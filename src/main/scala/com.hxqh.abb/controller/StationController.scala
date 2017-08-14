package com.hxqh.abb.controller

import java.util

import com.hxqh.abb.model.version2.Udvehicle
import com.hxqh.abb.service.StationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, ResponseBody, RestController}
import org.springframework.web.servlet.ModelAndView

/**
  * Created by Ocean lin on 2017/8/14.
  */
@ResponseBody
@ComponentScan
@RestController
@RequestMapping(Array("/station")) class StationController @Autowired()
(private val stationService: StationService) {

  /**
    * 车辆台账  页面跳转接口
    *
    * @return
    */
  @RequestMapping(value = Array("/vehicleList"), method = Array(RequestMethod.GET))
  def vehicleList: ModelAndView = new ModelAndView("vehicle/vehicleList")

  /**
    * 车辆台账  数据接口
    *
    * @return
    */
  @ResponseBody
  @RequestMapping(value = Array("/vehicleListData"), method = Array(RequestMethod.GET))
  def vehicleListData: util.List[Udvehicle] = {
    stationService.vehicleListData
  }
}
