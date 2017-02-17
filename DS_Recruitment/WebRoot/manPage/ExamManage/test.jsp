<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>DS工作室-管理员-修改试题</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/manCss/shareCss.css">
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css" >
	<link rel="stylesheet" type="text/css" href="css/manCss/ExamManageCss/ReviseExaminationCss.css">

	
	<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
		
	<script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="js/bootstrap-datetimepicker.fr.js"></script>
	<script type="text/javascript" src="js/manJs/shareJS.js"></script>
	
	<script type="text/javascript" src="js/manJs/test.js"></script>
	<script type="text/javascript" src="js/bootstrapToolsJs/tooltip.js"></script>

	
  </head>
  
  <body>
    <!--page header -->
    <div class="all">
      <div class="content">
      <%@ include file="../manHeader.jsp" %>
      	<div class="mainContent">
			<div class="form-group">
				<label class="col-sm-2 control-label">题目：</label>
				<div class="col-sm-10">
					<div class="input-group">
						<input type="text" class="form-control"  placeholder='请输入题目内容         请用   "_"  代替空格输入' data-toggle="tooltip" data-placement="top" title="用下划线替代填空题的空格。示例：前端主要学_语言、_语言。注意：下划线需为英文输入">
						<span class="input-group-btn">
							<button class="btn btn-default fill-ans-btn" type="button" data-toggle="tooltip" data-placement="top" title="一旦生成，将无法修改题目">生成答案域</button>
						</span>
					</div>
				</div>
			</div>      		
        </div>
      <%@ include file="../manFooter.jsp" %>
    </div>
  </body>
</html>




