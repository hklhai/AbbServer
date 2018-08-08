package com.hxqh.abb.dao

import com.hxqh.abb.common.basedao.DaoSupport
import com.hxqh.abb.model.view.Woactivity
import org.springframework.stereotype.Repository

/** * Created by Ocean lin	  */
@Repository("woactivityDao") class WoactivityDaoImpl extends DaoSupport[Woactivity] with WoactivityDao {}
