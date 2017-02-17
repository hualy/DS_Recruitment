
var cho_num = 0;//用于选择题单选框

var rev_cho_num = 0;
var cho_objects = new Array();
var add_fill_num = 0;

jQuery(document).ready(function(){
	$(function () {
	  $('[data-toggle="tooltip"]').tooltip()
	});
	
	
	choose_manage();//选择题增加函数
	fill_manage();//填空题 增加函数
	programme_manage();//程序题增加函数
	revise();//修改已有试题函数
	score_manage();//分值管理
});

function score_manage(){
	var cho_score = 0;
	var fill_score = 0;
	var pro_score = 0;
	//修改分值按钮
	$(".score-rev-btn").click(function(){
		if($(this).text() == "修改"){
			$(".score-input").attr("disabled",false);
			cho_score = $(".score-input").eq(0).val();
			fill_score = $(".score-input").eq(1).val();
			pro_score = $(".score-input").eq(2).val();
			$(this).text("确认修改");
			$(".score-rev-cancel-btn").css("display","inline");
		}else if($(this).text() == "确认修改"){
			//此处省略ajax代码
			$(".score-input").attr("disabled",true);
			$(this).text("修改");
			$(".score-rev-cancel-btn").css("display","none");
		}
	});
	//取消修改分值按钮
	$(".score-rev-cancel-btn").click(function(){
		$(".score-input").eq(0).val(cho_score);
		$(".score-input").eq(1).val(fill_score);
		$(".score-input").eq(2).val(pro_score);
		$(".score-input").attr("disabled",true);
		$(".score-rev-btn").text("修改");
		$(this).css("display","none");
	});
	
	
}


function revise(){
	var input = $(".answer").children(".rev-input").children(input);
	var topic_input = $(".topic").children(".rev-input").children(input);
	input.attr("disabled",true);
	topic_input.attr("disabled",true);
	$(".rev-cho-btn").click(function(){
		var thisTopic = $(this).parent().parent().parent();
		var topic_rev = thisTopic.children(".topic").children(".rev-input").children(input);
		var answer_rev = thisTopic.children(".answer").children(".rev-input").children(input);
		topic_rev.attr("disabled",false);
		answer_rev.attr("disabled",false);
		$(this).css("display","none");
		$(this).parent().children(".sure-rev-btn").css("display","inline");
		$(this).parent().children(".cancel-btn").css("display","inline");
		$(this).parent().children(".cancel-btn").attr("cancel",rev_cho_num);
		rev_cho_num ++;
		//$(this).remove();
	});
	$(".rev-fill-btn").click(function(){	
		var thisTopic = $(this).parent().parent().parent();
		var topic_rev = thisTopic.children(".topic").children(".rev-input").children(input);
		var answer_rev = thisTopic.children(".answer").children(".rev-input").children(input);
		topic_rev.attr("disabled",false);
		answer_rev.attr("disabled",false);
		$(this).css("display","none");
		$(this).next(".sure-rev-btn").css("display","inline");
		//$(this).remove();
	});
	$(".rev-pro-btn").click(function(){	
		var thisTopic = $(this).parent().parent().parent();
		var topic_rev = thisTopic.children(".topic").children(".rev-input").children(input);
		topic_rev.attr("disabled",false);
		$(this).css("display","none");
		$(this).next(".sure-rev-btn").css("display","inline");
		//$(this).remove();
	});
	$(".cancel-btn").click(function(){
		rev_cho_num --;
		$(this).parent().children(".cancel-btn").attr("cancel",false);
		var thisTopic = $(this).parent().parent().parent();
		var topic_rev = thisTopic.children(".topic").children(".rev-input").children(input);
		var answer_rev = thisTopic.children(".answer").children(".rev-input").children(input);
		topic_rev.attr("disabled",true);
		answer_rev.attr("disabled",true);
		$(this).css("display","none");
		$(this).parent().children(".sure-rev-btn").css("display","none");
		$(this).parent().children(".rev-cho-btn").css("display","inline");
	});
	$(".del-btn").click(function(){
		alert("恭喜你点击了删除按钮"+$(this).attr("location"));
	});
	$(".sure-rev-btn").click(function(){
		
		var thisTopic = $(this).parent().parent().parent();
		var topic_rev = thisTopic.children(".topic").children(".rev-input").children(input);
		var answer_rev = thisTopic.children(".answer").children(".rev-input").children(input);
		topic_rev.attr("disabled",true);
		answer_rev.attr("disabled",true);
		alert("确认修改按钮"+$(this).attr("location"));
		/*
		此处省略ajax代码
		*/
		
		var thisParent = $(this).parent();
		thisParent.empty();
		thisParent.append("已修改");
	});
	
}



function choose_manage(){
	$(".add-cho-btn").click(function(){	
		cho_num ++ ;
		$(".add-cho-btn").parent().parent().before('<div class="container topic-piece">'+
						       				'<div class="form-group">'+
											    '<label class="col-sm-2 control-label">题目：</label>'+
											    '<div class="col-sm-10">'+
											      '<input type="text" class="form-control"  placeholder="请输入题目内容" name="mtitle" >'+
											    '</div>'+
										  	'</div>'+
						       				'<div class="form-group">'+
											    '<label class="col-sm-2 control-label">选项A：</label>'+
											    '<div class="col-sm-10">'+
											      '<input type="text" class="form-control"  placeholder="请输入选项内容"  name="optionA">'+
											    '</div>'+
										  	'</div>'+
						       				'<div class="form-group">'+
											    '<label class="col-sm-2 control-label">选项B：</label>'+
											    '<div class="col-sm-10">'+
											      '<input type="text" class="form-control"  placeholder="请输入选项内容"  name="optionB">'+
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
								                    '<input type="radio" name="optionsRadios'+cho_num+'" value="A" checked>A'+
								                 ' </label>'+
								                '</span>'+
								                '<span class="radio col-sm-1">'+
								                 ' <label>'+
								                    '<input type="radio" name="optionsRadios'+cho_num+'" value="B">B'+
								                  '</label>'+
								                '</span>'+
								                '<span class="radio col-sm-1">'+
								                  '<label>'+
								                   ' <input type="radio" name="optionsRadios'+cho_num+'" value="C">C'+
								                  '</label>'+
								                '</span>'+	
								                '<span class="radio col-sm-1">'+
								                  '<label>'+
								                   ' <input type="radio" name="optionsRadios'+cho_num+'" value="D">D'+
								                  '</label>'+
								               '</span>	'+							                							                
										  	'</div>'+
										  	'<input type="hidden" value="A" name="mrightAnswer"/>'+
										  '</div>'
										  	
		
		);
	
	});
}

function fill_manage(){
	
	$(".add-fill-btn").click(function(){
		add_fill_num ++ ;
		$(this).parent().parent().before(
				'<div class="container topic-piece" id="location'+add_fill_num+'">'+
					'<div class="form-group">'+
						'<label class="col-sm-2 control-label">题目：</label>'+
							'<div class="col-sm-10 cont">'+
								'<div class="input-group">'+
									'<input type="text" class="form-control fill-input"  placeholder=\'请输入题目内容         请用   "_"  代替空格输入\' data-toggle="tooltip" data-placement="top" title="用下划线替代填空题的空格。示例：前端主要学_语言、_语言。注意：下划线需为英文输入">'+
									'<span class="input-group-btn">'+
										'<button class="btn btn-default fill-ans-btn" type="button" data-toggle="tooltip" data-placement="top" title="一旦生成，将无法修改题目" location="'+add_fill_num+'">生成答案域</button>'+
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
	
	
	
	$(document).on("click",".fill-ans-btn",function(){
//		var thisPiece = $(this).parent().parent().parent().parent().parent();
		//var fill = $(this).parent().prev().val();
//		var fill = $(this).parent().parent().children(".fill-input").val();
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
		if(fillNum == 0)
			{
				alert("您的题目还没有设置填空!");
				return;
			}
		thisInput.attr("readonly",true);
		thisHidden.val(fillNum);
		//$(this).parent().prev().attr("disabled",true);
//		$(this).parent().parent().children(".fill-input").attr("disabled",true);
	//	alert(fillNum);
		for(var i = 1;i<=fillNum;i++){
			thisPiece.append(
				'<div class="form-group">'+
					'<label class="col-sm-2 control-label">正确答案'+i+'：</label>'+
					'<div class="col-sm-10">'+
				     '<input type="text" name="frightAnswer" class="form-control"  placeholder="请输入正确答案'+i+'">'+
					'</div>'+			
				'</div>'
			);	
		}
		var tooltip = thisPiece.children(".form-group").children(".cont").children(".input-group").children(".input-group-btn").children(".tooltip");
		tooltip.css("display","none");
		$(this).attr("disabled",true);
	});		
}

function programme_manage(){
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
}












