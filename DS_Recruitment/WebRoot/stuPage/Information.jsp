<%@ page language="java" import="com.gdut.ds.beans.informationManagement.*,java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>公告</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1"><!--必须！！！-->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	

  	<link rel="stylesheet" type="text/css" media="all" href="css/bootstrap-glyphicons.css">
 	<link rel="stylesheet" type="text/css" media="all" href="css/stuCss/styles.css">
 
	<link rel="stylesheet" type="text/css" href="css/stuCss/headerCss.css">
	<link rel="stylesheet" type="text/css" href="css/stuCss/footerCss.css">

 	<link rel="stylesheet" type="text/css" href="css/stuCss/infoCss.css">
	<link rel="stylesheet" type="text/css" href="css/sweet-alert.css">
	

  <link rel="stylesheet" type="text/css" href="css/stuCss/infoCss.css">
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

<% 
	Map<String, Object> groupsInfo = (Map<String, Object>)request.getAttribute("groupsInfo");
	Map<String, Object> infoMap = (Map<String, Object>)request.getAttribute("infoMap");
		
	if(infoMap != null){
		List<Object> infoList = (List<Object>)infoMap.get("infoList");
		String[] infoName = (String[])infoMap.get("infoName");
		int[] monthnums = (int[])infoMap.get("monthnums"); 
		int maxMonth = (Integer)groupsInfo.get("maxMonth");
		int minMonth = (Integer)groupsInfo.get("minMonth");
		String[] months = {"XX","January","February","March","April","May","June","July","August","September","October","November","December"};
		int j = 1, k = 0;
			
%>

  <ul class="timeline">
  
  	<% for(int i = maxMonth; i >= minMonth; i--){
  		   j = 1;	
  	%>
  

    <li><div class="tldate"><%= months[i] %></div></li>
    
    	<% while(j <= monthnums[i] && monthnums[i] != 0){ 
    			if(infoName[k].equals("notice")){
    	%>
		    	<li>
			      <div class="tl-circ"></div><!--小圆点-->
			      <div class="timeline-panel"><!--时间面板-->
			        <div class="tl-heading"><!--标题以及时间-->
			          <h4><%= ((Notice)infoList.get(k)).getTopic() %></h4>
			          <p><small class="text-muted"><i class="glyphicon glyphicon-time"></i><%= ((Notice)infoList.get(k)).getTime().toLocaleString()  %></small></p> <!-- 最好要做成显示几个小时之前 -->
			        </div>
			        <div class="tl-body"><!--面板内容-->
			          <p><%=((Notice)infoList.get(k)).getContent() %></p>
			        </div>
			      </div>
			    </li>			
		<%   }else{ %>
    	
	    <li class="timeline-inverted" ><!--右边-->
	      <div class="tl-circ1"></div>
	      <div class="timeline-panel">
	        <div class="tl-heading">
	          <h4><%= ((Recruitment)infoList.get(k)).getTopic() %></h4>
	          <p><small class="text-muted"><i class="glyphicon glyphicon-time"></i><%= ((Recruitment)infoList.get(k)).getTime().toLocaleString() %></small></p>
	        </div>
	        <div class="tl-body">
	          <p><%= ((Recruitment)infoList.get(k)).getContent() %></p>
	        </div>
	      </div>
	    </li>
	    
	<% 

			}
			k++;j++;
		}
  	}
	%>
	    
  </ul>
  <%		
}else{

%>
	<div align="center"><h1 style="color: white">公告正在来的路上，去主页看看吧！</h1></div>
<% 
}
%>
  
</div>
  	<%@ include file="Footer.jsp" %>
  	
  	<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script src="js/sweet-alert.min.js"></script> 
  </body>
</html>
