<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- jstl을 사용하기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- include 이후 -->
<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>

<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- css -->
<link href="../resources/css/customerService/customerDetail.css"
	rel="stylesheet" type="text/css">

<!-- js&jquery -->
<script type="text/javascript"
	src="../resources/js/customerService/customerService.js"></script>

<!-- middle1 시작 -->
<br>
<br>
<div id="middle1">
	<br>
	<br>
	<br>

	<!-- 미니메뉴 테이블 -->
	<div id="minimenu">
		<table class="minimenu">
			<tr>
				<td colspan="3" width="33%"><a style="color: white;">고객의소리 글보기</a></td>
			</tr>
		</table>
		<br>
		<br>
	</div>
	<!-- 미니메뉴 테이블 끝 -->

	<!-- 게시글 테이블 시작 -->
	<div id="boardtable">
		<form id="customerService" method="get"
			enctype="multipart/form-data">
			<table class="table" width="100%">
					
				<!-- 로그인 되어있으면 글수정과 글삭제가 보임 -->
				<c:choose>
					<c:when test="${sessionScope.uid!=null || log==true}">
						<tr>
							<th width="10%">글번호</th>
							<td><input type="hidden" value="${detail.cno}" name="cno"
								readonly>${detail.cno}</td>
						</tr>
						<tr>
							<th>글제목</th>
							<td>${detail.csubject}</td>
						</tr>
						<tr>
							<th>글내용</th>
							<td height="300px">${detail.ccontent}</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td>${detail.cuid}</td>
						</tr>
						<tr>
							<th>작성날짜</th>
							<td>${detail.cwrite_date}</td>
						</tr>

						<tr>
							<td colspan="2">
							<input type="submit" value="수정" class="modify">
							<input type="submit" value="삭제" class="delete" onclick="customerServiceDelete(${detail.cno})">
							</td>
						</tr>
					</c:when>

					<c:otherwise>
						<br><br><br>
						<center><p>로그인 하시면 글을 수정 · 삭제하실 수있습니다.</p></center>
						<br><br><br>
					</c:otherwise>

				</c:choose>

			</table>

			<br>
		</form>
	</div>
	<!-- boardtable 종료 -->

	<div id="boardcomment">
    <form id="commentForm" name="commentForm" method="post">
    
    <!-- 관리자만 댓글입력창이 보임 -->
		<c:choose>
		<c:when test="${sessionScope.uid=='admin' || log==true}"> 

        <div>
            <div>
               <p><strong>&emsp;댓글</strong></p>
            </div>
            <div>
                <table class="table">
                                 
                    <tr>
                        <td height="200px" colspan="5">
                            <textarea style="width:100%" rows="3" cols="30" id="comments" placeholder="댓글을 입력하세요."></textarea>
                            <input type="hidden" name="cno" value="${detail.cno}">
                            <input type="hidden" name="cmuid" value="${sessionScope.uid}">
                            <input type="button" value="등록" class="commentsWrite" onclick="commentsWrite()">
                        </td>
                    </tr>
                    
                    <tr>
                        <th width="40%">댓글내용</th>
                        <th>작성자</th>
                        <th>작성날짜</th>
                        <th>수정날짜</th>
                        <th>댓글관리</th>
                    </tr>
                    
                    <c:forEach items="${comments}" var="co">
                    <tr>
                        <td height="10%"><p>${co.comments}<p></td>
                        <td><p>${co.cmuid}<p></td>
                        <td><p>${co.cdate_time}<p></td>
                        <td><p>${co.cndate_time}<p></td>
                        <td><a style="cursor:pointer" onclick="commentsModify(${co.cmno})">수정</a>&emsp;
                        	<a style="cursor:pointer" onclick="commentsDelete(${co.cmno})">삭제</a></td>
                    </tr>

                    <div id="commentsModify" class="showInput${co.cmno}" style="display:none">
                    <tr>
                    	<td colspan="5">
                    	<div id="commentsModify" class="showInput${co.cmno}" style="display:none">
                    	<textarea style="width:100%" rows="3" cols="30" id="comments2" placeholder="수정하실 댓글을 입력하세요."></textarea>
                    	<input type="hidden" name="cmno" value="${co.cmno}">
                    	<input type="hidden" name="cndate_time" value="${co.cndate_time}">
                    	<input type="button" value="완료" class="commentsModify" onclick="commentsModify2(${co.cmno})">
                    	</div>
                    	</td>
                    </tr>
                    
                    
                    <!--
                    <tr>
                    <td colspan="5">
                    <span class="commentsModifyShow${co.cmno}"></span>
                    <td>
                    </tr>
                     -->
                     
                    </c:forEach>
                   
                </table>
                
                
            </div>
        </div>
		</c:when>
		
		<c:when test="${sessionScope.uid!=null || log==true}"> 
        <div>
            <div>
               <p><strong>&emsp;댓글</strong></p>
            </div>
            <div>
                <table class="table">
                    
                    <tr>
                        <th width="50%">댓글내용</th>
                        <th>작성자</th>
                        <th>작성날짜</th>
                        <th>수정날짜</th>
                    </tr>
                    
                    <c:forEach items="${comments}" var="co">
                    <tr>
                        <td height="10%"><p>${co.comments}<p></td>
                        <td><p>${co.cmuid}<p></td>
                        <td><p>${co.cdate_time}<p></td>
                        <td><p>${co.cndate_time}<p></td>
                    </tr>

                    <div id="commentsModify" class="showInput${co.cmno}" style="display:none">
                    <tr>
                    	<td colspan="4">
                    	<div id="commentsModify" class="showInput${co.cmno}" style="display:none">
                    	<textarea style="width:100%" rows="3" cols="30" id="comments2" placeholder="수정하실 댓글을 입력하세요."></textarea>
                    	<input type="hidden" name="cmno" value="${co.cmno}">
                    	<input type="hidden" name="cndate_time" value="${co.cndate_time}">
                    	<input type="button" value="수정" class="commentsModify" onclick="commentsModify2(${co.cmno})">
                    	</div>
                    	</td>
                    </tr>
                    
                    <!--
                    <tr>
                    <td colspan="5">
                    <span class="commentsModifyShow${co.cmno}"></span>
                    <td>
                    </tr>
                     -->
                     
                    </c:forEach>
                   
                </table>
                
                
            </div>
        </div>
		</c:when>
		
        <c:otherwise>
			<td></td>
		</c:otherwise>
	</c:choose>
			
        <br><br>
    </form>
	</div><!-- boardcomment 종료 -->
	
</div>
<!-- miidle1 종료 -->

<!-- 최하단 부트스트랩 -->
<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
	CopyRight &copy; 2020 speshase All Rights Reserved. </footer>
	
	</body>
</html>