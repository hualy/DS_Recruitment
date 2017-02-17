	
 	var panelBodyI ;
  	var imgsI ;
	var countPageI;		//页面的总数
	var currentPageI;	//当前页
	var firstLiI =1;		//当前页数的第一个数字
	//有关于分页的一些按钮
	var pageDivI = $("<div id='navi' ></div>");
	var pageUlI = $('<ul class="pagination" ></ul>');
	pageUlI.css('cursor','pointer');
	pageDivI.append(pageUlI);
	var arrayPageDownUpI = new Array(2);
	arrayPageDownUpI[0] = $('<li style="display:none"><a >&laquo;</a></li>');
	arrayPageDownUpI[1] = $('<li style="display:none"><a >&raquo;</a></li>');
	var arrayPageI = new Array(5);
	pageUlI.append(arrayPageDownUpI[0]);
	for(var i=0;i<arrayPageI.length;i++){
		arrayPageI[i] = $("<li></li>");
		pageUlI.append(arrayPageI[i]);
	}
	pageUlI.append(arrayPageDownUpI[1]);
	
	//上一页的设置
	var lastPageFunctionI = function(){
		currentPageI--;
		getInterecommunionFunction(currentPageI);
	}
	
	//下一页的设置
	var nextPageFunctionI = function(){
		currentPageI++;
		getInterecommunionFunction(currentPageI);
	}
	
	var getByPageI = function(page){
		currentPageI = page;
		getInterecommunionFunction(currentPageI);
	}
	
	//分页的实现
	var pageFunctionI = function(){	
			if(countPageI<=5){
				//arrayPageDownUp[0].attr('style','display:none;');
				//arrayPageDownUp[1].attr('style','display:none;');
				for(var i=0;i<countPageI;i++){
				arrayPageI[i].attr('style','');
				if(currentPageI==firstLiI+i)
					arrayPageI[i].html('<a><font color="red">&nbsp;'+(firstLiI+i)+'&nbsp;</font></a>');
				else {
					arrayPageI[i].html('<a>&nbsp;'+(firstLiI+i)+'&nbsp;</a>');
					arrayPageI[i].attr('onclick','getByPageI('+(firstLiI+i)+')');
					}
				}
				for(var i=countPageI;i<5;i++){
					arrayPageI[i].attr('style','display:none;');
							
				}
			}
			else{
				if(firstLiI+4<currentPageI) firstLiI=currentPageI-4;
				if(firstLiI>currentPageI) firstLiI = currentPageI;
				if(currentPageI<countPageI){
					if(firstLi+4==currentPageI) firstLiI++;
					else if(currentPageI==firstLiI&&firstLiI>1) firstLiI--;
				}
				for(var i=0;i<5;i++){
					arrayPageI[i].attr('style','');
					arrayPageI[i].attr('style','');
					if(currentPageI==firstLiI+i)
					arrayPageI[i].html('<a><font color="red">&nbsp;'+(firstLiI+i)+'&nbsp;</font></a>');
					else{
						arrayPageI[i].html('<a>&nbsp;'+(firstLiI+i)+'&nbsp;</a>');
						arrayPageI[i].attr('onclick','getByPageI('+(firstLiI+i)+')');
					} 
								
				}
						
					}
					
					if(currentPageI<=1) arrayPageDownUpI[0].attr('style','display:none;'); 
					else {
						arrayPageDownUpI[0].attr('style',''); 
						arrayPageDownUpI[0].attr('onclick','lastPageFunctionI()'); 
					}
					if(currentPageI>=countPageI) arrayPageDownUpI[1].attr('style','display:none;'); 
					else{
						arrayPageDownUpI[1].attr('style','');
						arrayPageDownUpI[1].attr('onclick','nextPageFunctionI()'); 
					}
					
				};
				
	var getInterecommunionFunctionOnLoad = function(currentPage){
		panelBodyI = $("#example3");
  		imgsI = $("#example3  img");
  		
  		if(panelBodyI.parent().parent().attr("class").indexOf("in")==-1){
  			getInterecommunionFunction(currentPage);
  			if(panelBodyI.parent().children("#navi").length==0){
			  panelBodyI.parent().append(pageDivI);
			}
  		}
  		
	}

	var getInterecommunionFunction = function(currentPage){		//点击项目按钮
			
			
		
  			$.post("user/introduction/getInterecommunions",{'currentPage':currentPage},function(returnedData,status){
  				
  				var interecommunion = returnedData[0];
  				countPageI = returnedData[1];
  				if(countPageI<=0){
  					panelBodyI.children().attr("style","display:none");
  					panelBodyI.children("h4[id='h4']").attr("style","");
  				}else{
  					panelBodyI.children("h4[id='h4']").attr("style","display:none");
  					panelBodyI.children().not("h4[id='h4']").attr("style","");
					panelBodyI.children("h4").not("h4[id='h4']").text("主题："+interecommunion.theme);
  				
	  				//alert(imgsI.length);
	  				for(var i=0;i<interecommunion.images.length;i++)
	  					$(imgsI[i]).attr("src",interecommunion.images[i].path);
	  				
	  				var arrayP = panelBodyI.children("p");
	  				
	  				$(arrayP[0]).text("时间："+interecommunion.date);
	  				$(arrayP[1]).text("主讲人："+interecommunion.speaker);
//	  				panelBodyI.children("textarea").val("描述："+interecommunion.content);
//	  				panelBodyI.children("textarea").attr("rows",panelBodyI.children("textarea").val().split("\n").length);
			  		var Rnum = 0;
			  		Rnum = interecommunion.content.split("\n").length;
			  		for(var flag = 0;flag < Rnum;flag++){
			  			interecommunion.content = interecommunion.content.replace(/\n/,"</br>");
			  		}
			  		panelBodyI.children(".TextArea").html("描述："+interecommunion.content);
	  				
	  				//分页的实现
	  				
	  				currentPageI = currentPage;
	  				pageFunctionI();
	  			
	  				
  				}
  				
  				if(countPageI<=0) 
  					panelBodyI.parent().children("#navi").attr("style","display:none");
  				else panelBodyI.parent().children("#navi").attr("style","");
  				panelBodyI.parent().attr("style","");
  			});
  			
  			
  			
  			
  			}
  			
		
































