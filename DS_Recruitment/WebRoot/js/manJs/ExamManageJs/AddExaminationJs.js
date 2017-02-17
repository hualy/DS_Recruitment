
var add_fill_num = 0;
jQuery(document).ready(function(){
	$(function () {
	  $('[data-toggle="tooltip"]').tooltip()
	});
	var cho_num = 0;
	$(".add-cho-btn").click(function(){	
		cho_num++;
		$(".add-cho-btn").parent().parent().before('<div class="container topic-piece">'+
						       				'<div class="form-group">'+
											    '<label class="col-sm-2 control-label">题目：</label>'+
											    '<div class="col-sm-10">'+
											      '<input type="text" class="form-control"  placeholder="请输入题目内容" name="mtitle">'+
											    '</div>'+
										  	'</div>'+
						       				'<div class="form-group">'+
											    '<label class="col-sm-2 control-label">选项A：</label>'+
											    '<div class="col-sm-10">'+
											      '<input type="text" class="form-control"  placeholder="请输入选项内容" name="optionA">'+
											    '</div>'+
										  	'</div>'+
						       				'<div class="form-group">'+
											    '<label class="col-sm-2 control-label">选项B：</label>'+
											    '<div class="col-sm-10">'+
											      '<input type="text" class="form-control"  placeholder="请输入选项内容" name="optionB">'+
											    '</div>'+
										  	'</div>'+
						       				'<div class="form-group">'+
											    '<label class="col-sm-2 control-label">选项C：</label>'+
											    '<div class="col-sm-10">'+
											      '<input type="text" class="form-control"  placeholder="请输入选项内容" name="optionC">'+
											    '</div>'+
										  	'</div>'+										  											  	
						       				'<div class="form-group">'+
											    '<label class="col-sm-2 control-label">选项D：</label>'+
											    '<div class="col-sm-10">'+
											      '<input type="text" class="form-control"  placeholder="请输入选项内容" name="optionD">'+
											    '</div>'+
										  	'</div>'+
										 '<div class="form-group">'+
										  		'<label class="col-sm-2 control-label">正确选项:</label>'+
								                '<span class="radio col-sm-1">'+
								                  '<label>'+
								                    '<input type="radio" name="rightAnswer'+cho_num+'" value="A" checked class="Answer">A'+
								                 ' </label>'+
								                '</span>'+
								                '<span class="radio col-sm-1">'+
								                 ' <label>'+
								                    '<input type="radio" name="rightAnswer'+cho_num+'" value="B" class="Answer">B'+
								                  '</label>'+
								                '</span>'+
								                '<span class="radio col-sm-1">'+
								                  '<label>'+
								                   ' <input type="radio" name="rightAnswer'+cho_num+'" value="C" class="Answer">C'+
								                  '</label>'+
								                '</span>'+	
								                '<span class="radio col-sm-1">'+
								                  '<label>'+
								                   ' <input type="radio" name="rightAnswer'+cho_num+'" value="D" class="Answer">D'+
								                  '</label>'+
								               '</span>	'+							                							                
										  	'</div>'+
										  	'<input type="hidden" value="A" name="mrightAnswer"/>'+
										  '</div>'
										  	
		
		);		
	});
	$(document).on("click",".Answer",function(){
		$(this).parent().parent().parent().next().val($(this).val());
	});
	
	var fillTopicNum = 0;
	$(".add-fill-btn").click(function(){
		add_fill_num ++;
		$(this).parent().parent().before(
				'<div class="container topic-piece" id="location'+add_fill_num+'">'+
					'<div class="form-group">'+
						'<label class="col-sm-2 control-label">题目：</label>'+
							'<div class="col-sm-10 cont">'+
								'<div class="input-group">'+
									'<input type="text" name="ftitle" class="form-control fill-input"  placeholder=\'请输入题目内容         请用   "_"  代替空格输入\' data-toggle="tooltip" data-placement="top" title="用下划线替代填空题的空格。示例：前端主要学_语言、_语言。注意：下划线需为英文输入">'+
									'<span class="input-group-btn">'+
										'<button class="btn btn-default fill-ans-btn" type="button" location="'+add_fill_num+'" data-toggle="tooltip" data-placement="top" title="一旦生成，将无法修改题目" >生成答案域</button>'+
									'</span>'+
								'</div>'+
							'</div>'+
					 '</div>'+
					 '<input type="hidden" value="0" id="frightAnswer'+add_fill_num+'" name="frightAnswernums"/>'+
				 '</div>'
		);
		$(function () {
		  $('[data-toggle="tooltip"]').tooltip()
		});
	});
	
	$(".add-pro-btn").click(function(){
		$(this).parent().parent().before(
				'<div class="container topic-piece">'+
					'<div class="form-group">'+
						'<label class="col-sm-2 control-label">题目：</label>'+
							'<div class="col-sm-10">'+
								'<input type="text" class="form-control"  placeholder="请输入题目内容" name="ptitle">'+
							'</div>'+
					'</div>'+
				'</div>'
		);
	});
	
	$(document).on("click",".fill-ans-btn",function(){
//		var thisPiece = $(this).parent().parent().parent().parent().parent();
		//var fill = $(this).parent().prev().val();
//		var fill = $(this).parent().parent().children(".fill-input").val()
		//alert(fill);
		var addFillBar = $(".add-fill-bar");
		var thisPiece = addFillBar.children("#location"+$(this).attr("location"));
		var thisInput = thisPiece.children(".form-group").children(".cont").children(".input-group").children(".fill-input");
		var thisHidden = thisPiece.children("#frightAnswer"+$(this).attr("location"));
		var fill = thisInput.val();
		
		var fillNum = 0;
		for(var i in fill){
			if(fill[i] == "_"){
				fillNum++;
			}
		}
		if(fillNum == 0) return;
		thisHidden.val(fillNum);
		//$(this).parent().prev().attr("disabled",true);
//		$(this).parent().parent().children(".fill-input").attr("disabled",true);
		thisInput.attr("readonly",true);
	//	alert(fillNum);
		for(var i = 1;i<=fillNum;i++){
			thisPiece.append(
				'<div class="form-group">'+
					'<label class="col-sm-2 control-label">正确答案'+i+'：</label>'+
					'<div class="col-sm-10">'+
				     '<input type="text" name="frightAnswer" class="form-control fill"  placeholder="请输入正确答案'+i+'">'+
					'</div>'+			
				'</div>'
			);	
		}
		var tooltip = thisPiece.children(".form-group").children(".cont").children(".input-group").children(".input-group-btn").children(".tooltip");
		tooltip.css("display","none");
		$(this).attr("disabled",true);
	});	
	
	
	$("#submit").click(function(){
		
		$.ajax({
			type: "POST",
			url: "admin/examination_manager/addASetOfExaminationQuestionsAction",
			dataType: "HTML",
			data: $("#add-form").serialize(), 
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
									window.location.href = "admin/examination_manager/getALLTheExaminationQuestionsAction";
								}
							);
					}
			
		});
		
		return false;									//防止页面自动跳转
		
		
	});
	
	
	
	
	
});






