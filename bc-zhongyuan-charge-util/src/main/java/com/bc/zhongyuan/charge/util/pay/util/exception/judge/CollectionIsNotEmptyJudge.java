package com.bc.zhongyuan.charge.util.pay.util.exception.judge;

import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * <p>集合不可为空判断</p>
 * @ClassName: CollectionIsNotEmptyJudge
 * @Description: 集合不可为空判断
 * @author g.yang@i-vpoints.com
 * @date 2018年5月2日 下午3:56:41
 */
public class CollectionIsNotEmptyJudge<T extends Throwable> implements OperateJudge<T> {
	
	/**
	 * 集合
	 */
	private Collection<?> collection;
	/**
	 * 错误抛出异常
	 */
	private T e;
	
	public CollectionIsNotEmptyJudge(Collection<?> collection, T e) {
		this.collection = collection;
		this.e = e;
	}

	@Override
	public boolean judge() {
		return !CollectionUtils.isEmpty(collection);
	}

	@Override
	public T get() {
		return e;
	}
	
}
