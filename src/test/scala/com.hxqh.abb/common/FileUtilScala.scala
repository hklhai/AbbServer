package com.hxqh.abb.common

import java.io._

import scala.io.Source


/**
  * Created by Ocean Lin on 2017/6/8.
  */
object FileUtilScala {
    /*
      * 往文件里写入字符串
      */
  def WriteStringToFile(filePath: String, context: String): Unit = {
    try {
      val file = new File(filePath)
      val ps = new PrintStream(new FileOutputStream(file))
      ps.println(context) // 往文件里写入字符串

    } catch {
      case e: FileNotFoundException =>
        e.printStackTrace()
    }
  }

  /**
    * 读取txt文件的内容
    *
    * @param f
    * 想要读取的文件对象
    * @return 返回文件内容
    */
  def txt2String(f: String): String = {
    //    try {
    //      val br = new BufferedReader(new FileReader(file))
    //      // 构造一个BufferedReader类来读取文件
    //      var s = null
    //      while ((s = br.readLine()) != null) { // 使用readLine方法，一次读一行
    //        result.append(System.lineSeparator + s)
    //      }
    //      br.close()
    //    } catch {
    //      case e: Exception =>
    //        e.printStackTrace()
    //    }
    val result = new StringBuilder

    val file=Source.fromFile(f)
    for(line <- file.getLines)
    {
      result.append("\t").append(line)
    }
    file.close

    result.toString
  }
}