<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>DS工作室-管理员-发布交流会</title>
    
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
	
	<script type="text/javascript" src="js/manJs/TimeChooseControlForGeneral.js"></script>
	
	<script type="text/javascript" src="js/manJs/FormValidation/shareValidationJs.js"></script>
	<script type="text/javascript" src="js/manJs/FormValidation/GeneralFormValidation/Com-FormValidation.js"></script>	

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
	              <li>概况管理</li>
	              <li class="active">发布交流会</li>
	            </ol>
	            
	            <%String message = (String)request.getParameter("message");
	            if(null!=message&&!"".equals(message.trim())){
	            	%>  
	            	<script type="text/javascript">
	            		alert("<%=message%>");
	            	</script>
	            	
	            	<% 
	            }
	            %>
	            <form class="form-horizontal" action='admin/introduction/createInterecommunion' enctype='multipart/form-data' method="post" id="pub-com-form">
	            	<div class="form-group has-feedback themeBar">
		                <label class="col-sm-2 control-label">主题：</label>
		                <div class="col-sm-8">
		                  <input type="text" class="form-control theme" name='theme' placeholder="请输入主题">
		                  <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display: none;"></span>
		               	  <span style="color:red;"></span>			                  
		                </div>
		            </div>
					<div class="form-group has-feedback	timeBar">
		                <label class="col-sm-2 control-label">时间：</label>
		                <div class="col-sm-3">
		                     <input type="text" value="2016-03-08" name='date' class="form-control timeChooser time">
		                  	 <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display: none;"></span>
		               	  	 <span style="color:red;"></span>			                     
		                </div>
		            </div>
		            <div class="form-group has-feedback speakerBar">
		                <label class="col-sm-2 control-label">主讲人：</label>
		                <div class="col-sm-4">
		                  <input type="text" class="form-control speaker" name='speaker' placeholder="请输入组织者姓名">
		                  <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display: none;"></span>
		               	  <span style="color:red;"></span>			                
		                </div>
		            </div>	
		              <div class="form-group">
		              	<label class="col-sm-2 control-label">照片：</label>
		              	<div class="col-sm-2 has-feedback">
		                     <input type="file" name='files' class="form-control imgs">
		                  	 <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display: none;"></span>
		               	     <span style="color:red;"></span>			                     
		                </div>
		              	<div class="col-sm-2 has-feedback">
		                     <input type="file" name='files' class="form-control imgs">
		                  	 <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display: none;"></span>
		               	     <span style="color:red;"></span>			                     
		                </div>
		              	<div class="col-sm-2 has-feedback">
		                     <input type="file" name='files' class="form-control imgs">
		                  	 <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display: none;"></span>
		               	     <span style="color:red;"></span>			                     
		                </div>                              
		              </div>   		            
			 		 <div class="form-group has-feedback contentBar">
		                <label class="col-sm-2 control-label">交流会总结：</label>
		                <div class="col-sm-8">
		                    <textarea class="form-control com-result" rows="4" name='content' wrap="hard"></textarea>
		                  	<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display: none;"></span>
		               	    <span style="color:red;"></span>		                    
		                </div>
		             </div> 		           
		            <button class="btn btn-success col-sm-2 col-sm-offset-2 pub-com-btn" type="button">提交</button>
		            <button class="btn btn-danger col-sm-2 col-sm-offset-2" type="reset">重置</button>    
	            </form>
            </div>
        </div>
      </div>
      <%@ include file="../manFooter.jsp" %>
    </div>
  </body>
 </html>