<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- css -->
	<link href="resources/css/mainmenu/allmenujsp.css" rel="stylesheet" type="text/css">
	
	<!-- js&jquery -->

	<!-- middle1 시작 -->
	<br><br>
	<div id="middle1">
	<br><br>
	
	<div id="middle2">
	
	<!-- 게시글 테이블 시작 -->

		<form action="allWrite" method="get" enctype="multipart/form-data">
		
		<div>

			<c:forEach items="${allmenu}" var="all">

			<c:choose>
			<c:when test="${all.cname !='coupon'}">
			
			<div id="forContents">
			<a href=mainMenu/${all.cname}Detail?np=${all.np}><img src="mainMenu/display?sfile1=${all.sfile1}" alt="Image Error" width="315px" height="400px"></a><br>
			<a href=mainMenu/${all.cname}Detail?np=${all.np} style="cursor:pointer" class="coupontitle"><p id="nptitle">${all.nptitle}</p></a><br>
			<a href=mainMenu/${all.cname}Detail?np=${all.np} style="cursor:pointer" class="coupontitle"><p id="npprice"><b>${all.npprice}원</b></p></a>&nbsp;
			<br>
			</div>
			
			</c:when>
			<c:otherwise>
			
			<div id="forContents">
			<a href=mainMenu/${all.cname}Detail?np=${all.np}><img src="mainMenu/display?sfile1=${all.sfile1}" alt="Image Error" width="315px" height="400px"></a><br>
			<a href=mainMenu/${all.cname}Detail?np=${all.np} style="cursor:pointer" class="coupontitle"><p id="nptitle1">${all.nptitle}</p></a><br>
			<a href=mainMenu/${all.cname}Detail?np=${all.np} style="cursor:pointer" class="coupontitle"><p id="npprice1"><b>${all.npprice}원</b></p></a>&nbsp;
			<a href=mainMenu/${all.cname}Detail?np=${all.np} style="cursor:pointer" class="coupontitle"><p id="nppricedc1"><b>${all.nppricedc}원</b></p></a>
			<br>
			</div>
			
			</c:otherwise>
			</c:choose>
			
			</c:forEach>
		</div>
		
		</form>

	</div>

	<br><br><br><br>
	</div>
