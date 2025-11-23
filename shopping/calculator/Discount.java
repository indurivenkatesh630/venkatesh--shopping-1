package com.shopping.calculator;

public class Discount 
{
	public double totalAmount ;
   public void discount(double price, int quantity , double discount)
   {
	   double total=price*quantity;
	   System.out.println("Total price :"+total);
	   double totalDiscount=(discount/100) * total ;
	   System.out.println("Total discount :"+totalDiscount);
	    this.totalAmount=total-totalDiscount;
	   System.out.println("Total price should you pay :"+totalAmount);
	   
   }
  
}
