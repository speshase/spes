<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!-- include 이후 -->
	<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- css -->
	<link href="../resources/css/mainmenu/coupon.css" rel="stylesheet" type="text/css">
	
	<!-- js&jquery -->

	<!-- middle1 시작 -->
	<br><br>
	<div id="middle1">
	<br><br>
	
	<div id="middle2">
	
	<!-- 게시글 테이블 시작 -->
	<div id="boardtable">
		<form action="couponWrite" method="get" enctype="multipart/form-data">
		
		<div>
			<hr>
			<div id="listTitle"><p id="tabletitle"><b>[할인/쿠폰상품]</b></p>
			
			<c:choose>
			<c:when test="${sessionScope.uid=='admin'}">
			<input type="submit" class="write" value="글등록">
			</c:when>
			<c:otherwise>
					
			</c:otherwise>
			</c:choose>
			</div>
			<br>

			<c:forEach items="${couponProduction}" var="cp">
			<div id="forContents">
			<a href=couponDetail?np=${cp.np}><img src="display?cfile1=${cp.cfile1}" alt="Image Error" width="315px" height="400px"></a><br>
			<a href=couponDetail?np=${cp.np} style="cursor:pointer" class="coupontitle"><p id="cptitle">${cp.cptitle}</p></a><br>
			<a href=couponDetail?np=${cp.np} style="cursor:pointer" class="coupontitle"><p id="cpprice"><b>${cp.cpprice}원</b></p></a>&nbsp;
			<a href=couponDetail?np=${cp.np} style="cursor:pointer" class="coupontitle"><p id="cppricedc"><b>${cp.cppricedc}원</b></p></a><br>
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