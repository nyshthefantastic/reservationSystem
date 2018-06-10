
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
import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;


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
		createEmployeeTable();
	}


	
	public static void createEmployeeTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE));
			// Create new employees table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	
	@Override
	public void addTableReservation(Reservation reservation) {

		String employeeID = CommonUtil.generateIDs(getEmployeeIDs());
		
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
	public Reservation getEmployeeByID(String employeeID) {

		return actionOnEmployee(employeeID).get(0);
	}
	
	
	@Override
	public ArrayList<Reservation> getEmployees() {
		
		return actionOnEmployee(null);
	}

	
	@Override
	public void removeEmployee(String employeeID) {

		// Before deleting check whether employee ID is available
		if (employeeID != null && !employeeID.isEmpty()) {
			/*
			 * Remove employee query will be retrieved from EmployeeQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_EMPLOYEE));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, employeeID);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}

	/**
	 * This performs GET employee by ID and Display all employees
	 * 
	 * @param employeeID
	 *            ID of the employee to remove or select from the list

	 * @return ArrayList<Employee> Array of employee list will be return
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws NullPointerException
	 *             - Service is not available
	 * 
	 * @see #getEmployees()
	 * @see #getEmployeeByID(String)
	 */
	private ArrayList<Reservation> actionOnEmployee(String employeeID) {

		ArrayList<Reservation> employeeList = new ArrayList<Reservation>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching employee it checks whether employee ID is
			 * available
			 */
			if (employeeID != null && !employeeID.isEmpty()) {
				/*
				 * Get employee by ID query will be retrieved from
				 * EmployeeQuery.xml
				 */
				  String load = "SELECT * FROM Foods WHERE id='" + employeeID + "'";

		            pst = con.prepareStatement(load);
			}
			/*
			 * If employee ID is not provided for get employee option it display
			 * all employees
			 */
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
				
				employeeList.add(reservation);
			}

		} catch (SQLException |  ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} 
		return employeeList;
	}

	/**
	 * Get the updated employee
	 * 
	 * @param employeeID
	 *            ID of the employee to remove or select from the list
	 * 
	 * @return return the Employee object
	 * 
	 */
	@Override
	public Reservation updateEmployee(String employeeID, Reservation reservation) {

		/*
		 * Before fetching employee it checks whether employee ID is available
		 */
		if (employeeID != null && !employeeID.isEmpty()) {
			/*
			 * Update employee query will be retrieved from EmployeeQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_EMPLOYEE));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, reservation.getName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, reservation.getAddress());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, reservation.getContactNumber());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, reservation.getResDate());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, reservation.getAddress());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, reservation.getNoOfChairs());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, reservation.getEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, reservation.getEmployeeID());
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		// Get the updated employee
		return getEmployeeByID(employeeID);
	}

	private ArrayList<String> getEmployeeIDs(){
		
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
