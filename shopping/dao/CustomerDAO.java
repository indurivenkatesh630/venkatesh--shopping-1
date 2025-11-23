package com.shopping.dao;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopping.dto.Customer;
import com.shopping.util.JDBCConnection;

public class CustomerDAO 
{
	Customer customer;
    private static final String insert="insert into customer_details( Customer_Name, Customer_EmailId, Customer_Mobile_Number, Customer_Address, Customer_Gender,Customer_Password) values(?,?,?,?,?,?)";
    private static final String select_customer_details="select * from customer_details ";
    private static final String customer_Login="select * from customer_details where (Customer_EmailId=? OR Customer_Mobile_Number=?) and Customer_Password=?";
    public boolean insertCustomerDetails( Customer customer) {
    	try {
			Connection connection=JDBCConnection.forMySqlConnection();
			PreparedStatement ps=connection.prepareStatement(insert);
			ps.setString(1, customer.getCustomer_Name());
			ps.setString(2, customer.getCustomer_EmailId());
			ps.setLong(3, customer.getCustomer_Mobile_Number());
			ps.setString(4, customer.getCustomer_Address());
			ps.setString(5, customer.getCustomer_Gender());
			ps.setString(6, customer.getCustomer_Password());
			int result=ps.executeUpdate();
			if(result!=0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }
    public List<Customer> selectAllCustomerDetails()
    {
    	try {
			Connection connection=JDBCConnection.forMySqlConnection();
			PreparedStatement ps=connection.prepareStatement(select_customer_details);
			ResultSet rs=ps.executeQuery();
			List<Customer> listOfCustomers=new ArrayList<Customer>();
			while(rs.next())
			{
			    Customer customer=new Customer();
				customer.setCustomer_EmailId(rs.getString("Customer_EmailId"));
				customer.setCustomer_Mobile_Number(rs.getLong("Customer_Mobile_Number"));
				customer.setCustomer_Password(rs.getString("Customer_Password"));
				listOfCustomers.add(customer);
			
			}
			return listOfCustomers;
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    	
    }
    public Customer selectCustomerDetailsByUsingEmailOrMobileNumberAndPassword(String emailOrMobileNumber, String password)
    {
    	/* select * from customer_details where customer_EmailId=? OR customer_Mobile_Number=? and customer_password=?*/
    	try {
			Connection connection=JDBCConnection.forMySqlConnection();
			PreparedStatement ps=connection.prepareStatement(customer_Login);
			ps.setString(1, emailOrMobileNumber);
			ps.setString(2, emailOrMobileNumber);
			ps.setString(3, password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
			    customer=new Customer();
			   customer.setCustomer_Id(rs.getInt("Customer_Id"));
			    System.out.println(rs.getInt("Customer_Id"));
				customer.setCustomer_EmailId(rs.getString("Customer_EmailId"));
				customer.setCustomer_Mobile_Number(rs.getLong("Customer_Mobile_Number"));
				customer.setCustomer_Password(rs.getString("Customer_Password"));
				customer.setCustomer_Name(rs.getString("Customer_Name"));
				customer.setCustomer_Gender(rs.getString("Customer_Gender"));
				customer.setCustomer_Address(rs.getString("Customer_Address"));
				return customer;
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
