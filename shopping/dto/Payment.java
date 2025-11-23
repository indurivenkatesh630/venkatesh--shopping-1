package com.shopping.dto;


import java.time.LocalDate;

public class Payment 
{
	private int payment_Id;
	private int ucstomer_Id;
	private int product_Id;
	private String payment_Type;
	private String payment_Status;
	private double amount;
	private LocalDate payment_Date;
	public Payment() {
	
	}
	public Payment(int payment_Id, int ucstomer_Id, int product_Id, String payment_Type, String payment_Status,
			double amount, LocalDate payment_Date) {
		
		this.payment_Id = payment_Id;
		this.ucstomer_Id = ucstomer_Id;
		this.product_Id = product_Id;
		this.payment_Type = payment_Type;
		this.payment_Status = payment_Status;
		this.amount = amount;
		this.payment_Date = payment_Date;
	}
	public int getPayment_Id() {
		return payment_Id;
	}
	public void setPayment_Id(int payment_Id) {
		this.payment_Id = payment_Id;
	}
	public int getUcstomer_Id() {
		return ucstomer_Id;
	}
	public void setUcstomer_Id(int ucstomer_Id) {
		this.ucstomer_Id = ucstomer_Id;
	}
	public int getProduct_Id() {
		return product_Id;
	}
	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}
	public String getPayment_Type() {
		return payment_Type;
	}
	public void setPayment_Type(String payment_Type) {
		this.payment_Type = payment_Type;
	}
	public String getPayment_Status() {
		return payment_Status;
	}
	public void setPayment_Status(String payment_Status) {
		this.payment_Status = payment_Status;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getPayment_Date() {
		return payment_Date;
	}
	public void setPayment_Date(LocalDate payment_Date) {
		this.payment_Date = payment_Date;
	}
	@Override
	public String toString() {
		return "Payment [payment_Id=" + payment_Id + ", ucstomer_Id=" + ucstomer_Id + ", product_Id=" + product_Id
				+ ", payment_Type=" + payment_Type + ", payment_Status=" + payment_Status + ", amount=" + amount
				+ ", payment_Date=" + payment_Date + "]";
	}
	
}
