package com.gdut.ds.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.gdut.ds.beans.examination.ExamPaper;
import com.gdut.ds.beans.examination.ExaminationQuestions;
import com.gdut.ds.beans.examination.FillInTheBlank;
import com.gdut.ds.beans.examination.InformationForExam;
import com.gdut.ds.beans.examination.MultipleChoice;
import com.gdut.ds.beans.examination.ProceduralQuestions;
import com.gdut.ds.beans.examination.StudentAnswersANDGrade;
import com.gdut.ds.daoImpl.examination.ExamPaperDaoImpl;
import com.gdut.ds.daoImpl.examination.ExaminationQuestionsDaoImpl;
import com.gdut.ds.daoImpl.examination.FillInTheBlankDaoImpl;
import com.gdut.ds.daoImpl.examination.InformationForExamDaoImpl;
import com.gdut.ds.daoImpl.examination.MultipleChoiceDaoImpl;
import com.gdut.ds.daoImpl.examination.ProceduralQuestionsDaoImpl;
import com.gdut.ds.daoImpl.examination.StudentAnswersANDGradeDaoImpl;
import com.gdut.ds.service.ExaminationService;
import com.gdut.ds.utils.ExportGradeReport;
import com.gdut.ds.utils.ExportThePaper;
import com.gdut.ds.utils.RandomTool;

public class ExaminationServiceImpl implements ExaminationService {

	
	private MultipleChoiceDaoImpl multipleChoiceDao;
	
	private FillInTheBlankDaoImpl fillInTheBlankDao;
	
	private ProceduralQuestionsDaoImpl proceduralQuestionsDao;
	
	private InformationForExamDaoImpl informationForExamDao;
	
	private StudentAnswersANDGradeDaoImpl stuGradeDao;
	
	private ExamPaperDaoImpl examPaperDao;
	
	private ExamPaper examPaper;
	
	private ExaminationQuestions examinationQuestions;
	
	private ExaminationQuestionsDaoImpl examinationQuestionsDao;
	
	
	public ExaminationQuestionsDaoImpl getExaminationQuestionsDao() {
		return examinationQuestionsDao;
	}

	public void setExaminationQuestionsDao(
			ExaminationQuestionsDaoImpl examinationQuestionsDao) {
		this.examinationQuestionsDao = examinationQuestionsDao;
	}

	public void setExaminationQuestions(ExaminationQuestions examinationQuestions) {
		this.examinationQuestions = examinationQuestions;
	}

	public ExaminationQuestions getExaminationQuestions() {
		return examinationQuestions;
	}
	
	public StudentAnswersANDGradeDaoImpl getStuGradeDao() {
		return stuGradeDao;
	}


	public void setStuGradeDao(StudentAnswersANDGradeDaoImpl stuGradeDao) {
		this.stuGradeDao = stuGradeDao;
	}


	public ExamPaperDaoImpl getExamPaperDao() {
		return examPaperDao;
	}


	public void setExamPaperDao(ExamPaperDaoImpl examPaperDao) {
		this.examPaperDao = examPaperDao;
	}


	public InformationForExamDaoImpl getInformationForExamDao() {
		return informationForExamDao;
	}


	public void setInformationForExamDao(
			InformationForExamDaoImpl informationForExamDao) {
		this.informationForExamDao = informationForExamDao;
	}


	public ExamPaper getExamPaper() {
		return examPaper;
	}


	public void setExamPaper(ExamPaper examPaper) {
		this.examPaper = examPaper;
	}


	public void setMultipleChoiceDao(MultipleChoiceDaoImpl multipleChoiceDao) {
		this.multipleChoiceDao = multipleChoiceDao;
	}


	public MultipleChoiceDaoImpl getMultipleChoiceDao() {
		return multipleChoiceDao;
	}


	public void setFillInTheBlankDao(FillInTheBlankDaoImpl fillInTheBlankDao) {
		this.fillInTheBlankDao = fillInTheBlankDao;
	}


	public FillInTheBlankDaoImpl getFillInTheBlankDao() {
		return fillInTheBlankDao;
	}


	public void setProceduralQuestionsDao(ProceduralQuestionsDaoImpl proceduralQuestionsDao) {
		this.proceduralQuestionsDao = proceduralQuestionsDao;
	}


	public ProceduralQuestionsDaoImpl getProceduralQuestionsDao() {
		return proceduralQuestionsDao;
	}
	
	
	
	
	/*
	 * 随机拿出一套题试卷（还是改成从application组卷）
	 */
	public ExaminationQuestions getASetOfExaminationQuestions(int id) {
		

		//String hql = "Select top ? * from MultipleChoice m  where m.setID = ?";(sqlsever版)
		//String hql = "from MultipleChoice m  where m.setID = ? ORDER BY RAND() limit ?";//mysql版
//		String hql = "from MultipleChoice m  where m.setID = ?";
//		
//		//String hql1 = "Select top ? * from FillInTheBlank f  where f.setID = ?";(sqlsever版)
//		//String hql1 = "from FillInTheBlank f  where f.setID = ? ORDER BY RAND() limit ?";//mysql版
//		String hql1 = "from FillInTheBlank f  where f.setID = ? ";
//			
//		//String hql2 = "Select top ? * from ProceduralQuestions p  where p.setID = ?";(sqlsever版)
//		String hql2 = "from ProceduralQuestions p  where p.setID = ?";//mysql版
//		
//		examinationQuestions.setMultipleChoiceList(multipleChoiceDao.find(hql, setID));
//		examinationQuestions.setFillInTheBlankList(fillInTheBlankDao.find(hql1, setID));
//		examinationQuestions.setProceduralQuestionsList(proceduralQuestionsDao.find(hql2, setID));
		
		
		return examinationQuestionsDao.get(ExaminationQuestions.class, id);
	}
	
	
	/*
	 * 根据套题随机组题
	 */
	public ExamPaper getTheExamPaper(ExaminationQuestions examinationQuestions) {
		
		int num = 4;						//题目数量
		
		List<MultipleChoice> mList = new ArrayList<MultipleChoice>();
		List<FillInTheBlank> fList = new ArrayList<FillInTheBlank>();
		
		List<MultipleChoice> multipleChoiceList = examinationQuestions.getMultipleChoiceList();
		List<FillInTheBlank> fillInTheBlankList = examinationQuestions.getFillInTheBlankList();
		
		int[] s1 = RandomTool.randomCommon(1, multipleChoiceList.size(), num);	//获取随机数来随机获取题目
		int[] s2 = RandomTool.randomCommon(1, fillInTheBlankList.size(), num);
		
		for(int i = 0; i < s1.length; i++){
			mList.add(multipleChoiceList.get(s1[i] - 1));						//因为随机数从1到list的大小，所以要减1
		}
		
		for(int j = 0; j < s2.length; j++){
			fList.add(fillInTheBlankList.get(s2[j] - 1));
		}
		
		examPaper.setMultipleChoiceList(mList);
		examPaper.setFillInTheBlankList(fList);
		examPaper.setProceduralQuestionsList(examinationQuestions.getProceduralQuestionsList());
		examPaper.setMscore(examinationQuestions.getMscore());
		examPaper.setFscore(examinationQuestions.getFscore());
		examPaper.setPscore(examinationQuestions.getPscore());
		
		return examPaper;
	}
	
	
	/*
	 * 获取没有考试的考试信息
	 */
	public InformationForExam getTheNOTFinshedExamInfo() {
		
		
		return informationForExamDao.findByHQL("From InformationForExam i where i.finished = 0 and i.released = 1");
	}
	
	
	/*
	 * 提交试卷（有待修改）
	 */
	public void submitExamPaper(ExamPaper examPaper) {
		
		examPaperDao.save(examPaper);
	}
	
	
	
	
	
	
	/*
	 * 获取考试信息
	 */
	public InformationForExam getTheInformationForExam(int id) {
		
		return informationForExamDao.get(InformationForExam.class, id);
	}
	
	
	/*
	 * 发布考试信息
	 */
	public void releaseTheInformationForExam(InformationForExam informationForExam) {
		
		informationForExamDao.save(informationForExam);
	}
	
	
	/*
	 * 修改考试信息
	 */
	public void modifyTheInformationForExam(InformationForExam informationForExam) {
		
		informationForExamDao.update(informationForExam);
	}
	
	
	/*
	 * 试题管理(增删查改)
	 */
	
	/*
	 * 增加套题
	 */
	public void addASetOfQuestions(ExaminationQuestions examinationQuestions) {
		
		examinationQuestionsDao.save(examinationQuestions);
	}

	
	/*
	 * 删除套题
	 */
	public void deleteASetOfQuestions(int id) {
		
		examinationQuestionsDao.delete(examinationQuestionsDao.get(ExaminationQuestions.class, id));
	}
	
	
	/*
	 * 获取题库中的套题数
	 */
	public int getTheNumsOfExaminationQuestions() {
		
		return examinationQuestionsDao.findCount(ExaminationQuestions.class).intValue();
	}
	
	
	/*
	 * 获取套题中的特定填空题
	 */
	public FillInTheBlank getFillInTheBlank(int id) {
		
		return fillInTheBlankDao.get(FillInTheBlank.class, id);
	}


	/*
	 * 获取套题中的特定选择题
	 */
	public MultipleChoice getMultipleChoice(int id) {
		
		return multipleChoiceDao.get(MultipleChoice.class, id);
	}


	/*
	 * 获取套题中的特定程序题
	 */
	public ProceduralQuestions getProceduralQuestions(int id) {
		
		return proceduralQuestionsDao.get(ProceduralQuestions.class, id);
	}
	

	/*
	 * 增加填空题
	 */
	public void addFillInTheBlanks(List<FillInTheBlank> fillInTheBlankList) {
		
		for(FillInTheBlank f : fillInTheBlankList){
			fillInTheBlankDao.save(f);
		}
	}


	/*
	 * 增加选择题
	 */
	public void addMultipleChoices(List<MultipleChoice> multipleChoiceList) {
		
		for(MultipleChoice m : multipleChoiceList){
			multipleChoiceDao.save(m);
		}
	}


	/*
	 * 增加程序题
	 */
	public void addProceduralQuestions(List<ProceduralQuestions> proceduralQuestionsList) {
		
		for(ProceduralQuestions p : proceduralQuestionsList){
			proceduralQuestionsDao.save(p);
		}
	}


	/*
	 * 删除指定的填空题
	 */
	public void deleteFillInTheBlank(FillInTheBlank fillInTheBlank) {
		
			fillInTheBlankDao.delete(fillInTheBlank);
	}


	/*
	 * 删除指定的选择题
	 */
	public void deleteMultipleChoice(MultipleChoice multipleChoice) {

			multipleChoiceDao.delete(multipleChoice);
	}


	/*
	 * 删除指定的程序题
	 */
	public void deleteProceduralQuestions(ProceduralQuestions proceduralQuestions) {

			proceduralQuestionsDao.delete(proceduralQuestions);
	}



	/*
	 * 修改指定的填空题
	 */
	public void reviseFillInTheBlank(FillInTheBlank fillInTheBlank) {

			fillInTheBlankDao.update(fillInTheBlank);
	}


	/*
	 * 修改指定的选择题
	 */
	public void reviseMultipleChoice(MultipleChoice multipleChoice) {

			multipleChoiceDao.update(multipleChoice);
	}


	/*
	 * 修改指定程序题
	 */
	public void reviseProceduralQuestions(ProceduralQuestions proceduralQuestions) {

			proceduralQuestionsDao.update(proceduralQuestions);
	}
	
	

	
	/*
	 * 获得考生考试情况对象集合
	 */
	public List<StudentAnswersANDGrade> getTheReport() {
		
		return stuGradeDao.findAll(StudentAnswersANDGrade.class);
	}

	
	/*
	 * 系统初评(选择题和填空题)
	 */
	public void firstMarking(String[] multipleChoiceAnswer,String[] fillInTheBlankAnswer,StudentAnswersANDGrade stuGrade,ExamPaper examPaper) {
		
		int firstGrade = 0;
		int i = 0, j = 0;
		
		List<MultipleChoice> mList = examPaper.getMultipleChoiceList();
		List<FillInTheBlank> fList = examPaper.getFillInTheBlankList();
		
		for(MultipleChoice m : mList){									//计算选择题的得分
			if(m.getRightAnswer().equals(multipleChoiceAnswer[i])){
				firstGrade += examPaper.getMscore();
			}
			i++;
		}
		
		for(FillInTheBlank f : fList){									//计算填空题的得分
			if(f.getRightAnswer().equals(fillInTheBlankAnswer[j])){
				firstGrade += examPaper.getFscore();
			}
			j++;
		}
		
		stuGrade.setExamPaper(examPaper);
		stuGrade.setFirstGrade(firstGrade);								//登记初评分数
	}


	/*
	 * 记录考生程序题的分数
	 */
	public void scoringTheProceduralQuestions(int[] proceduralscores) {
		
		List<StudentAnswersANDGrade> studentAnswersANDGradeList = stuGradeDao.findAll(StudentAnswersANDGrade.class);
		
		int i = 0;
		
		for(StudentAnswersANDGrade s : studentAnswersANDGradeList){
			
			s.setFinalGrade(s.getFirstGrade() + proceduralscores[i]);	//记录最终成绩
			
			stuGradeDao.update(s);										//更新数据
		}
		
		
	}


	
	/*
	 * 导出初评后试卷到word进行人工评分
	 */
	public void exportThePapers() {
		
		try {
			
			ExportThePaper.createDoc(stuGradeDao.find("from StudentAnswersANDGrade s Order by s.firstGrade desc"));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
	
	
	/*
	 * 导出最终排名和分数到excel
	 */
	public void exportReport() {
		
		try {
			
			ExportGradeReport.createExcel(stuGradeDao.find("from StudentAnswersANDGrade s Order by s.finalGrade desc"));
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	
	
	/*
	 * 获取所有套题信息
	 */
	public List<ExaminationQuestions> getAllSetsOfExaminationQuestions() {
		
		return examinationQuestionsDao.findAll(ExaminationQuestions.class);
	}

	
	/*
	 * 根据名称获取试题
	 */
	public ExaminationQuestions getASetOfExaminationQuestions(String name) {
		
		return examinationQuestionsDao.findByHQL("From ExaminationQuestions eq where eq.name = ?",name);
	}

	
	/*
	 * 更新某套试题
	 */
	public void reviseTheSetOfExaminationQuestions(
			ExaminationQuestions examinationQuestions) {
		
		
		examinationQuestionsDao.update(examinationQuestions);
	}

	
	/*
	 * 获取所有考试信息
	 */
	public List<InformationForExam> getAllTheInformationForExam() {
		
		return informationForExamDao.find("From InformationForExam i Order by i.beginTime");
	}

	


	
}
