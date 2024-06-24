package org.techhub.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import org.techhub.model.*;
import org.techhub.service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAllRecords
 */
@WebServlet("/View")
public class ViewAllRecords extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		StudentService studService=new StudentService();
		List<Student>list=studService.getAllRecords();
		RequestDispatcher r=request.getRequestDispatcher("navigation.html");
		r.include(request, response);
		out.println("<br><br>");
//		ServletContext context=this.getServletContext();
//		String serverPath=context.getRealPath("/");
		out.println("<table border='5' align='center' width='50%'>");
		out.println("<tr><th>NAME</th><th>EMAIL</th><th>CONTACT</th><th>PHOTO</th><th>DELETE</th><th>UPDATE</th></tr>");
		for(Student s:list)
		{
			int studId=s.getId();
			out.println("<tr>");
			out.println("<td>"+s.getName()+"</td>");
			out.println("<td>"+s.getEmail()+"</td>");
			out.println("<td>"+s.getContact()+"</td>");
			out.println("<td><img src='images/"+s.getPhoto()+"' width='100px' height='100px' alt='image not found'/></td>");
			out.println("<td><a href='del?studentId="+studId+"'>DELETE</a></td>");
			out.println("<td><a href='update?n="+s.getName()+"&e="+s.getEmail()+"&c="+s.getContact()+"&sid="+studId+"'>UPDATE</a></td>");
			out.println("</tr>");
		}
		out.println("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
