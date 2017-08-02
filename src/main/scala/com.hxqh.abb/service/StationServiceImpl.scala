package com.hxqh.abb.service

import java.util

import com.hxqh.abb.dao.SiteDao
import com.hxqh.abb.model.Site
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
  * Created by Ocean lin on 2017/8/2.
  */


@Transactional
@Service("stationService") class StationServiceImpl extends StationService {
  @Autowired private val  siteDao:SiteDao = null

  override def getSiteList: util.List[Site] = siteDao.findAll
}
