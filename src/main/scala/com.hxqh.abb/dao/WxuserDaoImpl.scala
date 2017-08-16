package com.hxqh.abb.dao

import com.hxqh.abb.common.basedao.DaoSupport
import com.hxqh.abb.model.version2.Wxuser
import org.springframework.stereotype.Repository

/** * Created by Ocean lin	  */
@Repository("wxuserDao") class WxuserDaoImpl extends DaoSupport[Wxuser] with WxuserDao {}
