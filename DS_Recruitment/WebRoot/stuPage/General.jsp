<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>DS工作室概况</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	
	<link rel="stylesheet" type="text/css" href="css/stuCss/headerCss.css">
	<link rel="stylesheet" type="text/css" href="css/stuCss/footerCss.css">
	<link rel="stylesheet" type="text/css" href="css/stuCss/generalCss.css">
	<link rel="shortcut icon" href="photos/DSlogo32.ico" />
  <link rel="stylesheet" type="text/css" href="css/stuCss/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="css/stuCss/stylesCode.css">
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

  <div class="container theTwo" style="min-height: 470px;margin-top: 20px;">
    
    <div class="panel panel-default">
        <div class="panel-heading theOne">
          <p class="panel-title">关于我们</p>
        </div>
        <div class="panel-body">
          <p style="text-indent: 2em">“数据结构与可视计算工作室”，简称“DS工作室”，是广东工业大学计算机学院计算机科学系下设的学生科技创新团队，成立于2010年10月,指导老师为李杨老师、吴伟民副院长和谢光强副教授。工作室的主要研究领域为：Java Web开发、在线可视化C编译器、数据挖掘。工作室具有良好的实验室环境、团结进取的团队文化、优秀的师资。工作室非常重视成员综合素质的培养，不仅包括技术方面，还包括团队协作、奉献精神、吃苦精神等非技术方面。工作室为了锻炼成员的沟通表达能力，促进技术交流，还制订了每周一次的技术交流会制度，至今已举办了100多次。为增强团队凝聚力和锻炼身体，工作室还举行每周一次的文体活动和每年一次的团队周年纪念活动。团队成立至今，先后申报大学生创业创新项目4项，大学生创新科技立项4项，申请软件著作权2项，其中1项获得第五届“挑战杯”广东工业大学课外学术科技作品竞赛三等奖，1项获2012年省级大学生创新创业训练计划立项。</p>
        </div>
    </div>
    
    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">

  <div class="panel panel-default" id="the1" >
    <div class="panel-heading" role="tab" id="headingOne" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
      <h4 class="panel-title">
      	<!-- aria-expanded="true"默认打开	aria-controls的值指向其内容的id值 -->
        <a>
          方向简介
        </a>
      </h4>
    </div>
    <!--此div的id值为aria-controls的值		.collapse 隐藏内容		.collapse.in 显示内容-->
    <div id="collapseOne" class="panel-collapse collapse " role="tabpanel" aria-labelledby="headingOne">
      <div class="panel-body">
       
       <!-- 模态框例子--> 
       <!--	-->
        <div class="row"><!--第一行-->
        	<div class="col-md-6 col-sm-9 item" style="cursor: pointer;">
        		<div class="thumbnail btn01"  onclick="$('#myModalOne').modal('show');">
        			<img src="photos/stuImg/pic1.jpg" alt="数据挖掘">
              <div class="ovrly"></div>

              <div class="buttons" style="color:#fff;font-size: 20px;">
                <strong>点击查看更多</strong>
              </div>
        			<div class="caption" style="text-align: center;" >
        				<h3>数据挖掘组</h3>

                <!--
        				<p>...</p>
        				<p>
                  
        					<button type="button" class="btn btn-primary btn-lg">
       							更多
       						</button>
                  
        				</p>

                -->
        			</div>
        		</div>
        		<!-- Modal -->
       						<!-- 务必为 .modal 添加 role="dialog" 属性，
       									aria-labelledby="myModalLabel" 属性用于只想模态框的标题栏，
       									aria-hidden="true" 用于通知辅助性工具略过模态框的 DOM元素。
       									aria-describedby 属性为模态框 
       									.modal 添加描述性信息。
       									.fade 为淡入淡出效果！-->
       						<div class="modal fade bs-example-modal-lg" id="myModalOne" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
       							<!--modal-lg大的对话框 -->
       							<div class="modal-dialog modal-lg">
       								<div class="modal-content">
       									<div class="modal-header">
       										<!-- 关闭按钮-->
       										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
       										<h4 class="modal-title" id="myModalLabel" style="color: #000">数据挖掘组</h4>
       									</div>
       									<div class="modal-body" style="text-align: left">
       										<h4>简介</h4>
       										<p style="color:black;">2020年全球数据总量将超40ZB，DT时代已经来临。不难发现，在未来对于大数据的探索和处理也显得日益重要。为了顺应未来的发展，同时也是兴趣的驱使，数据挖掘组自2014年建立，从此开始茁壮发展。数据挖掘是通过统计学、机器学习和数据处理等领域的思想，旨从大量的数据中通过算法探索隐藏于其中信息的过程。目前在工作室的主要任务，便是参加数据挖掘类比赛，以及参与《验证码自动识别》、《代码抄袭检测》等项目。
	对于数据挖掘的学习，首先 大学的数学课程需打好基础，如：高等数学、线性代数、概率论；
其次，计算机编程能力需实践熟练：编程语言除C要打好基础以外，其他如Java、Python、R等语言也要学会快速上手的技巧；而编程思想则需学习好数据结构、算法设计等课程；最后.数据挖掘相关知识的学习：如数据库技术、机器学习算法、统计学习模型等;还有数据挖掘工具的练手实践。
	除此之外，良好的数学思维、敏捷的算法能力、不倦的探索动力，另外还有团队合作的默契也是必不可少的。</p>
       									</div>
       									<div class="modal-footer">
       										<button type="button" class="btn btn-primary" data-dismiss="modal" aria-label="Close">Close</button>
       									</div>
       								</div>
       							</div>
       						</div>
        			
        	</div>
        	<div class="col-md-6 col-sm-9 item" style="cursor: pointer;">
        			
        		<div class="thumbnail btn01"  data-toggle="modal" data-target="#myModalTwo">
        			<img src="photos/stuImg/pic2.jpg" alt="编译器">
              <div class="ovrly"></div>

              <div class="buttons" style="color:#fff;font-size: 20px;">
                <strong>点击查看更多</strong>
              </div>
        			<div class="caption" style="text-align: center;">
        				<h3>编译器组</h3>
                <!--
        				<p>...</p>
        				<p>

        					<button type="button" class="btn btn-primary btn-lg">
       							更多
       						</button>
        				</p>
                -->
        			</div>
        		</div>
        		       						<!-- Modal -->
       						<div class="modal fade bs-example-modal-lg" id="myModalTwo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
       							<div class="modal-dialog modal-lg">
       								<div class="modal-content">
       									<div class="modal-header">
       										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
       										<h4 class="modal-title" id="myModalLabel" style="color: #000">编译器组</h4>
       									</div>
       									<div class="modal-body" style="text-align: left">
       										<h4>简介</h4>
       										<p style="color:black;">据说世界上第一个编译程序出现在20世纪50年代。当时所谓的程序只是一大串机械码，后来发展出了汇编。但编程还是一件无比艰难的事情，因此当时能从事与计算机相关的工作的人少之又少。而编译器的出现降低了对程序员的要求,各种经典的高级编程语言相继出现，使计算机行业得到迅速发展，进入了新时代。
工作室的第一代师兄们自己开发了一个编译器，从此编译器组成立，本组的方向名也以编译器命名。
团队主要进行对编译器的研究和开发，了解程序从高级语言编写的源代码到低级机械码的转化过程和优化过程。现在本方向的主要项目是网页版anyview、和代码抄袭检测系统。
从事这方面的研究需要学习的主要知识点有：编译原理、数据结构、操作系统、计算机组成原理、离散数学、SQL、java EE、java WEB等。
这要求团队成员有扎实的编程基础、良好的抽象思维、很强的学习能力和团队合作能力。</p>
       									</div>
       									<div class="modal-footer">
       										<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
       									</div>
       								</div>
       							</div>
       						</div>
        	</div>
        </div>

       	<div class="row"><!--第二行-->
       		<div class="col-md-6 col-sm-9 item" style="cursor: pointer;">
        			
       			<div class="thumbnail btn01"  data-toggle="modal" data-target="#myModalThree">
       				<img src="photos/stuImg/pic3.jpg" alt="前端">
              <div class="ovrly"></div>

              <div class="buttons" style="color:#fff;font-size: 20px;">
                <strong>点击查看更多</strong>
              </div>
       				<div class="caption" style="text-align: center;">
       					<h3>前端组</h3>
                <!--
       					<p>...</p>
       					<p>

       						<button type="button" class="btn btn-primary btn-lg">
       							更多
       						</button>
       					</p>
                -->
       				</div>
       			</div>
       			       						<!-- Modal -->
       						<div class="modal fade bs-example-modal-lg" id="myModalThree" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
       							<div class="modal-dialog modal-lg">
       								<div class="modal-content">
       									<div class="modal-header">
       										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
       										<h4 class="modal-title" id="myModalLabel" style="color: #000">前端组</h4>
       									</div>
       									<div class="modal-body" style="text-align: left">
       										<h4>简介</h4>
       										<p style="color:black;">	自从互联网出现以来，人们对网络的依赖呈指数上涨。发展至今，几乎每个企业，每个单位，甚至每个人都拥有属于自己的网站，促使了网站制作技术的快速发展。前端是用户与网站最直接的接触，是一个网站对外的窗户。因此，我们前端致力于给用户带来网页视觉冲击，打造用户体验更优的网站，呈现更好的网页交互。
	前端方向自从成立至今茁壮成长，主要以做项目和打比赛为主，如学院的数据结构的mooc平台、考试问答系统、工作室网站等项目、“共享杯”国家总平台的比赛等。加入我们，让你的创意奔跑起来，做出各种绚烂的网页！前端需要学习以下知识：
		1.HTML ：HTML的主要常用标签并利用HTML知识写出简单的页面,如表单之类的
		2.CSS：学习CSS知识对样式进行优化，以及理解布局概念。
		3.Javascript：学习脚本程序，为页面上的元素注册事件，让你的页面活泼起来。</p>
       									</div>
       									<div class="modal-footer">
       										<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
       										
       									</div>
       								</div>
       							</div>
       						</div>
        	</div>

        	<div class="col-md-6 col-sm-9 item" style="cursor: pointer;">
        			
        		<div class="thumbnail btn01" data-toggle="modal" data-target="#myModalFour">
        			<img src="photos/stuImg/pic4.jpg" alt="后台">
              <div class="ovrly"></div>

              <div class="buttons" style="color:#fff;font-size: 20px;">
                <strong>点击查看更多</strong>
              </div>
        			<div class="caption" style="text-align: center;">
        				<h3>后台组</h3>
                <!--
        				<p>...</p>
        				<p>
        					<button type="button" class="btn btn-primary btn-lg" >
       							更多
       						</button>
        				</p>
                -->
        			</div>
        		</div>
        		<!-- Modal -->
       						<div class="modal fade bs-example-modal-lg" id="myModalFour" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
       							<div class="modal-dialog modal-lg">
       								<div class="modal-content">
       									<div class="modal-header">
       										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
       										<h4 class="modal-title" id="myModalLabel" style="color: #000">后台组</h4>
       									</div>
       									<div class="modal-body" style="text-align: left">
       										<h4>简介</h4>
       										<p style="color:black;">后台开发，顾名思义是相对于前端的UI开发。虽然我们一眼看去察觉不了，可我们都在享受着后台提供的服务。当你在使用百度搜索资料的时候，你可曾想过百度搜索引擎是怎么返回匹配到的资料和网址？当你下载心仪的资料的时候，你可曾想过文件是怎样从服务器传送到你的电脑？后台，只是服务商给你提供的一系列服务的统称。不仅如此，作为后台开发人员，你还需要考虑这个平台的安全性和稳定性，用户反馈决定你这后台服务搭建的成功与否。我们后台组开发的自主学习平台获得软件软件著作权，正在参与到学校MOOC学习平台的开发和维护。
     现在各式各样的编程语言都在应用，而后台开发需要的编程语言也不少。而sql数据库技术更是后台开发人员必备学习内容，同时搭建网站还需掌握web系列的技术(html,jsp,servlet)和基本框架(其中常用的三大框架ssh(struts2+hibernate+spring))，而服务器的搭建和维护同时也考验我们的能力。因此想参与后台开发，首先要热爱编程，能吃苦耐劳，因为后台要学习的东西并不少，积极主动去学习会让你学会更多。
     未来是大数据云计算的时代，数据的快速存取是后台开发者一直致力研究的方向。现在redis和memcache等分布式数据存储方式正在飞速发展，我们相信将来后台提供的服务将更加人性化，这需要我们不断追求。</p>
       									</div>
       									<div class="modal-footer">
       										<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
       									</div>
       								</div>
       							</div>
       						</div>
        		
        	</div>
       	</div>
	


      </div>
    </div>
  </div>

  <div class="panel panel-default" id="the2" >
  	<div class="panel-heading" role="tab" id="headingTwo" class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
  		<h4 class="panel-title">
  			<a>
  				成员介绍
  			</a>
  		</h4>
  	</div>
		<div id ="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
  		<div class="panel-body">
  			<img src="photos/stuImg/pic5.png" class="img-responsive" style="margin-bottom: 10px;">
  			<div class="container" style="min-height: 200px"> 
  				<div class="row" style="margin-bottom: 15px;">
  					<div class="col-md-3 col-sm-3">
  						<img src="photos/stuImg/李杨.png" id="personImg">
  					</div>
  					<div class="col-md-9 col-sm-15">
  						<div class="info" style="margin-top: 15px;">
  							<p>姓名：李杨</p>
  							<p>性别：女</p>
  							<p>简介：计算机科学系副主任，科研方向为“机器学习、数据挖掘与差分隐私保护”。</p>
  						</div>
  					</div>
            <hr style="height:2px;background-color: #3caee7">
  				</div>

          


          <div class="row" style="margin-bottom: 15px;">
            <div class="col-md-3 col-sm-3">
              <img src="photos/stuImg/谢光强.png" id="personImg">
            </div>
            <div class="col-md-9 col-sm-15">
              <div class="info" style="margin-top: 15px;">
                <p>姓名：谢光强</p>
                <p>性别：男</p>
                <p>简介：副教授，广东省科技咨询专家库专家，研究领域为人工智能，虚拟现实，复杂网络。</p>
              </div>
            </div> 
            <hr style="height:2px;background-color: #3caee7">
          </div>

         


          <div class="row" style="margin-bottom: 15px;">
            <div class="col-md-3 col-sm-3">
              <img src="photos/stuImg/吴伟民.png" id="personImg">
            </div>
            <div class="col-md-9 col-sm-15">
              <div class="info" style="margin-top: 15px;">
                <p>姓名：吴伟民</p>
                <p>性别：男</p>
                <p>简介：国务院政府特殊津贴专家、广东省计算机学会常务理事、全国高等学校计算机教育研究会理事。</p>
              </div>
            </div>
          </div>

  			</div>
  			<img src="photos/stuImg/pic6.png" class="img-responsive" style="margin-bottom: 10px;">


  			<div class="panel-group" id="accordionSub" role="tablist" aria-multiselectable="true">

  				<div class="panel panel-default">
  					<div class="panel-heading" role="tab" id="headingOneSub" data-toggle="collapse" data-parent="#accordionSub" href="#collapseOneSub" aria-expanded="true" aria-controls="collapseOneSub" onclick="getMemberFunction(0);">
  						<h4 class="panel-title">
  							<a >
  								数据挖掘组
  							</a>
  						</h4>
  					</div>
  					<div id="collapseOneSub" class="panel-collapse collapse " role="tabpanel" aria-labelledby="headingOneSub">
  						<div class="panel-body">
  						<!-- 
  							<div class="row">
  								<div class="col-md-3 col-sm-3">
  									<img src="photos/stuImg/pic7.jpg" class="img-thumbnail" id="personImg">
  								</div>
  								<div class="col-md-9 col-sm-15">
  									<div class="info" style="margin-top: 10px;">
  										<p>姓名：xxx</p>
  										<p>性别：xx</p>
  										<p>专业：xxx</p>
  										<p>班级：xxx</p>
  										<p>介绍：（兴趣，个性）</p>
  										<p>留言：xxx</p>
  									</div>
  								</div>
  							</div>
  							<hr style="height:2px;background-color: #3caee7">
  							<div class="row" id="rowBot">
  								<div class="col-md-3 col-sm-3">
  									<img src="photos/stuImg/pic7.jpg" class="img-thumbnail" id="personImg">
  								</div>
  								<div class="col-md-9 col-sm-15">
  									<div class="info" style="margin-top: 10px;">
  										<p>姓名：xxx</p>
  										<p>性别：xx</p>
  										<p>专业：xxx</p>
  										<p>班级：xxx</p>
  										<p>介绍：（兴趣，个性）</p>
  										<p>留言：xxx</p>
  									</div>
  								</div>
  								
  							</div>
  							 
  							<hr style="height:2px;background-color: #3caee7">
  							-->
  						</div>
  					</div>
  				</div>


  				<div class="panel panel-default">
  					<div onclick="getMemberFunction(1);" class="panel-heading" role="tab" id="headingTwoSub" class="collapsed" data-toggle="collapse" data-parent="#accordionSub" href="#collapseTwoSub" aria-expanded="false" aria-controls="collapseTwoSub">
  						<h4 class="panel-title">
  							<a >
  								编译器组
  							</a>
  						</h4>
  					</div>
  					<div id="collapseTwoSub" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwoSub">
  						<div class="panel-body">
  							<!--  
  							<div class="row">
  								<div class="col-md-3 col-sm-3">
  									<img src="photos/stuImg/pic7.jpg" class="img-thumbnail" id="personImg">
  								</div>
  								<div class="col-md-9 col-sm-15">
  									<div class="info" style="margin-top: 10px;">
  										<p>姓名：xxx</p>
  										<p>性别：xx</p>
  										<p>专业：xxx</p>
  										<p>班级：xxx</p>
  										<p>介绍：（兴趣，个性）</p>
  										<p>留言：xxx</p>
  									</div>
  								</div>
  							</div>
  							<hr style="height:2px;background-color: #3caee7">
  							<div class="row">
  								<div class="col-md-3 col-sm-3">
  									<img src="photos/stuImg/pic7.jpg" class="img-thumbnail" id="personImg">
  								</div>
  								<div class="col-md-9 col-sm-15">
  									<div class="info" style="margin-top: 10px;">
  										<p>姓名：xxx</p>
  										<p>性别：xx</p>
  										<p>专业：xxx</p>
  										<p>班级：xxx</p>
  										<p>介绍：（兴趣，个性）</p>
  										<p>留言：xxx</p>
  									</div>
  								</div>
  							</div>
  							<hr style="height:2px;background-color: #3caee7">
  						-->
  						</div>
  					</div>
  				</div>


  				<div class="panel panel-default">
  					<div onclick="getMemberFunction(2);" class="panel-heading" role="tab" id="headingThreeSub" class="collapsed" data-toggle="collapse" data-parent="#accordionSub" href="#collapseThreeSub" aria-expanded="false" aria-controls="collapseThreeSub">
  						<h4 class="panel-title">
  							<a >
  								前端组
  							</a>
  						</h4>
  					</div>
  					<div id="collapseThreeSub" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThreeSub">
  						<div class="panel-body">
  							<!--  
  							<div class="row">
  								<div class="col-md-3 col-sm-3">
  									<img src="photos/stuImg/pic7.jpg" class="img-thumbnail" id="personImg">
  								</div>
  								<div class="col-md-9 col-sm-15">
  									<div class="info" style="margin-top: 10px;">
  										<p>姓名：xxx</p>
  										<p>性别：xx</p>
  										<p>专业：xxx</p>
  										<p>班级：xxx</p>
  										<p>介绍：（兴趣，个性）</p>
  										<p>留言：xxx</p>
  									</div>
  								</div>
  							</div>
  							<hr style="height:2px;background-color: #3caee7">
  							<div class="row">
  								<div class="col-md-3 col-sm-3">
  									<img src="photos/stuImg/pic7.jpg" class="img-thumbnail" id="personImg">
  								</div>
  								<div class="col-md-9 col-sm-15">
  									<div class="info" style="margin-top: 10px;">
  										<p>姓名：xxx</p>
  										<p>性别：xx</p>
  										<p>专业：xxx</p>
  										<p>班级：xxx</p>
  										<p>介绍：（兴趣，个性）</p>
  										<p>留言：xxx</p>
  									</div>
  								</div>
  							</div>
  							<hr style="height:2px;background-color: #3caee7">
  						-->
  						</div>
  					</div>
  				</div>

  				<div class="panel panel-default">
  					<div onclick="getMemberFunction(3);" class="panel-heading" role="tab" id="headingFourSub" class="collapsed" data-toggle="collapse" data-parent="#accordionSub" href="#collapseFourSub" aria-expanded="false" aria-controls="collapseFourSub">
  						<h4 class="panel-title">
  							<a >
  								后台组
  							</a>
  						</h4>
  					</div>
  					<div id="collapseFourSub" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFourSub">
  						<div class="panel-body">
  							<!-- 
  							<div class="row">
  								<div class="col-md-3 col-sm-3">
  									<img src="photos/stuImg/pic7.jpg" class="img-thumbnail" id="personImg">
  								</div>
  								<div class="col-md-9 col-sm-15">
  									<div class="info" style="margin-top: 10px;">
  										<p>姓名：xxx</p>
  										<p>性别：xx</p>
  										<p>专业：xxx</p>
  										<p>班级：xxx</p>
  										<p>介绍：（兴趣，个性）</p>
  										<p>留言：xxx</p>
  									</div>
  								</div>
  							</div>
  							<hr style="height:2px;background-color: #3caee7">
  							<div class="row">
  								<div class="col-md-3 col-sm-3">
  									<img src="photos/stuImg/pic7.jpg" class="img-thumbnail" id="personImg">
  								</div>
  								<div class="col-md-9 col-sm-15">
  									<div class="info" style="margin-top: 10px;">
  										<p>姓名：xxx</p>
  										<p>性别：xx</p>
  										<p>专业：xxx</p>
  										<p>班级：xxx</p>
  										<p>介绍：（兴趣，个性）</p>
  										<p>留言：xxx</p>
  									</div>
  								</div>
  							</div>
  							<hr style="height:2px;background-color: #3caee7">
  						 -->
  						</div>
  					</div>
  				</div>
  			</div>


  		</div>
  	</div>
  </div>
 

  <div class="panel panel-default" id="the3" >
    <div class="panel-heading" role="tab" id="headingThree" class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
      <h4 class="panel-title">
        <a>
          工作室主要成果
        </a>
      </h4>
    </div>
    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
      <div class="panel-body">

      	<!-- 内部手风琴-->
      	<div class="panel-group" id="accordionSub1" role="tablist" aria-multiselectable="true">



      		<!-- 项目-->
      		<div class="panel panel-default">
      			<div class="panel-heading" role="tab" id="headingOneSub1" id="projectA" data-toggle="collapse" data-parent="#accordionSub1" href="#collapseOnea" aria-expanded="true" aria-controls="collapseOnea" onclick="getResultFunctionOnLoad(1,1);">
      				<h4 class="panel-title">
      					<a>
      						项目
      					</a>
      				</h4>
      			</div>
      			<div id="collapseOnea" class="panel-collapse collapse " role="tabpanel" aria-labelledby="headingOneSub1">
      			<div class="panel-body" style="display:none">
				
				<!--此div里面的内容更新-->
				
                <div id="example1">
                <h4 id='h4'>没有项目内容</h4>
                  <h4>主题：xxx</h4>
                  <div class="row box" >
                    <div class="col-md-4 col-sm-6 pic">
                      <img src="photos/stuImg/1.png" alt="" class="img-responsive">
                    </div>
                    <div class="col-md-4 col-sm-6 pic">
                      <img src="photos/stuImg/1.png" alt="" class="img-responsive">
                    </div>
                    <div class="col-md-4 col-sm-6 pic">
                      <img src="photos/stuImg/1.png" alt="" class="img-responsive">
                    </div>
                  </div>
                  <p >时间：xxx</p>
                  <p >参与成员：xxxx（组长） xxx</p>
                 <!--   <textarea class="TextArea">描述文本……</textarea>-->
                  <div class="TextArea">描述文本...</div>
      			   </div>
      			   <!--例子div-->
			<!-- 
              <div id="navi" >
                 <ul class="pagination" >
                    <li><a >&laquo;</a></li>
                    <li><a >1</a></li>
                    <li><a >2</a></li>
                    <li><a >3</a></li>
                    <li><a >4</a></li>
                    <li><a >5</a></li>
                    <li><a >&raquo;</a></li>
                  </ul>
                </div> -->
      			</div>		<!--body结束-->	 
      		</div>
        </div>



      		<!-- 比赛-->
      		<div class="panel panel-default">
      			<div class="panel-heading" role="tab" id="headingTwoSub2" class="collapsed" data-toggle="collapse" data-parent="#accordionSub1" href="#collapseTwob" aria-expanded="false" aria-controls="collapseTwob" onclick="getResultFunctionOnLoad(1,0);">
      				<h4 class="panel-title">
      					<a>
      						比赛
      					</a>
      				</h4>
      			</div>
      			<div id="collapseTwob" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwoSub2">
      				<div class="panel-body" style="display:none">
      					<div id="example2">
      					<h4 id='h4'>没有比赛内容</h4>
      						<h4>主题：xxx</h4>
      						<div class="row box">
      							<div class="col-md-4 col-sm-6 pic">
      								<img src="photos/stuImg/1.png" alt="pic" class="img-responsive">
      							</div>
      							<div class="col-md-4 col-sm-6 pic">
      								<img src="photos/stuImg/1.png" alt="pic" class="img-responsive">
      							</div>
      							<div class="col-md-4 col-sm-6 pic">
      								<img src="photos/stuImg/1.png" alt="pic" class="img-responsive">
      							</div>
      						</div>
      						<p>时间：xxx</p>
      						<p>参与成员：xxxx（组长） xxx</p>
      						<!--  <textarea class="TextArea">描述文本……</textarea>-->
      						<div class="TextArea">描述文本...</div>
      					</div>
      			<!-- 	
                <div id="navi">
                  <ul class="pagination" >
                    <li><a href="#">&laquo;</a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">&raquo;</a></li>
                  </ul>
                </div> -->	
      				</div><!--body结束-->
      			</div>
      		</div>
      	</div><!--end内部手风琴-->

      </div>
      </div>
    </div>
  

  <div class="panel panel-default" id="the4">
    <div class="panel-heading" role="tab" id="headingFour" class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
      <h4 class="panel-title">
        <a>
          工作室日常活动
        </a>
      </h4>
    </div>
    <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
      <div class="panel-body">
        <!-- 内部手风琴-->
      	<div class="panel-group" id="accordionSub2" role="tablist" aria-multiselectable="true">
      		<!--技术交流会-->
      		<div class="panel panel-default">
      			<div class="panel-heading" role="tab" id="headingOneSub11" data-toggle="collapse" data-parent="#accordionSub2" href="#collapseOneab" aria-expanded="true" aria-controls="collapseOneab" onclick="getInterecommunionFunctionOnLoad(1);">
      				<h4 class="panel-title">
      					<a >
      						技术交流会
      					</a>
      				</h4>
      			</div>
      			<div id="collapseOneab" class="panel-collapse collapse " role="tabpanel" aria-labelledby="headingOneSub11">
      				<div class="panel-body" style="display:none">
      					<div id="example3">
      					<h4 id='h4'>没有交流会内容</h4>
      						<h4>主题：xxx</h4>
      						<div class="row">
      							<div class="col-md-4 col-sm-6 pic">
      								<img src="photos/stuImg/1.png" alt="" class="img-responsive">
      							</div>
      							<div class="col-md-4 col-sm-6 pic">
      								<img src="photos/stuImg/1.png" alt="" class="img-responsive">
      							</div>
      							<div class="col-md-4 col-sm-6 pic">
      								<img src="photos/stuImg/1.png" alt="" class="img-responsive">
      							</div>
      						</div>
      						<p>时间：xxx</p>
      						<p>主讲人：xxx</p>
      						<!--  <textarea rows="5" class="TextArea">描述文本……（简介以及成果展示）</textarea>-->
      						<div class="TextArea">描述文本...</div>
      					</div>
      			<!-- 	
                <div id="navi">
                  <ul class="pagination" >
                    <li><a href="#">&laquo;</a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">&raquo;</a></li>
                  </ul>
                </div>
 				-->	
      				</div><!--body 结束-->
      			</div>
      		</div>
      		<!--康乐活动-->
      		<div class="panel panel-default">
      			<div class="panel-heading" role="tab" id="headingTwoSub22" class="collapsed" data-toggle="collapse" data-parent="#accordionSub2" href="#collapseTwobb" aria-expanded="false" aria-controls="collapseTwobb" onclick="getActivityFunctionOnLoad(1);">
      				<h4 class="panel-title">
      					<a >
      						康乐活动
      					</a>
      				</h4>
      			</div>
      			<div id="collapseTwobb" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwoSub22">
      				<div class="panel-body" style="display:none">
      					<div id="example4">
      						<h4 id='h4'>没有活动内容</h4>
      						<h4>主题：xxx</h4>
      						<div class="row box">
      							<div class="col-md-4 col-sm-6 pic">
      								<img src="photos/stuImg/1.png" alt="" class="img-responsive">
      							</div>
      							<div class="col-md-4 col-sm-6 pic">
      								<img src="photos/stuImg/1.png" alt="" class="img-responsive">
      							</div>
      							<div class="col-md-4 col-sm-6 pic">
      								<img src="photos/stuImg/1.png" alt="" class="img-responsive">
      							</div>
      						</div>
      						<p>组织者：xxx</p>
      						<p>活动时间：xxx</p>
      						<!--  <textarea rows="5" class="TextArea">活动内容：xxx</textarea>
      						<textarea rows="5" class="TextArea">活动感想：xxx</textarea>-->
      						<div class="TextArea">描述文本...</div>
      						<div class="TextArea">描述文本...</div>
      					</div>
      			<!--  		
                <div id="navi">
                  <ul class="pagination" >
                    <li><a href="#">&laquo;</a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">&raquo;</a></li>
                  </ul>
                </div>
                -->
      				</div><!--body结束-->
      			</div>
      		</div>
      	</div><!--end内部手风琴-->
      </div>
    </div>
  </div>

  <div class="panel panel-default" id="the5">
    <div class="panel-heading" role="tab" id="headingFive" class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseFive" aria-expanded="false" aria-controls="collapseFive" onclick="getArticleFunctionOnLoad(1)">
      <h4 class="panel-title">
        <a >
          工作室推送
        </a>
      </h4>
    </div>
    <div id="collapseFive" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFive">
      <div class="panel-body" style="display:none">
        <div id="example5">
        	<h4 id='h4'>没有推送内容</h4>
        	<h4>主题：xxx</h4>
        	<p>发布时间：xxx</p>
        	<p>发布人：xxxx（转载等描述）</p>
        	<p>描述文本……</p>
        	<div id='content'>内容:</div>
        </div>
        </div>
      </div><!--body结束-->
    </div>

  </div><!--面板组结束-->

  </div><!-- end contianer-->

	</div>
  
  <%@ include file="Footer.jsp" %>
    
  <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	
	<script type="text/javascript" src="js/stuJs/general_member.js"></script>
	<script type="text/javascript" src="js/stuJs/general_result.js"></script>
	<script type="text/javascript" src="js/stuJs/general_interecommunion.js"></script>
	<script type="text/javascript" src="js/stuJs/general_activity.js"></script>
	<script type="text/javascript" src="js/stuJs/general_article.js"></script>


	  <script type="text/javascript">
    jQuery(document).ready(function($) {
      $("#nav").css('margin-bottom', '20px');
    });
  </script>

	
	  <script type="text/javascript">
  	
  		$(function(){
  			<%  String openNum = request.getParameter("openNum");
  			int value = 0;
  			if(null!=openNum)
  				if(openNum.matches("[0-9]")){
  					value = Integer.parseInt(openNum);
  				}
  		
  			%> 
  		
  		switch(<%=value%>){
  			case 0: openDiv = $("#collapseOne");break;
  			case 1:openDiv = $("#collapseTwo");break;
  		}  
  		openDiv.attr("class",openDiv.attr("class")+" in");
  		
  		});
  	
  </script>
  <script type="text/javascript">
    jQuery(document).ready(function($) {
      $("#nav").css('margin-bottom', '20px');
    });
  </script>
	



  </body>

</html>
