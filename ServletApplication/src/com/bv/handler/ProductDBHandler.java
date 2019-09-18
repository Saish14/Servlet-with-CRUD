package com.bv.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bv.connection.DBconnect;
import com.bv.model.Products;

public class ProductDBHandler {

	public static int addProducts(Products product)
	{
		int status = 0;
		String sql = "insert into products(productname , manufacturername , price) values (?,?,?)";
		
		Connection connection = DBconnect.getConnection();
		
		try
		{
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			prepared.setString(1, product.getProductname());
			prepared.setString(2, product.getManufacturername());
		    prepared.setDouble(3, product.getPrice());
		    
		    status = prepared.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	
	
	public static int UpdateProducts(Products product)
	{
		int status = 0;
		String sql = "update products set productname = ? , manufacturername = ? , price = ? where id = ?";
		
		Connection connection = DBconnect.getConnection();
		
		try
		{
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			prepared.setString(1, product.getProductname());
			prepared.setString(2, product.getManufacturername());
		    prepared.setDouble(3, product.getPrice());
		    prepared.setInt(4, product.getId());
		    
		    status = prepared.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	
	
	public static int DeleteProducts(int id)
	{
		int status = 0;
		String sql = "Delete from products where id = ?";
		
		Connection connection = DBconnect.getConnection();
		
		try
		{
			PreparedStatement prepared = connection.prepareStatement(sql);
			
		    prepared.setInt(1, id);
		    
		    status = prepared.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	public static List<Products> getAllProducts()
	{
		 List<Products> list=new ArrayList<>();
		String sql = "select * from products";
		Connection connection = DBconnect.getConnection();

		try {
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				Products products=new Products();
				products.setId(rs.getInt("id"));
				products.setProductname(rs.getString("PRODUCTNAME"));
				products.setManufacturername(rs.getString("MANUFACTURERNAME"));
				products.setPrice(rs.getDouble("PRICE"));
				list.add(products);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public static Products getProductById(int id)
	{
		Products products =  new Products();
		String sql = "select * from products where id = ?";
		Connection connection = DBconnect.getConnection();
		
		try
		{
			PreparedStatement prepared = connection.prepareStatement(sql);
			prepared.setInt(1, id);
			
			ResultSet rs = prepared.executeQuery();
			
			while (rs.next()) {

				products.setId(rs.getInt("id"));
				products.setProductname(rs.getString("productname"));
				products.setManufacturername(rs.getString("manufacturername"));
				products.setPrice(rs.getDouble("price"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
		
	}
}
