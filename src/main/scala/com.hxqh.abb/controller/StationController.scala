package com.hxqh.abb.controller
import java.util

import com.hxqh.abb.model.Site
import com.hxqh.abb.service.StationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, ResponseBody, RestController}

/**
  * Created by Ocean lin on 2017/8/2.
  */
@ResponseBody
@ComponentScan
@RestController
@RequestMapping(Array("/station")) class StationController @Autowired()(private val stationService: StationService) {

  //  @Autowired private val stationService:StationService = null

  /**
    * 数据接口
    *
    * @return
    */

  @RequestMapping(value = Array("/sitedata"), method = Array(RequestMethod.GET)) def sitedata(): util.List[Site] = {
    var listData = null
    stationService.getSiteList()
  }

}
