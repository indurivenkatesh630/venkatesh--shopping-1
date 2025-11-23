package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dto.Admin;
import com.shopping.dto.Customer;
import com.shopping.util.JDBCConnection;

public class AdminDAO 
{
	private static final String admin_Login="select * from admin_details where Admin_Email=?  and Admin_Password=?";
    private static final String insert="insert into admin_details( Admin_Email, Admin_Password, Admin_Role) values (?,?,?)";
    private static final String select_admin_details="select * from admin_details";
    public boolean insertAdminDetails(Admin admin)
    {
    	try {
			Connection connection=JDBCConnection.forMySqlConnection();
			PreparedStatement ps=connection.prepareStatement(insert);
			ps.setString(1, admin.getAdmin_Email() );
			ps.setString(2, admin.getAdmin_Password());
			ps.setString(3, admin.getAdmin_Role());
			int result=ps.executeUpdate();
			if(result!=0)
			{
				return true;
			}
			else
				return false;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}	
    }
    public List<Admin> selectAllAdminDetails()
    {
    	try {
			Connection connection=JDBCConnection.forMySqlConnection();
			PreparedStatement ps=connection.prepareStatement(select_admin_details);
			ResultSet rs=ps.executeQuery();
			List<Admin> listOfadmins=new ArrayList<Admin>();
			while(rs.next())
			{
				Admin admin=new Admin();
				admin.setAdmin_Email(rs.getString("Admin_Email"));
				admin.setAdmin_Password(rs.getString("Admin_Password"));
				admin.setAdmin_Role(rs.getString("Admin_Role"));
				listOfadmins.add(admin);
			
			}
			return listOfadmins;
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    	
    }
    
    public Admin selectAdminDetailsByUsingEmailAndPassword(String email, String password)
    {
    	/* select * from admin_details where admin_EmailId=?  and admin_password=?*/
    	try {
			Connection connection=JDBCConnection.forMySqlConnection();
			PreparedStatement ps=connection.prepareStatement(admin_Login);
			ps.setString(1, email);
			ps.setString(2, password);
	
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				Admin admin=new Admin();
				admin.setAdmin_Email(rs.getString("Admin_Email"));
				admin.setAdmin_Password(rs.getString("Admin_Password"));
				admin.setAdmin_Role(rs.getString("Admin_Role"));
				return admin;
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
