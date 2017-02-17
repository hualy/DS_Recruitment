package com.gdut.ds.service;

import java.util.List;

import com.gdut.ds.beans.examination.ExamPaper;
import com.gdut.ds.beans.examination.ExaminationQuestions;
import com.gdut.ds.beans.examination.FillInTheBlank;
import com.gdut.ds.beans.examination.InformationForExam;
import com.gdut.ds.beans.examination.MultipleChoice;
import com.gdut.ds.beans.examination.ProceduralQuestions;
import com.gdut.ds.beans.examination.StudentAnswersANDGrade;

public interface ExaminationService {
	
	/*
	 * 网上笔试
	 */
	public ExaminationQuestions getASetOfExaminationQuestions(int id);			//从数据库获取套题
	
	public ExamPaper getTheExamPaper(ExaminationQuestions examinationQuestions);//根据套题随机组题
	
	public InformationForExam getTheNOTFinshedExamInfo();						//获取未考的考试信息
	
	public void submitExamPaper(ExamPaper examPaper);							//提交试卷
	
	
	
	
	
	/*
	 * 笔试管理
	 */
	
	public InformationForExam getTheInformationForExam(int id);						//根据id获取考试信息
	
	public void releaseTheInformationForExam(InformationForExam informationForExam);//发布（保存）考试信息
	
	public List<InformationForExam> getAllTheInformationForExam();					//获取考试信息
	
	public void modifyTheInformationForExam(InformationForExam informationForExam);//修改考试信息
	
	public List<ExaminationQuestions> getAllSetsOfExaminationQuestions();		//获取所有套题
	
	public ExaminationQuestions getASetOfExaminationQuestions(String name);		//根据试题名称获取
	
	public void reviseTheSetOfExaminationQuestions(ExaminationQuestions examinationQuestions);//更新某套试题
	
	public int getTheNumsOfExaminationQuestions();								//获取题库中的套题数
	
	public void addASetOfQuestions(ExaminationQuestions examinationQuestions);	//增加套题
	
	public void deleteASetOfQuestions(int id);									//删除套题
	
	public void addMultipleChoices(List<MultipleChoice> multipleChoiceList);	//增加选择题
	
	public void addFillInTheBlanks(List<FillInTheBlank> fillInTheBlankList);	//增加填空题
	
	public void addProceduralQuestions(List<ProceduralQuestions> proceduralQuestionsList);//增加程序题
	
	public void deleteMultipleChoice(MultipleChoice multipleChoice);			//删除指定选择题
	
	public void deleteFillInTheBlank(FillInTheBlank fillInTheBlank);			//删除指定填空题
	
	public void deleteProceduralQuestions(ProceduralQuestions proceduralQuestions);//删除指定程序题
	
	public void reviseMultipleChoice(MultipleChoice multipleChoice);			//修改指定选择题
	
	public void reviseFillInTheBlank(FillInTheBlank fillInTheBlank);			//修改指定填空题
	
	public void reviseProceduralQuestions(ProceduralQuestions proceduralQuestions);//修改指定程序题
	
	public MultipleChoice getMultipleChoice(int id);							//获取某套题的特定选择题
	
	public FillInTheBlank getFillInTheBlank(int id);							//获取某套题的特定填空题
	
	public ProceduralQuestions getProceduralQuestions(int id);					//获取某套题的特定程序题
	
	
	
	
	
	public List<StudentAnswersANDGrade> getTheReport();							//获得考生考试情况对象集合
	
	public void firstMarking(String[] multipleChoiceAnswer,String[] fillInTheBlankAnswer
			,StudentAnswersANDGrade stuGrade,ExamPaper examPaper);				//进行试卷的初评
	
	public void exportThePapers();												//导出初评后试卷到word进行人工评卷 
	
	public void scoringTheProceduralQuestions(int[] proceduralscores);			//进行程序题的评分
	
	public void exportReport();													//导出最终成绩单（已排好序的）
	
}
