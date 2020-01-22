/**
 * 
 */
$(document).ready(function(){
	
	//class가 modify인 버튼을 클릭했을 때(글수정버튼을 클릭했을 때)
	$(".modify").click(function(){
		alert("modify");
		$("#questionsForm").attr("action","questionsModify").submit();
	})
	
	//class가 delete인 버튼을 클릭했을 때(글삭제버튼을 클릭했을 때)
	$(".delete").click(function(){
		alert("delete");
		$("#questionsForm").attr("action","customer/questionsDelete")
	})

	

//alert("QuestionsList 연결!")
	/*
	$("#qcategory").change(function(){
		var qca =  $("#qcategory option:selected").val();
		//alert(qca);
    
		$.ajx({
			type : "GET",
            url : "qcategory?qca="+qca,
            dataType:"json",
            success : function(data) {
            	console.log(data);

            },
            error
		})
	});*/

	
/* questionsList 제목 클릭시 내용 나타내기 */

	// jquery를 활용 //
	// show & hide & toggle

	$(".content2").hide();
	var contentclick = false;
	$(".content").click(function() { // show메서드 실행
		if(contentclick == false) {
			$(".content2").show(); // slow는 속도(fast)
			
			contentclick = true;
		}else {
			$(".content2").hide();
			contentclick = false;
		}
	});
});