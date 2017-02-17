package com.gdut.ds.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gdut.ds.beans.informationManagement.Notice;
import com.gdut.ds.beans.informationManagement.Recruitment;

public class TimeTools {

//	public static void main(String[] args) {
//		
//		System.out.println(new Date().toLocaleString());
//	}
	
	
	/*
	 * 字符串转为日期
	 */
	public static Date praseDate(String s){
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateTime = null;
		try {
			dateTime = dateFormat.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dateTime;
	}

	
	/*
	 * 日期转为字符串
	 */
	public static String praString(Date date){
		
		String s = null;
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		s = dateFormat.format(date);
		
		return s;
	}
	
	
	/*
	 * 返回一个记录着公告分组信息
	 */
	@SuppressWarnings("deprecation")
	public static int[] divideTheNoticeListByMonths(List<Notice> noticeList){
		
//		int n;															//获取一共有几个分组
//		
//		if(noticeList.get(0).getTime().getYear() != noticeList.get(noticeList.size() - 1).getTime().getYear()){
//			
//			n = noticeList.get(0).getTime().getMonth() 
//			- noticeList.get(noticeList.size() - 1).getTime().getMonth() + 1 +
//			+(noticeList.get(0).getTime().getYear() - noticeList.get(noticeList.size() - 1).getTime().getYear()) * 12;
//			
//		}else{
//			
//			n = noticeList.get(0).getTime().getMonth() 
//			- noticeList.get(noticeList.size() - 1).getTime().getMonth() + 1;
//		}
		
		int[] monthnums = new int[13];									//记录所在的月份信息
		
		for(int k = 0; k < monthnums.length; k++) monthnums[k] = 0;		//数组初始化
		
		int basemonth = noticeList.get(0).getTime().getMonth();
		for(int i = 0; i < noticeList.size(); i++){						

			if(noticeList.get(i).getTime().getMonth() == basemonth){
				monthnums[basemonth + 1]++;
			}else{
				basemonth = noticeList.get(i).getTime().getMonth();
				monthnums[basemonth + 1]++;
			}
			
		}
		
		return monthnums;
	}
	
	/*
	 * 返回一个记录着招新信息分组信息
	 */
	@SuppressWarnings("deprecation")
	public static int[] divideTheRecruitmentListByMonths(List<Recruitment> reList){
	
//		int n;													//表示根据月份已经分为n组
//		
//		if(reList.get(0).getTime().getYear() != reList.get(reList.size() - 1).getTime().getYear()){
//			n = reList.get(0).getTime().getMonth() 
//				- reList.get(reList.size() - 1).getTime().getMonth() + 1 +
//				+(reList.get(0).getTime().getYear() - reList.get(reList.size() - 1).getTime().getYear()) * 12;
//			
//		}else{
//			
//			n = reList.get(0).getTime().getMonth() 
//			- reList.get(reList.size() - 1).getTime().getMonth() + 1;
//		}
		
		int[] monthnums = new int[13];							
		
		for(int k = 0; k < monthnums.length; k++) monthnums[k] = 0;				//数组初始化
		
		int basemonth = reList.get(0).getTime().getMonth();
		for(int i = 0; i < reList.size(); i++){
			
			if(reList.get(i).getTime().getMonth() == basemonth){
				monthnums[basemonth + 1]++;
			}else{
				basemonth = reList.get(i).getTime().getMonth();
				monthnums[basemonth + 1]++;
			}
			
		}
		return monthnums;
	}
	
	
	/*
	 *	将公告信息和招新信息混合后排序
	 */
	public static Map<String, Object> mixUpAllTheInformation(List<Notice> noticeList, List<Recruitment> reList){
		
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String[] infoName = new String[noticeList.size() + reList.size()];
	
		
		if(noticeList.size() != 0 && reList.size() != 0){
			
			List<Object> infoList = sortAllTheInformation(noticeList, reList, infoName);
			
			int[] monthnums = combineTheMonthsInfo(divideTheNoticeListByMonths(noticeList), divideTheRecruitmentListByMonths(reList));
			
			infoMap.put("infoList", infoList);
			
			infoMap.put("infoName", infoName);
			
			infoMap.put("monthnums", monthnums);

			
		}else if(noticeList.size() == 0 && reList.size() != 0){
			
			for(int i = 0; i < infoName.length; i++){
				
				infoName[i] = "recruitment";
			}
			
			int[] monthnums = divideTheRecruitmentListByMonths(reList);
			
			infoMap.put("infoList", reList);
			
			infoMap.put("infoName", infoName);
			
			infoMap.put("monthnums", monthnums);
			
		}else if(noticeList.size() != 0 && reList.size() == 0){
			
			for(int i = 0; i < infoName.length; i++){
				
				infoName[i] = "notice";
			}
			int[] monthnums = divideTheNoticeListByMonths(noticeList);
			
			infoMap.put("infoList", noticeList);
			
			infoMap.put("infoName", infoName);
			
			infoMap.put("monthnums", monthnums);
			
		}else{
			
			return null;
		}
		
		
		return infoMap;
	}
	
	
	/*
	 * 对公告和招新信息进行整体的排序
	 */
	public static List<Object> sortAllTheInformation(List<Notice> noticeList, List<Recruitment> reList, String[] infoName){
		
		List<Object> infoList = new ArrayList<Object>();
		int i = 0, j = 0, k = 0;
		
		while(i < noticeList.size() && j < reList.size()){
			
			if(noticeList.get(i).getTime().compareTo(reList.get(j).getTime()) > 0){
				
				infoList.add(noticeList.get(i));
				infoName[k++] = "notice";
				i++;
				
			}else{
				
				infoList.add(reList.get(j));
				infoName[k++] = "recruitment";
				j++;
			}
			
		}
		while(i < noticeList.size()){
			
			infoList.add(noticeList.get(i));
			infoName[k++] = "notice";
			i++;
		}
		while(j < reList.size()){
			
			infoList.add(reList.get(j));
			infoName[k++] = "recruitment";
			j++;
		}
		
		
		return infoList;
	}
	
	
	
	/*
	 * 合并两个月的信息
	 */
	private static int[] combineTheMonthsInfo(int[] a, int[] b) {
		
		int t[] = new int[13];
		
		for(int i = 0; i < t.length; i++){
			
			t[i] = a[i] + b[i];
		}

		return t;
	}
}
