package com.gdut.ds.serviceImpl;

import java.io.File;

import com.gdut.ds.beans.introduction.Image;
import com.gdut.ds.dao.introduction.ActivityDao;
import com.gdut.ds.dao.introduction.ArticleDao;
import com.gdut.ds.dao.introduction.ImageDao;
import com.gdut.ds.dao.introduction.InterecommunionDao;
import com.gdut.ds.dao.introduction.ResultDao;
import com.gdut.ds.service.ImageService;

public class ImageServiceImpl implements ImageService {
	
	private ImageDao imageDao;
//	private ActivityDao activityDao;
//	private ArticleDao articleDao;
//	private ResultDao resultDao;
//	private InterecommunionDao interecommunionDao;
	
	public ImageDao getImageDao() {
		return imageDao;
	}

	public void setImageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}

//	public ActivityDao getActivityDao() {
//		return activityDao;
//	}
//
//	public void setActivityDao(ActivityDao activityDao) {
//		this.activityDao = activityDao;
//	}
//
//	public ArticleDao getArticleDao() {
//		return articleDao;
//	}
//
//	public void setArticleDao(ArticleDao articleDao) {
//		this.articleDao = articleDao;
//	}
//
//	public ResultDao getResultDao() {
//		return resultDao;
//	}
//
//	public void setResultDao(ResultDao resultDao) {
//		this.resultDao = resultDao;
//	}
//
//	public InterecommunionDao getInterecommunionDao() {
//		return interecommunionDao;
//	}
//
//	public void setInterecommunionDao(InterecommunionDao interecommunionDao) {
//		this.interecommunionDao = interecommunionDao;
//	}

	public void deleteImage(String imageId) {
		
		Image image = imageDao.get(Image.class, imageId);		//根据ID来得到实体
//		String content = null;
		
		if(image==null) return;
		
//		//得到含有图片标记的内容，然后去除掉
//		switch(image.getType()){
//			case Image.TYPE_ACTIVITY:			//如果是活动类型的图片，则得到的是文章的内容
//				content = image.getActivity().getContent();break;
//			case Image.TYPE_ARTICLE:			//如果是推送的图片，则得到的是推送的内容
//				content = image.getArticle().getContent();break;
//			case Image.TYPE_INTERECOMMUNION: 	//如果是交流会的图片，则得到的是交流会的内容
//				content = image.getInterecommunion().getContent();break;
//			case Image.TYPE_RESULT:				//如果是成果的图片，则得到的是成果的图片
//				content = image.getResult().getDescription();break;
//		}
//		
//		//除去内容中含有该图片的内容
//		content = content.replace("<img src='images/result/"+image.getPath().substring(image.getPath().lastIndexOf('/')+1)+"' />", "");
		
		//刷新原来的内容，并更新保存
//		switch(image.getType()){
//		case Image.TYPE_ACTIVITY:			//如果是活动类型的图片，则更新的是文章的内容
//			image.getActivity().setContent(content);
//			activityDao.update(image.getActivity());break;
//		case Image.TYPE_ARTICLE:			//如果是推送的图片，则更新的是推送的内容
//			image.getArticle().setContent(content);
//			articleDao.update(image.getArticle());
//			break;
//		case Image.TYPE_INTERECOMMUNION: 	//如果是交流会的图片，则更新的是交流会的内容
//			image.getInterecommunion().setContent(content);
//			interecommunionDao.update(image.getInterecommunion());
//			break;
//		case Image.TYPE_RESULT:				//如果是成果的图片，则更新的是成果的内容
//			image.getResult().setDescription(content);
//			resultDao.update(image.getResult());
//			break;
//	}
		
	//删除图片文件本身
		File file = new File(image.getPath());
		if(file.exists()){
			file.delete();
		}
	//删除图片
		imageDao.delete(image);		
	}
	

	
}
