package com.gdut.ds.serviceImpl;


import java.util.List;

import com.gdut.ds.beans.word.Question;
import com.gdut.ds.dao.word.LeavingWordDao;
import com.gdut.ds.dao.word.QuestionDao;
import com.gdut.ds.service.QuestionService;
import com.gdut.ds.utils.Mail;

public class QuestionServiceImpl implements QuestionService {
	
	private static final int pageSize = 4; //查看常规问题的页面问题数
	
	private QuestionDao questionDao;			//由spring 注入
	private LeavingWordDao leavingWordDao;		//由spring注入
	private Question question;					//由spring注入
		
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public QuestionDao getQuestionDao() {
		return questionDao;
	}

	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	public LeavingWordDao getLeavingWordDao() {
		return leavingWordDao;
	}

	public void setLeavingWordDao(LeavingWordDao leavingWordDao) {
		this.leavingWordDao = leavingWordDao;
	}
	

	public void setQuestion(String problem, String answer) {
	
			question.setAnswer(answer);				//设置回答
			question.setProblem(problem);			//设置问题
			questionDao.save(question);				//保存到数据库当中
		
	}

	public List<Question> findByPage(int currentPage) {
		
		if(currentPage<=0) return null;
		
		return questionDao.findByPage(" from Question q ", (currentPage-1)*pageSize,pageSize);
		
	}

	public Long getCount() {
		return questionDao.findCount(Question.class);
	}

}
