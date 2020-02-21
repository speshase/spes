<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
    
<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!-- include 이후 -->
	<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- css -->
	<link href="../resources/css/mainmenu/bestDetail.css" rel="stylesheet" type="text/css">
	
	<!-- js&jquery -->
	<script type="text/javascript" src="../resources/js/mainmenu/bestDetail.js"></script>
	
	<!-- middle1 시작 -->
	<br><br>
	<div id="middle1">
	<br><br>
	
	<div id="middle2">

		<!-- 게시글 테이블 시작 -->
		<div id="boardtable">
			<form id="bestform" method="get" enctype="multipart/form-data">
			<table class="table" width="100%">
			
				<c:choose>
				<c:when test="${sessionScope.uid=='admin'}">
				&nbsp;&nbsp;&nbsp;
				<input type="hidden" name="np" value="${detail.np}">
				<input type="submit" id="modify" class="modify" value="글수정">&nbsp;
				<input type="hidden" name="np" value="${detail.np}">
				<input type="button" class="delete" value="글삭제" onclick="bestDelete(${detail.np})">
				
				</c:when>
				<c:otherwise>
						
				</c:otherwise>
				</c:choose>
				
				<br>
			
				<tr>
				<th width="40%">제목</th>
				<th width="60%" colspan="4">${detail.bptitle}</th>
				</tr>
				
				<tr>
				<th rowspan="3" width="40%"><img src="display?bfile1=${detail.bfile1}" alt="Image Error" width="315px" height="400px"></th>
				<td colspan="2" width="20%">내용설명</td>
				<td colspan="2" width="40%">${detail.bptext}</td>
				</tr>
				
				<tr>
				<td colspan="2" width="20%">가격</td>
				<td></td>
				<td width="10%"><p style="font-size:120%; color:#ef0056;"><b>${detail.bpprice}</b>원</p></td>
				</tr>
				
				<tr>
				<td></td><td colspan="4"></td>
				</tr>

			</table>
			
			<input type="hidden" name="cfile1" value="${detail.bfile1}">
			<input type="hidden" name="ctitle" value="${detail.bptitle}">
			<input type="hidden" name="cpprice" value="${detail.bpprice}">
			<% String uid=(String)session.getAttribute("uid"); %>
			<input type="hidden" name="uid" value="${uid}">
			<div class="__count_range">
				<input class="countbtn"value="-" count_range="m" type="button">
				<input class="count" value="1" readonly name="count" size="1px">
				<input class="countbtn" value="+" count_range="p" type="button">
				&emsp;
				<input type="button" value="장바구니 담기" class="cartin" onclick="cartin(${detail.np})">
			</div>
			
			<br><br><br>
			<div>
			<img src="display?bfile1=${detail.bfile2}" alt="Image Error" width="1032px">
			</div>
			
		</form>
		</div>
	</div>
	<br><br>
	
	</div>
	
<!-- 최하단 부트스트랩 -->
<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		CopyRight &copy; 2020 speshase All Rights Reserved. </footer>
	
</body>
</html>