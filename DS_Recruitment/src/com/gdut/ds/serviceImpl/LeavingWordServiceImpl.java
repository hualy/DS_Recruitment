package com.gdut.ds.serviceImpl;

import java.util.List;

import com.gdut.ds.beans.word.LeavingWord;
import com.gdut.ds.dao.word.LeavingWordDao;
import com.gdut.ds.service.LeavingWordService;
import com.gdut.ds.utils.Mail;

public class LeavingWordServiceImpl implements LeavingWordService {
	
	private LeavingWord leavingWord;
	
	private LeavingWordDao leavingWordDao;
	
	private static final int pageSize = 10;
	
	
	private  static final String title = "来自DS工作室对你的留言的回复";
	
	
	
	
	public LeavingWord getLeavingWord() {
		return leavingWord;
	}

	public void setLeavingWord(LeavingWord leavingWord) {
		this.leavingWord = leavingWord;
	}

	public LeavingWordDao getLeavingWordDao() {
		return leavingWordDao;
	}

	public void setLeavingWordDao(LeavingWordDao leavingWordDao) {
		this.leavingWordDao = leavingWordDao;
	}
	
	
	//保存用户发送给管理员的留言
	
	public void send(String name, String QQ, String email, String content) {
		
		leavingWord.setAnswerOrNot(false);		//设置此留言没有被管理员回答
		
		leavingWord.setQQ(QQ);					//设置留言者QQ
		
		leavingWord.setEmail(email);			//设置留言者email
		
//		System.out.println("name"+name);
		
		leavingWord.setName(name);				//设置留言者姓名
		
		leavingWord.setContent(content);		//设置留言者内容
		
		leavingWordDao.save(leavingWord);		//保存在数据库中
			

	}
	
	
	//分页查询还没有被回答的留言
	public List<LeavingWord> get(int currentPage) {
		
		if(currentPage<=0) return null;
		
		return  leavingWordDao.findByPage("from LeavingWord l where l.answerOrNot = 0", (currentPage-1)*pageSize,pageSize);
		
		
	}
	
	
	
	//发送邮件的方法
	public LeavingWord sendEmails(String leavingWordsId, String answer) {
		
		
		LeavingWord lw = leavingWordDao.get(LeavingWord.class, leavingWordsId);		//得到的是留言
		
		if(lw==null) return null;
		
		//List<String> emails = new ArrayList<String>(lws.size()); 		//存储邮箱地址
		
//		for(LeavingWord l:lws){
//			if(null!=l.getEmail())
//				emails.add(l.getEmail());
//			else emails.add(l.getQQ()+"@qq.com");
//			
//			l.setAnswerOrNot(true);
//		}
		
		
		lw.setAnswerOrNot(true);
		
		answer="您的问题："+lw.getContent()+"<br/>\r"+"DS回答："+answer;
		
		new Mail(lw.getEmail(), title, answer).start();		//发送邮件
		
	   leavingWordDao.update(lw);				//更新已经回答的留言
	   return lw;
	}

	//得到总数
	public Long getCount() {
		
	return (Long)leavingWordDao.findCount("select count(*) from LeavingWord l where l.answerOrNot=?", false);
	
	}
}
