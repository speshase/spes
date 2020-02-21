<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- include 이후 -->
<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>

<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- css -->
<link href="../resources/css/customerService/customerWrite.css"
	rel="stylesheet" type="text/css">

<!-- js&jquery -->
<script type="text/javascript"
	src="../resources/js/customerService/questionsWrite.js"></script>

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
				<td colspan="3" width="33%"><a style="color: white;">고객의 소리 글쓰기</a></td>
			</tr>
		</table>
		<br>
		<br>
	</div>
	<!-- 미니메뉴 테이블 끝 -->

	<!-- 게시글 테이블 시작 -->
	<div id="boardtable">
		<form action="customerServiceWriteEnd" method="post"
			enctype="multipart/form-data">
			<table class="table" width="100%">

						<tr>
							<th width="10%">글번호</th>
							<td>자동입력</td>
						</tr>
						<tr>
							<th>글제목</th>
							<td><input type="text" name="csubject" required></td>
						</tr>
						<tr>
							<th>글내용</th>
							<td height="300px" name="ccontent">
							<textarea name="ccontent" cols="100%" rows="10%" required></textarea>
							</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td><input type="hidden" name="cuid" value="${sessionScope.uid}">${sessionScope.uid}</td>
						</tr>
						<tr>
							<th>작성날짜</th>
							<td>자동입력</td>
						</tr>
						
					<!-- 로그인했으면 글쓰기가 보임 -->
					<c:choose>
						<c:when test="${sessionScope.uid!=null || log==true}">

						<tr>
							<td colspan="2">
							<input type="submit" value="등록" class="write">
							</td>
						</tr>
					</c:when>

					<c:otherwise>
						<br><br><br>
						<center><p>로그인 하시면 글을 작성하실 수있습니다.</p></center>
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