package com.gdut.ds.action.examination.manager;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.gdut.ds.serviceImpl.ExaminationServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteTheSetOfExaminationQuestionsAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String id;
	
	private ExaminationServiceImpl examinationService;
	
	
	@JSON(serialize=false)
	public ExaminationServiceImpl getExaminationService() {
		return examinationService;
	}

	public void setExaminationService(ExaminationServiceImpl examinationService) {
		this.examinationService = examinationService;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		
		String result = "success";
		
		examinationService.deleteASetOfQuestions(Integer.parseInt(id));
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		int num = (Integer) session.get("examsum");
		num--;
		session.put("examsum", num);
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		
		PrintWriter pw = response.getWriter();
		pw.print(result);
		pw.flush();
		pw.close();
		
		return SUCCESS;
	}
}
