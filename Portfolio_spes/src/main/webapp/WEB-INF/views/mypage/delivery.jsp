<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!-- include 이후 -->
	<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>

	<!-- css -->
	<link href="../resources/css/mypage/delivery.css"
		rel="stylesheet" type="text/css">
	
	<!-- js&jquery -->
	<script type="text/javascript"
		src="../resources/js/mypage/delivery.js"></script>

<!-- middle1 시작 -->
<br><br>
<div id="middle1">
		<br><br>
	
	<div id="middle2">
		<div id="minimenu">
		<table class="minimenu">
			<tr>
				<td width="25%"><a href="/spes/mypage/delivery" style="color:white;">▶배송조회◀</a></td>
				<td width="25%"><a href="/spes/mypage/cart" style="color:white;">장바구니</a></td>
				<td width="25%"><a href="/spes/mypage/review" style="color:white;">상품후기</a></td>
				<td width="25%"><a href="/spes/mypage/coupon2" style="color:white;">쿠폰</a></td>
			</tr>
		</table>
		<br>
		</div>
		<div id="table">
		<div id="formcenter">
	
		<p class="tt">현재 <b>배송중</b>인 상품만 <b>조회</b>가 가능합니다.</p>
		<p class="tb"><b>운송장 번호</b>를 입력해주세요.<br><br><br>
	
		<form id=name="door_to_door_frm" onSubmit="doorToDoorSearch();return false;">
			  <select name="dtd_select" id="dtd_select">
			    <option value="경동택배" selected>경동택배</option>
			    <option value="대신택배">대신택배</option>
			    <option value="대한통운">대한통운</option>
			    <option value="동부익스프레스">동부익스프레스</option>
			    <option value="로젠택배">로젠택배</option>
			    <option value="우체국택배">우체국택배</option>
			    <option value="이노지스택배">이노지스택배</option>
			    <option value="일양로지스택배">일양로지스택배</option>
			    <option value="하나로택배">하나로택배</option>
			    <option value="한덱스">한덱스</option>
			    <option value="한진택배">한진택배</option>
			    <option value="현대택배">현대택배</option>
			    <option value="CJ GLS">CJ GLS</option>
			    <option value="CVSnet 편의점택배">CVSnet 편의점택배</option>
			    <option value="DHL">DHL</option>
			    <option value="EMS">EMS</option>
			    <option value="FedEx">FedEx</option>
			    <option value="GTX">GTX</option>
			    <option value="HB한방택배">HB한방택배</option>
			    <option value="KG옐로우캡택배">KG옐로우캡택배</option>
			    <option value="KGB택배">KGB택배</option>
			    <option value="TNT Express">TNT Express</option>
			    <option value="UPS">UPS</option>
			  </select>
			  <input type="text" style="width:30%;" class="input_off" name="dtd_number_query" id="dtd_number_query" value="'-'를 제외하고 입력하세요." onClick="this.value=''">
			  <input type="submit" class="select" value="조회">
			</form>
		</div>
		</div>
		<br><br>
		</div>
	<br>
	</div>

<!-- 최하단 부트스트랩 -->
<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		CopyRight &copy; 2020 speshase All Rights Reserved. </footer>
		
</body>
</html>