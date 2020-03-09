<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- include 이후 -->
<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>

<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- css -->
	<link href="../resources/css/customerService/travisNews.css" rel="stylesheet" type="text/css">
	
	<!-- js&jquery -->
	<script type="text/javascript" src="../resources/js/customerService/travisNews.js"></script>

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
				<td width="33%"><a href="/spes/customer/questionsList" style="color:white;">자주묻는 질문</a></td>
				<td width="33%"><a href="/spes/customer/customerService" style="color:white;">고객의 소리</a></td>
				<td width="33%"><a href="/spes/customer/travisNewsList" style="color:white;">▶트라비스 소식◀</a></td>
			</tr>
		</table>
		<br>
	
	<!-- 카테고리 <div id="travisNewscss"> -->
		<div id="travisNewscss">
		<form id="travisNewsListForm">
			<select name="ncategory">
			<option value="">카테고리선택</option>
				<option value="notice">공지</option>
				<option value="event">이벤트</option>

			</select>
			</form>
		</div>
		<br><br>
	</div> <!-- 미니메뉴 테이블 끝 -->

	<!-- 게시글 테이블 시작 -->
	<div id="boardtable">
	<form action="travisNewsWrite" id="travisNewsForm">
		<table class="table" width="100%">
		
		<!-- 아이디가 관리자면 글수정과 글삭제가 보임 -->
		<c:choose>
			<c:when test="${sessionScope.uid=='admin'}">
				<thead>
					<tr>
					<th width="25%">카테고리</th>
					<th>제목</th>
					<th width="30%">관리</th>
					</tr>
				</thead>
		
				<tbody>
					<c:forEach items="${travisNewsList}" var="news">        
					<tr>
					<td>${news.ncategoryk}</td>
					<td>
						<a class="content" onclick="travisNewsShow(${news.nno})">${news.nsubject}&emsp;</a>
					</td>
					<td>
					<!-- a태그에 번호값을 넣어서 href를 통해서 controller로 보냄 -->
						<button value="수정" class="modify"><a class="modify2" href="travisNewsModify?nno=${news.nno}">수정</a></button>

					<!-- input button태그에 해당 값을 onclick함수에 담아서 js로 보냄_ajax사용 -->
						<input type="button" class="delete" onclick="travisNewsDelete(${news.nno})" value="삭제">
					</td>
					</tr>
					
					<tr>
					<td></td>
					<td>
						<div id="dis${news.nno}" class="contentt${news.nno}" style ="display:none"><center><p class="ncontent">${news.ncontent}</p></center></div>
					</td>
					<td></td>
					</tr>
					</c:forEach>
				</c:when>
			
				<c:otherwise>
				<thead>
					<tr>
					<th width="25%">카테고리</th>
					<th width="75%">제목</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${travisNewsList}" var="news">        
					<tr>
					<td>${news.ncategoryk}</td>
					<td><a class="content" onclick="travisNewsShow(${news.nno})">${news.nsubject}&emsp;</a></td>
					</tr>
					<tr>
					<td></td>
					<td>
					<div id="dis${news.nno}" class="contentt${news.nno}" style ="display:none"><center><p class="ncontent">${news.ncontent}</p></center></div>
					</td>
					</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<tr>
			<td colspan="3">
				<center>
					<c:if test="${page.prev}">
						<a href="travisNewsList?pageNum=${page.startPage-10}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">[이전]</a>
					</c:if>
                   		
					<c:forEach var="num" begin="${page.startPage}" end="${page.endPage}">
						<a href="travisNewsList?pageNum=${num}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">${num}&emsp;</a>
					</c:forEach>
	                   		
					<c:if test="${page.next}">
						<a href="travisNewsList?pageNum=${page.endPage+1}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">[다음]</a>
					</c:if>
				</center>
			</td>
			</tr>
			
			<!-- 아이디가 관리자면 글쓰기가 보임 -->
			<c:choose>
				<c:when test="${sessionScope.uid=='admin'}">
					<tr>
					<td><input type="submit" value="글쓰기" class="write"></td>
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
	</form>
	</div> <!-- boardtable 종료 -->
	
	</div> <!-- miidle1 종료 -->
	
	
<!-- 최하단 부트스트랩 -->
<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		CopyRight &copy; 2020 speshase All Rights Reserved. </footer>
	
	</body>
</html>