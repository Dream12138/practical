package com.neusoft.busmis.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = {RestController.class})
public class RestControllerExceptionHandler {
	
	//所有REST Controller异常处理方法
	@ExceptionHandler
	public ResponseEntity<String> handle(Exception ex) {
		System.out.println("全局异常处理方法。。。。");
		return new ResponseEntity<String>(ex.getMessage(),null,HttpStatus.EXPECTATION_FAILED);
	}

}
