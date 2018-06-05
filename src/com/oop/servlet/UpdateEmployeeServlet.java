package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Reservation;
import com.oop.service.ReservationServiceImpl;
import com.oop.service.IReservationService;

/**
 * Update employees servlet
 */
public class UpdateEmployeeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateEmployeeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		Reservation reservation = new Reservation();
		String employeeID = request.getParameter("employeeID");	
		reservation.setEmployeeID(employeeID);
		reservation.setName(request.getParameter("employeeName"));
		reservation.setAddress(request.getParameter("address"));
		reservation.setAddress(request.getParameter("designation"));
		reservation.setContactNumber(request.getParameter("faculty"));
		reservation.setResDate(request.getParameter("department"));
		reservation.setNoOfChairs(request.getParameter("qualification"));
		reservation.setEmail(request.getParameter("gender"));
		
		IReservationService iEmployeeService = new ReservationServiceImpl();
		iEmployeeService.updateEmployee(employeeID, reservation);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListEmployees.jsp");
		dispatcher.forward(request, response);
	}

}
