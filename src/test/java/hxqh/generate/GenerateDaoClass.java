package hxqh.generate;

import com.hxqh.abb.common.util.FileUtils;

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

	public static void main(String[] args) throws IOException {
		File mboFile = new File("src/test/resources/dao.property");
		File daoImpl = new File("src/test/resources/daoImpl.property");

		//生成Mbo实体
		File file = new File("src/test/resources/table.list");
		String s = FileUtils.txt2String(file).trim();
		//        System.out.println(s);
		String[] mBOName = s.split("\r\n");


		for (String string : mBOName) {
			String mboStr = FileUtils.txt2String(mboFile).replaceAll("XXXXX", string+"Dao").replaceAll("YYYYY",string);
			FileUtils.writeStringToFile("src/"+string+"Dao"+".java",mboStr);

			//daoImpl
			StringBuilder sb = new StringBuilder(string);
			sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
			String daoImplStr = FileUtils.txt2String(daoImpl).replaceAll("XXXX", string+"Dao").replaceAll("YYYY",string)
					.replaceAll("ZZZZ",string+"DaoImpl").replaceAll("WWWW",sb.toString()+ "Dao");
			FileUtils.writeStringToFile("src/"+string+"DaoImpl"+".java",daoImplStr);
		}
		System.out.println("Generate Success!");
	}


}
