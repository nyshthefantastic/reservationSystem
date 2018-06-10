package com.oop.model;

public class Food {
	

	private String foodid;
	
	private String foodname;

	private String unitPrice;
	
	public String getFoodID() {
		return foodid;
	}

	public void setFoodID(String foodID) {
		foodid = foodID;
	}


	public String getName() {
		return foodname;
	}


	public void setName(String name) {
		foodname = name;
	}
	public String getUnitPrice() {
		return unitPrice;
	}

	
	public void setUnitPrice(String price) {
		unitPrice = price;
	}

	@Override
	public String toString() {
		
		return "Food Name = " + foodname + "\n" + "Unit Price = " + unitPrice ;
	}

}
