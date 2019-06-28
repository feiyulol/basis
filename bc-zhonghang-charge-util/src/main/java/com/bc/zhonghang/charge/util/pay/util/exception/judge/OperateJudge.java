package com.bc.zhonghang.charge.util.pay.util.exception.judge;

/**
 * <p>判断操作</p>
 * @ClassName: JudgeOperate
 * @Description: 判断操作
 * @author g.yang@i-vpoints.com
 * @date 2017年12月12日 下午2:35:53
 */
public interface OperateJudge<T extends Throwable> {
	
	/**
	 * <p>需要判断的操作<p>
	 * @Title: judge
	 * @Description: 需要判断的操作
	 * @author g.yang@i-vpoints.com
	 * @date 2017年12月12日 下午2:36:55
	 * @return boolean 判断是否成功
	 */
	public boolean judge();
	
	/**
	 * <p>如果校验失败，需要被抛出的异常<p>
	 * @Title: get
	 * @Description: 如果校验失败，需要被抛出的异常
	 * @author g.yang@i-vpoints.com
	 * @date 2017年12月12日 下午2:37:22
	 * @return Exception 需要抛出的异常
	 */
	public T get();
	
}
