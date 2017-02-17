package com.gdut.ds.action.introduction;

import java.io.File;
import java.util.List;
import java.util.Set;


import com.gdut.ds.beans.introduction.Image;
import com.gdut.ds.service.ResultService;
import com.gdut.ds.utils.ImageFunction;
import com.gdut.ds.utils.RealPathUtil;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateResultAction extends ActionSupport {
	
	private String resultId;		//由客户端返回的更新的数据
	
	private String date;				//日期
	private String theme;				//主题
	private int type;				//成果类型
	private String description;		//描述,里面应该用<image标签来标记图片>
	private String savePath;		//文件保存的主路径，在struts2的参数设置
	private String leaderName;     //组长
	private String membersName;		//成员
	private boolean resetPicture;		//是否重置图片
	
	private String message;				//返回给前端的一些信息
	    
	private List<File> files;					//struts2传来的文件
    private List<String> filesFileName;			//struts2传来的文件名
    private List<String> filesContentType;		//struts2传来的文件类型
    
    private ImageFunction imageFunction;  //文件处理类，由spring注入
    
    private ResultService resultService;		//更新处理的service类

	public String getResultId() {
		return resultId;
	}

	public void setResultId(String resultId) {
		this.resultId = resultId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public String getMembersName() {
		return membersName;
	}

	public void setMembersName(String membersName) {
		this.membersName = membersName;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public List<String> getFilesFileName() {
		return filesFileName;
	}

	public void setFilesFileName(List<String> filesFileName) {
		this.filesFileName = filesFileName;
	}

	public List<String> getFilesContentType() {
		return filesContentType;
	}

	public void setFilesContentType(List<String> filesContentType) {
		this.filesContentType = filesContentType;
	}

	public ImageFunction getImageFunction() {
		return imageFunction;
	}

	public void setImageFunction(ImageFunction imageFunction) {
		this.imageFunction = imageFunction;
	}
    
	
	public ResultService getResultService() {
		return resultService;
	}

	public void setResultService(ResultService resultService) {
		this.resultService = resultService;
	}

	public boolean isResetPicture() {
		return resetPicture;
	}

	public void setResetPicture(boolean resetPicture) {
		System.out.println("resetPicture:"+resetPicture);
		this.resetPicture = resetPicture;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
    public String execute() throws Exception {
		
		if(date==null||"".equals(date.trim())){
			message="日期不能为空";
			return INPUT;
		}
		if(theme==null||"".equals(theme.trim())){
			message="主题不能为空";
			return INPUT;
		}
		if(leaderName==null||"".equals(leaderName.trim())){
			message="组长姓名不能为空";
			return INPUT;
		}
		if(membersName==null||"".equals(membersName.trim())){
			message="成员姓名不能为空";
			return INPUT;
		}
		if(description==null||"".equals(description.trim())){
			message="描述不能为空";
			return INPUT;
		}
		
		if(resultId==null){
			message="内容不合法";
			return INPUT;
		}
		
		Set<Image> images = null;
		if(resetPicture){
				images  =  imageFunction.deal(files, filesContentType, 
    			Image.TYPE_RESULT, savePath,RealPathUtil.getRealPath());
    	}
    	resultService.updateResult(resultId, theme, leaderName, membersName, date, type, description,resetPicture, images);
    	message="更新成功";
    	return SUCCESS;
    }
	
}
