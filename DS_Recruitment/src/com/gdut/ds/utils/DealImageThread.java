package com.gdut.ds.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.gdut.ds.beans.introduction.Image;

public class DealImageThread extends Thread {
	
	private List<Image> images;		
	private List<File> files;
	private String realPath;
	
	
	public DealImageThread(List<Image> images,List<File> files,String realPath) {
		
			this.images = images;
			this.files = files;
			this.realPath =realPath;
			
		
	}
	
	@Override
	public void run() {
//		System.out.println("DealImage realPath:"+realPath);
		
		 for(int i=0;i<images.size();i++){
			File file = new File(realPath+"/"+images.get(i).getPath());
			
			while(file.exists()){ //如果文件存在的话，另外改变其名字
				int se  = images.get(i).getPath().lastIndexOf(".");  //放置.的位置
				images.get(i).setPath(images.get(i).getPath().substring(0,se-1)+images.get(i).getPath().substring(se));
				file = new File(realPath+"/"+images.get(i).getPath()); 
			}
			
			
//			int se  = images.get(i).getPath().lastIndexOf(".");  //放置.的位置
//			images.get(i).setPath(images.get(i).getPath().substring(0,se)+"a"+images.get(i).getPath().substring(se));
//			new File(images.get(i).getPath());
			
			try {
				//file.createNewFile();	//文件不存在，另外创建文件
				FileOutputStream fos = null ;  //文件输出
				FileInputStream fis = null ;  //文件输入
				
				try {
					 fos = new FileOutputStream(file);
					 fis = new FileInputStream(files.get(i));
					 byte b[] = new byte[1024];
					 int c;
					 while((c=fis.read(b))!=-1){
						 fos.write(b,0,c);
					 }
					 
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}finally{
					try {
						fis.close();		//关闭流
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			
		}
	}
	
	

}
