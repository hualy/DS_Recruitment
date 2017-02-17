



var ok = true;
jQuery(document).ready(function(){
	$(".theme").blur(function(){
		var thisbar = $(".themeBar");
		var logo = $(this).next();
		var mess = $(this).next().next();
		logo.css("display","inline");
		if(inputIsEmpty($(this).val())){
			setError(thisbar,logo,mess,"*主题不能为空");
		}else{
			setRight(thisbar,logo,mess);
		}		
	});
	$(".time").blur(function(){
		var thisbar = $(".timeBar");
		var logo = $(this).next();
		var mess = $(this).next().next();
		logo.css("display","inline");
		if(!dateIsRight($(this).val())){
			setError(thisbar,logo,mess,"*时间格式不正确");
		}else{
			setRight(thisbar,logo,mess);
		}		
	});
	$(".speaker").blur(function(){
		var thisbar = $(".speakerBar");
		var logo = $(this).next();
		var mess = $(this).next().next();
		logo.css("display","inline");
		if(inputIsEmpty($(this).val())){
			setError(thisbar,logo,mess,"*主讲人名字不能为空");
		}else{
			setRight(thisbar,logo,mess);
		}		
	});
	$(document).on("change",".imgs",function(){
		var thisbar = $(this).parent();
		var logo = $(this).next();
		var mess = $(this).next().next();
		logo.css("display","inline");
		if(!imgIsRight($(this).val())){
			setError(thisbar,logo,mess,"*只支持jpg,jpeg,png,bmp,gif格式");
		}else{
			setRight(thisbar,logo,mess);
		}		
	});
		$(".com-result").blur(function(){
		var thisbar = $(".contentBar");
		var logo = $(this).next();
		var mess = $(this).next().next();
		logo.css("display","inline");
		if(inputIsEmpty($(this).val())){
			setError(thisbar,logo,mess,"*交流会总结不能为空");
		}else{
			setRight(thisbar,logo,mess);
		}		
	});
	$(document).on("click",".pub-com-btn",function(){
		ok = true;
		$.checkAll();
		if(ok){
			$("#pub-com-form").submit();
		}
	});
	$(document).on("click",".rev-com-btn",function(){
		ok = true;
		$.checkAll();
		if(ok){
			$("#rev-com-form").submit();
		}
	});
		
		
	
});

 $.extend({
	 checkAll : function(){
	 $(".theme").next().css("display","inline");
	 $(".time").next().css("display","inline");
	 $(".speaker").next().css("display","inline");
	 $(".com-result").next().css("display","inline");
	 $(".imgs").next().css("display","inline");
	if(inputIsEmpty($(".theme").val())){
		ok = false;
		setError($(".themeBar"),$(".theme").next(),$(".theme").next().next(),"*主题不能为空");
	}else{
		setRight($(".themeBar"),$(".theme").next(),$(".theme").next().next());
	}	
	
	if(inputIsEmpty($(".time").val())){
		ok = false;
		setError($(".timeBar"),$(".time").next(),$(".time").next().next(),"*时间格式不对");
	}else{
		setRight($(".timeBar"),$(".time").next(),$(".time").next().next());
	}
	
	if(inputIsEmpty($(".speaker").val())){
		ok = false;
		setError($(".speakerBar"),$(".speaker").next(),$(".speaker").next().next(),"*主讲人名字不能为空");
	}else{
		setRight($(".speakerBar"),$(".speaker").next(),$(".speaker").next().next());
	}
	
	if(inputIsEmpty($(".com-result").val())){
		ok = false;
		setError($(".contentBar"),$(".com-result").next(),$(".com-result").next().next(),"*交流会总结不能为空");
	}else{
		setRight($(".contentBar"),$(".com-result").next(),$(".com-result").next().next());
	}
	
	$(".imgs").each(function(){
		if(inputIsEmpty($(this).val())){
			ok = false;
			setError($(this).parent(),$(this).next(),$(this).next().next(),"*请选择图片");
		}else{
			if(!imgIsRight($(this).val())){
				ok = false;
				
				setError($(this).parent(),$(this).next(),$(this).next().next(),"*只支持jpg,jpeg,png,bmp,gif格式");
			}else{
				setRight($(this).parent(),$(this).next(),$(this).next().next());
			}
		}
	});	
	
}
});














