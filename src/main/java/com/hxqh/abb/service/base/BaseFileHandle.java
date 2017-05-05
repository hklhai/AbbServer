package com.hxqh.abb.service.base;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: LuckyStar
 * Date: 2010-9-6
 * Time: 18:36:31
 * To change this template use File | Settings | File Templates.
 */

@Service
@Transactional
public class BaseFileHandle {



    private String infDocument;
    //@Value("${isrc.information.infDocument}")
    public void setInfDocument(String infDocument) {
        this.infDocument = infDocument;
    }

    /**
     * 文件的写入
     * @param filePath
     * @param fileName
     * @param args
     * @throws IOException
     */
    public void writeFile(String filePath,String fileName,String[] args)   throws IOException
    {
        FileWriter fw=new FileWriter(filePath + fileName);
        PrintWriter out = new PrintWriter(fw);
        for(int i=0;i<args.length;i++) {
            out.write(args[i]);
            out.println();
            out.flush();
        }
        fw.close();
        out.close();

    }

    /**
     * 文件的写入
     * @param filePath
     * @param fileName
     * @param args
     * @throws IOException
     */
    public void writeFile(String filePath, String fileName, String args)
            throws IOException {
        FileWriter fw = new FileWriter(filePath+"/" + fileName);
        fw.write(args);
        fw.close();
    }

    /**
     * 文件的创建和删除
     * @param filePath
     * @param fileName
     * @return
     * @throws IOException
     */
    public boolean createAndDeleteFile(String filePath, String fileName)
            throws IOException {
        boolean result = false;
        File file = new File(filePath, fileName);
        if (file.exists()) {
            file.delete();
            result = false;
            System.out.println("文件已经删除！");
        }
        else{
            file.createNewFile();
            result = true;
            System.out.println("文件已经创建！");
        }
        return result;
    }

    /*
     * 目录的创建
     * @param folderName
     * @param folderPath
     * @return
     * @throws java.io.IOException
     */
    public void createFolder(String folderPath, String folderName)
            throws IOException{
        File file = new File(folderPath +"/"+ folderName);
        if (file.exists()) {
            System.out.println("目录已经存在!");
        } else {
            file.mkdir();
            System.out.println("目录不存在，已经建立!");
        }
    }

    /**
     * 目录的创建和删除
     * @param folderName
     * @param folderPath
     * @return
     * @throws IOException
     */
    public boolean createAndDeleteFolder(String folderPath, String folderName)
            throws IOException{
        boolean result = false;
        File file = new File(folderPath +"/"+ folderName);
        if (file.exists()) {
            file.delete();
            System.out.println("目录已经存在，已删除!");
            result = false;
        } else {
            file.mkdir();
            System.out.println("目录不存在，已经建立!");
            result = true;
        }
        return result;
    }

    /**
     * 读取文件中的所有内容
     * @param filePath
     * @param fileName
     * @throws IOException
     */
    public void readAllFile(String filePath, String fileName)
            throws IOException {
        FileReader fr = new FileReader(filePath+"/" + fileName);
        int count = fr.read();
        while (count != -1) {
            System.out.print((char) count);
            count = fr.read();
            if (count == 13) {
                fr.skip(1);
            }
        }
        fr.close();
    }
    public String readFile(String filePath, String fileName)
            throws IOException {
    	String path = filePath+"/" + fileName;
//        FileReader fr = new FileReader(filePath+"/" + fileName);
        BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(path),"GBK")); 
//        BufferedReader reader = new BufferedReader(fr);
        StringBuffer strb = new StringBuffer();
        String temp=null;
        while((temp=reader.readLine())!=null)
        {
            strb.append(temp);
            strb.append("\n"); //由于readLine会消除换行符，这里需要手工加入
        }
        String content = strb.toString();
        return content;
    }
    /**
     * 文件是否存在
     * @param filePath
     * @return
     * @throws IOException
     */
    public boolean isFileExists(String filePath, String folderName) throws IOException{

        File f = new File(filePath+"/" + folderName);

        if (f.exists()) {// 检查File.txt是否存在
            return true;
        } else {
            return false;
        }
    }

    /**
     * 写入FCK
     * @param filename
     * @param content
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void writeFCK(String filename,String content){
        try{
            //取项目的相对路径
            String filepath = this.getClass().getResource("/").toURI().getPath();
            int lastNum = filepath.lastIndexOf("/WEB-INF/");
            filepath = filepath.substring(0, lastNum);
            createFolder(filepath,infDocument);
            boolean filecreate=false;
            filepath=filepath+"/"+infDocument;
            filecreate=createAndDeleteFile(filepath,filename);
            if(!filecreate)
                filecreate=createAndDeleteFile(filepath,filename);
            writeFile(filepath,filename,content);

        }
        catch (Exception ex) {
            System.out.println("writeFCK is error:" + ex);
        }
    }

    /**
     * 读入FCk
     * @param filename
     * @return
     * @throws Exception 
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public String readFCK(String filename) throws Exception
    {
        String content=null;
        Properties prop = new Properties();  
        String filepath = "";
		try {   
			InputStream in = BaseFileHandle.class.getResourceAsStream("../../../../../config.properties");
            prop.load(in);   
            filepath = prop.getProperty("cn.edu.ncut.istc.infodownloadpath").trim();   
            boolean isFileExist=isFileExists(filepath,filename);
            if(isFileExist)
                content=readFile(filepath,filename);
        } catch (IOException e) { 
        	System.out.println("readFCK is error:" + e);
            e.printStackTrace();   
        }
        return content;
    }

    public boolean deleteFCK(String filename)
    {
        boolean result=false;
        try{
            String filepath = this.getClass().getResource("/").toURI().getPath();
            int lastNum = filepath.lastIndexOf("/WEB-INF/");
            filepath = filepath.substring(0, lastNum);
            File file = new File(filepath, filename);
            if (file.exists()) {
                file.delete();
                result = true;
                System.out.println("文件已经删除！");
            }
            else{
                result = false;
            }
        }
        catch (Exception ex) {
            result=false;
            System.out.println("deleteFCK is error:" + ex);
        }
        return result;
    }

    public String getDymaticPath(){
        try{
            String filepath = this.getClass().getResource("/").toURI().getPath();
            int lastNum = filepath.lastIndexOf("/WEB-INF/");
            filepath = filepath.substring(0, lastNum);
            return filepath;
        }
        catch (Exception ex) {
            System.out.println("getDymaticPath error:" + ex);
            return null;
        }
    }
}