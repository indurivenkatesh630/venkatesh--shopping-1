package com.shopping.dto;

import java.sql.Date;

public class Product 
{
	private int product_Id;
	private String product_Name;
	private String product_Brand;
	private double product_Price;
	private Date product_Mfg_Date;
	private Date product_Exp_Date;
	private int product_Quantity;
	private String product_Category;
	private double product_Discount;
	public Product() {
	
	}
	public Product(int product_Id, String product_Name, String product_Brand, double product_Price,
			Date product_Mfg_Date, Date product_Exp_Date, int product_Quantity, String product_Category,
			double product_Discount) {
		
		this.product_Id = product_Id;
		this.product_Name = product_Name;
		this.product_Brand = product_Brand;
		this.product_Price = product_Price;
		this.product_Mfg_Date = product_Mfg_Date;
		this.product_Exp_Date = product_Exp_Date;
		this.product_Quantity = product_Quantity;
		this.product_Category = product_Category;
		this.product_Discount = product_Discount;
	}
	public int getProduct_Id() {
		return product_Id;
	}
	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}
	public String getProduct_Name() {
		return product_Name;
	}
	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}
	public String getProduct_Brand() {
		return product_Brand;
	}
	public void setProduct_Brand(String product_Brand) {
		this.product_Brand = product_Brand;
	}
	public double getProduct_Price() {
		return product_Price;
	}
	public void setProduct_Price(double product_Price) {
		this.product_Price = product_Price;
	}
	public Date getProduct_Mfg_Date() {
		return product_Mfg_Date;
	}
	public void setProduct_Mfg_Date(Date product_Mfg_Date) {
		this.product_Mfg_Date = product_Mfg_Date;
	}
	public Date getProduct_Exp_Date() {
		return product_Exp_Date;
	}
	public void setProduct_Exp_Date(Date product_Exp_Date) {
		this.product_Exp_Date = product_Exp_Date;
	}
	public int getProduct_Quantity() {
		return product_Quantity;
	}
	public void setProduct_Quantity(int product_Quantity) {
		this.product_Quantity = product_Quantity;
	}
	public String getProduct_Category() {
		return product_Category;
	}
	public void setProduct_Category(String product_Category) {
		this.product_Category = product_Category;
	}
	public double getProduct_Discount() {
		return product_Discount;
	}
	public void setProduct_Discount(double product_Discount) {
		this.product_Discount = product_Discount;
	}
	@Override
	public String toString() {
		return "Product \n product_Id=" + product_Id + ",\n product_Name=" + product_Name + ",\n product_Brand="
				+ product_Brand + ",\n product_Price=" + product_Price + ",\n product_Mfg_Date=" + product_Mfg_Date
				+ ",\n product_Exp_Date=" + product_Exp_Date + ",\n product_Quantity=" + product_Quantity
				+ ",\n product_Category=" + product_Category + ",\n product_Discount=" + product_Discount + "";
	}
	
}
