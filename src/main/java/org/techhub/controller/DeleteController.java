package org.techhub.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.techhub.service.StudentService;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/del")
public class DeleteController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("studentId");

		int id1 = Integer.parseInt(id);
		// System.out.println("id is"+id);

		// int studentId=Integer.parseInt(request.getParameter("studId"));
		// System.out.println("studentId");
		// System.out.println(id1);

		StudentService sService = new StudentService();
		boolean b = sService.isDeleteRecord(id1);
		if (b) {
			RequestDispatcher r = request.getRequestDispatcher("View");
			r.forward(request, response);
		} 
		else{
			out.println("<h1>Some Problem is there....</h1>");
		}

	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
