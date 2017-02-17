

jQuery(document).ready(function(){
	
	$(document).on("click","#rev-ann-btn",function(){
		
		$(".exist-ann").slideUp();
		$(".revise-ann").slideDown();
		var id = $(this).attr("location");
		
		$.ajax({
			type: "POST",
			url: "admin/informationManagement/getTheNoticeAction",
			dataType: "HTML",
			data: {'id':id},
			success: function(data){
//						swal(data);
						var result = jQuery.parseJSON(data);
						var topic = result.topic;
						var content = result.content;
						$("#topic").val(topic);
						$("#describe").val(content);
						$("#pos").val(id);
					}
			
		});
		
	});

	
	$(document).on("click","#del-ann-btn",function(){
		
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
				if (isConfirm) {     
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
						url: "admin/informationManagement/deleteTheNoticeAction",
						dataType: "HTML",
						data: {'id': id},
						success: function(data){
									var deleteNode = document.getElementById(data);
									deleteNode.remove();
								}
					});
					
					
				}else{    
					swal("取消成功","Your imaginary file is safe :)", "success");   
				} 
		});
	});
	
	$("#giveUp").click(function(){
		$(".revise-ann").slideUp();
		
		$(".exist-ann").slideDown();
	});
	
	
	$("#revise-btn").click(function(){
		
		$.ajax({
			type: "POST",
			url: "admin/informationManagement/reviseTheNoticeAction",
			dataType: "HTML",
			data: $("#revise-form").serialize(), 
			success: function(result){
							swal({
								title: "修改成功",  
								text: "Your imaginary file has been revised!",
								type: "success",   
								confirmButtonColor: "#DD6B55",   
								confirmButtonText: "确认",   
								closeOnConfirm: false
								},
								function(){
									window.location.href = "admin/informationManagement/getAllTheNoticeAction";
								}
							);
					}
			
		});
		
		return false;									//防止页面自动跳转
		
	});
	
	
});


