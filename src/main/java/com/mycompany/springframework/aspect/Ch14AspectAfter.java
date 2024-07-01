package com.mycompany.springframework.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class Ch14AspectAfter {
	// @After :  pointcut 실행 후 공통 코드 실행
	@After("execution(public * com.mycompany.springframework.controller.Ch14Controller.after(..))")
	public void method() {
		// 컨트롤러가 실행된 후, 해당 method() 가 마지막에 실행 
		log.info("후처리 코드 실행");
	}
}
