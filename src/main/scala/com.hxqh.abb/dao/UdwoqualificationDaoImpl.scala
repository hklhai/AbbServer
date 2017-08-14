package com.hxqh.abb.dao

import com.hxqh.abb.common.basedao.DaoSupport
import com.hxqh.abb.model.version2.Udwoqualification
import org.springframework.stereotype.Repository

/** * Created by Ocean lin	  */
@Repository("udwoqualificationDao") class UdwoqualificationDaoImpl extends DaoSupport[Udwoqualification] with UdwoqualificationDao {}
