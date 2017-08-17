package com.hxqh.abb.controller

import java.util

import com.hxqh.abb.model.dto.VehicleDto
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
@RequestMapping(Array("/xx")) class StationController @Autowired()
(private val stationService: StationService) {

  /**
    * List公用接口
    *
    * @return
    */
  @RequestMapping(value = Array("/list"), method = Array(RequestMethod.GET))
  def commonList(@RequestParam("apptname") apptname: String): ModelAndView = {
    val result = new util.HashMap[String, AnyRef]
    var titles = stationService.getAppInfo(apptname)
    result.put("titles", titles)
    result.put("urls", "/common/listData")
    new ModelAndView("commonFunc/commonlist")
  }

//  @throws[Exception]
//  def vehicleListData(page: Page, apptable: String, pkid: String, fields: String, searchs: String): List[_]


//  @ResponseBody
//  @RequestMapping(value = Array("/listData"), method = Array(RequestMethod.POST))
//    def vehicleListData(page: Page,
//                        @RequestParam("apptable") apptable: String,
//                        @RequestParam("pkid") pkid: String,
//                        @RequestParam("fields") fields: String,
//                        @RequestParam("searchs") searchs: String
//                       ): VehicleDto = {
////      stationService.vehicleListData(page,apptable,pkid,fields,searchs)
//    }



}
