package com.gdut.ds.action.introduction;

import java.io.File;


import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gdut.ds.utils.ImageFunction;
import com.gdut.ds.utils.RealPathUtil;
import com.opensymphony.xwork2.ActionSupport;

public class UpLoadImageAction extends ActionSupport {
	
	private File filedata;
	private String filedataFileName;
	private String filedataContentType;
	
	private String savePath;		//由struts2注入
	
	private ImageFunction imageFunction;
	
	
	public File getFiledata() {
		return filedata;
	}

	public void setFiledata(File filedata) {
		this.filedata = filedata;
	}




	public ImageFunction getImageFunction() {
		return imageFunction;
	}

	public void setImageFunction(ImageFunction imageFunction) {
		this.imageFunction = imageFunction;
	}

	public String getFiledataFileName() {
		return filedataFileName;
	}

	public void setFiledataFileName(String filedataFileName) {
		this.filedataFileName = filedataFileName;
	}

	public String getFiledataContentType() {
		return filedataContentType;
	}

	public void setFiledataContentType(String filedataContentType) {
		this.filedataContentType = filedataContentType;
	}
	

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	@Override
	public String execute() throws Exception {
		
		
//		FileInputStream fis = new FileInputStream(filedata);
//		
//		File file = new File("E:\\Myeclipsecjf\\XhEditor\\WebRoot\\images\\"+"1111.jpg");
//		
//		FileOutputStream fos = new FileOutputStream(file);
//		
//		int c;
//		byte[] b = new byte[1024];
//		while((c=fis.read(b))!=-1){
//			fos.write(b, 0, c);
//		}
		
		String imagePath = imageFunction.dealImageForArticle(filedata, filedataContentType, savePath, RealPathUtil.getRealPath());
		
		HttpServletResponse  resp = ServletActionContext.getResponse();
		
		resp.setCharacterEncoding("utf-8");
		
		resp.getWriter().write("{\"err\":\"\",\"msg\":\""+imagePath+"\"}");
		
		resp.getWriter().close();
		
		return NONE;
		
	}
}
