<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
							<div class="card-header">게시물 목록</div>
							<div class="card-body">
						      <table class="table table-sm table-bordered">
						         <tr>
						            <th style="width:30px">번호</th>
						            <th style="width:300px">제목</th>
						            <th style="width:70px">글쓴이</th>
						            <th style="width:70px">날짜</th>
						            <th style="width:70px">조회수</th>
						         </tr>
						         
						         <c:forEach var="board" items="${boardList}">
						            <tr>
						               <td>${board.bno}</td>
						               <td><a href="detailBoard?bno=${board.bno}">${board.btitle}</a></td>
						               <td>${board.mid}</td>
						               <td><fmt:formatDate value="${board.bdate}" pattern="yyyy-MM-dd"/></td>
						               <td>${board.bhitcount}</td>
						            </tr>
						         </c:forEach>
						         
						         <tr>
						            <td colspan="4" class="text-center">
						               <div>
						               	  <!-- 처음, 이전 -->
						               	  <!-- 처음을 누른 경우, 1페이지를 보여줘야 하니까, pageNo 를 1로 넘겨주기 -->
						                  <a class="btn btn-outline-primary btn-sm" href="boardList?pageNo=1">처음</a>
						                  <!--  1그룹인 경우에는 이전 페이지가 존재하지 않음 , 
						                  if 문을 사용해서 1그룹 보다 클 경우에만 이전 버튼 보이게 하기
						                  	그리고, 이전 그룹의 끝 페이지로 이동해야함 -->
						                  <c:if test="${pager.groupNo>1}">
						                     <a class="btn btn-outline-info btn-sm" href="boardList?pageNo=${pager.startPageNo-1}">이전</a>
						                  </c:if>
						                  
						                  <!-- 번호 부여 -->
						                  <c:forEach var="i" begin="${pager.startPageNo}" end="${pager.endPageNo}">
						                     <c:if test="${pager.pageNo != i}">
						                        <a class="btn btn-outline-success btn-sm" href="boardList?pageNo=${i}">${i}</a>
						                     </c:if>
						                     <!-- 현재 페이지가 i 쪽이면, 강조된 모양 (danger)으로 다르게 표시  -->
						                     <c:if test="${pager.pageNo == i}">
						                        <a class="btn btn-danger btn-sm" href="boardList?pageNo=${i}">${i}</a>
						                     </c:if>
						                  </c:forEach>
						                  
						                  <!-- 다음, 맨끝 -->
						                  <!-- 
						                   	다음이 사라지는 경우에는 맨 마지막 그룹일때는 다음 버튼이  존재하지 않음
						                   	맨 마지막 그룹보다 적을 경우에만 다음 버튼이 나오게 함
						                   	
						                   	다음을 누른 경우에는, 현재 마지막 페이지 그룹에다가 + 1을 해줌  -->
						                  <c:if test="${pager.groupNo<pager.totalGroupNo}">
						                     <a class="btn btn-outline-info btn-sm" href="boardList?pageNo=${pager.endPageNo+1}">다음</a>
						                  </c:if>
						                  
						                  <!-- 전체 페이지 넘버를 넣어서, 맨 마지막 페이지를 나타나게 함 -->
						                  <a class="btn btn-outline-primary btn-sm" href="boardList?pageNo=${pager.totalPageNo}">맨끝</a>
						               </div>
						            </td>
						         </tr>
						      </table>					      			
							</div>
						</div>
						<!-- ###################################### -->
					</div>
				</div>
			</div>
		</div>
	</body>
</html>