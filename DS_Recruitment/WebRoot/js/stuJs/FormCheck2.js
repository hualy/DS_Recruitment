

$(function(){
	
	$(document).on("click",".sa-custom",function(){
		var Random = Math.random();
		$(this).css("background-image",'url("examination_public/createCheckCodeAction?'+Random+'")');
	});
//	$("#body").on("click",".cancel",function(){
//		$("#body").removeClass("stop-scrolling");
//	});
	
	var saveApp = function(){
		$.ajax({
			type: "POST",
			url: "userInfo/saveApplicantInfoAction",
			dataType: "HTML",
			data: $("#form").serialize(),
			success: function(result){
					if(result == "success"){
						swal({
							title: "报名成功",   
							text: "DS欢迎您!",   
							type: "success",   
							confirmButtonColor: "#DD6B55",   			
							confirmButtonText: "确认",   
							closeOnConfirm: false
							},function(){
								window.location.href = "Home.html";
							});
						}
			}
		});
	}

	var checkValidate = function(){
			swal({
                title: "请输入验证码",
                type: "input",
                imageUrl: "examination_public/createCheckCodeAction?"+ Math.random(),
                imageSize: "150x50",
				showCancelButton: true,
				closeOnConfirm: false,
				animation: "slide-from-top",
                inputPlaceholder: "请在这输入!",
                }, function(inputValue) {
                     if (inputValue == "") {
                         swal.showInputError("请输入!");
                         return false;
                     }else{
           				$.ajax({
							type: "POST",
							url: "examination_public/applicationValidateAction",
							dataType: "HTML",
							data: {'checkCode': inputValue, 'studentID':$("#inputSuccessNumber").val(), 'name':$("#inputSuccessName").val()},   
							success:function(result){
									if(result == "wrong"){
										swal({
											title: "验证码不正确!",   
											text: "请重新输入",   
											type: "error",   
											confirmButtonColor: "#DD6B55",   
											confirmButtonText: "确认",   
											closeOnConfirm: false
											},function(){
												checkValidate();
											}
										);
									}else if(result == "illegal"){
										swal({
											title: "身份验证出现了问题!",   
											text: "不好意思，本平台仅接受计算机学院大一新生的报名!请检查您的名字和学号是否正确,若无误请联系我们 QQ：601537492/316207576",   
											type: "error",   
											confirmButtonColor: "#DD6B55",   
											confirmButtonText: "确认",   
											closeOnConfirm: false
											}
										);
									}else if(result == "exist"){
										swal({
											title: "您已经报名了!",   
											text: "请问您是否要覆盖原来的报名信息,继续报名？",   
											type: "warning",   
											showCancelButton: true,   
											confirmButtonColor: "#DD6B55",   
											confirmButtonText: "确定",   
											cancelButtonText: "取消",   
											closeOnConfirm: false,   
											closeOnCancel: false 
											},function(isConfirm){
													if(isConfirm){
														saveApp();
//														swal("暂时不能修改您的信息","如想修改信息,请联系招新负责人(QQ:316207576)","error");
													}else{
														swal("取消成功！","","success");
													}
											}
										);
									}else if(result == "success"){
										saveApp();	
									}
								}
						});
                       }
              });

	}

	$("#submit").click(function(){
		var form = document.getElementById("form");
		if(validate(form)){
			checkValidate();
		}else{
			sweetAlert("报名失败", "请重新输入！", "error");
		}
	});

});


function getLength(str){
	return str.replace(/[^\x00-xff]/g,"x").length;
}


function validate(thisform){
	//提交的时候判空
	with(thisform){
		var length=0;


		var numberTip=document.getElementById("numberTip");
		var nameTip=document.getElementById("nameTip");
		var academyTip=document.getElementById("academyTip");
		var majorTip=document.getElementById("majorTip");
		var classesTip=document.getElementById("classesTip");
		var positionTip=document.getElementById("positionTip");
		var telTip=document.getElementById("telTip");
		var shortTelTip=document.getElementById("shortTelTip");
		var qqTip=document.getElementById("qqTip");//不必要
		var emailTip=document.getElementById("emailTip");//不必要
		var abilityTip=document.getElementById("abilityTip");
		var commentTip=document.getElementById("commentTip");
		var objectTip=document.getElementById("objectTip");


		length1=getLength(studentID.value);//学号长度
		length2=getLength(name.value);//姓名长度
		length3=getLength(academy.value);//学院长度
		length4=getLength(major.value);//专业长度
		length5=getLength(grade.value);//班级长度
		length6=getLength(phoneNumber.value);//手机长度
		length7=getLength(QQ.value);//qq长度
		length8=getLength(skills.value);//技能长度
		length9=getLength(selfevaluation.value);//自我评价长度
		length10=getLength(hopes.value);

		var re1=/[^\d]/g;//判断数字
		var re2=/(3215|3115[0-9]*)/;//学号判断
		var re3=/[^\u4e00-\u9fa5]/g;//文字判断
		var re33=/[\u4E00-\u9FA5]{2,7}(?:·[\u4E00-\u9FA5]{2,7})*/g;
		var re4=/^[0-9]{5,6}$/;//短号判断
		var re5= /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/g;//邮箱判断
		var re6=/[\u4e00-\u9fa5]|[1-9]\d*/g;//班级判断
		var re7=/^[\d|\u4E00-\u9FFF]+$/g;//班级判断

		var re=/^\?(.*)(select%20|insert%20|delete%20from%20|count\(|drop%20table|update%20truncate%20|asc\(|mid\(|char\(|xp_cmdshell|exec%20master|net%20localgroup%20administrators|\"|:|net%20user|\|%20or%20)(.*)$/gi;//SQL注入问题
		var e1=re.test(studentID.value);
		var e2=re.test(name.value);
		var e3=re.test(academy.value);
		var e4=re.test(major.value);
		var e5=re.test(grade.value);
		var e6=re.test(job.value);
		var e7=re.test(phoneNumber.value);
		var e8=re.test(shortphoneNumber.value);
		var e9=re.test(QQ.value);
		var e10=re.test(email.value);
		//----------------------------------学号验证------------------------------------------
		if (e1) {
			numberTip.style.display="block";
			numberTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#numberDiv").addClass('has-error');
				$("#numberspanerror").css('display', 'block');
				$("#numberspansuccess").css('display', 'none');
			})
			studentID.focus();
			return false
		}else if(studentID.value==""){
			numberTip.style.display="block";
			numberTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
			jQuery(document).ready(function($) {
				$("#numberDiv").addClass('has-error');
				$("#numberspanerror").css('display', 'block');
				$("#numberspansuccess").css('display', 'none');
			})
			studentID.focus();
			return false
		}else if(re1.test(studentID.value)){
			numberTip.style.display="block";
			numberTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#numberDiv").addClass('has-error');
				$("#numberspanerror").css('display', 'block');
				$("#numberspansuccess").css('display', 'none');
			})
			studentID.focus();
			return false
		}else if(length1<10||length1>10){
			numberTip.style.display="block";
			numberTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>学号格式不正确！</strong></p>';
			jQuery(document).ready(function($) {
				$("#numberDiv").addClass('has-error');
				$("#numberspanerror").css('display', 'block');
				$("#numberspansuccess").css('display', 'none');
			})
			studentID.focus();
			return false
		}else if(!re2.test(studentID.value)){
			numberTip.style.display="block";
			numberTip.innerHTML='<p class="<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>非大一新生！</strong></p>';
			jQuery(document).ready(function($) {
				$("#numberDiv").addClass('has-error');
				$("#numberspanerror").css('display', 'block');
				$("#numberspansuccess").css('display', 'none');
			})
			studentID.focus();
			return false
		}

		//----------------------------------名字验证------------------------------------------
		else if (e2) {
			nameTip.style.display="block";
			nameTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#nameDiv").addClass('has-error');
				$("#namespanerror").css('display', 'block');
				$("#namespansuccess").css('display', 'none');
			})
			name.focus();
			return false
		}else if(name.value==""){
			nameTip.style.display="block";
			nameTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
			jQuery(document).ready(function($) {
				$("#nameDiv").addClass('has-error');
				$("#namespanerror").css('display', 'block');
				$("#namespansuccess").css('display', 'none');
			})
			name.focus();
			return false
		}else if(!re33.test(name.value)){
			nameTip.style.display="block";
			nameTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#nameDiv").addClass('has-error');
				$("#namespanerror").css('display', 'block');
				$("#namespansuccess").css('display', 'none');
			})
			name.focus();
			return false
		}else if(length2>15){
			nameTip.style.display="block";
			nameTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>过长！</strong></p>';
			jQuery(document).ready(function($) {
				$("#nameDiv").addClass('has-error');
				$("#namespanerror").css('display', 'block');
				$("#namespansuccess").css('display', 'none');
			})
			name.focus();
			return false
		}
		//----------------------------------学院验证------------------------------------------
		else if (e3) {
			academyTip.style.display="block";
			academyTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#academyDiv").addClass('has-error');
				$("#academyspanerror").css('display', 'block');
				$("#academyspansuccess").css('display', 'none');
			})
			academy.focus();
			return false
		}else if(academy.value==""){
			academyTip.style.display="block";
			academyTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
			jQuery(document).ready(function($) {
				$("#academyDiv").addClass('has-error');
				$("#academyspanerror").css('display', 'block');
				$("#academyspansuccess").css('display', 'none');
			})
			academy.focus();
			return false
		}else if(re3.test(academy.value)){
			academyTip.style.display="block";
			academyTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#academyDiv").addClass('has-error');
				$("#academyspanerror").css('display', 'block');
				$("#academyspansuccess").css('display', 'none');
			})
			academy.focus();
			return false
		}else if(length3>10){
			academyTip.style.display="block";
			academyTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>过长！</strong></p>';
			jQuery(document).ready(function($) {
				$("#academyDiv").addClass('has-error');
				$("#academyspanerror").css('display', 'block');
				$("#academyspansuccess").css('display', 'none');
			})
			academy.focus();
			return false
		}
		//----------------------------------专业验证------------------------------------------
		else if(e4){
			majorTip.style.display="block";
			majorTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#majorDiv").addClass('has-error');
				$("#majorspanerror").css('display', 'block');
				$("#majorspansuccess").css('display', 'none');
			})
			major.focus();
			return false
		}else if(major.value==""){
			majorTip.style.display="block";
			majorTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
			jQuery(document).ready(function($) {
				$("#majorDiv").addClass('has-error');
				$("#majorspanerror").css('display', 'block');
				$("#majorspansuccess").css('display', 'none');
			})
			major.focus();
			return false
		}else if(re3.test(major.value)){
			majorTip.style.display="block";
			majorTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#majorDiv").addClass('has-error');
				$("#majorspanerror").css('display', 'block');
				$("#majorspansuccess").css('display', 'none');
			})
			major.focus();
			return false
		}else if(length4>10){
			majorTip.style.display="block";
			majorTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>过长！</strong></p>';
			jQuery(document).ready(function($) {
				$("#majorDiv").addClass('has-error');
				$("#majorspanerror").css('display', 'block');
				$("#majorspansuccess").css('display', 'none');
			})
			major.focus();
			return false
		}
		//----------------------------------班级验证------------------------------------------
		else if(e5){
			classesTip.style.display="block";
			classesTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#classesDiv").addClass('has-error');
				$("#classesspanerror").css('display', 'block');
				$("#classesspansuccess").css('display', 'none');
			})
			grade.focus();
			return false
		}else if(!re7.test(grade.value)){
			classesTip.style.display="block";
			classesTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#classesDiv").addClass('has-error');
				$("#classesspanerror").css('display', 'block');
				$("#classesspansuccess").css('display', 'none');
			})
			grade.focus();
			return false
		}else if(grade.value==""){
			classesTip.style.display="block";
			classesTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
			jQuery(document).ready(function($) {
				$("#classesDiv").addClass('has-error');
				$("#classesspanerror").css('display', 'block');
				$("#classesspansuccess").css('display', 'none');
			})
			grade.focus();
			return false
		}else if(length5>10){
			classesTip.style.display="block";
			classesTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>过长！</strong></p>';
			jQuery(document).ready(function($) {
				$("#classesDiv").addClass('has-error');
				$("#classesspanerror").css('display', 'block');
				$("#classesspansuccess").css('display', 'none');
			})
			grade.focus();
			return false
		}
		//----------------------------------职务验证------------------------------------------(非必要)
		else if(e6){
			positionTip.style.display="block";
			positionTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#positionDiv").addClass('has-error');
				$("#positionspanerror").css('display', 'block');
				$("#positionspansuccess").css('display', 'none');
			})
			job.focus();
			return false
		}else if(re3.test(job.value)&&job.value!=""){
			positionTip.style.display="block";
			positionTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#positionDiv").addClass('has-error');
				$("#positionspanerror").css('display', 'block');
				$("#positionspansuccess").css('display', 'none');
			})
			job.focus();
			return false
		}
		//----------------------------------手机验证------------------------------------------
		else if(e7){
			telTip.style.display="block";
			telTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#telDiv").addClass('has-error');
				$("#telspanerror").css('display', 'block');
				$("#telspansuccess").css('display', 'none');
			})
			phoneNumber.focus();
			return false
		}else if(phoneNumber.value==""){
			telTip.style.display="block";
			telTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
			jQuery(document).ready(function($) {
				$("#telDiv").addClass('has-error');
				$("#telspanerror").css('display', 'block');
				$("#telspansuccess").css('display', 'none');
			})
			phoneNumber.focus();
			return false
		}else if(re1.test(phoneNumber.value)){
			telTip.style.display="block";
			telTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#telDiv").addClass('has-error');
				$("#telspanerror").css('display', 'block');
				$("#telspansuccess").css('display', 'none');
			})
			phoneNumber.focus();
			return false
		}else if(length6<11||length6>11){
			telTip.style.display="block";
			telTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>手机号格式不正确！</strong></p>';
			jQuery(document).ready(function($) {
				$("#telDiv").addClass('has-error');
				$("#telspanerror").css('display', 'block');
				$("#telspansuccess").css('display', 'none');
			})
			phoneNumber.focus();
			return false
		}
		//----------------------------------短号验证------------------------------------------（非必要）
		else if(e8){
			shortTelTip.style.display="block";
			shortTelTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#shortTelDiv").addClass('has-error');
				$("#shortTelspanerror").css('display', 'block');
				$("#shortTelspansuccess").css('display', 'none');
			})
			//shortphoneNumber.focus();
			return false
		}else if(!re4.test(shortphoneNumber.value)&&shortphoneNumber.value!=""){
			shortTelTip.style.display="block";
			shortTelTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>短号格式不对！</strong></p>';
			jQuery(document).ready(function($) {
				$("#shortTelDiv").addClass('has-error');
				$("#shortTelspanerror").css('display', 'block');
				$("#shortTelspansuccess").css('display', 'none');
			})
			//shortphoneNumber.focus();
			return false
		}
		//----------------------------------QQ验证------------------------------------------
		else if(e9){
			qqTip.style.display="block";
			qqTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#qqDiv").addClass('has-error');
				$("#qqspanerror").css('display', 'block');
				$("#qqspansuccess").css('display', 'none');
			})
			QQ.focus();
			return false
		}else if(QQ.value==""){
			qqTip.style.display="block";
			qqTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
			jQuery(document).ready(function($) {
				$("#qqDiv").addClass('has-error');
				$("#qqspanerror").css('display', 'none');
				$("#qqspansuccess").css('display', 'none');
			})
			QQ.focus();
			return false
		}else if(re1.test(QQ.value)){
			qqTip.style.display="block";
			qqTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#qqDiv").addClass('has-error');
				$("#qqspanerror").css('display', 'block');
				$("#qqspansuccess").css('display', 'none');
			})
			QQ.focus();
			return false
		}else if(length7>15||length7<6){
			qqTip.style.display="block";
			qqTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>QQ号格式不正确！</strong></p>';
			jQuery(document).ready(function($) {
				$("#qqDiv").addClass('has-error');
				$("#qqspanerror").css('display', 'block');
				$("#qqspansuccess").css('display', 'none');
			})
			QQ.focus();
			return false
		}
		//----------------------------------邮箱验证------------------------------------------（非必要）
		else if(e10){
			emailTip.style.display="block";
			emailTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#emailDiv").addClass('has-error');
				$("#emailspanerror").css('display', 'block');
				$("#emailspansuccess").css('display', 'none');
			})
			email.focus();
			return false
		}else if(!re5.test(email.value)&&email.value!=""){
			emailTip.style.display="block";
			emailTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>邮箱格式不正确！</strong></p>';
			jQuery(document).ready(function($) {
				$("#emailDiv").addClass('has-error');
				$("#emailspanerror").css('display', 'block');
				$("#emailspansuccess").css('display', 'none');
			})
			email.focus();
			return false
		}
		//----------------------------------技能验证------------------------------------------
		else if(length8==0){
				//alert("NO");
				abilityTip.style.display="block";
				abilityTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
				jQuery(document).ready(function($) {
					$("#abilityDiv").addClass('has-error');
					$("#abilityspanerror").css('display', 'block');
					$("#abilityspansuccess").css('display', 'none');
				})
				skills.focus();
				return false
		}else if(length8>150){
				//alert("hello");
				abilityTip.style.display="block";
				abilityTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>字数多于150！</strong></p>';
				jQuery(document).ready(function($) {
					$("#abilityDiv").addClass('has-error');
					$("#abilityspanerror").css('display', 'block');
					$("#abilityspansuccess").css('display', 'none');
				})
				skills.focus();
				return false
			}
		//----------------------------------自我评价验证------------------------------------------
		else if(length9==0){
				//alert("NO");
				commentTip.style.display="block";
				commentTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
				jQuery(document).ready(function($) {
					$("#commentDiv").addClass('has-error');
					$("#commentspanerror").css('display', 'block');
					$("#commentspansuccess").css('display', 'none');
				})
				selfevaluation.focus();
				return false
			}else if(length9>150){
				//alert("hello");
				commentTip.style.display="block";
				commentTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>字数多于150！</strong></p>';
				jQuery(document).ready(function($) {
					$("#commentDiv").addClass('has-error');
					$("#commentspanerror").css('display', 'block');
					$("#commentspansuccess").css('display', 'none');
				})
				selfevaluation.focus();
				return false
			}
		//----------------------------------目的及期望验证验证------------------------------------------
			else if(length10==0){
				//alert("NO");
				objectTip.style.display="block";
				objectTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
				jQuery(document).ready(function($) {
					$("#objectDiv").addClass('has-error');
					$("#objectspanerror").css('display', 'block');
					$("#objectspansuccess").css('display', 'none');
				})
				hopes.focus();
				return false
			}else if(length10>150){
				//alert("hello");
				objectTip.style.display="block";
				objectTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>字数多于150！</strong></p>';
				jQuery(document).ready(function($) {
					$("#objectDiv").addClass('has-error');
					$("#objectspanerror").css('display', 'block');
					$("#objectspansuccess").css('display', 'none');
				})
				hopes.focus();
				return false
			}else{
				return true
		}
	}//with

}//validate


window.onload=function(){
	var number=document.getElementById("inputSuccessNumber");
	var name=document.getElementById("inputSuccessName");
	var academy=document.getElementById("inputSuccessAcademy");
	var major=document.getElementById("inputSuccessMajor");
	var classes=document.getElementById("inputSuccessClasses");
	var position=document.getElementById("inputSuccessPosition");
	var tel=document.getElementById("inputSuccessTel");
	var shorttel=document.getElementById("inputSuccessShortTel");
	var qq=document.getElementById("inputSuccessQQ");
	var email=document.getElementById("inputSuccessEmail");
	var ability=document.getElementById("inputSuccessAbility");
	var comment=document.getElementById("inputSuccessComment");
	var object=document.getElementById("inputSuccessObject");

	var numberTip=document.getElementById("numberTip");
	var nameTip=document.getElementById("nameTip");
	var academyTip=document.getElementById("academyTip");
	var majorTip=document.getElementById("majorTip");
	var classesTip=document.getElementById("classesTip");
	var positionTip=document.getElementById("positionTip");
	var telTip=document.getElementById("telTip");
	var shortTelTip=document.getElementById("shortTelTip");
	var qqTip=document.getElementById("qqTip");//不必要
	var emailTip=document.getElementById("emailTip");//不必要
	var abilityTip=document.getElementById("abilityTip");
	var commentTip=document.getElementById("commentTip");
	var objectTip=document.getElementById("objectTip");


	number.focus();

	//----------------------------------学号验证------------------------------------------
	number.onblur=function(){
		length=getLength(this.value);
		var re1=/^\?(.*)(select%20|insert%20|delete%20from%20|count\(|drop%20table|update%20truncate%20|asc\(|mid\(|char\(|xp_cmdshell|exec%20master|net%20localgroup%20administrators|\"|:|net%20user|\|%20or%20)(.*)$/gi;
		var e=re1.test(this.value);
		if (e) {
			numberTip.style.display="block";
			numberTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#numberDiv").addClass('has-error');
				$("#numberspanerror").css('display', 'block');
				$("#numberspansuccess").css('display', 'none');
			})
		}
		var re=/[^\d]/g;
		var re4=/(3215|3115[0-9]*)/;
		if(this.value==""){
			numberTip.style.display="block";
			numberTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
			jQuery(document).ready(function($) {
				$("#numberDiv").addClass('has-error');
				$("#numberspanerror").css('display', 'block');
				$("#numberspansuccess").css('display', 'none');
			})
		}else if(re.test(this.value)){
			numberTip.style.display="block";
			numberTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#numberDiv").addClass('has-error');
				$("#numberspanerror").css('display', 'block');
				$("#numberspansuccess").css('display', 'none');
			})
		}else if(length<10||length>10){
			numberTip.style.display="block";
			numberTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>学号格式不正确！</strong></p>';
			jQuery(document).ready(function($) {
				$("#numberDiv").addClass('has-error');
				$("#numberspanerror").css('display', 'block');
				$("#numberspansuccess").css('display', 'none');
			})
		}else if(!re4.test(this.value)){
			numberTip.style.display="block";
			numberTip.innerHTML='<p class="<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>非大一新生！</strong></p>';
			jQuery(document).ready(function($) {
				$("#numberDiv").addClass('has-error');
				$("#numberspanerror").css('display', 'block');
				$("#numberspansuccess").css('display', 'none');
			})
		}else{
			jQuery(document).ready(function($) {
				$("#numberDiv").removeClass('has-error');
				$("#numberDiv").addClass('has-success');
				$("#numberspanerror").css('display', 'none');
				$("#numberspansuccess").css('display', 'block');
				numberTip.style.display="none";
			})
		}

	}
	//----------------------------------名字验证------------------------------------------
	name.onblur = function(){
		length=getLength(this.value);
		var re1=/^\?(.*)(select%20|insert%20|delete%20from%20|count\(|drop%20table|update%20truncate%20|asc\(|mid\(|char\(|xp_cmdshell|exec%20master|net%20localgroup%20administrators|\"|:|net%20user|\|%20or%20)(.*)$/gi;
		var e=re1.test(this.value);
		if (e) {
			nameTip.style.display="block";
			nameTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#nameDiv").addClass('has-error');
				$("#namespanerror").css('display', 'block');
				$("#namespansuccess").css('display', 'none');
			})
		}
		var re=/[\u4E00-\u9FA5]{2,7}(?:·[\u4E00-\u9FA5]{2,7})*/g;
		if(this.value==""){
			nameTip.style.display="block";
			nameTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
			jQuery(document).ready(function($) {
				$("#nameDiv").addClass('has-error');
				$("#namespanerror").css('display', 'block');
				$("#namespansuccess").css('display', 'none');
			})
		}else if(!re.test(this.value)){
			nameTip.style.display="block";
			nameTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#nameDiv").addClass('has-error');
				$("#namespanerror").css('display', 'block');
				$("#namespansuccess").css('display', 'none');
			})
		}else if(length>15){
			nameTip.style.display="block";
			nameTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>过长！</strong></p>';
			jQuery(document).ready(function($) {
				$("#nameDiv").addClass('has-error');
				$("#namespanerror").css('display', 'block');
				$("#namespansuccess").css('display', 'none');
			})
		}else{
			jQuery(document).ready(function($) {
				$("#nameDiv").removeClass('has-error');
				$("#nameDiv").addClass('has-success');
				$("#namespanerror").css('display', 'none');
				$("#namespansuccess").css('display', 'block');
				nameTip.style.display="none";
			})
		}//else结束！
	}
	//----------------------------------学院验证------------------------------------------
	academy.onblur = function(){
		length=getLength(this.value);
		var re1=/^\?(.*)(select%20|insert%20|delete%20from%20|count\(|drop%20table|update%20truncate%20|asc\(|mid\(|char\(|xp_cmdshell|exec%20master|net%20localgroup%20administrators|\"|:|net%20user|\|%20or%20)(.*)$/gi;
		var e=re1.test(this.value);
		if (e) {
			academyTip.style.display="block";
			academyTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#academyDiv").addClass('has-error');
				$("#academyspanerror").css('display', 'block');
				$("#academyspansuccess").css('display', 'none');
			})
		}
		var re=/[^\u4e00-\u9fa5]/g;
		if(this.value==""){
			academyTip.style.display="block";
			academyTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
			jQuery(document).ready(function($) {
				$("#academyDiv").addClass('has-error');
				$("#academyspanerror").css('display', 'block');
				$("#academyspansuccess").css('display', 'none');
			})
		}else if(re.test(this.value)){
			academyTip.style.display="block";
			academyTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#academyDiv").addClass('has-error');
				$("#academyspanerror").css('display', 'block');
				$("#academyspansuccess").css('display', 'none');
			})
		}else if(length>10){
			academyTip.style.display="block";
			academyTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>过长！</strong></p>';
			jQuery(document).ready(function($) {
				$("#academyDiv").addClass('has-error');
				$("#academyspanerror").css('display', 'block');
				$("#academyspansuccess").css('display', 'none');
			})
		}else{
			jQuery(document).ready(function($) {
				$("#academyDiv").removeClass('has-error');
				$("#academyDiv").addClass('has-success');
				$("#academyspanerror").css('display', 'none');
				$("#academyspansuccess").css('display', 'block');
				academyTip.style.display="none";
			})
		}
	}
	//----------------------------------专业验证------------------------------------------
	major.onblur = function(){
		length=getLength(this.value);
		var re1=/^\?(.*)(select%20|insert%20|delete%20from%20|count\(|drop%20table|update%20truncate%20|asc\(|mid\(|char\(|xp_cmdshell|exec%20master|net%20localgroup%20administrators|\"|:|net%20user|\|%20or%20)(.*)$/gi;
		var e=re1.test(this.value);
		if(e){
			majorTip.style.display="block";
			majorTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#majorDiv").addClass('has-error');
				$("#majorspanerror").css('display', 'block');
				$("#majorspansuccess").css('display', 'none');
			})
		}
		var re=/[^\u4e00-\u9fa5]/g;
		if(this.value==""){
			majorTip.style.display="block";
			majorTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
			jQuery(document).ready(function($) {
				$("#majorDiv").addClass('has-error');
				$("#majorspanerror").css('display', 'block');
				$("#majorspansuccess").css('display', 'none');
			})
		}else if(re.test(this.value)){
			majorTip.style.display="block";
			majorTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#majorDiv").addClass('has-error');
				$("#majorspanerror").css('display', 'block');
				$("#majorspansuccess").css('display', 'none');
			})
		}else if(length>10){
			majorTip.style.display="block";
			majorTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>过长！</strong></p>';
			jQuery(document).ready(function($) {
				$("#majorDiv").addClass('has-error');
				$("#majorspanerror").css('display', 'block');
				$("#majorspansuccess").css('display', 'none');
			})
		}else{
			jQuery(document).ready(function($) {
				$("#majorDiv").removeClass('has-error');
				$("#majorDiv").addClass('has-success');
				$("#majorspanerror").css('display', 'none');
				$("#majorspansuccess").css('display', 'block');
				majorTip.style.display="none";
			})
		}
	}
	//----------------------------------班级验证------------------------------------------
	classes.onblur = function(){
		length=getLength(this.value);
		var re1=/^\?(.*)(select%20|insert%20|delete%20from%20|count\(|drop%20table|update%20truncate%20|asc\(|mid\(|char\(|xp_cmdshell|exec%20master|net%20localgroup%20administrators|\"|:|net%20user|\|%20or%20)(.*)$/gi;
		var e=re1.test(this.value);
		if(e){
			classesTip.style.display="block";
			classesTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#classesDiv").addClass('has-error');
				$("#classesspanerror").css('display', 'block');
				$("#classesspansuccess").css('display', 'none');
			})
		}
		var re=/^[\d|\u4E00-\u9FFF]+$/g;
		if(!re.test(this.value)){
			classesTip.style.display="block";
			classesTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#classesDiv").addClass('has-error');
				$("#classesspanerror").css('display', 'block');
				$("#classesspansuccess").css('display', 'none');
			})
		}else if(this.value==""){
			classesTip.style.display="block";
			classesTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
			jQuery(document).ready(function($) {
				$("#classesDiv").addClass('has-error');
				$("#classesspanerror").css('display', 'block');
				$("#classesspansuccess").css('display', 'none');
			})
		}else if(length>10){
			classesTip.style.display="block";
			classesTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>过长！</strong></p>';
			jQuery(document).ready(function($) {
				$("#classesDiv").addClass('has-error');
				$("#classesspanerror").css('display', 'block');
				$("#classesspansuccess").css('display', 'none');
			})
		}else{
			jQuery(document).ready(function($) {
				$("#classesDiv").removeClass('has-error');
				$("#classesDiv").addClass('has-success');
				$("#classesspanerror").css('display', 'none');
				$("#classesspansuccess").css('display', 'block');
				classesTip.style.display="none";
			})
		}
	}
	//----------------------------------职务验证------------------------------------------(非必要)
	position.onblur = function(){
		var re1=/^\?(.*)(select%20|insert%20|delete%20from%20|count\(|drop%20table|update%20truncate%20|asc\(|mid\(|char\(|xp_cmdshell|exec%20master|net%20localgroup%20administrators|\"|:|net%20user|\|%20or%20)(.*)$/gi;
		var e=re1.test(this.value);
		if(e){
			positionTip.style.display="block";
			positionTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#positionDiv").addClass('has-error');
				$("#positionspanerror").css('display', 'block');
				$("#positionspansuccess").css('display', 'none');
			})
		}
		var re=/[^\u4e00-\u9fa5]/g;
		if(this.value==""){
			jQuery(document).ready(function($) {
				$("#positionDiv").removeClass('has-error');
				$("#positionspanerror").css('display', 'none');
				$("#positionspansuccess").css('display', 'none');
				positionTip.style.display="none";
			})
		}else if(re.test(this.value)&&this.value!=""){
			positionTip.style.display="block";
			positionTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#positionDiv").addClass('has-error');
				$("#positionspanerror").css('display', 'block');
				$("#positionspansuccess").css('display', 'none');
			})
		}else{//非空并且值正确
			jQuery(document).ready(function($) {
				$("#positionDiv").removeClass('has-error');
				$("#positionDiv").addClass('has-success');
				$("#positionspanerror").css('display', 'none');
				$("#positionspansuccess").css('display', 'block');
				positionTip.style.display="none";
			})
		}
	}
	//----------------------------------手机验证------------------------------------------
	tel.onblur = function(){
		length=getLength(this.value);
		var re1=/^\?(.*)(select%20|insert%20|delete%20from%20|count\(|drop%20table|update%20truncate%20|asc\(|mid\(|char\(|xp_cmdshell|exec%20master|net%20localgroup%20administrators|\"|:|net%20user|\|%20or%20)(.*)$/gi;
		var e=re1.test(this.value);
		if(e){
			telTip.style.display="block";
			telTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#telDiv").addClass('has-error');
				$("#telspanerror").css('display', 'block');
				$("#telspansuccess").css('display', 'none');
			})
		}
		var re=/[^\d]/g;
		if(this.value==""){
			telTip.style.display="block";
			telTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
			jQuery(document).ready(function($) {
				$("#telDiv").addClass('has-error');
				$("#telspanerror").css('display', 'block');
				$("#telspansuccess").css('display', 'none');
			})
		}else if(re.test(this.value)){
			telTip.style.display="block";
			telTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#telDiv").addClass('has-error');
				$("#telspanerror").css('display', 'block');
				$("#telspansuccess").css('display', 'none');
			})
		}else if(length<11||length>11){
			telTip.style.display="block";
			telTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>手机号格式不正确！</strong></p>';
			jQuery(document).ready(function($) {
				$("#telDiv").addClass('has-error');
				$("#telspanerror").css('display', 'block');
				$("#telspansuccess").css('display', 'none');
			})
		}else{
			jQuery(document).ready(function($) {
				$("#telDiv").removeClass('has-error');
				$("#telDiv").addClass('has-success');
				$("#telspanerror").css('display', 'none');
				$("#telspansuccess").css('display', 'block');
				telTip.style.display="none";
			})
		}
	}
	//----------------------------------短号验证------------------------------------------（非必要）
	shorttel.onblur = function(){
		var re1=/^\?(.*)(select%20|insert%20|delete%20from%20|count\(|drop%20table|update%20truncate%20|asc\(|mid\(|char\(|xp_cmdshell|exec%20master|net%20localgroup%20administrators|\"|:|net%20user|\|%20or%20)(.*)$/gi;
		var e=re1.test(this.value);
		if(e){
			shortTelTip.style.display="block";
			shortTelTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#shortTelDiv").addClass('has-error');
				$("#shortTelspanerror").css('display', 'block');
				$("#shortTelspansuccess").css('display', 'none');
			})
		}
		var re=/^[0-9]{5,6}$/;
		if(this.value==""){
			jQuery(document).ready(function($) {
				$("#shortTelDiv").removeClass('has-error');
				$("#shortTelspanerror").css('display', 'none');
				$("#shortTelspansuccess").css('display', 'none');
				shortTelTip.style.display="none";
			})
		}else if(!re.test(this.value)&&this.value!=""){
			shortTelTip.style.display="block";
			shortTelTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>短号格式不对！</strong></p>';
			jQuery(document).ready(function($) {
				$("#shortTelDiv").addClass('has-error');
				$("#shortTelspanerror").css('display', 'block');
				$("#shortTelspansuccess").css('display', 'none');
			})
		}else{
			jQuery(document).ready(function($) {
				$("#shortTelDiv").removeClass('has-error');
				$("#shortTelDiv").addClass('has-success');
				$("#shortTelspanerror").css('display', 'none');
				$("#shortTelspansuccess").css('display', 'block');
				shortTelTip.style.display="none";
			})
		}

	}
	//----------------------------------QQ验证------------------------------------------
	qq.onblur = function(){
		length=getLength(this.value);
		var re1=/^\?(.*)(select%20|insert%20|delete%20from%20|count\(|drop%20table|update%20truncate%20|asc\(|mid\(|char\(|xp_cmdshell|exec%20master|net%20localgroup%20administrators|\"|:|net%20user|\|%20or%20)(.*)$/gi;
		var e=re1.test(this.value);
		if(e){
			qqTip.style.display="block";
			qqTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#qqDiv").addClass('has-error');
				$("#qqspanerror").css('display', 'block');
				$("#qqspansuccess").css('display', 'none');
			})
		}
		var re=/[^\d]/g;
		if(this.value==""){
			qqTip.style.display="block";
			qqTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
			jQuery(document).ready(function($) {
				$("#qqDiv").addClass('has-error');
				$("#qqspanerror").css('display', 'none');
				$("#qqspansuccess").css('display', 'none');
			})
		}else if(re.test(this.value)){
			qqTip.style.display="block";
			qqTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#qqDiv").addClass('has-error');
				$("#qqspanerror").css('display', 'block');
				$("#qqspansuccess").css('display', 'none');
			})
		}else if(length>15||length<6){
			qqTip.style.display="block";
			qqTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>QQ号格式不正确！</strong></p>';
			jQuery(document).ready(function($) {
				$("#qqDiv").addClass('has-error');
				$("#qqspanerror").css('display', 'block');
				$("#qqspansuccess").css('display', 'none');
			})
		}else{
			jQuery(document).ready(function($) {
				$("#qqDiv").removeClass('has-error');
				$("#qqDiv").addClass('has-success');
				$("#qqspanerror").css('display', 'none');
				$("#qqspansuccess").css('display', 'block');
				qqTip.style.display="none";
			})
		}
	}
	//----------------------------------邮箱验证------------------------------------------（非必要）
	email.onblur = function(){
		var re1=/^\?(.*)(select%20|insert%20|delete%20from%20|count\(|drop%20table|update%20truncate%20|asc\(|mid\(|char\(|xp_cmdshell|exec%20master|net%20localgroup%20administrators|\"|:|net%20user|\|%20or%20)(.*)$/gi;
		var e=re1.test(this.value);
		if(e){
			emailTip.style.display="block";
			emailTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#emailDiv").addClass('has-error');
				$("#emailspanerror").css('display', 'block');
				$("#emailspansuccess").css('display', 'none');
			})
		}
		var re = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/g;
		if(this.value==""){
			jQuery(document).ready(function($) {
				$("#emailDiv").removeClass('has-error');
				$("#emailspanerror").css('display', 'none');
				$("#emailspansuccess").css('display', 'none');
				emailTip.style.display="none";
			})
		}else if(!re.test(this.value)&&this.value!=""){
			emailTip.style.display="block";
			emailTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>邮箱格式不正确！</strong></p>';
			jQuery(document).ready(function($) {
				$("#emailDiv").addClass('has-error');
				$("#emailspanerror").css('display', 'block');
				$("#emailspansuccess").css('display', 'none');
			})
		}else{
			jQuery(document).ready(function($) {
				$("#emailDiv").removeClass('has-error');
				$("#emailDiv").addClass('has-success');
				$("#emailspanerror").css('display', 'none');
				$("#emailspansuccess").css('display', 'block');
				emailTip.style.display="none";
			})
		}

	}
		//----------------------------------技能验证------------------------------------------
		ability.onblur=function(){
			length=getLength(this.value);
			//alert(length);
			if(length==0){
				//alert("NO");
				abilityTip.style.display="block";
				abilityTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
				jQuery(document).ready(function($) {
				$("#abilityDiv").addClass('has-error');
				$("#abilityspanerror").css('display', 'block');
				$("#abilityspansuccess").css('display', 'none');
				})
			}else if(length>150){
				//alert("hello");
				abilityTip.style.display="block";
				abilityTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>字数多于150！</strong></p>';
				jQuery(document).ready(function($) {
				$("#abilityDiv").addClass('has-error');
				$("#abilityspanerror").css('display', 'block');
				$("#abilityspansuccess").css('display', 'none');
				})
			}else{
				//alert("OK");
				jQuery(document).ready(function($) {
				$("#abilityDiv").removeClass('has-error');
				$("#abilityDiv").addClass('has-success');
				$("#abilityspanerror").css('display', 'none');
				$("#abilityspansuccess").css('display', 'block');
				abilityTip.style.display="none";
			})
			}
		}
		//----------------------------------自我评价验证------------------------------------------
		comment.onblur=function(){
			length=getLength(this.value);
			//alert(length);
			if(length==0){
				//alert("NO");
				commentTip.style.display="block";
				commentTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
				jQuery(document).ready(function($) {
				$("#commentDiv").addClass('has-error');
				$("#commentspanerror").css('display', 'block');
				$("#commentspansuccess").css('display', 'none');
				})
			}else if(length>150){
				//alert("hello");
				commentTip.style.display="block";
				commentTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>字数多于150！</strong></p>';
				jQuery(document).ready(function($) {
				$("#commentDiv").addClass('has-error');
				$("#commentspanerror").css('display', 'block');
				$("#commentspansuccess").css('display', 'none');
				})
			}else{
				//alert("OK");
				jQuery(document).ready(function($) {
				$("#commentDiv").removeClass('has-error');
				$("#commentDiv").addClass('has-success');
				$("#commentspanerror").css('display', 'none');
				$("#commentspansuccess").css('display', 'block');
				commentTip.style.display="none";
			})
			}
		}
		//----------------------------------目的及期望验证验证------------------------------------------
		object.onblur= function(){
			length=getLength(this.value);
			//alert(length);
			if(length==0){
				//alert("NO");
				objectTip.style.display="block";
				objectTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
				jQuery(document).ready(function($) {
				$("#objectDiv").addClass('has-error');
				$("#objectspanerror").css('display', 'block');
				$("#objectspansuccess").css('display', 'none');
				})
			}else if(length>150){
				//alert("hello");
				objectTip.style.display="block";
				objectTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>字数多于150！</strong></p>';
				jQuery(document).ready(function($) {
				$("#objectDiv").addClass('has-error');
				$("#objectspanerror").css('display', 'block');
				$("#objectspansuccess").css('display', 'none');
				})
			}else{
				//alert("OK");
				jQuery(document).ready(function($) {
				$("#objectDiv").removeClass('has-error');
				$("#objectDiv").addClass('has-success');
				$("#objectspanerror").css('display', 'none');
				$("#objectspansuccess").css('display', 'block');
				objectTip.style.display="none";
			})
			}
		}
}