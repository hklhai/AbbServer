package com.hxqh.abb.dao

import com.hxqh.abb.common.basedao.DaoSupport
import com.hxqh.abb.model.version2.Poline
import org.springframework.stereotype.Repository

/** * Created by Ocean lin	  */
@Repository("polineDao") class PolineDaoImpl extends DaoSupport[Poline] with PolineDao {}
