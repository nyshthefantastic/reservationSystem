<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "resSystem.css" />

<meta charset="UTF-8">
<title>Online table reservation</title>
</head>
<body class="body">

	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

	<h2 class="h2">Online table reservation</h2>

	<br>
	<br>

	<form method="POST" action="AddFoodServlet">
		<table>

			<tr>
				<td>Full Name</td>
				<td><input type="text" name="cusName" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td>Contact Number</td>
				<td><input type="text" name="conNo" /></td>
			</tr>
			<tr>
				<td>Reservation Date and time</td>
			    <td><input type=datetime-local  step="1" name="resdate"></td>
			
			</tr>
			<tr>
				<td>Number of Chairs</td>
				<td><input type="text" name="noChair" /></td>
			</tr>
			<tr>
				<td>Email Address</td>
				<td><input type="text" name="emailAdd" /></td>
			</tr>
		
			<tr>
				<td colspan="2"><input type="submit" value="Add Food" class="add-button" /> </td>
			</tr>
			
		</table>
	</form>

	<form method="POST" action="ListFoodServlet">
		<table>
			<tr>
				<td colspan="2"><input type="submit" value="List All Food" class="list-button" />
				</td>
			</tr>
		</table>
	</form>


</body>
</html>