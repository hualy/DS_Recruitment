<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>DS工作室-管理员-留言回复</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/manCss/shareCss.css">	
	<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css" >
	<link rel="stylesheet" type="text/css" href="css/manCss/MessageReplyCss.css">
	<link rel="shortcut icon" href="photos/DSlogo32.ico" />
	
	<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
		
	<script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="js/bootstrap-datetimepicker.fr.js"></script>
	<script type="text/javascript" src="js/manJs/shareJS.js"></script>
	
	<script type="text/javascript" src="js/manJs/MessageReplyJs.js"></script> 
  </head>
  <body>
  	 <!--page header -->
    <div class="all">
      <div class="content">
        <%@ include file="manHeader.jsp" %>
        <!-- navigation bar -->
        <div class="mainContent container">
        	<ol class="breadcrumb">
                <li>首页</li>
                <li class="active">留言回复</li>
            </ol>
	<!--  	<table class="table table-striped exist-message">
			  <tr class="info">
			  	<td class="col-sm-1">留言人</td>
			  	<td class="col-sm-2">联系方式</td>
			  	<td class="col-sm-6">留言内容</td>	
			  	<td class="col-sm-3">操作</td>
			  </tr>

			  	<tr>
				  	<td class="col-sm-1">xxx</td>
				  	<td class="col-sm-2">xxxxxxxxxxx@qq.com</td>
				  	<td class="col-sm-6"><textarea class="form-control">xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</textarea></td>
				  	<td class="col-sm-3">
					  	<button class="btn btn-default">回复</button>
	                    <button class="btn btn-default">设为常规问题</button>
				  	</td>	  	
			  	</tr>

			</table>   -->
			
			<script type="text/javascript">
				
				var currentPage = 1;	
				var firstLi = 1;
				var countPage;
				var arrayDiv = new Array(10);
				var arrayR = new Array(10);
				var arrayName = new Array(10);
				var arrayEmail = new Array(10);
				var arrayContent = new Array(10);
				var arrayHidden = new Array(10);
				var arrayTextarea = new Array(10);
				var arrayPage = new Array(5);
				var arrayPageDownUp = new Array(2);
				var num;
				var  iniDiv =  function(){
					for(var i=1;i<11;i++){
							var div1 = $("<div style='display:none;'></div>");		//每个留言版的内容
							div1.attr("class","row");
							div1.attr("style","margin-bottom:5px;");
							div1.attr("name","message-piece");
							arrayDiv[i-1]= div1;			//加入到array里面
							
							var name = $('<div class="col-sm-1"></div>');
							arrayName[i-1] = name;
							
							var email = $("<div class='col-sm-2'></div>");
							arrayEmail[i-1] = email;
							
							var contentDiv = $("<div class='col-sm-6'></div>");
							var content = $('<textarea class="form-control"></textarea>');
							arrayContent[i-1] = content;
							contentDiv.append(content);

							var div2 = $("<div name='divButton'></div>");
							div2.attr("class","col-sm-3");
							var button1 = $("<button></button>");
							var button2 = $("<button id='buttonId"+i+"' onclick='changeAsQuestionOrNot(this);'></button>");
							button1.attr("class","btn btn-default");
							button2.attr("class","btn btn-default");
							button1.attr("type","button");
							
							button1.attr("data-toggle","collapse");
							button1.attr("data-target","#message"+i);
							button1.text("回复");
							button2.text("设为常规问题");
							div2.append(button1);
							div2.append(button2);
							
							div1.append(name);
							div1.append(email);
							div1.append(contentDiv);
							div1.append(div2);
							
							var div3 = $("<div ></div>");		//要留言的div
							div3.attr("class","collapse");
							div3.attr("id","message"+i);
							
							arrayR[i-1] = div3;
							
							var div4 = $("<div class='well'></div>");
							var textarea = $('<textarea class="form-control"></textarea>');
							arrayTextarea[i-1] = textarea;
							var submit = $('<button class="btn btn-success" onclick="sendAnswer(this,\'buttonId'+i+'\');">提交</button>');
							var hidden = $('<input type="hidden" />');
							arrayHidden[i-1] = hidden;
							
							div4.append(textarea);
							div4.append(submit);
							div4.append(hidden);
							
							div3.append(div4);
							$("#leavingWordBoard").append(div1);
							$("#leavingWordBoard").append(div3);
						}
					
					//页面分页初始化
					var nav = $("<nav></nav>");
						var ul = $('<ul class="pagination"></ul>');
							var last = $('<li style="display:none;" onclick="lastPageFunction();">'+
			      			//'<a onclick="lastPageFucntion();" aria-label="Previous">'+
			        		'<span aria-hidden="true">&laquo;</span>'+
			      			//'</a>'+
			    			'</li>');
							ul.append(last);
							arrayPageDownUp[0] = last;
						
							for(var i=0;i<5;i++){
								var li = $('<li style="display:none;" onclick="getByPage('+(firstLi+i)+');"></li>');
								if(currentPage==firstLi+i)
									li.html('<a><font color="red">&nbsp;'+(firstLi+i)+'&nbsp;</font></a>');
								else li.html('<a>&nbsp;'+(firstLi+i)+'&nbsp;</a>');
								ul.append(li);
								arrayPage[i] = li;
							}
						
						
							var next = $('<li style="display:none;" onclick="nextPageFunction();">'+
			      			//'<a onclick="nextPageFunction();" aria-label="Next">'+
			        		'<span aria-hidden="true">&raquo;</span>'+
			      			//'</a>'+
			    			'</li>');
							ul.append(next);
							arrayPageDownUp[1] = next;
							
						
						nav.append(ul);
						$("#leavingWordBoard").append(nav);
					
				}
				
				var getLeavingWordFunction = function(page){
					$.post("admin/word/getLeavingWord",{'currentPage':page},function(returnedData,status){
						//$("#leavingWordBoard").empty();
						
						var leavingWords = returnedData[0];
						if(returnedData[1]<=0) num=0;
						else
							num = returnedData[0].length;
						//alert(leavingWords[0].name);
						if(num<=0){
							$("#leavingWordBoard").children().remove();
							$("#leavingWordBoard").append("<h4><font color='red'>没有留言内容</font></h4>");
						}else{
							countPage = Math.floor((returnedData[1]-1)/10+1);
						if(currentPage>countPage) currentPage=countPage;//如果当前页面都要比总页面数要大，则当前页面应该为最大的页面
						//$("button[class='btn btn-default").attr("aria-expanded",'false');
						//$("button[class='btn btn-default").attr("class","btn btn-default collapsed");
						
						for(var i=1;i<leavingWords.length+1;i++){
							//arrayR[i-1].slideUp();
							arrayDiv[i-1].attr('style','margin-bottom:5px;');
							if(null==leavingWords[i-1].name)
								arrayName[i-1].text("");
							else
								arrayName[i-1].text(leavingWords[i-1].name);
							if(null==leavingWords[i-1].email)
								arrayEmail[i-1].text("");
							else
								arrayEmail[i-1].text(leavingWords[i-1].email);
							
							if(null==leavingWords[i-1].content)
								arrayContent[i-1].text("");
							else
								arrayContent[i-1].text(leavingWords[i-1].content);
							
							arrayTextarea[i-1].val("请输入回复内容");
							arrayHidden[i-1].attr('value',leavingWords[i-1].id);
							//alert(hidden.attr('value'));
						}
						
						for(var j=leavingWords.length;j<10;j++){
							arrayDiv[j].attr('style','display: none;');
							arrayR[j].attr('style','display: none;');
						}
						
						
						pageFunction();
						if(currentPage>countPage) currentPage=countPage;//如果当前页面都要比总页面数要大，则当前页面应该为最大的页面
						//$("button[class='btn btn-default").attr("aria-expanded",'false');
						//$("button[class='btn btn-default").attr("class","btn btn-default collapsed");
						
						for(var i=1;i<leavingWords.length+1;i++){
							//arrayR[i-1].slideUp();
							arrayDiv[i-1].attr('style','margin-bottom:5px;');
							if(null==leavingWords[i-1].name)
								arrayName[i-1].text("");
							else
								arrayName[i-1].text(leavingWords[i-1].name);
							if(null==leavingWords[i-1].email)
								arrayEmail[i-1].text("");
							else
								arrayEmail[i-1].text(leavingWords[i-1].email);
							
							if(null==leavingWords[i-1].content)
								arrayContent[i-1].text("");
							else
								arrayContent[i-1].text(leavingWords[i-1].content);
							
							arrayTextarea[i-1].val("请输入回复内容");
							arrayHidden[i-1].attr('value',leavingWords[i-1].id);
							//alert(hidden.attr('value'));
						}
						
						for(var i=leavingWords.length;i<10;i++){
							arrayDiv[i].attr('style','display: none;');
						}
						
						pageFunction();
						}
						
					})
				
				};
				// 发送回答
				var sendAnswer = function(submit,buttonId){
					if('不设为常规问题'==$("#"+buttonId).text()){
						$.ajax({  
	         				type : "post",  
	          				url : "admin/word/answerForLeavingWord",  
	          				data : {'leavingWordId':$(submit).next().attr('value')
							,'answer':$(submit).prev().val()
							,'setAsQuestion':'true'},
	          				async : false,  
	          				success : function(data){  
          				}  
     					}); 
					
					}else 
						$.ajax({  
	         				type : "post",  
	          				url : "admin/word/answerForLeavingWord",  
	          				data : {'leavingWordId':$(submit).next().attr('value')
							,'answer':$(submit).prev().val()
							,'setAsQuestion':'false'},
	          				async : false,  
	          				success : function(data){  
          				}  
     					});
					if(num==1)
							currentPage--;
					
					getLeavingWordFunction(currentPage);
						alert("回复留言成功");
				};
				
				//改变是否设置为常规问题
				var changeAsQuestionOrNot = function(button){
					if('设为常规问题'==$(button).text())
						$(button).text('不设为常规问题');
					else
						$(button).text('设为常规问题');
				}
				//分页的实现
				var pageFunction = function(){
				
					
					if(countPage<=5){
						arrayPageDownUp[0].attr('style','display:none;');
						arrayPageDownUp[1].attr('style','display:none;');
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
							
						if(currentPage==1) arrayPageDownUp[0].attr('style','display:none;'); 
						else arrayPageDownUp[0].attr('style',''); 
						if(currentPage>=countPage) arrayPageDownUp[1].attr('style','display:none;'); 
						else arrayPageDownUp[1].attr('style','');
						for(var i=0;i<5;i++){
							arrayPage[i].attr('style','');
							arrayPage[i].attr('style','');
							if(currentPage==firstLi+i)
								arrayPage[i].html('<a><font color="red">&nbsp;'+(firstLi+i)+'&nbsp;</font></a>');
							else 
								arrayPage[i].html('<a>&nbsp;'+(firstLi+i)+'&nbsp;</a>');
						}
						
					}
					
				};
				
				var getByPage = function(page){
					currentPage = page;
					getLeavingWordFunction(currentPage);
				}
				
				//上一页
				var lastPageFunction = function(){
					if(currentPage<=1) return;
					currentPage--;
					getLeavingWordFunction(currentPage);
						
				};
				//下一页	
				var nextPageFunction = function(){
					if(currentPage>=countPage) return;
					//alert(currentPage);
					currentPage++;
					getLeavingWordFunction(currentPage);
				};
				
				
				
				//getLeavingWordFunction(1);
				$(function(){
					iniDiv();
					getLeavingWordFunction(1);
				});
				
				</script>
				
				
			<div class="container exist-message" id="divDeal">
				<div class="row">
					<div class="col-sm-1">留言人</div>
					<div class="col-sm-2">联系方式</div>
					<div class="col-sm-6">留言人的留言内容</div>
					<div class="col-sm-3">操作</div>
				</div>
				<div id="leavingWordBoard"></div>
				
				<!--  
				<%for(int i=1;i<=10;i++){ %>
				<div class="row" style="margin-bottom:5px;" name="message-piece">
					<div class="col-sm-1">XXXXX</div>
					<div class="col-sm-2">xxxxxxxxxx@qq.com</div>
					<div class="col-sm-6"><textarea class="form-control">xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</textarea></div>
					<div class="col-sm-3">					  	
						<button class="btn btn-default" type="button" data-toggle="collapse" data-target="#message<%=i %>">回复</button>
	                    <button class="btn btn-default">设为常规问题</button>
	                </div>	
				</div>
				<div class="collapse" id="message<%=i %>">
					<div class="well">
						<textarea class="form-control">请输入回复内容</textarea>
						<button class="btn btn-success">提交</button>
					</div>					
				</div>
				<%} %>
				<nav>
				  <ul class="pagination">
				    <li>
				      <a href="#" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				    <li><a href="#">1</a></li>
				    <li><a href="#">2</a></li>
				    <li><a href="#">3</a></li>
				    <li><a href="#">4</a></li>
				    <li><a href="#">5</a></li>
				    <li>
				      <a href="#" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				  </ul>
				</nav>
				-->
			</div>
			
			<!--  	<div class="row col-sm-5 col-sm-offset-3" id="changepage"></div>-->
			</div>
        </div>
      
      <%@ include file="manFooter.jsp" %>
    </div>
	
  </body>
 </html>