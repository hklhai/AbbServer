package com.hxqh.abb.dao;

import com.hxqh.abb.common.basedao.DaoSupport;
import com.hxqh.abb.model.User;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lh
 *
 */
@Repository("userDao")
public class UserDaoImpl extends DaoSupport<User> implements UserDao {

}
