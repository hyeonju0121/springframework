package com.mycompany.springframework.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch02AuthInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception {
		log.info("preHandler() 실행");
		
		// 요청 매핑 메소드 참조 객체
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		
		// 요청 매핑 메소드에 @Auth가 붙어있지 않다면 null을 리턴
		// 요청 매핑 메소드에 @Auth가 붙어있다면 not null을 리턴
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		if (auth == null) {
			// 로그인이 필요 없는 경우 
			// 요청 매핑 메소드를 실행
			return true;
		} else {
			// 로그인이 필요한 경우
			// 로그인 검사
			boolean loginStatus = true;
			if (loginStatus) {
				// 요청 매핑 메소드를 실행
				return true;
			} else {
				// 홈으로 강제 이동
				// requset.getContextPath => /springframework
				response.sendRedirect(request.getContextPath());
				// 요청 매핑 메소드 실행을 하지 않음
				return false;
			}
		}
	}

}
