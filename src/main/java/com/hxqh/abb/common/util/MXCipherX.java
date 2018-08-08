package com.hxqh.abb.common.util;

/**
 * Created by fuyg on 2017-12-07.
 */

import java.lang.reflect.Constructor;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MXCipherX {
    String algorithm = "DESede";
    String mode = "CBC";
    String padding = "PKCS5Padding";
    String key = "Sa#qk5usfmMI-@2dbZP9`jL3";
    String spec = "beLd7$lB";
    String modulus = "";
    private Cipher cipherEncrypt = null;
    String transformation = null;
    SecretKey secretKey = null;
    IvParameterSpec ivSpec = null;
    PBEParameterSpec pbeParamSpec = null;
    SecretKeySpec secretkeySpec = null;
    PublicKey publicKey = null;
    PrivateKey privateKey = null;
    boolean nonSunProviders = false;
    Provider providerClass = null;
    int padLen = 8;

    protected MXCipherX() {
    }

    public MXCipherX(String algTest, String modeTest, String paddingTest, String keyTest, String specTest) throws Exception {
        this.init(algTest, modeTest, paddingTest, keyTest, specTest, (String)null, (String)null);
    }

    public MXCipherX(String algTest, String modeTest, String paddingTest, String keyTest, String specTest, String modTest, String providerTest) throws Exception {
        this.init(algTest, modeTest, paddingTest, keyTest, specTest, modTest, providerTest);
    }

    protected void init(String algTest, String modeTest, String paddingTest, String keyTest, String specTest, String modTest, String providerTest) throws Exception {

        if(providerTest != null && !providerTest.equals("")) {
            Class c = Class.forName(providerTest);
            Class[] paramTypes = new Class[0];
            Constructor ctor = c.getConstructor(paramTypes);
            Object[] params = new Object[0];
            this.providerClass = (Provider)ctor.newInstance(params);
            Security.addProvider(this.providerClass);
        }


        Provider[] provs = Security.getProviders();

        for(int xx = 0; xx < provs.length; ++xx) {
            if(!provs[xx].getName().toUpperCase().startsWith("SUN")) {
                ;
            }

            this.nonSunProviders = true;
        }

        this.validateParams(algTest, modeTest, paddingTest, keyTest, specTest, modTest);
        this.transformation = this.algorithm;
        if(this.mode != null && !this.mode.equals("") && this.padding != null && !this.padding.equals("")) {
            this.transformation = this.transformation + "/" + this.mode + "/" + this.padding;
        }


        this.cipherEncrypt = this.buildCipher(true);

    }

    Cipher buildCipher(boolean encrypt) throws Exception {
        Cipher cipher = null;
        int cryptMode = encrypt?1:2;
        SecretKeyFactory keyFac;
        if(!this.algorithm.equals("DESede") && !this.algorithm.equals("TripleDES")) {
            if(this.algorithm.equals("DES")) {
                if(this.secretKey == null || this.ivSpec == null) {
                    DESKeySpec keyspec = new DESKeySpec(this.key.getBytes());
                    keyFac = SecretKeyFactory.getInstance(this.algorithm);
                    this.secretKey = keyFac.generateSecret(keyspec);
                    this.ivSpec = new IvParameterSpec(this.spec.getBytes());
                }

                if(this.providerClass == null) {
                    cipher = Cipher.getInstance(this.transformation);
                } else {
                    cipher = Cipher.getInstance(this.transformation, this.providerClass);
                }

                if(this.transformation.indexOf("ECB") < 0) {
                    cipher.init(cryptMode, this.secretKey, this.ivSpec);
                } else {
                    cipher.init(cryptMode, this.secretKey);
                }
            } else if(this.algorithm.startsWith("PBEWith")) {
                if(this.secretKey == null || this.pbeParamSpec == null) {
                    this.pbeParamSpec = new PBEParameterSpec(this.spec.getBytes(), 20);
                    PBEKeySpec pbeKeySpec = new PBEKeySpec(this.spec.toCharArray());
                    keyFac = SecretKeyFactory.getInstance(this.algorithm);
                    this.secretKey = keyFac.generateSecret(pbeKeySpec);
                }

                if(this.providerClass == null) {
                    cipher = Cipher.getInstance(this.transformation);
                } else {
                    cipher = Cipher.getInstance(this.transformation, this.providerClass);
                }

                cipher.init(cryptMode, this.secretKey, this.pbeParamSpec);
            } else if(this.algorithm.equals("RSA")) {
                if(this.publicKey == null || this.privateKey == null) {
                    KeyFactory fac = KeyFactory.getInstance("RSA", this.providerClass);
                    this.publicKey = fac.generatePublic(new RSAPublicKeySpec(new BigInteger(this.modulus), new BigInteger(this.key)));
                    this.privateKey = fac.generatePrivate(new RSAPrivateKeySpec(new BigInteger(this.modulus), new BigInteger(this.spec)));
                }

                if(this.providerClass == null) {
                    cipher = Cipher.getInstance(this.transformation);
                } else {
                    cipher = Cipher.getInstance(this.transformation, this.providerClass);
                }

                if(encrypt) {
                    cipher.init(cryptMode, this.publicKey);
                } else {
                    cipher.init(cryptMode, this.privateKey);
                }
            } else {
                if(this.secretkeySpec == null) {
                    int padLen = this.algorithm.equals("SKIPJACK")?10:16;
                    byte[] byteArray = this.spec.getBytes();
                    byteArray = this.pad(byteArray, padLen);
                    this.secretkeySpec = new SecretKeySpec(byteArray, this.algorithm);
                }

                if(this.providerClass == null) {
                    cipher = Cipher.getInstance(this.transformation);
                } else {
                    cipher = Cipher.getInstance(this.transformation, this.providerClass);
                }

                cipher.init(cryptMode, this.secretkeySpec);
            }
        } else {
            if(this.secretKey == null || this.ivSpec == null) {
                DESedeKeySpec keyspec = new DESedeKeySpec(this.key.getBytes());
                keyFac = SecretKeyFactory.getInstance(this.algorithm);
                this.secretKey = keyFac.generateSecret(keyspec);
                this.ivSpec = new IvParameterSpec(this.spec.getBytes());
            }

            if(this.providerClass == null) {
                cipher = Cipher.getInstance(this.transformation);
            } else {
                cipher = Cipher.getInstance(this.transformation, this.providerClass);
            }

            if(this.transformation.indexOf("ECB") < 0) {
                cipher.init(cryptMode, this.secretKey, this.ivSpec);
            } else {
                cipher.init(cryptMode, this.secretKey);
            }
        }
        return cipher;
    }

    private void validateParams(String algTest, String modeTest, String paddingTest, String keyTest, String specTest, String modTest) throws Exception {
        if(algTest != null && !algTest.equals("")) {
            this.algorithm = algTest;
        }

        if(modeTest != null && !modeTest.equals("")) {
            this.mode = modeTest;
        }

        if(paddingTest != null && !paddingTest.equals("")) {
            this.padding = paddingTest;
        }

        if(keyTest != null && !keyTest.equals("")) {
            this.key = keyTest;
        }

        if(specTest != null && !specTest.equals("")) {
            this.spec = specTest;
        }

        if(modTest != null && !modTest.equals("")) {
            this.modulus = modTest;
        }

        if(this.algorithm == null) {
            throw new Exception("mxe.security.algorithm");
        } else {
            if(!this.algorithm.equals("AES") && !this.algorithm.equals("Serpent") && !this.algorithm.equals("MARS") && !this.algorithm.equals("RC6") && !this.algorithm.equals("Rijndael") && !this.algorithm.equals("Square") && !this.algorithm.equals("Twofish")) {
                if(this.algorithm.equals("RSA")) {
                    this.padLen = 0;
                }
            } else {
                this.padLen = 16;
            }

            if(!this.algorithm.equals("DES") && !this.algorithm.equals("DESede") && !this.algorithm.equals("AES")) {
                if(modeTest == null || modeTest.equals("")) {
                    this.mode = "";
                }

                if(paddingTest == null || paddingTest.equals("")) {
                    this.padding = "";
                }
            }

            if(!this.nonSunProviders) {
                if(!this.algorithm.equals("DESede") && !this.algorithm.equals("DES") && !this.algorithm.equals("AES") && !this.algorithm.equals("PBEWithMD5AndDES")) {
                    throw new Exception("mxe.security.algorithm");
                } else if(!this.algorithm.equals("AES") || this.mode != null && this.mode.equals("ECB")) {
                    if(this.algorithm.equals("PBEWithMD5AndDES")) {
                        if(this.mode == null || !this.mode.equals("CBC")) {
                            throw new Exception("mxe.security.mode");
                        }

                        if(this.padding == null || !this.padding.equals("PKCS5Padding")) {
                            throw new Exception("mxe.security.padding");
                        }

                        if(this.key.getBytes().length != 8) {
                            throw new Exception("mxe.security.key");
                        }
                    }

                    if(this.mode != null && !this.mode.equals("") && !this.mode.equals("CBC") && !this.mode.equals("CFB") && !this.mode.equals("ECB") && !this.mode.equals("OFB") && !this.mode.equals("PCBC")) {
                        throw new Exception("mxe.security.mode");
                    } else if(this.padding != null && !this.padding.equals("") && !this.padding.equals("NoPadding") && !this.padding.equals("PKCS5Padding")) {
                        throw new Exception("mxe.security.padding");
                    } else if(this.key != null && !this.key.equals("") && !this.algorithm.equals("RSA") && this.key.length() % 24 != 0) {
                        throw new Exception("mxe.security.key");
                    } else if(this.spec != null && !this.spec.equals("") && !this.algorithm.equals("RSA") && this.spec.length() % 8 != 0) {
                        throw new Exception("mxe.security.spec");
                    } else if(this.mode != null && this.mode.equals("OFB") && this.padding != null && !this.padding.equals("NoPadding") && (this.algorithm == null || !this.algorithm.equals("DES"))) {
                        throw new Exception("mxe.security.padding");
                    }
                }
            }
        }
    }

    public synchronized byte[] encData(String in) throws Exception {
        byte[] temp = in.getBytes();
        temp = this.pad(temp);

        byte[] encryptVal = this.cipherEncrypt.doFinal(temp);
        return encryptVal;
    }

    protected byte[] pad(byte[] in) {
        return this.pad(in, this.padLen);
    }

    protected byte[] pad(byte[] in, int padLen) {
        if(padLen == 0) {
            return in;
        } else {
            int inlen = in.length;
            int outlen = inlen;
            int rem = inlen % padLen;
            if(rem > 0) {
                outlen = inlen + (padLen - rem);
            }

            byte[] out = new byte[outlen];

            for(int xx = 0; xx < inlen; ++xx) {
                out[xx] = in[xx];
            }
            return out;
        }
    }
}

