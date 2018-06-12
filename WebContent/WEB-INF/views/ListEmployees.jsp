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
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel = "stylesheet"
   type = "text/css"
   href = "Employee.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Food Ordering System</title>
	   <script>
	   function myFunc(){
            $(document).ready(function(){
		        $( "input[type=checkbox]" ).each(function(){
		            if($(this).is(':checked'))
		            {
		                var value = $(this).closest('tr').find($( "input[type=text]" )).val();
		                console.log(value);
		                var amount = document.getElementById("xy").innerText;
		                console.log(amount);
		                document.getElementById('totVal').value="Total Value is : "+amount*value;
		                console.log('Total Value is : '+amount*value);
		                

		            }
		        });
		    });
            
	   }
            </script>
</head>
<body>
	<h3>Food Ordering System</h3>
	
	<br>
	<br>
	  <div align="left">
		<table border="1" cellpadding="12" id="mytable">
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
				<td id="xy"> <%=foods.getUnitPrice()%>  </td>
				<td> <input type="text" name="amtEntered" /> </td>
				
				<td> 
					
				 
				 </td>	
				</tr>			
			<%	
			   }
            %>     
         
            <tr>
								<td colspan="2"><input type="submit" value="Submit Order" onclick="myFunc()" class="list-button" />
								</td>
							</tr>
		</table>
		<script>
			
			
				</script>
				<textarea id="totVal"></textarea>
	<!-- 		<form method="POST" action="submitOrderServelet">
				
						<table>
							<tr>
								<td colspan="2"><input type="submit" value="Submit Order" class="list-button" />
								</td>
							</tr>
						</table>
					</form> -->
		</div>
		
</body>
</html>