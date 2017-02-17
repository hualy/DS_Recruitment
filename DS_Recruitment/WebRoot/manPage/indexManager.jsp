<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>DS工作室-管理员</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/manCss/GeneralSituationCSS.css">
	<link rel="stylesheet" type="text/css" href="css/manCss/shareCss.css">
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css" >
	<link rel="stylesheet" type="text/css" href="css/sweet-alert.css">
	<link rel="shortcut icon" href="photos/DSlogo32.ico" />
	
	<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
		
	<script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="js/bootstrap-datetimepicker.fr.js"></script>
	<script type="text/javascript" src="js/sweet-alert.min.js"></script> 
	<script type="text/javascript" src="js/manJs/shareJS.js"></script>
	<style type="text/css">
		.mainContent{
			text-align: center;
		}
		.mainTitle{
			width: 25%;
			margin: auto;
			margin-top: 100px;
			font-size: 4rem;
			font-family: 隶书;
			color: #124734;

		}
	</style>
	
  </head>
  
  <body>
    <!--page header -->
    <div class="all">
      <div class="content">
        <%@ include file="manHeader.jsp" %>
        <!-- navigation bar -->
        <div class="mainContent">
          <!--首页-->
          <div class="mainTitle">
            <p>DS工作室网站</p>
            <p>---管理员版---</p>        
          </div>
          <!--首页-->
        </div>
      </div>
      <%@ include file="manFooter.jsp" %>
    </div>
  </body>
</html>




