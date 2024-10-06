<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.useraddress.User_address_model" %>
<%@ page import="com.useraddress.User_address_services" %>

<%
	Long id = Long.parseLong(request.getParameter("id"));
	User_address_services service = new User_address_services();
	User_address_model address= service.getAddressById(id);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Addresses</title>
</head>
<body>
	<h1>UPDATE ADDRESS</h1>
	<form action="updateAddress" method="post">
		<input type="hidden" name="id" value="<%= address.getId() %>" />
		<label>Province: </label> <input type="text" value="<% address.getProvince(); %>" />
		<label>District: </label> <input type="text" value="<% address.getDistrict(); %>" />
		<label>Sector: </label> <input type="text" value="<% address.getSector(); %>" />
		<label>Cell: </label> <input type="text" value="<% address.getCell(); %>" />
		<label>Village: </label> <input type="text" value="<% address.getVillage(); %>" />
		<label>Health Care Center: </label> <input type="text" value="<% address.getHeathcarecenter(); %>" />
		<label>Residence: </label> <input type="text" value="<% address.getResidential(); %>" />
		
		<input type="submit" value="Update">
	</form>
</body>
</html>