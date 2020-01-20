/**
 * 
 */

$(document).ready(function(){  /*패턴 체크*/
	var idcheck=RegExp(/^[a-zA-Z0-9]{5,20}$/);/*특수 문자 적용 안됨.*/
	var pwcheck=RegExp(/^(?=.*[a-zA-Z])(?=.*[!@#$%^&*+=-])(?=.*[0-9]).{8,20}$/);
	var idolcheck=0;

	/* 아이디 형식체크 */
	$("#uid").keyup(function(){  /*아이디 체크*/
		if(!idcheck.test($("#uid").val())){
			$("#idchk").html("형식에 맞게 입력 해 주세요.");
			$("#idchk").css("font-size","13px");
			$("#idchk").css("color","red")
		}else{
			$("#idchk").html("사용 가능한 ID 입니다.");
			$("#idchk").css("font-size","13px");
			$("#idchk").css("color","#0080ff")
		}
	});
	
	/* 아이디 중복체크 */
	$(function() {
	    //idolcheck 버튼을 클릭했을 때 
	    $("#idolcheck").click(function() {
	        
	        var userid =  $("#uid").val(); 
	        
	        $.ajax({
	            type : "GET",
	            url : "idolcheck?uid="+userid,
	            dataType:"json",
	            success : function(data) {
	            	console.log("1:중복, 0:중복아님 / data : "+ data);
	            	
	            	if(userid == "") {
	            		alert("아이디를 입력하세요.");
	            	}else {
	            		if(data > 0) {
	            			alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
	            			$("#uid").val("");
	            			}else {
	            				alert("사용가능한 아이디입니다.");
	            				}
	            		}
	            	},
	            	error : function(error) {
	            		alert("삐 - 에러입니다. : " + error);
	            }
	        });
	    });
	});
	
	
	/*비밀번호 형식체크 */
	
	$("#upw").keyup(function(){
		if(!pwcheck.test($("#upw").val())){
			$("#pwchk").html("형식에 맞게 입력 해 주세요.");
			$("#pwchk").css("font-size","13px");
			$("#pwchk").css("color","red")
		}else{
			$("#pwchk").html("사용 가능한 비밀번호 입니다.");
			$("#pwchk").css("font-size","13px");
			$("#pwchk").css("color","#0080ff")
		}
	});
	
	
	/*비밀번호 확인체크 */
	
	$("#repw").keyup(function(){  /*비밀번호확인 체크*/
		var pw = $("#upw").val();  /*pw의 값을 들고옴 - 비밀번호 값 */
		var repw = $("#repw").val();  /*repw의 값을 들고옴 - 비밀번호 재확인 값 */
		
		if(pw==repw) {
			$("#repwchk").html("비밀번호가 일치합니다.");
			$("#repwchk").css("font-size","13px");
			$("#repwchk").css("color","#0080ff");
		}else{
			$("#repwchk").html("비밀번호가 일치하지 않습니다.");
			$("#repwchk").css("font-size","13px");
			$("#repwchk").css("color","red");
		}
	});
	
	
	
	
	
});