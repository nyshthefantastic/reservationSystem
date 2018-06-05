
package com.oop.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class Reservation {

	private String EmployeeID;
	
	private String Name;

	private String address;

	private String contactNumber;

	private String ResDate;

	
	private String noOfChairs;
	
	private String email;
	
	private String afterDate;

	public String getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(String employeeID) {
		EmployeeID = employeeID;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}
	public String getContactNumber() {
		return contactNumber;
	}

	
	public void setContactNumber(String contact) {
		contactNumber = contact;
	}

	
	public String getAddress() {
		return address;
	}


	public void setAddress(String add) {
		address = add;
	}


	public String getResDate() {
		return ResDate;
	}
	public String getafterdate() {
		return afterDate;
	}
	
	public void setResDate(String rDate) {
		
		String temp[]=rDate.split("T");
		
		ResDate = temp[0]+" "+temp[1];
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 try {
			Date date = formatter.parse(ResDate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.HOUR_OF_DAY, 3);
			afterDate = formatter.format(cal.getTime());

			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}



	public String getNoOfChairs() {
		return noOfChairs;
	}


	public void setNoOfChairs(String noChairs) {
		noOfChairs = noChairs;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String mail) {
		email = mail;
	}

	@Override
	public String toString() {
		
		return "Customer Name = " + Name + "\n" + "Address = " + address + "\n"
				+ "Contact Number  = " + contactNumber + "\n" + "Reservation Date = " + ResDate + "\n" 
				 + "Number of Chairs = " + noOfChairs + "\n" + "email = " + email;
	}
}
