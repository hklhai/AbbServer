package com.hxqh.abb.dao

import com.hxqh.abb.common.basedao.DaoSupport
import com.hxqh.abb.model.version2.Po
import org.springframework.stereotype.Repository

/** * Created by Ocean lin	  */
@Repository("poDao") class PoDaoImpl extends DaoSupport[Po] with PoDao {}
