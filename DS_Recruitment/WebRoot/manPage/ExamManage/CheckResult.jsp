<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>DS工作室-管理员-查看考试结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/manCss/GeneralSituationCSS.css">
	<link rel="stylesheet" type="text/css" href="css/manCss/shareCss.css">
	<link rel="shortcut icon" href="photos/DSlogo32.ico" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css" >

	
	<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
		
	<script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="js/bootstrap-datetimepicker.fr.js"></script>
	<script type="text/javascript" src="js/manJs/shareJS.js"></script>
<!--	<script type="text/javascript" src="js/manJs/CheckResultJs.js"></script>  -->

	
  </head>
  
  <body>
    <!--page header -->
    <div class="all">
      <div class="content">
        <%@ include file="../manHeader.jsp" %>
        <!-- navigation bar -->
        <div class="mainContent">
        	<div class="container">
        		<a class="col-sm-1 col-sm-offset-11 btn btn-success" style="margin-bottom:10px;" href="export/grade.xls">导出成绩</a>
        		<table class="table table-striped" style="text-align:center;">
        			<tr class="info">
        				<td class="col-sm-2">学号</td>
        				<td class="col-sm-2">姓名</td>
        				<td class="col-sm-2">性别</td>
        				<td class="col-sm-3">专业</td>
        				<td class="col-sm-1">选填题成绩</td>
        				<td class="col-sm-1">程序题成绩</td>
        			</tr>
        			<%for(int i=0;i<10;i++){ %><!-- 遍历所有考生信息 -->
	        			<tr name="stu-result-piece">
	        				<td class="col-sm-2">xxxxxxxxxx</td>
	        				<td class="col-sm-2">xxx</td>
	        				<td class="col-sm-2">mm</td>
	        				<td class="col-sm-3">xxxxxxxxxxxxxxxx</td>
	        				<td class="col-sm-1">99</td>
	        				<td class="col-sm-1">97</td>
	        			</tr>        			
        			<%} %>     			      			
        		</table>
        		<div class="container" style="text-align:center;">
	        		<nav style="margin:auto;">			//分页的使用
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
				</div>
        	</div>
        </div>
      </div>
      <%@ include file="../manFooter.jsp" %>
    </div>
  </body>
</html>




