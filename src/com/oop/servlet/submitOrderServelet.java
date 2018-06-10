package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Food;
import com.oop.service.IFoodServiceImpl;
import com.oop.service.IFoodService;

public class submitOrderServelet extends HttpServlet  {

	
		private static final long serialVersionUID = 1L;

		public submitOrderServelet() {
			super();
		}

		
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

		}

		
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			response.setContentType("text/html");

			Food foods = new Food();
		
		}


}
