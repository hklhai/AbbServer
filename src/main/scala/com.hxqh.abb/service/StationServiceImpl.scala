package com.hxqh.abb.service

import java.util
import javax.annotation.Resource

import com.hxqh.abb.dao.{TbAppDao, UdvehicleDao}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
  * Created by Ocean lin on 2017/8/2.
  */


@Transactional
@Service("stationService") class StationServiceImpl extends StationService {
  @Autowired private val udvehicleDao: UdvehicleDao = null
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

//  override def vehicleListData(page: Page,
//                               apptable: String,
//                               pkid: String,
//                               fields: String,
//                               searchs: String) = {
//
//    val x:VehicleDto
//    x
//  }
}
