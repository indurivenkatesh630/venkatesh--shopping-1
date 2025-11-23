package com.shopping.service;

import java.time.LocalDate;
import java.util.Scanner;

import com.shopping.dao.OrderDAO;
import com.shopping.dao.PaymentDAO;
import com.shopping.dto.Customer;
import com.shopping.dto.Order;
import com.shopping.dto.Payment;
import com.shopping.dto.Product;

public class PaymentService 
{
	Product product=new Product();
	Customer customer=new Customer();
	PaymentDAO paymentDAO=new PaymentDAO();
	 Scanner scan=new Scanner(System.in);
	 OrderDAO orderDAO=new OrderDAO();
  public void paymentProcessDetails(int custId,int proId,int num,double pamount, String custAddress)
  {
	  Payment payment=new Payment();
	 
	 System.out.println("Enter \n 1.For UPI \n. 2.Cash On Delivery \n 3.Debit \n 4.Net Payment \n 5.EMI");
	 switch (scan.nextInt()) {
	case 1: payment.setPayment_Type("UPI");
	        payment.setPayment_Status("Payment sucess");
	break;
	case 2:payment.setPayment_Type("Cash On Delivery");
	       payment.setPayment_Status("Under Processing");
	break;
	case 3:payment.setPayment_Type("Debit");
	       payment.setPayment_Status("Payment sucess");
	break;
	case 4:
		   payment.setPayment_Type("Net Payment");
		   payment.setPayment_Status("Under Processing");
	break;
	case 5: payment.setPayment_Type("EMI");
	        payment.setPayment_Status("Under Processing");
	break;
	default:
	break;
	}
	  System.out.println("Enter the amount");
	  double amount=scan.nextDouble();
	  if(amount==pamount)
	  {
		 
		  payment.setUcstomer_Id(custId);
		  payment.setProduct_Id(product.getProduct_Id());
		  payment.setAmount(amount);
		 payment.setPayment_Date(LocalDate.now());
		 if(paymentDAO.insertPaymentDetails(payment))
		 {
			 System.out.println("Order placed sucessfully");
			 System.out.println("Select Address to deliver the Product \n 1."+custAddress +" \n 2. change Address");
			 Order order=new Order();
			 order.setCunstomer_Id(custId);
			 
			 order.setProduct_Id(proId);
			 order.setProduct_Quantity(num);
			 order.setOrder_Date(LocalDate.now());
			 if(scan.nextInt()==1)
			 {
				 String address=custAddress;
				 order.setOrder_Address(address);
				 
			 }
			 else
			 {
				 System.out.println("Enter New Address");
				 String newAdd=scan.next();
				 order.setOrder_Address(newAdd);
				
				
			 }
			 if(orderDAO.insertOrders(order))
				 System.out.println("Order details inserted");
			 else
				 System.out.println("server 500");
		 }
		 else
		 {
			 System.out.println("Server error 500");
		 }
	  }
	  else
		  System.out.println("Invalid amount");
  }
}
