package com.useraddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name ="User_address_servlet", urlPatterns = {"/addAddress", "/updateAddress", "/delete"})
public class User_address_servlet extends HttpServlet {
	private User_address_services service = new User_address_services();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String action = req.getServletPath();
		
		if(action.equals("/addAddress")) {
			addAddress(req, res);
		}else if(action.equals("/updateAddress")) {
			updateAddress(req, res);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String action = req.getServletPath();
		
		if(action.equals("/delete")) {
			deleteAddress(req, res);
		}
	}
	
	private void addAddress(HttpServletRequest req, HttpServletResponse res) throws IOException{
		User_address_model address = new User_address_model();
		//address.setId(req.getParameter("userID"));	
		address.setProvince(req.getParameter("province"));	
		address.setDistrict(req.getParameter("district"));	
		address.setSector(req.getParameter("sector"));	
		address.setCell(req.getParameter("cell"));	
		address.setVillage(req.getParameter("village"));	
		address.setHcc(req.getParameter("healthcarecenter"));	
		address.setResidence(req.getParameter("residence"));	
		
		service.saveOrUpdate(address);
		res.sendRedirect("UserAddress.jsp");
	}
	
	private void updateAddress(HttpServletRequest req, HttpServletResponse res) throws IOException{
		Long id = Long.parseLong(req.getParameter("id"));
		User_address_model address = service.getAddressById(id);
		
		if(address != null) {
			address.setProvince(req.getParameter("province"));	
			address.setDistrict(req.getParameter("district"));	
			address.setSector(req.getParameter("sector"));	
			address.setCell(req.getParameter("cell"));	
			address.setVillage(req.getParameter("village"));	
			address.setHcc(req.getParameter("healthcarecenter"));	
			address.setResidence(req.getParameter("residence"));
			
			service.saveOrUpdate(address);
		}
		
		res.sendRedirect("UserAddress.jsp");
	}
	
	private void deleteAddress(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		service.deleteAddress(id);
		res.sendRedirect("UserAddress.jsp");
	}
}
