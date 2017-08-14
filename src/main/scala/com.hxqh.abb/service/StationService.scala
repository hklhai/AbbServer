package com.hxqh.abb.service

import java.util

import com.hxqh.abb.model.version2.Udvehicle

/**
  * Created by Ocean lin on 2017/8/2.
  */

trait StationService{

  def vehicleListData:util.List[Udvehicle]
}