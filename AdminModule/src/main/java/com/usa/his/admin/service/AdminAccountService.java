package com.usa.his.admin.service;

import java.util.List;

import com.usa.his.admin.dto.AdminDTO;

public interface AdminAccountService {
	/**
	 * This method gives all the roles that are available in the database table.
	 * @return
	 */
	public List<String> getAllRoles();
	/**
	 * 
	 * This Method is used to create admin account by talking to the database table.
	 * @param dto
	 * @return String
	 */
	public String createAdminAccount(AdminDTO dto);
	/**
	 * This method is used to load all the admin details.
	 * @return List<AdminDTO>
	 */
	public List<AdminDTO> loadAllAdmin();
	
	/**
	 * This method is used to check whether the given mail is exist or not
	 * @param emilId
	 * @return
	 */
	public String checkEmailAvailablity(String emilId);

}
