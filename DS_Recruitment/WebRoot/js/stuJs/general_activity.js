	
 	var panelBodyAc ;
  	var imgsAc ;
	var countPageAc;		//页面的总数
	var currentPageAc;	//当前页
	var firstLiAc =1;		//当前页数的第一个数字
	//有关于分页的一些按钮
	var pageDivAc = $("<div id='navi' ></div>");
	var pageUlAc = $('<ul class="pagination" ></ul>');
	pageUlAc.css('cursor','pointer');
	pageDivAc.append(pageUlAc);
	var arrayPageDownUpAc = new Array(2);
	arrayPageDownUpAc[0] = $('<li style="display:none" ><a >&laquo;</a></li>');
	arrayPageDownUpAc[1] = $('<li style="display:none"><a >&raquo;</a></li>');
	var arrayPageAc = new Array(5);
	pageUlAc.append(arrayPageDownUpAc[0]);
	for(var i=0;i<arrayPageAc.length;i++){
		arrayPageAc[i] = $("<li></li>");
		pageUlAc.append(arrayPageAc[i]);
	}
	pageUlAc.append(arrayPageDownUpAc[1]);
	
	//上一页的设置
	var lastPageFunctionAc = function(){
		currentPageAc--;
		getActivityFunction(currentPageAc);
	}
	
	//下一页的设置
	var nextPageFunctionAc = function(){
		currentPageAc++;
		getActivityFunction(currentPageAc);
	}
	
	var getByPageAc = function(page){
		currentPageAc = page;
		getActivityFunction(currentPageAc);
	}
	
	//分页的实现
	var pageFunctionAc = function(){	
			if(countPageAc<=5){
				//arrayPageDownUp[0].attr('style','display:none;');
				//arrayPageDownUp[1].attr('style','display:none;');
				for(var i=0;i<countPageAc;i++){
				arrayPageAc[i].attr('style','');
				if(currentPageAc==firstLiAc+i)
					arrayPageAc[i].html('<a><font color="red">&nbsp;'+(firstLiAc+i)+'&nbsp;</font></a>');
				else {
					arrayPageAc[i].html('<a>&nbsp;'+(firstLiAc+i)+'&nbsp;</a>');
					arrayPageAc[i].attr('onclick','getByPageAc('+(firstLiAc+i)+')');
					}
				}
				for(var i=countPageAc;i<5;i++){
					arrayPageAc[i].attr('style','display:none;');
							
				}
			}
			else{
				if(firstLiAc+4<currentPageAc) firstLiAc=currentPageAc-4;
				if(firstLiAc>currentPageAc) firstLiAc = currentPageAc;
				if(currentPageAc<countPageAc){
							if(firstLiAc+4==currentPageAc) firstLiAc++;
							else if(currentPageAc==firstLiAc&&firstLiAc>1) firstLiAc--;
						}
				for(var i=0;i<5;i++){
					arrayPageAc[i].attr('style','');
					arrayPageAc[i].attr('style','');
					if(currentPageAc==firstLiAc+i)
					arrayPageAc[i].html('<a><font color="red">&nbsp;'+(firstLiAc+i)+'&nbsp;</font></a>');
					else{
						arrayPageAc[i].html('<a>&nbsp;'+(firstLiAc+i)+'&nbsp;</a>');
						arrayPageAc[i].attr('onclick','getByPageAc('+(firstLiAc+i)+')');
					} 
								
				}
						
					}
					
					if(currentPageAc<=1) arrayPageDownUpAc[0].attr('style','display:none;'); 
					else {
						arrayPageDownUpAc[0].attr('style',''); 
						arrayPageDownUpAc[0].attr('onclick','lastPageFunctionAc()'); 
					}
					if(currentPageAc>=countPageAc) arrayPageDownUpAc[1].attr('style','display:none;'); 
					else{
						arrayPageDownUpAc[1].attr('style','');
						arrayPageDownUpAc[1].attr('onclick','nextPageFunctionAc()'); 
					}
					
				};
				
	var getActivityFunctionOnLoad = function(currentPage){
		panelBodyAc = $("#example4");
  		imgsAc = $("#example4  img");
  		
  		if(panelBodyAc.parent().parent().attr("class").indexOf("in")==-1){
  			getActivityFunction(currentPage);
  			
  			if(panelBodyAc.parent().children("#navi").length==0){
			  panelBodyAc.parent().append(pageDivAc);
			}
  		}
  		
	}

	var getActivityFunction = function(currentPage){		//点击项目按钮
			
			
		
  			$.post("user/introduction/getActivities",{'currentPage':currentPage},function(returnedData,status){
  				
  				var activity = returnedData[0];
  				countPageAc = returnedData[1];
  				if(countPageAc<=0){
  					panelBodyAc.children().attr("style","display:none");
  					panelBodyAc.children("h4[id='h4']").attr("style","");
  				}else{
  					panelBodyAc.children("h4[id='h4']").attr("style","display:none");
  					panelBodyAc.children().not("h4[id='h4']").attr("style","");
  					
  					panelBodyAc.children("h4").not("h4[id='h4']").text("主题："+activity.theme);
  				
	  				//alert(imgsAc.length);
	  				for(var i=0;i<activity.images.length;i++)
	  					$(imgsAc[i]).attr("src",activity.images[i].path);
	  				
	  				var arrayP = panelBodyAc.children("p");
	  				
	  				$(arrayP[0]).text("组织者："+activity.origanzier);
	  				$(arrayP[1]).text("活动时间："+activity.date);
	  				$(arrayP[2]).text("组织者："+activity.origanzier);
	  				
	  				var arrayTextarea = panelBodyAc.children(".TextArea");
	  				
			  		var Rnum = 0;
			  		Rnum = activity.content.split("\n").length;
			  		for(var flag = 0;flag < Rnum;flag++){
			  			activity.content = activity.content.replace(/\n/,"</br>");
			  		}
			  		
	  				$(arrayTextarea[0]).html("内容："+activity.content);
//	  				$(arrayTextarea[0]).attr("rows",$(this).val().split("\n").length);
	  				
	  				Rnum = activity.thoughts.split("\n").length;
			  		for(var flag = 0;flag < Rnum;flag++){
			  			activity.thoughts = activity.thoughts.replace(/\n/,"</br>");
			  		}
			  		
	  				$(arrayTextarea[1]).html("感想："+activity.thoughts);
//	  				$(arrayTextarea[1]).attr("rows",$(this).val().split("\n").length);
	  				//分页的实现
	  				
	  				currentPageAc = currentPage;
	  				
	  				pageFunctionAc();
	  			
	  				
  				}
  				
  				if(countPageAc<=0) 
  					panelBodyAc.parent().children("#navi").attr("style","display:none");
  				else panelBodyAc.parent().children("#navi").attr("style","");
  				
  				
  				panelBodyAc.parent().attr("style","");
  			});
  			
  			
  			
  			
  			}
  			
		
































