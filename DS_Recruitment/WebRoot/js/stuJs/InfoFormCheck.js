$(function(){
	
	$(document).on("click",".sa-custom",function(){
		var Random = Math.random();
		$(this).css("background-image",'url("examination_public/createCheckCodeAction?'+Random+'")');
	});
});

 	var formSubmit = function(){
 		
 		swal({
 			type:"input",
 			title:"请输入验证码",
 			imageUrl:'word/getCheckCode?',
 			imageSize:"150x50",
 			html:true,
 			showCancelButton: true,
 			animation: "slide-from-top", 
			//inputPlaceholder: "请在这输入!",
			closeOnConfirm: false
 		},
	 		function(inputValue){
 				if(inputValue==false){
 					
 				}else{
 					if(inputValue.length==4){
					 	$.ajax({
				 			type:"post",
				     		url:'word/sendLeavingWord',
				    		data: {
					 			"code":inputValue,
				 				"name":$("input[name='name']").val(),
				 				"QQ":$("input[name='QQ']").val(),
				 				"email":$("input[name='email']").val(),
				 				"content":$("textarea[name='content']").val()
				    		},
				    		async:false,
				    		success:function(returnedData,status){
				    			if(returnedData=="留言成功"){
					    			swal({
												title: "留言成功",  
												text: "DS欢迎您留言",
												type: "success",   
												confirmButtonColor: "#DD6B55",   
												confirmButtonText: "确认",   
												closeOnConfirm: false
											}		    
										);
					    			$("input[name='name']").val("");
					    			$("input[name='QQ']").val("");
					    			$("input[name='email']").val("");
					    			$("textarea[name='content']").val("");
					
									$("#namespansuccess").css('display', 'none');
									$("#qqspansuccess").css('display', 'none');
									$("#emailspansuccess").css('display', 'none');
									$("#informationspansuccess").css('display', 'none');
				    			}else{
				    				swal(returnedData,'error','error');
				    			}
				    			
				    		}
				 		});
 					}else{
 						swal("请输入正确的验证码",'error','error');
 					}
 					
 				}
	 			
	 		}
 		);
 		
 		
// 		$.ajax({
// 			type:"post",
//     		url:'word/sendLeavingWord',
//    		data: {
// 				"name":$("input[name='name']").val(),
// 				"QQ":$("input[name='QQ']").val(),
// 				"email":$("input[name='email']").val(),
// 				"content":$("textarea[name='content']").val()
//    		},
//    		async:false,
//    		success:function(returnedData,status){
//    			swal({
//							title: "留言成功",  
//							text: "DS欢迎您留言",
//							type: "success",   
//							confirmButtonColor: "#DD6B55",   
//							confirmButtonText: "确认",   
//							closeOnConfirm: false
//						}		    
//					);
//    			$("input[name='name']").val("");
//    			$("input[name='QQ']").val("");
//    			$("input[name='email']").val("");
//    			$("textarea[name='content']").val("");
//
//				$("#namespansuccess").css('display', 'none');
//				$("#qqspansuccess").css('display', 'none');
//				$("#emailspansuccess").css('display', 'none');
//				$("#informationspansuccess").css('display', 'none');
//    		}
// 		});



 	}




function getLength(str){
	return str.replace(/[^\x00-xff]/g,"x").length;
}

function sendSuccess(){
				
     	swal({
			title: "留言成功",   
		    text: "DS欢迎您！",   
		    type: "success", 
		    showConfirmButton:true,
		    confirmButtonColor: "#DD6B55",   
		    confirmButtonText: "确认",   
		    closeOnConfirm: false
		    },function(){
		    	
		    }
		);
				
}



function validate(thisform){
	//提交的时候判空

	with(thisform){
		length=0;
		var nameTip=document.getElementById("nameTip");
		var qqTip=document.getElementById("qqTip");
		var emailTip=document.getElementById("emailTip");
		var informationTip=document.getElementById("informationTip");


		length1=getLength(name.value);
		length2=getLength(QQ.value);
		length3=getLength(email.value);
		length4=getLength(content.value);

		var re=/^\?(.*)(select%20|insert%20|delete%20from%20|count\(|drop%20table|update%20truncate%20|asc\(|mid\(|char\(|xp_cmdshell|exec%20master|net%20localgroup%20administrators|\"|:|net%20user|\|%20or%20)(.*)$/gi;//SQL注入问题
		var e1=re.test(name.value);
		var e2=re.test(QQ.value);
		var e3=re.test(email.value);
		var e4=re.test(content.value);

		var re1=/[^\d]/g;//判断数字
		var re2=/(3215|3115[0-9]*)/;//学号判断
		var re3=/[^\u4e00-\u9fa5]/g;//文字判断
		var re33=/[\u4E00-\u9FA5]{2,7}(?:·[\u4E00-\u9FA5]{2,7})*/g;
		var re4=/^[0-9]{5,6}$/;//短号判断
		var re5= /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/g;//邮箱判断


		//----------------------------------姓名验证------------------------------------------
		if (e1) {
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
		}else if(length1>15){
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

		//----------------------------------QQ验证------------------------------------------

		if(e2){
			qqTip.style.display="block";
			qqTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#qqDiv").addClass('has-error');
				$("#qqspanerror").css('display', 'block');
				$("#qqspansuccess").css('display', 'none');
			})
			QQ.focus();
			return false
		}
		if(QQ.value==""){
			qqTip.style.display="block";
			qqTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
			jQuery(document).ready(function($) {
				$("#qqDiv").addClass('has-error');
				$("#qqspanerror").css('display', 'block');
				$("#qqspansuccess").css('display', 'none');
			})
			QQ.focus();
			return false
		}else if(re1.test(QQ.value)&&QQ.value!=""){
			qqTip.style.display="block";
			qqTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#qqDiv").addClass('has-error');
				$("#qqspanerror").css('display', 'block');
				$("#qqspansuccess").css('display', 'none');
			})
			QQ.focus();
			return false
		}else if(length2>15||length2<6){
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

		//----------------------------------邮箱验证------------------------------------------
		else if(e3){
			emailTip.style.display="block";
			emailTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>含有非法字符！</strong></p>';
			jQuery(document).ready(function($) {
				$("#emailDiv").addClass('has-error');
				$("#emailspanerror").css('display', 'block');
				$("#emailspansuccess").css('display', 'none');
			})
			email.focus();
			return false
		}
		if(email.value==""){
			emailTip.style.display="block";
			emailTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
			jQuery(document).ready(function($) {
				$("#emailDiv").addClass('has-error');
				$("#emailspanerror").css('display', 'block');
				$("#emailspansuccess").css('display', 'none');
			})
			email.focus();
			return false
		}else if(!re5.test(email.value)){
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

		//----------------------------------留言验证------------------------------------------

		else if(length4==0){
				//alert("NO");
				informationTip.style.display="block";
				informationTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
				jQuery(document).ready(function($) {
					$("#informationDiv").addClass('has-error');
					$("#informationspanerror").css('display', 'block');
					$("#informationspansuccess").css('display', 'none');
				})
				content.focus();
				return false
		}else if(length>200){
				//alert("hello");
				informationTip.style.display="block";
				informationTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>字数多于200！</strong></p>';
				jQuery(document).ready(function($) {
					$("#informationDiv").addClass('has-error');
					$("#informationspanerror").css('display', 'block');
					$("#informationspansuccess").css('display', 'none');
				})
				content.focus();
				return false
		}else{
			formSubmit();
			return false
		}
	}
}


window.onload = function(){
	var name=document.getElementById("inputSuccessName");
	var qq=document.getElementById("inputSuccessQQ");
	var email=document.getElementById("inputSuccessEmail");
	var content=document.getElementById("inputSuccessInformation");

	var length=0;

	var nameTip=document.getElementById("nameTip");
	var qqTip=document.getElementById("qqTip");
	var emailTip=document.getElementById("emailTip");
	var informationTip=document.getElementById("informationTip");

	//----------------------------------姓名验证------------------------------------------
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
		var re=/[^\d$]/g;
		if(this.value==""){
			qqTip.style.display="block";
			qqTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
			jQuery(document).ready(function($) {
				$("#qqDiv").addClass('has-error');
				$("#qqspanerror").css('display', 'block');
				$("#qqspansuccess").css('display', 'none');
			})
		}else if(re.test(this.value)&&this.value!=""){
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

	//----------------------------------邮箱验证------------------------------------------

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
			emailTip.style.display="block";
			emailTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
			jQuery(document).ready(function($) {
				$("#emailDiv").addClass('has-error');
				$("#emailspanerror").css('display', 'block');
				$("#emailspansuccess").css('display', 'none');
			})
		}else if(!re.test(this.value)){
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

	//----------------------------------留言验证------------------------------------------
		
		content.onblur=function(){
			length=getLength(this.value);
			//alert(length);
			if(length==0){
				//alert("NO");
				informationTip.style.display="block";
				informationTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>此处不能为空！</strong></p>';
				jQuery(document).ready(function($) {
				$("#informationDiv").addClass('has-error');
				$("#informationspanerror").css('display', 'block');
				$("#informationspansuccess").css('display', 'none');
				})
			}else if(length>200){
				//alert("hello");
				informationTip.style.display="block";
				informationTip.innerHTML='<p class="form-control-static"><img src="photos/stuImg/bulb.png" style="margin-right:5px;"/><strong>字数多于200！</strong></p>';
				jQuery(document).ready(function($) {
				$("#informationDiv").addClass('has-error');
				$("#informationspanerror").css('display', 'block');
				$("#informationspansuccess").css('display', 'none');
				})
			}else{
				//alert("OK");
				jQuery(document).ready(function($) {
				$("#informationDiv").removeClass('has-error');
				$("#informationDiv").addClass('has-success');
				$("#informationspanerror").css('display', 'none');
				$("#informationspansuccess").css('display', 'block');
				informationTip.style.display="none";
			})
			}
		}
}//window结束
