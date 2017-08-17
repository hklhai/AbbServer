package com.hxqh.abb.service

import java.util

import com.hxqh.abb.model.TbApp

/**
  * Created by Ocean lin on 2017/8/2.
  */

trait StationService {

  def getAppInfo(apptable: String): util.List[TbApp]

//  def vehicleListData(page: Page,
//                      apptable: String,
//                      pkid: String,
//                      fields: String,
//                      searchs: String): VehicleDto


}