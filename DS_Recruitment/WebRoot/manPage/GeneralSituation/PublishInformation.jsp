<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>DS工作室-管理员-发布推送</title>
    
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

	<script type="text/javascript" src="js/manJs/XheditorControl.js"></script>
	<script type="text/javascript" src="xheditor/xheditor-1.2.2.min.js"></script>
	<script type="text/javascript" src="xheditor/xheditor_lang/zh-cn.js"></script>
	
	<script type="text/javascript" src="js/manJs/TimeChooseControlForGeneral.js"></script>

	<script type="text/javascript" src="js/manJs/FormValidation/shareValidationJs.js"></script>
	<script type="text/javascript" src="js/manJs/FormValidation/GeneralFormValidation/Inf-FormValidation.js"></script>
	
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
	              <li class="active">发布推送</li>
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
	            <script type="text/javascript">
	            	$(function(){
	            		$("textarea").xheditor({tools:'full',
	            			width:800,
	            			height:300,
	            			html5Upload:false,
    						upImgUrl:"${basePath}/DR/admin/introduction/upLoadImage", //upLoadImageServlet
    						upImgExt:"jpg,jpeg,gif,png",
    						upMultiple:false,
    						uploadSize:"10024"
	            		});
	            		
	            	});
	            	
	            	var deleteTempImage = function(){
	            		//if($("textarea[name='content']").val().indexOf('temp')!=-1){
	            			$.post("admin/introduction/deleteTempImageForArticle",{},function(){})
	            		//}
	            	}
	            </script>
	            <form class="form-horizontal" action='admin/introduction/createArticle' enctype='multipart/form-data' method="post" id="pub-info-form">
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
		                     <input type="text" name='date' class="form-control timeChooser time">
		                  	 <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display: none;"></span>
		               	  	 <span style="color:red;"></span>			                     
		                </div>
		            </div>
		            <div class="form-group has-feedback speakerBar">
		                <label class="col-sm-2 control-label">发布人：</label>
		                <div class="col-sm-4">
		                  <input type="text" name='lanucher' class="form-control speaker" placeholder="请输入发布人姓名">
		                  <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display: none;"></span>
		               	  <span style="color:red;"></span>			                  
		                </div>
		            </div>
		         	<div class="form-group has-feedback desBar">
		                <label class="col-sm-2 control-label">其他描述：</label>
		                <div class="col-sm-8">
		                  <input type="text" name='description' class="form-control description" placeholder="如授权转载的文章">
		                  <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display: none;"></span>
		               	  <span style="color:red;"></span>			                
		                </div>
		            </div>
			 		<div class="form-group">
		                <label class="col-sm-2 control-label">推送内容：</label>
		                <div class="col-sm-8">
		                    <textarea name='content'>请输入推送内容</textarea>			                    
		                </div>
		             </div> 
		            <button class="btn btn-success col-sm-2 col-sm-offset-2 pub-inf-btn" type="button">提交</button>
		            <button class="btn btn-danger col-sm-2 col-sm-offset-2" type="reset" onclick='deleteTempImage();'>重置</button>    
	            </form>
            </div>
        </div>
      </div>
      <%@ include file="../manFooter.jsp" %>
    </div>
  </body>
 </html>