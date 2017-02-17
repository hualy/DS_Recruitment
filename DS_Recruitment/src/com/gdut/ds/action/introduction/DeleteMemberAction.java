package com.gdut.ds.action.introduction;


import com.gdut.ds.service.MemberService;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteMemberAction extends ActionSupport {
	
	private String memberId;
	private MemberService memberService;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
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
		
		if(null==memberId){
			return INPUT;
		}
		
		memberService.deleteMember(memberId);
		
		return SUCCESS;
	}
	
	
}
