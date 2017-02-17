package com.gdut.ds.action.introduction;


import com.gdut.ds.service.MemberService;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteMemberTempImageAction extends ActionSupport {
	
private MemberService memberService;

	
	

	public MemberService getMemberService() {
	return memberService;
}




public void setMemberService(MemberService memberService) {
	this.memberService = memberService;
}




	@Override
	public String execute() throws Exception {
		
//		if(RealPathUtil.getRealPath()==null)
//			RealPathUtil.setRealPath(ServletActionContext.getRequest().getRealPath("."));
		
		memberService.deleteTempImage();
		
		return SUCCESS;
	}
	
	
}
