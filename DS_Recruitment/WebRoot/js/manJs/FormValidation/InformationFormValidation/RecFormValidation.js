

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
	$("#describe").blur(function(){
		var thisbar = $(".desBar");
		var logo = $(this).next();
		var mess = $(this).next().next();
		logo.css("display","inline");
		if(inputIsEmpty($(this).val())){
			setError(thisbar,logo,mess,"*招新内容不能为空");
		}else{
			setRight(thisbar,logo,mess);
		}		
	});
	
	$(".pub-rec-btn").click(function(){
		ok = true;
		$.checkAll();
		if(ok){
			$("#pub-rec-form").submit();
		}
	});
	$("#revise-btn").click(function(){
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
	
	if(inputIsEmpty($("#describe").val())){
		ok = false;
		setError($(".desBar"),$("#describe").next(),$("#describe").next().next(),"*招新内容不能为空");
	}else{
		setRight($(".desBar"),$("#describe").next(),$("#describe").next().next());
	}
	
}
});
















