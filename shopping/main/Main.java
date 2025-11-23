package com.shopping.main;

import java.util.Scanner;

import com.shopping.service.AdminService;
import com.shopping.service.CustomerService;

public class Main 
{  
     public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		CustomerService cs=new CustomerService();
		AdminService as=new AdminService();
		 System.out.println("****----****🙏WElCOME To A14_Shopping🙏****----****");
			while(true)
			{
				System.out.println("Enter \n 1.For Admin Login \n 2.For Customer Registration \n 3.For Customer Login");
				int choice=scan.nextInt();
				switch (choice) {
				case 1:System.out.println("Enter \n 1. Adminlogin \n 2.new admin");
				int ch=scan.nextInt();
				if(ch==2)
				{
					as.adminRegistration();
				}
				else
					as.adminLogin();
				break;
				case 2:System.out.println("Customer Registration");
				cs.customerRegistration();
				break;
				case 3:System.out.println("Customer login");
				cs.customerLogin();
				
				break;
		        default:System.out.println("invalid Request");
				break;
				}
				System.out.println("Do you want to continue..Enter \n ✅Yes \n ❌No");
				String s=scan.next();
				if(!s.equalsIgnoreCase("Yes"))
				{
					System.out.println("Thank you visit again...🙏🏻");
					break;
				}
			}
			
		
			
	}
}
