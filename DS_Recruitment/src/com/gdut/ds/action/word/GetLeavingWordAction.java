package com.gdut.ds.action.word;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.http.HttpRequest;

import com.gdut.ds.beans.word.LeavingWord;
import com.gdut.ds.service.LeavingWordService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class GetLeavingWordAction extends ActionSupport {
	
	private int currentPage;						//当前页面
	
	private LeavingWordService leavingWordService;	
	
	private List<LeavingWord> leavingWords;			//返回给客户端的留言
	
	private Long countAll;							//返回给客户端的总数
	
	private Gson gson;	
	
	@JSON(serialize=false)
	public Gson getGson() {
		return gson;
	}

	public void setGson(Gson gson) {
		this.gson = gson;
	}
	@JSON(serialize=false)
	public Long getCountAll() {
		return countAll;
	}
	
	public void setCountAll(Long countAll) {
		this.countAll = countAll;
	}
	@JSON(serialize=false)
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	@JSON(serialize=false)
	public LeavingWordService getLeavingWordService() {
		return leavingWordService;
	}

	public void setLeavingWordService(LeavingWordService leavingWordService) {
		this.leavingWordService = leavingWordService;
	}
	@JSON(serialize=false)
	public List<LeavingWord> getLeavingWords() {
		return leavingWords;
	}

	public void setLeavingWords(List<LeavingWord> leavingWords) {
		this.leavingWords = leavingWords;
	}
	

	@Override
	public String execute() throws Exception {
		
		
		leavingWords = leavingWordService.get(currentPage);		//得到留言
		
		countAll = leavingWordService.getCount();
		
		List list = new ArrayList();
		
		list.add(leavingWords);
		list.add(countAll);
		
		String result = gson.toJson(list);
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		
		resp.setHeader("param", "no-cache");
		resp.setHeader("cache-control", "no-cache");
		resp.setContentType("application/json;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		out.write(result);
		out.flush();
		out.close();
		
		
		
		
//		for(LeavingWord l:leavingWords){
//			System.out.println(l.getContent());
//		}
		
		return SUCCESS;
	}

}
