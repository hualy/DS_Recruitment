<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>DS工作室页面丢失啦</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="photos/DSlogo32.ico" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<style type="text/css">
		*{
			margin:0px;
			padding:0px;
			border:0px;
		}
		body{
			background:rgb(52,74,95);
		}
		.cont{
			margin-top:10%;
		}
		.information p:nth-child(1){
			font-size:4rem;
		}
		.information p:nth-child(2),.information p:nth-child(3){
			font-size:1.5rem;
		}		
		.information{
			color:white;
			margin-top:4%;		
		}
		a{
			color:rgb(0,202,216);
		}
		a:hover{
			color:rgb(235,183,84);
		}
	</style>
  </head>
  
  <body>
  	<div class="container-fluid">
  		<div class="row cont">
  			<div class="col-sm-4 col-sm-offset-3 information">
	  			<p>您访问的页面暂时无法接通!</p>
	  			<p>在Q群公告点开链接的，请截下面“点击进入主页”按钮</p>
	  			<p>请稍后再访问或联系我们。Q群：475025206</p>
	  			<p><a href="http://120.76.100.254/DS/Home.html">点此进入主页</a></p>
  			</div>
  			<img class="col-sm-2 img-responsive" src="photos/404.png" alt="404-img"/>
  		</div>
  	</div>
  </body>
</html>
