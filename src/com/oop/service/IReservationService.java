
package com.oop.service;

import com.oop.model.Reservation;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

public interface IReservationService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IReservationService.class.getName());


	public void addTableReservation(Reservation reservation);


	public Reservation getEmployeeByID(String empoyeeID);
	

	public ArrayList<Reservation> getEmployees();
	

	public Reservation updateEmployee(String employeeID, Reservation reservation);


	public void removeEmployee(String employeeID);

}
