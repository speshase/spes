<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>

<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- css -->
	<link href="../resources/css/customerService/questionsWrite.css" rel="stylesheet" type="text/css">
	
	<!-- js&jquery -->
	<script type="text/javascript" src="../resources/js/customerService/questionsWrite.js"></script>
	
	<!-- middle1 시작 -->
	<br><br>
	<div id="middle1">
	<br><br><br>
	
	<!-- 미니메뉴 테이블 -->
		<div id="minimenu">
		<table class="minimenu">
			<tr>
				<td colspan="3" width="33%"><a href="questionsWrite" style="color:white;">(관리자페이지) 자주묻는 질문 글쓰기</a></td>
			</tr>
		</table>
		<br><br>
	</div> <!-- 미니메뉴 테이블 끝 -->

	<!-- 게시글 테이블 시작 -->
	<div id="boardtable">
	<form action="questionsWriteEnd" method="post" enctype="multipart/form-data">
		<table class="table" width="100%">
			
				<tr>
				<th width="10%">글번호</th>
				<td width="30%">자동입력</td>
				</tr>
				
				<tr>
				<th>영어카테고리</th>
				<td>
				<div id="qcategorycss">
					<select name="qcategory">
						<option>카테고리전체</option>
						<option value="pay">pay</option>
						<option value="cancel">cancel</option>
						<option value="delivery">delivery</option>
						<option value="coupon">coupon</option>
						<option value="memverinfo">memverinfo</option>
						<option value="serviceuse">serviceuse</option>
					</select>
				</div>
				</td>
				</tr>
				
				<tr>
				<th>한글카테고리</th>
				<td>
				<div id="qcategorycss">
					<select name="qcategoryk">
						<option>카테고리전체</option>
						<option value="주문/결제">주문/결제</option>
						<option value="취소/교환/반품">취소/교환/반품</option>
						<option value="배송문의">배송문의</option>
						<option value="쿠폰/할인">쿠폰/할인</option>
						<option value="회원정보문의">회원정보문의</option>
						<option value="서비스이용 및 기타">서비스이용 및 기타</option>
					</select>
				</div>
				</td>
				</tr>
				
				<tr>
				<th>글제목</th>
				<td><input type="text" name="qsubject" size="50%"></td>
				</tr>
				
				<tr>
				<th>글내용</th>
				<td height="30%">
				<textarea name="qcontent" cols="100%" rows="10%">
				</textarea>
				</td>
				</tr>
				
				<tr>
				<td colspan="2"><input type="submit" value="등록" class="write"></td>
				</tr>
										
			</table>
			
			<br><br><br>
		</form>
	</div> <!-- boardtable 종료 -->
	
	</div> <!-- miidle1 종료 -->

<!-- 최하단 부트스트랩 -->
<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		CopyRight &copy; 2020 speshase All Rights Reserved. </footer>