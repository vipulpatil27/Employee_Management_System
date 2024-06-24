package org.techhub.service;

import java.util.*;
import org.techhub.model.Student;
import org.techhub.repository.StudentRepository;

public class StudentService {
	
	StudentRepository studRepo=new StudentRepository();
	
	public boolean isSave(Student student)
	{
		
		/*String fileName=student.getPhoto();
		//3
		int index=fileName.indexOf(".jpg");// abc.jpg or server side validations
		if(index!=-1)
		{
			//boolean b=studRepo.isSave(student);
			//return b;
			//return studRepo.isSave(student);
		}
		else
		{
			return false;
	    }*/
		
		//shortcut method for uppper code
		return student.getPhoto().indexOf(".jpg")!=-1 ? studRepo.isSave(student):false;
	}
	public List<Student> getAllRecords(){
		return studRepo.getAllRecords();
	}
	public boolean isDeleteRecord(int studentId) {
		return studRepo.isDeleteRecord(studentId);
		
	}
	public boolean isUpdate(Student student)
	{
		return studRepo.isUpdate(student);
	}
}
