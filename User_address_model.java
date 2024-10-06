package com.useraddress;

public class User_address_model {
	private Long userID;
	private String province;
	private String district;
	private String sector;
	private String cell;
	private String village;
	private String health_care_center;
	private String residential;
	
	
	
	/*public Object getId() {
		return null;
	}*/
	
	public Long getId() {
		return userID;
	}
	public void setId(long userID) {
		this.userID = userID;
	}
	
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		
	}
	
	public String getCell() {
		return cell;
	}
	public void setCell(String cell) {
			
	}
	
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		
	}
	
	public String getHeathcarecenter() {
		return health_care_center;
	}
	public void setHcc(String health_care_center) {
		
	}
	
	public String getResidential() {
		return residential;
	}
	public void setResidence(String residential) {
		
	}
}
