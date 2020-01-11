//alert("룰루~! 보기화면 연결~!");

$(document).ready(function(){
	
	//id가 write인 버튼을 클릭했을 때(글쓰기버튼을 클릭했을 때)
	$("#write").click(function(){
		//alert("write");
		$("#form1").attr("action","register");
	})
	
	//id가 modify인 버튼을 클릭했을 때(돌아가기버튼을 클릭했을 때)
	$("#return").click(function(){
		//alert("return");
		$("#form1").attr("action","return");
	})
	
	//id가 modify인 버튼을 클릭했을 때(수정버튼을 클릭했을 때)
	$("#modify").click(function(){
		//alert("modify");
		$("#form1").attr("action","modify");
	})
	
	//id가 delete인 버튼을 클릭했을 때(삭제버튼을 클릭했을 때)
	$("#delete").click(function(){
		//alert("delete");
		$("#form1").attr("action","delete");
	})
	
})

