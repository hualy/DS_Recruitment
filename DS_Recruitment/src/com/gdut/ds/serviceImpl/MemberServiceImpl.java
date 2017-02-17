package com.gdut.ds.serviceImpl;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.gdut.ds.beans.introduction.DS_Member;
import com.gdut.ds.dao.introduction.ImageDao;
import com.gdut.ds.dao.introduction.MemberDao;
import com.gdut.ds.service.MemberService;
import com.gdut.ds.utils.ImageFunction;
import com.gdut.ds.utils.RealPathUtil;

public class MemberServiceImpl implements MemberService {
	
	private static final int pageSize = 4;   //设置查看结果页面的页数为1
	
	private static final int admPageSize = 10; //后台查看的页面数为8
	
	private MemberDao memberDao;
	
	private DS_Member member;
	
	private ImageFunction imageFunction;
	
	private ImageDao imageDao;
	
	
	
	
	
	public MemberDao getMemberDao() {
		return memberDao;
	}




	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}




	public DS_Member getMember() {
		return member;
	}




	public void setMember(DS_Member member) {
		this.member = member;
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




	//查找
	public List<DS_Member> getMemberDetail(int majorOnDs) {
		
		return memberDao.find("from DS_Member m where m.majorOnDs=? order by grade ", majorOnDs);
	}
	
	
	
	
	//根据id来删除接口
	public void deleteMember(String memberId) {
		
		member = memberDao.get(DS_Member.class, memberId);
		
		//Image image = member.getImage();	//得到图片
		
//		System.out.println(images.size());
//		
//		for(Image image:images){
//			System.out.println(image.getPath());
//		}
		
		//imageFunction.delete(image,RealPathUtil.getRealPath());		//删除图片
		
		
			//imageDao.delete(image);				//从数据库中删除与图片有关的信息
		
		String imagePath = member.getImage();
		
		imageFunction.delete(imagePath, RealPathUtil.getRealPath());	//删除图片
		
		
		memberDao.delete(member);				//从数据库中删除Member相关信息
		
	}

	//创建
	public void createMember(String name,boolean female,int majorOnDs,String major,int grade,int cla,String description,String img,String leavingWord,String savePath) {
		
		img = imageFunction.dealImageForMember(img, savePath);
		
//		System.out.println("img"+img);
		
		member.setCla(cla);
		member.setDescription(description);
		member.setFemale(female);
		member.setImage(img);
		member.setLeavingWord(leavingWord);
		member.setMajorOnDs(majorOnDs);
		member.setGrade(grade);
		member.setMajor(major);
		member.setName(name);
		
		memberDao.save(member);
	}

	//更新
	public void updateMember(String id,String name,boolean female,int majorOnDs,String major,int grade,int cla,String description,String img,String leavingWord,String savePath) {
		
		member = memberDao.get(DS_Member.class, id);
		
		if(!img.equals(member.getImage())){
			img = imageFunction.dealImageForMember(img, savePath);
		}
		
		member.setCla(cla);
		member.setDescription(description);
		member.setFemale(female);
		member.setImage(img);
		member.setLeavingWord(leavingWord);
		member.setMajorOnDs(majorOnDs);
		member.setGrade(grade);
		member.setMajor(major);
		member.setName(name);
		
		memberDao.update(member);
		
	}




	public List<DS_Member> getMember(int currentPage) {
		
		return	memberDao.findByPage("select new DS_Member(id,name,cla,grade) from DS_Member", (currentPage-1)*admPageSize, admPageSize);
		
	}

	public Long getCountAll() {
		return memberDao.findCount(DS_Member.class);
	}




	public DS_Member getMemberById(String id) {
		
		return memberDao.get(DS_Member.class, id);
	}




	public void deleteTempImage() {
		String path = RealPathUtil.getRealPath()+"/images/member/temp/" +ServletActionContext.getRequest().getSession().getId();
		imageFunction.deleteTempImage(path);
		
	}
	
}
