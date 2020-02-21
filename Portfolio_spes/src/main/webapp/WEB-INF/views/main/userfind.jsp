<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

	<!-- include 이후 -->
	<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- css -->
	<link href="../resources/css/userfind.css" rel="stylesheet" type="text/css">

	<!-- js&jquery -->
	<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="../resources/js/userfind.js"></script>
	
	<br>
	<div id="middle1">
	<br><br><br>
	<div id="boardtable">
		<form id="userfind" method="post">
		<table>
			<tr>
				<th><h3>아이디 찾기<br></h3></th>
				<th><h3>비밀번호 찾기<br></h3></th>
			</tr>
			<tr>
				<td>&emsp;</td>
				<td>&emsp;</td>
			</tr>
			<tr>
				<td><p class="p1">이　름</p></td>
				<td><p class="p1">아이디</p></td>
			</tr>
			<tr>
				<td><input type="text" name="uname" value="${uname}" class="inputform" placeholder="이름을 입력하세요"></td>
				<td><input type="text" name="uid" value="${uid}" class="inputform" placeholder="아이디를 입력하세요"></td>
			</tr>
			<tr>
				<td><p class="p1">이메일</p></td>
				<td><p class="p1">이메일</p></td>
			</tr>
			<tr>
				<td><input type="text" name="uemail1" value="${uemail}" class="inputform" placeholder="이메일을 입력하세요"></td>
				<td><input type="text" name="uemail2" value="${uemail}"  class="inputform" placeholder="이메일을 입력하세요"></td>
			</tr>
			<tr>
				<td><hr width="400px"></td>
				<td><hr width="400px"></td>
			</tr>
			<tr>
				<td><input type="button" value="아이디 찾기" class="findid" onclick="findid()"></td>
				<td><input type="button" value="비밀번호 찾기 (이메일 인증번호 전송)" class="findpw" onclick="findpw()"></td>
			</tr>
		</table>
	</div>
			
	<div id="checkEmail" class="showInput" style ="display:none">
		<table id="checkEmail" method="get">
			<tr>
				<td></td>
				<td>이메일 인증</td>
			</tr>
			<tr>
				<td>&emsp;</td>
				<td>
				<input type="text" name="inputNum" value="" class="inputform2">
				<input type="button" id="checkNum" value="인증번호 확인" class="checkEmail">
				</td>
			</tr>
			<tr>
				<td>&emsp;</td>
				<td>&emsp;</td>
			</tr>
		</table>
	</div>
	</form>
			<br><br>
	</div><!-- middle1 끝 -->
	
<!-- 최하단 부트스트랩 -->
<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		CopyRight &copy; 2020 speshase All Rights Reserved. </footer>

</body>
</html>