package com.hxqh.abb.dao

import com.hxqh.abb.common.basedao.DaoSupport
import com.hxqh.abb.model.version2.Failurereport
import org.springframework.stereotype.Repository

/** * Created by Ocean lin	  */
@Repository("failurereportDao") class FailurereportDaoImpl extends DaoSupport[Failurereport] with FailurereportDao {}
