package com.mycompany.springframework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;

@Component
@ControllerAdvice
@Slf4j
public class Ch10ExceptionHandler {

	@ExceptionHandler(NullPointerException.class)
	public String handlerNullPointerException() {
		// 예외 처리 내용 작성
		log.info("실행");
		return "ch10/error500_null";
	}
	
	@ExceptionHandler(Ch10CustomException.class)
	// 예외객체를 받을 수 있도록 매개변수 타입 설정 model로 <!-- 예외에 대한 매개변수 선언 -->
	public String handlerCh10CustomException(Ch10CustomException e, Model model) {
		// 예외 처리 내용 작성
		log.info("실행");
		model.addAttribute("message", e.getMessage());
		return "ch10/error500_custom";
	}

	// 500에러 한꺼번에 처리하기 위 예외를 제외한 500을 발생시키는 모든 예외를 처리
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500
	public String handle500Exception() {
		return "ch10/error500";
	}

	// 404 예외 처리 -> 잘못된 주소 요청
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND) // 404
	public String handle404() {
		return "ch10/error404";
	}
}