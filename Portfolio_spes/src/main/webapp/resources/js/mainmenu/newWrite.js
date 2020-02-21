/**
 * 
 */

$("#a_img").change(function(){
	
	if(this.files && this.files[0]){
		var reader = new FileReader;
		reader.onload = function(data){
			$(".select_img1 img").attr("src",data.target.result).width(200);
		}
		reader.readAsDataURL(this.files[0]);
	}
});

$("#b_img").change(function(){
	
	if(this.files && this.files[0]){
		var reader = new FileReader;
		reader.onload = function(data){
			$(".select_img2 img").attr("src",data.target.result).width(200);
		}
		reader.readAsDataURL(this.files[0]);
	}
});

