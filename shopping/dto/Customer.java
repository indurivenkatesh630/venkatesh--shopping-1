package com.shopping.dto;

public class Customer 
{
	private int customer_Id;
	private String customer_Name;
	private String customer_EmailId;
	private long customer_Mobile_Number;
	private String customer_Address;
	private String customer_Gender;
	private String customer_Password;
	public Customer() {
		
	}
	public Customer(int customer_Id, String customer_Name, String customer_EmailId, long customer_Mobile_Number,
			String customer_Address, String customer_Gender, String customer_Password) {
		super();
		this.customer_Id = customer_Id;
		this.customer_Name = customer_Name;
		this.customer_EmailId = customer_EmailId;
		this.customer_Mobile_Number = customer_Mobile_Number;
		this.customer_Address = customer_Address;
		this.customer_Gender = customer_Gender;
		this.customer_Password = customer_Password;
	}
	public int getCustomer_Id() {
		return customer_Id;
	}
	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}
	public String getCustomer_Name() {
		return customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}
	public String getCustomer_EmailId() {
		return customer_EmailId;
	}
	public void setCustomer_EmailId(String customer_EmailId) {
		this.customer_EmailId = customer_EmailId;
	}
	public long getCustomer_Mobile_Number() {
		return customer_Mobile_Number;
	}
	public void setCustomer_Mobile_Number(long customer_Mobile_Number) {
		this.customer_Mobile_Number = customer_Mobile_Number;
	}
	public String getCustomer_Address() {
		return customer_Address;
	}
	public void setCustomer_Address(String customer_Address) {
		this.customer_Address = customer_Address;
	}
	public String getCustomer_Gender() {
		return customer_Gender;
	}
	public void setCustomer_Gender(String customer_Gender) {
		this.customer_Gender = customer_Gender;
	}
	public String getCustomer_Password() {
		return customer_Password;
	}
	public void setCustomer_Password(String customer_Password) {
		this.customer_Password = customer_Password;
	}
	@Override
	public String toString() {
		return "Customer [customer_Id=" + customer_Id + ", customer_Name=" + customer_Name + ", customer_EmailId="
				+ customer_EmailId + ", customer_Mobile_Number=" + customer_Mobile_Number + ", customer_Address="
				+ customer_Address + ", customer_Gender=" + customer_Gender + ", customer_Password=" + customer_Password
				+ "]";
	}
	
}
