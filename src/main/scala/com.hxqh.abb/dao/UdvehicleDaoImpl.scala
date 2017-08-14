package com.hxqh.abb.dao

import com.hxqh.abb.common.basedao.DaoSupport
import com.hxqh.abb.model.version2.Udvehicle
import org.springframework.stereotype.Repository

/** * Created by Ocean lin	  */
@Repository("udvehicleDao") class UdvehicleDaoImpl extends DaoSupport[Udvehicle] with UdvehicleDao {}
