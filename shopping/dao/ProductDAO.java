package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dto.Product;
import com.shopping.util.JDBCConnection;

public class ProductDAO 
{
	private static final String selectproducts="select * from product_details";
	 private static final String insertProducts="insert into product_details(Product_Name, Product_Brand, Product_Price, "
	    		+ "Product_Mfg_Date, Product_Exp_Date, Product_Quantity, Product_Category, Product_Discount) values(?,?,?,?,?,?,?,?)";
	 public boolean insertProductDetails(Product product)
	 {
		 try {
			Connection connection=JDBCConnection.forMySqlConnection();
			PreparedStatement ps=connection.prepareStatement(insertProducts);
			ps.setString(1, product.getProduct_Name());
			ps.setString(2, product.getProduct_Brand());
			ps.setDouble(3, product.getProduct_Price());
			ps.setDate(4, product.getProduct_Mfg_Date());
			ps.setDate(5, product.getProduct_Exp_Date());
			ps.setInt(6, product.getProduct_Quantity());
			ps.setString(7, product.getProduct_Category());
			ps.setDouble(8, product.getProduct_Discount());
			int result=ps.executeUpdate();
			if(result!=0)
				return true;
			else
			   return false;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
	 }
	 public boolean insertMoreThanOneProduct(List<Product> listOfProducts) {
		 try {
			Connection connection=JDBCConnection.forMySqlConnection();
			PreparedStatement ps=connection.prepareStatement(insertProducts);
			for(Product product:listOfProducts)
			{
				ps.setString(1, product.getProduct_Name());
				ps.setString(2, product.getProduct_Brand());
				ps.setDouble(3, product.getProduct_Price());
				ps.setDate(4, product.getProduct_Mfg_Date());
				ps.setDate(5, product.getProduct_Exp_Date());
				ps.setInt(6, product.getProduct_Quantity());
				ps.setString(7, product.getProduct_Category());
				ps.setDouble(8, product.getProduct_Discount());
				ps.addBatch();
			}
			int [] result=ps.executeBatch();
			if(result.length!=0)
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
	 public List<Product> selectAllProductDetails()
	 {
		 /* select * from product_details*/
		 try {
			Connection connection=JDBCConnection.forMySqlConnection();
			PreparedStatement ps=connection.prepareStatement(selectproducts);
			ResultSet rs=ps.executeQuery();
			List<Product> listOfproducts=new ArrayList<Product>();
			if(rs.isBeforeFirst())
			{
				while(rs.next())
				{
					Product product=new Product();
					product.setProduct_Id(rs.getInt("Product_Id"));
					product.setProduct_Name(rs.getString("Product_Name"));
					product.setProduct_Brand(rs.getString("Product_Brand"));
					product.setProduct_Price(rs.getDouble("Product_Price"));
					product.setProduct_Mfg_Date(rs.getDate("Product_Mfg_Date"));
					product.setProduct_Exp_Date(rs.getDate("Product_Exp_Date"));
					product.setProduct_Quantity(rs.getInt("Product_Quantity"));
					product.setProduct_Category(rs.getString("Product_Category"));
					product.setProduct_Discount(rs.getDouble("Product_Discount"));
					listOfproducts.add(product);
				}
				return listOfproducts;
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
