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
public class GetEmployeeServlet extends HttpServlet {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetEmployeeServlet() {
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

 		String employeeID = request.getParameter("employeeID");			
		IReservationService resSer = new ReservationServiceImpl();
		Reservation reservation = resSer.getFoodById(employeeID);

		request.setAttribute("employee", reservation);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/GetEmployee.jsp");
		dispatcher.forward(request, response);
	}

}
