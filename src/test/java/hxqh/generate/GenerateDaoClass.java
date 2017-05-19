package hxqh.generate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 生成字段类
 * @author lh
 *
 */
public class GenerateDaoClass {

	private static String[] MBOName = {"AbbAssetLocation","AbbAsset"};
	

	public static void main(String[] args) throws IOException {
		File mboFile = new File("D:\\myProject\\AbbServer\\AbbServer\\src\\test\\resources\\dao.property");
		File daoImpl = new File("D:\\myProject\\AbbServer\\AbbServer\\src\\test\\resources\\daoImpl.property");


		for (String string : MBOName) {
			String mboStr = txt2String(mboFile).replaceAll("XXXXX", string+"Dao").replaceAll("YYYYY",string);
			WriteStringToFile("src/"+string+"Dao"+".java",mboStr);


			//daoImpl
			StringBuilder sb = new StringBuilder(string);
			sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
			String daoImplStr = txt2String(daoImpl).replaceAll("XXXX", string+"Dao").replaceAll("YYYY",string)
					.replaceAll("ZZZZ",string+"DaoImpl").replaceAll("WWWW",sb.toString()+ "Dao");
			WriteStringToFile("src/"+string+"DaoImpl"+".java",daoImplStr);
		}
		
		System.out.println("Generate Success!");
	}

	/*
	 * 往文件里写入字符串
	 */
	public static void WriteStringToFile(String filePath,String context) {
		try {
			File file = new File(filePath);
			PrintStream ps = new PrintStream(new FileOutputStream(file));
			ps.println(context);// 往文件里写入字符串
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取txt文件的内容
	 * 
	 * @param file
	 *            想要读取的文件对象
	 * @return 返回文件内容
	 */
	public static String txt2String(File file) {
		StringBuilder result = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
			String s = null;
			while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
				result.append(System.lineSeparator() + s);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

}
