<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- include 이후 -->
<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>

<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- css -->
<link href="../resources/css/customerService/customerModify.css"
	rel="stylesheet" type="text/css">

<!-- js&jquery -->
<script type="text/javascript"
	src="../resources/js/customerService/customerService.js"></script>

<!-- middle1 시작 -->
<br>
<br>
<div id="middle1">
	<br>
	<br>
	<br>

	<!-- 미니메뉴 테이블 -->
	<div id="minimenu">
		<table class="minimenu">
			<tr>
				<td colspan="3" width="33%"><a style="color: white;">고객의 소리 글수정</a></td>
			</tr>
		</table>
		<br>
		<br>
	</div>
	<!-- 미니메뉴 테이블 끝 -->

	<!-- 게시글 테이블 시작 -->
	<div id="boardtable">
		<form action="customerServiceModifyEnd" method="post"
			enctype="multipart/form-data">
			<table class="table" width="100%">

						<tr>
							<th width="10%">글번호</th>
							<td><input type="hidden" name="cno" value="${modify.cno}" readonly>${modify.cno}</td>
						</tr>
						<tr>
							<th>글제목</th>
							<td><input type="text" name="csubject" value="${modify.csubject}" size="100" required></td>
						</tr>
						<tr>
							<th>글내용</th>
							<td height="300px"><textarea name="ccontent" cols="100%" rows="10" required>${modify.ccontent}</textarea></td>
						</tr>
						<tr>
							<th>작성자</th>
							<td>${modify.cuid}</td>
						</tr>
						<tr>
							<th>작성날짜</th>
							<td>${modify.cwrite_date}</td>
						</tr>
						
					<!-- 아이디가 관리자면 글수정과 글삭제가 보임 -->
					<c:choose>
						<c:when test="${sessionScope.uid!=null || log==true}">

						<tr>
							<td colspan="2">
                      			<input type="submit" value="완료" class="modify">
                      		</td>
						</tr>
					</c:when>

					<c:otherwise>
						<br><br><br>
						<center><p>로그인 하시면 글을 수정 · 삭제하실 수있습니다.</p></center>
						<br><br><br>
					</c:otherwise>

				</c:choose>

			</table>

			<br>
			<br>
			<br>
		</form>
	</div>
	<!-- boardtable 종료 -->

</div>
<!-- miidle1 종료 -->

<!-- 최하단 부트스트랩 -->
<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
	CopyRight &copy; 2020 speshase All Rights Reserved. </footer>
	
	</body>
</html>