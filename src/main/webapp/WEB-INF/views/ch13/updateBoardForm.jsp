<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>

<!-- Bootstrap 5를 위한 외부 라이브러리 설정-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- jQuery 외부 라이브러리 설정 -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>

<!--사용자 정의 스크립트 -->
<script type="text/javascript">
	
</script>
</head>

	<body>
		<div class="d-flex flex-column vh-100">
			<%@ include file="/WEB-INF/views/common/header.jsp"%>
			<div class="flex-grow-1 m-2">
				<div class="d-flex row">
					<div class="col-md-4">
						<%@ include file="/WEB-INF/views/common/menu.jsp"%>
					</div>
	
					<div class="col-md-8">
						<!-- ###################################### -->
						<div class="card">
							<div class="card-header">게시물 수정</div>
							<div class="card-body">
						      <form id="updateBoardForm" method="post" action="updateBoard" enctype="multipart/form-data">
						         <div class="input-group">
						        	 <!-- bno 는 수정 못하도록 readonly 설정 추가 -->
						            <div class="input-group-prepend"><span class="input-group-text">bno</span></div>
						            <input id="bno" type="text" name="bno" class="form-control" readonly value="${board.bno}"/>
						         </div>
						         <!-- 디폴트값으로 value 속성을 추가해 기존 값을 넣어줌 -->
						         <div class="input-group mt-2">
						            <div class="input-group-prepend"><span class="input-group-text">btitle</span></div>
						            <input id="btitle" type="text" name="btitle" class="form-control" value="${board.btitle}">
						         </div>
						         
						         <div class="input-group mt-2">
						            <div class="input-group-prepend"><span class="input-group-text">bcontent</span></div>
						            <textarea id="bcontent" name="bcontent" class="form-control">${board.bcontent}</textarea>
						         </div>
						         
						         <div class="input-group mt-2">
						            <div class="input-group-prepend"><span class="input-group-text">battach</span></div>
						            <input id="battach" type="file" name="battach" class="form-control">
						         	<c:if test="${board.battachoname != null}">
						         		<img src="attachDownload?bno=${board.bno}" width="150px"/>
						         	</c:if>
						         </div>
						            
						         <div class="mt-3">
						            <button type="submit" class="btn btn-info btn-sm me-2">글수정</button>
						            <a class="btn btn-info btn-sm" href="boardList">목록</a>
						         </div>
						      </form>								
							</div>
						</div>
						<!-- ###################################### -->
					</div>
				</div>
			</div>
		</div>
	</body>
</html>