<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Insert title here</title>
      
      <!-- Bootstrap 5 외부 라이브러리 설정 -->
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>   
      
      <!-- jQuery 외부 라이브러리 설정 -->
      <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
      
      <!-- 사용자 정의 자바스크립트 -->
      <script>
      	function handleBtn1() {
      		//파일 정보를 JSON 으로 받기 1 
      		console.log("handleBtn1() 실행");
      		
      		$.ajax({
      			url: "objectReturnJson1",
      			type: "get",
      			success: function(data) {
      				console.log(data);
      			}
      		});
      	}
      	
      	function handleBtn2() {
      		// 파일 정보를 JSON 으로 받기 2
      		console.log("handleBtn2() 실행");
      		
      		$.ajax({
      			url: "objectReturnJson2",
      			type: "get",
      			success: function(data) {
      				console.log(data);
      			}
      		});
      	}
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
                     <div class="card-header">Object 리턴</div>
                     <div class="card-body">
                     	<button onClick="handleBtn1()" class="btn btn-info btn-sm">파일 정보를 JSON으로 받기1</button>
                     	<button onClick="handleBtn2()" class="btn btn-warning btn-sm">파일 정보를 JSON으로 받기2</button>
                     </div>
                  </div>
                  <!-- ###################################### -->
               </div>
            </div>
         </div>
      </div>
   </body>
</html>