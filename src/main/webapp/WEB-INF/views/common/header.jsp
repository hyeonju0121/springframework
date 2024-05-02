<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
<!-- container-fluid : 전체 폭 차지 -->
  <div class="container-fluid">
    <a class="navbar-brand" href="/springframework">
      <img src="${pageContext.request.contextPath}/resources/image/logo-spring.png" style="width:40px;" class="rounded-pill"> 
      <!-- align-middle : 수직 정렬 태그 -->
      <span class="align-middle">전자정부프레임워크(Spring Framework)</span>
    </a>
    <div>
    
    	<%--
    	<c:if test="${login!='success'}">
    		<a href="${pageContext.request.contextPath}/ch07/sessionLoginForm" class="btn btn-success btn-small">login</a>
    	</c:if>	
    	
    	<c:if test="${login=='success'}">
    		<a href="${pageContext.request.contextPath}/ch07/sessionLogout" class="btn btn-success btn-small">logout</a>
    	</c:if>
    	--%>
    	
    	<!-- 로그인 안된 경우 -->
    	<sec:authorize access="isAnonymous()">
    		<a href="${pageContext.request.contextPath}/ch17/loginForm" class="btn btn-success btn-small">login</a>
    	</sec:authorize>
    	<!-- 로그인 된 경우 -> 로그아웃 버튼 활성화 -->
    	<sec:authorize access="isAuthenticated()">
    		<%-- 사이트간 요청 위조 방지 설정이 비활성화되어 있을 경우 GET 방식으로 요청 가능 --%>
    		<b class="text-white me-2">
    			<sec:authentication property="principal.username"/>
    			<span>님, 안녕하세요!</span>
    		</b>
    		<a href="${pageContext.request.contextPath}/logout" class="btn btn-success btn-small">logout</a>
    		
    		<%-- 사이트간 요청 위조 방지 설정이 활성화되어 있을 경우 POST 방식으로만 요청 가능 --%>
    		<%-- <form action="post" action="${pageContext.request.contextPath}/logout">
    			사이트간 요청 위조 방지 설정이 활성화 된 경우에는 hidden 이 코드를 폼 안에 반드시 넣어줘야 한다.
    			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    			<button type="submit" class="btn btn-success btn-sm">로그아웃</button>
    		</form> --%>
    	</sec:authorize>
    </div>
  </div>
</nav>