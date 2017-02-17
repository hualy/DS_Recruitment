<%@ page language="java" import="com.gdut.ds.beans.examination.*,java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>DS工作室-管理员-试题管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/manCss/shareCss.css">
	<link rel="shortcut icon" href="photos/DSlogo32.ico" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css" >
	<link rel="stylesheet" type="text/css" href="css/sweet-alert.css">
	
	
	<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/sweet-alert.min.js"></script>
	
		
	<script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="js/bootstrap-datetimepicker.fr.js"></script>
	<script type="text/javascript" src="js/manJs/shareJS.js"></script>
	
	<script type="text/javascript" src="js/manJs/ExamManageJs/ExamTopicManage.js"></script>

	
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
	              <li class="active">试题管理</li>
	            </ol>
	            <div class="container exist-ExamTopic">
	            	<table class="table table-striped" style="text-align:center;">
		                <tr class="info"><td>试题名称</td><td>试题号</td><td>操作</td></tr>
		                
		          <% List<ExaminationQuestions> exams = (List<ExaminationQuestions> )request.getAttribute("exams"); %>
		                
		                <%for(int i=0; i < exams.size(); i++){ %>
		                <tr id="<%= exams.get(i).getId()%>"><td><%= exams.get(i).getName() %></td><td><%= exams.get(i).getSetID() %></td>
		                  <td>
		                    <button class="btn btn-default rev-examination" type="button" location="<%= exams.get(i).getId()%>">修改</button>
		                    <button class="btn btn-danger del-btn" type="button" location="<%= exams.get(i).getId()%>">删除</button>

		                  </td>
		                </tr>
		                <%} %>

		                <tr><td><input class="form-control" type="text" placeholder="试题名称" id="name"/></td>
		                	<td style="text-align:center;"><input class="form-control" type="number" style="width:30%;margin:auto;" placeholder="试题号" id="setID"/></td>
		                	<td>
		                		<button class="btn btn-success add-examination" type="button">添加试题</button>
		                	</td>
		                </tr>	            		
	            	</table>	            	
	            </div>
			</div>
    	</div>
      </div>
      <%@ include file="../manFooter.jsp" %>
    </div>
  </body>
</html>




