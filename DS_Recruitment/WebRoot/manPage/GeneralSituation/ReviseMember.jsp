<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>DS工作室-管理员-修改成员</title>
    
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
	<script type="text/javascript" src="js/sweet-alert.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/sweet-alert.css">	
	
	<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	
	<script type="text/javascript" src="js/ajaxfileupload.js"></script>
	
	<script type="text/javascript" src="js/manJs/GeneralSituaionJs/ReviseMemberJs.js"></script>
		
	<script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="js/bootstrap-datetimepicker.fr.js"></script>
	<script type="text/javascript" src="js/manJs/shareJS.js"></script>
	
	<script type="text/javascript" src="js/manJs/FormValidation/shareValidationJs.js"></script>	
	<script type="text/javascript" src="js/manJs/FormValidation/GeneralFormValidation/Mem-FormValidation.js"></script>
  	
	
  </head>
  <body>
  	 <!--page header -->
    <div class="all">
      <div class="content">
        <%@ include file="../manHeader.jsp" %>
        <!-- navigation bar -->
        <div class="mainContent">
			<!--修改成员页面-->
          <div class="container rev-member">
            <ol class="breadcrumb">
                <li>首页</li>
                <li>概况管理</li>
                <li class="active">修改成员展示</li>
            </ol>
            <div class="exist-mem container">
              <table class="table table-striped">
                <tr id="trRevise" class="info"><td>姓名</td><td>年级</td><td>班别</td><td>操作</td></tr>
                
                <!-- 
                <%for(int i=0;i<9;i++){ %>
                <tr><td>xxxx</td><td>2014</td><td>8</td>
                  <td>
                    <button class="btn btn-default">修改</button>
                    <button class="btn btn-danger">删除</button>
                  </td>
                </tr>
                <%} %>
                 -->
              </table>
            </div>
            
            <script type="text/javascript">
            
             var loadPictureFunction = function(){
            	if($("#upLoadFileId").val()!=""){
            		$.ajaxFileUpload({
            			url:'admin/introduction/upLoadMemberImage',
            			secureuri:false,
            			fileElementId:'upLoadFileId',
            			dataType:'json',
            			success:function(data,status){
            				//alert('right');
            				//alert(data.imagePath);
            				$("form img").attr("src", data.imagePath);
            				$("form input[type='hidden'][name='imagePath']").attr("value", data.imagePath);
            			},
            			error:function(data,status,e){
            				alert("upload fail");
            				alert(e);
            			}
            		});
            	}
            	$("form input[type='hidden']").attr("value",$("form input[type='hidden']").attr("value"));
            	
            }
             
              var deleteTempImage = function(){
	            		//if($("textarea[name='content']").val().indexOf('temp')!=-1){
	            			$.post("admin/introduction/deleteTempImageForMember",{},function(){})
	            		//}
	           }
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
            
            <div class="revise-mem container">

             <form id="rev-mem-form" class="form-horizontal" action="admin/introduction/updateMember" method="post">
              <div class="form-group has-feedback nameBar">
                <label for="name" class="col-sm-2 control-label">姓名：</label>
                <div class="col-sm-4">
                  <input type="text" name='name' class="form-control" id="name" placeholder="请输入姓名">
                  <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display: none;"></span>
               	  <span style="color:red;"></span>
                </div>
              </div>
              <div class="form-group">
                <label for="name" class="col-sm-2 control-label">方向：</label>
                <div class="col-sm-4">
                  	<select class="form-control" name="majorOnDs">
					  <option value="2">前端</option>
					  <option value="3">后台</option>
					  <option value="1">编译器</option>
					  <option value="0" selected>数据挖掘</option>
					</select>
                </div>
              </div>    
              <div class="form-group">
                <label for="name" class="col-sm-2 control-label">专业：</label>
                <div class="col-sm-4">
                    <select class="form-control" name="major">
					  <option value="软件工程">软件工程</option>
					  <option value="网络工程">网络工程</option>
					  <option value="计算机科学与技术">计算机科学与技术</option>
					</select>
                </div>
              </div> 
              <div class="form-group">
                <label class="col-sm-2 control-label">性别：</label>
                <span class="radio col-sm-2">
                  <label>
                    <input type="radio" name="female"  value="false" checked>
                    	男
                  </label>
                </span>
                <span class="radio col-sm-2">
                  <label>
                    <input type="radio" name="female" value="true">
                    	女
                  </label>
                </span>
              </div>                 
                <div class="form-group">
                  <label class="col-sm-2 control-label">年级：</label>
                  <div class="col-sm-2">
                    <select class="form-control" name='grade'>
	                    <%for(int i = 2005;i<=2015;i++){ %>
	                  		<option value=<%=i %>><%=i %></option>
	                  	<%} %>
                    </select>
                  </div>
                  <label class="col-sm-1 control-label">班别：</label>
                  <div class="col-sm-2">                  
                    <select class="form-control" name='cla'>
	                  	<%for(int i = 1;i<=10;i++){ %> 
	                    	<option value=<%=i %>><%=i %></option>
	                    <%} %>
                    </select>
                  </div>
                </div>
              <div class="form-group has-feedback intBar">
                <label class="col-sm-2 control-label">介绍：</label>
                <div class="col-sm-5">
                  <textarea class="form-control" name="description" id="introduce" rows="4"></textarea>
                  <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display: none;"></span>
                  <span style="color:red;"></span>
                </div>
              </div>
              <div class="form-group has-feedback desBar">
                <label class="col-sm-2 control-label" >留言：</label>
                <div class="col-sm-5">
                  <textarea class="form-control" name='leavingWord' id="describe" rows="4"></textarea>
                  <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display: none;"></span>
                  <span style="color:red;"></span>                  
                </div>
              </div> 
                <div class="form-group imgBar has-feedback">
                  <label class="col-sm-2 control-label">图片：</label>
                  <div class="col-sm-2">
                    <input type="file" name='file' onchange="loadPictureFunction();" id='upLoadFileId' class="form-control">
	                <span class="logo glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display: none;"></span>
	                <span style="color:red;"></span>                   
                  </div>
                  <div class="col-sm-3">
                  <img class="mem-photo" alt="图片预览" style="width: 80%;height:40%;border:1px solid grey;">
                  <input type='hidden' name="imagePath"/>
                  </div>
                </div>   
                <button class="btn btn-success col-sm-2 col-sm-offset-2 rev-mem-btn" type="button">保存修改</button>
                <button class="btn btn-danger col-sm-2 col-sm-offset-2 cancel-btn" type="button" onclick='deleteTempImage();'>放弃修改</button>
                <input type="hidden" name='memberId'>
              </form>
            </div>
          </div> 
          <!--修改成员页面-->
        </div>
      </div>
      <%@ include file="../manFooter.jsp" %>
    </div>
	
  </body>
 </html>