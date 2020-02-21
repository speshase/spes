/**
 * 
 */

//alert("userfind");


//아이디 찾기
function findid(){
	
	var uname=$("input[name=uname]").val();
	var uemail=$("input[name=uemail1]").val();
	
	//alert(uname);
	//alert(uemail);
	
	$.ajax({
		type:'POST',
		  url: "findid", // @RequestMapping에 들어가는 주소
		  contentType : "application/json",
		  data : JSON.stringify({ "uname" : uname, "uemail" : uemail }),
		  dataType : "text", // return 타입
		  success: function(data){
			if(data == ""){
				alert("조회되는 회원정보가 없습니다. 다시 시도해주세요.");
			}else{
				alert("회원님의 아이디는 "+data+"입니다.");
			}
			location.reload();
		},
		
		error: function(xhr, status, error) {
			alert("조회에 실패하였습니다."+"code:"+request.status+"\n"
					+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}

var uid;

//비밀번호 찾기
function findpw(){
	
	//alert("이메일 인증 버튼 누름");
	
	uid=$("input[name=uid]").val();
	var uemail=$("input[name=uemail2]").val();
	
	alert(uid);
	alert(uemail);
	
	var inputTag = document.getElementById("checkEmail");
	
	if(inputTag.style.display == 'none') {
		$(".showInput").show();
		inputTag.style.display = 'block';
	}
	
	$.ajax({
		type:'POST',
		  url: "findpw", // @RequestMapping에 들어가는 주소
		  contentType : "application/json",
		  data : JSON.stringify({ "uid" : uid, "uemail" : uemail }),
		  dataType : "text", // return 타입
		  success: function(data){
			if(data == ""){
				alert("조회되는 회원정보가 없습니다. 다시 시도해주세요.");
			}else{
				alert("잠시만 기다려주세요. 인증번호를 전송중입니다.");
				
				$.ajax({
					type:'POST',
					url: "sendMail", // @RequestMapping에 들어가는 주소
					data : {"uemail" : uemail},
					dataType : "text", // return 타입
					success: function(data){
						if(data != ""){
							alert("메일로 인증번호를 전송하였습니다. 확인 후 인증번호를 입력해주세요.");
						}else{
							alert("인증번호 전송 실패! 다시 시도해주세요.");
						}
					}
				});
			}
		},
		error: function(xhr, status, error) {
			alert("조회에 실패하였습니다."+"code:"+request.status+"\n"
					+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});

	//인증번호 입력 후 전송버튼
	//id가 checkNum인 버튼을 클릭했을 때
	$("#checkNum").click(function(){
		//alert("인증번호 확인하기 연결");
		
		var inputNum=$("input[name=inputNum]").val();
		//alert("입력값 = "+inputNum);
		
		$.ajax({
			type:'POST',
			  url: "checkNum", // @RequestMapping에 들어가는 주소
			  data : { "inputNum" : inputNum },
			  dataType : "text", // return 타입
			  success: function(data){
				  if(data=="pass"){
					  alert("인증번호가 확인되었습니다. 새로운 비밀번호를 입력해주세요.");
					  //alert(data);
					  //$("#pwModify").attr("href","pwModify");
					  
					  $.ajax({
					 	type:"GET",
					 	url:"pwModify?uid="+uid,
					 	dataType:"text",
					 	success: function(){
					 	//alert(uid);
					 	location.href="pwModify?uid="+uid;
					 },
					 	error: function(xhr, status, error) {
					 	alert("error : 화면 로딩에 실패하였습니다. 다시 시도해주세요."+error);
					 	}
					});
					  
				  }else{
					  alert("인증번호가 틀렸습니다. 다시 입력해주세요.");
				  }
			},
			
			error: function(xhr, status, error) {
				alert("조회에 실패하였습니다."+"code:"+request.status+"\n"
						+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
	});
}
