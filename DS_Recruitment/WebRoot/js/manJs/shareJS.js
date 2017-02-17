
//自动的下拉菜单
jQuery(document).ready(function($) {
	
	$("#navigation a").click(function(e){
		e.preventDefault();
		$(this).tab("show");
	})
    $(".index-btn").click(function(){//首页链接
        location.href = getRootPath()+"/manPage/indexManager.jsp";
    });
    $("#pub-ach-btn").click(function(){//发布成果展示链接
        location.href = getRootPath()+"/manPage/GeneralSituation/PublishAchievement.jsp";
    });
    $("#rev-ach-btn").click(function(){//修改成果展示链接
        location.href = getRootPath()+"/manPage/GeneralSituation/ReviseAchievement.jsp";
    });
    $("#pub-mem-btn").click(function(){//发布成员展示链接
        location.href = getRootPath()+"/manPage/GeneralSituation/PublishMember.jsp";
    });
    $("#rev-mem-btn").click(function(){//修改成员展示链接
        location.href = getRootPath()+"/manPage/GeneralSituation/ReviseMember.jsp";
    });
    $("#pub-info-btn").click(function(){//发布推送链接
        location.href = getRootPath()+"/manPage/GeneralSituation/PublishInformation.jsp";
    });
    $("#rev-info-btn").click(function(){//修改推送链接
        location.href = getRootPath()+"/manPage/GeneralSituation/ReviseInformation.jsp";
    });
    $("#pub-act-btn").click(function(){//发布康乐活动链接
        location.href = getRootPath()+"/manPage/GeneralSituation/PublishActivities.jsp";
    });
    $("#rev-act-btn").click(function(){//修改康乐活动链接
        location.href = getRootPath()+"/manPage/GeneralSituation/ReviseActivities.jsp";
    });
    $("#pub-com-btn").click(function(){//发布交流会链接
        location.href = getRootPath()+"/manPage/GeneralSituation/PublishCommunication.jsp";
    });
    $("#rev-com-btn").click(function(){//修改交流会链接
        location.href = getRootPath()+"/manPage/GeneralSituation/ReviseCommunication.jsp";
    });
    $("#pub-ann-btn").click(function(){//发布公告链接
        location.href = getRootPath()+"/manPage/InformationManage/PublishAnnouncement.jsp";
    });
    $("#rev-ann-btn").click(function(){//修改公告链接
        location.href = getRootPath()+"/admin/informationManagement/getAllTheNoticeAction";
    });
    $("#pub-rec-btn").click(function(){//发布招新信息链接
        location.href = getRootPath()+"/manPage/InformationManage/PublishRecruitment.jsp";
    });
    $("#rev-rec-btn").click(function(){//修改招新信息链接
        location.href = getRootPath()+"/admin/informationManagement/getAllTheRecruitmentAction";
    });
    $("#mess-reply-btn").click(function(){//留言回复链接
        location.href = getRootPath()+"/manPage/MessageReply.jsp";
    });
    $("#exa-topic-man-btn").click(function(){//试题管理链接
        location.href = getRootPath()+"/admin/examination_manager/getALLTheExaminationQuestionsAction";
    });
    $("#che-res-btn").click(function(){//查看考试结果链接
        location.href = getRootPath()+"/manPage/ExamManage/CheckResult.jsp";
    });
    $("#ent-stu-res-btn").click(function(){//录入考生成绩链接
        location.href = getRootPath()+"/manPage/ExamManage/EnterStuResult.jsp";
    });
    $("#pub-exam-mess-btn").click(function(){//考试信息管理链接
        location.href = getRootPath()+"/admin/examination_manager/getAllInformationForExamAction";
    });
    $("#registration-mess-btn").click(function(){//导出报名信息链接
    	
    	$.ajax({
    		type: "POST",
    		url: getRootPath() + "/admin/examination_manager/exportTheApplicationFromAction",
    		dataType: "HTML",
    		data:{},
    		success: function(address){				//返回zip文件的位置
    			if(address == "failure"){
    				swal({
					title: "导出失败",  
					text: "当前报名人数为0",
					type: "error",   
					confirmButtonColor: "#DD6B55",   
					confirmButtonText: "确认",   
					closeOnConfirm: false
					});	
    			}else{
					window.location.href=getRootPath() + address;
    				
    			}
    		}
    		
    	});
    	
        
    });
    $("#download-result").click(function(){//下载成绩单链接
        alert("确定下载吗？？？？");
        alert("然而并不能");
        alert("去淘宝玩玩吧");
//        location.href = "http://www.taobao.com";
    });

    
 	
    
     $("#adminLogout-btn").click(function(){					//注销登陆
    	
    		$.ajax({
    			type: "POST",
				url: getRootPath() + "/admin/userInfo/adminLogoutAction",
				dataType: "HTML",
				data: {},
				success: function(result){

							if(result == "success") 
								swal({
								title: "注销成功",  
								text: "You account has been logouted!",
								type: "success",   
								confirmButtonColor: "#DD6B55",   
								confirmButtonText: "确认",   
								closeOnConfirm: false
								},
								function(){
									window.location.href = getRootPath() + "/manPage/LoginManager.jsp";
								}
							);
					
						}
    			
    			
    		});
    	
    });
    
    

   var viewUpdata = setInterval(" pageviews()",5000);
});
		
	    
     function pageviews(){										//浏览量检测(要定时执行)

    	$.ajax({
    		type: "POST",
				url: getRootPath() + "/admin/informationManagement/getTheNewestPageViewsAction",
				dataType: "HTML",
				data: {},
				success: function(data){
					
							$("#pageviews-btn").text("浏览量:" + data);			
					
						}
    	});	
    };

    function getRootPath() {
        //获得根目录
        var strFullPath = window.document.location.href;
        var strPath = window.document.location.pathname;
        var pos = strFullPath.indexOf(strPath); 
        var prePath = strFullPath.substring(0, pos); 
        var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1); 
        return (prePath + postPath);
    }
