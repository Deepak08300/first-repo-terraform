package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;

public class BookingOrderDaoIMPL implements BookingOrderDao {

@Autowired
public void orderbook(Integer bookid,String orderername,String ordereraddress, Integer quantity) {
	      Connection c = null;
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         c = DriverManager
	            .getConnection("jdbc:mysql://localhost:3307/oracomp1",
	            "oracomp", "password");
	         Integer fulfilled;
	         String sql = "CALL Booking_order(?,?,?,?,@fulfilled)";
		      PreparedStatement preparedStatement = c.prepareStatement(sql) ;
		      preparedStatement.setInt(1, bookid);
		      preparedStatement.setString(2, orderername);
		      preparedStatement.setString(3, ordereraddress);
		      preparedStatement.setInt(4, quantity);
		      
		      
		      int rs = preparedStatement.executeUpdate();
		     
		      if(rs==1)
			    {
			    	System.out.println("Order Completed");
			    }else {
			    	System.out.println("Order Unfufilled");
			    }
			   
		     
	         System.out.println("successfull db connection" );
	     
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.out.println("Error");
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	     
	
	}



}
