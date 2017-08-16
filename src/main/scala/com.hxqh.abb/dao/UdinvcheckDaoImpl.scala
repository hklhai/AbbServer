package com.hxqh.abb.dao

import com.hxqh.abb.common.basedao.DaoSupport
import com.hxqh.abb.model.version2.Udinvcheck
import org.springframework.stereotype.Repository

/** * Created by Ocean lin	  */
@Repository("udinvcheckDao") class UdinvcheckDaoImpl extends DaoSupport[Udinvcheck] with UdinvcheckDao {}
