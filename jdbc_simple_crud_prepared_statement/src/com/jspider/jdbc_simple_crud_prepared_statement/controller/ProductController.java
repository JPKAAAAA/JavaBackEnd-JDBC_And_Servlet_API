package com.jspider.jdbc_simple_crud_prepared_statement.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import com.jspider.jdbc_simple_crud_prepared_statement.connection.ProductConnection;
import com.jspider.jdbc_simple_crud_prepared_statement.entity.Product;

public class ProductController {
	public static void main(String[] args)
	{
		Scanner cin=new Scanner(System.in);
		Connection connection=ProductConnection.getProductConnection();
		boolean flag=true;
		do
		{
			System.out.println("1. INSERT\n2. DISPLAY\n3. DISPLAY ALL\n4. UPDATE COLOR AND NAME BY ID\n5. DELETE BY NAME\n6. EXIT");
			System.out.println("Select your Option: ");
			int choice=cin.nextInt();
			switch(choice)
			{
			case 1:{
				String insertProductQuery="insert into product(name,color,price,mfd,expd) values(?,?,?,?,?)";
				try
				{
					System.out.println("Enter Product Name: ");
					String name=cin.next();
					System.out.println("Enter Product Color: ");
					String color=cin.next();
					System.out.println("Enter Product Price: ");
					double price=cin.nextDouble();
					System.out.println("Enter Product Manufacturing Date: ");
					LocalDate mfd=LocalDate.parse(cin.next());
					System.out.println("Enter Product Expiry Date: ");
					String exp=cin.next();
					LocalDate expd=LocalDate.parse(exp);
					Product product=new Product();
					product.setName(name);
					product.setColor(color);
					product.setPrice(price);
					product.setMfd(mfd);
					product.setExpd(expd);
					PreparedStatement ps=connection.prepareStatement(insertProductQuery);
					ps.setString(1, product.getName());
					ps.setString(2, product.getColor());
					ps.setDouble(3, product.getPrice());
					ps.setObject(4, product.getMfd());
					ps.setObject(5, product.getExpd());
					int a=ps.executeUpdate();
					String msg=a!=0?"Data Stored Successfully!!":"Data not Stored, Check with your Code";
					System.out.println(msg);
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}break;
			case 2:{
				String displayProductByIdQuery="Select * from product where id=?";
				try
				{
					System.out.println("Enter Product ID to Display: ");
					int SearchID=cin.nextInt();
					PreparedStatement ps=connection.prepareStatement(displayProductByIdQuery);
					ps.setInt(1, SearchID);
					ResultSet set=ps.executeQuery();
					if(set.next()) 
					{
						int id=set.getInt("id");
						String name=set.getString("name");
						String color=set.getString("color");
						double price=set.getDouble("price");
						LocalDate mfd=set.getDate("mfd").toLocalDate();
						LocalDate expd=set.getDate("expd").toLocalDate();
						Product product=new Product();
						product.setId(id);
						product.setName(name);
						product.setColor(color);
						product.setPrice(price);
						product.setMfd(mfd);
						product.setExpd(expd);
						System.out.println(product);
					}
					else
						System.out.println("Given ID not Found or check your Code");
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}break;
			case 3:{
				String displayAllProductQuery="Select * from product";
				try
				{
					PreparedStatement ps=connection.prepareStatement(displayAllProductQuery);
					ResultSet set=ps.executeQuery();
					while(set.next()) 
					{
						int id=set.getInt("id");
						String name=set.getString("name");
						String color=set.getString("color");
						double price=set.getDouble("price");
						LocalDate mfd=set.getDate("mfd").toLocalDate();
						LocalDate expd=set.getDate("expd").toLocalDate();
						Product product=new Product();
						product.setId(id);
						product.setName(name);
						product.setColor(color);
						product.setPrice(price);
						product.setMfd(mfd);
						product.setExpd(expd);
						System.out.println(product);
					}
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}break;
			case 4:{
				String updateProductPriceAndColorQuery="update product set price=?,color=? where id=?";
				try
				{
					System.out.println("Enter Product  ID to Update: ");
					int id=cin.nextInt();
					System.out.println("Enter New Product Color: ");
					String color=cin.next();
					System.out.println("Enter New Product Price: ");
					double price=cin.nextDouble();
					PreparedStatement ps=connection.prepareStatement(updateProductPriceAndColorQuery);
					ps.setInt(3, id);
					ps.setString(2, color);
					ps.setDouble(1, price);
					int a=ps.executeUpdate();
					String msg=a!=0?a+" Data Updated":"Data Not Updated, Check with your Code";
					System.out.println(msg);
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}break;
			case 5:{
				String deleteProductByNameQuery="delete from product where name=?";
				try
				{
					System.out.println("Enter Product Name to Delete: ");
					String id=cin.next();
					PreparedStatement ps=connection.prepareStatement(deleteProductByNameQuery);
					ps.setString(1, id);
					int a=ps.executeUpdate();
					String msg=a!=0?a+" Data Deleted":"Data Not Deleted, Check with your Code";
					System.out.println(msg);
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}break;
			case 6:{
				flag=false;
			}break;	
			default:{
				System.out.println("Invalid Choice");
			}break;
			}
		}while(flag);
		System.out.println("Program Terminated");
		cin.close();
	}
}
