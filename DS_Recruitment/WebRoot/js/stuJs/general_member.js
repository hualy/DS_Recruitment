
var getMemberFunction = function(majorOnDs){
	
	var panelBody ;
	switch(majorOnDs){
		case 1: panelBody= $("#collapseTwoSub > .panel-body");break;
		case 2:panelBody = $("#collapseThreeSub > .panel-body");break;
		case 3:panelBody = $("#collapseFourSub > .panel-body");break; 
		default:panelBody = $("#collapseOneSub > .panel-body");break; 
	}
		
	
	if(0==panelBody.children().length){
		$.post("user/introduction/getMembers",{"majorOnDs":majorOnDs},function(returnedData,status){
			
			var members = returnedData;
			
			if(members.length>0){
				for(var i=0;i<members.length;i++){
					var rowBot = $('<div class="row"></div>');
					
					var imageDiv = $('<div class="col-md-3 col-sm-3 peoImg"></div>');
					var img = $('<img style="width:100%;height:100%;"/>');
					img.attr("src",members[i].image);
					imageDiv.append(img);
					
					var parentDiv = $('<div class="col-md-9 col-sm-15"></div>');
					var memberDiv = $('<div class="info" style="margin-top: 10px;"></div>');
					memberDiv.append("<p>姓名："+members[i].name+"</p>");
					if(members[i].female){
						memberDiv.append("<p>性别：女</p>");
					}else{
						memberDiv.append("<p>性别：男</p>");
					}
					memberDiv.append("<p>专业："+members[i].major+"</p>");
					memberDiv.append("<p>"+members[i].grade+"("+members[i].cla+")</p>");
					memberDiv.append("<p>介绍："+members[i].description+"</p>");
					memberDiv.append("<p>留言："+members[i].leavingWord+"</p>");
					memberDiv.append();
					
					parentDiv.append(memberDiv);
					
					rowBot.append(imageDiv);
					rowBot.append(parentDiv);
					
					panelBody.append(rowBot);
					panelBody.append('<hr style="height:2px;background-color: #3caee7">');
				}
			}else{
				panelBody.append("<p>此方向没有成员<p>");
			}
			
			
		});
	}
}
