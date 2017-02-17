package com.gdut.ds.service;

import java.util.List;

import com.gdut.ds.beans.word.LeavingWord;

public interface LeavingWordService {
	
	
	//发送的留言保存在数据库中
	public void send(String name,String QQ,String email,String content);
	
	//分页查询没有回答的留言
	public List<LeavingWord> get(int currentPage);
	
	//发送邮件
	LeavingWord sendEmails(String leavingWordsId, String answer);
	
	Long getCount();
}
