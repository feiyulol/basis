package com.bc.zhonghang.charge.util.pay.util.exception;


import com.bc.zhonghang.charge.util.pay.util.exception.judge.OperateJudge;

/**
 * <p>异常抛出工具类</p>
 * @ClassName: ThrowableUtil
 * @Description: 异常抛出工具类
 * @author g.yang@i-vpoints.com
 * @date 2017年12月12日 下午2:39:06
 */
public class ThrowableUtil {
	
	/**
	 * <p>判断一个操作是否成功<p>
	 * @Title: judge
	 * @Description: 判断一个操作是否成功
	 * @param nullSafe 空值安全，true，则允许operator为null，并认为是成功；如果为false，当operator为null时，抛出NullPointerException
	 * @param operator 需要判断操作的对象
	 * @author g.yang@i-vpoints.com
	 * @throws Exception 失败所抛异常
	 * @date 2017年12月12日 下午2:41:53
	 */
	public static <T extends Throwable> void judgement(boolean nullSafe, OperateJudge<T> operator) throws T {
		if(false == nullSafe) {
			judge(operator);
		}else {
			if(null != operator && false == operator.judge()) {
				judge(operator);
			}
		}
	}
	
	/**
	 * <p>判断一个操作是否成功，null-safe，如果判断一个操作是否成功为null则认为操作成功<p>
	 * @Title: judgement
	 * @Description: 判断一个操作是否成功，null-safe，如果判断一个操作是否成功为null则认为操作成功
	 * @param operator
	 * @author g.yang@i-vpoints.com
	 * @date 2017年12月12日 下午2:48:55
	 * @throws 失败所抛异常
	 */
	public static <T extends Throwable> void judgement(OperateJudge<T> operator) throws T{
		judgement(true, operator);
	}
	
	private static <T extends Throwable> void judge(OperateJudge<T> operator) throws T{
		if(false == operator.judge()) {
			throw operator.get();
		}
	}
	
}
