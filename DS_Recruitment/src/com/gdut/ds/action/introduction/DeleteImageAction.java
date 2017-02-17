package com.gdut.ds.action.introduction;


import com.gdut.ds.service.ImageService;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteImageAction extends ActionSupport {
	private String imageId;
	
	private ImageService imageService;

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public ImageService getImageService() {
		return imageService;
	}

	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}

	@Override
	public String execute() throws Exception {
		
//		if(RealPathUtil.getRealPath()==null)
//			RealPathUtil.setRealPath(ServletActionContext.getRequest().getRealPath("."));
		
		if(imageId==null) return INPUT;
		
		imageService.deleteImage(imageId);
		
		return SUCCESS;
	}
	
}
