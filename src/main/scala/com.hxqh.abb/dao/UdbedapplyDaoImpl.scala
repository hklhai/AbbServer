package com.hxqh.abb.dao

import com.hxqh.abb.common.basedao.DaoSupport
import com.hxqh.abb.model.version2.Udbedapply
import org.springframework.stereotype.Repository

/** * Created by Ocean lin	  */
@Repository("udbedapplyDao") class UdbedapplyDaoImpl extends DaoSupport[Udbedapply] with UdbedapplyDao {}
