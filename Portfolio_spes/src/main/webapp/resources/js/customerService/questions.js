/**
 * 
 */
$(document).ready(function(){
	
	//class가 modify인 버튼을 클릭했을 때(글수정버튼을 클릭했을 때)
	$(".modify").click(function(){
		//alert("modify");
		$("#questionsForm").attr("action","questionsModify").submit();
	});
});

/* 게시글 삭제 버튼 */

function questionDelete(qno){
	//alert(qno);
	var result = confirm("정말 게시글을 삭제하시겠습니까?");
	//alert(result);
	
	if(result){
	
	$.ajax({
		type:"GET",
		url:"questionsDelete?qno="+qno,
		success: function(){
			alert("삭제하였습니다.")
			location.reload();
		},
		
		error: function(xhr, status, error) {
			alert("삭제에 실패하였습니다. error : " + error);
		}
	});
		
	}else {
		alert("삭제를 취소하였습니다.")
	}
}


/* questionsList 제목 클릭시 내용 나타내기 */

function questionShow(qno){
	
	var dis = document.getElementById("dis"+qno);
	//alert(dis);
	
	//$(".content").click(function() { // show메서드 실행
		if(dis.style.display == 'none') {
			$(".contentt"+qno).show(); // slow는 속도(fast)
			dis.style.display = 'block';
		}else {
			$(".contentt"+qno).hide();
			dis.style.display = 'none';
		}
	//});
}

/* questionsList 카테고리 선택시 해당내용 나타내기 */

$(document).ready(function(){
	$("select[name=qcategory]").change(function(){
		$("#questionsListForm").attr("action","questionsList").submit();
	});
});

