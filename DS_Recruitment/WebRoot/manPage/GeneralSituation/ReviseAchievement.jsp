<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>DS工作室-管理员-修改成果</title>
    
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
	
	<script type="text/javascript" src="js/manJs/FormValidation/shareValidationJs.js"></script>
	<script type="text/javascript" src="js/manJs/FormValidation/GeneralFormValidation/Ach-FormValidation.js"></script>
	
	<script type="text/javascript" src="js/manJs/TimeChooseControlForGeneral.js"></script>
	<script type="text/javascript" src="js/manJs/GeneralSituaionJs/ReviseAchievementJs.js"></script>
  </head>
  <body>
  	 <!--page header -->
    <div class="all">
      <div class="content">
        <%@ include file="../manHeader.jsp" %>
        <!-- navigation bar -->
        <div class="mainContent">
        	 <!--修改成果页面-->
          <div class="rev-achievement container">
            <ol class="breadcrumb">
              <li>首页</li>
              <li>概况管理</li>
              <li class="active">修改成果展示</li>
            </ol>
            
             <script type="text/javascript">
        jQuery(document).ready(function($) {
            $("#btn").click(function(event) {
                /* Act on the event */
                document.getElementById('here').scrollIntoView();
            });
        });

    </script>
  
  				<%String message = (String)request.getParameter("message");
	            if(null!=message&&!"".equals(message.trim())){
	            	%>  
	            	<script type="text/javascript">
	            		alert("<%=message%>");
	            	</script>
	            	
	            	<% 
	            }
	            %>

    
            <div class="exist-ach container" >
              <table class="table table-striped">
                <tr class="info" id='trRevise'><td>主题</td><td>类型</td><td>时间</td><td>操作</td></tr>
               <!-- 
                <%for(int i=0;i<4;i++){ %>
                <tr><td>xxxx</td><td>项目</td><td>2016-2-27</td>
                  <td>
                    <button class="btn btn-default">修改</button>
                    <button class="btn btn-danger">删除</button>
                  </td>
                </tr>
                <%} %>
                 -->
              </table>
            </div>  
            <div class="revise-ach container">

            <form class="form-horizontal" action="admin/introduction/updateResult" enctype="multipart/form-data" method="post" id="rev-ach">
 			 <div class="form-group has-feedback themeBar" >
                <label class="col-sm-2 control-label">主题：</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" name="theme" id="theme" placeholder="请输入主题">
                  <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="display: none;" id="TMessLogo"></span>
                  <span style="color:red;display:none;" id="themeMess">*主题不能为空</span>

                </div>
              </div>
              <div class="form-group has-feedback dateBar">
                <label class="col-sm-2 control-label">时间：</label>
                <div class="col-sm-4">
                     <input type="text" value="2016-03-08" name='date' class="form-control timeChooser date">
                     <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="display: none;"></span>
                	 <span style="color:red;" id="dateMess"></span>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">类型：</label>
                <span class="radio col-sm-2">
                  <label>
                    <input type="radio" name="type"  value="0" checked>
                    	比赛
                  </label>
                </span>
                <span class="radio col-sm-2">
                  <label>
                    <input type="radio" name="type" value="1">
                    	项目
                  </label>
                </span>
              </div>  
              <div class="form-group has-feedback memberBar">
                <label class="col-sm-2 control-label">参与者：</label>
                <div class="col-sm-2">
                     <input type="text" class="form-control leaderName" name='leaderName' placeholder="组长">
                     <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="display: none;"></span>
                     <span style="color:red;" id="leaderMess"></span>
                </div>
                <div class="col-sm-6">
                     <input type="text" class="form-control membersName" name='membersName' placeholder="成员">
                     <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="display: none;"></span>
                	 <span style="color:red;" id="membersMess"></span>
                </div>
              </div>
  		        <div class="form-group">
					<label class="col-sm-2 control-label">配图：</label>
					<div class="col-sm-2">
						<button class="btn btn-default change-img-btn" type="button">更换</button>
						<input type="hidden" name="resetPicture" value="false"/>
					</div>					
                </div>            
	              <div class="form-group desBar">
	                <label class="col-sm-2 control-label">项目简介：</label>
	                <div class="col-sm-8">
	                  <textarea class="form-control description" rows="4" name='description'></textarea>
	                  <span style="color:red;" id="DesMess"></span>
	                </div>
	              </div>
                <input class="btn btn-success col-sm-2 col-sm-offset-2" id="rev-ach-btn" type="button" value="保存修改">
                <input class="btn btn-danger col-sm-2 col-sm-offset-2 cancel-btn" type="button" value="放弃修改">
             	<input type='hidden' name="resultId" />
              </form>
            </div>
          </div>
          <!--修改成果页面-->
        </div>
      </div>
      <%@ include file="../manFooter.jsp" %>
    </div>
	
  </body>
 </html>