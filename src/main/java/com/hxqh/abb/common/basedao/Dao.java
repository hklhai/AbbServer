package com.hxqh.abb.common.basedao;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface Dao<T extends Serializable> {
	public abstract T find(Serializable id);

	public abstract void save(T entity);

	public abstract void update(T entity);

	public abstract void merge(T entity);

	/**
	 * 更新时首先进行查询，实体应包含主键，实验于不把字段改为NULL的更新
	 * 
	 * @param entity
	 */
	public abstract void updateWithQuery(T entity);

	public abstract void delete(Serializable id);

	public abstract long getCount();

	public abstract long getCount(String where, Map<String, Object> params);

	/**
	 * 根据条件查询，获得所有记录
	 */
	public abstract List<T> findAll();

	/**
	 * 根据条件查询，获得记录集
	 * 
	 * @param where
	 *            查询条件语句
	 * @param params
	 *            查询条件参数
	 * @param orderby
	 *            排序属性 value asc/desc
	 */
	public abstract List<T> findAll(String where, Map<String, ?> params, LinkedHashMap<String, String> orderby);

	/**
	 * 根据条件查询，获得记录集
	 * 
	 * @param firstResult
	 *            第一条记录号,为-1时不进行筛选
	 * @param maxResult
	 *            返回记录最大数,为-1时不进行筛选
	 * @param where
	 *            查询条件语句
	 * @param params
	 *            查询条件参数
	 * @param orderby
	 *            排序属性 value asc/desc
	 */
	public abstract List<T> findAll(int firstResult, int maxResult, String where, Map<String, Object> params,
                                    String orderby);

	/**
	 * 根据条件查询，获得记录集,只查询fields的字段
	 * 
	 * @param firstResult
	 *            第一条记录号,为-1时不进行筛选
	 * @param maxResult
	 *            返回记录最大数,为-1时不进行筛选
	 * @param where
	 *            查询条件语句
	 * @param params
	 *            查询条件参数
	 * @param orderby
	 *            order by 属性 asc/desc
	 * @param fields
	 *            需要查询的字段
	 */
	public abstract QueryResult<Map<String, Object>> getScrollData(int firstResult, int maxResult, String where,
                                                                   Map<String, Object> params, String orderby, String[] fields);

	/**
	 * 根据条件查询，获得记录集
	 * 
	 * @param firstResult
	 *            第一条记录号,为-1时不进行筛选
	 * @param maxResult
	 *            返回记录最大数,为-1时不进行筛选
	 * @param where
	 *            查询条件语句
	 * @param params
	 *            查询条件参数
	 * @param orderby
	 *            order by 属性 asc/desc
	 */
	public abstract QueryResult<T> getScrollData(int firstResult, int maxResult, String where,
                                                 Map<String, Object> params, String orderby);

	/**
	 * 根据条件查询，获得记录集
	 * 
	 * @param firstResult
	 *            第一条记录号,为-1时不进行筛选
	 * @param maxResult
	 *            返回记录最大数,为-1时不进行筛选
	 * @param where
	 *            查询条件语句
	 * @param params
	 *            查询条件参数
	 * @param orderby
	 *            排序属性 value asc/desc
	 */
	public abstract QueryResult<T> getScrollData(int firstResult, int maxResult, String where,
                                                 Map<String, Object> params, LinkedHashMap<String, String> orderby);

	/**
	 * 根据条件查询，获得记录集
	 * 
	 * @param firstResult
	 *            第一条记录号
	 * @param maxResult
	 *            返回记录最大数
	 * @param orderby
	 *            排序属性 value asc/desc
	 */
	public abstract QueryResult<T> getScrollData(int firstResult, int maxResult, LinkedHashMap<String, String> orderby);

	/**
	 * 根据条件查询，获得记录集
	 * 
	 * @param where
	 *            查询条件语句
	 * @param params
	 *            查询条件参数
	 */
	public abstract QueryResult<T> getScrollData(String where, Map<String, Object> params);

	public abstract QueryResult<T> getScrollData();

}
