package com.gdut.ds.utils;



import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Mail extends Thread{
	
	private String email;
	private String title;
	private String content;
	
	
	public Mail(String email,String title,String content){
		this.email = email;
		this.title = title;
		this.content = content;
	}
	
	@Override
	public void run() {
		sendMail();
	}
	
	public void sendMail(){
		
//		System.out.println(email);
		
		Properties prop = new Properties();
		
		prop.setProperty("mail.smtp.auth", "true");		//设置为要认证
		prop.setProperty("mail.transport.protocol", "smtp");	//设置协议
		
		Session session = Session.getInstance(prop);
		
//		session.setDebug(true);			//设置debug为真
		
		Message msg = new MimeMessage(session);
		
		try {
			msg.setSubject(title);		//设置题目	
//			msg.setText(content);		//设置内容
			msg.setContent(content, "text/html;charset=utf-8");
			msg.setFrom(new InternetAddress("gdut_ds2015@sina.com")); //设置来源地址
			msg.saveChanges();				//保存更改
			
			Transport tran = session.getTransport();		//发送器
			
			tran.connect("smtp.sina.com", 25, "gdut_ds2015","gdut_ds2016");
			
			
			Address address = null;
//			System.out.println(lw.getEmail());
			try{
				address = new InternetAddress(email);
			}catch(MessagingException e){
				System.out.println("==========Email Address is not exist========");
			}
			
			
//			List<Address>  addresses = new ArrayList<Address>(emailAddresses.size());		//将发送的地址全部转为address类型
			
//			for(String emailAddress:emailAddresses){
//				try{
//					addresses.add(new InternetAddress(emailAddress));
//				}catch(MessagingException e){
//					System.out.println("==========Email Address is not exist========");
//				}
//			}
			
//			Address[] emails = new InternetAddress[addresses.size()] ;
//			
//			addresses.toArray(emails);
			
			//System.out.println(emails[0].toString());
			
			tran.sendMessage(msg,new Address[]{address} );
			
			tran.close();
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}			

		
	}
	
//	public static void main(String[] args) throws MessagingException {
//		
//		List<String> emailAddresses = new ArrayList<String>();
//		
//		emailAddresses.add("1570590121@qq.com");
//		
//		emailAddresses.add("1570590121@qq.com");
//		
//		emailAddresses.add("1570590121@qq.com");
//		
//		Mail mail = new Mail();
//		
//		mail.sendMail(emailAddresses, "测试", "测试");
//		
//	}

}
