package com.example.demo;

import java.sql.SQLException;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
@EnableScheduling
public class BookingOrderController {

	public static void main(String[] args) {
		SpringApplication.run(BookingOrderController.class, args);
	}
	
	@RequestMapping("/orderbook")
	public void orderbook(@RequestBody String data )  throws SQLException, ParseException, JSONException {
		
		
		JSONObject jsonObject = new JSONObject(data);

		  String bookid_S =
		  (String)jsonObject.get("bookid"); 
		  Integer bookid = Integer.parseInt(bookid_S);
		  String orderername =
		  (String)jsonObject.get("orderername"); 
		  
		  String ordereraddress =
		  (String)jsonObject.get("ordereraddress"); 
		 
		  String quantity_S =
		  (String)jsonObject.get("quantity"); 
		  Integer quantity = Integer.parseInt(quantity_S);
		  
		 
		  System.out.println("data is "+bookid+" ordernanme:"+orderername +" orderer Address :"+ordereraddress+ "quantity : "+quantity);
		  	
		 
	
		System.out.println("DB Connections start");
		BookingOrderDao bookingorderdao = new BookingOrderDaoIMPL();
		//bookingorderdao.orderbook(bookid,orderername,ordereraddress,quantity);
		bookingorderdao.orderbook(1,"Ordering Book1","T12N56W",12);
		System.out.println("DB Connections end");

	}

}
