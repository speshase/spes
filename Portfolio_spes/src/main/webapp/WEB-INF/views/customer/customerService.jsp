<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- include 이후 -->
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
			<td width="33%"><a href="http://localhost:8080/spes/customer/customerService" style="color:white;">▶고객의 소리◀</a></td>
			<td width="33%"><a href="http://localhost:8080/spes/customer/travisNewsList" style="color:white;">트라비스 소식</a></td>
		</tr>
	</table>
	<br>
	</div>

	
	<!-- 게시글 테이블 시작 -->
	<div id="boardtable">
	<form action="customerServiceWrite" method="get" enctype="multipart/form-data">
		<table class="table" width="100%">

		<!-- 로그인 상태면 글쓰기가 보임 -->
		<c:choose>
			<c:when test="${sessionScope.uid!=null || log==true}">
				
		<thead>
			<tr>
			<th width="15%">번호</th>
			<th width="55%">제목</th>
			<th width="30%">작성날짜</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${customerService}" var="cservice">        
			<tr>
			<td>${cservice.cno}</td>
			<td><a href=customerServiceDetail?cno=${cservice.cno}>${cservice.csubject}</a></td>
			<td>${cservice.cwrite_date}</td>
			</tr>
		</c:forEach>
	<tr>
	<td colspan="3">
		<center>
			<c:if test="${page.prev}">
				<a href="customerService?pageNum=${page.startPage-10}&amount=${page.cri.amount}">[이전]</a>
			</c:if>
                 		
			<c:forEach var="num" begin="${page.startPage}" end="${page.endPage}">
				<a href="customerService?pageNum=${num}&amount=${page.cri.amount}">${num}&emsp;</a>
			</c:forEach>
	                   		
			<c:if test="${page.next}">
				<a href="customerService?pageNum=${page.endPage+1}&amount=${page.cri.amount}">[다음]</a>
			</c:if>
		</center>
	</td>
	</tr>
		<tr>
			<td colspan="2"></td>
			<td width="30%"><input type="submit" value="글쓰기" class="write"></td>
		</tr>
			</c:when>
			
			<c:otherwise>
				<br><br><br>
				<p><center>로그인 하시면 글을 작성 · 확인하실 수 있습니다.</center></p>
				<br><br><br>
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

</body>
</html>