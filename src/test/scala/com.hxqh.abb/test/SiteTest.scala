package com.hxqh.abb.test

import javax.annotation.Resource

import com.hxqh.abb.service.StationService
import org.junit.runner.RunWith
import org.junit.{Assert, Test}
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
  * Created by Ocean lin on 2017/8/2.
  */

@ContextConfiguration(locations = Array("classpath:spring/applicationContext.xml"))
@RunWith(classOf[SpringJUnit4ClassRunner])
class SiteTest {
  @Resource private val stationService: StationService = null

  @Test def bootstrap(): Unit = {
    Assert.assertTrue(stationService.getSiteList().size() > 0)
  }

}