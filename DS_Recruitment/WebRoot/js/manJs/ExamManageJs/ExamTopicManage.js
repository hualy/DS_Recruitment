jQuery(document).ready(function(){
	

	$(".add-examination").click(function(){			//添加试题
        
		var setID = $("#setID").val();
		var name = $("#name").val();
		
        $.ajax({
        	type: "POST",
      		url: "admin/examination_manager/judgementOfsetIDAction",  	
     		dataType: "HTML",
     		data:{'setID':setID, 'name':name},
     		success: function(data){
     			
     					if(data == "success")  
     						window.location.href = "manPage/ExamManage/AddExamination.jsp?name=" +name+ "&setID=" +setID;
     					else{
     						swal("录入失败","该套题已经存在,请检查名称和套题号是否填写正确","error");
     					}
     				}
        });
        
    });
	
	
	 $(".rev-examination").click(function(){		//修改笔试题目
		 
		 var id = $(this).attr("location");
		
        location.href = "admin/examination_manager/getTheSetOfExaminationQuestionsAction?id=" + id;
    });
	 
	 
                          
	$(".del-btn").click(function(){                //删除试题按钮
		
		 var id = $(this).attr("location");
		
		 swal({
				title: "Are you sure?",     
				type: "warning",   
				showCancelButton: true,   
				confirmButtonColor: "#DD6B55",   
				confirmButtonText: "确定删除!",   
				cancelButtonText: "取消!",   
				closeOnConfirm: false,   
				closeOnCancel: false  
			},
		
			function(isConfirm){
				if(isConfirm){
					swal({
							title: "删除成功",  
							text: "Your imaginary file has been deleted!",
							type: "success",   
							confirmButtonColor: "#DD6B55",   
							confirmButtonText: "确认",   
							closeOnConfirm: false
						}
					);
					
					$.ajax({
				        	type: "POST",
				      		url: "admin/examination_manager/deleteTheSetOfExaminationQuestionsAction",  	
				     		dataType: "HTML",
				     		data:{'id':id},
				     		success: function(data){
				     					var deleteNode = document.getElementById(id);
										deleteNode.remove();
				     				}
        			});
		 
					
				}else{
					swal("取消成功","Your imaginary file is safe :)", "success");
				}
			}
		);
		 
		  
	});
		           
    
});

