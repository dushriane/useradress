package com.useraddress;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class User_address_repository {
	private List<User_address_model> addresses = new ArrayList<>();
	private long idCounter = 1;
	
	//create or update
	public User_address_model save(User_address_model userAddress) {
		if(userAddress.getId() == null) {
			userAddress.setId(idCounter++);
			addresses.add(userAddress);
		}else {
			addresses = update(userAddress);
		}
		return userAddress;
	}
	
	//read all
	public List<User_address_model> findAll(){
		return addresses;
	}
	
	//read by ID
	public Optional<User_address_model> findById(Long userID){
		return addresses.stream().filter(a->a.getId().equals(userID)).findFirst();
	}
	public User_address_model findByID(Long userID) {
		return addresses.stream().filter(a->a.getId().equals(userID)).findFirst();
	}
	
	//delete by ID
	public Object deletedById(Long userID) {
		return addresses.removeIf(a->a.getId().equals(userID));
	}
	
	private List<User_address_model> update(User_address_model userAddress){
		for(int i = 0; i < addresses.size(); i++) {
			if(addresses.get(i).getId().equals(userAddress.getId())) {
				addresses.set(i, userAddress);
			}
		}
		return addresses;
	}

}
