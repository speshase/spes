<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>

<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- css -->
	<link href="../resources/css/customerService/customerService.css" rel="stylesheet" type="text/css">
	
	<!-- js&jquery -->
	<script type="text/javascript" src="../resources/js/customerService/clist.js"></script>
	
	<!-- middle1 시작 -->
	<br><br>
	<div id="middle1">
	<br><br>
	<p class="tt" style="color:#ef0056;"><b>트라비스의 중심</b>은 항상 <b>고객님</b>입니다.</p>
	<p class="tb">트라비스를 이용하면서 느끼신 불편사항이나 바라는 점을 알려주세요.<br>
	고객님의 소중한 의견으로 한 뼘 더 자라는 트라비스가 되겠습니다.</p>
	<br><br>
	
	<div id="minimenu">
	<table class="minimenu">
		<tr>
			<td width="33%"><a href="http://localhost:8080/spes/customer/questionsList" style="color:white;">자주묻는 질문</a></td>
			<td width="33%"><a href="http://localhost:8080/spes/customer/customerService" style="color:white;">고객의 소리</a></td>
			<td width="33%"><a href="http://localhost:8080/spes/customer/travisNews" style="color:white;">트라비스 소식</a></td>
		</tr>
	</table>
	<br>
	</div>

	
	<!-- 게시글 테이블 시작 -->
	<div id="boardtable">
	<form id="customerServiceWrite" method="get" enctype="multipart/form-data">
		<table class="table" width="100%">
		<thead>
			<tr>
			<th width="10%">번호</th>
			<th width="60%">제목</th>
			<th width="10%">작성날짜</th>
			<th>답변여부</th>
			</tr>
		</thead>
		
		<tbody>        
		
		<tr>
		<td colspan="4"> 페이지 </td>
		</tr>
			
		<!-- 아이디가 관리자면 글쓰기가 보임 -->
		<c:choose>
			<c:when test="${sessionScope.uid=='admin'}">
				<tr>
				<td colspan="2" width="30%"><input type="submit" value="글쓰기" class="write"></td>
				</tr>
			</c:when>
			
			<c:otherwise>
				<tr>
				<td colspan="4"></td>
				<td></td>
				</tr>
			</c:otherwise>
		</c:choose>
		</tbody>
	</table>
	<br><br>
	</div> <!-- boardtable 종료 -->
	
	</div> <!-- miidle1 종료 -->


<!-- 최하단 부트스트랩 -->
<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		CopyRight &copy; 2020 speshase All Rights Reserved. </footer>
	
</html>