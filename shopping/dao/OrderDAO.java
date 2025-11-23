package com.shopping.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dto.Order;
import com.shopping.util.JDBCConnection;

public class OrderDAO 
{
	private static final String select="select * from order_details where Cunstomer_Id=?";
	private static final String insert="insert into order_details( Cunstomer_Id, Product_Id, Product_Quantity, Order_Address, Order_Date) values (?,?,?,?,?)";
     public boolean insertOrders(Order order)
     {
    	 try {
			Connection connection=JDBCConnection.forMySqlConnection();
			PreparedStatement ps=connection.prepareStatement(insert);
			ps.setInt(1, order.getCunstomer_Id());
			ps.setInt(2, order.getProduct_Id());
			ps.setInt(3, order.getProduct_Quantity());
			ps.setString(4, order.getOrder_Address());
			ps.setDate(5, Date.valueOf(order.getOrder_Date()));
			int result=ps.executeUpdate();
			if(result!=0)
			{
				return true;
			}
			else return false;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
     }
     public List<Order> selectOrderDetails(int custId)
     {
    	 try {
			Connection connection=JDBCConnection.forMySqlConnection();
			PreparedStatement ps=connection.prepareStatement(select);
			ps.setInt(1, custId );
			ResultSet rs=ps.executeQuery();
			List<Order> listOfOrders=new ArrayList<Order>();
			if(rs.isBeforeFirst())
			{
				while(rs.next())
				{
					Order order=new Order();
					order.setCunstomer_Id(rs.getInt("Cunstomer_Id"));
					order.setOrder_Address(rs.getString("Order_Address"));
					order.setOrder_Date(rs.getDate("Order_Date").toLocalDate());
					order.setProduct_Id(rs.getInt("Product_Id"));
					order.setOrder_Id(rs.getInt("order_Id"));
					order.setProduct_Quantity(rs.getInt("Product_Quantity"));
					listOfOrders.add(order);
				}
				return listOfOrders;
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
