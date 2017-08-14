package com.hxqh.abb.dao

import com.hxqh.abb.common.basedao.DaoSupport
import com.hxqh.abb.model.version2.Invuseline
import org.springframework.stereotype.Repository

/** * Created by Ocean lin	  */
@Repository("invuselineDao") class InvuselineDaoImpl extends DaoSupport[Invuseline] with InvuselineDao {}
