/**
 * 
 */

$(document).ready(function(){
	
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

	});
	*/
	
	/* questionsList 제목 클릭시 내용 나타내기 */

	// jquery를 활용 //
	$("#showClick").click(function(){
		alert("dd");
		$("#showContent").css('display', 'block');
		/*$("#showContent").hide(); // 숨기기
		$("#showContent").show(); // 보이기 */
	})
});