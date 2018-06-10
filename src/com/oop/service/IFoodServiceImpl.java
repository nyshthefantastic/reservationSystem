package com.oop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

import com.oop.model.Food;
import com.oop.model.Reservation;
import com.oop.util.dbconnct;

public class IFoodServiceImpl implements IFoodService{
	 Connection con = null;
	 PreparedStatement pst = null;
	 ResultSet rs = null;

	 public IFoodServiceImpl() {
		 
	        con = dbconnct.connect();

	 }
	 @Override
	public Food getFoodByID(String foodid) {

			return actiononfood(foodid).get(0);
	}
	@Override
	public ArrayList<Food> getFoods() {
		
		return actiononfood(null);
	}
	
	private ArrayList<Food> actiononfood(String foodID) {

		ArrayList<Food> foodList = new ArrayList<Food>();
		try {
			
			
			
			if (foodID != null && !foodID.isEmpty()) {
				
				  String load = "SELECT * FROM Foods WHERE id='" + foodID + "'";

		            pst = con.prepareStatement(load);
			}
			
			else {
				  String load = "SELECT * FROM Foods";

		            pst = con.prepareStatement(load);
			}
				rs=pst.executeQuery();
			while (rs.next()) {
				Food foods = new Food();
				foods.setFoodID(rs.getString("id"));
				foods.setName(rs.getString("foodName"));
				foods.setUnitPrice(rs.getString("unitPrice"));
				
				foodList.add(foods);
			}

		} catch (SQLException e) {
			
		} 
		return foodList;
	}
}
