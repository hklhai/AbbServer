package com.hxqh.abb.common.util;

//import com.hxqh.test.DBUtil;

import psdi.util.MXCipherX;
import psdi.util.MXException;
import psdi.util.MXSession;

public class MXCipherXUtils {
    private static MXCipherX mxcipherx;
    private static MXCipherXUtils instance = new MXCipherXUtils();

    public static MXCipherXUtils getInstance() {
        return instance;
    }

    private MXCipherXUtils() {
        try {
            mxcipherx = new MXCipherX(null, null, null, null, null);
        } catch (MXException e) {
            e.printStackTrace();
        }
    }

    public static void setInstance(MXCipherXUtils instance) {
        instance = instance;
    }

    public static MXCipherX getMxcipherx() {
        return mxcipherx;
    }

    public static void setMxcipherx(MXCipherX mxcipherx) {
        mxcipherx = mxcipherx;
    }

    public static String encodePwd(String password)
            throws MXException {
        String encryptedPassword = "";
        byte[] bytes = mxcipherx.encData(password);
        for (int i = 0; i < bytes.length; i++) {
            int b = bytes[i];
            String hex = Integer.toHexString(b).toUpperCase();
            hex = hex.replaceAll("FFFFFF", "");
            hex = hex.length() < 2 ? "0" + hex : hex;
            encryptedPassword = encryptedPassword + hex;
        }
        return encryptedPassword;
    }

    public static String encodePwdV2(String password) throws Exception {
        String encryptedPassword = "x'";
        byte[] bytes = mxcipherx.encData(password);
        for (int i = 0; i < bytes.length; i++) {
            int b = bytes[i];
            String hex = Integer.toHexString(b).toUpperCase();
            hex = hex.replaceAll("FFFFFF", "");
            hex = (hex.length() < 2) ? "0" + hex : hex;
            encryptedPassword += hex;
        }
        encryptedPassword +="'";
        return encryptedPassword;
    }


//  public static String encrypt(String password) throws Exception {
//      String encryptedPassword = "0x";
//      byte[] bytes = getMXCipherX().encData(password);
//      for (int i = 0; i < bytes.length; i++) {
//          int b = bytes[i];
//          String hex = Integer.toHexString(b).toUpperCase();
//          hex = hex.replaceAll("FFFFFF", "");
//          hex = (hex.length() < 2) ? "0" + hex : hex;
//          encryptedPassword += hex;
//      }
//      return encryptedPassword;
//  }
//
//  public static MXCipherX getMXCipherX() throws Exception {
//      /*MXSession mxSession = MXSession.getSession();
//      mxSession.setHost(SERVER);
//      mxSession.setUserName(SUPER_USERNAME);
//      mxSession.setPassword(SUPER_PASSWORD); */
//  	 DBUtil db = new DBUtil();
//   	MXSession session = db.getMXSession();
//
//      session.connect();
//      MXCipherX mxCipherX = new MXCipherX(session.getMXServerRemote());
//      session.disconnect();
//      return mxCipherX;
//  }
//
//
//    public static void main(String[] args) throws Exception {
//
//        String password = "86020933";
//        try {
//            String pwd = MXCipherXUtils.encodePwd(password);
//            System.out.println(pwd);
//        } catch (MXException e) {
//            e.printStackTrace();
//        }
//    }
}