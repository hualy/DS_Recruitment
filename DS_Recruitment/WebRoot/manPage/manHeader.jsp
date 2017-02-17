		<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
		<script src="js/sweet-alert.min.js"></script> 
		<link rel="stylesheet" type="text/css" href="css/sweet-alert.css">
		
		<div class="page-header container">
          <div class="headline">
            <span><img src="photos/manImg/logo.png" /></span>
            <span><h1>DS WORKSHOP---MANAGER</h1></span>
          </div>
          <div class="clearFloat"></div>
        </div>
        <!--page header -->
        <!-- navigation bar -->
        <nav class="navbar navbar-default" role="navigation">
          <div class="container">

            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navigation">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <span class="navbar-brand">DS工作室</span>
            </div>

            <div class="collapse navbar-collapse" id="navigation">
                <ul class="nav navbar-nav nav-tabs" role="tablist">
                  <li class="active"><a href="#" class="index-btn">
                  <span class="glyphicon glyphicon-home" style="padding-right: 7px;"></span>首页</a></li>

                    <li class="dropdown">
                      <a href="#" data-toggle="dropdown" id="GeneralSituation-btn">
                        	<span class="glyphicon glyphicon-user" style="padding-right: 7px;"></span>
                        	概况管理<span class="caret"></span>
                      </a>
                      <ul class="dropdown-menu" role="menu">
                        <li><a href="#" role="menuitem" id="pub-ach-btn">
                        	<span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>
                        	发布成果</a></li>
                        <li><a href="#" role="menuitem" id="rev-ach-btn">
                        	<span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>
                        	修改成果</a></li>
                        <li><a href="#" role="menuitem" id="pub-mem-btn">
                        	<span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>
                        	发布成员</a></li>
                        <li><a href="#" role="menuitem" id="rev-mem-btn">
                        	<span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>
                        	修改成员</a></li>
                        <li><a href="#" role="menuitem" id="pub-info-btn">
                        	<span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>
                        	发布推送</a></li>
                        <li><a href="#" role="menuitem" id="rev-info-btn">
                        	<span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>
                        	修改推送</a></li>
                        <li><a href="#" role="menuitem" id="pub-com-btn">
                        	<span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>
                        	发布交流会展示</a></li>
                        <li><a href="#" role="menuitem" id="rev-com-btn">
                        	<span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>
                        	修改交流会展示</a></li>
                        <li><a href="#" role="menuitem" id="pub-act-btn">
                        	<span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>
                        	发布日常活动展示</a></li>
                        <li><a href="#" role="menuitem" id="rev-act-btn">
                        	<span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>
                        	修改日常活动展示</a></li>
                        
                      </ul>
                    </li>

                    <li class="dropdown">
                      <a href="#" data-toggle="dropdown">
                      <span class="glyphicon glyphicon-bullhorn" style="padding-right: 7px;"></span></span>
                     	 信息管理<span class="caret"></span></a>
                      <ul class="dropdown-menu" role="menu">
                        <li><a href="#" role="menuitem" id="pub-ann-btn">
                        	<span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>
                        	发布公告</a></li>
                        <li><a href="#" role="menuitem" id="rev-ann-btn">
                        	<span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>
                        	修改公告</a></li>
                        <li><a href="#" role="menuitem" id="pub-rec-btn">
                        	<span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>
                        	发布招生信息</a></li>
                        <li><a href="#" role="menuitem" id="rev-rec-btn">
                        	<span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>
                        	修改招生信息</a></li>
                      </ul>
                    </li>

                    <li class="dropdown">
                      <a href="#" data-toggle="dropdown">
                      	<span class="glyphicon glyphicon-pencil" style="padding-right: 7px;"></span>
                      	笔试管理<span class="caret"></span></a>
                      <ul class="dropdown-menu" role="menu">
                        <li><a href="#" id="exa-topic-man-btn">
                        	<span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>
                        	试题管理</a></li>
                        <li><a href="#" role="menuitem" id="pub-exam-mess-btn">
                        	<span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>
                        	考试信息管理</a></li>                        	
                        <li><a href="#" role="menuitem" id="che-res-btn">
                        	<span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>
                        	查看考试结果</a></li>
                        <li><a href="#" role="menuitem" id="download-result">
                        	<span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>
                        	导出考生试卷</a></li>  
                        <li><a href="#" role="menuitem" id="registration-mess-btn">
                        	<span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;" ></span>
                        	导出报名信息</a></li>                         	                      	
                        <li><a href="#" role="menuitem" id="ent-stu-res-btn">
                        	<span class="glyphicon glyphicon-triangle-right" style="padding-right: 5px;"></span>
                        	录入程序题成绩</a></li>
                      </ul>
                    </li>
                    <li><a href="#" role="menuitem" id="mess-reply-btn">
                    		<span class="glyphicon glyphicon-envelope" style="padding-right: 5px;"></span>
                    		留言回复</a></li>
                </ul>


                <ul class="nav navbar-nav navbar-right">
                  <li><a href="#" id="pageviews-btn">浏览量:0</a></li>
                  <li><a href="#" class="navbar-link" id="adminLogout-btn"><span class="glyphicon glyphicon-thumbs-up" style="padding-right: 5px;"></span>注销登陆</a></li>
                </ul>
            </div>
          </div>      
        </nav> 
        
        