//alert("룰루~! 보기화면 연결~!");

$(document).ready(function(){
	
	// id가 modify인 버튼을 클릭했을 때(수정버튼을 클릭했을 때)
	$("#modify").click(function(){
		// alert("modify");
		$("#newform").attr("action","newModify");
	});
	
});

function newDelete(np){
	// alert(np);
	var result = confirm("정말 게시글을 삭제하시겠습니까?");
	// alert(result);
	
	if(result){
	
	$.ajax({
		type:"GET",
		url:"newDelete?np="+np,
		success: function(){
			alert("삭제하였습니다.")
			location.href="new";
		},
		
		error: function(xhr, status, error) {
			alert("삭제에 실패하였습니다. error : " + error);
		}
	});
		
	}else {
		alert("삭제를 취소하였습니다.")
	}
}


/* 상품 수량 조절 */

$(document).ready(function(){
    $('.__count_range input[count_range]').click(function(e){
        e.preventDefault();
        var type = $(this).attr('count_range');
        var $count = $(this).parent().children('input.count');
        var count_val = $count.val(); // min 1
        if(type=='m'){
            if(count_val<2){
                return;
            }
            $count.val(parseInt(count_val)-1);
        }else if(type=='p'){
            $count.val(parseInt(count_val)+1);
        }
    });
});

/* 장바구니 */

function cartin(np){
	
	var cfile1=$("input[name=cfile1]").val(); /* 상품이미지 */
	var ctitle=$("input[name=ctitle]").val(); /* 상품이름 */
	var count=$("input[name=count]").val(); /* 상품 개수 */
	var cpprice=$("input[name=cpprice]").val(); /* 상품 금액 */
	var uid=$("input[name=uid]").val(); /* 로그인 아이디 */
	
	//alert(np);
	//alert(cfile1);
	//alert(ctitle);
	//alert(count);
	//alert(cpprice);
	//alert(uid);
	
	var cart = {
		"np":np,
		"cfile1":cfile1,
		"ctitle":ctitle,
		"count":count,
		"cpprice":cpprice
	};
	
	$.ajax({
		type:"POST",
		url:"../mypage/cart", // @RequestMapping에 들어가는 주소
		contentType : "application/json",
		data : JSON.stringify(cart),
		success: function(data){
			//alert(data)
			if(data==0) {
				alert("장바구니에 담겼습니다.")
				location.reload();
			}
			else if(data==100){
				alert("로그인을 먼저 해주세요.")
			}
			else if(data==1){
				alert("장바구니에 이미 존재하는 상품입니다.")
			}
		},
		
		error: function(xhr, status, error) {
			alert("장바구니 담기에 실패하였습니다. 나중에 다시 시도해주세요.");
		}
	});
	
	
	
}

