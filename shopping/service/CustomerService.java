package com.shopping.service;

import java.util.List;
import java.util.Scanner;

import com.shopping.calculator.Discount;
import com.shopping.dao.CustomerDAO;
import com.shopping.dao.ProductDAO;
import com.shopping.dto.Cart;
import com.shopping.dto.Customer;
import com.shopping.dto.Order;
import com.shopping.dto.Payment;
import com.shopping.dto.Product;
import com.shopping.exception.CustomerDataInvalidException;
 
public class CustomerService 
{
   Scanner scan=new Scanner(System.in);
   CustomerDAO custDAO=new CustomerDAO();
   Customer customer; 
   ProductDAO productDAO=new ProductDAO();
   ProductService ps=new ProductService();
   CartService cartService=new CartService();
   Product product;
   Discount d=new Discount();
   PaymentService paymentService =new PaymentService();
   OrderService orderService=new OrderService();
   public void customerRegistration()
   {
	   Customer customer=new Customer();
	   List<Customer> list=custDAO.selectAllCustomerDetails();
	   System.out.println("Enter the Customer name..");
	   String cname=scan.next();
	   while(true) {
		   System.out.println("Enter the customer emailid");
		   String emailid=scan.next();
		  long emailCount= list.stream().filter((custom)->custom.getCustomer_EmailId().equalsIgnoreCase(emailid)).count();
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
				   customer.setCustomer_EmailId(emailid);
				   break;
			   }
		     } 
		  catch (CustomerDataInvalidException e) {
			System.out.println(e.getInvalid());
			System.out.println("Re-Enter the Customer emailid");
		}
	   }
	   while(true)
	   {
		   System.out.println("Enter the customer mobile number..");
		   long mobile=scan.nextLong();
		   long mobileCount=list.stream().filter((custom)->custom.getCustomer_Mobile_Number()==mobile).count();
		  try {
			  if(!(mobile>=6000000000l && mobile<=9999999999l))
			   {
				   throw new CustomerDataInvalidException("Invalid Mobile number");
			   }
			  
			   if(mobileCount>0)
			   {
				   throw new CustomerDataInvalidException("Mobile number already exited..");
			   }
			   else
			   {
				   customer.setCustomer_Mobile_Number(mobile);
				   break;
			   }
		} catch (CustomerDataInvalidException e) {
			System.out.println(e.getInvalid());
			System.out.println("Re-Enter the Customer mobile number");
		}
		   
	   }
	  
	   System.out.println("Enetr the Customer address");
	   String address=scan.next();
	   System.out.println("Enter the customer gender");
	   String gender=scan.next();
	   System.out.println("enter the  customer password");
	   String password=scan.next();
	   customer.setCustomer_Name(cname);
	   customer.setCustomer_Address(address);
	   customer.setCustomer_Gender(gender);
	   customer.setCustomer_Password(password);
	   custDAO.insertCustomerDetails(customer);
	   System.out.println(customer.getCustomer_Name()+"Rigistered sucessfully..");
   }
   public void customerLogin()
   {
	   System.out.println("Enter the Emaild id");
	   String emailIdOrMobile=scan.next();
	   System.out.println("enter the password");
	   String password=scan.next();
	    customer=custDAO.selectCustomerDetailsByUsingEmailOrMobileNumberAndPassword(emailIdOrMobile, password);
		  if(customer!=null)
		  {
			  System.out.println("Login sucessfull");
			  if(customer.getCustomer_Gender().equalsIgnoreCase("male"))
			  {
				  System.out.println("hello Mr':"+customer.getCustomer_Name());
				  customerOperation();
			  }
			  if(customer.getCustomer_Gender().equalsIgnoreCase("female"))
			  {
				  System.out.println("hello Miss':"+customer.getCustomer_Name());
				  customerOperation();
			  }
		  }
	   else
		   System.out.println("Invalid emaild or password");
	   
   }
   public void customerOperation()
   {
	   System.out.println("Enter \n 1.For All products \n 2.For Cart Details \n 3.For Order Details");
	   int choice=scan.nextInt();
	   switch (choice) {
	case 1: List<Product> listOfproducts=ps.allProductDetails();
	int i=1;
	      for(Product product:listOfproducts)
	      {
	    	  System.out.println("S.NO -"+i++);
	    	  System.out.println("Product name :"+product.getProduct_Name());
	    	  System.out.println("Product Brand :"+product.getProduct_Brand());
	    	  System.out.println("Product price :"+product.getProduct_Price());
	    	  System.out.println("Product mfg date :"+product.getProduct_Mfg_Date());
	    	  System.out.println("Product exp date :"+product.getProduct_Exp_Date());
	    	  System.out.println("Product quantity :"+product.getProduct_Quantity());
	    	  System.out.println("product category :"+product.getProduct_Category());
	    	  System.out.println("product discount :"+product.getProduct_Discount());
	    	  System.out.println("********---------**********---------********--------");
	    	 
	      }
	      System.out.println("Select S.No to add to Cart or To Buy");
	            product=listOfproducts.get(scan.nextInt()-1);
		    	  System.out.println("Product name :"+product.getProduct_Name());
		    	  System.out.println("Product Brand :"+product.getProduct_Brand());
		    	  System.out.println("Product price :"+product.getProduct_Price());
		    	  System.out.println("Product mfg date :"+product.getProduct_Mfg_Date());
		    	  System.out.println("Product exp date :"+product.getProduct_Exp_Date());
		    	  System.out.println("Product quantity :"+product.getProduct_Quantity());
		    	  System.out.println("product category :"+product.getProduct_Category());
		    	  System.out.println("product discount :"+product.getProduct_Discount());
		    	  System.out.println("********---------**********---------********--------");
	    	 System.out.println("Select\n 1.To Add The Product To The Cart \n 2.To Buy");
	    	 switch (scan.nextInt()) {
			case 1:
				  System.out.println("Add The Product To The Cart");
				  System.out.println("Enter the Product Quantity");
				  int quantity=scan.nextInt();
				  Cart cart=new Cart();
				  cart.setProduct_I(product.getProduct_Id());
				  cart.setCustomer_Id(customer.getCustomer_Id());
				  cart.setProduct_Quantity(quantity);
				 cartService.addCartDetails(cart);
				break;
			case 2: System.out.println("Enter the product quantity");
			       int num=scan.nextInt();
			  System.out.println("Product name :"+product.getProduct_Name());
	    	  System.out.println("Product Brand :"+product.getProduct_Brand());
	    	  System.out.println("Product price :"+product.getProduct_Price());
	    	  System.out.println("product category :"+product.getProduct_Category());
	    	  d.discount(product.getProduct_Price(), num, product.getProduct_Discount());
	    	  paymentService.paymentProcessDetails(customer.getCustomer_Id(),product.getProduct_Id(),num,d.totalAmount, customer.getCustomer_Address());
	   
			default:
				break;
			}
	      
		break;
	case 2:System.out.println("Cart Details");
	      List<Cart> allCart= cartService.allCartDetails(customer.getCustomer_Id());
	      for(Cart cart:allCart)
	      {
	    	  System.out.println("Cart Id :"+cart.getCart_Id());
	    	  System.out.println("Product Id :"+cart.getProduct_I());
	    	  System.out.println("Customer id :"+cart.getCustomer_Id());
	    	  System.out.println("Product quantity :"+cart.getProduct_Quantity());
	    	  System.out.println("****-----*****------*****------*****");
	      }
	break;
	case 3:System.out.println("Order Details..");
	       List<Order> allOrders=orderService.allOrderDetails(customer.getCustomer_Id());
	       for(Order order:allOrders)
	       {
	    	   System.out.println("Order Id :"+order.getOrder_Id());
	    	   System.out.println("Product Id :"+order.getProduct_Id());
	    	   System.out.println("Customer Id :"+order.getCunstomer_Id());
	    	   System.out.println("Product Quantity :"+order.getProduct_Quantity());
	    	   System.out.println("Ordered address :"+order.getOrder_Address());
	    	   System.out.println("Ordered Date :"+order.getOrder_Date());
	    	   System.out.println("***---***---***---***---***---***---***---***");
	       }
	break;
	default:System.out.println("Invalid request");
		break;
	}
   }
   
}
