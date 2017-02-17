
var OK = true;
jQuery(document).ready(function(){
	$("#name").blur(function(){//姓名输入框验证
		var namebar = $(".nameBar");
		var logo = $(this).next();
		var mess = $(this).next().next();
		logo.css("display","inline");
		if(inputIsEmpty($(this).val())){
			setError(namebar,logo,mess,"*姓名不能为空");
		}else{
			setRight(namebar,logo,mess);
		}
	});
	$("#introduce").blur(function(){//介绍输入框验证
		var intbar = $(".intBar");
		var logo = $(this).next();
		var mess = $(this).next().next();
		logo.css("display","inline");
		if(inputIsEmpty($(this).val())){
			setError(intbar,logo,mess,"*介绍不能为空");
		}else{
			setRight(intbar,logo,mess);
		}		
	});
	$("#describe").blur(function(){//留言框验证
		var desbar = $(".desBar");
		var logo = $(this).next();
		var mess = $(this).next().next();
		logo.css("display","inline");
		if(inputIsEmpty($(this).val())){
			setError(desbar,logo,mess,"*留言不能为空");
		}else{
			setRight(desbar,logo,mess);
		}
	});
	
	
	
	$(".pub-mem-btn").click(function(){
		OK = true;
		checkAll();
		if(OK){
			$("#pub-mem-form").submit();
		}	
	});
	$(".rev-mem-btn").click(function(){
		OK = true;
		checkAll();
		if(OK){
			$("#rev-mem-form").submit();
		}	
	});
});

function checkAll(){//检查所有输入框是否正确
		if(inputIsEmpty($("#name").val())){
			OK = false;
			$("#name").next().css("display","inline");
			setError($(".nameBar"),$("#name").next(),$("#name").next().next(),"*姓名不能为空");
		}else{
			$("#name").next().css("display","inline");
			setRight($(".nameBar"),$("#name").next(),$("#name").next().next());
		}
		
		
		if(inputIsEmpty($("#introduce").val())){
			OK = false;
			$("#introduce").next().css("display","inline");
			setError($(".intBar"),$("#introduce").next(),$("#introduce").next().next(),"*介绍不能为空");
		}else{
			$("#introduce").next().css("display","inline");
			setRight($(".intBar"),$("#introduce").next(),$("#introduce").next().next());
		}
		
		
		if(inputIsEmpty($("#describe").val())){
			OK = false;
			$("#describe").next().css("display","inline");
			setError($(".desBar"),$("#describe").next(),$("#describe").next().next(),"*留言不能为空");
		}else{
			$("#describe").next().css("display","inline");
			setRight($(".desBar"),$("#describe").next(),$("#describe").next().next());
		}
		
		if($(".mem-photo").attr("src") == undefined){
			OK = false;
			setError($(".imgBar"),$(".logo"),$(".logo").next(),"*图片不能为空");
		}else{
			if(!imgIsRight($(".mem-photo").attr("src"))){
				OK = false;
				setError($(".imgBar"),$(".logo"),$(".logo").next(),"*请用jpg,png,jpeg,gif,bmp格式图片");
			}else{
				setRight($(".imgBar"),$(".logo"),$(".logo").next());
			}
		}
}






















