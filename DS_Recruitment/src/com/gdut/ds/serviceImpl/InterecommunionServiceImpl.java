package com.gdut.ds.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gdut.ds.beans.introduction.DS_Interecommunion;
import com.gdut.ds.beans.introduction.Image;
import com.gdut.ds.dao.introduction.ImageDao;
import com.gdut.ds.dao.introduction.InterecommunionDao;
import com.gdut.ds.service.InterecommunionService;
import com.gdut.ds.utils.ImageFunction;
import com.gdut.ds.utils.RealPathUtil;

public class InterecommunionServiceImpl implements InterecommunionService {
	
	private static final int pageSize = 1;   //设置查看结果页面的页数为1
	
	private static final int admPageSize = 10;   //设置管理员查看结果页面的页数为1
	
	private InterecommunionDao interecommunionDao;
	
	private DS_Interecommunion interecommunion;
	
	private ImageFunction imageFunction;
	
	private ImageDao imageDao;
	

	public InterecommunionDao getInterecommunionDao() {
		return interecommunionDao;
	}

	public void setInterecommunionDao(InterecommunionDao interecommunionDao) {
		this.interecommunionDao = interecommunionDao;
	}

	public DS_Interecommunion getInterecommunion() {
		return interecommunion;
	}

	public void setInterecommunion(DS_Interecommunion interecommunion) {
		this.interecommunion = interecommunion;
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
	public void updateInterecommunion(String id, String theme, String date,
			String speaker, String presenter, String content,boolean resetPicture, Set<Image> images) {
		
		DS_Interecommunion interecommunion = interecommunionDao.get(DS_Interecommunion.class, id);		//得到Interecommunion实体
		
//		for(Image image:images){
//			description = description.replaceFirst(Image.imageLabel,"<img src='images/Interecommunion/"+image.getPath().substring(image.getPath().lastIndexOf('/')+1)+"' />");
//		}
		
		if(resetPicture){
			
			Set<Image> interecommunionImages = interecommunion.getImages();
			
			interecommunion.setImages(null);
			
			imageFunction.deleteImage(interecommunionImages,RealPathUtil.getRealPath());		//删除图片
			
			for(Image image:interecommunionImages){
				imageDao.delete(image);				//从数据库中删除与图片有关的信息
			}
			
			if(null==interecommunion.getImages()) interecommunion.setImages(new HashSet<Image>());
			for(Image image:images){
				interecommunion.getImages().add(image);
			}
		}
		
		
		interecommunion.setDate(date);
		interecommunion.setContent(content);
		interecommunion.setPresenter(presenter);
		interecommunion.setSpeaker(speaker);
		interecommunion.setTheme(theme);
		
		interecommunionDao.update(interecommunion);
		
	}
	
	//查找
	public DS_Interecommunion getInterecommunionDetail(int currentPage) {
		
		List<DS_Interecommunion> l = interecommunionDao.findByPage("from DS_Interecommunion ", (currentPage-1)*pageSize, pageSize);
		
		if(null==l||l.size()<=0){
			return null;
		}
		
		return l.get(0);
	}
	
	//创建
	public void createInterecommunion(String theme, String date,
			String speaker, String presenter, String content, Set<Image> images) {
		
		
		interecommunion.setDate(date);
		interecommunion.setContent(content);
		interecommunion.setImages(images);
		interecommunion.setPresenter(presenter);
		interecommunion.setSpeaker(speaker);
		interecommunion.setTheme(theme);
		
		interecommunionDao.save(interecommunion);
		
	}
	
	//根据id来删除接口
	public void deleteInterecommunion(String InterecommunionId) {
		
		interecommunion = interecommunionDao.get(DS_Interecommunion.class, InterecommunionId);
		
		Set<Image> images = interecommunion.getImages();	//得到图片
		
//		System.out.println(images.size());
//		
//		for(Image image:images){
//			System.out.println(image.getPath());
//		}
		
		imageFunction.deleteImage(images,RealPathUtil.getRealPath());		//删除图片
		
		for(Image image:images){
			imageDao.delete(image);				//从数据库中删除与图片有关的信息
		}
		
		interecommunionDao.delete(interecommunion);				//从数据库中删除Interecommunion相关信息
		
	}

	public List<DS_Interecommunion> getInterecommunions(int currentPage) {

		return interecommunionDao.findByPage("select new DS_Interecommunion(id,theme,date,speaker) from DS_Interecommunion ", (currentPage-1)*admPageSize, admPageSize);
	}

	public Long getCountAll() {
		return interecommunionDao.findCount(DS_Interecommunion.class);
	}

	public DS_Interecommunion getInterecommunionById(String id) {
		return interecommunionDao.get(DS_Interecommunion.class, id);
	}
	
}
