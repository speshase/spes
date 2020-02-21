<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

	<!-- include 이후 -->
	<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- css -->
	<link href="../resources/css/login.css" rel="stylesheet" type="text/css">

	<!-- js&jquery -->
	<script src="https://code.jquery.com/jquery-1.11.3.js"></script>

	<br>
	
	<script type="text/javascript">
		var msg = '${msg}';
		if(msg != "") {
		alert(msg);
		}
	</script>
	
	<br>
	<div id="middle1">
		<form action="loginPost" method="post">
			<br><br>
			<h3>로그인 </h3>
			<br><br>
				<input type="text" name="uid" class="inputform" placeholder="아이디">
				<br>
				<input type="password" name="upw" class="inputform" placeholder="비밀번호">
				<br><br>
				<hr width="400px">
				<br>
				<input type="checkbox" name="useCookie" class="loginsession">&nbsp로그인 상태 유지
				<br>
				<input type="submit" value="로그인" class="loginenter">
				<br>
				<a href="agree" class="btn agree">회원가입</a><a href="userfind" class="btn userfind">아이디&비밀번호 찾기</a>
				<br><br><br>
		</form>
	</div><!-- middle1 끝 -->
</div><!-- all 끝 -->

<!-- 최하단 부트스트랩 -->
<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		CopyRight &copy; 2020 speshase All Rights Reserved. </footer>

</body>
</html>