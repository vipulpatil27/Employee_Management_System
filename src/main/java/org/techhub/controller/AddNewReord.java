package org.techhub.controller;

import java.io.IOException;
import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;                
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;    
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addrecord")
public class AddNewReord extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>i am servlet page</title>");
		out.println("<style>input{ width:400px; height:40px; margin-left:100px; }</style>");
		out.println("</head>");
		out.println("<body>");
		RequestDispatcher r = request.getRequestDispatcher("navigation.html");
		r.include(request, response);
		out.println("<br></br>");
		out.println("<form name='frm' action='save' method='POST' enctype='multipart/form-data'>");
		//POST method=file uploading or to not show data to user
		//enctype = file uploading
		out.println("<input type='text' name='name' value='' placeholder='Enter name'/><br><br>");
		out.println("<input type='text' name='email' value'' placeholder='Enter email'/><br><br>");
		out.println("<input type='text' name='contact' value'' placeholder='Enter contact'/><br><br>");
		out.println("<input type='file' name='photo' value'' /><br><br>");
		out.println("<input type='submit' name='s' value='Add New Student'/><br><br>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
