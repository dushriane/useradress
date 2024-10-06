package com.useraddress;

import java.util.List;
import java.util.Optional;
import java.sql.*;
import java.util.ArrayList;

public class User_address_services {
	
	private User_address_repository userAddressRepository = new User_address_repository();
	
	/*public User_address_model saveOrUpdate(User_address_model userAddress) {
		return userAddressRepository.save(userAddress);
	}
	
	public List<User_address_model> getAllAddresses(){
		return userAddressRepository.findAll();
	}
	
	public Optional<User_address_model> getAddressById(Long id){
		return userAddressRepository.findById(id);
	}
	
	public User_address_model getAddessById(Long id) {
		return userAddressRepository.findById(id);
	}
	public  Object deleteAddress(Long id) {
		return userAddressRepository.deletedById(id);
	}
	*/
	
	
	// SQL Queries
    private static final String INSERT_SQL = "INSERT INTO addresslist (province, district, sector, cell, village, hcc, residence) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE addresslist SET province=?, district=?, sector=?, cell=?, village=?, hcc=?, residence=? WHERE id=?";
    private static final String DELETE_SQL = "DELETE FROM addresslist WHERE id=?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM addresslist";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM addresslist WHERE id=?";

    
    public void saveOrUpdate(User_address_model address) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = JDBCUtil.getConnection();

            if (address.getId() == null) {
                // New address - perform INSERT
                stmt = conn.prepareStatement(INSERT_SQL);
            } else {
                // Existing address - perform UPDATE
                stmt = conn.prepareStatement(UPDATE_SQL);
                stmt.setLong(11, address.getId()); // Set the ID for update
            }

            stmt.setString(1, address.getProvince());
            stmt.setString(2, address.getDistrict());
            stmt.setString(3, address.getSector());
            stmt.setString(4, address.getCell());
            stmt.setString(5, address.getVillage());
            stmt.setString(6, address.getHeathcarecenter());
            stmt.setString(7, address.getResidential());
            

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(conn);
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
    public void deleteAddress(Long id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(DELETE_SQL);
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(conn);
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
    public User_address_model getAddressById(Long id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User_address_model address = null;

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(SELECT_BY_ID_SQL);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                address = new User_address_model();
                address.setId(rs.getLong("id"));
                address.setProvince(rs.getString("province"));
                address.setDistrict(rs.getString("district"));
                address.setSector(rs.getString("sector"));
                address.setCell(rs.getString("cell"));
                address.setVillage(rs.getString("village"));
                address.setHcc(rs.getString("health care center"));
                address.setResidence(rs.getString("residence"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(conn);
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return address;
    }

    
    public List<User_address_model> getAllAddresses() {
        List<User_address_model> addresses = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SELECT_ALL_SQL);

            while (rs.next()) {
            	User_address_model address = new User_address_model();
                address.setId(rs.getLong("id"));
                address.setProvince(rs.getString("province"));
                address.setDistrict(rs.getString("district"));
                address.setSector(rs.getString("sector"));
                address.setCell(rs.getString("cell"));
                address.setVillage(rs.getString("village"));
                address.setHcc(rs.getString("health care center"));
                address.setResidence(rs.getString("residence"));
                

                addresses.add(address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(conn);
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return addresses;
    }

	
}
