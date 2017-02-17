package com.gdut.ds.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.gdut.ds.beans.introduction.Image;



public class ImageFunction {
	
	public static final int count = 4;
	
	
	
	//处理增加的的图片
	public Set<Image> deal(List<File> files,List<String> filesType,int type,String savePath,String realPath){
		
		if(files==null||files.size()<=0) return null;   //如果files为空，直接返回
		
		
		Set<Image> images = new HashSet<Image>();
//		savePath =  ServletActionContext.getServletContext().getRealPath(savePath);
		
		//先创建名字
	   //根据参数来决定images目录下的子目录名
		String str = null;
		switch(type){
			case Image.TYPE_ACTIVITY: str=File.separator+"activity";break;
			case Image.TYPE_ARTICLE: str=File.separator+"article";break;
			case Image.TYPE_RESULT: str=File.separator+"result";break;
			case Image.TYPE_INTERECOMMUNION:str=File.separator+"interecommunion";break;
		}
		
		
		
		//为每个文件创建名字
		for(int i=0;i<files.size();i++){
			StringBuffer savePathBuffer = new StringBuffer(savePath+str);
			Image image = new Image();
			
			image.setPath(savePathBuffer.append(File.separator).append(System.currentTimeMillis())
					.append("(").append(i).append(")").append(".").append(filesType.get(i).substring(filesType.get(i).indexOf("/")+1))
					.toString().replace("\\", "/"));
//			image.setPath(savePathBuffer.append(File.separator).append(System.currentTimeMillis())
//					.append("(").append(i).append(")").append(".").append(filesType.get(i).substring(filesType.get(i).indexOf("/")+1))
//					.toString().replace("\\", "/"));
			images.add(image);
		}
		
//		for(int i=0;i<images.size();i++){
//			System.out.println(images.get(i).getPath());
//		}
		
		List<Image> imageList = null;		//临时储存的图片的地方
		List<File>  fileList = null;			//暂时储存的文件的地方
		List<DealImageThread> itl = new ArrayList<DealImageThread>();   //放置线程的集合
		Iterator<Image> iterator = images.iterator();
		for(int i=0;i<files.size();i++){
			if(i%count==0){//count个为一组
				if(i!=0){
					DealImageThread  di = new DealImageThread(imageList,fileList,realPath); //新建线程
					di.start();
					itl.add(di);
				}
				imageList = new ArrayList<Image>();
				fileList = new ArrayList<File>();
			}
			imageList.add(iterator.next()) ;
			fileList.add(files.get(i))  ;
			
			if(i==files.size()-1&&i%count!=0){//为最后一组，但是不满足count个一组的
				DealImageThread  di = new DealImageThread(imageList,fileList,realPath); //新建线程
				di.start();
				itl.add(di);
			}
		}
		
		while(itl.size()!=0){	//判断是否所有线程都已经结束
			for(int i=0;i<itl.size();i++){
				if(!itl.get(i).isAlive()){
					itl.remove(i);
					i--;
					if(i<=0) break; 
				}
			}
		}
		
		//设置图片类型
		for(Image image:images){
			image.setType(type);
		}
		return images;
	}
	
	/*
	//为成员处理图片
	public Image dealImageForMember(File file,String fileType,int type,String savePath,String realPath){
		
		if(file==null) return null;   //如果files为空，直接返回
		
		
		
//		savePath =  ServletActionContext.getServletContext().getRealPath(savePath);
		
		//先创建名字
	   //根据参数来决定images目录下的子目录名
//		switch(type){
//			case Image.TYPE_ACTIVITY: savePath+=File.separator+"activity";break;
//			case Image.TYPE_ARTICLE: savePath+=File.separator+"article";break;
//			case Image.TYPE_RESULT: savePath+=File.separator+"result";break;
//			case Image.TYPE_INTERECOMMUNION:savePath+=File.separator+"interecommunion";break;
//		}
		
		//肯定为DS_member类型
		savePath+=File.separator+"member";
		
		
		//为每个文件创建名字
		
			StringBuffer savePathBuffer = new StringBuffer(savePath);
			Image image = new Image();
			
			image.setPath(savePathBuffer.append(File.separator).append(System.currentTimeMillis())
					.append("(").append(1).append(")").append(".").append(fileType.substring(fileType.indexOf("/")+1))
					.toString().replace("\\", "/"));
			
		
		
//		for(int i=0;i<images.size();i++){
//			System.out.println(images.get(i).getPath());
//		}
			
			File f = new File(realPath+"/"+savePath);
				
			while(f.exists()){ //如果文件存在的话，另外改变其名字
				int se  = image.getPath().lastIndexOf(".");  //放置.的位置
				image.setPath(image.getPath().substring(0,se-1)+image.getPath().substring(se));
				f = new File(realPath+"/"+image.getPath()); 
			}
		
			try {
				//file.createNewFile();	//文件不存在，另外创建文件
				FileOutputStream fos = null ;  //文件输出
				FileInputStream fis = null ;  //文件输入
				
				try {
					 fos = new FileOutputStream(f);
					 fis = new FileInputStream(file);
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
		
		
		
		
		
		//设置图片类型
		
			image.setType(type);
		
		return image;
	}
	
	*/
	
	public String dealImageForMember(String imagePath,String savePath){
		
		if(imagePath==null||"".equals(imagePath.trim()))
			return null;
		File file = new File(RealPathUtil.getRealPath()+"/"+imagePath);//先得到原文件
		
		imagePath = imagePath.replace("\\", "/");
		imagePath = imagePath.substring(imagePath.lastIndexOf("/")+1);	//得到文件的名称
		
		savePath += "/member";	//得到的是保存的路径

		File parent = new File(RealPathUtil.getRealPath()+"/"+savePath);
			//父目录不存在则重建
		if(!(parent.exists())){
			parent.mkdirs();
		}
		
		
		
		imagePath = savePath+"/"+imagePath.substring(imagePath.lastIndexOf("/")+1);
			

			File f = new File(RealPathUtil.getRealPath()+"/"+imagePath);
				
			while(f.exists()){ //如果文件存在的话，另外改变其名字
				int se  = imagePath.lastIndexOf(".");  //放置.的位置
				imagePath = imagePath.substring(0,se-1)+imagePath.substring(se);
				f = new File(RealPathUtil.getRealPath()+"/"+imagePath); 
			}
		
			try {
				//file.createNewFile();	//文件不存在，另外创建文件
				FileOutputStream fos = null ;  //文件输出
				FileInputStream fis = null ;  //文件输入
				
				try {
					 fos = new FileOutputStream(f);
					 fis = new FileInputStream(file);
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
			
			
			
			StringBuffer sb = new StringBuffer(RealPathUtil.getRealPath());
			
			//还有删除当前的sessionId的所有的图片 
			File p = new File(sb.append("/").append(savePath).append("/temp/")
					.append(ServletActionContext.getRequest().getSession().getId()).toString());
			
//			System.out.println("imageFunction partLoad p :"+p.getAbsolutePath());
			
			
			if(p.exists()){
				for(File fi:p.listFiles()){
					fi.delete();
				}
				p.delete();
			}else{
				System.out.println("临时的文件夹不存在");
			}
			
//			System.out.println("imageFunction imagePath :"+imagePath);
			
			return imagePath;
	}
	
	
	//为成员处理图片
	public String dealImageTempForMember(File file,String fileType,String savePath,String realPath){
		
		if(file==null) return "";   //如果files为空，直接返回
		
		
		
//		savePath =  ServletActionContext.getServletContext().getRealPath(savePath);
		
		//先创建名字
	   //根据参数来决定images目录下的子目录名
//		switch(type){
//			case Image.TYPE_ACTIVITY: savePath+=File.separator+"activity";break;
//			case Image.TYPE_ARTICLE: savePath+=File.separator+"article";break;
//			case Image.TYPE_RESULT: savePath+=File.separator+"result";break;
//			case Image.TYPE_INTERECOMMUNION:savePath+=File.separator+"interecommunion";break;
//		}
		
		//肯定为DS_member类型
		savePath+="/"+ServletActionContext.getRequest().getSession().getId();
		
		
		//为每个文件创建名字
			
			StringBuffer savePathBuffer = new StringBuffer(savePath);
			File parent = new File(realPath+"/"+savePath);
			if(!parent.exists()){
				parent.mkdirs();
			}
			
			savePath = savePathBuffer .append(File.separator).append(System.currentTimeMillis())
					.append("(").append(1).append(")").append(".").append(fileType.substring(fileType.indexOf("/")+1))
					.toString().replace("\\", "/");
			
			
			File f = new File(realPath+"/"+savePath);
//			if(!f.getParentFile().exists()){
//				f.mkdirs();
//			}
//			if(!f.exists()){
//				try {
//					f.createNewFile();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
				
//			while(f.exists()){ //如果文件存在的话，另外改变其名字
//				int se  = image.getPath().lastIndexOf(".");  //放置.的位置
//				image.setPath(image.getPath().substring(0,se-1)+image.getPath().substring(se));
//				f = new File(realPath+"/"+image.getPath()); 
//			}
		
			try {
				//file.createNewFile();	//文件不存在，另外创建文件
				FileOutputStream fos = null ;  //文件输出
				FileInputStream fis = null ;  //文件输入
				
				try {
					 fos = new FileOutputStream(f);
					 fis = new FileInputStream(file);
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
		
		return savePath;
	}
	
	//为推送处理图片
	public String dealImageForArticle(File file,String fileType,String savePath,String realPath){
		
		if(file==null) return null;   //如果files为空，直接返回
		
		
		

		savePath+=File.separator+ServletActionContext.getRequest().getSession().getId();
		
		
		//为每个文件创建名字
		
			StringBuffer savePathBuffer = new StringBuffer(savePath);
			File parent = new File(realPath+"/"+savePath);
			//父目录不存在则重建
			if(!(parent.exists())){
				parent.mkdirs();
			}
			
			String imagePath = savePathBuffer.append(File.separator).append(System.currentTimeMillis())
			.append("(").append(1).append(")").append(".").append(fileType.substring(fileType.indexOf("/")+1))
			.toString().replace("\\", "/");
			

			File f = new File(realPath+"/"+savePath);
				
			while(f.exists()){ //如果文件存在的话，另外改变其名字
				int se  = imagePath.lastIndexOf(".");  //放置.的位置
				imagePath = imagePath.substring(0,se-1)+imagePath.substring(se);
				f = new File(realPath+"/"+imagePath); 
			}
		
			try {
				//file.createNewFile();	//文件不存在，另外创建文件
				FileOutputStream fos = null ;  //文件输出
				FileInputStream fis = null ;  //文件输入
				
				try {
					 fos = new FileOutputStream(f);
					 fis = new FileInputStream(file);
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
		
		return imagePath;
	}
	
	//删除图片
	public void deleteImage(Set<Image> images,String realPath){
		
		if(images==null||images.size()<=0) return;		//没有图片，直接返回呗
		
//		for(Image image:images){
//			System.out.println(image.getPath());
//		}
	
		for(Image image:images){
			File file = new File(realPath+"/"+image.getPath());
			if(file.exists()) file.delete();
		}
		
	}
	
	public void delete(String image,String realPath){
		
		if(image==null) return;		//没有图片，直接返回呗
		
		File file = new File(realPath+"/"+image);
		if(file.exists()) file.delete();
		
		
	}
	
	public void deleteTempImage(String path){
		if(path==null) return;		//没有图片，直接返回呗
		
		File file = new File(path);
		if(file.exists()&&file.isDirectory()){
			for(File children :file.listFiles()){
				children.delete();
			}
			file.delete();
		}
		
	}
	
	
	
}
