<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<!-- include 이후 -->
	<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- css -->
	<link href="../resources/css/join.css" rel="stylesheet" type="text/css">
	
	<!-- js -->
	<script type="text/javascript" src="../resources/js/join.js"></script>
	<script type="text/javascript" src="../resources/js/searchadress.js"></script>
	
	<!-- 도로명주소 api -->
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	
	<!-- middle1 시작-->
	<br><br>
	<div id="middle1">
		<form id="join" method="post" enctype="multipart/form-data">
		<br><br>
		<h3>회원가입</h3>
		<br><br>
		<div id="middlein">
			<p class="p1">아이디(필수)</p>
			<input type="text" id="uid" name="uid" placeholder="ID를 입력 해 주세요" maxlength="20" required class="inputformid">
			&emsp;
			<input type="button" id="idolcheck" onclick="idolcheck()" value="중복체크" class="searchadress">
			<br>
			<label id="idchk">
			<p class="pp1">&nbsp;5~20자의 영문 소문자 사용 가능합니다.</p></label><br>
			
			<p class="p1">비밀번호(필수)</p>
			<input type="password" id="upw" name="upw" placeholder="PW를 입력 해 주세요" maxlength="20" required class="inputform">
			<br>
			<label id="pwchk">
			<p class="pp1">&nbsp;8~20자의 영문 대 소문자, 숫자, 특수문자를 사용하세요.</p></label><br>
			
			<p class="p1">비밀번호 재확인(필수)</p>
			<input type="password" id="repw" name="repw" placeholder="PW를 한번 더 입력 해 주세요" maxlength="16" required class="inputform">
			<br>
			<label id="repwchk">
			<p class="pp1">&nbsp;비밀번호를 한번 더 입력하세요.</p></label><br>
			<br>
			
			<p class="p1">이름(필수)</p>
			<input type="text" id="uname" name="uname" placeholder="이름을 입력 해 주세요" maxlength="10" required class="inputformid">
			&emsp;
			<br><br>
			
			<p class="p1">주소(필수)</p>
			<input type="text" id="uadress_num" name="uadress_num" placeholder="우편번호" required class="inputform2" readonly>
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;
			<input type="button" onclick="searchadressapi()" value="주소검색" class="searchadress">
			<br>
			<input type="text" id="uadress" name="uadress" placeholder="주소" required class="inputform" readonly>
			<br>
			<input type="text" id="uadress_detail" name="uadress_detail" placeholder="상세주소를 입력해주세요." required class="inputform">
			<br>
			<br>
			
			<p class="p1">이메일(필수)</p>
			<input type="text" id="uemail" name="uemail" placeholder="e-mail를 입력 해 주세요" required class="inputform">
			<br><br>
				
		</div><!-- middlein -->
		
		<hr width="400px">
		
		<br>
			<input type="button" value="회원가입 완료" class="join" onclick="join()">
			<br><br><br><br>
		</form>
	</div><!-- middle1 끝 -->
	
</div><!-- all 끝 -->

<!-- 최하단 부트스트랩 -->
<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		CopyRight &copy; 2020 speshase All Rights Reserved. </footer>

</body>
</html>