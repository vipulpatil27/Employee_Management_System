package org.techhub.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.techhub.model.Student;
import org.techhub.service.StudentService;

/**
 * Servlet implementation class StudentSaveController
 */
@WebServlet("/save")
public class StudentSaveController extends HttpServlet {
	String name,email,contact,fileName;
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//check request is multipart or not
		boolean b=ServletFileUpload.isMultipartContent(request); //b=false
		if(!b)
		{
			out.println("<h1>Invalid file uploaded</h1>");
		}
		else
		{
			//file uploading logic
			//Service layer
			DiskFileItemFactory factory=new DiskFileItemFactory();
			factory.setSizeThreshold(5*1024);
			factory.setRepository(new File("C:\\aaaaaaaaaaaaaaaa"));
			ServletFileUpload upload = new ServletFileUpload(factory);
			//set maximum file size;
			upload.setSizeMax(50*(1024*1024));
			try
			{
				List<FileItem> fileItems=upload.parseRequest(request);
				for(FileItem item:fileItems)
				{
					b=item.isFormField();
					if(!b)
					{
						//Get file details
						//data of file
						fileName=item.getName();
						String fieldName=item.getFieldName();
						String contentType=item.getContentType();
						long size=item.getSize();
						
						ServletContext context=this.getServletContext();
						String realPath=context.getRealPath("/");
						//out.println("Root path of project"+realPath);
						
						//file handling topic
						File f = new File(realPath+"images");
						if(!f.exists()) //if(!false)=true
						{
							f.mkdir();
						 }
						f=new File(realPath+"images\\"+fileName);
						//save file at server hard disk in project location
						item.write(f);
						out.println("<h1>File Uploaded Sucessfully.....");
					}
					else
					{
						//data of html control
						String controlName=item.getFieldName();
						String data=item.getString();
						if(controlName.equals("name"))
						{
							name=item.getString();
						}
						if(controlName.equals("email"))
						{
							email=item.getString();
						}
						if(controlName.equals("contact"))
						{
							contact=item.getString();
						}
					}
				}
				RequestDispatcher r=request.getRequestDispatcher("navigation.html");
				r.include(request, response);
				out.println("<br><br>");
				Student s=new Student();
				s.setName(name);
				s.setEmail(email);
				s.setContact(contact);
				s.setPhoto(fileName);
				StudentService sService=new StudentService();
				//b=sSer  vice.isSave(s);
			    if(sService.isSave(s))
			    {
			    	out.println("<h1>Student Record Added....</h1>");
			    }
			    else
			    {
			    	out.println("<h1>Some problem is there....</h1>");
			    }
			}
			catch(Exception ex)
			{
				out.println("Error is "+ex);
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}