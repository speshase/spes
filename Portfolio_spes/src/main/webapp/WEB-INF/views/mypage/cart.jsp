<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- include 이후 -->
<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>

	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- css -->
	<link href="../resources/css/mypage/cart.css" rel="stylesheet" type="text/css">
	
	<!-- js&jquery = 최하단-->

<!-- middle1 시작 -->
<br><br>
<div id="middle1">
		<br><br>
	<div id="middle2">
		<div id="minimenu">
		<table class="minimenu">
			<tr>
				<td width="25%"><a href="/spes/mypage/delivery" style="color:white;">배송조회</a></td>
				<td width="25%"><a href="/spes/mypage/cart" style="color:white;">▶장바구니◀</a></td>
				<td width="25%"><a href="/spes/mypage/review" style="color:white;">상품후기</a></td>
				<td width="25%"><a href="/spes/mypage/coupon2" style="color:white;">쿠폰</a></td>
			</tr>
		</table>

		</div>
		
		<c:choose>
			<c:when test="${sessionScope.uid!=null || log==true}">
		
		<form> <!-- 장바구니 목록 -->
			<table class="carttable">
			
				<tr>
					<th width="50%" colspan="2">상품정보</th>
					<th width="20%">수량</th>
					<th>상품금액</th>
					<tr width="5%"></tr>
				<tr>
				
				<c:set var="sum" value="0" />
				<c:forEach items="${cart}" var="cart">
				
				<input type="hidden" name="uid" value="${cart.uid}">
				
				<tr>
					<td width="14%">&emsp;<img src="../mainMenu/display?cfile1=${cart.cfile1}" alt="Image Error" width="100px"></td>
					<td width="40%" style="text-align:left;">&emsp;&emsp;${cart.ctitle}</td>
					<td>
					<div class="__count_range">
						<input class="countbtn" onclick="cartModify(${cart.cp}, ${cart.cpprice} , '-', ${cart.count})" value="-" count_range="m" type="button">
						<input id="counttt" value="${cart.count}" readonly name="count" size="1px">
						<input class="countbtn" id="count" onclick="cartModify(${cart.cp}, ${cart.cpprice}, '+', ${cart.count})" value="+" count_range="p" type="button">
						<input type="hidden" name="cp" value="${cart.cp}">
						<input type="hidden" name="cpprice" id="cpprice" value="${cart.cpprice}">
					</div>
					</td>
					<td>${cart.total}원</td>
					<td>
					<img src="../resources/img/rest/X_image-01.png" width="13px" onclick="cartDelete(${cart.cp})" style="cursor:hand">&emsp;</td>
				</tr>

				<fmt:parseNumber value="${sum + (cart.count * (cart.total/cart.count))}" var="sum" />
				
				<fmt:parseNumber value="0" var="cou" />
				<c:choose>
					<c:when test="${sum>=30000}">
						<fmt:parseNumber value="0" var="deli" />
					</c:when>
					<c:otherwise>
						<fmt:parseNumber value="2500" var="deli" />
					</c:otherwise>
				</c:choose>
				</c:forEach>
			<br><br>

			</table>
		</form>
		
		<br>	
		<fmt:parseNumber value="${sum-cou+deli}" var="result" />
	<div id="paytable">
		
		<form> <!-- 계산테이블 -->
		
			<div class="box" id="sum">
				<p><br><br><b>상품금액</b></p>
				<p class="boxname2"><br>${sum}원</p>
			</div>
			<div class="cc"><p>-</p></div>
			<div class="box">
				<p><br><br><b>할인금액</b></p>
				<p class="boxname2"><br>${cou}원</p>
			</div>
			<div class="cc"><p>+</p></div>
			<div class="box">
				<p><br><br><b>배송비</b></p>
				<p class="boxname2"><br>${deli}원</p>
			</div>
			<div class="cc"><p>=</p></div>
			<div class="box2">
				<p><br><br><b>결제예정금액</b></p>
				<p class="boxname2"><br>${result}원</p>
			</div>
			
		</form>
			<br>
			<div>
				<input type="button" class="pay" value="결제하기">
			</div>
		
		</c:when>
			
			<c:otherwise>
				<br><br><br>
				<p><center>로그인 하시면 장바구니를 확인하실 수 있습니다.</center></p>
				<br><br><br>
			</c:otherwise>
		</c:choose>
		
	</div>
		
		<br><br>
	</div>
</div>


<!-- 최하단 부트스트랩 -->
<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		CopyRight &copy; 2020 speshase All Rights Reserved. </footer>
		
<script type="text/javascript" src="../resources/js/mypage/cart.js"></script>
		
</body>
</html>