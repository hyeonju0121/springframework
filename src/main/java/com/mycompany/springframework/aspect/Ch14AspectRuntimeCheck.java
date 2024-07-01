package com.mycompany.springframework.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class Ch14AspectRuntimeCheck {
	// @Around -> 핵심 로직을 호출하기 전과 후에 공통 기능을 실행
	// RuntimeCheck 어노테이션이 사용된 코드에 aop 적용
	@Around("@annotation(com.mycompany.springframework.aspect.RuntimeCheck)")
	public Object method(ProceedingJoinPoint joinPoint) throws Throwable{
		// 전처리 공통 코드 정의
		long start = System.nanoTime();
		
		Object result = joinPoint.proceed(); 
		
		// 후처리 공통 코드 정의
		long end = System.nanoTime();
		long howLong = end - start;
		
		log.info("메소드 실행시간: " + howLong + "ns");
		
		ServletRequestAttributes sra = 
				(ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		
		HttpServletRequest request = sra.getRequest();
		request.setAttribute("methodName", joinPoint.getSignature().toShortString());
		request.setAttribute("howLong", howLong);
		
		return result;
	}
}
