<%-- page 지시자: page 서버(WAS-Tomcat)에서 JSP 해석하는 방법을 기술 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Insert title here</title>
	      
	    <!-- Bootstrap 5를 위한 외부 라이브러리 설정 -->
	    <link href="${pageContext.request.contextPath}/resources/bootstrap-5.3.3/css/bootstrap.min.css" rel="stylesheet">
	    <script src="${pageContext.request.contextPath}/resources/bootstrap-5.3.3/js/bootstrap.bundle.min.js"></script>

	    <!-- jQuery 외부 라이브러리 설정 -->
	    <script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.7.1.min.js"></script>
	
		<!--사용자 정의 스크립트 -->
		<script type="text/javascript">
		</script>
	</head>
	
	<body>
		<!-- d-flex : row 방향 / vh: viewport 100%  -->
		<div class="d-flex flex-column vh-100">
			<%-- (include 지시자) : 소스 복사 개념 --%>
			<%@ include file="/WEB-INF/views/common/header.jsp" %>
			
			<div class="flex-grow-1 m-2">
				<div class="d-flex row">
					<!-- category -->
					<div class="col-md-4">
						<%-- <%@ include file="/WEB-INF/views/common/menu.jsp" %> --%>
						
						<%-- (jsp:include 액션) 외부에서 실행하고 결과만 삽입 --%>
						<jsp:include page="/WEB-INF/views/common/menu.jsp"/>
					</div>
					
					<!-- content -->
					<div class="border col-md-8">
						<!-- #################################################### -->
						<div class="card">
							<div class="card-header">home</div>
							<div class="card-body">
								content
							</div>
						</div>
						<!-- #################################################### -->
					</div>
				</div>
			</div>
		</div>
	</body>
</html>