/**
 * 
 */

$(document).ready(function(){
	
	//alert("로그아웃 연결")
	
	//id가 logout인 버튼을 클릭했을 때(글쓰기버튼을 클릭했을 때)
	$("#logout").click(function(){
		//alert("write");
		$("#logoutform").attr("action","logout").submit();
		
	});
});