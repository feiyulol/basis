package com.bc.zhongyuan.charge.util.pay.util.exception.judge;

/**
 * <p>boolean 类型结果判断</p>
 * <p>如果结果为false，则会抛出期望异常/p>
 * @ClassName: BooleanResultJudge
 * @Description: boolean 类型结果判断
 * @author g.yang@i-vpoints.com
 * @date 2018年5月2日 下午3:57:01
 */
public class BooleanResultJudge <T extends Throwable> implements OperateJudge<T> {
	
	private boolean bool;
	private T e;
	
	public BooleanResultJudge(boolean bool, T e) {
		this.bool = bool;
		if(null == e) {
			throw new NullPointerException();
		}
		this.e = e;
	}

	@Override
	public boolean judge() {
		return bool;
	}

	@Override
	public T get() {
		return e;
	}

}
