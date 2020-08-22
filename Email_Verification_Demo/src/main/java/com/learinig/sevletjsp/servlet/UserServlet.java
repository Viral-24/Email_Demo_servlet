package com.learinig.sevletjsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learinig.sevletjsp.userinfro.Send_Email;
import com.learinig.sevletjsp.userinfro.UserInfo;


public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UserServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sendemail(request,response);	

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getPathInfo().toString();
		//doGet(request, response);
		System.out.println(action+1);
	
			 verifycode(request,response);	       

	
	}

	private void verifycode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		UserInfo user=(UserInfo) session.getAttribute("authcode");
		String code=request.getParameter("authcode");
		
		if(code.equals(user.getCode())) {
			out.print("Veriction Done");
		}
		else {
			out.print("Something when Wrong");
		}
		
	}

	private void sendemail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String name=request.getParameter("username");
		String email=request.getParameter("usermail");
		
		Send_Email sm= new Send_Email();
		String code=sm.getRandom();
		
		UserInfo user=new UserInfo(name, email, code);
		
		boolean test=sm.sendEmail(user);
		System.out.println(test+"check");
		if(test) {
			HttpSession session=request.getSession();
			session.setAttribute("authcode", user);
			response.sendRedirect("http://localhost:8080/Email_Verification_Demo/vericationcode.jsp");	
		}
		
	}

}
