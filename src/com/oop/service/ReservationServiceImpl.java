
package com.oop.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.oop.util.dbconnct;


import com.oop.model.Reservation;


public class ReservationServiceImpl implements IReservationService {
	

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ReservationServiceImpl.class.getName());

	
	 Connection con = null;
	 PreparedStatement pst = null;
	 ResultSet rs = null;
		private PreparedStatement preparedStatement;

	 public ReservationServiceImpl() {
		 
	        con = dbconnct.connect();

	 }
	static{
	
	}


	

	
	@Override
	public void addTableReservation(Reservation reservation) {

		
		if(checkNumberofReservations( reservation.getContactNumber(), reservation.getafterdate())<15) {
			
		
		try {
		
			
            String q = "INSERT INTO table_reservation(name,address,contactNumber,resDate,NoOfChairs,email) VALUES ('" + reservation.getName() + "','" + reservation.getAddress() + "','" + reservation.getContactNumber() + "','" + reservation.getResDate() + "','" +  reservation.getNoOfChairs()  + "','" +  reservation.getEmail() + "')";
            pst = con.prepareStatement(q);
            pst.execute();
            System.out.println("SUCCESS");
			

		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		
		}
		}
	}
	
	public int checkNumberofReservations(String startDateTime,String endDateTime) {
		int numberOfReservations=0;
		 try {
	            String load = "SELECT COUNT(resId) FROM table_reservation WHERE resDate BETWEEN '" + startDateTime + "' AND '" + endDateTime + "'";

	            pst = con.prepareStatement(load);
	            rs = pst.executeQuery();
	            if (rs.next()) {
	            	numberOfReservations=rs.getInt(1);
	            }
	            
	        } catch (Exception e) {
	            System.out.println(e);
	        }
 		return numberOfReservations;

		
	}
	
		
	


	
	private ArrayList<String> getFoodId(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		try {
			 
		            String load = "SELECT * FROM Foods";

		            pst = con.prepareStatement(load);
		            rs = pst.executeQuery();
					while (rs.next()) {
							arrayList.add(rs.getString("id"));
					}
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} 
		return arrayList;
	
	}
}
