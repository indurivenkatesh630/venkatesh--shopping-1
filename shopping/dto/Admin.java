package com.shopping.dto;

public class Admin 
{
	private int admin_Id;
	private String admin_Email;
	private String admin_Password;
	private String admin_Role;
	public Admin() {
		
	}
	public Admin(int admin_Id, String admin_Email, String admin_Password, String admin_Role) {
	
		this.admin_Id = admin_Id;
		this.admin_Email = admin_Email;
		this.admin_Password = admin_Password;
		this.admin_Role = admin_Role;
	}
	public int getAdmin_Id() {
		return admin_Id;
	}
	public void setAdmin_Id(int admin_Id) {
		this.admin_Id = admin_Id;
	}
	public String getAdmin_Email() {
		return admin_Email;
	}
	public void setAdmin_Email(String admin_Email) {
		this.admin_Email = admin_Email;
	}
	public String getAdmin_Password() {
		return admin_Password;
	}
	public void setAdmin_Password(String admin_Password) {
		this.admin_Password = admin_Password;
	}
	public String getAdmin_Role() {
		return admin_Role;
	}
	public void setAdmin_Role(String admin_Role) {
		this.admin_Role = admin_Role;
	}
	@Override
	public String toString() {
		return "Admin [admin_Id=" + admin_Id + ", admin_Email=" + admin_Email + ", admin_Password=" + admin_Password
				+ ", admin_Role=" + admin_Role + "]";
	}
	
	
}
