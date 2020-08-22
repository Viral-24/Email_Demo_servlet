package com.learinig.sevletjsp.userinfro;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Send_Email {

	public String getRandom() {
		Random rnd=new Random();
		int number =rnd.nextInt(999999);
		return String.format("%06d",number);
	}
	
	public boolean sendEmail(UserInfo UserInfo) {
		boolean test=false;
		String toEmail=UserInfo.getEmail();
		final String fromemail="";//Enter the Email form which you want to send mail
		final String password="";//Enter the App password of 16 
		
		try {
			Properties pro=new Properties();
			  pro.put("mail.smtp.auth","true");
			  pro.put("mail.smtp.starttls.enable","true");
			  pro.put("mail.smtp.host", "smtp.gmail.com");
			  pro.put("mail.smtp.port", "587");
			
			  Session session=Session.getInstance(pro, new Authenticator() {
				  protected PasswordAuthentication getPasswordAuthentication() {
					  return new PasswordAuthentication(fromemail, password);
				  }
			});
			  
			  Message message= new MimeMessage(session);
			  message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			  
			  message.setSubject("User Email Verication !!!");
			  
			  message.setText("Registered Successfully.Please Verify your Account using this Code :"+UserInfo.getCode());
			  
			  Transport.send(message);
			  
			  test=true;
		}
		catch (Exception e) {
			System.out.println("Error in Send_Email at sendemail"+e);
		}
		return test;
	}
}
