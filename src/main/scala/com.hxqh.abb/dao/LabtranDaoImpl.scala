package com.hxqh.abb.dao

import com.hxqh.abb.common.basedao.DaoSupport
import com.hxqh.abb.model.version2.Labtran
import org.springframework.stereotype.Repository

/** * Created by Ocean lin	  */
@Repository("labtranDao") class LabtranDaoImpl extends DaoSupport[Labtran] with LabtranDao {}
