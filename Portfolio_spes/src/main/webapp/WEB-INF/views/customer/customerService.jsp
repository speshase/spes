<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>

<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- css -->
	<link href="../resources/css/customerService/clist.css" rel="stylesheet" type="text/css">
	
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
			<td width="33%"><a href="#" style="color:white;">자주묻는 질문</a></td>
			<td width="33%"><a href="#" style="color:white;">고객의 소리</a></td>
			<td width="33%"><a href="#" style="color:white;">쿠팡소식</a></td>
		</tr>
	</table>
	<br>
	</div>
	
	<!-- 테이블 시작 -->
	<div id="boardtable">
	<form id="" method="get">
		<table class="table">
		<thead>
			<tr>
			<th width="12%">글번호</th>
			<th>글제목</th>
			<th width="15%">작성자</th>
			<th width="17%">작성날짜</th>
			<th width="12%">조회수</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="board">           
			<tr>
			<td>${board.no}</td>
			<td><a href=detail?no=${board.no}>${board.subject}</a></td>
			<td>${board.writer}</td>
			<td>${board.write_date}</td>
			<td>${board.cnt}</td>
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
			<tr>
			<td colspan="4"></td>
			<td><input type="submit" value="글쓰기" id="write" class="btn btn-primary"></td>
			</tr>
		</tbody>
	</table>
	<br><br>
	</div> <!-- boardtable 종료 -->
	
	</div> <!-- miidle1 종료 -->


<!-- 최하단 부트스트랩 -->
<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		CopyRight &copy; 2020 speshase All Rights Reserved. </footer>
	
</html>