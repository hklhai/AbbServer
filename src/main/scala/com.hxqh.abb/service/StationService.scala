package com.hxqh.abb.service

import java.util

import com.hxqh.abb.model.TbApp
import com.hxqh.abb.model.searchdto.Page
import com.hxqh.abb.model.version2.Udvehicle

/**
  * Created by Ocean lin on 2017/8/2.
  */

trait StationService {

  def getAppInfo(): util.List[TbApp]

  def vehicleListData(page: Page): util.List[Udvehicle]


}