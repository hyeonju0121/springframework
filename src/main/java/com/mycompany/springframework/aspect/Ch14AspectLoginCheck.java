package com.mycompany.springframework.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
public class Ch14AspectLoginCheck {
	// @Around -> 핵심 로직을 호출하기 전과 후에 공통 기능을 실행
	// LoginCheck 어노테이션이 사용된 코드에 aop 적용
	@Around("@annotation(com.mycompany.springframework.aspect.LoginCheck)")
	public Object method(ProceedingJoinPoint joinPoint) throws Throwable{
		// 전처리 공통 코드 정의
		ServletRequestAttributes sra = 
				(ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		
		HttpServletRequest request = sra.getRequest();
		HttpSession session = request.getSession();
			
		// session 내에 login 에 대한 데이터가 있는지 검사
		String login = (String) session.getAttribute("login");
		
		if(login == null) {
			// 로그인이 되지 않았다면, 로그인 폼으로 redirect 시킴
			return "redirect:/ch07/sessionLoginForm";
		} else {
			Object result = joinPoint.proceed(); 
			return result;
		} 
	}
}
