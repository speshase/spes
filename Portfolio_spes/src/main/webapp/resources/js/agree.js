/**
 * 
 */

$(document).ready(function(){
	
	//id가 agree인 버튼을 클릭했을 때
	$("#agree").click(function(){
		if($('#checkBox01').prop('checked') == false || $('#checkBox02').prop('checked') == false){
            alert('필수 약관에 동의 하셔야 합니다.');
		}else{
		$(location).attr("href","join");
		}
	})
});