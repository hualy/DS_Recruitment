package com.gdut.ds.action.introduction;

import java.io.File;


import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gdut.ds.utils.ImageFunction;
import com.gdut.ds.utils.RealPathUtil;
import com.opensymphony.xwork2.ActionSupport;

public class UpLoadMemberImageAction extends ActionSupport {
	
	private File file;
	private String fileFileName;
	private String fileContentType;
	
	private String savePath;		//由struts2注入
	
	private ImageFunction imageFunction;
	
	
	

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public ImageFunction getImageFunction() {
		return imageFunction;
	}

	public void setImageFunction(ImageFunction imageFunction) {
		this.imageFunction = imageFunction;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	@Override
	public String execute() throws Exception {
		
		

		
		String imagePath = imageFunction.dealImageTempForMember(file, fileContentType,savePath, RealPathUtil.getRealPath());
		
		HttpServletResponse  resp = ServletActionContext.getResponse();
		
		//resp.setCharacterEncoding("utf-8");
		
		resp.setHeader("param", "no-cache");
		resp.setHeader("cache-control", "no-cache");
		//resp.setContentType("application/json;");
		
		resp.getWriter().write("{\"imagePath\":\""+imagePath+"\"}");
		resp.getWriter().flush();
		resp.getWriter().close();
		
		return NONE;
		
	}
}
