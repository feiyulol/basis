package com.bc.zhongyuan.charge.util.pay.util.exception.judge;

/**
 * <p>对象不为空判断</p>
 * @ClassName: ObjectNotNullJudge
 * @Description: 对象不为空判断
 * @author g.yang@i-vpoints.com
 * @date 2017年12月27日 上午11:11:47
 */
public class ObjectNotNullJudge<T extends Throwable> implements OperateJudge<T>{
	
	private Object obj;
	private T e;
	
	public ObjectNotNullJudge(Object obj, T e) {
		this.obj = obj;
		if(null == e) {
			throw new NullPointerException();
		}
		this.e = e;
	}

	@Override
	public boolean judge() {
		return obj != null;
	}

	@Override
	public T get() {
		return e;
	}

}
