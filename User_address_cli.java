package com.useraddress;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

//import org.apache.tomcat.jni.Address;

public class User_address_cli {
	
	private User_address_services userAddressService = new User_address_services();
	private Scanner scan = new Scanner(System.in);
	
	public void start() {
		while (true) {
			printMenu();
			int choice = scan.nextInt();
			scan.nextLine();
			
			switch(choice) {
				case 1: 
					createAddress();
					break;
				case 2:
					viewAllAddresses();
					break;
				case 3:
					viewAddressById();
					break;
				case 4: 
					updateAddress();
					break;
				case 5:
					deleteAddress();
					break;
				case 6:
					System.out.println("Exiting...");
					return;
				default:
					System.out.println("Invalid choice. Try again.");
					
			}
		}
	}
	
	private void printMenu() {
		System.out.println("User Address Management System (CLI)");
		System.out.println("1. Create Address");
		System.out.println("2. View All Addresses");
		System.out.println("3. View Address by ID");
		System.out.println("4. Update Address");
		System.out.println("5. Delete Address");
		System.out.println("6. Exit");
		System.out.println("Choose an option: ");
	}
	
	private void createAddress() {
		System.out.println("Enter your User ID: ");
		long userID = scan.nextInt();
		System.out.println("Enter province: ");
		String province = scan.nextLine();
		System.out.println("Enter district: ");
		String district = scan.nextLine();
		System.out.println("Enter sector: ");
		String sector = scan.nextLine();
		System.out.println("Enter cell: ");
		String cell = scan.nextLine();
		System.out.println("Enter village: ");
		String village = scan.nextLine();
		System.out.println("Enter health care center you work at: ");
		String health_care_center = scan.nextLine();
		System.out.println("Is your residential area far? (Yes/No): ");
		String residential = scan.nextLine();
		
		User_address_model userAddress = new User_address_model();
		userAddress.setId(userID);
		userAddress.setProvince(province);
		userAddress.setDistrict(district);
		userAddress.setSector(sector);
		userAddress.setCell(cell);
		userAddress.setVillage(village);
		userAddress.setHcc(health_care_center);
		userAddress.setResidence(residential);
		
		userAddressService.saveOrUpdate(userAddress);
		
	}
	
	private void viewAllAddresses() {
		List<User_address_model> addresses = userAddressService.getAllAddresses();
		if(addresses.isEmpty()) {
			System.out.println("No addresses found.");
		} else {
			addresses.forEach(address -> System.out.println(address.toString()));
		}
	}
	
	private void viewAddressById() {
		System.out.println("Enter ID: ");
		Long id = scan.nextLong();
		Optional<User_address_model> address = userAddressService.getAddressById(id);
		
		if(address.isPresent()) {
			System.out.println(address.get());
		} else {
			System.out.println("Address not found");
		}
		}
	
	private void updateAddress() {
		System.out.print("Enter ID of the address to update: ");
		Long id = scan.nextLong();
		scan.nextLine();
		Optional<User_address_model> address = userAddressService.getAddressById(id);
		
		if(address.isPresent()) {
			System.out.println("Updating address: " + address.get().toString());
		}else {
			System.out.println("Address not found.");
		}
	}
	
	private void deleteAddress() {
		System.out.print("Enter ID to delete: ");
		Long id = scan.nextLong();
		userAddressService.deleteAddress(id);
		System.out.println("Address deleted succeddfully.");
	}
}
