<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>DS的服务器繁忙呀</title>
    
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
			background:rgb(21,28,34);
		}
		.cont{
			margin-top:13%;
		}
		.information p:nth-child(1){
			font-size:4rem;
		}
		.information p:nth-child(2){
			font-size:1.5rem;
		}		
		.information{
			color:white;
			margin-top:8%;		
		}
		a{
			color:rgb(0,202,216);
		}
		a:hover{
			color:rgb(235,183,84);
		}
		img{
			margin-top:5%;
		}
	</style>
  </head>
  
  <body>
  	<div class="container-fluid">
  		<div class="row cont">
  			<div class="col-sm-3 col-sm-offset-3 information">
	  			<p>服务器繁忙!</p>
	  			<p>请稍后再访问或联系我们。Q群：475025206</p>
	  			<p><a href="http://120.76.100.254/DS/Home.html">点此转至主页</a></p>
  			</div>
  			<img class="col-sm-4 img-responsive" src="photos/500.png" alt="500-img"/>
  		</div>
  	</div>
  </body>
</html>
