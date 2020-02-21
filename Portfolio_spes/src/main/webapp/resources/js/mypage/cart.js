

/* 상품 개수 수정 */
function cartModify(cp, cpprice, countval, count){
	
	var count=parseInt(count);
	var cpprice=parseInt(cpprice);

	//alert("cp="+cp);
	//alert("cpprice="+cpprice);
	//alert("cpprice="+(cpprice/count));
	//alert("countval="+countval);
	//alert("count="+count);
    
    if(countval=='-'){
    	//alert("-");
        if(count<2){
        	alert("상품 개수는 1개 이상이어야 합니다.")
            return count=1;
        }
        //alert("count-1="+(count-1));
        count=(count-1);
    }else if(countval=='+'){
    	//alert("+");
    	//alert("count+1="+(count+1));
    	count=(count+1);
    }
    
    //$(window).bind("beforeunload", function (e){

        $.ajax({
    		type:"POST",
    		url:"cartModify", // @RequestMapping에 들어가는 주소
    		data : {"count":count, "cp":cp, "cpprice":cpprice},
    		
    		success: function(){
    			location.reload();
    		},
    		
    		error: function(xhr, status, error) {
    			alert("에러에러");
    		}
    	});  
};

/* 계산 테이블 */
function deli(sum){
	alert(sum);
	
}


/* 상품 삭제 */

function cartDelete(cp){
	//alert(cp);
	var result = confirm("정말 이 상품을 삭제하시겠습니까?");
	//alert(result);
	
	if(result){
	
	$.ajax({
		type:"POST",
		url:"cartDelete",
		data : {"cp":cp},
		
		success: function(){
			alert("상품을 삭제하였습니다.")
			location.reload();
		},
		
		error: function(xhr, status, error) {
			alert("에러에러");
		}
	});
		
	}else {
		alert("삭제를 취소하였습니다.")
	}
}

