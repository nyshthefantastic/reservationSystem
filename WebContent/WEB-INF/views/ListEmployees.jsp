<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.oop.model.Reservation"%>

 <%@page import="java.util.*"%>
<%@page import="com.oop.service.ReservationServiceImpl"%>
<%@page import="com.oop.service.IReservationService"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "Employee.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SLIIT OOP Employee Management</title>
</head>
<body>
	<h3>List of Employees</h3>
	SLIIT Employee Management App for OOP jsp servlet.
	<br>
	<br>
	  <div align="left">
		<table border="1" cellpadding="12">
		 <caption><h2>List of Employees</h2></caption>
		 <a href="homeView.jsp">Add Employee</a>
		  <tr>
                <th>Chooser</th>
                <th>Food Id</th>
                <th>Food Name</th>
                <th>Unit Price</th>
                 <th>Amount</th>
               
            </tr>
            <%
            	IReservationService iEmployeeService = new ReservationServiceImpl();
                                    	ArrayList<Reservation> arrayList = iEmployeeService.getEmployees();
                                    	
                                    	for(Reservation employee : arrayList){
            %>
			 <tr>
			 	<td><input type="checkbox" name="name1" />&nbsp; </td>	
				<td> <%=employee.getEmployeeID() %> </td>
				<td> <%=employee.getName() %> </td>
				<td> <%=employee.getAddress() %> </td>
				<td> <input type="text" name="amtEntered" /> </td>
				
				<td> 
					<form method="POST" action="GetEmployeeServlet">
						<input type="hidden" name="employeeID" value="<%=employee.getEmployeeID()%>"/>
					 	<input type="submit" value= "Select Employee" class="select-button" /> 
					 </form>
				 
				 </td>	
				</tr>			
			<%	
			   }
            %>     
		</table>
			<form method="POST" action="ListEmployeeServlet">
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