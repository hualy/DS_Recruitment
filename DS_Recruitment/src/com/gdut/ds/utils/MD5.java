package com.gdut.ds.utils;
import java.io.UnsupportedEncodingException;
import java.security.*;

public class MD5 {									
	
	
	public static byte[] MD5Run(String str)  {						//MD5加密
		
		MessageDigest md5 = null;
		
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		str += str.concat(String.valueOf(str.hashCode()));
		
		try {
			//return new String(md5.digest(new String(str).getBytes("iso-8859-1")),"utf-8");
			return md5.digest(new String(str).getBytes("iso-8859-1"));
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public static boolean compareTo(byte[] p1, byte[] p2){			//MD5加密后的比较
		
		boolean result = false;
		int tag = 0;
		
		for(int i = 0; i < p1.length; i++){
			
			if(p1[i] == p2[i]) tag++;
		}
		
//		System.out.println(tag == p1.length);
		
		if(tag == p1.length) result = true;
		
		return result;
	}
	
}
