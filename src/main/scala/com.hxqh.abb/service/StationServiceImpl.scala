package com.hxqh.abb.service

import com.hxqh.abb.dao.{TbAppDao, UdvehicleDao}
import com.hxqh.abb.model.searchdto.Page
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
  @Autowired private val tbAppDao: TbAppDao = null

  override def vehicleListData(page: Page) = {
    //    val udtoolList: util.List[AbbUdtool] = udtoolDao.findAll(0, 15, null, null, " order by udtoolid desc")
    //    val siteList: util.List[AbbInventorySite] = siteDao.findAll
    //    val statusList: util.List[String] = util.Arrays.asList(Array[String]("完好", "维修"))
    //    page.setTotalPageNum(udtoolDao.getCount.toInt)
    //    val toolDto: ToolDto = new ToolDto(udtoolList, siteList, statusList, page)
    //    return toolDto

    udvehicleDao.findAll()
  }

  override def getAppInfo() = {
    tbAppDao.findAll()
  }
}
