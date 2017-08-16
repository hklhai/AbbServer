package com.hxqh.abb.dao

import com.hxqh.abb.common.basedao.DaoSupport
import com.hxqh.abb.model.version2.Udbed
import org.springframework.stereotype.Repository

/** * Created by Ocean lin	  */
@Repository("udbedDao") class UdbedDaoImpl extends DaoSupport[Udbed] with UdbedDao {}
