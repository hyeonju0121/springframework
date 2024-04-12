<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" >
		<title>Insert title here</title>
		
		<!-- Bootstrap 5를 위한 외부 라이브러리 설정-->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
		<!-- jQuery 외부 라이브러리 설정 -->
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
	
		<!--사용자 정의 스크립트 -->
		<script type="text/javascript">
			function handleBtn1() {
				console.log("handleBtn1() 실행");
				location.href = "getMethod?chNUm=ch02&bkind=QAndA&bno=200";
			}
			
			function handleBtn2() {
				console.log("handleBtn2() 실행");
				// 비동기 요청
				$.ajax({
					url: "getMethodAjax", // getMethodAjax.jsp에 Ajax 요청
					type: "get", 
					// data: "bkind=notice&bno=300",
					data: {bkind:"notice", bno:300}, // 요청할 때 보낼 데이터 지정
					success: function(data) { // ajax 요청 성공시 실행할 이벤트 지정 (function)
						console.log(data);
						// data 를 id="ajaxResponseInclude" 인 태그에 html 로 출력 
						$("#ajaxResponseInclude").html(data);
					}
				});
				
				/* $.get("getMethodAjax", {bkind:"notice", bno:300}, function(data) {
							$("#ajaxResponseInclude").html(data);
				}); */
				
				console.log("~~~~~~");
			}
		</script>
	</head>
	
	<body>
		<!-- d-flex : row 방향 / vh: viewport 100%  -->
		<div class="d-flex flex-column vh-100">
			<%@ include file="/WEB-INF/views/common/header.jsp" %>
			<div class="flex-grow-1 m-2">
				<div class="d-flex row">
					<!-- category -->
					<div class="col-md-4">
						<%@ include file="/WEB-INF/views/common/menu.jsp" %>
					</div>
					
					<!-- content -->
					<div class="border col-md-8">
						<!-- #################################################### -->
						<div class="card">
							<div class="card-header">GET 방식</div>
								<form class="m-2" method="get" action="getMethod">
								<input type="hidden" name="chNum" value="ch02"/>
								   <div class="form-group mb-2">
								       <label for="bkind">bkind</label>
								       <input type="text" class="form-control" id="bkind" name="bkind" value="free">
								   </div>
								   
								   <div class="form-group mb-2">
								       <label for="bno">bno</label>
								       <input type="text" class="form-control" id="bno" name="bno" value="1">
								   </div>
								   <!-- 제출 버튼: 양식의 데이터를 서버로 보냄 -->
								   <!-- 
								   <input type="submit" value="GET방식" class="btn btn-info btn-sm"/>
								   <button type="submit" class="btn btn-info btn-sm">GET방식</button> 
								   -->
								   <input type="image" 
								   		  src="${pageContext.request.contextPath}/resources/image/submit_icon.png"
								   		  width="150"/>
								</form>
								
								<hr/>
								
								<button onClick="handleBtn1()" type="button" class="btn btn-success btn-sm">JavaScript로 요청</button>
								<button onClick="handleBtn2()" type="button" class="btn btn-success btn-sm">Ajax로 요청</button>
								
								<div id="ajaxResponseInclude" class="mt-2"></div>
								
								<div class="card-body">
							</div>
						</div>
						<!-- #################################################### -->
					
					</div>
				</div>
			</div>
		</div>
	</body>
</html>