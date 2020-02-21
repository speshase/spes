<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<!-- include 이후 -->
	<jsp:include page="../include/topjsp.jsp" flush="true"></jsp:include>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- css -->
	<link href="../resources/css/agree.css" rel="stylesheet" type="text/css">
	
	<!-- js&jquery -->
	<script type="text/javascript" src="../resources/js/agree.js"></script>

	
	<!-- middle1(약관동의) 시작 -->
	<br><br>
	<div id="middle1">
		<form>
            <ul>
                <li>
                <br><br>
                    <ul>
                        <li>
							<div class="wrap">
							  <div class="square">
							    <p class="agreeP">[약관동의] 이용약관, 개인정보 수집 및 이용에 동의해주십시오. &emsp; *동의하신 경우에만 회원가입이 가능합니다.</p>
							  </div>
							</div>
						</li>
                    </ul>
                    <br>
                </li>
                <br>
                <li>
                    <textarea cols="100%" rows="5px">&nbsp; 여러분을 환영합니다. 트라비스 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 트라비스 서비스의 이용과 관련하여 트라비스 서비스를 제공하는 트라비스 주식회사(이하 ‘트라비스’)와 이를 이용하는 트라비스 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 트라비스 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다. 트라비스은 「개인정보보호법」 제15조제1항제1호, 제17조제1항제1호, 제23조제1호, 제24조제1항 제1호에 따라
아래와 같이 개인정보의 수집. 이용에 관하여 귀하의 동의를 얻고자 합니다. 트라비스는 이용자의 사전 동의 없이는 이용자의 개인정보를 함부로 공개하지 않으며, 수집된 정보는 아래와 같이 이용하고 있습니다. 이용자가 제공한 모든 정보는 아래의 목적에 필요한 용도 이외로는 사용되지 않으며 이용 목적이 변경될 시에는 이를 알리고 동의를 구할 것입니다.</textarea>
					<br>
                    <ul>
                        <li class="agreeP">이용약관 동의(필수)&nbsp;<input type="checkbox" id="checkBox01"></li>
                    </ul>
                </li>
                <br>
                <br>
                <li>
                    <textarea cols="100%" rows="5px">&nbsp; 여러분을 환영합니다. 트라비스 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 트라비스 서비스의 이용과 관련하여 트라비스 서비스를 제공하는 트라비스 주식회사(이하 ‘트라비스’)와 이를 이용하는 트라비스 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 트라비스 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다. 트라비스은 「개인정보보호법」 제15조제1항제1호, 제17조제1항제1호, 제23조제1호, 제24조제1항 제1호에 따라
아래와 같이 개인정보의 수집. 이용에 관하여 귀하의 동의를 얻고자 합니다. 트라비스는 이용자의 사전 동의 없이는 이용자의 개인정보를 함부로 공개하지 않으며, 수집된 정보는 아래와 같이 이용하고 있습니다. 이용자가 제공한 모든 정보는 아래의 목적에 필요한 용도 이외로는 사용되지 않으며 이용 목적이 변경될 시에는 이를 알리고 동의를 구할 것입니다.</textarea>
                    <br>
                    <ul>
                        <li class="agreeP">개인정보 수집 및 이용에 대한 안내(필수)&nbsp;<input type="checkbox" id="checkBox02"></li>
                    </ul>
                </li>
                <br>
                <br>
            </ul>
            <ul class="agreefix">
                <li><!-- <input type="submit" value="동의하고 가입하기" class="btn btnagree"> -->
                <!-- <a href=" " id="agree" class="btn btnagree">동의하고 가입하기</a> -->
                <input type="button" value="동의하고 가입하기" id="agree" class="btn btnagree">
                </li>
            </ul>
            <br>
            <br>
            <br>
        </form>
	</div>
</div><!-- all 끝 -->

<!-- 최하단 부트스트랩 -->
<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		CopyRight &copy; 2020 speshase All Rights Reserved. </footer>
		
</body>
</html>