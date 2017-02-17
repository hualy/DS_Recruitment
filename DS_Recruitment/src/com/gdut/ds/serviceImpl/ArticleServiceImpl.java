package com.gdut.ds.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.gdut.ds.beans.introduction.DS_Article;
import com.gdut.ds.beans.introduction.Image;
import com.gdut.ds.dao.introduction.ImageDao;
import com.gdut.ds.dao.introduction.ArticleDao;
import com.gdut.ds.service.ArticleService;
import com.gdut.ds.utils.ImageFunction;
import com.gdut.ds.utils.RealPathUtil;

public class ArticleServiceImpl implements ArticleService {
	
	private static final int pageSize = 1;   //设置查看结果页面的页数为1
	
	private static final int admPageSize = 10;   //设置查看结果页面的页数为1
	
	private ArticleDao articleDao;
	
	private DS_Article article;
	
	private ImageFunction imageFunction;
	
	private ImageDao imageDao;
	
	public ArticleDao getArticleDao() {
		return articleDao;
	}


	public void setArticleDao(ArticleDao ArticleDao) {
		this.articleDao = ArticleDao;
	}

	

	
	public DS_Article getArticle() {
		return article;
	}


	public void setArticle(DS_Article article) {
		this.article = article;
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
	
	public void updateArticle(String id, String theme, String date,
			String lanucher, String description, String content,
			String xheSavePath,String savePath) {
		DS_Article article = articleDao.get(DS_Article.class, id);
		String[] string = article.getContent().split("<img");
		for(int i =1;i<string.length;i++){
			int start = string[i].indexOf("src")+5;
			int end = string[i].indexOf("\"",string[i].indexOf('\"')+1);
			
			//String webRoot = ServletActionContext.getRequest().getRealPath(".");
			try{
				//删除图片文件本身
				String path = string[i].substring(start, end);
				if(content.indexOf(path)!=-1||path.indexOf("http")!=-1)
					continue;			//如果在更新的内容里面，则不用删除图片,或者是网络图片
				
				File file = new File(RealPathUtil.getRealPath()+"/"+path);
				
				if(file.exists()){
					file.delete();
				}
			}catch(Exception e){
				System.out.println("ArticleServiceImpl updataArticle error when deleting image");
			}
		}
		
		content = dealTemp(content, xheSavePath); //处理content里面的临时文件
		
		article.setDate(date);
		article.setDescription(description);
		article.setContent(content);
		article.setTheme(theme);
		article.setLanucher(lanucher);
		articleDao.update(article);
		
	}



	//查找
	public List<DS_Article> getArticle(int currentPage) {
		
		return articleDao.findByPage("select new DS_Article(id,theme,date,lanucher) from DS_Article ", (currentPage-1)*admPageSize, admPageSize);
	}
	
	
	private String dealTemp(String content,String xheSavePath){
		int srcPoint=0 ;
		
		while((srcPoint=content.indexOf("src=",srcPoint+1))!=-1){
			String imageName = content.substring(srcPoint+5,content.indexOf("\"",srcPoint+5));
			
			//如果找到的不是临时文件则不能按照临时文件的操作
			if(imageName.indexOf("temp")==-1){
				continue;
			}
			
//			System.out.println("ArticleServiceImpl imageName:"+imageName);
			
			File file = new File(RealPathUtil.getRealPath()+"/"+imageName);
			if(file.exists()){
				String contentImagePath = "images/article/"+imageName.substring(imageName.lastIndexOf("/")+1);
				
				File outFile = new File(RealPathUtil.getRealPath()+"/"+contentImagePath);	//输出的图片			
				
				FileInputStream fis = null;
				FileOutputStream fos =null;
				try {
					fis = new FileInputStream(file);
					fos = new FileOutputStream(outFile);
					byte[] b = new byte[1024];
					int c;
					while((c=fis.read(b))!=-1){
						fos.write(b,0,c);
					}
					
					content = content.replace(imageName, contentImagePath);
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				catch(IOException e){
					e.printStackTrace();
				}finally{
					try {
						if(fis!=null)
							fis.close();
						if(fos!=null)
							fos.close();
						} catch (IOException e) {
							
							e.printStackTrace();
						}
				}
			}else{
				System.out.println("图片不存在");
			}
			
		}
		
		//删除临时存储的文件
		File tempFile = new File(RealPathUtil.getRealPath()+"/"+xheSavePath);
		if(tempFile.exists()){ 			
			//System.out.println("父目录存在");
			File[] files = tempFile.listFiles();
			if(files!=null)
				for(File f :files){
					f.delete();
				}
			
			tempFile.delete();
		}
		
		return content;
	}
	
	
	//创建
	public void createArticle(String theme, String date, String lanucher,
			String description, String content,String xheSavePath) {
		
		xheSavePath += "/"+ServletActionContext.getRequest().getSession().getId();
		
//		System.out.println("ArticleServiceImpl xheSavePath:"+xheSavePath);
		
		content = dealTemp(content, xheSavePath); //处理临时文件
		
		article.setDate(date);
		article.setDescription(description);
//		if(article.getImages()==null) article.setImages(new HashSet<Image>(0));
//		if(images!=null){
//			for(Image image:images){
//				article.getImages().add(image);
//			}
//		}
		article.setContent(content);
//		article.setImages(images);
		article.setTheme(theme);
		article.setLanucher(lanucher);
		articleDao.save(article);
	}
	
	
	
	//根据id来删除接口
	public void deleteArticle(String articleId) {
		
		article = articleDao.get(DS_Article.class, articleId);
		
		if(article==null) return;
		
//		Set<Image> images = article.getImages();	//得到图片
//		
//		imageFunction.deleteImage(images, RealPathUtil.getRealPath());  //删除图片本身
//		
//		article.setImages(null);
//		
//		for(Image image:images){
//			imageDao.delete(image);  //从数据库中删除图片
//		}
		
//		System.out.println(images.size());
//		
//		for(Image image:images){
//			System.out.println(image.getPath());
//		}
		
//		imageFunction.deleteImage(images,RealPathUtil.getRealPath());		//删除图片
		
		//删除内容中的图片
		
		if(null!=article.getContent()){
			String[]	string = article.getContent().split("<img");
			
			//String webRoot = ServletActionContext.getRequest().getRealPath(".");
			for(int i =1;i<string.length;i++){
				int start = string[i].indexOf("src")+5;
				int end = string[i].indexOf("\"",string[i].indexOf('\"')+1);
				try{
					String imagePath = RealPathUtil.getRealPath()+"/"+string[i].substring(start, end);
					if(imagePath.indexOf("http")!=-1) continue;	//如果是网络图片则不用删除
					//删除图片文件本身
					File file = new File(imagePath);
					if(file.exists()){
						file.delete();
					}
				}catch(Exception e){
					System.out.println("ArticleServiceImpl updataArticle error when deleting image");
				}
			}
		}
		
		
		articleDao.delete(article);				//从数据库中删除Article相关信息
		
	}


	public DS_Article getArticleById(String id) {
		return articleDao.get(DS_Article.class, id);
	}


	public Long getCountAll() {
		return articleDao.findCount(DS_Article.class);
	}


	public DS_Article getArticleDetail(int currentPage) {
		List<DS_Article> l = articleDao.findByPage(" from DS_Article ", (currentPage-1)*pageSize, pageSize);
		if(l==null||l.size()<=0) return null;
		
		return l.get(0);
	}


	public void deleteTempImage() {
		
		String path = RealPathUtil.getRealPath()+"/images/article/temp/" +ServletActionContext.getRequest().getSession().getId();
		imageFunction.deleteTempImage(path);
	}
	
}
