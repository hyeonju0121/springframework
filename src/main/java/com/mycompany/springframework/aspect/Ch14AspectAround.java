package com.mycompany.springframework.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class Ch14AspectAround {

	// @Around -> 핵심 로직을 호출하기 전과 후에 공통 기능을 실행
	@Around("execution(public * com.mycompany.springframework.controller.Ch14Controller.around(..))")
	public Object method(ProceedingJoinPoint joinPoint) throws Throwable{
		// 전처리 공통 코드 정의
		log.info("전처리 공통 코드 실행");
		
		// Around 의 리턴값을 받아야 함
		Object result = joinPoint.proceed(); // Ch14Controller.around() 호출
		
		// 후처리 공통 코드 정의
		log.info("후처리 공통 코드 실행");
		
		return result;
	}
}
