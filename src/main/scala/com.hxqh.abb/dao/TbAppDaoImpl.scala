package com.hxqh.abb.dao

import com.hxqh.abb.common.basedao.DaoSupport
import com.hxqh.abb.model.TbApp
import org.springframework.stereotype.Repository

/** * Created by Ocean lin	  */
@Repository("tbAppDao") class TbAppDaoImpl extends DaoSupport[TbApp] with TbAppDao {}
