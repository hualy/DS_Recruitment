package com.gdut.ds.action.introduction;

import java.io.File;
import java.util.List;
import java.util.Set;


import com.gdut.ds.beans.introduction.Image;
import com.gdut.ds.service.ResultService;
import com.gdut.ds.utils.ImageFunction;
import com.gdut.ds.utils.RealPathUtil;
import com.opensymphony.xwork2.ActionSupport;

public class CreateResultAction extends ActionSupport {
	
    private String date;				//日期
    private String theme;				//主题
    private int optionsRadios;			//成果类型
    private String description;		//描述,里面应该用<image标签来标记图片>
    private String savePath;		//文件保存的主路径，在struts2的参数设置
    private String leaderName;     //组长
    private String membersName;		//成员
    
    private String message;			//返回给前端的一些信息
    
    private List<File> files;					//struts2传来的文件
    private List<String> filesFileName;			//struts2传来的文件名
    private List<String> filesContentType;		//struts2传来的文件类型
   
    private ImageFunction imageFunction;  //文件处理类，由spring注入
    
    private ResultService resultService;	//service层处理创建的result
    
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
	
	public int getOptionsRadios() {
		return optionsRadios;
	}
	public void setOptionsRadios(int optionsRadios) {
		this.optionsRadios = optionsRadios;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	
	
	
	public ResultService getResultService() {
		return resultService;
	}
	public void setResultService(ResultService resultService) {
		this.resultService = resultService;
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
		
//		if(RealPathUtil.getRealPath()==null)
//			RealPathUtil.setRealPath(ServletActionContext.getRequest().getRealPath("."));
		
//		System.out.println("action realPath:"+realPath);
		
		Set<Image> images = imageFunction.deal(files, filesContentType,		//储存图片的路径信息和支持储存图片 
				Image.TYPE_RESULT, savePath,RealPathUtil.getRealPath());
		
		//description = "第一张图片<image/>;第二张图片<image/>;第三张图片<image/>;第四张图片<image/>;第五张图片<image/>;第六张图片<image/>;第七张图片<image/>;"; 
	
		
		resultService.createResult(theme, leaderName, membersName, 
										date, optionsRadios, description, images);
		
		message="创建成果成功";
		
		return SUCCESS;
	}
	
}








