/**
 * 
 */

var bno = 1;
var str = "";

$.getJSON("../replies/all/" + bno, function(data) {
	// alert(data);
	// alert(data.length);
	console.log(data.length);

	$(data).each(
			function() {
				str += "<li data-rno='" + this.rno + "' class='replyLi'>"
						+ this.rno + ":" + this.replytext
						+" "+"<input type='button' value='수정'>"
						;
			});
	$("#replies").html(str);
});

//댓글쓰기 버튼 클릭
$(document).ready(function() {
	$("#modDiv").hide();
	$("#replyAddBtn").on("click", function() {
		alert("버튼적용!");

		var bno = $("#newbBno").val();
		var replyer = $("#newReplyWriter").val();
		var replytext = $("#newReplyText").val();
		/*
		 * alert(bno); alert(replyer); alert(replytext);
		 * 
		 * console.log("bno : "+bno); console.log("replyer : "+replyer);
		 * console.log("replytext : "+replytext);
		 */
		
		$.ajax({
			type : "post", // post=추가
			url : "../replies", // @RequestMapping에 들어가는 주소
			contentType : "application/json",
			dataType : "text",
			data : JSON.stringify({
				bno : bno, replyer : replyer, replytext : replytext
			}),
			success : function(data) {
				alert("등록되었습니다.");
			},
			error : function(err) {
				alert("등록에 실패하였습니다.");
			}
		});
	});	

	
//댓글 수정 버튼 띄우기
//.replyLi 클래스의 button을 클릭하면!
$("#replies").on("click", ".replyLi input[type='button']", function(){

	var reply = $(this).parent();
	
	var rno = reply.attr("data-rno") //부모요소에서 data-rno를 getter하여 rno에 저장, setter는 attr("data-rno", 1)
	alert(rno);

	var replytext1 = reply.text().split(":");
	var replytext = replytext1[1];
	alert(replytext);
	
	$(".modal-title").html(rno);
	$("#replytext").val(replytext);
	$("#modDiv").show("slow");
	
	//alert(rno + " : " + replytext);
});

//수정하기
$("#replyModBtn").on("click", function(){
	var rno=$(".modal-title").html();
	var replytext=$("#replytext").val();
		
	$.ajax({
		type : "put", // put=수정
		url : "../replies/"+rno, // @RequestMapping에 들어가는 주소
		contentType : "application/json",
		dataType : "text",
		data : JSON.stringify({
			replytext : replytext
		}),
		success : function(data) {
			if(data=="SUCCESS") {
			alert("수정되었습니다.");
			$("#modDiv").hide("slow");
			}
		},
		error : function(err) {
			alert("수정에 실패하였습니다.");
		}
	});
});

//삭제하기
$("#replyDelBtn").on("click", function(){
	var rno=$(".modal-title").html();
		
	$.ajax({
		type : "delete", // delete=삭제
		url : "../replies/"+rno, // @RequestMapping에 들어가는 주소
		contentType : "application/json",
		dataType : "text",
		data : JSON.stringify({
			replytext : replytext
		}),
		success : function(data) {
			if(data=="SUCCESS") {
			alert("삭제되었습니다.");
			$("#modDiv").hide("slow");
			}
		},
		error : function(err) {
			alert("삭제에 실패하였습니다.");
		}
	});
});

//닫기
$("#closeBtn").on("click", function(){
	$("#modDiv").hide("slow");
});

});