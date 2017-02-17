package com.gdut.ds.action.examination.manager;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.gdut.ds.beans.examination.ExaminationQuestions;
import com.gdut.ds.beans.examination.FillInTheBlank;
import com.gdut.ds.beans.examination.MultipleChoice;
import com.gdut.ds.beans.examination.ProceduralQuestions;
import com.gdut.ds.serviceImpl.ExaminationServiceImpl;
import com.gdut.ds.utils.ExamTools;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddASetOfExaminationQuestionsAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String name;
	
	private String setID;
	
	private String[] mtitle;
	
	private String[] optionA;
	
	private String[] optionB;
	
	private String[] optionC;
	
	private String[] optionD;
	
	private String[] mrightAnswer;
	
	private String mscore;
	
	private String[] ftitle;
	
	private String[] frightAnswer;
	
	private String[] frightAnswernums;
	
	private String fscore;
	
	private String[] ptitle;
	
	private String pscore;
	
	private ExaminationQuestions examinationQuestions;
	
	private List<MultipleChoice> mList;
	
	private List<FillInTheBlank> fList;
	
	private List<ProceduralQuestions> pList;
	
	private ExaminationServiceImpl examinationService;

	
	public String[] getFrightAnswernums() {
		return frightAnswernums;
	}

	public void setFrightAnswernums(String[] frightAnswernums) {
		this.frightAnswernums = frightAnswernums;
	}

	public String getMscore() {
		return mscore;
	}

	public void setMscore(String mscore) {
		this.mscore = mscore;
	}

	public String getFscore() {
		return fscore;
	}

	public void setFscore(String fscore) {
		this.fscore = fscore;
	}

	public String getPscore() {
		return pscore;
	}

	public void setPscore(String pscore) {
		this.pscore = pscore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSetID() {
		return setID;
	}

	public void setSetID(String setID) {
		this.setID = setID;
	}

	public String[] getMtitle() {
		return mtitle;
	}

	public void setMtitle(String[] mtitle) {
		this.mtitle = mtitle;
	}

	public String[] getOptionA() {
		return optionA;
	}

	public void setOptionA(String[] optionA) {
		this.optionA = optionA;
	}

	public String[] getOptionB() {
		return optionB;
	}

	public void setOptionB(String[] optionB) {
		this.optionB = optionB;
	}

	public String[] getOptionC() {
		return optionC;
	}

	public void setOptionC(String[] optionC) {
		this.optionC = optionC;
	}

	public String[] getOptionD() {
		return optionD;
	}

	public void setOptionD(String[] optionD) {
		this.optionD = optionD;
	}

	public String[] getMrightAnswer() {
		return mrightAnswer;
	}

	public void setMrightAnswer(String[] mrightAnswer) {
		this.mrightAnswer = mrightAnswer;
	}

	public String[] getFtitle() {
		return ftitle;
	}

	public void setFtitle(String[] ftitle) {
		this.ftitle = ftitle;
	}

	public String[] getFrightAnswer() {
		return frightAnswer;
	}

	public void setFrightAnswer(String[] frightAnswer) {
		this.frightAnswer = frightAnswer;
	}


	public String[] getPtitle() {
		return ptitle;
	}

	public void setPtitle(String[] ptitle) {
		this.ptitle = ptitle;
	}

	@JSON(serialize=false)
	public ExaminationQuestions getExaminationQuestions() {
		return examinationQuestions;
	}

	public void setExaminationQuestions(ExaminationQuestions examinationQuestions) {
		this.examinationQuestions = examinationQuestions;
	}

	@JSON(serialize=false)
	public ExaminationServiceImpl getExaminationService() {
		return examinationService;
	}

	public void setExaminationService(ExaminationServiceImpl examinationService) {
		this.examinationService = examinationService;
	}
	
	
	
	@Override
	public String execute() throws Exception {
	
		String[] fanswer = ExamTools.transfromAnswer(frightAnswer, frightAnswernums);//将每道选择题的答案分组
		
		System.out.println("选择题 "+ ftitle.length +" "+ fanswer.length + frightAnswer.length);
		
		examinationQuestions.setName(name);
		examinationQuestions.setSetID(Integer.parseInt(setID));
		examinationQuestions.setMscore(Integer.parseInt(mscore));
		examinationQuestions.setFscore(Integer.parseInt(fscore));
		examinationQuestions.setPscore(Integer.parseInt(pscore));
		
		mList = new ArrayList<MultipleChoice>();
		fList = new ArrayList<FillInTheBlank>();
		pList = new ArrayList<ProceduralQuestions>();
		
		
		for(int i = 0; i < mtitle.length; i++){
			
			MultipleChoice multipleChoice = new MultipleChoice(mtitle[i], optionA[i], optionB[i], 
					optionC[i], optionD[i], mrightAnswer[i],  examinationQuestions);
			mList.add(multipleChoice);
			
		}
		
		for(int j = 0; j < ftitle.length; j++){
			
			FillInTheBlank fillInTheBlank = new FillInTheBlank(ftitle[j], fanswer[j],  examinationQuestions);
			fList.add(fillInTheBlank);
		}
		
		for(int k = 0; k < ptitle.length; k++){
			
			ProceduralQuestions  proceduralQuestions = new ProceduralQuestions(ptitle[k],  examinationQuestions);
			pList.add(proceduralQuestions);
		}
		
		examinationQuestions.setMultipleChoiceList(mList);
		examinationQuestions.setFillInTheBlankList(fList);
		examinationQuestions.setProceduralQuestionsList(pList);
		
		examinationService.addASetOfQuestions(examinationQuestions);
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		int num = (Integer) session.get("examsum");
		num++;
		session.put("examsum", num);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		
		PrintWriter pw = response.getWriter();
		pw.print("success");
		pw.flush();
		pw.close();
		
		return SUCCESS;
	}
	
}
