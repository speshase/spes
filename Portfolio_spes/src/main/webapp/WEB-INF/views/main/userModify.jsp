<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!-- include 이후 -->
	<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- css -->
	<link href="../resources/css/userModify.css" rel="stylesheet" type="text/css">
	
	<!-- js -->
	<script type="text/javascript" src="../resources/js/userModify.js"></script>
	<script type="text/javascript" src="../resources/js/searchadress.js"></script>
	
	<!-- 도로명주소 api -->
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	
	<!-- middle1 시작-->
	<br><br>
	<div id="middle1">
		<form id="userModify" method="post" enctype="multipart/form-data">
		
		<c:choose>
			<c:when test="${sessionScope.uid!=null || log==true}">
			
		<br><br>
		<h3>회원정보 수정</h3>
		<br><br>
		<div id="middlein">
			<p class="p1">아이디(변경불가)</p>
			<input type="text" id="uid" name="uid" value="${user.uid}" maxlength="20" required class="inputform" readonly>
			&emsp;
			<br><br>
			
			<p class="p1">비밀번호 확인(변경가능)</p>
			<input type="password" id="upw" name="upw" placeholder="PW를 입력 해 주세요" maxlength="20" required class="inputform">
			<br>
			<label id="pwchk">
			<p class="pp1">&nbsp8~20자의 영문 대 소문자, 숫자, 특수문자를 사용하세요.</p></label><br>
			
			<p class="p1">비밀번호 재확인(변경가능)</p>
			<input type="password" id="repw" placeholder="PW를 입력 해 주세요" maxlength="16" required class="inputform">
			<br>
			<label id="repwchk">
			<p class="pp1">&nbsp비밀번호를 한번 더 입력하세요.</p></label><br>
			
			<p class="p1">주소(변경가능)</p>
			<input type="text" id="uadress_num" name="uadress_num" value="${user.uadress_num}" required class="inputform2" readonly>
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;
			<input type="button" onclick="searchadressapi()" value="주소검색" class="searchadress">
			<br>
			<input type="text" id="uadress" name="uadress" value="${user.uadress}" required class="inputform" readonly>
			<br>
			<input type="text" id="uadress_detail" name="uadress_detail" value="${user.uadress_detail}" required class="inputform">
			<br>
			<br>
			<p class="p1">이메일(변경가능)</p>
			<input type="text" id="uemail" name="uemail" value=<c:out value="${user.uemail}"/> required class="inputform">
			<br><br>
				
		</div><!-- middlein -->
		
		<hr width="400px">
		
		<br>
			<input type="button" value="회원정보수정" class="modify" onclick="userModify()">
			<br><br><br>
			<a class="pp" onclick="userleave()" style="cursor:pointer">회원탈퇴를 하시려면 여기를 클릭하세요.</a><br>
			<br><br><br><br>
			
			</c:when>
			
			<c:otherwise>
				<br><br><br>
				<p><center>로그인 후 사용하실 수 있는 메뉴입니다.</center></p>
				<br><br><br>
			</c:otherwise>
		</c:choose>
		
		</form>
	</div><!-- middle1 끝 -->
	
</div><!-- all 끝 -->

<!-- 최하단 부트스트랩 -->
<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		CopyRight &copy; 2020 speshase All Rights Reserved. </footer>
		
</body>
</html>