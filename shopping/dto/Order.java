package com.shopping.dto;

import java.time.LocalDate;

public class Order 
{
	private int order_Id;
	private int cunstomer_Id;
	private int product_Id;
	private int product_Quantity;
	private String order_Address;
	private LocalDate order_Date;
	public Order() {

	}
	public Order(int order_Id, int cunstomer_Id, int product_Id, int product_Quantity, String order_Address,
			LocalDate order_Date) {
	
		this.order_Id = order_Id;
		this.cunstomer_Id = cunstomer_Id;
		this.product_Id = product_Id;
		this.product_Quantity = product_Quantity;
		this.order_Address = order_Address;
		this.order_Date = order_Date;
	}
	public int getOrder_Id() {
		return order_Id;
	}
	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}
	public int getCunstomer_Id() {
		return cunstomer_Id;
	}
	public void setCunstomer_Id(int cunstomer_Id) {
		this.cunstomer_Id = cunstomer_Id;
	}
	public int getProduct_Id() {
		return product_Id;
	}
	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}
	public int getProduct_Quantity() {
		return product_Quantity;
	}
	public void setProduct_Quantity(int product_Quantity) {
		this.product_Quantity = product_Quantity;
	}
	public String getOrder_Address() {
		return order_Address;
	}
	public void setOrder_Address(String order_Address) {
		this.order_Address = order_Address;
	}
	public LocalDate getOrder_Date() {
		return order_Date;
	}
	public void setOrder_Date(LocalDate order_Date) {
		this.order_Date = order_Date;
	}
	@Override
	public String toString() {
		return "Order [order_Id=" + order_Id + ", cunstomer_Id=" + cunstomer_Id + ", product_Id=" + product_Id
				+ ", product_Quantity=" + product_Quantity + ", order_Address=" + order_Address + ", order_Date="
				+ order_Date + "]";
	}
	
}
