package com.gdut.ds.utils;

import org.apache.struts2.ServletActionContext;

public class RealPathUtil {
	
	private static String realPath = null;
	
	static{
		realPath = ServletActionContext.getRequest().getRealPath(".");
		realPath = realPath.replace('\\', '/');
//		System.out.println("Static realPath:"+realPath);
	}

	public static String getRealPath() {
		return realPath;
	}

	public static void setRealPath(String realPath) {
		RealPathUtil.realPath = realPath;
	}
	
}
