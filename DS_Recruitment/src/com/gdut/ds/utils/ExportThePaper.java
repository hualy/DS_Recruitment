package com.gdut.ds.utils;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.gdut.ds.beans.examination.ProceduralQuestions;
import com.gdut.ds.beans.examination.ProceduralQuestionsAnswer;
import com.gdut.ds.beans.examination.StudentAnswersANDGrade;
import com.gdut.ds.beans.userInfo.Applicant;

public class ExportThePaper {
	
	
	public static void createDoc(List<StudentAnswersANDGrade> studentAnswersANDGradeList) throws Exception { 
		 
		for(StudentAnswersANDGrade s : studentAnswersANDGradeList){
			
			int num = 1;											//代表着考生的初评顺序
			
			Applicant applicant = s.getApplicant();
			List<ProceduralQuestions> proceduralQuestionsList = s.getExamPaper().getProceduralQuestionsList();
			List<ProceduralQuestionsAnswer> proceduralQuestionsAnswersList = s.getProceduralQuestionsAnswerList();
			
		    XWPFDocument doc = new XWPFDocument();  				//一个XWPFDocument代表一个docx文档，其可以用来读docx文档，也可以用来写docx文档
		  
		    XWPFParagraph p1 = doc.createParagraph();  				//XWPFParagraph：代表一个段落
		    p1.setAlignment(ParagraphAlignment.BOTH);  
		  
		    XWPFRun r1 = p1.createRun();  							//XWPFRun：代表具有相同属性的一段文本。
		    r1.setBold(true);  										//设置加粗
		    r1.setText("学号:  " + applicant.getStudentID());  
		    r1.setFontFamily("宋体");									//设置字体
		    r1.setFontSize(14);
//		    r1.setTextPosition(10);  
		 
		    
		    XWPFParagraph p2 = doc.createParagraph();  
		    p2.setAlignment(ParagraphAlignment.BOTH);  
		    
		    XWPFRun r2 = p2.createRun();
		    r2.setBold(true);  										
		    r2.setText("性别:  " + applicant.getSex());  
		    r2.setFontFamily("宋体");									
		    r2.setFontSize(14);
		  
		  
		    XWPFParagraph p3 = doc.createParagraph();   
//		    p3.setPageBreak(true);  								//设置分页标志
		    XWPFRun r3 = p3.createRun();  
		    r3.setBold(true);  										
		    r3.setText("姓名:  " + applicant.getName());  
		    r3.setFontFamily("宋体");									
		    r3.setFontSize(14);              

		    
		    XWPFParagraph p4 = doc.createParagraph();   
		    XWPFRun r4 = p4.createRun();  
		    r4.setBold(true);  										
		    r4.setText("初评分数:  " + s.getFirstGrade());  
		    r4.setFontFamily("宋体");									
		    r4.setFontSize(14); 
		    
		    for(int i = 0; i < proceduralQuestionsList.size(); i++){
		    
		    	XWPFParagraph p5 = doc.createParagraph();   
				XWPFRun r5 = p5.createRun();  										
				r5.setText("程序题: " + proceduralQuestionsList.get(i).getTitle());  
				r5.setFontFamily("宋体");									
				r5.setFontSize(16); 
				
				XWPFParagraph p6 = doc.createParagraph();   
				XWPFRun r6 = p6.createRun();  										
				r6.setText("答案: " + proceduralQuestionsAnswersList.get(i).getCode());  
				r6.setFontFamily("Courier");									
				r6.setFontSize(16);
		    }
		  
		    FileOutputStream out = new FileOutputStream("WebRoot/export/paper/" + num + "、" + applicant.getName() +".docx");  
		    num++;
		    doc.write(out);  
		    out.close();  
		}
	}  
	
}
