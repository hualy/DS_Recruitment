jQuery(document).ready(function(){
	
	$(".pub-newExam-btn").click(function(){
		$(".exam-message-form").attr("action",true);
		$(".exam-message-form").attr("action","admin/examination_manager/addInformationForExamAction");//增加考试信息的action
		$(".submit-btn").attr("id",true);
		$(".submit-btn").attr("id","add-exam-mess");//增加考试信息对应的提交按钮的id
		$("#examName").val("");
		$("#wholeTime").val("");
		$(".exist-exam").slideUp();
		$(".breadcrumb").children(".active").text("新增考试");
		$("#ExamInformationForm").slideDown();
	});
	
	
	$(document).on("click","#rev-EM-btn",function(){
		$(".exam-message-form").attr("action",true);
		$(".exam-message-form").attr("action","admin/examination_manager/reviseInformationForExamAction");//修改的action
		$(".submit-btn").attr("id",true);
		$(".submit-btn").attr("id","rev-exam-mess");//修改考试信息对应的提交按钮的id
		$(".exist-exam").slideUp();
		$(".breadcrumb").children(".active").text("修改考试");
		$("#ExamInformationForm").slideDown();
		
		var id = $(this).attr("location");
		
		$.ajax({
			type: "POST",
			url: "admin/examination_manager/getTheInformationForExamAction",
			dataType: "HTML",
			data: {'id':id},
			success: function(data){
						var result = jQuery.parseJSON(data);
						var examName = result.examName;
						var setID = result.setID;
						var wholeTime = result.wholeTime;
						$("#examName").val(examName);
						$("#setID").val(setID);
						$("#wholeTime").val(wholeTime);
						$("#ID").val(id);
					}
			
		});
	});
	
	
	$(document).on("click","#giveUp-btn",function(){
		$("#ExamInformationForm").slideUp();
		$(".breadcrumb").children(".active").text("当前已有考试");
		$(".exist-exam").slideDown();
	});
	
	$(document).on("click","#close-exam-btn",function(){
		
		var thisParent = $(this).parent();
		alert("恭喜你成功按下关闭试题按钮"+$(this).attr("location"));
		thisParent.empty();
		thisParent.append("<span>考试已结束</span>");
	});
	
	$(document).on("click",".pub-btn",function(){
		alert("恭喜你成功按下发布按钮"+$(this).attr("location"));
		location.href = "http://www.baidu.com";
	});
	
	$(document).on("click",".pickUp-btn",function(){
		alert("恭喜你成功按下提取试题按钮"+$(this).attr("location"));
		location.href = "http://http://www.w3school.com.cn";
	});
	
	//新增考试页面的提交按钮
	$(document).on("click","#add-exam-mess",function(){
		$.ajax({
			type: "POST",
			url: "admin/examination_manager/addInformationForExamAction",
			dataType: "HTML",
			data: $("#pub-exam-message").serialize(), 
			success: function(result){
							swal({
								title: "添加成功",  
								text: "Your data has been saved!",
								type: "success",   
								confirmButtonColor: "#DD6B55",   
								confirmButtonText: "确认",   
								closeOnConfirm: false
								},
								function(){
									window.location.href = "admin/examination_manager/getAllInformationForExamAction";
								}
							);
					}
			
		});
		
		return false;									//防止页面自动跳转
		
	});
	
		
	//修改考试页面的提交按钮
	$(document).on("click","#rev-exam-mess",function(){
		
		$.ajax({
			type: "POST",
			url: "admin/examination_manager/reviseInformationForExamAction",
			dataType: "HTML",
			data: $("#pub-exam-message").serialize(), 
			success: function(result){
							swal({
								title: "修改成功",  
								text: "Your data has been relesed!",
								type: "success",   
								confirmButtonColor: "#DD6B55",   
								confirmButtonText: "确认",   
								closeOnConfirm: false
								},
								function(){
									window.location.href = "admin/examination_manager/getAllInformationForExamAction";
								}
							);
					}
			
		});
		
		return false;									//防止页面自动跳转
		
	});

	
	
	
});