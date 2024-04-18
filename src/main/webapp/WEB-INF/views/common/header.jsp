<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
<!-- container-fluid : 전체 폭 차지 -->
  <div class="container-fluid">
    <a class="navbar-brand" href="/springframework">
      <img src="${pageContext.request.contextPath}/resources/image/logo-spring.png" style="width:40px;" class="rounded-pill"> 
      <!-- align-middle : 수직 정렬 태그 -->
      <span class="align-middle">전자정부프레임워크(Spring Framework)</span>
    </a>
    <div>
    	<c:if test="${login!='success'}">
    		<a href="${pageContext.request.contextPath}/ch07/sessionLoginForm" class="btn btn-success btn-small">login</a>
    	</c:if>	
    	
    	<c:if test="${login=='success'}">
    		<a href="${pageContext.request.contextPath}/ch07/sessionLogout" class="btn btn-success btn-small">logout</a>
    	</c:if>
    </div>
  </div>
</nav>