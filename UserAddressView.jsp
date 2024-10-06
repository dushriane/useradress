<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.useraddress.User_address_model" %>
<%@ page import="com.useraddress.User_address_services" %>

<%
	User_address_services service = new User_address_services();
	List<User_address_model> addresses = service.getAllAddresses();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Addresses</title>
</head>
<body>
	<h1>VIEW ADDRESSES</h1>
	<a href="UserAddress.jsp">Add New Address</a>
	<br><br>
	
	<table border = 1>
		<tr>
			<th>ID</th>
			<th>Province</th>
			<th>District</th>
			<th>Sector</th>
			<th>Cell</th>
			<th>Village</th>
			<th>Health Care Center</th>
			<th>Residence</th>
		</tr>
		<% for(User_address_model address : addresses){ %>
			<tr>
				<td><%= address.getId() %></td>
				<td><%= address.getProvince() %></td>
				<td><%= address.getDistrict() %></td>
				<td><%= address.getSector() %></td>
				<td><%= address.getCell() %></td>
				<td><%= address.getVillage() %></td>
				<td><%= address.getHeathcarecenter() %></td>
				<td><%= address.getResidential() %></td>
			
			</tr>
		<% } %>
	</table>
</body>
</html>