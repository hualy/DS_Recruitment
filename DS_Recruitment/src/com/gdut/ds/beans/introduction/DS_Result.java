package com.gdut.ds.beans.introduction;


import java.util.HashSet;
import java.util.Set;

/**
 * 工作室成果展示
 */
public class DS_Result  implements java.io.Serializable {
	
	public static final int TYPE_MATCH = 0;			//成果类型为比赛
	public static final int TYPE_PROJECT =1;		//成果类型为项目
	
     private String id;					//id
     private String date;				//日期
     private String theme;				//主题
     private int type;				//成果类型
     private String leaderName;		//组长姓名
     private String membersName;	//成员姓名	
     private String description;		//描述
     private Set<Image> images = new HashSet<Image>(0);	//图片

    public DS_Result() {
    }

    
    public DS_Result(String id, String theme, String date, int type) {
		this.id = id;
		this.date = date;
		this.theme = theme;
		this.type = type;
	}


	public DS_Result(String date, String theme, int type,String leaderName,String membersName, String description, Set<Image> images) {
       this.date = date;
       this.theme = theme;
       this.type = type;
       this.description = description;
       this.images = images;
       this.leaderName = leaderName;
       this.membersName = membersName;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    public String getTheme() {
        return this.theme;
    }
    
    public void setTheme(String theme) {
        this.theme = theme;
    }
    public int getType() {
        return this.type;
    }
    
    public void setType(int type) {
        this.type = type;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Set<Image> getImages() {
        return this.images;
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

	public void setImages(Set<Image> images) {
        this.images = images;
    }




}


