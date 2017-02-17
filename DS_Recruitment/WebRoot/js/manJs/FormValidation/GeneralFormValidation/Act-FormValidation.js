
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
	$(".date").blur(function(){
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
	$(".origanzier").blur(function(){
		var thisbar = $(".oriBar");
		var logo = $(this).next();
		var mess = $(this).next().next();
		logo.css("display","inline");
		if(inputIsEmpty($(this).val())){
			setError(thisbar,logo,mess,"*组织者名字不能为空");
		}else{
			setRight(thisbar,logo,mess);
		}		
	});
	$("#introduce").blur(function(){
		var thisbar = $(".intBar");
		var logo = $(this).next();
		var mess = $(this).next().next();
		logo.css("display","inline");
		if(inputIsEmpty($(this).val())){
			setError(thisbar,logo,mess,"*活动内容不能为空");
		}else{
			setRight(thisbar,logo,mess);
		}		
	});
	$(".thoughts").blur(function(){
		var thisbar = $(".thoBar");
		var logo = $(this).next();
		var mess = $(this).next().next();
		logo.css("display","inline");
		if(inputIsEmpty($(this).val())){
			setError(thisbar,logo,mess,"*活动感想不能为空");
		}else{
			setRight(thisbar,logo,mess);
		}		
	});
//	$(".imgs").change(function(){
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
	$(document).on("click",".pub-act-btn",function(){
		ok = true;
		$.checkAll();
		if(ok){
			$("#pub-act-form").submit();
		}
	});
	$(document).on("click",".rev-act-btn",function(){
		ok = true;
		$.checkAll();
		if(ok){
			$("#rev-act-form").submit();
		}
	});
});

 $.extend({
	 checkAll : function(){
	 $(".theme").next().css("display","inline");
	 $(".date").next().css("display","inline");
	 $(".origanzier").next().css("display","inline");
	 $("#introduce").next().css("display","inline");
	 $(".thoughts").next().css("display","inline");
	 $(".imgs").next().css("display","inline");
	if(inputIsEmpty($(".theme").val())){
		ok = false;
		setError($(".themeBar"),$(".theme").next(),$(".theme").next().next(),"*主题不能为空");
	}else{
		setRight($(".themeBar"),$(".theme").next(),$(".theme").next().next());
	}	
	
	if(inputIsEmpty($(".date").val())){
		ok = false;
		setError($(".timeBar"),$(".date").next(),$(".date").next().next(),"*时间格式不对");
	}else{
		setRight($(".timeBar"),$(".date").next(),$(".date").next().next());
	}
	
	if(inputIsEmpty($(".origanzier").val())){
		ok = false;
		setError($(".oriBar"),$(".origanzier").next(),$(".origanzier").next().next(),"*组织者名字不能为空");
	}else{
		setRight($(".oriBar"),$(".origanzier").next(),$(".origanzier").next().next());
	}
	
	if(inputIsEmpty($("#introduce").val())){
		ok = false;
		setError($(".intBar"),$("#introduce").next(),$("#introduce").next().next(),"*活动内容不能为空");
	}else{
		setRight($(".intBar"),$("#introduce").next(),$("#introduce").next().next());
	}
	
	if(inputIsEmpty($(".thoughts").val())){
		ok = false;
		setError($(".thoBar"),$(".thoughts").next(),$(".thoughts").next().next(),"*活动感想不能为空");
	}else{
		setRight($(".thoBar"),$(".thoughts").next(),$(".thoughts").next().next());
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








