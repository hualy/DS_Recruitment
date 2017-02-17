

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
		if(!timeIsRight($(this).val())){
			setError(thisbar,logo,mess,"*时间格式不正确");
		}else{
			setRight(thisbar,logo,mess);
		}		
	});
	$(".ann").blur(function(){
		var thisbar = $(".annBar");
		var logo = $(this).next();
		var mess = $(this).next().next();
		logo.css("display","inline");
		if(inputIsEmpty($(this).val())){
			setError(thisbar,logo,mess,"*公告内容不能为空");
		}else{
			setRight(thisbar,logo,mess);
		}		
	});
	
	$(".pub-ann-btn").click(function(){
		ok = true;
		$.checkAll();
		if(ok){
			$("#pub-ann-form").submit();
		}
	});
	$(".revise-btn").click(function(){
		ok = true;
		$.checkAll();
		if(ok){
			$("#revise-form").submit();
		}
	});
	
	
});
 $.extend({
	 checkAll : function(){
	 $(".theme").next().css("display","inline");
	 $(".time").next().css("display","inline");
	 $(".ann").next().css("display","inline");
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
	
	if(inputIsEmpty($(".ann").val())){
		ok = false;
		setError($(".annBar"),$(".ann").next(),$(".ann").next().next(),"*公告内容不能为空");
	}else{
		setRight($(".annBar"),$(".ann").next(),$(".ann").next().next());
	}
	
}
});






