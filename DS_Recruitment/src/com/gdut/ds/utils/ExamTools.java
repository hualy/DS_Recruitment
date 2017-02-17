package com.gdut.ds.utils;

public class ExamTools {

	public static void main(String[] args) {
		
		String[] s = {"1","2","3","4","5"};
		String[] si = {"2","1","2"};
		
		String[] s2 = transfromAnswer(s, si);
		
		for(int i = 0; i < s2.length; i++){
			
			System.out.println(s2[i]);
		}
		
		String[] s3 = divideAnswers(s2[0]);
		System.out.println("拆分后：");
		for(int j = 0; j < s3.length; j++){
			System.out.println(s3[j]);
		}
	}
	
	
	/*
	 * 用于填空题答案的分组
	 */
	public static String[] transfromAnswer(String[] aw, String[] num){
		
		String[] result = new String[num.length];

		int k = 0,m = 0;
		for(int i = 0; i < num.length; i++){
		
			if(Integer.parseInt(num[i]) == 1){						//当答案数为一时，就是一个答案
				
				result[k++] = aw[m++];
				
			}else{
				
				StringBuffer stringBuffer = new StringBuffer();
				for(int j = 0; j < Integer.parseInt(num[i]); j++){
					
					stringBuffer.append(aw[m]);
					if(j != Integer.parseInt(num[i]) - 1) stringBuffer.append("_");
					m++;
				}
				result[k++] = stringBuffer.toString();
			}
			
		}
		
		return result;
	}
	
	
	/*
	 * 用于填空题答案的拆分
	 */
	public static String[] divideAnswers(String as){
		
		String[] a = new String[10];
		
		a = as.split("_");
		
		return a;
	}
	
}
