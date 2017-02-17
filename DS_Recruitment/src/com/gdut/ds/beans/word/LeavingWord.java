package com.gdut.ds.beans.word;



/**
 * 留言
 */
public class LeavingWord  implements java.io.Serializable {
	

     private String id;					//id
     private String name;				//姓名
     private String QQ;					//QQ
     private String email;				//邮箱
     private String content;			//内容
     private boolean answerOrNot;		//是否已经回答

    public LeavingWord() {
    }

    public LeavingWord(String name, String QQ, String email, String content, boolean answerOrNot) {
       this.name = name;
       this.QQ = QQ;
       this.email = email;
       this.content = content;
       this.answerOrNot = answerOrNot;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getQQ() {
        return this.QQ;
    }
    
    public void setQQ(String QQ) {
        this.QQ = QQ;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
  
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    public boolean isAnswerOrNot() {
        return this.answerOrNot;
    }
    
    public void setAnswerOrNot(boolean answerOrNot) {
        this.answerOrNot = answerOrNot;
    }




}


