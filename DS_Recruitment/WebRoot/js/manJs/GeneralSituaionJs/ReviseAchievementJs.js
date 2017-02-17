
jQuery(document).ready(function(){
				$(document).on("click","#rev-ach-btn",function(){
					if(ach_formValidation()){
						$("#rev-ach").submit();
					}
				});

				var currentPage = 1;	
				var firstLi = 1;
				var countPage;
				var arrayTr = new Array(10);
				var arrayTheme = new Array(10);
				var arrayType = new Array(10);
				var arrayDate = new Array(10);
				var arrayHidden = new Array(10);
				
				var arrayPage = new Array(5);
				var arrayPageDownUp = new Array(2);
				
				var num ;
				
				var  iniFunction =  function(){
					for(var i=0;i<arrayTr.length;i++){
						var tr1 = $('<tr style="display:none;"></tr>');

						var themeTd = $('<td></td>');
						var typeTd = $('<td></td>');
						var dateTd = $('<td></td>');
						var buttonTd = $('<td></td>');
						var updateButton = $('<button class="btn btn-default upDate-btn" type="button">修改</button>');
						var deleteButton = $('<button class="btn btn-danger del-btn" type="button">删除</button>');
						var hidden = $('<input type="hidden" />');
						
						tr1.append(themeTd);
						tr1.append(typeTd);
						tr1.append(dateTd);
						buttonTd.append(updateButton);
						buttonTd.append(deleteButton);
						buttonTd.append(hidden);
						tr1.append(buttonTd);
						
						arrayTr[i] = tr1;
						arrayTheme[i] = themeTd;
						arrayType[i] = typeTd;
						arrayDate[i] = dateTd;
						arrayHidden[i] = hidden;
					}
					
					//设置顺序
					$('#trRevise').after(arrayTr[0]);
					for(var i=0;i<arrayTr.length;i++){
						arrayTr[i].after(arrayTr[i+1]);
					}
					
					//页面分页初始化
					var nav = $("<nav></nav>");
						var ul = $('<ul class="pagination"></ul>');
							var last = $('<li style="display:none;" class="lastPage">'+
			        		'<span aria-hidden="true">&laquo;</span>'+
			    			'</li>');
							ul.append(last);
							arrayPageDownUp[0] = last;
						
							for(var i=0;i<5;i++){
								var li = $('<li style="display:none" pageNum="'+(firstLi+i)+'" class="getByPage"></li>');
								if(currentPage==firstLi+i)
									li.html('<a><font color="red">&nbsp;'+(firstLi+i)+'&nbsp;</font></a>');
								else li.html('<a>&nbsp;'+(firstLi+i)+'&nbsp;</a>');
								ul.append(li);
								arrayPage[i] = li;
							}
						
						
							var next = $('<li style="display:none;" class="nextPage">'+
			 
			        		'<span aria-hidden="true">&raquo;</span>'+
			      			
			    			'</li>');
							ul.append(next);
							arrayPageDownUp[1] = next;
							
						
						nav.append(ul);
						$('table[class="table table-striped"]').after(nav);
					
				}
				
				var getResultFunction = function(page){
					$.post("admin/introduction/getResult",{'currentPage':page},function(returnedData,status){
						
						
						var results = returnedData[0];
						
						countPage = Math.floor((returnedData[1]-1)/arrayTr.length+1);	//得到页数
						num = returnedData[0].length ;
						//alert(countPage);
						if(currentPage>countPage) currentPage=countPage;//如果当前页面都要比总页面数要大，则当前页面应该为最大的页面
						for(var i=1;i<results.length+1;i++){
							arrayTr[i-1].attr('style','');
							
							if(null==results[i-1].theme)
								arrayTheme[i-1].text('');
							else
								arrayTheme[i-1].text(results[i-1].theme);
							if(results[i-1].date==null)
								arrayDate[i-1].text('');
							else
								arrayDate[i-1].text(results[i-1].date);
							if(results[i-1].type==0)
								arrayType[i-1].text('比赛');
							else 
								arrayType[i-1].text('项目');
							arrayHidden[i-1].attr('value',results[i-1].id);
							
						}
						
						for(var i=results.length;i<arrayTr.length;i++){
							arrayTr[i].attr('style','display: none;');
							arrayHidden[i].attr('value','');
						}
						
						pageFunction();
					})
				
				};
				
				
				
				//分页的实现
				var pageFunction = function(){
				
					
					if(countPage<=5){
						//arrayPageDownUp[0].attr('style','display:none;');
						//arrayPageDownUp[1].attr('style','display:none;');
						for(var i=0;i<countPage;i++){
							arrayPage[i].attr('style','');
							if(currentPage==firstLi+i)
									arrayPage[i].html('<a><font color="red">&nbsp;'+(firstLi+i)+'&nbsp;</font></a>');
							else arrayPage[i].html('<a>&nbsp;'+(firstLi+i)+'&nbsp;</a>');
						}
						for(var i=countPage;i<5;i++){
							arrayPage[i].attr('style','display:none;');
						}
					}
					else{
						if(firstLi+4<currentPage) firstLi=currentPage-4;
						if(firstLi>currentPage) firstLi = currentPage;
						if(currentPage<countPage){
							if(firstLi+4==currentPage) firstLi++;
							else if(currentPage==firstLi&&firstLi>1) firstLi--;
						}
						for(var i=0;i<5;i++){
							arrayPage[i].attr('style','');
							arrayPage[i].attr('style','');
							if(currentPage==firstLi+i)
								arrayPage[i].html('<a><font color="red">&nbsp;'+(firstLi+i)+'&nbsp;</font></a>');
							else 
								arrayPage[i].html('<a>&nbsp;'+(firstLi+i)+'&nbsp;</a>');
						}
						
					}
					
					if(currentPage<=1) arrayPageDownUp[0].attr('style','display:none;'); 
					else arrayPageDownUp[0].attr('style',''); 
					if(currentPage>=countPage) arrayPageDownUp[1].attr('style','display:none;'); 
					else arrayPageDownUp[1].attr('style','');
					
				};
				
				$(document).on("click",".getByPage",function(){
					currentPage = $(this).attr("pageNum");
					getResultFunction(currentPage);
				})
					
				
				
				//上一页
				$(document).on("click",".lastPage",function(){
					if(currentPage<=1) return;
					currentPage--;
					getResultFunction(currentPage);
				});
					
						
				
				//下一页	
				$(document).on("click",".nextPage",function(){
					if(currentPage>=countPage) return;
					//alert(currentPage);
					currentPage++;
					getResultFunction(currentPage);
				});
				
				$(function(){
					iniFunction();
					getResultFunction(1);
				});
				
				
				//得到一个成果的页面
				$(document).on("click",".upDate-btn",function(){
					
					//alert("upDate-btn  不用就注释掉");
					$.post('admin/introduction/getOneResult',{'resultId':$(this).nextAll('input').attr('value')},function(returnedData,status){
						var result = returnedData;
						//alert(result.theme);
						$("#theme").attr("value",result.theme);
						$("input[name='date']").text(result.date);
						//alert(result.type);
						if(1==result.type){
							$("input[value=1]").attr("checked","checked");
						}else{
							$("input[value=0]").attr("checked","checked");
						}
						$("input[name='leaderName']").attr('value',result.leaderName);
						$("input[name='membersName']").attr('value',result.membersName);
						//alert(result.description);
						$("textarea[name='description']").val(result.description);
						$("form input[type='hidden'][name='resultId']").attr('value',result.id);
					});
					
					$(".exist-ach").slideUp();
					$(".change-img-btn").attr("disabled",false);
					$(".change-img-btn").next().attr("value","0");
					$(".revise-ach").slideDown();
					
				});
				//删除按钮
				$(document).on("click",".del-btn",function(){
					swal({
							title: "是否删除该成果",  
							type: "success",
							showCancelButton: true,
							confirmButtonColor: "#DD6B55",   
							confirmButtonText: "是的，我要删除",
							closeOnConfirm: true,
							closeOnCancel: true 
						},
						function(isComfire){
						
							if(isComfire){
								$.ajax({
							type:"post",
							url:'admin/introduction/deleteResult',
							data:{'resultId': $(".del-btn").nextAll('input').attr('value')},
							async:false,
							});
						if(num==1)
						currentPage--;
						getResultFunction(currentPage);
					
							}
						}
							
					);	
					
				});
				//放弃修改按钮事件
				$(document).on("click",".cancel-btn",function(){
					if($(".change-img-btn").next().val() == "true"){
						$(".change-img").remove();
						$(".change-img-btn").text("更换");
					}
					$(".revise-ach").slideUp();
					$(".exist-ach").slideDown();
				});
				//更换配图按钮
				$(document).on("click",".change-img-btn",function(){
					if($(this).text() == "更换"){
						$(this).parent().parent().after(
							'<div class="form-group has-feedback imgBar">'+
				              	'<label for="time" class="col-sm-2 control-label">照片：</label>'+
				              	'<div class="col-sm-2">'+
				                     '<input type="file" name="files" class="form-control imgs">'+
				                     '<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="display: none;"></span>'+
				                     '<span style="color:red;"></span> '+
				                '</div>'+
				              	'<div class="col-sm-2">'+
				                     '<input type="file"  name="files" class="form-control imgs">'+
				                     '<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="display: none;"></span>'+
				                     '<span style="color:red;"></span> '+
				                '</div>'+
				              	'<div class="col-sm-2">'+
				                     '<input type="file" name="files" class="form-control imgs">'+
				                     '<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="display: none;"></span>'+
				                     '<span style="color:red;"></span> '+
				                '</div>'+                              
				        	'</div>'   
						
						);
						$(this).next().attr("value","true");
						$(this).text("取消更换");
					}else if($(this).text() == "取消更换"){
						$(".change-img").remove();
						$(this).text("更换");
						$(this).next().attr("value","false");
					}
				});

				
				
				
				
});



