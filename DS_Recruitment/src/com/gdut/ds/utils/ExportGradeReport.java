package com.gdut.ds.utils;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.gdut.ds.beans.examination.StudentAnswersANDGrade;
import com.gdut.ds.beans.userInfo.Applicant;


public class ExportGradeReport {
	
	
	public  static void createExcel(List<StudentAnswersANDGrade> stuList) throws Exception { 
		
        // 第一步，创建一个webbook，对应一个Excel文件  
        HSSFWorkbook wb = new HSSFWorkbook();  
        
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
        HSSFSheet sheet = wb.createSheet("成绩表");  
        
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
        HSSFRow row = sheet.createRow((int) 0);  
        
        // 第四步，创建单元格，并设置值表头 设置表头居中  
        HSSFCellStyle style = wb.createCellStyle();  
        
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
        
        // 设置excel每列宽度
        sheet.setColumnWidth(0, 3500);
        sheet.setColumnWidth(1, 3500);
        sheet.setColumnWidth(2, 3500);
        sheet.setColumnWidth(3, 3500);
        sheet.setColumnWidth(4, 3500);
        sheet.setColumnWidth(5, 3500);
        sheet.setColumnWidth(6, 3500);
        sheet.setColumnWidth(7, 4500);
        
  
        HSSFCell cell = row.createCell(0);  
        cell.setCellValue("学号");  
        cell.setCellStyle(style);  
        
        cell = row.createCell(1);  
        cell.setCellValue("性别");  
        cell.setCellStyle(style); 
        
        cell = row.createCell(2);  
        cell.setCellValue("姓名");  
        cell.setCellStyle(style);  
        
        cell = row.createCell(3);  
        cell.setCellValue("考试成绩");  
        cell.setCellStyle(style);  
        
        cell = row.createCell(4);  
        cell.setCellValue("报考方向");  
        cell.setCellStyle(style); 
        
        cell = row.createCell(5);  
        cell.setCellValue("专业");  
        cell.setCellStyle(style); 
        
        cell = row.createCell(6);  
        cell.setCellValue("班级");  
        cell.setCellStyle(style);
        
        cell = row.createCell(7);  
        cell.setCellValue("联系方式");  
        cell.setCellStyle(style);
        
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到
        
  
        for (int i = 0; i < stuList.size(); i++)  {
        	
        	//创建一行
            row = sheet.createRow((int) i + 1);  
            
            StudentAnswersANDGrade stu = (StudentAnswersANDGrade) stuList.get(i); 
            Applicant applicant = stu.getApplicant();
            
            //第四步，创建单元格，并设置值  
          row.createCell(0).setCellValue(applicant.getStudentID());  
          row.createCell(1).setCellValue(applicant.getSex());
          row.createCell(2).setCellValue(applicant.getName());  
          row.createCell(3).setCellValue(stu.getFinalGrade());
          row.createCell(4).setCellValue(applicant.getAspect());
          row.createCell(5).setCellValue(applicant.getMajor());
          row.createCell(6).setCellValue(applicant.getGrade());
          row.createCell(7).setCellValue(applicant.getPhoneNumber());
           
        }  
        
        
        // 第六步，将文件存到指定位置  
        try{  
            FileOutputStream fout = new FileOutputStream("WebRoot/export/grade/grade.xls");
            
            wb.write(fout);  
            
            fout.close();  
            
        }catch (Exception e){  
        	
            e.printStackTrace();  
            
        }  
    }  
}
