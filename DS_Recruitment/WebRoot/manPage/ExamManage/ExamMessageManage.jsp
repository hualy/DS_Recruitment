<%@ page language="java" import="com.gdut.ds.beans.examination.*,java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>DS工作室-管理员-发布考试信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/manCss/ExamManageCss/ExamMessageManageCss.css">
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
	
	<script type="text/javascript" src="js/manJs/ExamManageJs/ExamMessageManageJs.js"></script>
	<script type="text/javascript" src="js/manJs/TimeChooseControlForExamAndInfo.js"></script>
	
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
	              <li>考试信息管理</li>
	              <li class="active">当前已有考试</li>
	            </ol>
	            <div class="exist-exam container">
	              <table class="table table-striped">
	                <tr class="info"><td>考试名称</td><td>当前选用的套题号</td><td>开始时间~结束时间</td><td>操作</td></tr>
	                
	                <% List<InformationForExam> examInfo = (List<InformationForExam>)request.getAttribute("examInfo"); %>
	                
	                <%for(int i = 0; i < examInfo.size(); i++){ %><!-- 遍历已有考试信息 -->
	                <tr><td><%= examInfo.get(i).getExamName() %></td><td><%= examInfo.get(i).getSetID() %></td><td><%=examInfo.get(i).getBeginTime().toLocaleString()%>~<%=examInfo.get(i).getEndTime().toLocaleString() %></td>
	                  <td>
	                  	<button class="btn btn-success pub-btn" type="button" location="<%= examInfo.get(i).getId() %>">发布</button>
	                    <button class="btn btn-warning" type="button" id="rev-EM-btn" location="<%= examInfo.get(i).getId()  %>">修改</button>
	                    <button class="btn btn-info pickUp-btn" type="button" location="<%= examInfo.get(i).getId() %>">提取试题</button>
	                    <button class="btn btn-danger cancel-btn" type="button" id="close-exam-btn" location="<%= examInfo.get(i).getId() %>">关闭</button>
	                  </td>
	                </tr>
	                <%} %>
	                <tr><td>new</td><td>unknow</td><td>unknow</td>
	                  <td>
	                    <button class="btn btn-success pub-newExam-btn" type="button">新增考试</button>
	                  </td>
	                </tr>	                
	              </table>
	            </div> 
	            <div class="container" id="ExamInformationForm">
	            	<form class="form-horizontal exam-message-form" method="post" id="pub-exam-message">
		              <input type="hidden" name="id" id="ID">
		              <div class="form-group">
		                <label class="col-sm-2 control-label">考试名称：</label>
		                <div class="col-sm-8">
		                  <input type="text" class="form-control" placeholder="请输入名称" name="examName" id="examName">
		                </div>
		              </div>	
		              <div class="form-group">
		                <label class="col-sm-2 control-label">套题编号：</label>
		                <div class="col-sm-2">
		                  <select class="form-control" name="setID" id="setID">
		                  
		                  <%  int sum = (Integer)session.getAttribute("examsum"); %>
		                  
		                  	<%for(int i=0;i<=sum;i++){ %><!-- 遍历已存在的套题 -->
		                  		<option value="<%= i %>"><%= i %></option>
		                  	<%} %>
		                  </select>
		                </div>
		              </div>
					  <div class="form-group">
			              <label class="col-sm-2 control-label">考试允许时间：</label>
			              <div class="col-sm-3">
			                   <input type="text" class="form-control timeChooser" name="beginTime">
			              </div>
			              <div class="col-sm-1" style="text-align:center;">~</div>
			              <div class="col-sm-3">
			                   <input type="text" class="form-control timeChooser" name="endTime">
			              </div>			              
			          </div>
		              <div class="form-group">
		                <label class="col-sm-2 control-label">考试用时：</label>
		                <div class="col-sm-2">
		                  <input type="text" class="form-control" placeholder="请输入考试限时" name="wholeTime" id="wholeTime">
		                </div>		
		                <label class="col-sm-1 control-label" style="text-align:left;">min</label>                
		              </div>
						<button class="btn btn-success col-sm-2 col-sm-offset-2 submit-btn" type="button">提交</button>
	              		<button class="btn btn-danger col-sm-2 col-sm-offset-2" type="button" id="giveUp-btn">放弃</button>  		              			          		              		              		                          		
	            	</form>
	            </div>    		
      		</div>
		</div>
    </div>
      <%@ include file="../manFooter.jsp" %>    
   </div>
  </body>
</html>




