package com.hxqh.abb.controller

import java.util
import java.util.{HashMap, Map}

import com.hxqh.abb.model.searchdto.Page
import com.hxqh.abb.model.version2.Udvehicle
import com.hxqh.abb.service.StationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation._
import org.springframework.web.servlet.ModelAndView

/**
  * Created by Ocean lin on 2017/8/14.
  */
@ResponseBody
@ComponentScan
@RestController
@RequestMapping(Array("/common")) class StationController @Autowired()
(private val stationService: StationService) {

  /**
    * 车辆台账  页面跳转接口
    *
    * @return
    */
  @RequestMapping(value = Array("/list"), method = Array(RequestMethod.GET))
  def vehicleList(@RequestParam("func") func: String): ModelAndView = {
    val result = new util.HashMap[String, AnyRef]
    var titles= stationService.getAppInfo()
    result.put("titles", titles)
    result.put("urls", "/common/list")
    new ModelAndView("commonFunc/commonlist")
  }

  /**
    * 车辆台账  数据接口
    *
    * @return
    */
  @ResponseBody
  @RequestMapping(value = Array("/vehicleListData"), method = Array(RequestMethod.GET))
  def vehicleListData(page: Page): util.List[Udvehicle] = {
    stationService.vehicleListData(page)
  }


}
