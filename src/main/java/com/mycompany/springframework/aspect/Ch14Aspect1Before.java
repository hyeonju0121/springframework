package com.mycompany.springframework.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class Ch14Aspect1Before {
	// @Before :  pointcut  실행 전 공통 코드 실행
	@Before("execution(public * com.mycompany.springframework.controller.Ch14Controller.before(..))")
	public void method() {
		// 컨트롤러가 실행되기 전에 해당 method() 먼저 실행 
		log.info("전처리 코드 실행");
	}
}
