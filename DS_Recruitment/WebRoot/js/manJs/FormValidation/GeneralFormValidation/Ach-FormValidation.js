
function ach_formValidation(){//发布成果页面表单验证函数,没问题返回true，有问题返回false
	var ok = 1;
	$("#TMessLogo").css("display","inline");
	$(".leaderName").next().css("display","inline");
	$(".membersName").next().css("display","inline");
	$(".date").next().css("display","inline");
	$(".imgs").next().css("display","inline");
	if(inputIsEmpty($("#theme").val())){//判断主题输入框是否空
		ok = 0;
		$(".themeBar").removeClass("has-success");
		$(".themeBar").addClass("has-error");
		$("#TMessLogo").removeClass("glyphicon-ok");
		$("#TMessLogo").addClass("glyphicon-remove");
		$("#themeMess").css("display","inline");
	}else{
		$(".themeBar").removeClass("has-error");
		$(".themeBar").addClass("has-success");
		$("#TMessLogo").removeClass("glyphicon-remove");
		$("#TMessLogo").addClass("glyphicon-ok");
		$("#themeMess").css("display","none");
	}
	if(inputIsEmpty($(".leaderName").val())){//判断组长输入框是否空
		ok = 0;
		$(".leaderName").parent().removeClass("has-success");
		$(".leaderName").parent().addClass("has-error");
		$(".leaderName").next().removeClass("glyphicon-ok");
		$(".leaderName").next().addClass("glyphicon-remove");
		$("#leaderMess").text("*组长名字不能为空");
	}else{
		$(".leaderName").parent().removeClass("has-error");
		$(".leaderName").parent().addClass("has-success");
		$(".leaderName").next().removeClass("glyphicon-remove");
		$(".leaderName").next().addClass("glyphicon-ok");
		$("#leaderMess").text("");
	}
	if(inputIsEmpty($(".membersName").val())){//判断组员输入框是否空
		ok = 0;
		$(".membersName").parent().removeClass("has-success");
		$(".membersName").parent().addClass("has-error");
		$(".membersName").next().removeClass("glyphicon-ok");
		$(".membersName").next().addClass("glyphicon-remove");
		$("#membersMess").append("*成员名字不能为空");
	}else{
		$(".membersName").parent().removeClass("has-error");
		$(".membersName").parent().addClass("has-success");
		$(".membersName").next().removeClass("glyphicon-remove");
		$(".membersName").next().addClass("glyphicon-ok");
		$("#membersMess").text("");
	}
	if(inputIsEmpty($(".description").val())){//判断项目简介输入框是否空
		ok = 0;
		$(".desBar").removeClass("has-success");
		$(".desBar").addClass("has-error");
		$("#DesMess").text("*简介不能为空");
	}else{
		$(".desBar").removeClass("has-error");
		$(".desBar").addClass("has-success");
		$("#DesMess").text("");
	}
	if(!dateIsRight($(".date").val())){//判断日期格式是否错误
		ok = 0;
		$(".dateBar").removeClass("has-success");
		$(".dateBar").addClass("has-error");
		$(".date").next().removeClass("glyphicon-ok");
		$(".date").next().addClass("glyphicon-remove");
		$("#dateMess").text("*日期格式错误，正确格式:2016-2-29");		
	}else{
		$(".dateBar").removeClass("has-error");
		$(".dateBar").addClass("has-success");
		$(".date").next().removeClass("glyphicon-remove");
		$(".date").next().addClass("glyphicon-ok");
		$("#dateMess").text("");
	}
	$(".imgs").each(function(){//判断图片选择是否正确

		if(imgIsRight($(this).val())){
			$(this).parent().removeClass("has-error");
			$(this).parent().addClass("has-success");
			$(this).next().removeClass("glyphicon-remove");
			$(this).next().addClass("glyphicon-ok");
			$(this).next().next().text("");
		}else{
			ok = 0;
			$(this).parent().removeClass("has-success");
			$(this).parent().addClass("has-error");
			$(this).next().removeClass("glyphicon-ok");
			$(this).next().addClass("glyphicon-remove");
			$(this).next().next().text("只支持png,jpg,jpeg,gif,bmp格式图片");	
		}
	});

	
	if(ok == 1) return true;
	else return false;	
}











