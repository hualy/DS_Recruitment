package com.gdut.ds.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
	
														//这是对request进行计数，不过不够科学。（已弃用）
	private String adminName = "root";
	
	private String password = "ds616ds";				//到时记得改数据密码
	
															
	public void contextDestroyed(ServletContextEvent arg0) {
	
		ServletContext context = arg0.getServletContext();
		int count = (Integer)context.getAttribute("count");
		
		Connection connection = getConnection();
		try {
			
			Statement statement = connection.createStatement();
			
			 ResultSet r1 = statement.executeQuery("SELECT COUNT(*) as sums FROM pageviews;");
			 int sum = 0;
			 if(r1.next()) sum = r1.getInt("sums");
			
			statement.execute("insert INTO pageviews(id,totality,closeTime) VALUES("+(sum + 1)+","+count +",now());");
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
	}

	public void contextInitialized(ServletContextEvent arg0) {			//监听器初始化的操作
		
		ServletContext context = arg0.getServletContext();
		int count = 0;
		
		Connection dbConn = getConnection();
		
		try{  
		  Statement statement = dbConn.createStatement();
		    
		  String sql = "SELECT * FROM pageviews ORDER BY closeTime DESC limit 0,1";  
		  ResultSet resultSet = statement.executeQuery(sql);
//		  System.out.println(resultSet.getString(1));		//id号
//		  System.out.println(resultSet.getString(2));		//上次服务器关闭前记录的浏览量
//		  System.out.println(resultSet.getString(3));		//上次服务器关闭的时间
		  if(resultSet.next()) count = Integer.parseInt(resultSet.getString(2));
		 
		}catch(Exception e){
			  
			 e.printStackTrace();	
		} 
		

		context.setAttribute("count", count);

	}
	
	
	private Connection getConnection(){								//JDBC连接数据
		
		Connection dbConn = null; 
		String driverName = "com.mysql.jdbc.Driver";

		String dbURL = "jdbc:mysql://127.0.0.1:3306/ds_recruitment?useUnicode=true&characterEncoding=utf8";     
		 
		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL,adminName,password); 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}

		return dbConn;
	}

}
