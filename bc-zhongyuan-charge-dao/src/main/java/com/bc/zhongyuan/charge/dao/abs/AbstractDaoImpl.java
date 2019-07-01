
package com.bc.zhongyuan.charge.dao.abs;

import java.util.List;

/**
 * <p>服务接口的抽象实现</p>
 * @ClassName: AbstractDaoImpl
 * @Description: <p>服务接口的抽象实现</p>
 * @author Generator
 * @date 2019年06月28日 15时07分18秒
 * @param <E> Element 查询结果返回类型元素
 * @param <C> Condition 查询条件
 * @param <D> Mapper 数据层操作支持
 */
public abstract class AbstractDaoImpl<E,C extends DaoCondition,D extends BaseMapper<E, C>> implements BaseDao<E,C> {
	
	@Override
	public int updateById(E model) {
		return daoSupport().updateById(model);
	}

	@Override
	public List<E> selectAll() {
		C daoCondition = blankCondition();
		return selectList(daoCondition);
	}
	
	@Override
	public int insert(E model) {
		return daoSupport().insert(model);
	}
	
	/**
	 * <p>查询一个符合条件的记录，即查询一条数据记录，如果有多条符合条件的结果，则返回第一条</p>
	 * <p>这个方法的思想，在于只希望获取一个对象，如果获取对象，说明查询条件的唯一索引没有成功建立！是否需要抛异常，自行修改~</p>
	 * @Title: selectFirst
	 * @Description: 查询一个符合条件的记录
	 * @param daoCondition 查询条件
	 * @return E 查询结果
	 * @author Generator
	 * @date 2019年06月28日 15时07分18秒
	 */
	@Override
	public E selectFirst(C daoCondition){
		E result = null;
		List<E> list = selectList(daoCondition);
		if(null != list && false == list.isEmpty()){
			result = list.get(0);
		}
		return result;
	}
	
	/**
	 * <p>查询一个结果集合</p>
	 * @Title: selectList
	 * @Description: 查询一个结果集合
	 * @param daoCondition 查询条件
	 * @return List<E> 查询结果
	 * @author Generator
	 * @date 2019年06月28日 15时07分18秒
	 */
	@Override
	public List<E> selectList(C daoCondition){
		D dao = daoSupport();
		return dao.selectByCondition(daoCondition);
	}
	
	/**
	 * <p>DAO对象提供支持</p>
	 * <p>因为是抽象类，不在spring环境下，所有，由子类自身提供操作对象</p>
	 * @Title: daoSupport
	 * @Description: DAO对象提供支持
	 * @return D DAO操作对象
	 * @author Generator
	 * @date 2019年06月28日 15时07分18秒
	 */
	protected abstract D daoSupport();
	
	/**
	 * <p>提供一个空白的查询条件</p>
	 * @Title: blankCondition
	 * @Description: 提供一个空白的查询条件
	 * @return C 一个空白条件的查询条件
	 * @author Generator
	 * @date 2019年06月28日 15时07分18秒
	 */
	protected abstract C blankCondition();

}
