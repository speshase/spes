/**
 * 
 */

var idBool = false;
var idcheck0 = false;
var pwBool1 = false;
var pwBool2 = false;

$(document).ready(function(){  /*패턴 체크*/
	var idcheck=RegExp(/^[a-zA-Z0-9]{5,20}$/);/*특수 문자 적용 안됨.*/
	var pwcheck=RegExp(/^(?=.*[a-zA-Z])(?=.*[!@#$%^&*+=-])(?=.*[0-9]).{8,20}$/);
	//var named= RegExp(/^[가-힣]+$/) //한글만 되게 체크
	//var fmt = RegExp(/^\d{6}[1234]\d{6}$/) //주민번호 체크
	var idolcheck=0;

	/* 아이디 형식체크 */
	$("#uid").keyup(function(){  /*아이디 체크*/
		idBool=false;
		idcheck0 = false;
		
		if(!idcheck.test($("#uid").val())){
			$("#idchk").html("5~20자의 영문 소문자 사용 가능합니다.(사용불가)");
			$("#idchk").css("font-size","13px");
			$("#idchk").css("color","red");
			idBool = false;
			
		}else{
			$("#idchk").html("5~20자의 영문 소문자 사용 가능합니다.(사용가능)");
			$("#idchk").css("font-size","13px");
			$("#idchk").css("color","#0080ff");
			idBool = true;
		}
	});
	
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


function join(){
	var uid=$("input[name=uid]").val()
	var upw=$("input[name=upw]").val()
	var repw=$("input[name=repw]").val()
	var uname=$("input[name=uname]").val()
	var uadress_num=$("input[name=uadress_num]").val()
	var uadress=$("input[name=uadress]").val()
	var uadress_detail=$("input[name=uadress_detail]").val()
	var uemail=$("input[name=uemail]").val()
		
	//alert(uid);
	//alert(upw);
	//alert(repw);
	//alert(uname);
	//alert(uadress_num);
	//alert(uadress);
	//alert(uadress_detail);
	//alert(uemail);
	
	//alert("idBool : "+idBool);
	//alert("idcheck : "+idcheck);
	//alert("pwBool1 : "+pwBool1);
	//alert("pwBool2 : "+pwBool2);
	
	if(idBool==false) {
		alert("사용가능한 아이디를 입력하세요.");
		return false;
	}
	if(idcheck0==false) {
		alert("아이디 중복체크를 하셔야합니다.");
		return false;
	}
	if(pwBool1==false) {
		alert("사용가능한 비밀번호를 입력하세요.");
		return false;
	}
	if(upw != repw) {
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
		//alert("모두입력 & 모든확인 완료");
			$.ajax({
				type : "POST",
		           url : "join",
		           contentType : "application/json",
		           data : JSON.stringify(user),
		           success : function() {
		    			alert("회원가입이 완료되었습니다.")
		    			$(location).attr("href","joinend");
		            },
		            	error : function(error) {
		            		alert("회원정보를 다시 입력해주세요.");
		            }
		        });
			}

	
$(document).ready(function(){ 
	/* 아이디 중복체크 */
	$(function() {
	    //idolcheck 버튼을 클릭했을 때 
	    $("#idolcheck").click(function() {
	    	//alert("idcheck == "+idcheck);
	    	if(idcheck0==true){
	    		alert("이미 중복체크가 완료된 아이디입니다.");
	    		return false;
	    	}
	    	
			if(idBool==false){
				alert("5~20자의 영문 소문자 사용 가능합니다.(사용불가)");
			}else{
	        
	        var userid = $("#uid").val(); 
	        
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
	            			idcheck0=true;
	            			
	            			}
	            		}
	            	},
	            	error : function(error) {
	            		alert("삐 - 에러입니다. : " + error);
	            }
	        });
			}
	    });
	});
});
