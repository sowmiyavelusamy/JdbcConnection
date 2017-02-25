package org.jdbc.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import org.jdbc.model.Triangle;
import org.springframework.stereotype.Component;



@Component
public class DaoImpl {
	
	public Triangle getTriangle(int triangleid){
		
		
		Connection con =null;
		
	    try{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:port/db";
		String username = "***";
		String password = "***";
		
	
			Class.forName(driver).newInstance();
			
			
			 con = DriverManager.getConnection(url,username,password);
			
			String preparedSQL = "select  * from triangle where id =?";
			
			PreparedStatement ps = con.prepareStatement(preparedSQL);
			
		    System.out.println("connected to database");
		    
			ps.setInt(1, triangleid);
			
			System.out.println("Before tri.null");
			
			Triangle tri= null;
			
			
			ResultSet rs = ps.executeQuery();
			
			System.out.println("Before rs.next");
			if(rs.next()){
				System.out.println("inside rs.next");
				  tri = new Triangle(triangleid, rs.getString("name"));
			}
			else{
				System.out.println("null");
			}
			rs.close();
			ps.close();
			return tri;
	}
	
	catch(Exception e){
		 throw new RuntimeException("errot" +e);
	}
	
	finally{
		try{
			con.close();
		}catch(SQLException e){
			
		}
	}
			
			
			
			
		
		
		
		
		
		
		
		
	}

}
