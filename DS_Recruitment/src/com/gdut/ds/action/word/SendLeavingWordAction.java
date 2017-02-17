package com.gdut.ds.action.word;


import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gdut.ds.service.LeavingWordService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class SendLeavingWordAction extends ActionSupport {
	
	private String code;
	
	private String name;		//留言者姓名
	
	private String QQ;			//留言者QQ
	
	private String email;		//留言者邮箱
	
	private String content;		//留言者内容
	
	private LeavingWordService leavingWordService;		//处理相关的逻辑Service层
	
	private String message;
	
	private Gson gson;
	
	

	public void setMessage(String message) {
		this.message = message;
	}

	
	public void setCode(String code) {
		this.code = code;
	}

	public void setGson(Gson gson) {
		this.gson = gson;
	}

	public void setName(String name) {
//		try {
//			name = new String(name.getBytes("iso-8859-1"), "utf8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		this.name = name;
	}

	
	public void setQQ(String qQ) {
		QQ = qQ;
	}

	

	public void setEmail(String email) {
		this.email = email;
	}

	
	public void setContent(String content) {
//		System.out.println(content);
//		try {
//			content = new String(content.getBytes("iso-8859-1"), "utf8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		this.content = content;
//		System.out.println(content);
	}
	
	

	public void setLeavingWordService(LeavingWordService leavingWordService) {
		this.leavingWordService = leavingWordService;
	}
	
	@Override
	public void validate() {
		if(QQ==null||email==null){
			return;
		}
		if(!QQ.matches("^\\d{5,}$")){
			addActionError("QQ should be number");
			//System.out.println("QQ should be number");
		}
		if(email.lastIndexOf('@')==-1||email.lastIndexOf(".com")==-1){
			addActionError("email should be right format");
			//System.out.println("email should be right format");
		}
	}

	@Override
	public String execute() throws Exception {
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		String rightCode = (String)ServletActionContext.getRequest().getSession().getAttribute("checkCode");
		
		
		resp.setContentType("application/json;charset=utf-8");			//这个是错误的
		resp.setHeader("pragma", "no-cache");
		resp.setHeader("cache-control","no-cache");
		
		if(rightCode==null||!rightCode.toLowerCase().equals(code.toLowerCase()))
			message="验证码不正确";
		
		
		
		
		if(name==null||"".equals(name.trim())){
			message = "名字不能为空";
			
		}
		if(QQ==null||"".equals(QQ.trim())){
			message = "名字不能为空";
			
		}
		if(email==null||"".equals(email.trim())){
			message = "邮箱不能为空";
			
		}
		if(content==null||"".equals(content.trim())){
			message = "名字不能为空";
			
		}
		
//		System.out.println(name);
//		System.out.println(QQ);
//		System.out.println(email);
//		System.out.println(content);
		if(message!=null){
			resp.getWriter().write(gson.toJson(message));
			resp.getWriter().flush();
			resp.getWriter().close();
			return INPUT;
		}
		leavingWordService.send(name, QQ, email, content);
		message="留言成功";
		
		resp.getWriter().write(gson.toJson(message));
		resp.getWriter().flush();
		resp.getWriter().close();
		return SUCCESS;
		
	}

}
