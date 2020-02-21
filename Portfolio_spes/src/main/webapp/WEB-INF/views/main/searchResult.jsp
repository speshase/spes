<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!-- include 이후 -->
	<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- css -->
	<link href="../resources/css/searchResult.css" rel="stylesheet" type="text/css">
	
	<!-- js&jquery -->
	<script type="text/javascript" src="../resources/js/searchResult.js"></script>

	
	<!-- middle1 시작 -->
	<br><br>
	<div id="middle1">
	<br><br>
	
	<div id="middle2">
	
	<!-- 게시글 테이블 시작 -->
	<div id="boardtable">
		<form action="bestWrite" method="get" enctype="multipart/form-data">
		
		<div>
			<hr>
			<div id="listTitle"><p id="tabletitle"><b>[검색상품]</b></p>
			</div>
			<br>

			<c:forEach items="${keyword}" var="k">
			<div id="forContents">
			<a href=../mainMenu/${k.cname}Detail?np=${k.np}><img src="../mainMenu/display?sfile1=${k.sfile1}" alt="Image Error" width="315px" height="400px"></a><br>
			<a href=../mainMenu/${k.cname}Detail?np=${k.np} style="cursor:pointer" class="searchtitle"><p id="bptitle">${k.nptitle}</p></a><br>
			<a href=../mainMenu/${k.cname}Detail?np=${k.np} style="cursor:pointer" class="searchtitle"><p id="bpprice"><b>${k.npprice}원</b></p></a><br>
			<br>
			</div>
			</c:forEach>
		</div>
		
		</form>
	</div>

	</div>

	<br><br><br><br>
	</div>
	

<!-- 최하단 부트스트랩 -->
<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		CopyRight &copy; 2020 speshase All Rights Reserved. </footer>
		
</body>
</html>