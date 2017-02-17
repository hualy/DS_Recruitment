
function setError(parent,logo,mess,messText){
	parent.removeClass("has-success");
	parent.addClass("has-error");
	logo.removeClass("glyphicon-ok");
	logo.addClass("glyphicon-remove");
	mess.text(messText);
}
function setRight(parent,logo,mess){
	parent.removeClass("has-error");
	parent.addClass("has-success");
	logo.removeClass("glyphicon-remove");
	logo.addClass("glyphicon-ok");
	mess.text("");
}

function inputIsEmpty(inputObj){//判空函数,空返回true，非空返回false
	if(inputObj == ""){
		return true;
	}else return false;
}

function dateIsRight(date){//判断日期格式，正确返回true，否则返回false
	var dateFormat = new RegExp("\^\\d{4}-\\d{1,2}-\\d{1,2}\$");
	return dateFormat.test(date);
}

function timeIsRight(time){//判断时间格式，正确返回true，否则返回false
	var dateFormat = new RegExp("\^\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}\$");
	return dateFormat.test(time);
}

function imgIsRight(image){//判断图片格式,正确返回true,否则返回false
	var pngFormat = new RegExp(".png\$","i");
	var jpgFormat = new RegExp(".jpg\$","i");
	var jpegFormat = new RegExp(".jpeg\$","i");
	var gifFormat = new RegExp(".gif\$","i");
	var bmpFormat = new RegExp(".bmp\$","i");
	if(pngFormat.test(image)) return true;
	if(jpgFormat.test(image)) return true;
	if(jpegFormat.test(image)) return true;
	if(gifFormat.test(image)) return true;
	if(bmpFormat.test(image)) return true;
	return false;
}












