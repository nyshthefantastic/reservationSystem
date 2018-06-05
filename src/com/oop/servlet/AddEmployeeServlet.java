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
 * Servlet implementation class LoginServlet
 */
public class AddEmployeeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEmployeeServlet() {
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
		
		reservation.setName(request.getParameter("cusName"));
		reservation.setAddress(request.getParameter("address"));
		reservation.setContactNumber(request.getParameter("conNo"));
		reservation.setResDate(request.getParameter("resdate"));
		reservation.setNoOfChairs(request.getParameter("noChair"));
		reservation.setEmail(request.getParameter("emailAdd"));

		IReservationService iEmployeeService = new ReservationServiceImpl();
		iEmployeeService.addTableReservation(reservation);

		request.setAttribute("employee", reservation);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListEmployees.jsp");
		dispatcher.forward(request, response);
	}

}
