package com.bc.zhonghang.charge.util.handler;

import com.bc.zhonghang.charge.util.ResponseModel;
import com.bc.zhonghang.charge.util.ResponseModelCtc;
import com.bc.zhonghang.charge.util.enums.CtcCallResult;
import com.bc.zhonghang.charge.util.exception.ExceptionWrapper;
import com.bc.zhonghang.charge.util.exception.IllegalParamException;
import com.bc.zhonghang.charge.util.exception.ParamAbsentException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.SQLException;

/**
 * 
 * @Title: GlobalExceptionHandler
 * @Package com.bc.jiangbei.portal.util.handler
 * @Description: 全局捕获异常处理类
 * @author cy.wang@i-vpoints.com
 * @date 2018年5月3日 下午4:09:40
 * @version V1.0
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	private static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseModel defaultErrorHandler(Exception e) {
		LOGGER.error(e.getMessage(), e);
		return new ResponseModel(CtcCallResult.SYSTEM_ERROR.getResultCode(), CtcCallResult.SYSTEM_ERROR.getReusltMsg())
				.setTimestamp(System.currentTimeMillis());
	}

	@ExceptionHandler(value = SQLException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseModel sqlErrorHandler(SQLException e) {
		LOGGER.error(e.getMessage(), e);
		return new ResponseModel(CtcCallResult.EXTERNAL_SYSTEM_ERROR.getResultCode(), CtcCallResult.EXTERNAL_SYSTEM_ERROR.getReusltMsg())
				.setTimestamp(System.currentTimeMillis());
	}

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	public ResponseModel HttpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
		LOGGER.error(e.getMessage(), e);
		return new ResponseModel(CtcCallResult.EMPTY.getResultCode(), "缺少必传字段").setTimestamp(System.currentTimeMillis());
	}

	@ExceptionHandler(value = ExceptionWrapper.class)
	public ResponseModel customErrorHandler(ExceptionWrapper e) {
		LOGGER.error(e.getCustomErrMsg(), e);
		return new ResponseModel(e.getCode(), e.getCustomErrMsg()).setTimestamp(System.currentTimeMillis());
	}

	@ExceptionHandler(value = { IllegalParamException.class, ParamAbsentException.class,
			MissingServletRequestParameterException.class, MethodArgumentTypeMismatchException.class })
	public ResponseModelCtc paramValidErrorHandler(Exception e) {
		ResponseModelCtc response = new ResponseModelCtc();
		if (e instanceof ParamAbsentException || e instanceof MissingServletRequestParameterException) {
			response.setResultCode(CtcCallResult.EMPTY.getResultCode()).setReusltMsg(e.getMessage());
		} else if (e instanceof HttpMessageNotReadableException) {
			if (e.getCause() instanceof JsonProcessingException) {
				response.setResultCode(CtcCallResult.UNSUPPORTED.getResultCode())
						.setReusltMsg("json参数解析失败,请检查您的json格式: " + e.getCause().getMessage());
			} else {
				response.setResultCode(CtcCallResult.EXCEPTION.getResultCode()).setReusltMsg(CtcCallResult.EXCEPTION.getReusltMsg());
				LOGGER.error(e.getMessage(), e);
				return response;
			}
		} else {
			response.setResultCode(CtcCallResult.UNSUPPORTED.getResultCode()).setReusltMsg(e.getMessage());
		}
		LOGGER.info(response.getReusltMsg());
		return response;
	}
}
