package com.gdut.ds.beans.word;



/**
 * 常规问题
 */
public class Question  implements java.io.Serializable {


     private String id;					//id
     private String problem;			//问题
     private String answer;				//答案
     private Integer type;				//问题的类型

    public Question() {
    }

    public Question(String problem, String answer, Integer type) {
       this.problem = problem;
       this.answer = answer;
       this.type = type;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getProblem() {
        return this.problem;
    }
    
    public void setProblem(String problem) {
        this.problem = problem;
    }
    public String getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }




}


