
package com.hxqh.abb.dao;

import com.hxqh.abb.common.basedao.DaoSupport;
import com.hxqh.abb.model.Person;
import org.springframework.stereotype.Repository;


/**
 *
 * @author lh
 *
 */
@Repository("personDao")
public class PersonDaoImpl extends DaoSupport<Person> implements PersonDao {

}
