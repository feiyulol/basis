
package com.bc.zhongyuan.charge.dao.abs;

import java.util.List;

/**
 * <p>数据层的基础操作</p>
 * @ClassName: BaseDao
 * @Description: 数据层的基础操作
 * @author Generator
 * @date 2019年06月28日 15时07分18秒
 */
public interface BaseDao<E, C extends DaoCondition>{
	
	/**
	 * <p>通过主键ID更新一个实体bean</p>
	 * @Title: updateById
	 * @Description: 通过主键ID更新一个实体bean
	 * @param ${entityPackage} 当前需要更新的实体bean
	 * @author Generator
	 * @date 2019年06月28日 15时07分18秒
	 */
	public abstract int updateById(E model);
	
	/**
	 * <p>保存一条记录</p>
	 * @Title: insert
	 * @Description: 保存一条记录
	 * @param model 需要保存的实体
	 * @author Generator
	 * @date 2019年06月28日 15时07分18秒
	 */
	public abstract int insert(E model);
	
	/**
	 * <p>查询当前表里面所有的数据</p>
	 * @Title: selectAll
	 * @Description: 查询当前表里面所有的数据
	 * @return List<E> 表中的所有数据
	 * @author Generator
	 * @date 2019年06月28日 15时07分18秒
	 */
	public abstract List<E> selectAll();
	
	/**
	 * <p>通过一个查询条件，查询出一个查询结果</p>
	 * @Title: selectFirst
	 * @Description: 通过一个查询条件，查询出一个查询结果
	 * @param daoCondition 查询条件
	 * @return E 查询结果
	 * @author Generator
	 * @date 2019年06月28日 15时07分18秒
	 */
	public abstract E selectFirst(C daoCondition);
	
	/**
	 * <p>通过一个查询条件，查询出一个结果集合</p>
	 * @Title: selectList
	 * @Description: 通过一个查询条件，查询出一个结果集合
	 * @param daoCondition 查询条件
	 * @return List<E> 查询结果
	 * @author Generator
	 * @date 2019年06月28日 15时07分18秒
	 */
	public abstract List<E> selectList(C daoCondition);
	
}
