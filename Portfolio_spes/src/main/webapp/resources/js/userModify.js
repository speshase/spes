/**
 * 
 */

var pwBool1 = false;
var pwBool2 = false;

$(document).ready(function(){ /*패턴 체크*/
	var pwcheck=RegExp(/^(?=.*[a-zA-Z])(?=.*[!@#$%^&*+=-])(?=.*[0-9]).{8,20}$/);

	/*비밀번호 형식체크 */
	
	$("#upw").keyup(function(){
		var pw = $("#upw").val();  /*pw의 값을 들고옴 - 비밀번호 값 */
		var repw = $("#repw").val();  /*repw의 값을 들고옴 - 비밀번호 재확인 값 */
		
		if(pw==repw) {
			$("#repwchk").html("비밀번호가 일치합니다.");
			$("#repwchk").css("font-size","13px");
			$("#repwchk").css("color","#0080ff");
			pwBool2 = true;
		}else{
			$("#repwchk").html("비밀번호가 일치하지 않습니다.");
			$("#repwchk").css("font-size","13px");
			$("#repwchk").css("color","red");
			pwBool2 = false;
		}
		
		$("#repw").keyup(function(){  /*비밀번호확인 체크*/
			var pw = $("#upw").val();  /*pw의 값을 들고옴 - 비밀번호 값 */
			var repw = $("#repw").val();  /*repw의 값을 들고옴 - 비밀번호 재확인 값 */
			
			if(pw==repw) {
				$("#repwchk").html("비밀번호가 일치합니다.");
				$("#repwchk").css("font-size","13px");
				$("#repwchk").css("color","#0080ff");
				pwBool2 = true;
			}else{
				$("#repwchk").html("비밀번호가 일치하지 않습니다.");
				$("#repwchk").css("font-size","13px");
				$("#repwchk").css("color","red");
				pwBool2 = false;
			}
		});
		
		if(!pwcheck.test($("#upw").val())){
			$("#pwchk").html("8~20자의 영문 대 소문자, 숫자, 특수문자를 사용하세요.");
			$("#pwchk").css("font-size","13px");
			$("#pwchk").css("color","red")
			if(pw==repw) {
				$("#repwchk").html("비밀번호가 일치합니다.");
				$("#repwchk").css("font-size","13px");
				$("#repwchk").css("color","#0080ff");
				pwBool2 = true;
			}else{
				$("#repwchk").html("비밀번호가 일치하지 않습니다.");
				$("#repwchk").css("font-size","13px");
				$("#repwchk").css("color","red");
				pwBool2 = false;
			}
		}else{
			$("#pwchk").html("사용 가능한 비밀번호 입니다.");
			$("#pwchk").css("font-size","13px");
			$("#pwchk").css("color","#0080ff")
			pwBool1 = true;
			if(pw==repw) {
				$("#repwchk").html("비밀번호가 일치합니다.");
				$("#repwchk").css("font-size","13px");
				$("#repwchk").css("color","#0080ff");
				pwBool2 = true;
			}else{
				$("#repwchk").html("비밀번호가 일치하지 않습니다.");
				$("#repwchk").css("font-size","13px");
				$("#repwchk").css("color","red");
				pwBool2 = false;
			}
		}
	});
	
});

function userModify(){

	var uid=$("input[name=uid]").val()
	var upw=$("input[name=upw]").val()
	var repw=$("input[name=repw]").val()
	var uname=$("input[name=uname]").val()
	var uadress_num=$("input[name=uadress_num]").val()
	var uadress=$("input[name=uadress]").val()
	var uadress_detail=$("input[name=uadress_detail]").val()
	var uemail=$("input[name=uemail]").val()
	
	if(pwBool1 == false) {
		alert("사용가능한 비밀번호를 입력하세요.");
		return false;
	}
	if(pwBool2 == false) {
		alert("두 비밀번호가 일치해야합니다.");
		return false;
	}
	if(uname=="" || uadress_num=="" || uadress=="" || uadress_detail=="" || uemail==""){
		alert("회원정보를 모두 입력하셔야 합니다.")
		return false;
	}

	var user = {
		"uid":uid,
		"upw":upw,
		"uname":uname,
		"uadress_num":uadress_num,
		"uadress":uadress,
		"uadress_detail":uadress_detail,
		"uemail":uemail
	}
		
		if(pwBool1 == true && pwBool2 == true) {
			$.ajax({
	            type : "POST",
	            url : "userModify",
	            contentType : "application/json",
	    		data : JSON.stringify(user),
	            success : function() {
	    			alert("회원정보 변경이 완료되었습니다.")
	    			$(location).attr("href","/spes");
	            },
	            	error : function(error) {
	            		alert("회원정보 변경에 실패하였습니다.");
	            }
	        });
			
		}else{
			alert("회원정보 변경에 실패하였습니다.");
		}
}


//회원탈퇴
function userleave(){
	// alert(np);
	var result = confirm("정말 회원을 탈퇴하시겠습니까? 탈퇴하시면 모든 회원정보는 사라집니다.");
	alert(result);
	
	if(result){
	
	$.ajax({
		type:"GET",
		url:"userleave",
		success: function(){
			alert("탈퇴하였습니다.")
			location.href="../";
		},
		
		error: function(xhr, status, error) {
			alert("회원탈퇴에 실패하였습니다. error : " + error);
		}
	});
		
	}else {
		alert("회원탈퇴를 취소하였습니다.")
	}
}
