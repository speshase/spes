<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>

<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- css -->
	<link href="../resources/css/customerService/questionsList.css" rel="stylesheet" type="text/css">
	
	<!-- js&jquery -->
	<script type="text/javascript" src="../resources/js/customerService/questions.js"></script>

	<!-- middle1 시작 -->
	<br><br>
	<div id="middle1">
	<br><br>
	<p class="tt" style="color:#ef0056;"><b>트라비스의 중심</b>은 항상 <b>고객님</b>입니다.</p>
	<p class="tb">트라비스를 이용하면서 느끼신 불편사항이나 바라는 점을 알려주세요.<br>
	고객님의 소중한 의견으로 한 뼘 더 자라는 트라비스가 되겠습니다.</p>
	<br><br>
	
	<!-- 미니메뉴 테이블 -->
		<div id="minimenu">
		<table class="minimenu">
			<tr>
				<td width="33%"><a href="http://localhost:8080/spes/customer/questionsList" style="color:white;">자주묻는 질문</a></td>
				<td width="33%"><a href="http://localhost:8080/spes/customer/customerService" style="color:white;">고객의 소리</a></td>
				<td width="33%"><a href="http://localhost:8080/spes/customer/travisNews" style="color:white;">트라비스 소식</a></td>
			</tr>
		</table>
		<br>
		
	<!-- 카테고리 -->
		<div id="qcategorycss">
			<select name="qcategory" id="qcategory" onchange="qcatogory();">
			<option >카테고리전체</option>
				<option value="pay">주문/결제</option>
				<option value="cancel">취소/교환/반품</option>
				<option value="delivery">배송문의</option>
				<option value="coupon">쿠폰/할인</option>
				<option value="memverinfo">회원정보문의</option>
				<option value="serviceuse">서비스이용 및 기타</option>
			</select>
		</div>
		<br><br>
	</div> <!-- 미니메뉴 테이블 끝 -->

	<!-- 게시글 테이블 시작 -->
	<div id="boardtable">
	<form action="questionsWrite" id="questionsForm">
		<table class="table" width="100%">
		<!-- 아이디가 관리자면 글수정과 글삭제가 보임 -->
		<c:choose>
			<c:when test="${sessionScope.uid=='admin'}">
				<thead>
					<tr>
					<th width="25%">카테고리</th>
					<th>제목</th>
					<th width="30%">관리</th>
					</tr>
				</thead>
		
				<tbody>
					<c:forEach items="${qcatogoryList}" var="list">        
					<tr>
					<td>${list.qcategoryk}</td>
					<td>
						<a class="content" onclick="questionShow(${list.qno})">${list.qsubject}&emsp;
						</a>
					</td>
					<td>
					<!-- a태그에 번호값을 넣어서 href를 통해서 controller로 보냄 -->
						<button value="수정" class="modify"><a class="modify2" href="questionsModify?qno=${list.qno}">수정</a></button>

					<!-- input botton태그에 해당 값을 onclick함수에 담아서 js로 보냄_ajax사용 -->
						<input type="button" class="delete" onclick="questionDelete(${list.qno})" value="삭제">
					</td>
					</tr>
					
					<tr>
					<td></td>
					<td>
						<div class="contentt${list.qno}" style ="display:none"><center><p class="qcontent">${list.qcontent}</p></center></div>
					</td>
					<td></td>
					</tr>
					</c:forEach>
				</c:when>
			
				<c:otherwise>
				<thead>
					<tr>
					<th width="25%">카테고리</th>
					<th>제목</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${qcatogoryList}" var="list">        
					<tr>
					<td>${list.qcategoryk}</td>
					<td><a class="content">${list.qsubject}</a></td>
					</tr>
					<tr>
					<td></td>
					<td>
					<div class="content2"><center><p class="qcontent">${list.qcontent}</p></center></div>
					</td>
					</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<tr>
			<td colspan="3"> 페이지 </td>
			</tr>
			
			<!-- 아이디가 관리자면 글쓰기가 보임 -->
			<c:choose>
				<c:when test="${sessionScope.uid=='admin'}">
					<tr>
					<td><input type="submit" value="글쓰기" class="write"></td>
					</tr>
				</c:when>
				
				<c:otherwise>
					<tr>
					<td colspan="5"></td>
					<td></td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	<br><br>
	</form>
	</div> <!-- boardtable 종료 -->
	
	</div> <!-- miidle1 종료 -->
	
<!-- 최하단 부트스트랩 -->
<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		CopyRight &copy; 2020 speshase All Rights Reserved. </footer>

</html>