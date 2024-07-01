package com.mycompany.springframework.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class Ch14AspectAfterThrowing {

	// @After -> 실행이 끝났다에 시점
	// @AfterThrowing -> pointcut으로 지정된 메소드가 실행 도중 에러가 발생할 경우, 공통 기능 수행
	// Ch14Controller 가 갖고있는 모든 메소드를 대상으로 aspect 적용 .Ch14Controller.*(..)
	@AfterThrowing(pointcut="execution(public * com.mycompany.springframework.controller.Ch14Controller.*(..))",
					throwing="e")
	public void method(Throwable e) {
		log.info("후처리 코드 실행");
		log.info("예외 원인: " + e.getMessage());
	}
}
