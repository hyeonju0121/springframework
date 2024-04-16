<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<div class="accordion" id="accordionExample">
	  <div class="accordion-item">
	    <h2 class="accordion-header">
	      <button class="accordion-button ${chNum=='ch01'?'':'collapsed'}" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
	        Ch01. 개발 환경 구축
	      </button>
	    </h2>
	    <div id="collapseOne" class="accordion-collapse collapse ${chNum=='ch01'?'show':''}" data-bs-parent="#accordionExample">
	      <div class="accordion-body">
	      	<ul>
	      		<li><a href="${pageContext.request.contextPath}/ch01/content">공통 레이아웃 구성</a></li>
	      	</ul>
	      </div>
	    </div>
	  </div>
	  <div class="accordion-item">
	    <h2 class="accordion-header">
	      <button class="accordion-button ${chNum=='ch02'?'':'collapsed'}" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
	        Ch02. 요청 매핑
	      </button>
	    </h2>
	    <div id="collapseTwo" class="accordion-collapse collapse ${chNum=='ch02'?'show':''}" data-bs-parent="#accordionExample">
	      <div class="accordion-body">
	      	<ul>
	      		<li><a href="${pageContext.request.contextPath}/ch02/getMethod">GET 방식</a></li>
	      		<li><a href="${pageContext.request.contextPath}/ch02/postMethod">POST 방식</a></li>
	      		<li><a href="${pageContext.request.contextPath}/ch02/modelAndViewReturn">ModelAndView 리턴</a></li>
	      		<li><a href="${pageContext.request.contextPath}/ch02/voidReturn">void 리턴(image download)</a></li>
	      		<li><a href="${pageContext.request.contextPath}/ch02/objectReturn">Object 리턴</a></li>
	      		<li><a href="${pageContext.request.contextPath}/ch02/testAuthInterceptor1">testAuthInterceptor1(로그인 없이도 볼 수 있는 내용)</a></li>
	      		<li><a href="${pageContext.request.contextPath}/ch02/testAuthInterceptor2">testAuthInterceptor2()로그인 해야  볼 수 있는 내용)</a></li>
	      	</ul>
	      </div>
	    </div>
	  </div>
	  <div class="accordion-item">
	    <h2 class="accordion-header">
	      <button class="accordion-button ${chNum=='ch03'?'':'collapsed'}" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
	        Ch03. 요청 매핑 메소드의 매개변수
	      </button>
	    </h2>
	    <div id="collapseThree" class="accordion-collapse collapse ${chNum=='ch03'?'show':''}" data-bs-parent="#accordionExample">
	      <div class="accordion-body">
	      	<ul>
	      		<li><a href="${pageContext.request.contextPath}/ch03/receiveParamData?param1=문자열&param2=5&param3=3.14&param4=true&param5=2024-04-15">GET 방식 데이터 얻기</a></li>
	      		<li><a href="${pageContext.request.contextPath}/ch03/postMethodForm">POST 방식 Form 데이터 얻기</a></li>
	      		<li><a href="${pageContext.request.contextPath}/ch03/requestParamAnnoatation?param1=문자열&param2=5&param3=3.14&param4=true&param5=2024-04-15">@RequestParam</a></li>
	      		<li><a href="${pageContext.request.contextPath}/ch03/requestParamAnnoatationRequired?param1=문자열&param2=5&param3=3.14&param4=true&param5=2024-04-15">@RequestParam의 required 속성</a></li>
	      		<li><a href="${pageContext.request.contextPath}/ch03/requestParamAnnoatationDefaultValue?param1=문자열&param2=5&param3=3.14&param4=true">@RequestParam의 defaultValue 속성</a></li>
	      		<li><a href="${pageContext.request.contextPath}/ch03/typeChange?param1=문자열&param2=5&param3=3.14&param4=true&param5=2024-04-15">요청 파라미터의 값 타입 변환</a></li>
	      		<li><a href="${pageContext.request.contextPath}/ch03/getDto?param1=문자열&param2=5&param3=3.14&param4=true&param5=2024-04-15">요청 파라미터의 값을 DTO로 받기</a></li>
	      		<li><a href="${pageContext.request.contextPath}/ch03/ajax">AJAX로 요청 파라미터 보내기</a></li>
	      	</ul>
	      </div>
	    </div>
	  </div>
	  <div class="accordion-item">
	    <h2 class="accordion-header">
	      <button class="accordion-button ${chNum=='ch04'?'':'collapsed'}" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
	        Ch04. 폼 유효성 검사
	      </button>
	    </h2>
	    <div id="collapseFour" class="accordion-collapse collapse ${chNum=='ch04'?'show':''}" data-bs-parent="#accordionExample">
	      <div class="accordion-body">
	      	<ul>
	      		<li><a href="${pageContext.request.contextPath}/ch04/loginForm">로그인 폼</a></li>
	      		<li><a href="${pageContext.request.contextPath}/ch04/signUpForm">회원가입 폼</a></li>
	      	</ul>
	      </div>
	    </div>
	  </div>
	</div>