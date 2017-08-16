package com.hxqh.abb.dao

import com.hxqh.abb.common.basedao.DaoSupport
import com.hxqh.abb.model.version2.Matrectran
import org.springframework.stereotype.Repository

/** * Created by Ocean lin	  */
@Repository("matrectranDao") class MatrectranDaoImpl extends DaoSupport[Matrectran] with MatrectranDao {}
