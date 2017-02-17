<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>DS工作室-管理员-登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/manCss/shareCss.css">
	<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	
	<script src="js/sweet-alert.min.js"></script> 
	<link rel="stylesheet" type="text/css" href="css/sweet-alert.css">
	<link rel="shortcut icon" href="photos/DSlogo32.ico" />
	
	<style type="text/css">
		.loginForm{
			border: 1px solid #ccc;
			padding: 20px;
			margin-top: 50px;
			border-radius: 25px;
		}
		/*#main{
			background-image:url("photos/manImg/login-background.png");
			height:100%;
		}*/
	</style>
	
	<script type="text/javascript">
	
		$(function(){
		
			$("#submit").click(function(){		
				$.ajax({
					type: "POST",
					url: "userInfo/adminLoginAction",
					dataType: "html",
					data:$("#form").serialize(),   				//将表单的数据以json形式提交
					success:function(result){
						
						if(result == "success"){				
							swal({
								title: "登录成功",   
							    text: "DS欢迎您！",   
							    type: "success",   
							    confirmButtonColor: "#DD6B55",   
							    confirmButtonText: "确认",   
							    closeOnConfirm: false
							    },
							    
							    function(){
							    	window.location.href = "manPage/indexManager.jsp";
							    }
							);
							
						}else{
							sweetAlert("密码不正确", "该用户不存在，请重新输入！", "error");
							$("#UserName").val("");
							$("#password").val("");
							$("#UserName").focus();
						}
					}
				});
				
				return false;									//防止页面自动跳转
			});
			
		});	
	
	</script>
	
	
  </head>
  <body>
	 		<!--page header -->
    <div class="all">  
        <div class="content">  
	        <div class="page-header container">
	          <div class="headline">
	            <span><img src="photos/manImg/logo.png" /></span>
	            <span><h1>DS WORKSHOP---MANAGER</h1></span>
	          </div>
	          <div class="clearFloat"></div>
	        </div>
        	<!--page header -->
        	<div class="container-fluid" id = "main">
        		<div class="loginForm col-sm-4 col-sm-offset-4">
	        		<form class="form-horizontal" method="post"  id="form">
	        			<div class="form-group">
	        				<label for="UserName" class="control-label col-sm-4">用户名：</label>
	        				<div class="col-sm-8">
	        					<input type="text" class="form-control" id="UserName" placeholder="username" name="username">
	        				</div>
	        			</div>
	
	        			<div class="form-group">
	        				<label class="control-label col-sm-4" for="password">密码：</label>
	        				<div class="col-sm-8">
		        				<input type="password" placeholder="password" class="form-control" id="password" name="password"/>
		        			</div>
	        			</div>
	
	        			<button class="btn btn-success col-sm-4 col-sm-offset-2" type="submit" id="submit">登陆</button>
	        			<button class="btn btn-default col-sm-3 col-sm-offset-1" type="reset">重置</button>
	        		</form>
        		</div>
        	</div>
        </div> 
        <div class="footer">
            <div class="container-fluid">
                <p class="foot-word">DS工作室 工一616</p>
                <p class="foot-word">联系方式 QQ群:xxxxxxxxxx</p>
             </div>
        </div>
    </div>  
  </body>
 </html>