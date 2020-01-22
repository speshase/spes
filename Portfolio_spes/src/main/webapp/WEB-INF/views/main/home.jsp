<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>

<!-- bxSlider -->
<script type="text/javascript" src="../resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../resources/js/bxSlider.js"></script>
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">


	<div id="middle1" style="z-index: 1">
		<div class="bxslider">
			<div>
				<img src="../resources/img/bxSlider2(o)-01.png" width="100%">
			</div>
			<div>
				<img src="../resources/img/bxSlider2(o)-02.png" width="100%">
			</div>
			<div>
				<img src="../resources/img/bxSlider2(o)-03.png" width="100%">
			</div>
			<div>
				<img src="../resources/img/bxSlider2(o)-04.png" width="100%">
			</div>
		</div>
	</div>
		<br> <br> <br> <br>
		<div id="middle2">
			<form>
				<table width="100%" height="200px">
					<tr>
						<td colspan="4" height="50px"><h3>하루하루 달라지는 한정특가</h3></td>
					</tr>
					<br>
					<tr>
						<td colspan="2"><img src="../resources/img/sale/beefSale.PNG"
							width="430px" hight="350px"></td>
						<td colspan="2"><img
							src="../resources/img/sale/jjuggumiSale.PNG" width="430px"
							hight="350px"></td>
					</tr>
					<tr>
						<td id="salename" rowpan="2">&nbsp;[미트클레버] 숙성 한돈 목살 스테이크</td>
						<td id=salecolor width="15%"><h4>9,030원</h4></td>
						<td id="salename" rowpan="2">&nbsp;[올면] 쫄깃한 쭈꾸미 볶음면</td>
						<td id=salecolor width="15%"><h4>10,200원</h4></td>
					</tr>
				</table>
			</form>
		</div>
		<!-- middle2 끝 -->
		<br> <br> <br> <br>

	</div>
	<!-- all 끝 -->

	<!-- 최하단 부트스트랩 -->
	<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		CopyRight &copy; 2020 speshase All Rights Reserved. </footer>
</body>
</html>
