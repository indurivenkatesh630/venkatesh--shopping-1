package com.shopping.service;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.NumberFormatter;

import java.sql.*;
import java.text.RuleBasedCollator;

import com.shopping.dao.AdminDAO;
import com.shopping.dto.Admin;
import com.shopping.dto.Product;
import com.shopping.exception.CustomerDataInvalidException;

import javafx.util.converter.NumberStringConverter;

public class AdminService 
{
	 Scanner scan=new Scanner(System.in);
	 AdminDAO adminDAO=new AdminDAO();
	 Admin admin=new Admin();
	 Product product=new Product();
	 ProductService productService=new ProductService();
   public  void adminRegistration()
   {
	   
	   List<Admin> list=adminDAO.selectAllAdminDetails();
	   while(true) {
		   System.out.println("Enter the Admin emailid");
		   String emailid=scan.next();
		  long emailCount= list.stream().filter((admin)->admin.getAdmin_Email().equalsIgnoreCase(emailid)).count();
		  try {
			  if(!emailid.endsWith("@gmail.com"))
			   {
				   throw new CustomerDataInvalidException("Invalid EmailId");
			   }
			   if(emailCount>0)
			   {
				   throw new CustomerDataInvalidException("Email is already Exited");
			   }
			   else
			   {
				   admin.setAdmin_Email(emailid);
				   break;
			   }
		     } 
		  catch (CustomerDataInvalidException e) {
			System.out.println(e.getInvalid());
			System.out.println("Re-Enter the Admin emailid");
		}
	   }
	   
		   System.out.println("Enter the admin password");
		   String password=scan.next();
		  System.out.println("Enter the admin role");
		  String role=scan.next();
		  admin.setAdmin_Password(password);
		  admin.setAdmin_Role(role);
		  adminDAO.insertAdminDetails(admin);
		  System.out.println("Admin Registered sucessfully");    
   }
   
   public void adminLogin()
   {
	   
	   System.out.println("Enter the Emaild id");
	   String emailId=scan.next();
	   System.out.println("enter the password");
	   String password=scan.next();
	   Admin admin=adminDAO.selectAdminDetailsByUsingEmailAndPassword(emailId, password);
		  if(admin!=null)
		  {
			  System.out.println("Enter 1.To insert product details \n 2.For the same brand type");
			  int choice=scan.nextInt();
			  switch (choice) {
			case 1:
				  System.out.println(" Enter 1.Insert product details...");
				  productService.storeProductDetails();
				break;
			case 2:System.out.println("Insert product details...");
				productService.storeProductsByUsingBrand();
			    break;
			       
			default: System.out.println("Invalid Request...");
				break;
			}
		  }
	   else
		   System.out.println("Invalid emaild or password");
		  
		  
	   
   }
  
   
}
