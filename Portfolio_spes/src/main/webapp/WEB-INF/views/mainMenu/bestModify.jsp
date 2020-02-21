<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
    
<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!-- include 이후 -->
	<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- css -->
	<link href="../resources/css/mainmenu/bestModify.css" rel="stylesheet" type="text/css">
	
	<!-- js&jquery -->
	

	<!-- middle1 시작 -->
	<br><br>
	<div id="middle1">
	<br><br>
	
	<div id="middle2">

		<!-- 게시글 테이블 시작 -->
		<div id="boardtable">
			<form action="bestModify" method="post" enctype="multipart/form-data">
			
			<c:choose>
				<c:when test="${sessionScope.uid=='admin'}">
					
			<table class="table" width="100%">
			
				&nbsp;&nbsp;&nbsp;<input type="submit" class="modify" value="수정완료">
				
				<br>
			
				<input type="hidden" name="np" value="${modify.np}">
			
				<tr>
				<th width="40%">제목</th>
				<th width="60%" colspan="5">
				<input type="text" name="bptitle" value="${modify.bptitle}" size="90%">
				</th>
				</tr>
				
				<tr>
				<th width="40%">썸네일 이미지 변경</th>
				<th width="60%" colspan="4">
				<input type="file" name="file1" id="a_img" value="${modify.bfile1}">
				<input type="hidden" name="file2" value="${modify.bfile1}">
				<div class="select_img1"><img src="" width="315px"/></div>
				</th>
				</tr>
				
				<tr>
				<th rowspan="3" width="40%">
				<img src="display?bfile1=${modify.bfile1}" alt="Image Error" width="315px" height="400px"></th>
				<td colspan="2" width="20%">내용설명</td>
				<td colspan="2" width="40%">
				<textarea name="bptext" cols="73%" rows="12%">${modify.bptext}</textarea>
				</td>
				</tr>
				
				<tr>
				<td colspan="2" width="20%">가격</td>
				<td width="10%"><p><input type="text" name="bpprice" value="${modify.bpprice}" size="10%"><b>원</b></p></td>
				</tr>
				
				<tr>
				<th width="40%">본문이미지 변경</th>
				<th width="60%" colspan="4">
				<input type="file" name="file2" id="b_img" value="${modify.bfile2}">
				<input type="hidden" name="file2" value="${modify.bfile2}">
				<div class="select_img2"><img src=""/></div>
				</th>
				</tr>
				
				<tr>
				<td></td><td colspan="4"></td>
				</tr>

			</table>
			
			<br><br><br>
		
			<img src="display?bfile1=${modify.bfile2}" alt="Image Error" width="1000px"></div>
			
			</c:when>
				<c:otherwise>
					<br><br><br>
					<center><p>관리자만 접근 가능한 페이지입니다.</p></center>
					<br><br><br>
				</c:otherwise>
			</c:choose>
			
		</form>
		</div>
	<script type="text/javascript" src="../resources/js/mainmenu/bestModify.js"></script>
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