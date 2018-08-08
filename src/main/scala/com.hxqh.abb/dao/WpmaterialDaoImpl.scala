package com.hxqh.abb.dao

import com.hxqh.abb.common.basedao.DaoSupport
import com.hxqh.abb.model.view.Wpmaterial
import org.springframework.stereotype.Repository

/** * Created by Ocean lin	  */
@Repository("wpmaterialDao") class WpmaterialDaoImpl extends DaoSupport[Wpmaterial] with WpmaterialDao {}
