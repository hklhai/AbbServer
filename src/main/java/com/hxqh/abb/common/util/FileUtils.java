package com.hxqh.abb.common.util;

import java.io.*;

public class FileUtils
{
	/**
	 * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
	 */
	public static void readFileByBytes(String fileName)
	{
		File file = new File(fileName);
		InputStream in = null;
		try
		{
			System.out.println("以字节为单位读取文件内容，一次读一个字节：");
			// 一次读一个字节
			in = new FileInputStream(file);
			int tempbyte;
			while ((tempbyte = in.read()) != -1)
			{
				System.out.write(tempbyte);
			}
			in.close();
		} catch (IOException e)
		{
			e.printStackTrace();
			return;
		}
		try
		{
			System.out.println("以字节为单位读取文件内容，一次读多个字节：");
			// 一次读多个字节
			byte[] tempbytes = new byte[100];
			int byteread = 0;
			in = new FileInputStream(fileName);
			FileUtils.showAvailableBytes(in);
			// 读入多个字节到字节数组中，byteread为一次读入的字节数
			while ((byteread = in.read(tempbytes)) != -1)
			{
				System.out.write(tempbytes, 0, byteread);
			}
		} catch (Exception e1)
		{
			e1.printStackTrace();
		} finally
		{
			if (in != null)
			{
				try
				{
					in.close();
				} catch (IOException e1)
				{
				}
			}
		}
	}

	/**
	 * 以字符为单位读取文件，常用于读文本，数字等类型的文件
	 */
	public static String readFileByChars(String fileName,String coder)
	{
		File file = new File(fileName);
		Reader reader = null;
		String s = "";
		try
		{
			System.out.println("以字符为单位读取文件内容，一次读一个字节：");
			// 一次读一个字符
			reader = new InputStreamReader(new FileInputStream(file),coder);
			int tempchar;
			while ((tempchar = reader.read()) != -1)
			{
				s += (char) tempchar;
			}
			reader.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * 以行为单位读取文件，常用于读面向行的格式化文件
	 */
	public static String readFileByLines(String fileName)
	{
		File file = new File(fileName);
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		String temp;
		try
		{
			InputStreamReader in = new InputStreamReader(new FileInputStream(file), "UTF-8");
			reader = new BufferedReader(in);

			// 一次读入一行，直到读入null为文件结束
			while ((temp = reader.readLine()) != null)
			{
				sb.append(temp);
			}
			reader.close();
		} catch (IOException e)
		{
			System.out.println(e.getMessage());
		} finally
		{
			if (reader != null)
			{
				try
				{
					reader.close();
				} catch (IOException e1)
				{
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 随机读取文件内容
	 */
	public static void readFileByRandomAccess(String fileName)
	{
		RandomAccessFile randomFile = null;
		try
		{
			System.out.println("随机读取一段文件内容：");
			// 打开一个随机访问文件流，按只读方式
			randomFile = new RandomAccessFile(fileName, "r");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			// 读文件的起始位置
			int beginIndex = (fileLength > 4) ? 4 : 0;
			// 将读文件的开始位置移到beginIndex位置。
			randomFile.seek(beginIndex);
			byte[] bytes = new byte[10];
			int byteread = 0;
			// 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。
			// 将一次读取的字节数赋给byteread
			while ((byteread = randomFile.read(bytes)) != -1)
			{
				System.out.write(bytes, 0, byteread);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			if (randomFile != null)
			{
				try
				{
					randomFile.close();
				} catch (IOException e1)
				{
				}
			}
		}
	}

	/**
	 * 显示输入流中还剩的字节数
	 */
	private static void showAvailableBytes(InputStream in)
	{
		try
		{
			System.out.println("当前字节输入流中的字节数为:" + in.available());
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 写入文件
	 */
	public static void writeStrToFile(String str, String filename)
	{
		try
		{
			// FileOutputStream fos = new FileOutputStream(new
			// File("D:\\DwcrTmpFile\\" + filename),true);
			File file = new File(filename);
			//如果文件所在文件夹不存在 则 创建文件夹
			if (!file.getParentFile().exists())
				file.getParentFile().mkdirs();
			try
			{
				file.createNewFile();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			FileOutputStream fos = new FileOutputStream(file, true);
			Writer os = new OutputStreamWriter(fos, "UTF-8");
			os.write(str);
			os.flush();
			fos.close();
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writeStrToFileReward(String str, String filename)
	{
		try
		{
			// FileOutputStream fos = new FileOutputStream(new
			// File("D:\\DwcrTmpFile\\" + filename),true);
			File file = new File(filename);
			//如果文件所在文件夹不存在 则 创建文件夹
			if (!file.getParentFile().exists())
				file.getParentFile().mkdirs();
			try
			{
				file.createNewFile();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			FileOutputStream fos = new FileOutputStream(file, false);
			Writer os = new OutputStreamWriter(fos, "UTF-8");
			os.write(str);
			os.flush();
			fos.close();
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writeFileByByte(String path,byte[] contents)
	{
		try
		{
			FileOutputStream fio = new FileOutputStream(path);
			fio.write(contents);
			fio.flush();
			fio.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static boolean deleteFile(String filePath)
	{
		if(filePath != null && !"".equals(filePath))
		{
			try
			{
				File f = new File(filePath); // 输入要删除的文件位置
				if(f.exists())
					return f.delete();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public static byte[] readfile(String filePath) throws Exception
	{
		File file = new File(filePath);
		long fileSize = file.length();
		if (fileSize > Integer.MAX_VALUE) {
			System.out.println("file too big...");
			return null;
		}
		FileInputStream fi = new FileInputStream(file);
		byte[] buffer = new byte[(int) fileSize];
		int offset = 0;
		int numRead = 0;
		while (offset < buffer.length
				&& (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
			offset += numRead;
		}
		// 确保所有数据均被读取
		if (offset != buffer.length) {
			throw new IOException("Could not completely read file "
					+ file.getName());
		}
		fi.close();
		return buffer;
	}

	/*
	 * 往文件里写入字符串
	 */
	public static void writeStringToFile(String filePath,String context) {
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
