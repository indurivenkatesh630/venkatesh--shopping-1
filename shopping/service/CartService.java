package com.shopping.service;

import java.util.List;

import com.shopping.dao.CartDAO;
import com.shopping.dto.Cart;

public class CartService 
{
  CartDAO cartDAO=new CartDAO();
  
  public void addCartDetails(Cart cart)
  {
	  if(cartDAO.insertCartDetails(cart)) 
		  System.out.println("Products added to the cart..");
	  else
		  System.out.println("Server error 500");
  }
  public List<Cart> allCartDetails(int custId)
  {
	  return cartDAO.selectCartDetails(custId);
  }
}
