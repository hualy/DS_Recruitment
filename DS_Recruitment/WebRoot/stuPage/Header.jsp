<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


  <!-- 导航栏 -->
    <nav class="navbar navbar-default" id="nav">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <!-- 折叠后的效果 -->
    <!-- <a class="navbar-brand" href="#">
        <img alt="dsLogo" id="logo" src="photos/stuImg/logo1.png">
      </a> -->
    
    <div class="navbar-header">
    <!-- 折叠按钮 -->
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" style="background-color:#1293ef ;border: 0px;">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="Home.html">
        <img alt="Brand" src="photos/stuImg/brand1.png" style="margin-top: -16px;">
      </a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <!-- 要折叠的部分 -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="z-index:999;border: 0px;">
      
      <ul class="nav navbar-nav navbar-right">
      	<li><a href="Home.html"><span class="glyphicon glyphicon-home" style="padding-right: 5px;"></span>主页</a></li>
      	
      	<li class="dropdown" >
          <li><a href="General.html"><span class="glyphicon glyphicon-user" style="padding-right: 5px;"></span>工作室概况</a></li>
          <!--
      		<a href="stuPage/General.jsp" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false" id="drop1"><span class="glyphicon glyphicon-user" style="padding-right: 5px;"></span>工作室概况 <span class="caret"></span></a>
          
      		<ul class="dropdown-menu" role="menu">
      			<li id="here1"><a href="stuPage/General.jsp"><span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>方向简介</a></li>
      			<li class="divider"></li>
      			<li id="here2"><a><span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>成员介绍</a></li>
      			<li class="divider"></li>
      			<li id="here3"><a href="stuPage/General.jsp"><span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>工作室主要成果</a></li>
      			<li class="divider"></li>
      			<li id="here4"><a href="stuPage/General.jsp"><span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>工作室日常活动</a></li>
      			<li class="divider"></li>
      			<li id="here5"><a href="stuPage/General.jsp"><span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>工作室推送</a></li>
      		</ul>
          -->
      	</li>
        <li><a href="information.html"><span class="glyphicon glyphicon-bullhorn" style="padding-right: 5px;"></span>公告信息</a></li>
        <!--
      	<li class="dropdown">
      		<a href="stuPage/Information.jsp" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-bullhorn" style="padding-right: 5px;"></span>考试公告<span class="caret"></span></a>
      		<ul class="dropdown-menu" role="menu">
      			<li><a href="stuPage/Information.jsp"><span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>公告</a></li>
      			<li class="divider"></li>
      			<li><a href="stuPage/Information.jsp"><span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>招新信息</a></li>
      		</ul>	
      	</li>-->
      	<li><a href="ExamApply.html"><span class="glyphicon glyphicon-pencil" style="padding-right: 5px;"></span>在线报名</a></li>
      	<li><a href="messageBoard.html"><span class="glyphicon glyphicon-envelope" style="padding-right: 5px;"></span>留言板</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

