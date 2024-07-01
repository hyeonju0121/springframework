package com.mycompany.springframework.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class Ch14AspectAfterReturning {

	// @After -> 실행이 끝났다에 시점
	// @AfterReturning -> 실행이 끝나고 리턴값으로 뭘 받고 싶을 때 사용
	@AfterReturning(pointcut="execution(public * com.mycompany.springframework.controller.Ch14Controller.afterReturning(..))"
					, returning="returnValue")
	public void method(String returnValue) {
		// pointcut 이 실행되고 해당 pointcut으로 지정된 메소드 값이 매개값으로 들어온다.
		
		log.info("후처리 코드 실행");
		log.info("리턴값 처리: " +  returnValue);
	}
}
