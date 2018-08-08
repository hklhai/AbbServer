package com.hxqh.abb.service

import java.util
import javax.annotation.PostConstruct

import com.hxqh.abb.dao.TbAppDao
import com.hxqh.abb.model.Menu
import com.hxqh.abb.model.dto.AppDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

/**
  * Created by Ocean lin on 2017/8/2.
  */


@Transactional
@Service("stationService") class StationServiceImpl extends StationService {

  val appRelativeList = ArrayBuffer[Menu]()
  @Autowired private val tbAppDao: TbAppDao = null

  override def getAppInfo(apptable: String) = {
    //    val orderby = new util.LinkedHashMap[String, String]
    //    orderby.put("slaId", "asc")

    val params = new util.HashMap[String, AnyRef]
    params.put("APPNAME", apptable)
    params.put("APPCONTENT", "LIST")
    val where = "APPNAME=:APPNAME and  APPCONTENT=:APPCONTENT"
    tbAppDao.findAll(where, params, null)
  }

  @PostConstruct
  def init(): Unit = {
    val path = Thread.currentThread().getContextClassLoader.getResource("privilege.txt").getPath
    val source = Source.fromFile(path, "UTF-8")
    val lines = source.getLines()

    for (line <- lines) {
      val l = line.split("\t")
      val menu = new Menu(l(1).trim, l(2).trim, l(3).trim, l(4).trim)
      appRelativeList += menu
    }

  }


  override def getMenuMap(appList: java.util.List[AppDto]): java.util.Map[String, java.util.List[Menu]] = {
    // appRelativeList与appList取交集
    val apps = ArrayBuffer[Menu]()

    import scala.collection.JavaConversions.asScalaBuffer
    val appListBuffer = appList.toBuffer
    for (e <- appRelativeList) {
      for (x <- appListBuffer) {
        if (e.appname.equals(x.getAppid)) {
          apps += e
        }
      }
    }

    var modelMap = Map[String, ArrayBuffer[Menu]]()
    apps.foreach(e => {
      val mName = e.modelname
      modelMap.get(mName) match {
        case Some(modelname) =>
          modelMap += (mName -> modelname.:+(e))
        case None =>
          modelMap += (mName -> ArrayBuffer(e))
      }
    })
    // 转换成Java
    val modelJavaMap = new java.util.HashMap[String, java.util.List[Menu]]
    import scala.collection.JavaConverters._
    for ((x, y) <- modelMap) {
      modelJavaMap.put(x, y.asJava)
    }
    modelJavaMap
  }
}
