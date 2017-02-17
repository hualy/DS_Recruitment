<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>DS工作室-管理员-增加试题</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/manCss/GeneralSituationCSS.css">
	<link rel="stylesheet" type="text/css" href="css/manCss/shareCss.css">
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css" >
	<link rel="stylesheet" type="text/css" href="css/manCss/ExamManageCss/AddExaminationCss.css">
	<link rel="stylesheet" type="text/css" href="css/sweet-alert.css">
	<link rel="shortcut icon" href="photos/DSlogo32.ico" />
	
	<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/sweet-alert.min.js"></script>	
		
	<script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="js/bootstrap-datetimepicker.fr.js"></script>
	<script type="text/javascript" src="js/manJs/shareJS.js"></script>
	
	<script type="text/javascript" src="js/manJs/ExamManageJs/AddExaminationJs.js"></script>
	<script type="text/javascript" src="js/bootstrapToolsJs/tooltip.js"></script>
	

	
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
	              <li>试题管理</li>
	              <li class="active">增加试题</li>
	            </ol>
	            <div class="container"><span class="col-sm-3">试题名称：<%= new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8") %></span><span class="col-sm-2">套题号：<%= request.getParameter("setID") %></span></div>
	            <div class="container">
	              <form class="form-horizontal" id="add-form">
	              
	              	<input type="hidden" name="name" value="<%= new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8") %>">	
	              	<input type="hidden" name="setID" value="<%= request.getParameter("setID") %>">	
	              
	            	<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
					  <div class="panel panel-default">
					    <div class="panel-heading" role="tab" id="headingOne" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
					      <h4 class="panel-title">
					        <a class="collapsed">
					         	 选择题 <input type="text" style="width:50px;margin-left:20px;border-radius:5px;" placeholder="分值" name="mscore">
					        </a>
					      </h4>
					    </div>
					    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel">
					      <div class="panel-body">
					       		<div class="container ChooseTopic">					       			
					       				<div class="container topic-piece">
						       				<div class="form-group">
											    <label class="col-sm-2 control-label">题目：</label>
											    <div class="col-sm-10">
											      <input type="text" class="form-control"  placeholder="请输入题目内容" name="mtitle">
											    </div>
										  	</div>
						       				<div class="form-group">
											    <label class="col-sm-2 control-label">选项A：</label>
											    <div class="col-sm-10">
											      <input type="text" class="form-control"  placeholder="请输入选项内容" name="optionA">
											    </div>
										  	</div>
						       				<div class="form-group">
											    <label class="col-sm-2 control-label">选项B：</label>
											    <div class="col-sm-10">
											      <input type="text" class="form-control"  placeholder="请输入选项内容" name="optionB">
											    </div>
										  	</div>
						       				<div class="form-group">
											    <label class="col-sm-2 control-label">选项C：</label>
											    <div class="col-sm-10">
											      <input type="text" class="form-control"  placeholder="请输入选项内容" name="optionC">
											    </div>
										  	</div>										  											  	
						       				<div class="form-group">
											    <label class="col-sm-2 control-label">选项D：</label>
											    <div class="col-sm-10">
											      <input type="text" class="form-control"  placeholder="请输入选项内容" name="optionD">
											    </div>
										  	</div>
										  	<div class="form-group">
										  		<label class="col-sm-2 control-label">正确选项:</label>
								                <span class="radio col-sm-1">
								                  <label>
								                    <input type="radio" name="rightAnswer0" value="A" checked="checked" class="Answer">
								                    	A
								                  </label>
								                </span>
								                <span class="radio col-sm-1">
								                  <label>
								                    <input type="radio" name="rightAnswer0" value="B" class="Answer">
								                    	B
								                  </label>
								                </span>
								                <span class="radio col-sm-1">
								                  <label>
								                    <input type="radio" name="rightAnswer0" value="C" class="Answer">
								                    	C
								                  </label>
								                </span>	
								                <span class="radio col-sm-1">
								                  <label>
								                    <input type="radio" name="rightAnswer0" value="D" class="Answer">
								                    	D
								                  </label>
								                </span>								                							                
										  	</div>
										  	<input type="hidden" value="A" name="mrightAnswer"/>
					       				</div>
					       				<div class="row operate-btn">
						       				<div class="col-sm-8 col-sm-offset-4 container">
							       				<button class="btn btn-success add-cho-btn col-sm-5" type="button">增加</button>
						       				</div>
						       			</div>
					       		</div>
					      </div>
					    </div>
					  </div>
					  <div class="panel panel-default">
					    <div class="panel-heading" role="tab" id="headingTwo"  data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
					      <h4 class="panel-title">
					        <a class="collapsed">
					       	  填空题<input type="text" style="width:50px;margin-left:20px;border-radius:5px;" placeholder="分值" name="fscore">
					        </a>
					      </h4>
					    </div>
					    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" >
					      <div class="panel-body">
					      	<div class="container col-sm-11 add-fill-bar">	
					       			<div class="container topic-piece" id="location0">
						       			<div class="form-group">
										    <label class="col-sm-2 control-label">题目：</label>
										    <div class="col-sm-10 cont">
											    <div class="input-group">
											      <input type="text" name="ftitle" class="form-control fill-input"  placeholder='请输入题目内容         请用   "_"  代替空格输入' data-toggle="tooltip" data-placement="top" title="用下划线替代填空题的空格。示例：前端主要学_语言、_语言。注意：下划线需为英文输入">
											      <span class="input-group-btn">
											        <button class="btn btn-default fill-ans-btn" type="button" data-toggle="tooltip" data-placement="top" title="一旦生成，将无法修改题目" location="0">
											        	生成答案域</button>
											      </span>
											    </div>
										    </div>
										</div>
										<input type="hidden" value="0" name="frightAnswernums" id="frightAnswer0"/>
					       			</div>
					       			<div class="row operate-btn">
						       			<div class="col-sm-3 col-sm-offset-4 container">
							       			<button class="btn btn-success add-fill-btn col-sm-12" type="button">增加</button>
						       			</div>
						       		</div>
					      	</div>
					      </div>
					    </div>
					  </div>
					  <div class="panel panel-default">
					    <div class="panel-heading" role="tab" id="headingThree" data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
					      <h4 class="panel-title">
					        <a class="collapsed">
					          	程序题<input type="text" style="width:50px;margin-left:20px;border-radius:5px;" placeholder="分值" name="pscore">
					        </a>
					      </h4>
					    </div>
					    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel">
					      <div class="panel-body">
					      	<div class="container col-sm-11">	
					       			<div class="container topic-piece">
						       			<div class="form-group">
										    <label class="col-sm-2 control-label">题目：</label>
										    <div class="col-sm-10">
										      <input type="text" class="form-control"  placeholder="请输入题目内容" name="ptitle">
										    </div>
										</div>
					       			</div>
					       			<div class="row operate-btn">
						       			<div class="col-sm-3 col-sm-offset-4 container">
							       			<button class="btn btn-success add-pro-btn col-sm-12" type="button">增加</button>
						       			</div>
						       		</div>
					      	</div>
					      </div>
					    </div>
					  </div>
					</div>
					<button class="btn btn-default col-sm-3 col-sm-offset-4" type="submit" id="submit">提交</button>
				  </form>
	            </div>
			</div>
    	</div>
      </div>
      <%@ include file="../manFooter.jsp" %>
    </div>
  </body>
</html>




