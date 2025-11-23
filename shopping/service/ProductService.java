package com.shopping.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shopping.dao.ProductDAO;
import com.shopping.dto.Product;

public class ProductService 
{
    Scanner scan=new Scanner(System.in);
    Product product=new Product();
    ProductDAO productDAO=new ProductDAO();
    public void storeProductDetails()
    {
    	System.out.println("Enter the product name");
    	String pname=scan.next();
    	System.out.println("enter the product brand");
    	String pbrand=scan.next();
    	System.out.println("Enter the product Price");
    	double price=scan.nextDouble();
    	System.out.println("Enter the product mfg date");
    	String mfg=scan.next();
    	System.out.println("Enter the product exp date");
    	String expDate=scan.next();
    	System.out.println("Enter the product quantity");
    	int pquantity=scan.nextInt();
    	System.out.println("enter the product category");
    	String pcategory=scan.next();
    	System.out.println("Enter the product discount");
    	double pdiscount=scan.nextDouble();
    	product.setProduct_Name(pname);
    	product.setProduct_Brand(pbrand);
    	product.setProduct_Price(price);
    	/*  valueOf() return type Date
    	 *  Present in Date Class , argument String */
    	product.setProduct_Mfg_Date(Date.valueOf(mfg));
    	product.setProduct_Exp_Date(Date.valueOf(expDate));
    	product.setProduct_Quantity(pquantity);
    	product.setProduct_Category(pcategory);
    	product.setProduct_Discount(pdiscount);
    	productDAO.insertProductDetails(product);
    }
    public void storeProductsByUsingBrand()
    {
 	   List<Product> list=new ArrayList<Product>();
 	   System.out.println("Enter the Product Brand");
        String pbrand=scan.next();
        System.out.println("Number of products under "+pbrand+" brand ");
        int quantity=scan.nextInt();
       
        String[] nu= {"First","Second","Third","Fourth","Fifth"};
        for(int i=0;i<quantity;i++)
        {
        	System.out.println("Enter "+nu[i]+" product details....");
        	System.out.println("Enter the product name");
        	String pname=scan.next();
        	System.out.println("Enter the product Price");
        	double price=scan.nextDouble();
        	System.out.println("Enter the product mfg date");
        	String mfg=scan.next();
        	System.out.println("Enter the product exp date");
        	String expDate=scan.next();
        	System.out.println("Enter the product quantity");
        	int pquantity=scan.nextInt();
        	System.out.println("enter the product category");
        	String pcategory=scan.next();
        	System.out.println("Enter the product discount");
        	double pdiscount=scan.nextDouble();
        	product.setProduct_Name(pname);
        	product.setProduct_Brand(pbrand);
        	product.setProduct_Price(price);
        	product.setProduct_Mfg_Date(Date.valueOf(mfg));
        	product.setProduct_Exp_Date(Date.valueOf(expDate));
        	product.setProduct_Quantity(quantity);
        	product.setProduct_Category(pcategory);
        	product.setProduct_Discount(pdiscount);
        	list.add(product);
     
        }
        if(productDAO.insertMoreThanOneProduct(list))
        {
        	System.out.println("Products inserted sucessfully");
        }
        else
        	System.out.println("server error 500");
    }
    
    public List<Product> allProductDetails()
    {
       return productDAO.selectAllProductDetails();
    }
    
}
