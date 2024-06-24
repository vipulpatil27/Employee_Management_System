package org.techhub.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.techhub.model.Student;

public class StudentRepository {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public StudentRepository() {
		try {
			// Devlopment(coders)-->Testing-->Production(project deployment or DevOps team)
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aug2022", "root", "root");
		} catch (Exception ex) {
			System.out.println("Error is" + ex);
		}
	}

	public boolean isSave(Student model) {
		try {
			stmt = conn.prepareStatement("insert into servstudent values('0',?,?,?,?)");
			stmt.setString(1, model.getName());
			stmt.setString(2, model.getEmail());
			stmt.setString(3, model.getContact());
			stmt.setString(4, model.getPhoto());
			int value = stmt.executeUpdate();
			if (value > 0) 
			{
				return true;
			} else 
			{
				return false;
			}
		} catch (Exception ex) 
		{
			System.out.println("error is" + ex);
			return false;
		}

	}

	public List<Student> getAllRecords() {
		try {
			List<Student> list = new ArrayList<Student>();
			// Repository Layer
			stmt = conn.prepareStatement("select *from servstudent");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setContact(rs.getString(4));
				s.setPhoto(rs.getString(5));
				list.add(s);
			}
			// list.forEach(s->System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.getEmail()+"\t"+s.getContact()+"\t"+"\t"+s.getPhoto()));

			return list;
		} catch (Exception ex) {
			System.out.println("Error is" + ex);
			return null;
		}
	}

	public boolean isDeleteRecord(int userid) {
		try {
			// Repository Layer
			stmt = conn.prepareStatement("delete from servstudent where sid=?");
			stmt.setInt(1, userid);
			int value = stmt.executeUpdate();
			if (value > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			System.out.println("Error is" + ex);
			return false;
		}
	}

	public boolean isUpdate(Student student) {
		try {
			// Repository Layer
			stmt = conn.prepareStatement("update servstudent set name=?,email=?,contact=? where sid=?");
			stmt.setString(1, student.getName());
			stmt.setString(2, student.getEmail());
			stmt.setString(3, student.getContact());
			stmt.setInt(4, student.getId());
			int value = stmt.executeUpdate();
			if (value > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			System.out.println("error is" + ex);
			return false;
		}
	}
}