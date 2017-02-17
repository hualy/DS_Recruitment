package com.gdut.ds.beans.introduction;



/**
 * 工作室成员
 */
public class DS_Member  implements java.io.Serializable {

	
	 public static final int MAJOR_DM = 0 ;		//数据挖掘方向
	 public static final int MAJOR_COMPLIER = 1 ; //编译器方向
	 public static final int MAJOR_FRONTWeb = 2;  //前端方向
	 public static final int MAJOR_BACKGROUND = 3;//后台方向
	
     private String id;			//id
     private String name;		//姓名
     private boolean female;    //性别是否为女性
     private int majorOnDs;		//主攻方向
     private String major;		//专业
     private int cla;		// 班级
     private int grade;		//年级
     private String description;		//一些描述,介绍
     private String image;		//图片路径，放在
     private String leavingWord;	//一些留言
    public DS_Member(){
    	
    }
	public DS_Member(String id, String name, int cla, int grade) {
		super();
		this.id = id;
		this.name = name;
		this.cla = cla;
		this.grade = grade;
	}
	public DS_Member(String id, String name, boolean female, int majorOnDs,
			String major, int cla, int grade, String description, String image,
			String leavingWord) {
		super();
		this.id = id;
		this.name = name;
		this.female = female;
		this.majorOnDs = majorOnDs;
		this.major = major;
		this.cla = cla;
		this.grade = grade;
		this.description = description;
		this.image = image;
		this.leavingWord = leavingWord;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getLeavingWord() {
		return leavingWord;
	}
	public void setLeavingWord(String leavingWord) {
		this.leavingWord = leavingWord;
	}


}


