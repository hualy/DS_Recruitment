<%@ page language="java" import="com.gdut.ds.beans.examination.*,java.util.*" pageEncoding="UTF-8"%>
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
	<link rel="shortcut icon" href="photos/DSlogo32.ico" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css" >
	<link rel="stylesheet" type="text/css" href="css/manCss/ExamManageCss/ReviseExaminationCss.css">

	
	<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
		
	<script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="js/bootstrap-datetimepicker.fr.js"></script>
	<script type="text/javascript" src="js/manJs/shareJS.js"></script>
	
	<script type="text/javascript" src="js/manJs/ExamManageJs/ReviseExaminationJs.js"></script>
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
	              <li class="active">试题修改</li>
	            </ol>
	            
	            <% 
	            	ExaminationQuestions examQuestions = (ExaminationQuestions)request.getAttribute("examQuestions"); 
	            	List<MultipleChoice> mList = examQuestions.getMultipleChoiceList();
	            	List<FillInTheBlank> fList = examQuestions.getFillInTheBlankList();
	            	List<ProceduralQuestions> pList = examQuestions.getProceduralQuestionsList();
	            %>
	            
	            <div class="container">
	              <table class="table table-striped" style="text-align:center">
	                <tr class="info">
	                	<td class="col-sm-2">题目</td><td class="col-sm-2">选择</td>
	                	<td class="col-sm-2">填空</td><td class="col-sm-2">程序</td><td class="col-sm-4">操作</td>
	                </tr>
	                <tr class="success">
	                	<td class="col-sm-2">分值</td>
	                	<td class="col-sm-2"><input class="score-input" type="text" name="score" style="width:50px;border-radius:5px;" value="<%= examQuestions.getMscore() %>" disabled></td>
	                	<td class="col-sm-2"><input class="score-input" type="text" name="fscore" style="width:50px;border-radius:5px;" value="<%= examQuestions.getFscore() %>" disabled></td>
	                	<td class="col-sm-2"><input class="score-input" type="text" name="pscore" style="width:50px;border-radius:5px;" value="<%= examQuestions.getPscore() %>" disabled></td>
	                	<td class="col-sm-4">
	                		<button type="button" class="btn btn-default score-rev-btn">修改</button>
	                		<button type="button" class="btn btn-defalut score-rev-cancel-btn" style="display:none;">取消修改</button>
	                	</td>
	                </tr>
	              </table>	
	            </div>            
	            <div class="form-horizontal">
	            <div class="container">
	            	<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
					  <div class="panel panel-default">
					    <div class="panel-heading" role="tab" id="headingOne" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
					      <h4 class="panel-title">
					        <a class="collapsed">
					         	 选择题 （5分）
					        </a>
					      </h4>
					    </div>
					    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel">
					      <div class="panel-body">
					       		<div class="container ChooseTopic">
					       			<%for(int i=0;i < mList.size();i++){ %>
					       				<div class="container topic-piece">
						       				<div class="row topic">
						       					<label class="control-label col-sm-1">题目.</label>
						       					<div class="col-sm-11 rev-input">
						       						<input class="form-control" type="text" name="mtitle" value="<%= mList.get(i).getTitle() %>" />
						       					</div>
						       				</div>
						       				<div class="row answer">
						       					<label class="control-label col-sm-1">A.</label>
						       					<div class="col-sm-7 rev-input">
						       						<input class="form-control" type="text" name="optionA" value="<%= mList.get(i).getOptionA()%>"/>
						       					</div>
											</div>
						       				<div class="row answer">
						       					<label class="control-label col-sm-1">B.</label>
						       					<div class="col-sm-7 rev-input">
						       						<input class="form-control" type="text" name="optionB" value="<%= mList.get(i).getOptionB() %>"/>
						       					</div>
											</div>											
						       				<div class="row answer">
						       					<label class="control-label col-sm-1">C.</label>
						       					<div class="col-sm-7 rev-input">
						       						<input class="form-control" type="text" name="optionC" value="<%= mList.get(i).getOptionC() %>"/>
						       					</div>
											</div>
						       				<div class="row answer">
						       					<label class="control-label col-sm-1">D.</label>
						       					<div class="col-sm-7 rev-input">
						       						<input class="form-control" type="text" name="optionD" value="<%= mList.get(i).getOptionD() %>"/>
						       					</div>
											</div>
						       				<div class="row answer">
						       					<label class="control-label col-sm-3">正确答案：</label>
						       					<div class="col-sm-4 rev-input">
						       						<input class="form-control" type="text" name="mrightAnswer" placeholder="A/B/C/D" value="<%= mList.get(i).getRightAnswer() %>"/>
						       					</div>
											</div>
						       				<div class="row operate-btn" style="text-align:center;margin-top:10px;">
						       					<span style="margin:auto;">
							       					<button class="btn btn-default rev-cho-btn" type="button">修改</button>
							       					<button class="btn btn-success sure-rev-btn" type="button" location="<%= mList.get(i).getId() %>">确认修改</button>
							       					<button class="btn btn-danger del-btn" type="button" location="<%= mList.get(i).getId() %>">删除</button>
							       					<button class="btn btn-default cancel-btn" type="button" style="display:none;">取消修改</button>
						       					</span>
						       				</div>
					       				</div>
					       			<%} %>
					       			<!-- <form class="form-horizontal"> -->
					       				<div class="container topic-piece add-topic">
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
								                    <input type="radio" name="optionsRadios0" value="A" checked>
								                    	A
								                  </label>
								                </span>
								                <span class="radio col-sm-1">
								                  <label>
								                    <input type="radio" name="optionsRadios0" value="B">
								                    	B
								                  </label>
								                </span>
								                <span class="radio col-sm-1">
								                  <label>
								                    <input type="radio" name="optionsRadios0" value="C">
								                    	C
								                  </label>
								                </span>	
								                <span class="radio col-sm-1">
								                  <label>
								                    <input type="radio" name="optionsRadios0" value="D">
								                    	D
								                  </label>
								                </span>								                							                
										  	</div>
										  	<input type="hidden" value="A" name="mrightAnswer"/>
					       				</div>
						       			<div class="row operate-btn">
							       			<div class="col-sm-8 col-sm-offset-4">
								       			<button class="btn btn-success add-cho-btn" type="button">增加</button>
								       			<button class="btn btn-success" type="button">提交新增的选择题</button>
							       			</div>
						       			</div>
					       			<!-- </form> -->
					      		
					       			
					       		</div>
					      </div>
					    </div>
					  </div>
					  <div class="panel panel-default">
					    <div class="panel-heading" role="tab" id="headingTwo"  data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
					      <h4 class="panel-title">
					        <a class="collapsed">
					       	  填空题 （5分）
					        </a>
					      </h4>
					    </div>
					    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" >
					      <div class="panel-body">
					      	<div class="container">	
					      		<%for(int i=0; i< fList.size();i++){ %>	
					      			<div class="topic-piece container">		      		
						      			<div class="row topic">
						       				<label class="control-label col-sm-1">题目.</label>
						       				<div class="col-sm-11 rev-input">
						       					<input class="form-control" type="text" value="<%= fList.get(i).getTitle() %>"/>
						       				</div>
						       			</div>
						       			<% String[] answer = fList.get(i).getReal(); %>
						       			
						       			<%for(int j=0; j< answer.length;j++){ %>
						       			<div class="row answer">
						       				<label class="control-label col-sm-1">答案<%= j %>.</label>
						       				<div class="col-sm-7 rev-input">
						       					<input class="form-control" type="text" value="<%= answer[j] %>"/>
						       				</div>
										</div>
										<%} %>						       			
						       			
						      			<div class="row operate-btn" style="text-align:center;margin-top:10px;">
						      				<span style="margin:auto;">
								       			<button class="btn btn-default rev-fill-btn" type="button">修改</button>
								       			<button class="btn btn-success sure-rev-btn" type="button" location="<%= fList.get(i).getId() %>">确认修改</button>
								       			<button class="btn btn-danger del-btn" type="button" location="<%= fList.get(i).getId() %>">删除</button>	
							       			</span>				      			
						      			</div>
						      			<input type="hidden" value="<%=0 %>" name="frightAnswer"/><!-- 在这填上答案个数 -->
					      			</div>	
					      		<%} %>
					      		<!-- <form class="form-horizontal"> -->
						      		<div class="container-fluid add-fill-bar">
						       			<div class="container topic-piece" id="location0">
							       			<div class="form-group">
											    <label class="col-sm-2 control-label">题目：</label>
											    <div class="col-sm-10 cont">
												    <div class="input-group">
												      <input type="text" name="ptitle" class="form-control fill-input"  placeholder='请输入题目内容         请用   "_"  代替空格输入' data-toggle="tooltip" data-placement="top" title="用下划线替代填空题的空格。示例：前端主要学_语言、_语言。注意：下划线需为英文输入">
												      <span class="input-group-btn">
												        <button class="btn btn-default fill-ans-btn" type="button" data-toggle="tooltip" data-placement="top" title="一旦生成，将无法修改题目" location="0">生成答案域</button>
												      </span>
												    </div>
											    </div>
											</div>
											<input type="hidden" value="0" name="frightAnswer" id="frightAnswer0"/>
						       			</div>
							       		<div class="row operate-btn">
							       			<div class="col-sm-3 col-sm-offset-4">
								       			<button class="btn btn-success add-fill-btn" type="button">增加</button>
								       			<button class="btn btn-success" type="button">提交新增的填空题</button>
							       			</div>
							       		</div>
						       		</div>
					       			
					       		<!-- </form> -->
					      	</div>
					      </div>
					    </div>
					  </div>
					  <div class="panel panel-default">
					    <div class="panel-heading" role="tab" id="headingThree" data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
					      <h4 class="panel-title">
					        <a class="collapsed">
					          	程序题  （15分）
					        </a>
					      </h4>
					    </div>
					    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel">
					      <div class="panel-body">
					      	<div class="container">	
					      		<%for(int i=0; i<pList.size();i++){ %>	
					      			<div class="topic-piece container">		      		
						      			<div class="row topic">
						       				<label class="control-label col-sm-1">题目.</label>
						       				<div class="col-sm-11 rev-input">
						       					<input class="form-control" type="text" value="<%= pList.get(i).getTitle() %>"/>
						       				</div>
						       			</div>
						      			<div class="row operate-btn" style="text-align:center;margin-top:10px;">
						      				<span style="margin:auto;">
								       			<button class="btn btn-default rev-pro-btn" type="button">修改</button>
								       			<button class="btn btn-success sure-rev-btn" type="button" location="<%= pList.get(i).getId() %>">确认修改</button>
								       			<button class="btn btn-danger del-btn" type="button" location="<%=  pList.get(i).getId() %>">删除</button>	
							       			</span>				      			
						      			</div>
					      			</div>	
					      		<%} %>
					      		<!-- <form class="form-horizontal">-->
					       			<div class="container topic-piece">
						       			<div class="form-group">
										    <label class="col-sm-2 control-label">题目：</label>
										    <div class="col-sm-10">
										      <input type="text" name="ptitle" class="form-control"  placeholder="请输入题目内容">
										    </div>
										</div>
					       			</div>
						       		<div class="row operate-btn">
							       		<div class="col-sm-3 col-sm-offset-4">
								       		<button class="btn btn-success add-pro-btn" type="button">增加</button>
								       		<button class="btn btn-success" type="button">提交新增的程序题</button>
							       		</div>
							       	</div>					       			
					       		<!-- </form> -->
					      	</div>
					      </div>
					    </div>
					  </div>
					</div>
	            </div>
	            </div>
			</div>
    	</div>
      </div>
      <%@ include file="../manFooter.jsp" %>
    </div>
  </body>
</html>




