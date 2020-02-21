<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- include 이후 -->
<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>

	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- css -->
	<link href="../resources/css/mypage/coupon2.css" rel="stylesheet" type="text/css">
	
	<!-- js&jquery = 최하단-->

<!-- middle1 시작 -->
<br><br>
<div id="middle1">
		<br><br>
	<div id="middle2">
		<div id="minimenu">
		<table class="minimenu">
			<tr>
				<td width="25%"><a href="http://localhost:8080/spes/mypage/delivery" style="color:white;">배송조회</a></td>
				<td width="25%"><a href="http://localhost:8080/spes/mypage/cart" style="color:white;">장바구니</a></td>
				<td width="25%"><a href="http://localhost:8080/spes/mypage/review" style="color:white;">상품후기</a></td>
				<td width="25%"><a href="http://localhost:8080/spes/mypage/coupon2" style="color:white;">▶쿠폰◀</a></td>
			</tr>
		</table>
		</div>
		
		<br><br><br>
		<p><center>준비중인 서비스입니다. 빠른시일 내에 찾아뵙도록 하겠습니다.</center></p>
		<br><br><br>

		<br><br>
	</div>
</div>


<!-- 최하단 부트스트랩 -->
<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		CopyRight &copy; 2020 speshase All Rights Reserved. </footer>
		
</body>
</html>