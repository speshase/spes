<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- include 이후 -->
<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>

<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- css -->
	<link href="../resources/css/customerService/travisNewsModify.css" rel="stylesheet" type="text/css">
	
	<!-- js&jquery -->
	<script type="text/javascript" src="../resources/js/customerService/travisNews.js"></script>
	
	<!-- middle1 시작 -->
	<br><br>
	<div id="middle1">
	<br><br><br>
	
	<!-- 미니메뉴 테이블 -->
		<div id="minimenu">
		<table class="minimenu">
			<tr>
				<td colspan="3" width="33%"><a style="color:white;">(관리자페이지) 자주묻는 질문 글수정</a></td>
			</tr>
		</table>
		<br><br>
	</div> <!-- 미니메뉴 테이블 끝 -->

	<!-- 게시글 테이블 시작 -->
	<div id="boardtable">
	<form action="travisNewsModifyEnd" method="post" enctype="multipart/form-data">
		<table class="table" width="100%">

		<!-- 아이디가 관리자면 글수정과 글삭제가 보임 -->
		<c:choose>
			<c:when test="${sessionScope.uid=='admin'}">
	
				<tr>
				<th width="10%">글번호</th>
				<td width="30%"><input type="hidden" name="nno" value="${modify.nno}" readonly>${modify.nno}</td>
				</tr>
				
				<tr>
				<th>영어카테고리</th>
				<td>
				<div id="ncategorycss">
					<select name="ncategory" required>
						<option>${modify.ncategoryk}</option>
						<option value="notice">notice</option>
						<option value="event">event</option>
					</select>
				</div>
				</td>
				</tr>
				
				<tr>
				<th>한글카테고리</th>
				<td>
				<div id="ncategorycss">
					<select name="ncategoryk" required>
						<option>${modify.ncategory}</option>
						<option value="공지">공지</option>
						<option value="이벤트">이벤트</option>
					</select>
				</div>
				</td>
				</tr>
				
				<tr>
				<th>글제목</th>
				<td><input type="text" name="nsubject" size="50%" value="${modify.nsubject}" required></td>
				</tr>
				
				<tr>
				<th>글내용</th>
				<td height="30%">
				<textarea name="ncontent" cols="100%" rows="10%" required>${modify.ncontent}</textarea>
				</td>
				</tr>
				
				<tr>
				<td colspan="2"><input type="submit" value="완료" class="modify"></td>
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
	</div> <!-- boardtable 종료 -->
	
	</div> <!-- miidle1 종료 -->

<!-- 최하단 부트스트랩 -->
<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		CopyRight &copy; 2020 speshase All Rights Reserved. </footer>
		
	</body>
</html>