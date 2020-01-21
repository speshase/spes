<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>

<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- css -->
	<link href="../resources/css/customerService/travisNews.css" rel="stylesheet" type="text/css">
	
	<!-- js&jquery -->
	<script type="text/javascript" src="../resources/js/customerService/questions&New.js"></script>

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
	
	<!-- 카테고리 -->
		<div id="qcategorycss">
			<select name="qcategory" id="qcategory" onchange="qcatogory();">
			<option >카테고리전체</option>
				<option name="qcategory" value="notice">공지</option>
				<option name="qcategory" value="event">이벤트</option>
				<option name="qcategory" value="delivery">배송문의</option>
				<option name="qcategory" value="coupon">쿠폰/할인</option>
				<option name="qcategory" value="memverinfo">회원정보문의</option>
				<option name="qcategory" value="serviceuse">서비스이용 및 기타</option>
			</select>
		</div>
		<br><br>
	</div>
	
	<!-- 게시글 테이블 -->
	<div id="boardtable">
	<form id="" method="get">
		<table class="table" width="100%">
		<thead>
			<tr>
				<tr>
					<th width="25%">번호</th> <th width="80%">제목</th>
				</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="board">           
			<tr>
			<td><a href=detail?no=${board.no}>${board.subject}</a></td>
			<td>${board.content}</td>
			</tr>
		</c:forEach> 
			<tr>
			<td colspan="5">
		<center>
			<c:if test="${page.prev}">
			<a href="list?pageNum=${page.startPage-10}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">Previous</a>
			</c:if>
                   		
			<c:forEach var="num" begin="${page.startPage}" end="${page.endPage}">
			<a href="list?pageNum=${num}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">${num}</a>
			</c:forEach>
	                   		
			<c:if test="${page.next}">
			<a href="list?pageNum=${page.endPage+1}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">Next</a>
			</c:if>
		</center>
			</td>
			</tr>
			
			<!-- 아이디가 관리자면 글쓰기가 보임 -->
			<c:choose>
				<c:when test="${sessionScope.uid=='admin'}">
					<tr>
					<td colspan="4"></td>
					<td><input type="submit" value="글쓰기" id="write" class="btn btn-primary"></td>
					</tr>
				</c:when>
				
				<c:otherwise>
					<tr>
					<td colspan="5"></td>
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