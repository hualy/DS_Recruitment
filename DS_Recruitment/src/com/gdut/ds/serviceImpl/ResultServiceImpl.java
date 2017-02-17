package com.gdut.ds.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gdut.ds.beans.introduction.DS_Result;
import com.gdut.ds.beans.introduction.Image;
import com.gdut.ds.dao.introduction.ImageDao;
import com.gdut.ds.dao.introduction.ResultDao;
import com.gdut.ds.service.ResultService;
import com.gdut.ds.utils.ImageFunction;
import com.gdut.ds.utils.RealPathUtil;
import com.sun.corba.se.spi.orbutil.fsm.Input;

public class ResultServiceImpl implements ResultService {
	
	private static final int pageSize = 1;   //设置查看结果页面的页数为1
	
	private static final int adminPageSize = 10;	//返回给管理员修改页面的数量
	
	private ResultDao resultDao;
	
	private DS_Result result;
	
	private ImageFunction imageFunction;
	
	private ImageDao imageDao;
	
	public ResultDao getResultDao() {
		return resultDao;
	}


	public void setResultDao(ResultDao resultDao) {
		this.resultDao = resultDao;
	}

	

	
	public DS_Result getResult() {
		return result;
	}


	public void setResult(DS_Result result) {
		this.result = result;
	}


	public ImageFunction getImageFunction() {
		return imageFunction;
	}


	public void setImageFunction(ImageFunction imageFunction) {
		this.imageFunction = imageFunction;
	}


	public ImageDao getImageDao() {
		return imageDao;
	}


	public void setImageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}


	//更新
	public void updateResult(String id,String theme,String leaderName,String membersName, String date, int type,
			String description,boolean resetPicture, Set<Image> images) {
		
		DS_Result result = resultDao.get(DS_Result.class, id);		//得到result实体
		
//		for(Image image:images){
//			description = description.replaceFirst(Image.imageLabel,"<img src='images/result/"+image.getPath().substring(image.getPath().lastIndexOf('/')+1)+"' />");
//		}
		
		result.setDate(date);
		result.setDescription(description);
		
		
		if(resetPicture){
			
			if(null!=result.getImages()){ //注意级联关系引起的错误
				Set<Image> resutImages = result.getImages();
				result.setImages(null);				
					imageFunction.deleteImage(resutImages, RealPathUtil.getRealPath());		//删除图片
				for(Image image:resutImages){
					imageDao.delete(image);				//从数据库中删除与图片有关的信息
				}
			}	
			if(null==result.getImages()) result.setImages(new HashSet<Image>());
			for(Image image:images){
				result.getImages().add(image);
			}
		}
		result.setLeaderName(leaderName);
		result.setMembersName(membersName);
		result.setTheme(theme);
		result.setType(type);
		resultDao.update(result);
		
	}
	
	//查找
	public DS_Result getResultById(String id) {
		
		return resultDao.get(DS_Result.class, id);
	}
	
	public List<DS_Result> getResult(int currentPage){
		return resultDao.findByPage("select new DS_Result(id,theme,date,type) from DS_Result r", (currentPage-1)*adminPageSize, adminPageSize);
	}
	
	public DS_Result getResultDetail(int currentPage,int type){
		
		List<DS_Result> results = resultDao.findByPage((currentPage-1)*pageSize, pageSize, type);
		if(null!=results&&results.size()>0)
			return results.get(0);
		return null;
	}
	
	//创建
	public void createResult(String theme,String leaderName,String membersName, String date, int type,
			String description, Set<Image> images) {
		
//		for(Image image:images){
//			description = description.replaceFirst(Image.imageLabel,"<img src='images/result/"+image.getPath().substring(image.getPath().lastIndexOf('/')+1)+"' />");
//		}
		result.setDate(date);
		result.setDescription(description);
		result.setImages(images);
		result.setLeaderName(leaderName);
		result.setMembersName(membersName);
		result.setTheme(theme);
		result.setType(type);
		resultDao.save(result);
		
	}
	
	//根据id来删除接口
	public void deleteResult(String resultId) {
		
		result = resultDao.get(DS_Result.class, resultId);
		
		if(result==null) {
//			System.out.println("ResultServiceImpl result null");
			return ;
		}
		
		Set<Image> images = result.getImages();	//得到图片
		
//		System.out.println(images.size());
//		
//		for(Image image:images){
//			System.out.println(image.getPath());
//		}
		
		imageFunction.deleteImage(images, RealPathUtil.getRealPath());		//删除图片
		
		for(Image image:images){
			imageDao.delete(image);				//从数据库中删除与图片有关的信息
		}
		
		resultDao.delete(result);				//从数据库中删除result相关信息
		
	}


	public Long getCountAll() {
		return resultDao.findCount(DS_Result.class);
	}


	public Long getCountByType(int type) {
		return resultDao.findCount("select  count(*) from DS_Result r where r.type=?", type);
	}
	
	


	
}
