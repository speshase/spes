<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

	<!-- include 이후 -->
	<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- css -->
	<link href="../resources/css/pwModify.css" rel="stylesheet" type="text/css">

	<!-- js&jquery -->
	<script type="text/javascript" src="../resources/js/pwModify.js"></script>
	
	<div id="middle1">
		<form id="pwModify" method="post">
			<br><br>
			<h3>비밀번호 변경 </h3>
			<br><br>
			<div id="middlein">
			<p class="p1">아이디(변경불가)</p>
				<input type="text" id="uid" name="uid" class="inputform" value="${uid}" readonly>
				<br><br>
				<p class="p1">비밀번호(필수)</p>
				<input type="password" id="upw" name="upw" placeholder="변경하실 PW를 입력 해 주세요" maxlength="20" required class="inputform">
				<br>
				<label id="pwchk">
				<p class="pp1">&nbsp;8~20자의 영문 대 소문자, 숫자, 특수문자를 사용하세요.</p></label><br><br>
				<p class="p1">비밀번호 재확인(필수)</p>
				<input type="password" id="repw" name="repw" placeholder="PW를 한번 더 입력 해 주세요" maxlength="16" required class="inputform">
				<br>
				<label id="repwchk">
				<p class="pp1">&nbsp;비밀번호를 한번 더 입력하세요.</p></label><br><br>
				<input type="button" value="비밀번호 재설정 완료"  class="btn pwModify"  onclick="pwModify()">
				<br><br>
			</div><!-- middlein -->
			<br><br>
		</form>
	</div><!-- middle1 끝 -->

<!-- 최하단 부트스트랩 -->
<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		CopyRight &copy; 2020 speshase All Rights Reserved. </footer>

</body>
</html>