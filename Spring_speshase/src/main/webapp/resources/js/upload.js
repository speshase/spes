/**
 * 
 */

function checkImageType(fileName) {
	//alert("aaa="+fileName);
	var pattern = /jpg|gif|png|jpeg/i;
	return fileName.match(pattern);
}

function getImageLink(fileName) {
	if(!checkImageType(fileName)) {
		return;
	}
	var front=fileName.substr(0,12);
	var end=fileName.substr(14);
	
	//alert("front="+front);
	//alert("end="+end);
	
	return front+end;
}

function getOriginalName(fileName){
	//alert("fileName="+fileName);
	return fileName;
}

//마우스로 끄는 이벤트
$(".fileDrop").on("dragenter dragover", function(event) {
	event.preventDefault();
});

//마우스를 놓는 이벤트
$(".fileDrop").on("drop", function(event) {
	event.preventDefault();
	
	//dataTransfer 데이터를 전송할 때 쓰는
	var files=event.originalEvent.dataTransfer.files;
	var file=files[0];
	console.log(file);
	
	var formData = new FormData();
	
	formData.append("file", file);
	
	//받아온 데이터를 controller로 보냄
	$.ajax({
		url:"uploadAjax",
		data:formData,
		dataType:"text",
		processData:false,
		contentType:false,
		type:"post", //form태그로 보낼때는 반드시 post방식
		success:function(data){
		console.log("upload.js -> data="+data);
		//alert(checkImageType(data));
		//alert("data="+data);
			
			var str="";
			
			if(checkImageType(data)) {
				str="<div>"
					+"<img src='displayFile?fileName="+getImageLink(data)+"'/>"
				+"<small data-src=\'"+data+"\'>x</small>"+"</div>";
			}else {
				str="<div><a href='displayFile?fileName="+data+"'>"
				+getOriginalName(data)+"</a></div>";
			}
			$(".uploadedList").append(str);
		}
	})
});

//<small>태그를 click했을 때.
$(".uploadedList").on("click", "small", function(event) {
	var that = $(this);
	
	$.ajax({
		url:"deleteFile",
		type:"post",
		data:{fileName:$(this).attr("data-src")},
		dataType:"text",
		success:function(result){
			if(result=='deleted'){
				//alert("deleted");
				that.parent("div").remove();
			}
		}
	});
});