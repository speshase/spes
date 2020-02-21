<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!-- include 이후 -->
	<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- 5초뒤에 자동으로 메인페이지로갑니다. -->
	<meta http-equiv="refresh" content="4; url=http://localhost:8080/spes">
	
	<!-- css -->
	<link href="../resources/css/joinend.css" rel="stylesheet" type="text/css">
	
	<div id="middle1">
	
	<br>
	<br>
	<br>
	
	<center>
		<img src="../resources/img/congratulation.png" width="100%">
	</center>
	
	</div>
	
<!-- 최하단 부트스트랩 -->
<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		CopyRight &copy; 2020 speshase All Rights Reserved. </footer>

</body>
</html>