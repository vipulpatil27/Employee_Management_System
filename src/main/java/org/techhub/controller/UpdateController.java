package org.techhub.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.techhub.model.Student;
import org.techhub.service.StudentService;


@WebServlet("/update")
public class UpdateController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//out.println("I am UPDATE cotroller");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>i am servlet page</title>");
		out.println("<style>input{ width:400px; height:40px; margin-left:100px; }</style>");
		out.println("</head>");
		out.println("<body>");  
		RequestDispatcher r = request.getRequestDispatcher("navigation.html");
		r.include(request, response);
		String name=request.getParameter("n");
		String email=request.getParameter("e");
		String contact=request.getParameter("c");
		int studId=Integer.parseInt(request.getParameter("sid"));
		out.println("<br></br>");
		//POST method=file uploading or to not show data to user
		//enctype = file uploading
		//when action is blank then form is submit on same page
		out.println("<form name='frm' action='' method='POST'>");
		out.println("<input type='hidden' name='sid' value='"+studId+"' placeholder='Enter name'/><br><br>");
		out.println("<input type='text' name='name' value='"+name+"' placeholder='Enter name'/><br><br>");
		out.println("<input type='text' name='email' value='"+email+"' placeholder='Enter email'/><br><br>");
		out.println("<input type='text' name='contact' value='"+contact+"' placeholder='Enter contact'/><br><br>");
		out.println("<input type='file' name='photo' value'' /><br><br>");
		out.println("<input type='submit' name='s' value='Update Student Record'/><br><br>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		String button=request.getParameter("s");
		if(button!=null) //button is cliked
		{
			name=request.getParameter("name");
			email=request.getParameter("email");
			contact=request.getParameter("contact");
			studId=Integer.parseInt(request.getParameter("sid"));
			Student s=new Student();
			s.setName(name);
			s.setEmail(email);
			s.setContact(contact);
			s.setId(studId);
			StudentService sService=new StudentService();
			boolean b=sService.isUpdate(s);
			if(b) {
				RequestDispatcher rd=request.getRequestDispatcher("view");
				r.forward(request, response);
			}
			else
			{
				out.println("<h1>Some Problem is there...../</h1>");
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}