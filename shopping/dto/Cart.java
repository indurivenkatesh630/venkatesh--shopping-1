package com.shopping.dto;

public class Cart
{
	private int cart_Id;
	private int product_I;
	private int customer_Id;
	private int product_Quantity;
	
	public Cart() {
		
	}
	public Cart(int cart_Id, int product_I, int customer_Id, int product_Quantity) {
	
		this.cart_Id = cart_Id;
		this.product_I = product_I;
		this.customer_Id = customer_Id;
		this.product_Quantity = product_Quantity;
	}
	public int getCart_Id() {
		return cart_Id;
	}
	public void setCart_Id(int cart_Id) {
		this.cart_Id = cart_Id;
	}
	public int getProduct_I() {
		return product_I;
	}
	public void setProduct_I(int product_I) {
		this.product_I = product_I;
	}
	public int getCustomer_Id() {
		return customer_Id;
	}
	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}
	public int getProduct_Quantity() {
		return product_Quantity;
	}
	public void setProduct_Quantity(int product_Quantity) {
		this.product_Quantity = product_Quantity;
	}
	@Override
	public String toString() {
		return "Cart [cart_Id=" + cart_Id + ", product_I=" + product_I + ", customer_Id=" + customer_Id
				+ ", product_Quantity=" + product_Quantity + "]";
	}
	
}
