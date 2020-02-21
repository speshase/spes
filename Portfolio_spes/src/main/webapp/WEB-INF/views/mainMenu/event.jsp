<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!-- include 이후 -->
	<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- css -->
	<link href="../resources/css/mainmenu/event.css" rel="stylesheet" type="text/css">
	
	<!-- js&jquery -->

	<!-- middle1 시작 -->
	<br><br>
	<div id="middle1">
	<br><br>
	
	<div id="middle2">
	
	<!-- 게시글 테이블 시작 -->
	<div id="boardtable">
		<form action="eventWrite" method="get" enctype="multipart/form-data">
		
		<div>
			<hr>
			<div id="listTitle"><p id="tabletitle"><b>[이벤트]</b></p>
			
			<c:choose>
			<c:when test="${sessionScope.uid=='admin'}">
			<input type="submit" class="write" value="글등록">
			</c:when>
			<c:otherwise>
					
			</c:otherwise>
			</c:choose>
			</div>
			<br>

			<c:forEach items="${eventProduction}" var="ep">
			<div id="forContents">
			<a href=eventDetail?np=${ep.np} style="cursor:pointer" class="eventtitle"><p id="eptitle">${ep.eptitle}</p></a><br>
			<a href=eventDetail?np=${ep.np}><img src="display?efile1=${ep.efile1}" alt="Image Error" width="1000px" height="310px"></a><br>
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