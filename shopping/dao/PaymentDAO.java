package com.shopping.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.shopping.dto.Payment;
import com.shopping.util.JDBCConnection;

public class PaymentDAO 
{
	private static final String insert="insert into payment_details(Customer_Id, Product_Id, Payment_Type, Payment_Status, Amount, Payment_Date) values (?,?,?,?,?,?)";
	  
	public boolean insertPaymentDetails(Payment payment)
	{
		try {
			Connection connection=JDBCConnection.forMySqlConnection();
			PreparedStatement ps=connection.prepareStatement(insert);
			ps.setInt(1, payment.getUcstomer_Id());
			ps.setInt(2, payment.getProduct_Id());
			ps.setString(3, payment.getPayment_Type());
			ps.setString(4, payment.getPayment_Status());
			ps.setDouble(5, payment.getAmount());
			ps.setDate(6, Date.valueOf(payment.getPayment_Date()));
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
}
