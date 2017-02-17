	
 	var panelBodyAr ;
	var countPageAr;		//页面的总数
	var currentPageAr;	//当前页
	var firstLiAr =1;		//当前页数的第一个数字
	//有关于分页的一些按钮
	var pageDivAr = $("<div id='navi' ></div>");
	var pageUlAr = $('<ul class="pagination" ></ul>');
	pageUlAr.css('cursor','pointer');
	pageDivAr.append(pageUlAr);
	var arrayPageDownUpAr = new Array(2);
	arrayPageDownUpAr[0] = $('<li style="display:none" ><a >&laquo;</a></li>');
	arrayPageDownUpAr[1] = $('<li style="display:none"><a >&raquo;</a></li>');
	var arrayPageAr = new Array(5);
	pageUlAr.append(arrayPageDownUpAr[0]);
	for(var i=0;i<arrayPageAr.length;i++){
		arrayPageAr[i] = $("<li></li>");
		pageUlAr.append(arrayPageAr[i]);
	}
	pageUlAr.append(arrayPageDownUpAr[1]);
	
	//上一页的设置
	var lastPageFunctionAr = function(){
		currentPageAr--;
		getArticleFunction(currentPageAr);
	}
	
	//下一页的设置
	var nextPageFunctionAr = function(){
		currentPageAr++;
		getArticleFunction(currentPageAr);
	}
	
	var getByPageAr = function(page){
		currentPageAr = page;
		getArticleFunction(currentPageAr);
	}
	
	//分页的实现
	var pageFunctionAr = function(){	
			if(countPageAr<=5){
				//arrayPageDownUp[0].attr('style','display:none;');
				//arrayPageDownUp[1].attr('style','display:none;');
				for(var i=0;i<countPageAr;i++){
				arrayPageAr[i].attr('style','');
				if(currentPageAr==firstLiAr+i)
					arrayPageAr[i].html('<a><font color="red">&nbsp;'+(firstLiAr+i)+'&nbsp;</font></a>');
				else {
					arrayPageAr[i].html('<a>&nbsp;'+(firstLiAr+i)+'&nbsp;</a>');
					arrayPageAr[i].attr('onclick','getByPageAr('+(firstLiAr+i)+')');
					}
				}
				for(var i=countPageAr;i<5;i++){
					arrayPageAr[i].attr('style','display:none;');
							
				}
			}
			else{
				if(firstLiAr+4<currentPageAr) firstLiAr=currentPageAr-4;
				if(firstLiAr>currentPageAr) firstLiAr = currentPageAr;
				if(currentPageAr<countPageAr){
							if(firstLiAr+4==currentPageAr) firstLiAr++;
							else if(currentPageAr==firstLiAr&&firstLiAr>1) firstLiAr--;
						}
				for(var i=0;i<5;i++){
					arrayPageAr[i].attr('style','');
					arrayPageAr[i].attr('style','');
					if(currentPageAr==firstLiAr+i)
					arrayPageAr[i].html('<a><font color="red">&nbsp;'+(firstLiAr+i)+'&nbsp;</font></a>');
					else{
						arrayPageAr[i].html('<a>&nbsp;'+(firstLiAr+i)+'&nbsp;</a>');
						arrayPageAr[i].attr('onclick','getByPageAr('+(firstLiAr+i)+')');
					} 
								
				}
						
					}
					
					if(currentPageAr<=1) arrayPageDownUpAr[0].attr('style','display:none;'); 
					else {
						arrayPageDownUpAr[0].attr('style',''); 
						arrayPageDownUpAr[0].attr('onclick','lastPageFunctionAr()'); 
					}
					if(currentPageAr>=countPageAr) arrayPageDownUpAr[1].attr('style','display:none;'); 
					else{
						arrayPageDownUpAr[1].attr('style','');
						arrayPageDownUpAr[1].attr('onclick','nextPageFunctionAr()'); 
					}
					
				};
				
	var getArticleFunctionOnLoad = function(currentPage){
		panelBodyAr = $("#example5");
  		
  		if(panelBodyAr.parent().parent().attr("class").indexOf("in")==-1){
  			getArticleFunction(currentPage);
  			
  			if(panelBodyAr.parent().children("#navi").length==0){
			  panelBodyAr.parent().append(pageDivAr);
			}
  		}
  		
	}

	var getArticleFunction = function(currentPage){		//点击项目按钮
			
			
		
  			$.post("user/introduction/getArticles",{'currentPage':currentPage},function(returnedData,status){
  				
  				var article = returnedData[0];
  				countPageAr = returnedData[1];
  				if(countPageAr<=0){
  					panelBodyAr.children().attr("style","display:none");
  					panelBodyAr.children("h4[id='h4']").attr("style","");
  				}else{
  					panelBodyAr.children("h4[id='h4']").attr("style","display:none");
  					panelBodyAr.children().not("h4[id='h4']").attr("style","");
  					
  					panelBodyAr.children("h4").not("h4[id='h4']").text("主题："+article.theme);
  				
	  				
	  				var arrayP = panelBodyAr.children("p");
	  				
	  				$(arrayP[0]).text("发布时间："+article.date);
	  				$(arrayP[1]).text("发布人："+article.lanucher);
	  				$(arrayP[2]).text("描述："+article.description);
	  				
	  				$(panelBodyAr.children("div[id='content']")).html("内容：<br>"+article.content);
	  				    if(document.body.clientWidth<767){
	  				    	
							$("#content").children("p").each(function(){

								if($(this).children("img")[0] == undefined){

									$(this).children("span").children("img").css("width","100%");
								}else{
									$(this).children("img").css("width","100%");
								}
							});
					    }
	  				//分页的实现
	  				
	  				currentPageAr = currentPage;
	  				
	  				pageFunctionAr();
	  			
	  				
  				}
  				
  				if(countPageAr<=0) 
  					panelBodyAr.parent().children("#navi").attr("style","display:none");
  				else panelBodyAr.parent().children("#navi").attr("style","");
  				
  				
  				panelBodyAr.parent().attr("style","");
  			});
  			
  			
  			
  			
  			}
  			
		
































