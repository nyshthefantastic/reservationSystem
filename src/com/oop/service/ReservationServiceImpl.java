
package com.oop.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.oop.util.dbconnct;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.oop.model.Reservation;


public class ReservationServiceImpl implements IReservationService {
	

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ReservationServiceImpl.class.getName());

	private static Connection connection;
	
	private static Statement statement;
	 Connection con = null;
	 PreparedStatement pst = null;
	 ResultSet rs = null;
		private PreparedStatement preparedStatement;

	 public ReservationServiceImpl() {
		 
	        con = dbconnct.connect();

	 }
	static{
		//create table or drop if exist
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
	
	@Override
	public Reservation getFoodById(String foodId) {

		return actionOnEmployee(foodId).get(0);
	}
	
	
	@Override
	public ArrayList<Reservation> getEmployees() {
		
		return actionOnEmployee(null);
	}

	
	
	private ArrayList<Reservation> actionOnEmployee(String res) {

		ArrayList<Reservation> foodInfoList = new ArrayList<Reservation>();
		try {
		
			if (res != null && !res.isEmpty()) {
				
				  String load = "SELECT * FROM Foods WHERE id='" + res + "'";

		            pst = con.prepareStatement(load);
			}
			
			else {
				  String load = "SELECT * FROM Foods";

		            pst = con.prepareStatement(load);
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Reservation reservation = new Reservation();
				reservation.setEmployeeID(resultSet.getString("id"));
				reservation.setName(resultSet.getString("foodName"));
				reservation.setAddress(resultSet.getString("unitPrice"));
				
				foodInfoList.add(reservation);
			}

		} catch (SQLException  e) {
			log.log(Level.SEVERE, e.getMessage());
		} 
		return foodInfoList;
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
