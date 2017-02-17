package com.gdut.ds.utils;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.gdut.ds.beans.userInfo.Applicant;

import freemarker.template.Template;
import freemarker.template.TemplateException;

public class ExportTheApplicationFrom {

	
	private static Map<String, Object> dataMap = new HashMap<String, Object>();
	
	private FreeMarkerConfigurer freeMarkerConfigurer;
	
	private String exportPath;
	
	public FreeMarkerConfigurer getFreeMarkerConfigurer() {
		return freeMarkerConfigurer;
	}


	public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
		this.freeMarkerConfigurer = freeMarkerConfigurer;
	}
	
	public ExportTheApplicationFrom() {
		
	}
	
	public ExportTheApplicationFrom(String path){
		
		this.exportPath = path;
	}


	@SuppressWarnings("deprecation")
	 /*
	  * 生成固定模版的word文件
	  */
	public boolean createDoc(List<Applicant> appList) {  
  
	     Template t = null;  
	     try {  
	    	//获取模版
	    	t = freeMarkerConfigurer.getConfiguration().getTemplate("报名样本.xml");  //模版的路径
	        t.setEncoding("utf-8");  
	  
	     } catch (IOException e) {  
	  
	        e.printStackTrace();  
	  
	     }  
	     
	     if(appList.size() == 0){
	    	 
	    	 System.out.println("没有人报名");
	    	 
	    	 return false;
	    	 
	     }else{
	    	 
	    	 for(int i = 0; i < appList.size(); i++){
		    	 
		    	 Applicant app = appList.get(i);
		    	 Map<String, Object> dataMap = formTheMap(app);
		    	 
		    	 // 输出文档路径及名称   (在web目录不加上前面的，就会默认到tomcat下面的bin寻找)
			      File outFile = new File(exportPath + "/applicationform/" + dataMap.get("aspect") + "—" +dataMap.get("name") +dataMap.get("studentID")+".doc");
			      if(!outFile.exists()){
			    	
			    	System.out.println(outFile.getAbsolutePath());
			    	  
			    	try {
						outFile.createNewFile();
					} catch (IOException e2) {
						e2.printStackTrace();
					}
			      }
			      
			      Writer out = null;  
			  
			      try {  
			  
			         out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));  
			  
			      } catch (Exception e1) {  
			  
			         e1.printStackTrace();  
			  
			      }  
			  
			      try {  
			  
			         t.process(dataMap, out);  				//将数据填进文档
			  
			         out.close();  
			  
			      } catch (TemplateException e) {  
			  
			         e.printStackTrace();  
			  
			      } catch (IOException e) {  
			  
			         e.printStackTrace();  
			  
			      }  
		     }
		 
		      return true;
	     }
	      
	  }
	 
	 
	 /*
	  * 获取数据源
	  */
	 public static Map<String, Object> formTheMap(Applicant app){
		 
		 dataMap.put("name", app.getName());
		 dataMap.put("studentID", app.getStudentID());
		 dataMap.put("sex", app.getSex());
		 dataMap.put("academy", app.getAcademy());
		 dataMap.put("mg", app.getMajor() + app.getGrade());
		 dataMap.put("job", app.getJob());
		 dataMap.put("phoneNumber", app.getPhoneNumber());
		 dataMap.put("shortphoneNumber", app.getShortphoneNumber());
		 dataMap.put("qq", app.getQQ());
		 dataMap.put("email", app.getEmail());
		 dataMap.put("skills", app.getSkills());
		 dataMap.put("self", app.getSelfevaluation());
		 dataMap.put("hopes", app.getHopes());
		 dataMap.put("aspect", app.getAspect());
		 
		 return dataMap;  
	 }
	 
	 
	 
	 /*
	  * 将文件打包成zip
	  */
	 public boolean packSomeFiles(){

		 
		 File file1 = new File(exportPath + "/applicationform");
		 File[] file = file1.listFiles(); 
		 
		 if(file != null){
			 File zipFile = new File(exportPath + "/zip/考生报名信息.zip");			//最终打包的压缩包
	         
			 ZipOutputStream zipStream = null;
			 FileInputStream zipSource = null;
			 BufferedInputStream bufferStream = null;
			 try {
				zipStream = new ZipOutputStream(new FileOutputStream(zipFile));//用这个构造最终压缩包的输出流
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			} 
			
			 for(int i = 0; i < file.length; i++){
				 
				 try {
				     
				     zipSource = null;
				     zipSource = new FileInputStream(file[i]);					//将源头文件格式化为输入流
				             
				     byte[] bufferArea = new byte[1024 * 1024];					//读写缓冲区
				             
				     //压缩条目不是具体独立的文件，而是压缩包文件列表中的列表项，称为条目，就像索引一样
				     ZipEntry zipEntry = new ZipEntry(file[i].getName());
				     zipStream.putNextEntry(zipEntry);//定位到该压缩条目位置，开始写入文件到压缩包中
				             
				     bufferStream = new BufferedInputStream(zipSource, 1024 * 1024);//输入缓冲流
				     int read = 0;
				     
				     //在任何情况下，b[0] 到 b[off] 的元素以及 b[off+len] 到 b[b.length-1] 的元素都不会受到影响。这个是官方API给出的read方法说明，经典！
				     while((read = bufferStream.read(bufferArea, 0, 1024 * 1024)) != -1){
				    	 
				            zipStream.write(bufferArea, 0, read);
				     }
				             
				  }catch(Exception e) {
			
				      e.printStackTrace();
				  } 
				   
			 }
		 
			try {													//关闭流
				 if(null != bufferStream) bufferStream.close();
				 if(null != zipStream) zipStream.close();
				 if(null != zipSource) zipSource.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return true;
		 }
		 

		 return false;
	 } 
	
}
