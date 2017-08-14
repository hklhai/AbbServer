package com.hxqh.abb.dao

import com.hxqh.abb.common.basedao.DaoSupport
import com.hxqh.abb.model.version2.Invuse
import org.springframework.stereotype.Repository

/** * Created by Ocean lin	  */
@Repository("invuseDao") class InvuseDaoImpl extends DaoSupport[Invuse] with InvuseDao {}
