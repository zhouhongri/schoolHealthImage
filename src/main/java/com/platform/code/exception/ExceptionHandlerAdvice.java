package com.platform.code.exception;

import com.platform.code.util.ErrorCode;
import com.platform.code.util.ResponseResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description 异常统一处理类
 **/
@ControllerAdvice
@ResponseBody
public class ExceptionHandlerAdvice {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        logger.error(e.getMessage(), e);
        ResponseResultUtil.result(ErrorCode.SYSTEM_ERROR.getName(), ErrorCode.SYSTEM_ERROR.getStatusCode());
    }

    @ExceptionHandler(NullPointerException.class)
    public void handleNullPointerException(NullPointerException e) {
        logger.error(e.getMessage(), e);
        ResponseResultUtil.result(ErrorCode.PARAM_NULL_ERROR.getName(), ErrorCode.PARAM_NULL_ERROR.getStatusCode());
    }
}
