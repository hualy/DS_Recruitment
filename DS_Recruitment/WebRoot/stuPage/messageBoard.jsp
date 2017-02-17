<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="S" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>留言板</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	
	<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
	<link rel="stylesheet" type="text/css" href="css/stuCss/headerCss.css">
	<link rel="stylesheet" type="text/css" href="css/stuCss/footerCss.css">
	<link rel="stylesheet" type="text/css" href="css/stuCss/message.css">
	
	
	<link rel="stylesheet" type="text/css" href="css/sweet-alert.css">
	<link rel="shortcut icon" href="photos/DSlogo32.ico" />
	
   	<script type="text/javascript">

		function myBrowser(){
		     var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
		     // alert(userAgent);
		    var isOpera = userAgent.indexOf("Opera") > -1; //判断是否Opera浏览器
		    var isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !isOpera; //判断是否IE浏览器
		    var isFF = userAgent.indexOf("Firefox") > -1; //判断是否Firefox浏览器
		    var isSafari = userAgent.indexOf("Safari") > -1; //判断是否Safari浏览器
		    if (isIE) {
		         var IE5 = IE55 = IE6 = IE7 = IE8 = false;
		         var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
		         reIE.test(userAgent);
		         var fIEVersion = parseFloat(RegExp["$1"]);
		         IE55 = fIEVersion == 5.5;
		         IE6 = fIEVersion == 6.0;
		         IE7 = fIEVersion == 7.0;
		         IE8 = fIEVersion == 8.0;
		         IE9 = fIEVersion == 9.0;
		         IE10 = fIEVersion == 10.0;
		         IE11 = fIEVersion == 11.0;
		
		         if (IE55) {
		             return "IE55";
		         }
		         if (IE6) {
		             return "IE6";
		         }
		         if (IE7) {
		             return "IE7";
		         }
		         if (IE8) {
		             return "IE8";
		         }
		         if (IE9) {
		             return "IE9";
		         }
		         if (IE10) {
		             return "IE10";
		         }
		         if (IE11) {
		             return "IE11";
		         }        
		     }//isIE end
		     if (isFF) {
		         return "FF";
		     }
		     if (isOpera) {
		         return "Opera";
		     }
		 }//myBrowser() end
		 //以下是调用上面的函数
		 var myB = myBrowser()
		 if (myB == "IE55"||myB == "IE6"||myB == "IE7"||myB == "IE8"||myB == "IE9"||myB == "IE10"||myB == "IE11") {
		     //sawl("浏览器不兼容","请使用360极速浏览器（极速模式），360安全浏览器，火狐浏览器，谷歌浏览器，safari进行浏览","error");
		 	alert("为了你的浏览体验，请使用360极速浏览器（极速模式），360安全浏览器，火狐浏览器，谷歌浏览器，safari进行浏览");
		 }
			
	</script>
  </head>
  
  <body>
    <%@ include file="Header.jsp" %>

    

    <div class="container" style="min-height:470px;margin-top: 20px;">
    <h3>查看问题及回复</h3>
    <button class="btn btn-primary col-sm-2" type="submit" id="btn" style="float: right; margin-top: -39px;">我要留言</button>
    <hr style="height:2px;background-color: #3caee7" >
    <!--
    <div class="panel panel-default">
      <div class="panel-heading"><img src="photos/stuImg/pic7.jpg" alt="" class="img-circle" style="width:80px;margin-top: -55px; margin-left: -15px;border:5px solid #fff" >
        <div><h4>问题：xxxx</h4>
        </div>
      </div>
        <div class="panel-body">
            回复：xxx
        </div>
    </div>

    <div class="panel panel-default">
      <div class="panel-heading"><img src="photos/stuImg/pic8.jpg" alt="" class="img-circle" style="width:80px;margin-top: -55px; margin-left: -15px;border:5px solid #fff" >
        <div><h4>问题：xxxx</h4>
        </div>
      </div>
        <div class="panel-body">
            回复：xxx
        </div>
    </div>

    <div class="panel panel-default">
      <div class="panel-heading"><img src="photos/stuImg/pic9.jpg" alt="" class="img-circle" style="width:80px;margin-top: -55px; margin-left: -15px;border:5px solid #fff" >
        <div><h4>问题：xxxx</h4>
        </div>
      </div>
        <div class="panel-body">
            回复：xxx
        </div>
    </div>

    <div class="panel panel-default">
      <div class="panel-heading"><img src="photos/stuImg/pic7.jpg" alt="" class="img-circle" style="width:80px;margin-top: -55px; margin-left: -15px;border:5px solid #fff" >
        <div><h4>问题：xxxx</h4>
        </div>
      </div>
        <div class="panel-body">
            回复：xxx
        </div>
    </div>

    <div class="container" style="text-align:center">
        <div id="navi">
          <ul class="pagination" >
            <li><a href="#">&laquo;</a></li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">&raquo;</a></li>
          </ul>
        </div>
    </div>
    
    
     -->

 <script type="text/javascript">

 	
 </script> 


    <hr style="height:2px;background-color: #3caee7" ><!--分割线-->
    <form class="form-horizontal" id="here"  method="post" onsubmit="return validate(this);"><!--here为定位-->
    	<div class="form-group has-feedback">
    		<label class="control-label col-sm-1" for="inputSuccessName"><span style="color:red;margin-right:2px;">*</span>姓名：</label>
            <div class="col-sm-3" id="nameDiv">
                <input type="text" class="form-control" name="name" id="inputSuccessName" aria-describedby="inputSuccessState">
                <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display:none" id="namespansuccess"></span>
                <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="display:none" id="namespanerror"></span>
            </div>
            <div class="col-sm-3" id="nameTip" display="none" style="color: #e4c12e;"></div>
    	</div>

    	<div class="form-group has-feedback">
    		<label class="control-label col-sm-1" for="inputSuccessQQ"><span style="color:red;margin-right:2px;">*</span>QQ：</label>
            <div class="col-sm-3" id="qqDiv">
                <input type="text" class="form-control " name="QQ" id="inputSuccessQQ" aria-describedby="inputSuccessState">
                <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display:none" id="qqspansuccess"></span>
                <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="display:none" id="qqspanerror"></span>
            </div>
            <div class="col-sm-3" id="qqTip" style="color: #e4c12e;"></div>
    	</div>

    	<div class="form-group  has-feedback">
    		<label class="control-label col-sm-1" for="inputSuccessEmail"><span style="color:red;margin-right:2px;">*</span>邮箱：</label>
            <div class="col-sm-3" id="emailDiv">
            <input type="text" class="form-control " placeholder="Email" name='email' id="inputSuccessEmail" aria-describedby="inputSuccessState">
            <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display:none;" id="emailspansuccess"></span>
            <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="display:none" id="emailspanerror"></span>
        	</div>
            <div class="col-sm-3" id="emailTip" style="color: #e4c12e;"></div>
    	</div>


        <div class="form-group has-feedback">
            <label class="control-label col-sm-1" for="inputSuccessInformation"><span style="color:red;margin-right:2px;">*</span>留言：</label>
            <div class="col-sm-6" id="informationDiv">
                <textarea class="form-control" rows="5" name="content" style="resize:none" id="inputSuccessInformation" placeholder="不多于200字"></textarea>
                <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display:none;" id="informationspansuccess"></span>
            	<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="display:none" id="informationspanerror"></span>
            </div>
            <div class="col-sm-8 col-sm-offset-1" id="informationTip" style="color: #e4c12e;"></div>
        </div>
    	
        <div class="form-group">
          <div class="col-sm-offset-5 col-sm-10">
            <button type="submit" class="btn btn-primary col-sm-2" >提交</button>
          </div>
        </div>
       
    </form>



    </div><!-- container 结束 -->
    <%@ include file="Footer.jsp" %>
    <script type="text/javascript">

				var currentPage = 1;	
				var firstLi = 1;
				var countPage;
				var arrayDiv = new Array(10);
				var arrayImg = new Array(10);
				var arrayQuestionDiv = new Array(10);
				var arrayAnswerDiv = new Array(10);

				var arrayPage = new Array(5);
				var arrayPageDownUp = new Array(2);

				var num;

				var  iniDiv =  function(){
					for(var i=0;i<arrayDiv.length;i++){
						var div1 = $('<div style="display:none;" class="panel panel-default"></div>');
						var div2 = $('<div class="panel-heading"></div>');
						div2.css('margin-top','60px');
						var img  = $('<img alt="" class="img-circle" style="width:80px;margin-top: -55px; margin-left: -15px;border:5px solid #fff" />');
						var questionDiv = $('<div></div>');
						var answerDiv = $('<div class="panel-body"></div>');

						div1.append(div2);
						div2.append(img);
						div2.append(questionDiv);
						div1.append(answerDiv);
						
						arrayDiv[i] = div1;
						arrayImg[i] = img;
						arrayQuestionDiv[i] = questionDiv;
						arrayAnswerDiv[i] = answerDiv;
					}
					
					//设置图片 
					arrayImg[0].attr('src','photos/stuImg/pic7.jpg');
					arrayImg[1].attr('src','photos/stuImg/pic8.jpg');
					arrayImg[2].attr('src','photos/stuImg/pic9.jpg');
					arrayImg[3].attr('src','photos/stuImg/pic7.jpg');
					
					//设置顺序
					$('hr:first').after(arrayDiv[0]);
					for(var i=0;i<arrayDiv.length-1;i++){
						arrayDiv[i].after(arrayDiv[i+1]);
					}
					
					//页面分页初始化
					var nav = $("<nav></nav>");
						nav.css('text-align', 'center');
						nav.css('cursor','pointer');
						var ul = $('<ul class="pagination"></ul>');
							var last = $('<li style="display:none;" onclick="lastPageFunction();">'+
			      			//'<a onclick="lastPageFucntion();" aria-label="Previous">'+
			        		'<span aria-hidden="true">&laquo;</span>'+
			      			//'</a>'+
			    			'</li>');
							ul.append(last);
							arrayPageDownUp[0] = last;
						
							for(var i=0;i<5;i++){
								var li = $('<li style="display:none;" onclick="getByPage();"></li>');
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
						arrayDiv[3].after(nav);
					
				}
				
				var getQuestionFunction = function(page){
					$.post("word/getQuestion",{'currentPage':page},function(returnedData,status){
						
						
						var questions = returnedData[0];
						if(returnedData[1]<=0) num =0;
						else num = returnedData[0].length;
						if(num<=0){
							$("hr:first").nextAll('div').remove();
							$("hr:first").after("<h4>没有常规问题回答</h4>");
						}else{
							countPage = Math.floor((returnedData[1]-1)/4+1);	//得到页数
						//alert(countPage);
						if(currentPage>countPage) currentPage=countPage;//如果当前页面都要比总页面数要大，则当前页面应该为最大的页面
						for(var i=1;i<questions.length+1;i++){
							arrayDiv[i-1].attr('style','');
							
							if(null==questions[i-1].problem)
								arrayQuestionDiv[i-1].html('<h4>问题：</h4>');
							else
								arrayQuestionDiv[i-1].html('<h4>问题：'+questions[i-1].problem+'</h4>');
							if(null==questions[i-1].answer)
								arrayAnswerDiv[i-1].text("回答：");
							else
								arrayAnswerDiv[i-1].text("回答："+questions[i-1].answer);
							
						}
						
						for(var i=questions.length;i<4;i++){
							arrayDiv[i].attr('style','display: none;');
						}
						
						pageFunction();
						}
						
						
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
							else {
								arrayPage[i].html('<a>&nbsp;'+(firstLi+i)+'&nbsp;</a>');
								arrayPage[i].attr('onclick','getByPage('+(firstLi+i)+')');
							}
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
							
							if(currentPage==firstLi+i)
								arrayPage[i].html('<a><font color="red">&nbsp;'+(firstLi+i)+'&nbsp;</font></a>');
							else{
								arrayPage[i].html('<a>&nbsp;'+(firstLi+i)+'&nbsp;</a>');
								arrayPage[i].attr('onclick','getByPage('+(firstLi+i)+')');
							} 
								
						}
						
					}
					
					if(currentPage<=1) arrayPageDownUp[0].attr('style','display:none;'); 
					else arrayPageDownUp[0].attr('style',''); 
					if(currentPage>=countPage) arrayPageDownUp[1].attr('style','display:none;'); 
					else arrayPageDownUp[1].attr('style','');
					
				};
				
				var getByPage = function(page){
					
					//alert($(this));
					currentPage = page;
					getQuestionFunction(currentPage);
				}
				
				//上一页
				var lastPageFunction = function(){
					if(currentPage<=1) return;
					currentPage--;
					getQuestionFunction(currentPage);
						
				};
				//下一页	
				var nextPageFunction = function(){
					if(currentPage>=countPage) return;
					//alert(currentPage);
					currentPage++;
					getQuestionFunction(currentPage);
				};
				
				$(function(){
					iniDiv();
					getQuestionFunction(1);
				});
	</script>
    
    <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script src="js/sweet-alert.min.js"></script> 
	 <script type="text/javascript" src="js/stuJs/InfoFormCheck.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function($) {
            $("#btn").click(function(event) {
                /* Act on the event */
                document.getElementById('here').scrollIntoView();
            });
        });
    </script>
  </body>
</html>
