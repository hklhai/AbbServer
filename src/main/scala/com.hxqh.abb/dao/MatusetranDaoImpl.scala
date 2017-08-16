package com.hxqh.abb.dao

import com.hxqh.abb.common.basedao.DaoSupport
import com.hxqh.abb.model.version2.Matusetran
import org.springframework.stereotype.Repository

/** * Created by Ocean lin	  */
@Repository("matusetranDao") class MatusetranDaoImpl extends DaoSupport[Matusetran] with MatusetranDao {}
