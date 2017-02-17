package com.gdut.ds.action.word;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.gdut.ds.beans.word.Question;
import com.gdut.ds.service.QuestionService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class GetQuestionAction extends ActionSupport {
	
	private int currentPage;			//由客户端返回的当前页数
	
	private List<Question> questions;	//返回给客户端的常规问题列表
	
	private QuestionService questionService;
	
	private Gson gson;
	@JSON(serialize=false)
	public int getCurrentPage() {
		return currentPage;
	}
	
	
	@JSON(serialize=false)
	public Gson getGson() {
		return gson;
	}



	public void setGson(Gson gson) {
		this.gson = gson;
	}



	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	@JSON(serialize=false)
	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	@JSON(serialize=false)
	public QuestionService getQuestionService() {
		return questionService;
	}

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	@Override
	public String execute() throws Exception {
		
		questions = questionService.findByPage(currentPage);
		
		Long countAll = questionService.getCount();
		
		List l = new ArrayList();
		
		l.add(questions);
		l.add(countAll);
		
		String result = gson.toJson(l);
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		
		resp.setHeader("param", "no-cache");
		resp.setHeader("cache-control", "no-cache");
		resp.setContentType("application/json;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		out.write(result);
		out.flush();
		out.close();
		
//		for(Question q:questions){
//			System.out.println(q.getId());
//		}
		
		return SUCCESS;
		
	}
	

}
