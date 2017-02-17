<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>在线报名</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1"><!--必须！！！-->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	
	<link rel="stylesheet" type="text/css" href="css/stuCss/headerCss.css">
	<link rel="stylesheet" type="text/css" href="css/stuCss/footerCss.css">
	<link rel="stylesheet" type="text/css" href="css/stuCss/examApplyCss.css">

    
	<link rel="stylesheet" type="text/css" href="css/sweet-alert.css">
	<link rel="shortcut icon" href="photos/DSlogo32.ico" />
		<script type="text/javascript">

		function myBrowser(){
		     var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
		     // alert(userAgent);
		    var isOpera = userAgent.indexOf("Opera") > -1; //判断是否Opera浏览器
		    var isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !isOpera; //判断是否IE浏览器
		    var isFF = userAgent.indexOf("Firefox") > -1; //判断是否Firefox浏览器
		    var isSafari = userAgent.indexOf("Safari") > -1; //判断是否Safari浏览器
		    if (isIE) {
		         var IE5 = IE55 = IE6 = IE7 = IE8 = false;
		         var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
		         reIE.test(userAgent);
		         var fIEVersion = parseFloat(RegExp["$1"]);
		         IE55 = fIEVersion == 5.5;
		         IE6 = fIEVersion == 6.0;
		         IE7 = fIEVersion == 7.0;
		         IE8 = fIEVersion == 8.0;
		         IE9 = fIEVersion == 9.0;
		         IE10 = fIEVersion == 10.0;
		         IE11 = fIEVersion == 11.0;
		
		         if (IE55) {
		             return "IE55";
		         }
		         if (IE6) {
		             return "IE6";
		         }
		         if (IE7) {
		             return "IE7";
		         }
		         if (IE8) {
		             return "IE8";
		         }
		         if (IE9) {
		             return "IE9";
		         }
		         if (IE10) {
		             return "IE10";
		         }
		         if (IE11) {
		             return "IE11";
		         }        
		     }//isIE end
		     if (isFF) {
		         return "FF";
		     }
		     if (isOpera) {
		         return "Opera";
		     }
		 }//myBrowser() end
		 //以下是调用上面的函数
		 var myB = myBrowser()
		 if (myB == "IE55"||myB == "IE6"||myB == "IE7"||myB == "IE8"||myB == "IE9"||myB == "IE10"||myB == "IE11") {
		     //sawl("浏览器不兼容","请使用360极速浏览器（极速模式），360安全浏览器，火狐浏览器，谷歌浏览器，safari进行浏览","error");
		 	alert("为了你的浏览体验，请使用360极速浏览器（极速模式），360安全浏览器，火狐浏览器，谷歌浏览器，safari进行浏览");
		 }
			
	</script>
  </head>
  
  <body id="body">
    <%@ include file="Header.jsp" %>
    <div class="container" style="min-height: 470px;margin-top: 20px;">
    	<div class="panel panel-default">

    		<div class="panel-heading">
    			<p class="panel-title">在线报名&nbsp;&nbsp;&nbsp;<small>考生信息填写</small></p>
    		</div>
    		<div class="panel-body">
                <!--表单开始！-->
                <form class="form-horizontal" method="post"  id="form">

                  <div class="form-group has-feedback">
                    <label class="col-sm-2 control-label" for="inputSuccessNumber"><span style="color:red;margin-right:2px;">*</span>学号：</label>
                    <div class="col-sm-4" id="numberDiv">
                      <input type="text" class="form-control" name="studentID" id="inputSuccessNumber" aria-describedby="inputSuccessState">
                      <!--data-toggle="tooltip" data-placement="bottom" data-original-title="此处不能为空"-->
                      <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display:none" id="numberspansuccess"></span>
                      <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="display:none" id="numberspanerror"></span>
                    </div>
                    <div class="col-sm-3" id="numberTip" display="none" style="color: #e4c12e;"></div>  
                  </div>

                <div class="form-group has-feedback">
                    <label class="col-sm-2 control-label" for="inputSuccessName"><span style="color:red;margin-right:2px;">*</span>姓名：</label>
                    <div class="col-sm-4" id="nameDiv">
                      <input type="text" class="form-control" name="name" id="inputSuccessName" aria-describedby="inputSuccessState">
                       <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display:none" id="namespansuccess"></span>
                      <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="display:none" id="namespanerror"></span>
                    </div>
                    <div class="col-sm-3" id="nameTip" display="none" style="color: #e4c12e;"></div>
                </div>

                <div class="form-group ">
                    <label class="col-sm-2 control-label"><span style="color:red;margin-right:2px;">*</span>性别：</label>
                    <div class="col-sm-4">
                        <label class="radio-inline">
                            <input type="radio" name="sex" id="inlineRadio1" value="男" checked>男
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="sex" id="inlineRadio2" value="女">女
                        </label>
                    </div>
                </div>

                <div class="form-group  has-feedback" >
                    <label class="col-sm-2 control-label" for="inputSuccessAcademy"><span style="color:red;margin-right:2px;">*</span>学院：</label>
                    <div class="col-sm-4" id="academyDiv">
                      <input type="text" class="form-control" name="academy" id="inputSuccessAcademy" aria-describedby="inputSuccessState">
                       <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display:none" id="academyspansuccess"></span>
                      <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="display:none" id="academyspanerror"></span>
                    </div>  
                    <div class="col-sm-3" id="academyTip" style="color: #e4c12e;"></div>   
                </div>

                <div class="form-group has-feedback">
                    <label class="col-sm-2 control-label" for="inputSuccessMajor"><span style="color:red;margin-right:2px;">*</span>专业：</label>
                    <div class="col-sm-4" id="majorDiv">
                      <input type="text" class="form-control" name="major" id="inputSuccessMajor" aria-describedby="inputSuccessState">
                       <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display:none" id="majorspansuccess"></span>
                      <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="display:none" id="majorspanerror"></span>
                    </div>
                    <div class="col-sm-3" id="majorTip" style="color: #e4c12e;"></div>
                </div>

                <div class="form-group  has-feedback" >
                    <label class="col-sm-2 control-label" for="inputSuccessClasses"><span style="color:red;margin-right:2px;">*</span>班级：</label>
                    <div class="col-sm-4" id="classesDiv">
                      <input type="text" class="form-control" name="grade" id="inputSuccessClasses" aria-describedby="inputSuccessState" placeholder="例如：计科1班">
                      <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display:none" id="classesspansuccess"></span>
                      <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="display:none" id="classesspanerror"></span>
                    </div>
                    <div class="col-sm-3" id="classesTip" style="color: #e4c12e;"></div>
                </div>

                <div class="form-group  has-feedback" >
                    <label class="col-sm-2 control-label" for="inputSuccessPosition">现任职务：</label>
                    <div class="col-sm-4" id="positionDiv">
                      <input type="text" class="form-control" name="job" id="inputSuccessPosition" aria-describedby="inputSuccessState">
                      <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display:none" id="positionspansuccess"></span>
                      <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="display:none" id="positionspanerror"></span>
                    </div>
                    <div class="col-sm-3" id="positionTip" style="color: #e4c12e;"></div>
                </div>

                <div class="form-group  has-feedback" >
                    <label class="col-sm-2 control-label" for="inputSuccessTel"><span style="color:red;margin-right:2px;">*</span>手机：</label>
                    <div class="col-sm-4" id="telDiv">
                      <input type="text" class="form-control" name="phoneNumber" id="inputSuccessTel" aria-describedby="inputSuccessState">
                      <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display:none" id="telspansuccess"></span>
                      <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="display:none" id="telspanerror"></span>
                    </div>
                    <div class="col-sm-3" id="telTip" style="color: #e4c12e;"></div>
                </div>

                <div class="form-group  has-feedback" >
                    <label class="col-sm-2 control-label" for="inputSuccessShortTel">短号：</label>
                    <div class="col-sm-4" id="shortTelDiv">
                      <input type="text" class="form-control" name="shortphoneNumber" id="inputSuccessShortTel" aria-describedby="inputSuccessState">
                      <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display:none" id="shortTelspansuccess"></span>
                      <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="display:none" id="shortTelspanerror"></span>
                    </div>
                    <div class="col-sm-3" id="shortTelTip" style="color: #e4c12e;"></div>
                </div>

                <div class="form-group  has-feedback">
                    <label class="col-sm-2 control-label" for="inputSuccessQQ"><span style="color:red;margin-right:2px;">*</span>QQ：</label>
                    <div class="col-sm-4" id="qqDiv">
                      <input type="text" class="form-control" name="QQ" id="inputSuccessQQ" aria-describedby="inputSuccessState">
                      <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display:none" id="qqspansuccess"></span>
                      <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="display:none" id="qqspanerror"></span>
                    </div>
                    <div class="col-sm-3" id="qqTip" style="color: #e4c12e;"></div>
                </div>

                <div class="form-group  has-feedback">
                    <label  class="col-sm-2 control-label" for="inputSuccessEmail">Email：</label>
                    <div class="col-sm-4" id="emailDiv">
                      <input type="text" class="form-control" name="email" placeholder="Email"  id="inputSuccessEmail" aria-describedby="inputSuccessState">
                      <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display:none;" id="emailspansuccess"></span>
                      <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="display:none" id="emailspanerror"></span>
                    </div>
                    <div class="col-sm-3" id="emailTip" style="color: #e4c12e;"></div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label"><span style="color:red;margin-right:2px;">*</span>意向：</label>
                    <div class="col-sm-8">
                        <label class="radio-inline">
                            <input type="radio" id="inlineradio1" value="数据挖掘" name="aspect" checked>数据挖掘
                        </label>
                        <label class="radio-inline">
                            <input type="radio" id="inlineradio2" value="编译器方向" name="aspect">编译器方向
                        </label>
                        <label class="radio-inline">
                            <input type="radio" id="inlineradio3" value="前端" name="aspect">前端
                        </label>
                        <label class="radio-inline">
                            <input type="radio" id="inlineradio4" value="后台" name="aspect">后台
                        </label>
                    </div>
                </div>

                <div class="form-group has-feedback">
                  <label class="col-sm-2 control-label" for="inputSuccessAbility"><span style="color:red;margin-right:2px;">*</span>个人技能经验：</label>
                  <div class="col-sm-8" id="abilityDiv">
                    <textarea class="form-control" id="inputSuccessAbility" rows="5" name="skills" style="resize:none" placeholder="不多于150字"></textarea>
                    <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display:none;" id="abilityspansuccess"></span>
                    <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="display:none" id="abilityspanerror"></span>
                  </div>
                  <div class="col-sm-2 col-sm-offset-2" id="abilityTip" style="color: #e4c12e;"></div>
                </div>

                <div class="form-group has-feedback">
                  <label class="col-sm-2 control-label" for="inputSuccessComment"><span style="color:red;margin-right:2px;">*</span>自我评价：</label>
                  <div class="col-sm-8" id="commentDiv">
                    <textarea class="form-control" id="inputSuccessComment" rows="5" name="selfevaluation" style="resize:none" placeholder="不多于150字"></textarea>
                    <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display:none;" id="commentspansuccess"></span>
                    <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="display:none" id="commentspanerror"></span>
                  </div>
                  <div class="col-sm-2 col-sm-offset-2" id="commentTip" style="color: #e4c12e;"></div>
                </div>

                <div class="form-group has-feedback">
                  <label class="col-sm-2 control-label" for="inputSuccessObject"><span style="color:red;margin-right:2px;">*</span>加入团队的目的及期望：</label>
                  <div class="col-sm-8" id="objectDiv">
                    <textarea class="form-control" id="inputSuccessObject" rows="5" name="hopes" style="resize:none" placeholder="不多于150字"></textarea>
                    <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="display:none;" id="objectspansuccess"></span>
                    <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true" style="display:none" id="objectspanerror"></span>
                  </div>
                  <div class="col-sm-2 col-sm-offset-2" id="objectTip" style="color: #e4c12e;"></div>
                </div>

                <input class="btn btn-primary col-sm-2 col-sm-offset-8" type="button" value="提交" id="submit">
                </form>
                <!--表单结束！-->
    		</div>

    		<div class="panel-footer" >
                <div class="row">
                    
                </div>
    		</div><!--面板页脚结束-->
            
    	</div><!--面板结束-->
    
    </div><!--container结束-->


    <%@ include file="Footer.jsp" %>
    
    <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/stuJs/FormCheck2.js"></script>
	<script type="text/javascript" src="js/sweet-alert.min.js"></script> 

  </body>

</html>
