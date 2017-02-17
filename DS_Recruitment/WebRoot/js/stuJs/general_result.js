	
	var panelBody ; //内容
  	var imgs ;	//图片

	var countPageR;		//页面的总数
	var currentPageR;	//当前页
	var firstLiR =1;		//当前页数的第一个数字
	//有关于分页的一些按钮
	var pageDivR = $("<div id='navi' ></div>");
	var pageUlR = $('<ul class="pagination" ></ul>');
	pageUlR.css('cursor', 'pointer');
	pageDivR.append(pageUlR);
	var arrayPageDownUpR = new Array(2);
	arrayPageDownUpR[0] = $('<li style="display:none"><a >&laquo;</a></li>');
	arrayPageDownUpR[1] = $('<li style="display:none"><a >&raquo;</a></li>');
	var arrayPageR = new Array(5);
	pageUlR.append(arrayPageDownUpR[0]);
	for(var i=0;i<arrayPageR.length;i++){
		arrayPageR[i] = $("<li></li>");
		pageUlR.append(arrayPageR[i]);
	}
	pageUlR.append(arrayPageDownUpR[1]);
	
	//上一页的设置
	var lastPageFunctionR = function(type){
		currentPageR--;
		getResultFunction(currentPageR,type);
	}
	
	//下一页的设置
	var nextPageFunctionR = function(type){
		currentPageR++;
		getResultFunction(currentPageR,type);
	}
	
	var getByPageR = function(page,type){
					
					//alert($(this));
					currentPageR = page;
					getResultFunction(currentPageR,type);
				}
	
	//分页的实现
	var pageFunctionR = function(type){	
			if(countPageR<=5){
				//arrayPageDownUp[0].attr('style','display:none;');
				//arrayPageDownUp[1].attr('style','display:none;');
				for(var i=0;i<countPageR;i++){
				arrayPageR[i].attr('style','');
				if(currentPageR==firstLiR+i){
					arrayPageR[i].html('<a><font color="red">&nbsp;'+(firstLiR+i)+'&nbsp;</font></a>');
					arrayPageR[i].attr("onclick","");
				}else {
					arrayPageR[i].html('<a>&nbsp;'+(firstLiR+i)+'&nbsp;</a>');
					arrayPageR[i].attr('onclick','getByPageR('+(firstLiR+i)+','+type+')');
					}
				}
				for(var i=countPageR;i<5;i++){
					arrayPageR[i].attr('style','display:none;');
							
				}
			}
			else{
				if(firstLiR+4<currentPageR) firstLiR=currentPageR-4;
				if(firstLiR>currentPageR) firstLiR = currentPageR;
				if(currentPageR<countPageR){
							if(firstLiR+4==currentPageR) firstLiR++;
							else if(currentPageR==firstLiR&&firstLiR>1) firstLiR--;
						}
				for(var i=0;i<5;i++){
					arrayPageR[i].attr('style','');
					arrayPageR[i].attr('style','');
					if(currentPageR==firstLiR+i){
						arrayPageR[i].html('<a><font color="red">&nbsp;'+(firstLiR+i)+'&nbsp;</font></a>');
						arrayPageR[i].attr('onclick',"");
						}
					else{
						arrayPageR[i].html('<a>&nbsp;'+(firstLiR+i)+'&nbsp;</a>');
						arrayPageR[i].attr('onclick','getByPageR('+(firstLiR+i)+','+type+')');
					} 
								
				}
						
					}
					
					if(currentPageR<=1) arrayPageDownUpR[0].attr('style','display:none;'); 
					else {
						arrayPageDownUpR[0].attr('style',''); 
						arrayPageDownUpR[0].attr('onclick','lastPageFunctionR('+type+')'); 
					}
					if(currentPageR>=countPageR) arrayPageDownUpR[1].attr('style','display:none;'); 
					else{
						arrayPageDownUpR[1].attr('style','');
						arrayPageDownUpR[1].attr('onclick','nextPageFunctionR('+type+')'); 
					}
					
				};
	
	var getResultFunctionOnLoad = function(currentPage,type){
			
			if(type==1){
				panelBody = $("#example1");
				imgs = $("#example1  img");
			}
				
			else {
				panelBody = $("#example2");
				imgs = $("#example2  img");
				
			}
			//alert(panelBody.parent().parent().attr("class"));
			if(panelBody.parent().parent().attr("class").indexOf("in")==-1){
				firstLiR = 1;
				getResultFunction(currentPage,type);
				panelBody.parent().attr("style","");
			}
	}
				
	var getResultFunction = function(currentPage,type){		//点击项目按钮
  			
	  			$.post("user/introduction/getResults",{'currentPage':currentPage,'type':type},function(returnedData,status){
	  					var result = returnedData[0];
		  				countPageR = returnedData[1];
		  				if(countPageR<=0){
		  					panelBody.children().attr("style","display:none");
  							panelBody.children("h4[id='h4']").attr("style","");
		  				}else{
		  					//alert(panelBody.children("h4").length);
		  					panelBody.children("h4[id='h4']").attr("style","display:none");
  							panelBody.children().not("h4[id='h4']").attr("style","");
			  				panelBody.children("h4").not("h4[id='h4']").text("主题："+result.theme);
			  				
			  				//alert(imgs.length);
			  				for(var i=0;i<result.images.length;i++)
			  					$(imgs[i]).attr("src",result.images[i].path);
			  				
			  				var arrayP = panelBody.children("p");
			  				
			  				$(arrayP[0]).text("时间："+result.date);
			  				$(arrayP[1]).text("参与成员："+result.leaderName+"(组长)  "+result.membersName);
//  					panelBody.children("div[id='description']").text("描述："+result.description);
//			  				panelBody.children("textarea").val("描述："+result.description);
//			  				panelBody.children("textarea").attr("rows",panelBody.children("textarea").val().split("\n").length);
			  				var Rnum = 0;
			  				Rnum = result.description.split("\n").length;
			  				for(var flag = 0;flag < Rnum;flag++){
			  					result.description = result.description.replace(/\n/,"</br>");
			  				}
			  				panelBody.children(".TextArea").html("描述："+result.description);
			  				//分页的实现
			  				currentPageR = currentPage;
			  				pageFunctionR(type);
			  				
			  				if(panelBody.parent().children("#navi").length==0){
			  					panelBody.parent().append(pageDivR);
			  				}
			  				
			  				
		  				}
	  				
			  			if(countPageR<=0) 
		  					panelBody.parent().children("#navi").attr("style","display:none");
		  				else panelBody.parent().children("#navi").attr("style","");
		  				panelBody.parent().attr("style","");
	  				});
  			
  		}
  			
  			

  			
		
































