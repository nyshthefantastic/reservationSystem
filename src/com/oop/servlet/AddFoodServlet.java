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


public class AddFoodServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public AddFoodServlet() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	
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

		IReservationService iresservice = new ReservationServiceImpl();
		iresservice.addTableReservation(reservation);

		request.setAttribute("employee", reservation);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListFoods.jsp");
		dispatcher.forward(request, response);
	}

}
