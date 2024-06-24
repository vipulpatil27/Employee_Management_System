 // POJO class
 // Model class:- It is a class with setter-getter methods,which is used for to stored the view data and 
 // pass to service layer from controller
 // view control name and model class setter-getter name should be same. 
package org.techhub.model;

public class Student {
	
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	private String name;
	private String email;
	private String contact;
	private String photo;
}
