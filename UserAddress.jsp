<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Address</title>
	<link rel="stylesheet" type="text/css" href="UserAdress.css">
</head>
<body>
	<h1>ADD NEW ADDRESS</h1>
	
	<form action="addAddress" method="POST">
			<h1>Add Address</h1>
			<h4>Input your work place address </h4>
			<label>Province</label>  <input type="text" name="province">
			<label>District</label>  <input type="text" name="district">
			<label>Sector</label>    <input type="text" name="sector">
			<label>Cell</label>      <input type="text" name="cell">
			<label>Village</label>   <input type="text" name="village">

			<h4>Health Care Worker's work place and residence</h4>
			Health Care Center <input type="text" name="hcc">
			Residential Area 
			<select>
			  <option value="nearby">Nearby</option>
			  <option value="far">Far</option>
			  <option value="same area">Same Area</option>
			</select>
			
		    <input type="submit"  value="Save">
	</form>
		
</body>
</html>