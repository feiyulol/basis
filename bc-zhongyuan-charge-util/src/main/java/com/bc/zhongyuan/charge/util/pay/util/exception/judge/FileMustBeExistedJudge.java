package com.bc.zhongyuan.charge.util.pay.util.exception.judge;

import java.io.File;

/**
 * <p>文件存在性校验</p>
 * @ClassName: FileMustBeExistedJudge
 * @Description: 文件存在性校验
 * @author g.yang@i-vpoints.com
 * @date 2018年1月17日 下午2:51:40
 */
public class FileMustBeExistedJudge<T extends Throwable> implements OperateJudge<T> {
	
	/**
	 * 错误抛出异常
	 */
	private T e;
	/**
	 * 文件路径
	 */
	private String absFilePath;
	
	public FileMustBeExistedJudge(String absFilePath, T e) {
		this.absFilePath = absFilePath;
		this.e = e;
	}

	@Override
	public boolean judge() {
		boolean result = false;
		File file = new File(absFilePath);
		if(null != file) {
			result = file.exists();
		}
		return result;
	}

	@Override
	public T get() {
		return e;
	}

}
