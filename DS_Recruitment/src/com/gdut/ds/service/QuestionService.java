package com.gdut.ds.service;

import java.util.List;

import com.gdut.ds.beans.word.Question;

public interface QuestionService {
	
	void setQuestion(String question,String answer);
	
	List<Question> findByPage(int currentPage);
	
	
	
	Long getCount();
	
}
