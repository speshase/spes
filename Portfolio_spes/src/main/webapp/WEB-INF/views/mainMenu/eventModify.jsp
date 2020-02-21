<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
    
<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!-- include 이후 -->
	<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- css -->
	<link href="../resources/css/mainmenu/eventModify.css" rel="stylesheet" type="text/css">
	
	<!-- js&jquery -->
	

	<!-- middle1 시작 -->
	<br><br>
	<div id="middle1">
	<br><br>
	
	<div id="middle2">

		<!-- 게시글 테이블 시작 -->
		<div id="boardtable">
			<form action="eventModify" method="post" enctype="multipart/form-data">
			
			<c:choose>
				<c:when test="${sessionScope.uid=='admin'}">
					
			<table class="table" width="100%">
			
				&nbsp;&nbsp;&nbsp;<input type="submit" class="modify" value="수정완료">
				
				<br>
			
				<input type="hidden" name="np" value="${modify.np}">
			
				<tr>
				<th width="40%">제목</th>
				<th width="60%" colspan="5">
				<input type="text" name="eptitle" value="${modify.eptitle}" size="90%" required>
				</th>
				</tr>
				
				<tr>
				<th width="40%">썸네일 이미지 변경</th>
				<th width="60%" colspan="4">
				<input type="file" name="file1" id="a_img" value="${modify.efile1}">
				<input type="hidden" name="file2" value="${modify.efile1}">
				<div class="select_img1"><img src="" width="315px"/></div>
				</th>
				</tr>
				
				<tr>
				<th colspan="4" width="40%" >
				<img src="display?efile1=${modify.efile1}" alt="Image Error" width="500px" height="170px"></th>
				</tr>
				
				<tr>
				<th width="40%">본문이미지 변경</th>
				<th width="60%" colspan="5">
				<input type="file" name="file2" id="b_img" value="${modify.efile2}">
				<input type="hidden" name="file2" value="${modify.efile2}">
				<div class="select_img2"><img src=""/></div>
				</th>
				</tr>
				
				<tr>
				<td></td><td colspan="4"></td>
				</tr>

			</table>
			
			<br><br><br>
		
			<img src="display?efile1=${modify.efile2}" alt="Image Error" width="1000px"></div>
			
			</c:when>
				<c:otherwise>
					<br><br><br>
					<center><p>관리자만 접근 가능한 페이지입니다.</p></center>
					<br><br><br>
				</c:otherwise>
			</c:choose>
			
		</form>
		</div>
	<script type="text/javascript" src="../resources/js/mainmenu/eventModify.js"></script>
	</div>
	<br><br>
	
	</div>
	
<!-- 최하단 부트스트랩 -->
<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		CopyRight &copy; 2020 speshase All Rights Reserved. </footer>
	
</body>	
</html>

</body>
</html>