<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>TRAVIS</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../resources/css/home.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Nanum+Gothic+Coding&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>

<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script type="text/javascript" src="../resources/js/logoutInclude.js"></script>

</head>
<body>

	<div id="all">
		<div id=topbanner>
			<img src="../resources/img/Logo-02.png" style="max-width: 100%; height: auto;">
		</div>
		<div id="top">
			<div>
			
				<form id="logoutform">
					<ul id="topMenu">
					<c:choose>
							<c:when test="${sessionScope.uid==null || log==false}">
								<li><a href="http://localhost:8080/spes/main/agree">회원가입</a></li>
								<li><a href="http://localhost:8080/spes/main/login">&nbsp;로그인</a></li>
							</c:when>
							<c:otherwise>
								<li>${sessionScope.uid}님 어서오세요.</li>
								<li><a href="http://localhost:8080/spes/main/userModify">회원정보</a></li>
								<li><a href="javascript:void(0);" id="logout">&nbsp;로그아웃</a></li>
								<!-- <li><a href="javascript:void(0);" id="logout">&nbsp로그아웃</a></li>  -->
								<!-- <li><a href="http://localhost:8080/spes" id="logout">&nbsp로그아웃</a></li> -->
							</c:otherwise>
						</c:choose>
						<li><a href="http://localhost:8080/spes/mypage/cart">&nbsp;마이페이지</a></li>
						<li><a href="http://localhost:8080/spes/customer/customerService">&nbsp;고객센터</a></li>

					</ul>
				</form>
			</div>
			<!-- topMenu 끝 -->

			<br> <br> <br>
			<center>
				<a href="http://localhost:8080/spes"> <img src="../resources/img/Logo-01.png" width="20%"></a>
			</center>
			<br>
			<div>
				<form action="../main/searchResult" method="get" enctype="multipart/form-data" class="navbar-form pull-left">
					<br>
					<center>
						<input type="text" name="keyword" class="search-query" size="60px" placeholder="검색어를 입력하세요.">
						<input type="submit" class="btn search" value="검색">
					</center>
				</form>
			</div>

			<div id="dropdown">
				<ul class="nav justify-content-end">
					<li class="nav-item"><a href="http://localhost:8080/spes/mainMenu/allmenu"><img
							src="../resources/img/homeIcon/survey.png" width="25px">전체카테고리</a>
						<div id="dropdownMenu">
							<ul>
								<li><a href=""><img
										src="../resources/img/homeIcon/apple.png" width="15%">&nbsp과일/채소</a></li>
								<li><a href=""><img
										src="../resources/img/homeIcon/beef.png" width="15%">&nbsp정육/유제품</a></li>
								<li><a href=""><img
										src="../resources/img/homeIcon/fish.png" width="15%">&nbsp수산/건어물</a></li>
								<li><a href=""><img
										src="../resources/img/homeIcon/lunch.png" width="15%">&nbsp밀키트/간편식</a></li>
								<li><a href=""><img
										src="../resources/img/homeIcon/bread.png" width="15%">&nbsp베이커리</a></li>
								<li><a href=""><img
										src="../resources/img/homeIcon/macaron.png" width="15%">&nbsp디저트/음료</a></li>
							</ul>
						</div>
					<li class="nav-item"><a href="http://localhost:8080/spes/mainMenu/new">신상품</a></li>
					<li class="nav-item"><a href="http://localhost:8080/spes/mainMenu/best">인기상품</a></li>
					<li class="nav-item"><a href="http://localhost:8080/spes/mainMenu/coupon">할인/쿠폰</a></li>
					<li class="nav-item"><a href="http://localhost:8080/spes/mainMenu/event">이벤트</a></li>
				</ul>
			</div>
			<!-- dropdown 끝 -->
		</div>
		<!-- top 끝 -->