package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dto.Cart;
import com.shopping.util.JDBCConnection;

public class CartDAO 
{
   private static final String insert="insert  into cart_details( Product_Id, Customer_Id, Product_Quantity) values(?,?,?)";
   private static final String select=" select * from cart_details where Customer_Id=?";
   public boolean insertCartDetails(Cart cart)
   {
	   try {
		Connection connection=JDBCConnection.forMySqlConnection();
		PreparedStatement ps=connection.prepareStatement(insert);
		ps.setInt(1, cart.getProduct_I());
		ps.setInt(2, cart.getCustomer_Id());
		ps.setInt(3, cart.getProduct_Quantity());
		int result=ps.executeUpdate();
		if(result!=0)
		{
			return true;
		}
		else
			return false;
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
   }
   
   public List<Cart> selectCartDetails(int custId)
   {
	    try {
			Connection connection=JDBCConnection.forMySqlConnection();
			PreparedStatement ps=connection.prepareStatement(select);
			ps.setInt(1, custId);
			 ResultSet rs=ps.executeQuery();
			 List<Cart> listOfCart=new ArrayList<Cart>();
			 if(rs.isBeforeFirst())
			 {
				 while(rs.next())
				 {
					Cart cart=new Cart();
					cart.setCart_Id(rs.getInt("cart_Id"));
					cart.setCustomer_Id(rs.getInt("Customer_Id"));
					cart.setProduct_I(rs.getInt("Product_Id"));
					cart.setProduct_Quantity(rs.getInt("Product_Quantity"));
					listOfCart.add(cart);
				 }
				 return listOfCart;
			 }
			 else
				 return null;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
   }
}
