package com.hxqh.abb.test

import javax.annotation.Resource

import com.hxqh.abb.service.StationService
import junit.framework.Test
import org.junit.Assert
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
  * Created by Ocean lin on 2017/8/2.
  */

//@ContextConfiguration(locations = Array("classpath:spring/applicationContext.xml"))
//@RunWith(classOf[SpringJUnit4ClassRunner])
class SiteTest {
  @Resource private val stationService: StationService = null

//  @Test def bootstrap(): Unit = {
////    Assert.assertTrue(stationService.getSiteList().size() > 0)
//  }

//  @Test def testSave(): Unit = {
//    val udvehicle:Udvehicle = new Udvehicle()
//    udvehicle.setDepartment("ssss")
//    udvehicle.setHasld(0)
//    udvehicle.setRowstamp(22223l)
//    stationService.saveUdvehicle(udvehicle)
//  }
//
//  @Test def testUpdate(): Unit = {
//    val udvehicle:Udvehicle = new Udvehicle()
//    udvehicle.setDepartment("XXXXX")
//    udvehicle.setHasld(0)
//    udvehicle.setRowstamp(22223l)
//    udvehicle.setUdvehicleid(209)
//    stationService.updateUdvehicle(udvehicle)
//  }
//
//  @Test def testDel(): Unit = {
//    stationService.delUdvehicle(209l)
//  }

}