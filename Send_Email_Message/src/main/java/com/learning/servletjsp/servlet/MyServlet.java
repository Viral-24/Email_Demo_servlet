package com.learning.servletjsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String action = request.getPathInfo().toString();
		
		//System.out.println(action);
		sendemail(request, response);

	}

	private void sendemail(HttpServletRequest request, HttpServletResponse response) throws IOException {

		  response.setContentType("text/html");
		  PrintWriter out=response.getWriter();
		  
		  String email=request.getParameter("email");
		  String subject=request.getParameter("subject");
		  String message=request.getParameter("message");
		  
		 final String fromemail="";//Enter the Email form which you want to send mail
		 final  String password="";//Enter the App password of 16 
		  
		  
		  Properties propos=new Properties();
		  propos.put("mail.smtp.auth","true");
		  propos.put("mail.smtp.starttls.enable","true");
		  propos.put("mail.smtp.host", "smtp.gmail.com");
		  propos.put("mail.smtp.port", "587");
		  
		  Session session=Session.getInstance(propos,
				  new javax.mail.Authenticator(){
			  protected PasswordAuthentication getPasswordAuthentication() {
				  return new PasswordAuthentication(fromemail, password);
			  }
		  });
		  
		  try {
			  	Message msg=new MimeMessage(session);
			  	msg.setFrom(new InternetAddress(fromemail));
			  	msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email));
			  	msg.setSubject(subject);
			  	msg.setText(message);
			  	Transport.send(msg);
			  	
			  	out.println("<!Doctype html>");
				 out.println("<html>");
				 out.println("<head>");
				 out.println("<title>Mail Status</title>");
				 out.println("</head>");
				 out.println("<body>");
				 out.println("<h1>Mail Status !!!</h1>");
				 out.println("<b>Mail Send Successfully!!!</b><br>");
				 out.println("Click <a href='http://localhost:8080/Send_Email_Message/'>here</a> to go back!!");
				 out.println("</body>");
				 out.println("</html>");
		  }
		  
		  catch(Exception e) {
			  System.out.println(e);
			  out.print("Something when Wrong");
		  }
		 
	}

}
