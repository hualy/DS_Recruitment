jQuery(document).ready(function(){
	
	
				var currentPage = 1;	
				var firstLi = 1;
				var countPage;
				var arrayTr = new Array(10);
				var arrayTheme = new Array(10);
				var arrayLanucher= new Array(10);
				var arrayDate = new Array(10);
				var arrayHidden = new Array(10);
				
				var arrayPage = new Array(5);
				var arrayPageDownUp = new Array(2);
				
				var num;
				
				var  iniFunction =  function(){
					for(var i=0;i<arrayTr.length;i++){
						var tr1 = $('<tr style="display:none;"></tr>');
						var themeTd = $('<td></td>');
						var lanucherTd = $('<td></td>');
						var dateTd = $('<td></td>');
						var buttonTd = $('<td></td>');
						var updateButton = $('<button class="btn btn-default upDate-btn" type="button">修改</button>');
						var deleteButton = $('<button class="btn btn-danger del-btn" type="button">删除</button>');
						var hidden = $('<input type="hidden" />');
						
						tr1.append(themeTd);
						tr1.append(lanucherTd);
						tr1.append(dateTd);
						buttonTd.append(updateButton);
						buttonTd.append(deleteButton);
						buttonTd.append(hidden);
						tr1.append(buttonTd);
						
						arrayTr[i] = tr1;
						arrayTheme[i] = themeTd;
						arrayLanucher[i] = lanucherTd;
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
								var li = $('<li style="display:none;" pageNum="'+(firstLi+i)+'" class="getByPage"></li>');
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
				
				var getArticleFunction = function(page){
					$.post("admin/introduction/getArticle",{'currentPage':page},function(returnedData,status){
						
						
						var articles = returnedData[0];
						num = returnedData[0].length;
						countPage = Math.floor((returnedData[1]-1)/arrayTr.length+1);	//得到页数
						//alert(countPage);
						if(currentPage>countPage) currentPage=countPage;//如果当前页面都要比总页面数要大，则当前页面应该为最大的页面
						for(var i=1;i<articles.length+1;i++){
							arrayTr[i-1].attr('style','');
							if(null==articles[i-1].theme)
								arrayTheme[i-1].text('');
							else
								arrayTheme[i-1].text(articles[i-1].theme);
							if(articles[i-1].date==null)
								arrayDate[i-1].text('');
							else
								arrayDate[i-1].text(articles[i-1].date);
							if(articles[i-1].lanucher==null)
								arrayLanucher[i-1].text("");
							else 
								arrayLanucher[i-1].text(articles[i-1].lanucher);
							arrayHidden[i-1].attr('value',articles[i-1].id);
							
						}
						
						for(var i=articles.length;i<arrayTr.length;i++){
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
					getArticleFunction(currentPage);
				});
				
				//上一页
				$(document).on("click",".lastPage",function(){
					if(currentPage<=1) return;
					currentPage--;
					getArticleFunction(currentPage);
						
				});
				//下一页	
				$(document).on("click",".nextPage",function(){
					if(currentPage>=countPage) return;
					//alert(currentPage);
					currentPage++;
					getArticleFunction(currentPage);
				});
				
				$(function(){
					iniFunction();
					getArticleFunction(1);
				});
				
				
				//得到一个成果的页面
				$(document).on("click",".upDate-btn",function(){
					
					$.post('admin/introduction/getOneArticle',{'articleId':$(this).nextAll('input').attr('value')},function(returnedData,status){
						var article = returnedData;
						$("input[name='theme']").attr('value',article.theme);
						$("input[name='date']").attr('value',article.date);
						$("input[name='lanucher']").attr('value',article.lanucher);
						$("input[name='description']").attr('value',article.description);
						$("textarea[name='content']").val(article.content);
						$("input[type='hidden'][name='articleId']").attr('value',article.id);
					});
					/*
					$(".exist-com").slideUp();
					$(".change-img-btn").attr("disabled",false);
					$(".change-img-btn").next().attr("value","0");
					$("#rev-com-form").slideDown()
					*/
					$(".exist-info").slideUp();
					$("#rev-info-form").slideDown();
					
				});
				
				$(document).on("click",".del-btn",function(){
					swal({
							title: "是否删除该推送",  
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
						url:'admin/introduction/deleteArticle',
						data:{'articleId':$(".del-btn").nextAll('input').attr('value')},
						async:false,
					
					});
					if(num==1)
						currentPage--;
					getArticleFunction(currentPage);
				
					
							}
						}
							
					);	
				
					
				
				});
				//放弃修改按钮事件
				$(document).on("click",".cancel-btn",function(){
					$("#rev-info-form").slideUp();
					$(".exist-info").slideDown();
				});
				/*
				//更换配图按钮
				$(document).on("click",".change-img-btn",function(){
					if($(this).text() == "更换"){
						$(this).parent().parent().after(
							'<div class="form-group change-img">'+
				              	'<label for="time" class="col-sm-2 control-label">照片：</label>'+
				              	'<div class="col-sm-2">'+
				                     '<input type="file" name="files" class="form-control">'+
				                '</div>'+
				              	'<div class="col-sm-2">'+
				                     '<input type="file" name="files" class="form-control">'+
				                '</div>'+
				              	'<div class="col-sm-2">'+
				                  '   <input type="file" name="files" class="form-control">'+
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
			*/

	/* 键钧的代码 */
/*	//修改推送按钮
	$(document).on("click",".rev-btn",function(){
		$(".exist-info").slideUp();
		$("#rev-info-form").slideDown();
	});
	//删除推送按钮
	$(document).on("click",".del-btn",function(){
		alert("恭喜你点击了删除按钮");
	});
	//放弃修改按钮
	$(document).on("click",".cancel-btn",function(){
		$("#rev-info-form").slideUp();
		$(".exist-info").slideDown();
	});
*/	
});