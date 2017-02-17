package com.gdut.ds.action.introduction;




import com.gdut.ds.service.MemberService;
import com.opensymphony.xwork2.ActionSupport;

public class CreateMemberAction extends ActionSupport {
	
	
	private String name;		//姓名
    private boolean female;    //性别是否为女性
    private int majorOnDs;		//主攻方向
    private String major;		//专业
    private int cla;		//班级
    private int grade;		//年级
    private String description;		//一些描述,介绍
    private String leavingWord;	//一些留言
    
    private String imagePath;

    private String savePath;		//文件保存的主路径，在struts2的参数设置
    
    private String message;			//
   
//    private File file;					//struts2传来的文件
//    private String fileFileName;			//struts2传来的文件名
//    private String fileContentType;		//struts2传来的文件类型
   
//    private ImageFunction imageFunction;  //文件处理类，由spring注入
    
    private MemberService memberService;	//service层处理创建的Member
    
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isFemale() {
		return female;
	}


	public void setFemale(boolean female) {
		this.female = female;
	}
	public int getMajorOnDs() {
		return majorOnDs;
	}
	public void setMajorOnDs(int majorOnDs) {
		this.majorOnDs = majorOnDs;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getCla() {
		return cla;
	}
	public void setCla(int cla) {
		this.cla = cla;
	}
	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getLeavingWord() {
		return leavingWord;
	}


	public void setLeavingWord(String leavingWord) {
		this.leavingWord = leavingWord;
	}


	public String getSavePath() {
		return savePath;
	}


	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}


	
	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	public MemberService getMemberService() {
		return memberService;
	}


	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}


	
//	public ImageFunction getImageFunction() {
//		return imageFunction;
//	}
//
//
//	public void setImageFunction(ImageFunction imageFunction) {
//		this.imageFunction = imageFunction;
//	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String execute() throws Exception {
		
//		if(RealPathUtil.getRealPath()==null)
//			RealPathUtil.setRealPath(ServletActionContext.getRequest().getRealPath("."));
		
//		Image image = imageFunction.dealImageForMember(file, fileContentType, Image.TYPE_MEMBER, savePath,RealPathUtil.getRealPath());
		
		//description = "第一张图片<image/>;第二张图片<image/>;第三张图片<image/>;第四张图片<image/>;第五张图片<image/>;第六张图片<image/>;第七张图片<image/>;"; 
		
		if(name==null||"".equals(name.trim())){
			message="姓名不能为空";
			return INPUT;
		}
		if(major==null||"".equals(major.trim())){
			message="专业不能为空";
			return INPUT;
		}
		
		
		memberService.createMember(name, female, majorOnDs, major, grade, cla, description, imagePath, leavingWord, savePath);
		
		message="创建成员成功";
		
		return SUCCESS;
	}
	
}








