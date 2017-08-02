package com.hxqh.abb.service

import java.util

import com.hxqh.abb.model.Site

/**
  * Created by Ocean lin on 2017/8/2.
  */

trait StationService{

  @throws[Exception]
  def getSiteList(): util.List[Site]


}