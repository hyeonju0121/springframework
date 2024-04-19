package com.mycompany.springframework.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Component
@ControllerAdvice
@Slf4j
public class Ch10ExceptionHandler {
	
	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointerException() {
		// 예외 처리 내용 작성
		log.info("handleNullPointerException() 실행");
		
		return "ch10/error500_null";
	}
}
