package com.hxqh.abb.dao

import com.hxqh.abb.common.basedao.DaoSupport
import com.hxqh.abb.model.version2.Wftransaction
import org.springframework.stereotype.Repository

/** * Created by Ocean lin	  */
@Repository("wftransactionDao") class WftransactionDaoImpl extends DaoSupport[Wftransaction] with WftransactionDao {}
