<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>DS工作室</title>
    <link rel="shortcut icon" href="photos/DSlogo32.ico">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" type="text/css" href="css/stuCss/headerCss.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/main.css" id="main-css">
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
  
  <body style="height: 100%;">
  	
  	<%@ include file="Header.jsp" %>

  <div class="fullwidthbanner-container" style="height: 86%;">
		<div id="revolution-slider">
			<ul>
				 <li data-transition="fade" data-slotamount="10" data-masterspeed="300" data-thumb="photos/stuImg/images-slider/thumbs/thumb1.jpg">
					<!--  BACKGROUND IMAGE -->
					<img src="photos/stuImg/images-slider/wide33.jpg" alt="" />

					<!-- THE CAPTIONS IN THIS SLIDE -->
					<div class="tp-caption sfl"
						data-x="50"
						data-y="150"
						data-speed="300"
						data-start="300"
						data-easing="easeOutBack">
						<img src="photos/stuImg/images-slider/rb.png" alt="">
					</div>

					<div class="tp-caption med-white lfl"
						data-x="180"
						data-y="145"
						data-speed="300"
						data-start="800"
						data-easing="easeOutExpo">
						<img src="photos/stuImg/welcome.png" alt="">
					</div>
<!--class="caption sfb very-big-white"-->
					<div class="tp-caption med-white1 lfl"
						data-x="210"
						data-y="210"
						data-speed="300"
						data-start="1200"
						data-easing="easeOutExpo">
						数据结构与可视计算工作室 
						
					</div>

					<div class="tp-caption med-white lfl"
						data-x="210"
						data-y="250"
						data-speed="300"
						data-start="1600"
						data-easing="easeOutExpo">
						<img src="photos/stuImg/ds.png" alt="">
						
					</div>

					<div class="tp-caption small-white lfr"
						data-x="520"
						data-y="280"
						data-speed="300"
						data-start="2000"
						data-easing="easeOutExpo">
						数据挖掘组  编译器组  前端组  后台组
					</div>

					<div class="tp-caption small-white lfr"
						data-x="230"
						data-y="340"
						data-speed="300"
						data-start="2010"
						data-easing="easeOutExpo">
						宣讲会时间地点：4月9日 15：00 工一阶梯教室
					</div>
					<div class="tp-caption small-white lfr"
						data-x="258"
						data-y="370"
						data-speed="300"
						data-start="2020"
						data-easing="easeOutExpo">
						笔试时间地点：4月11日 19：30 教四101、103
					</div>

					<!--
					<div class="tp-caption lfb"
						data-x="390"
						data-y="40"
						data-speed="1000"
						data-start="2000"
						data-easing="easeOutExpo"
						data-endeasing="fade"
						>
						<img src="images-slider/guy-shadow.png" alt="">
					</div>-->
<!--
					<div class="tp-caption small-white lft"
						data-x="240"
						data-y="0"
						data-speed="2000"
						data-start="2600"
						data-easing="easeOutExpo">
						<img src="images-slider/spotlight.png" alt="">
					</div>

					<div class="tp-caption fade"
						data-x="390"
						data-y="40"
						data-speed="2000"
						data-start="2600"
						data-easing="easeOutExpo">
						<img src="images-slider/guy.png" alt="">
					</div>-->
				</li>
				<!-- THE FIRST SLIDE -->
				<li data-transition="fade" data-slotamount="10" data-masterspeed="300" data-thumb="photos/stuImg/images-slider/thumbs/thumb1.jpg">
					<!--  BACKGROUND IMAGE -->
					<img src="photos/stuImg/images-slider/wide111.jpg" alt="" />

					<!-- THE CAPTIONS IN THIS SLIDE -->
					<div class="caption large_text sfb"
						data-x="300"
						data-y="207"
						data-speed="300"
						data-start="800"
						data-easing="easeOutExpo">
						<img src="photos/stuImg/images-slider/middle.png" alt="">
					</div>

					<div class="tp-caption sfr"
						data-x="220"
						data-y="115"
						data-speed="300"
						data-start="1000"
						data-easing="easeOutBack">
						<img src="photos/stuImg/images-slider/lu.png" alt="">
					</div>

					<div class="tp-caption sfr"
						data-x="30"
						data-y="60"
						data-speed="300"
						data-start="1200"
						data-easing="easeOutBack">
						<img src="photos/stuImg/images-slider/enthusiasm.png" alt="">
					</div>

					<div class="tp-caption sfr"
						data-x="200"
						data-y="217"
						data-speed="300"
						data-start="1400"
						data-easing="easeOutBack">
						<img src="photos/stuImg/images-slider/lm.png" alt="">
					</div>

					<div class="tp-caption sfr"
						data-x="0"
						data-y="200"
						data-speed="300"
						data-start="1600"
						data-easing="easeOutBack">
						<img src="photos/stuImg/images-slider/earnest.png" alt="">
					</div>

					<div class="tp-caption sfr"
						data-x="210"
						data-y="285"
						data-speed="300"
						data-start="1800"
						data-easing="easeOutBack">
						<img src="photos/stuImg/images-slider/lb.png" alt="">
					</div>

					<div class="tp-caption sfr"
						data-x="30"
						data-y="345"
						data-speed="300"
						data-start="2000"
						data-easing="easeOutBack">
						<img src="photos/stuImg/images-slider/responsible.png" alt="">
					</div>

					<div class="tp-caption sfl"
						data-x="615"
						data-y="115"
						data-speed="300"
						data-start="2200"
						data-easing="easeOutBack">
						<img src="photos/stuImg/images-slider/ru.png" alt="">
					</div>

					<div class="tp-caption sfl"
						data-x="720"
						data-y="85"
						data-speed="300"
						data-start="2400"
						data-easing="easeOutBack">
						<img src="photos/stuImg/images-slider/optimistic.png" alt="">
					</div>

					<div class="tp-caption sfl"
						data-x="620"
						data-y="217"
						data-speed="300"
						data-start="2600"
						data-easing="easeOutBack">
						<img src="photos/stuImg/images-slider/rm.png" alt="">
					</div>

					<div class="tp-caption sfl"
						data-x="730"
						data-y="205"
						data-speed="300"
						data-start="2800"
						data-easing="easeOutBack">
						<img src="photos/stuImg/images-slider/cooperation.png" alt="">
					</div>

					<div class="tp-caption sfl"
						data-x="615"
						data-y="285"
						data-speed="300"
						data-start="3000"
						data-easing="easeOutBack">
						<img src="photos/stuImg/images-slider/rb.png" alt="">
					</div>

					<div class="tp-caption sfl"
						data-x="720"
						data-y="345"
						data-speed="300"
						data-start="3200"
						data-easing="easeOutBack">
						<img src="photos/stuImg/images-slider/patience.png" alt="">
					</div>
				</li>

				<li data-transition="fade" data-slotamount="10" data-masterspeed="300" data-thumb="photos/stuImg/images-slider/thumbs/thumb1.jpg">
					<!--  BACKGROUND IMAGE -->
					<img src="photos/stuImg/images-slider/wide22.jpg" alt="" />

					<!-- THE CAPTIONS IN THIS SLIDE -->
					<div class="tp-caption sfl"
						data-x="50"
						data-y="100"
						data-speed="300"
						data-start="300"
						data-easing="easeOutBack">
						<img src="photos/stuImg/images-slider/rb.png" alt="">
					</div>

					<div class="caption sfb very-big-white"
						data-x="180"
						data-y="180"
						data-speed="300"
						data-start="800"
						data-easing="easeOutExpo">
						<img src="photos/stuImg/come.png" alt="">
					</div>

					<div class="tp-caption med-white1 sfl"
						data-x="180"
						data-y="250"
						data-speed="300"
						data-start="1000"
						data-easing="easeOutExpo">
						你想要 我需要
					</div>

					<div class="tp-caption med-white sfl"
						data-x="180"
						data-y="310"
						data-speed="300"
						data-start="1000"
						data-easing="easeOutExpo">
						赶快加入我们吧！
					</div>
					<!--
					<div class="tp-caption small-white sfr"
						data-x="0"
						data-y="260"
						data-speed="300"
						data-start="1200"
						data-easing="easeOutExpo">
						<a href="#" class="btn btn-large btn-primary">Purchase Now</a>
					</div>

					<div class="tp-caption small-white lfb"
						data-x="300"
						data-y="40"
						data-speed="1000"
						data-start="1400"
						data-easing="easeOutExpo">
						<img src="images-slider/slider-10.png" alt="" />
					</div>-->
				</li>
			   
			</ul>
		</div>
</div>
    <%@ include file="Footerer.jsp" %>
    
    
    <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/stuJs/rev-setting-1.js"></script>
	<script type="text/javascript" src="rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
  </body>
</html>
