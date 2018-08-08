package com.hxqh.abb.service

import java.util

import com.hxqh.abb.model.dto.AppDto
import com.hxqh.abb.model.{Menu, TbApp}

/**
  * Created by Ocean lin on 2017/8/2.
  */

trait StationService {

  def getAppInfo(apptable: String): util.List[TbApp]

  def getMenuMap(appList: java.util.List[AppDto]): java.util.Map[String, util.List[Menu]]

}