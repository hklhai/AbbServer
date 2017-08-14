package com.hxqh.abb.service

import com.hxqh.abb.dao.UdvehicleDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
  * Created by Ocean lin on 2017/8/2.
  */


@Transactional
@Service("stationService") class StationServiceImpl extends StationService {
  //  @Autowired private val siteDao: SiteDao = null
  @Autowired private val udvehicleDao: UdvehicleDao = null

  override def vehicleListData = {
    udvehicleDao.findAll()
  }

}
