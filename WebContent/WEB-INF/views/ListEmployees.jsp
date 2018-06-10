<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.oop.model.Food"%>

 <%@page import="java.util.*"%>
<%@page import="com.oop.service.IFoodServiceImpl"%>
<%@page import="com.oop.service.IFoodService"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "Employee.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Food Ordering System</title>
</head>
<body>
	<h3>Food Ordering System</h3>
	
	<br>
	<br>
	  <div align="left">
		<table border="1" cellpadding="12">
		 <caption><h2>List of Food Items</h2></caption>
		 <a href="homeView.jsp">Table Reservation</a>
		  <tr>
                <th>Chooser</th>
                <th>Food Id</th>
                <th>Food Name</th>
                <th>Unit Price</th>
                 <th>Amount</th>
               
            </tr>
            <%
            	IFoodService ifoods = new IFoodServiceImpl();
                                    	ArrayList<Food> arrayList = ifoods.getFoods();
                                    	
                                    	for(Food foods : arrayList){
            %>
			 <tr>
			 	<td><input type="checkbox" name="name1" />&nbsp; </td>	
				<td> <%=foods.getFoodID() %> </td>
				<td> <%=foods.getName() %> </td>
				<td> <%=foods.getUnitPrice()%>  </td>
				<td> <input type="text" name="amtEntered" /> </td>
				
				<td> 
					
				 
				 </td>	
				</tr>			
			<%	
			   }
            %>     
		</table>
			<form method="POST" action="submitOrderServelet">
						<table>
							<tr>
								<td colspan="2"><input type="submit" value="Submit Order" class="list-button" />
								</td>
							</tr>
						</table>
					</form>
		</div>
		
</body>
</html>