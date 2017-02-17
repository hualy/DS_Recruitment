package com.gdut.ds.action.word;

import com.gdut.ds.beans.word.LeavingWord;
import com.gdut.ds.service.LeavingWordService;
import com.gdut.ds.service.QuestionService;
import com.opensymphony.xwork2.ActionSupport;

public class AnswerForLeavingWord extends ActionSupport {
	
	private String leavingWordId;		//一些要回复留言的id
	
	private boolean setAsQuestion;				//是否设置为常规问题
	
	
	private String answer;						//回答
	
	private QuestionService questionService;	
	
	private LeavingWordService leavingWordService;

	public QuestionService getQuestionService() {
		return questionService;
	}

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	public LeavingWordService getLeavingWordService() {
		return leavingWordService;
	}

	public void setLeavingWordService(LeavingWordService leavingWordService) {
		this.leavingWordService = leavingWordService;
	}

	public String getLeavingWordId() {
		return leavingWordId;
	}

	public void setLeavingWordId(String leavingWordId) {
		this.leavingWordId = leavingWordId;
	}

	public boolean isSetAsQuestion() {
		return setAsQuestion;
	}

	public void setSetAsQuestion(boolean setAsQuestion) {
		this.setAsQuestion = setAsQuestion;
//		System.out.println(setAsQuestion);
	}


	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
//try {
//			answer = new String(answer.getBytes("iso-8859-1"),"utf-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		System.out.println("answer:"+answer);
		this.answer = answer;
	}
	
	@Override
	public String execute() throws Exception {
		
		LeavingWord lw = leavingWordService.sendEmails(leavingWordId, answer);
		
		if(setAsQuestion) questionService.setQuestion(lw.getContent(), answer);
		
		return SUCCESS;
		
	}
	
}
