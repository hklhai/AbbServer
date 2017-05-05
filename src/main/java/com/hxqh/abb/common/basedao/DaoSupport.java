package com.hxqh.abb.common.basedao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.persistence.Id;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class DaoSupport<T extends Serializable> implements Dao<T> {

	@Resource
	protected SessionFactory sessionFactory;
	protected Class<?> entityClass;
	protected String entityName;
	protected Method getIdMethod;

	public DaoSupport() {
		if (!"BaseDaoImpl".equals(this.getClass().getSimpleName())) {
			entityClass = getEntityClass();
			entityName = getEntityName();
			getIdMethod = findGetIdMethod();
		}
	}

	@SuppressWarnings("unchecked")
	public Class<T> getEntityClass() {
		Type parentType = getClass().getGenericSuperclass();
		if (parentType instanceof ParameterizedType) {
			ParameterizedType ptype = (ParameterizedType) parentType;
			return (Class<T>) ptype.getActualTypeArguments()[0];
		}
		return null;
	}

	public String getEntityName() {
		return this.entityClass.getSimpleName();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public T find(Serializable id) {
		return (T) sessionFactory.getCurrentSession().get(entityClass, id);
	}

	public void save(T entity) {
		sessionFactory.getCurrentSession().persist(entity);
	}

	public void update(T entity) {
		sessionFactory.getCurrentSession().update(entity);
	}
	
	public void merge(T entity) {
		sessionFactory.getCurrentSession().merge(entity);
	}

	public void updateWithQuery(T entity) {
		try {
			Serializable id = (Serializable) getIdMethod.invoke(entity);
			T entitycur = find(id);

			Field[] fields = entityClass.getDeclaredFields();
			for (Field field : fields) {
				String filedName = field.getName();
				String ufilename = filedName.substring(0, 1).toUpperCase()
						+ filedName.substring(1);
				String getfiledMethodName = "get" + ufilename;
				String setfiledMethodName = "set" + ufilename;
				try {
					Method getMethod = entityClass
							.getMethod(getfiledMethodName);
					Object f = getMethod.invoke(entity);
					if (f != null) {
						Class<?> type = getMethod.getReturnType();
						Method setMethod = entityClass.getMethod(
								setfiledMethodName, new Class[] { type });
						setMethod.invoke(entitycur, f);
					}
				} catch (NoSuchMethodException e) {
				}

			}
			this.update(entitycur);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(Serializable id) {
		sessionFactory.getCurrentSession().delete(
				sessionFactory.getCurrentSession().load(entityClass, id));
	}

	@Transactional(readOnly = true)
	public long getCount() {
		return (Long) sessionFactory.getCurrentSession()
				.createQuery("select count(o) from " + entityName + " o")
				.iterate().next();
	}

	@Transactional(readOnly = true)
	public long getCount(String where, Map<String, Object> params) {
		String whereql = where != null && !"".equals(where.trim()) ? " where "
				+ where : "";
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select count(o) from " + entityName + " o " + whereql);
		if (where != null && !"".equals(where.trim())) {
			setParameter(query, params);
		}
		return (Long) query.iterate().next();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> findAll(String where, Map<String, ?> params,
			LinkedHashMap<String, String> orderby) {
		String whereql = where != null && !"".equals(where.trim()) ? " where "
				+ where : "";
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from " + entityName + " o " + whereql + buildOrderby(orderby));
		if (where != null && !"".equals(where.trim())) {
			setParameter(query, params);
		}
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> findAll(int firstResult,int maxResult,String where, Map<String, Object> params,
			String orderby) {
		String whereql = where != null && !"".equals(where.trim()) ? " where "
				+ where : "";
		orderby = orderby == null ? "" : orderby;
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from " + entityName + " o " + whereql + orderby);
		if (firstResult != -1 && maxResult != -1)
			query.setFirstResult(firstResult).setMaxResults(maxResult);
		return query.list();
	}
	

	public List<T> findAll() {
		return findAll(null, null, null);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public QueryResult<T> getScrollData(int firstResult, int maxResult,
			String where, Map<String, Object> params, String orderby) {
		String whereql = where != null && !"".equals(where.trim()) ? " where "
				+ where : "";
		orderby = orderby == null ? "" : orderby;
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from " + entityName + " o " + whereql + orderby);
		if (firstResult != -1 && maxResult != -1)
			query.setFirstResult(firstResult).setMaxResults(maxResult);
		if (where != null && !"".equals(where.trim())) {
			setParameter(query, params);
		}
		QueryResult<T> qr = new QueryResult<T>();
		qr.setResultlist(query.list());
		query = sessionFactory.getCurrentSession().createQuery(
				"select count(o) from " + entityName + " o " + whereql);
		if (where != null && !"".equals(where.trim())) {
			setParameter(query, params);
		}
		qr.setRecordtotal((Long) query.iterate().next());
		return qr;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public QueryResult<Map<String, Object>> getScrollData(int firstResult,
			int maxResult, String where, Map<String, Object> params,
			String orderby, String[] fields) {
		String whereql = where != null && !"".equals(where.trim()) ? " where "
				+ where : "";
		String strFields = buildFields(fields);
		orderby = orderby == null ? "" : orderby;
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select " + strFields + " from " + entityName + " o " + whereql
						+ orderby);
		if (firstResult != -1 && maxResult != -1)
			query.setFirstResult(firstResult).setMaxResults(maxResult);
		if (where != null && !"".equals(where.trim())) {
			setParameter(query, params);
		}
		QueryResult<Map<String, Object>> qr = new QueryResult<Map<String, Object>>();
		qr.setResultlist(query.list());
		query = sessionFactory.getCurrentSession().createQuery(
				"select count(o) from " + entityName + " o " + whereql);
		if (where != null && !"".equals(where.trim())) {
			setParameter(query, params);
		}
		qr.setRecordtotal((Long) query.iterate().next());
		return qr;
	}

	public QueryResult<T> getScrollData(int firstResult, int maxResult,
			String where, Map<String, Object> params,
			LinkedHashMap<String, String> orderby) {
		return getScrollData(firstResult, maxResult, where, params,
				buildOrderby(orderby));
	}

	public QueryResult<T> getScrollData(String where, Map<String, Object> params) {
		return getScrollData(-1, -1, where, params, "");
	}

	public QueryResult<T> getScrollData(int firstResult, int maxResult,
			LinkedHashMap<String, String> orderby) {
		return getScrollData(firstResult, maxResult, "", null, orderby);
	}
	
	/**
	 * 获得记录集
	 */
	public QueryResult<T> getScrollData() {
		return getScrollData(-1, -1, "", null, "");
	}

	/**

	/**
	 * 构建排序语句
	 * 
	 * @param orderby
	 *            key排序属性 value asc/desc
	 * @return
	 */
	protected static String buildOrderby(LinkedHashMap<String, String> orderby) {
		StringBuilder sb = new StringBuilder();
		if (orderby != null && !orderby.isEmpty()) {
			sb.append(" order by ");
			for (Map.Entry<String, String> entry : orderby.entrySet()) {
				sb.append("o.").append(entry.getKey()).append(" ")
						.append(entry.getValue()).append(",");
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	protected static void setParameter(Query query, Map<String, ?> params) {
		if (params == null || params.size() == 0)
			return;
		query.setProperties(params);
	}

	protected static String buildFields(String[] fields) {
		StringBuilder sb = new StringBuilder("new map(");
		for (String field : fields) {
			if (field.lastIndexOf(".") >= 0)
				sb.append(field.toLowerCase()).append(" as ")
						.append(field.substring(field.lastIndexOf(".")+1))
						.append(",");
			else
				sb.append(field.toLowerCase()).append(" as ").append(field)
						.append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append(")");
		return sb.toString();
	}

	protected Method findGetIdMethod() {
		Method[] methods = entityClass.getMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(Id.class)) {
				return method;
			}
		}
		return null;
	}
	
	
}
