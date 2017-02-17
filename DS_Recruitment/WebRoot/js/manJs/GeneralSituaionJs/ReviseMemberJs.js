

jQuery(document).ready(function(){
				
				var currentPage = 1;	
				var firstLi = 1;
				var countPage;
				var arrayTr = new Array(10);
				var arrayName = new Array(10);
				var arrayGrade = new Array(10);
				var arrayCla = new Array(10);
				var arrayHidden = new Array(10);
				
				var arrayPage = new Array(5);
				var arrayPageDownUp = new Array(2);
				
				var num;
				
				var  iniFunction =  function(){
					for(var i=0;i<arrayTr.length;i++){
						var tr1 = $('<tr style="display:none"></tr>');
						var nameTd = $('<td></td>');
						var gradeTd = $('<td></td>');
						var claTd = $('<td></td>');
						var buttonTd = $('<td></td>');
						var updateButton = $('<button class="btn btn-default upDate-btn" type="button">修改</button>');
						var deleteButton = $('<button class="btn btn-danger del-btn" type="button">删除</button>');
						var hidden = $('<input type="hidden" />');
						
						tr1.append(nameTd);
						tr1.append(gradeTd);
						tr1.append(claTd);
						buttonTd.append(updateButton);
						buttonTd.append(deleteButton);
						buttonTd.append(hidden);
						tr1.append(buttonTd);
						
						arrayTr[i] = tr1;
						arrayName[i] = nameTd;
						arrayGrade[i] = gradeTd;
						arrayCla[i] = claTd;
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
								var li = $('<li style="display:none" class="getPage" page="'+(firstLi+i)+'"></li>');
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
				
				var getMemberFunction = function(page){
					$.post("admin/introduction/getMember",{'currentPage':page},function(returnedData,status){
						var members = returnedData[0];
						num = returnedData[0].length;
						countPage = Math.floor((returnedData[1]-1)/arrayTr.length+1);	//得到页数
						//alert(countPage);
						if(currentPage>countPage) currentPage=countPage;//如果当前页面都要比总页面数要大，则当前页面应该为最大的页面
						for(var i=1;i<members.length+1;i++){
							arrayTr[i-1].attr('style','');
							if(null==members[i-1].name)
								arrayName[i-1].text('');
							else
								arrayName[i-1].text(members[i-1].name);
							if(members[i-1].cla==null)
								arrayCla[i-1].text('');
							else
								arrayCla[i-1].text(members[i-1].cla);
							if(members[i-1].grade==null)
								arrayGrade[i-1].text("");
							else 
								arrayGrade[i-1].text(members[i-1].grade);
							arrayHidden[i-1].attr('value',members[i-1].id);
							
						}
						
						for(var i=members.length;i<arrayTr.length;i++){
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
				
				$(document).on("click",".getPage",function(){
					currentPage = $(this).attr("page");
					getMemberFunction(currentPage);
				});
					
				
				
				//上一页
				$(document).on("click",".lastPage",function(){
					if(currentPage<=1) return;
					currentPage--;
					getMemberFunction(currentPage);
				});

						
				//下一页	
				$(document).on("click",".nextPage",function(){
					if(currentPage>=countPage) return;
					//alert(currentPage);
					currentPage++;
					getMemberFunction(currentPage);
				});

				
				$(function(){
					iniFunction();
					getMemberFunction(1);
				});
				
				
				//得到一个成果的页面
				$(document).on("click",".upDate-btn",function(){

					$.post('admin/introduction/getOneMember',{'memberId':$(this).nextAll('input').attr('value')},function(returnedData,status){
						var member = returnedData;
						$("input[name='name']").attr('value',member.name);
						$("select[name='majorOnDs'] option[value="+member.majorOnDs+"]").attr("selected","selected");
						$("select[name='major'] option[value="+member.major+"]").attr("selected","selected");
						$("select[name='grade'] option[value="+member.grade+"]").attr("selected","selected");
						$("select[name='cla'] option[value="+member.cla+"]").attr("selected","selected");
						if(member.female){
							$("input[name='female'][value='true']").attr("checked","checked");
						}else{
							$("input[name='female'][value='false']").attr("checked","checked");
						}
						$("textarea[name='description']").text(member.description);
						$("textarea[name='leavingWord']").text(member.leavingWord);
						$("form img").attr("src",member.image);
						$("form input[type='hidden'][name='imagePath']").attr("value",member.image);
						$("form input[type='hidden'][name='memberId']").attr("value",member.id);
					});
					
					$(".exist-mem").slideUp();
					$(".revise-mem").slideDown()
					
					
				});
				
				$(document).on("click",".del-btn",function(){
					
				
					
					swal({
							title: "是否删除该成员",  
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
								url:'admin/introduction/deleteMember',
								dataType: "HTML",
								data:{'memberId':$(".del-btn").nextAll('input[type="hidden"]').attr('value')}
								
								});
								if(num==1)
								currentPage--;
								getMemberFunction(currentPage);
								
							}
							
					
						
				
						}
							
					);	
					
				
				});
				//放弃修改按钮事件
				$(document).on("click",".cancel-btn",function(){
					
					$(".revise-mem").slideUp();
					$(".exist-mem").slideDown();
				});
			
});