package com.gdut.ds.beans.introduction;
/**
 * 图片
 */
public class Image  implements java.io.Serializable {
	
	public static final int TYPE_RESULT = 0;
	public static final int TYPE_ARTICLE = 1;
	public static final int TYPE_ACTIVITY =2;
	public static final int TYPE_INTERECOMMUNION = 3;
	public static final int TYPE_MEMBER =4;
	
	private static  String contentPath ;
	public static final String imageLabel = "<image/>";
	
	
	
     private String id;					//id	
     private String path;				//图片所在路径
     private int type;					//图片类型
     private DS_Activity activity;		//活动的图片
     private DS_Result result;			//成果图片
     //private DS_Article article;		//文章图片
     private DS_Interecommunion interecommunion;	//交流会图片
     
     private DS_Member member;			//成员 

    public Image() {
    }

    public Image(DS_Member member,String path,int type,DS_Interecommunion interecommunion, DS_Activity activity, DS_Result result) {
       this.path = path;
       this.type = type;
       this.interecommunion = interecommunion;
       this.activity = activity;
       this.result = result;
       //this.article = article;
       this.member = member;
    }
    
   
    public DS_Member getMember() {
		return member;
	}

	public void setMember(DS_Member member) {
		this.member = member;
	}

	public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getPath() {
        return this.path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    
    
    public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public DS_Interecommunion getInterecommunion() {
		return interecommunion;
	}

	public void setInterecommunion(DS_Interecommunion interecommunion) {
		this.interecommunion = interecommunion;
	}

	public DS_Activity getActivity() {
        return this.activity;
    }
    
    public void setActivity(DS_Activity activity) {
        this.activity = activity;
    }
    public DS_Result getResult() {
        return this.result;
    }
    
    public void setResult(DS_Result result) {
        this.result = result;
    }
   

	public static String getContentPath() {
		return contentPath;
	}

	public static void setContentPath(String contentPath) {
		Image.contentPath = contentPath;
	}

}


