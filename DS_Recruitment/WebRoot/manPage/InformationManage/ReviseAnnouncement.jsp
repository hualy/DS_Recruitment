<%@ page language="java" import="com.gdut.ds.beans.informationManagement.*,java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>DS工作室-管理员-修改公告</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/manCss/InformationManageCss.css">
	<link rel="stylesheet" type="text/css" href="css/manCss/shareCss.css">
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css" >
	
	<link rel="shortcut icon" href="photos/DSlogo32.ico" />
	
	<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	
	<script type="text/javascript" src="js/sweet-alert.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/sweet-alert.css">	
	
	<script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="js/bootstrap-datetimepicker.fr.js"></script>
	<script type="text/javascript" src="js/manJs/shareJS.js"></script>
	
	<script type="text/javascript" src="js/manJs/TimeChooseControlForExamAndInfo.js"></script>
	<script type="text/javascript" src="js/manJs/InformationManageJs/ReviseAnnouncementJs.js"></script>
	
	
	<script type="text/javascript" src="js/manJs/FormValidation/shareValidationJs.js"></script>
	<script type="text/javascript" src="js/manJs/FormValidation/InformationFormValidation/InfFormValidation.js"></script>
	
  </head>
  <body>
  	 <!--page header -->
    <div class="all">
      <div class="content">
        <%@ include file="../manHeader.jsp" %>
        <!-- navigation bar -->
        <div class="mainContent">
			<!--修改公告页面-->
          <div class="container rev-member">
            <ol class="breadcrumb">
                <li>首页</li>
                <li>信息管理</li>
                <li class="active">修改公告</li>
            </ol>
            <div class="exist-ann container">
            
              <%
              	List<Notice> noticeList = (List<Notice>)request.getAttribute("notices");
              %>
            
              <table class="table table-striped">
                <tr class="info"><td>公告主题</td><td>发布时间</td><td>操作</td></tr>
                
                <%for(int i = 0; i < noticeList.size(); i++){ %>
                <tr id="<%= noticeList.get(i).getId() %>"><td><%= noticeList.get(i).getTopic() %></td><td><%= noticeList.get(i).getTime().toLocaleString() %></td>
                 	<!-- 添加一个记录当前位置的值i -->
                  <td>
                    <button class="btn btn-default" type="button" id="rev-ann-btn" location="<%= noticeList.get(i).getId() %>">修改</button>
                    <button class="btn btn-danger" type="button" id="del-ann-btn" location="<%= noticeList.get(i).getId() %>">删除</button>
                  </td>
                </tr>  
                <%} %>  
                          
              </table>
            </div>
            
            <div class="revise-ann container">
              <form class="form-horizontal" id="revise-form"  method="post">
              
              		<input type="hidden" name="id" id="pos">
              
	            	<div class="form-group has-feedback themeBar">
		                <label class="col-sm-2 control-label">主题：</label>
		                <div class="col-sm-8">
		                  <input type="text" class="form-control theme" placeholder="请输入主题" name="topic" id="topic">
		                  <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display: none;"></span>
		               	  <span style="color:red;"></span>			                
		                </div>
		            </div>
					<div class="form-group has-feedback timeBar">
		                <label class="col-sm-2 control-label">时间：</label>
		                <div class="col-sm-3">
		                     <input type="text" class="form-control timeChooser time" name="time" id="time">
		                  	 <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display: none;"></span>
		               	  	 <span style="color:red;"></span>			                
		                </div>
		            </div>
		            <div class="form-group has-feedback annBar">
		                <label class="col-sm-2 control-label">公告内容：</label>
		                <div class="col-sm-5">
		                  <textarea class="form-control ann" id="describe" rows="4" name="content" ></textarea>
		                  <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display: none;"></span>
		               	  <span style="color:red;"></span>			                
		                </div>
		            </div> 	               
                <button class="btn btn-success col-sm-2 col-sm-offset-2" type="button" id="revise-btn">保存修改</button>
                <button class="btn btn-danger col-sm-2 col-sm-offset-2" type="button" id="giveUp">放弃修改</button>
              </form>
            </div>
            
          </div> 
          <!--修改公告页面-->
        </div>
      </div>
      <%@ include file="../manFooter.jsp" %>
    </div>
	
  </body>
 </html>