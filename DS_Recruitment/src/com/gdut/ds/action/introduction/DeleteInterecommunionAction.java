package com.gdut.ds.action.introduction;


import com.gdut.ds.service.InterecommunionService;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteInterecommunionAction extends ActionSupport {
	
	private String interecommunionId;
	private InterecommunionService interecommunionService;
	
	public String getInterecommunionId() {
		return interecommunionId;
	}
	
	public void setInterecommunionId(String interecommunionId) {
		this.interecommunionId = interecommunionId;
	}
	
	public InterecommunionService getInterecommunionService() {
		return interecommunionService;
	}
	
	public void setInterecommunionService(
			InterecommunionService interecommunionService) {
		this.interecommunionService = interecommunionService;
	}

	@Override
	public String execute() throws Exception {
		
//		if(RealPathUtil.getRealPath()==null)
//			RealPathUtil.setRealPath(ServletActionContext.getRequest().getRealPath("."));
		
		if(interecommunionId==null) return INPUT;
		
		interecommunionService.deleteInterecommunion(interecommunionId);
		
		return SUCCESS;
	}
	
	
}
