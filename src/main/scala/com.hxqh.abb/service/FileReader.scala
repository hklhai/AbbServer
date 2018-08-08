package com.hxqh.abb.service

import com.hxqh.abb.model.Menu

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

/**
  * Created by Ocean lin on 2017/12/7.
  */
object FileReader {

  def main(args: Array[String]): Unit = {

    val path = Thread.currentThread().getContextClassLoader.getResource("privilege.txt").getPath
    val source = Source.fromFile(path, "UTF-8")
    val lines = source.getLines()

    val applistList = ArrayBuffer[Menu]()
    var modelMap = Map[String, ArrayBuffer[Menu]]()
    for (line <- lines) {
      val l = line.split("\t")
      val menu = new Menu(l(1).trim, l(2).trim, l(3).trim, l(4).trim)
      applistList += menu
    }
    applistList.foreach(e => {
      val mName = e.modelname
      modelMap.get(mName) match {
        case Some(modelname) =>
          modelMap += (mName -> modelname.:+(e))
        case None =>
          modelMap += (mName -> ArrayBuffer(e))
      }
    })
  }
}
