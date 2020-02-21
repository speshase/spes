/**
 * 
 */

$(document).ready(function(){
	
	//alert($("input[name=cmuid]").val());
	
	//class가 modify인 버튼을 클릭했을 때(글수정 버튼을 클릭했을 때)
	$(".modify").click(function(){
		//alert("modify");
		$("#customerService").attr("action","customerServiceModify").submit();
	});
	
	//class가 delete인 버튼을 클릭했을 때(글삭제 버튼을 클릭했을 때)
	$(".delete").click(function(){
		//alert("delete");
		$("#customerService").attr("action","customerServiceDelete").submit();
	});
	
});
/*
$(function(){
    
    getCommentList();
    
});
*/

//댓글등록
//class가 commentWrite인 버튼을 클릭했을 때(댓글 등록을 클릭했을 때)
function commentsWrite(){
	
	//alert("등록버튼");
	
	var cno=$("input[name=cno]").val();
	var comments=$("#comments").val();
	var cmuid=$("input[name=cmuid]").val();
	
	//alert("댓글번호 : "+cno);
	//alert("댓글내용 : "+comments);
	//alert("작성자 : "+cmuid);
	
	if(comments==""){
		alert("댓글을 입력하세요.");
		return false;
	}
	
	var comments = {
		"cno":cno,
		"comments":comments,
		"cmuid":cmuid,
	};
	
	$.ajax({
		type:"POST",
		url:"commentsWrite", // @RequestMapping에 들어가는 주소
		contentType : "application/json",
		data : JSON.stringify(comments),
		dataType : "text", // return 타입
		success: function(data){
			alert("댓글이 등록되었습니다.")
			location.reload();
		},
		
		error: function(xhr, status, error) {
			alert("댓글 등록에 실패하였습니다.");
		}
	});
}

//댓글 수정 클릭시 입력창 열기
//class가 commentsModify인 버튼을 클릭했을 때(댓글 수정을 클릭했을 때)
function commentsModify(cmno){
	
	//alert("수정버튼");
	//alert(cmno);
	
	var inputTag = document.getElementById("commentsModify");
	
	/* div이용하는 방법 */
	if(inputTag.style.display == 'none') {
		$(".showInput"+cmno).show();
		inputTag.style.display = 'block';
	}
	
	/* span이용하는 방법 */
	/*
	$(".commentsModifyShow"+cmno).html (
		"<textarea style='width:100%' rows='3' cols='30'" +
		"id='comments' placeholder='수정하실 댓글을 입력하세요.'></textarea>"
		+"<input type='button' value='수정' class='commentsModify' onclick='commentsModify()'>");
	*/
}

//댓글 수정
function commentsModify2(cmno){
	 
	//alert("수정버튼2");
	//alert(cmno);
	
	var cmno=$("input[name=cmno]").val();
	var comments=$("#comments2").val();
	var cmuid=$("input[name=cmuid]").val();
	var cndate_time=$("input[name=cndate_time]").val();
	
	//alert("댓글번호 : "+cmno);
	//alert("댓글내용 : "+comments);
	//alert("작성자 : "+cmuid);
	//alert("댓글수정시간 : "+cndate_time);
	
	var comments = {
			"cmno":cmno,
			"comments":comments,
			"cmuid":cmuid,
			"cndate_time":cndate_time
		};

	if(comments!=null){
		alert("댓글을 입력하세요.");
		return false;
	}
		
	//alert(cmno);
		
	$.ajax({
		type:"POST",
		url:"commentsModify", // @RequestMapping에 들어가는 주소
		contentType : "application/json",
		data : JSON.stringify(comments),
		dataType : "text", // return 타입
		success: function(data){
			alert("댓글이 수정되었습니다.")
			location.reload();
		},
		
		error: function(xhr, status, error) {
			alert("댓글 수정에 실패하였습니다.");
		}
	});
	}

//댓글 삭제
//class가 commentWrite인 버튼을 클릭했을 때(댓글 등록을 클릭했을 때)
function commentsDelete(cmno){
	 
	//alert("삭제버튼");
	//alert(cmno);
	
	//var cmno=$("input[name=cmno]").val();
	
	//alert("댓글번호 : "+cmno);
	
	var comments = {
			"cmno":cmno
		};

	if(comments != null){
		
	//alert(cmno);
		
	$.ajax({
		type:"POST",
		url:"commentsDelete", // @RequestMapping에 들어가는 주소
		contentType : "application/json",
		data : JSON.stringify(comments),
		dataType : "text", // return 타입
		success: function(data){
			alert("댓글이 삭제되었습니다.")
			location.reload();
		},
		
		error: function(xhr, status, error) {
			alert("댓글 삭제에 실패하였습니다.");
		}
	});
	}else{
		alert("오류가 발생하였습니다.")
	}
}