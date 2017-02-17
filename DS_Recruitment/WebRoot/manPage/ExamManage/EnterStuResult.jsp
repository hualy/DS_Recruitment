<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>DS工作室-管理员-录入考生成绩</title>
    
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

	
  </head>
  
  <body>
    <!--page header -->
    <div class="all">
      <div class="content">
        <%@ include file="../manHeader.jsp" %>
        <!-- navigation bar -->
        <div class="mainContent">
        	<div class="container">
      			<ol class="breadcrumb">
	              <li>首页</li>
	              <li>笔试管理</li>
	              <li class="active">录入考生成绩</li>
	            </ol>
	            <form class="form-horizontal">
	            <div class="container">      	
        		
        			<table class="table table-striped" style="text-align:center;">
						<tr class="info">
							<td class="col-sm-2">考生学号</td>
							<td class="col-sm-2">考生姓名</td>
							<td class="col-sm-2">考生选填成绩</td>
							<td class="col-sm-2">程序题成绩</td>
						</tr>
		                <%for(int i=0;i<10;i++){ %>
			                <tr><td class="col-sm-2">xxxx</td><td class="col-sm-2">xxxx</td><td class="col-sm-2">xxxx</td>
			                <td class="col-sm-2" style="text-align:center;">
			                <input type="text" class="form-control" placeholder="请输入程序题成绩" style="margin:auto;width:50%;"></td></tr>
		                <%} %>
					</table>
        		</div>  
        		<div style="text-align:center;">
	        		<nav style="margin:auto;">
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
				<div class="container">
					<button class="btn btn-success col-sm-2 col-sm-offset-5" type="submit">提交</button> 
        		</div>
				</form>      		
        		
        	</div>
        </div>
      </div>
      <%@ include file="../manFooter.jsp" %>
    </div>
  </body>
</html>




