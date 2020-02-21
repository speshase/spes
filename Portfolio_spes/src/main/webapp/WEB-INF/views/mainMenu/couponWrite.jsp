<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!-- include 이후 -->
	<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- css -->
	<link href="../resources/css/mainmenu/couponWrite.css" rel="stylesheet" type="text/css">
	
	<!-- js&jquery -->
	

	<!-- middle1 시작 -->
	<br><br>
	<div id="middle1">
	<br><br>
	
	<!-- 미니메뉴 테이블 -->
		<div id="minimenu">
			<table class="minimenu">
				<tr>
					<td colspan="3" width="33%"><a style="color: white;">(관리자페이지) 할인/쿠폰상품 글쓰기</a></td>
				</tr>
			</table>
			<br>
			<br>
		</div>
		<!-- 미니메뉴 테이블 끝 -->

		<!-- 게시글 테이블 시작 -->
		<div id="boardtable">
			<form action="coupon" method="post" enctype="multipart/form-data">
			<table class="table" width="100%">
		
		<!-- 아이디가 관리자면 글수정과 글삭제가 보임 -->
		<c:choose>
			<c:when test="${sessionScope.uid=='admin'}">
			
			&nbsp;&nbsp;&nbsp;<input type="submit" class="write" value="등록">
				
				<br><br>
			
				<tr>
				<th width="10%">글번호</th>
				<td width="30%">자동입력</td>
				<input type="hidden" name="cname" value="coupon">
				</tr>
				
				<tr>
				<th>기존가격</th>
				<td><input type="text" name="cpprice" size="10%" required>원</td>
				</tr>
				
				<tr>
				<th>할인가격</th>
				<td><input type="text" name="cppricedc" size="10%" required>원</td>
				</tr>
				
				<tr>
				<th>글제목</th>
				<td><input type="text" name="cptitle" size="50%" required></td>
				</tr>
				
				<tr>
				<th>글내용</th>
				<td height="30%">
				<textarea name="cptext" cols="100%" rows="10%" required></textarea>
				</td>
				</tr>
				
				<tr>
				<th>썸네일 이미지</th>
				<td><input type="file" name="file1" id="a_img" required>
				<div class="select_img1"><img src=""/></div>
            	</td>
				</tr>
				
				<tr>
				<th>본문 이미지</th>
				<td><input type="file" name="file2" id="b_img" required>
				<div class="select_img2"><img src=""/></div>
            	</td>
				</tr>
				
			</c:when>
			
			<c:otherwise>
				<br><br><br>
				<center><p>관리자만 접근 가능한 페이지입니다.</p></center>
				<br><br><br>
			</c:otherwise>
				
			</c:choose>
										
			</table>
			
			<br><br><br>
		</form>
		</div>
	<script type="text/javascript" src="../resources/js/mainmenu/couponWrite.js"></script>
	</div>
	<br><br>

</body>
</html>