
package com.bc.zhongyuan.charge.dao.abs;

import java.util.List;

/**
 * <p>数据库层操作的共性方法抽象</p>
 * @ClassName: BaseMapper
 * @Description: 数据库层操作的共性方法抽象
 * @author Generator
 * @date 2019年06月28日 15时07分18秒
 * @param <E> E Element 类型元素，返回类型
 * @param <C> Condition 操作条件
 */
public interface BaseMapper<E,C extends DaoCondition> {
	
	/**
	 * <p>通过给定查询条件，查询出一组结果集</p>
	 * @Title: selectByCondition
	 * @Description: 通过给定查询条件，查询出一组结果集
	 * @param daoMapper 查询条件
	 * @return List<E> 查询结果集
	 * @author Generator
	 * @date 2019年06月28日 15时07分18秒
	 */
	public abstract List<E> selectByCondition(C daoCondition);
	
	/**
	 * <p>查询当前表下的所有数据</p>
	 * @Title: selectAll
	 * @Description: 查询当前表下的所有数据
	 * @return List<E> 结果集合
	 * @author Generator
	 * @date 2019年06月28日 15时07分18秒
	 */
	public abstract List<E> selectAll();
	
	/**
	 * <p>插入指定实体bean到数据库中</p>
	 * @Title: insert
	 * @Description: 插入指定实体bean到数据库中
	 * @param entity 需要插入的实体bean
	 * @author Generator
	 * @date 2019年06月28日 15时07分18秒
	 */
	public abstract int insert(E entity);
	
	/**
	 * <p>根据主键更新指定实体bean</p>
	 * @Title: updateById
	 * @Description: 根据主键更新指定实体bean
	 * @param entity 需要更新的实体bean
	 * @author Generator
	 * @date 2019年06月28日 15时07分18秒
	 */
	public abstract int updateById(E entity);
	
}
