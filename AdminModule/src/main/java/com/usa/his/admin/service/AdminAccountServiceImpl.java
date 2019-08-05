package com.usa.his.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.his.admin.config.AppsMessage;
import com.usa.his.admin.constants.AppsConstants;
import com.usa.his.admin.dto.AdminDTO;
import com.usa.his.admin.entity.AdminAccountMaster;
import com.usa.his.admin.entity.RoleMaster;
import com.usa.his.admin.repositery.AdminAccountRepositery;
import com.usa.his.admin.repositery.RolesRepository;

/**
 * This is the service class is used to perform business operation in the
 * application.
 * 
 * @author manash
 *
 */
@Service
public class AdminAccountServiceImpl implements AdminAccountService {

	/**
	 * Initializing Logger object to perform logging operation.
	 */
	private static final Logger LOG = LogManager.getLogger(AdminAccountServiceImpl.class);

	/**
	 * Injecting Admin repository class object to perform curd operation on the
	 * database table.
	 */
	@Autowired
	private AdminAccountRepositery repositery;
	/**
	 * Injecting Role repository class object to perform curd operation on the
	 * database table.
	 */
	@Autowired
	private RolesRepository roleRepo;

	/**
	 * This is the field which binded with properties file show messages.
	 */
	@Autowired
	private AppsMessage msg;

	
	@Override
	public String createAdminAccount(AdminDTO dto) {
		AdminAccountMaster entity = null;
		LOG.info("***createAdminAccount() method execution started***");
		entity = new AdminAccountMaster();
		try {
			if (dto != null) {
				LOG.debug("***Coping data from dto to entity***");
				BeanUtils.copyProperties(dto, entity);
				entity = repositery.save(entity);
			} else {
				LOG.warn("***Failled to copy data from dto to entity***");
			}
		} catch (Exception e) {
			LOG.error("createAdminAccount() method throwing exception***");
			e.printStackTrace();
		}
		LOG.info("***createAdminAccount() method execution completed***");
		return (entity.getAdminId() != null) ? msg.getProperties().get(AppsConstants.SUCC_MSG)
				: msg.getProperties().get(AppsConstants.FAIL_MSG);
	}
	
	@Override
	public List<String> getAllRoles() {
		List<RoleMaster> roleMasterList = null;
		LOG.info("***getAllRoles() method execution started***");

		roleMasterList = roleRepo.findAll();
		List<String> roles = new ArrayList<String>(roleMasterList.size());
		try {
			if (!roleMasterList.isEmpty()) {
				LOG.debug("***getting all roles from roleMasterList collection***");
				roleMasterList.forEach(master -> {
					roles.add(master.getRole());
				});
			}
		} catch (Exception e) {
			LOG.error("***getAllMethod() throws Exception***");
			e.printStackTrace();
		}
		LOG.info("***getAllRoles() method execution completed***");
		return roles;
	}

	@Override
	public List<AdminDTO> loadAllAdmin() {
		List<AdminAccountMaster> adminList = null;
		LOG.info("***loadAllAdmin() method execution started***");

		adminList = repositery.findAll();
		List<AdminDTO> adminDtoList = new ArrayList<AdminDTO>(adminList.size());
		try {
			if (!adminList.isEmpty()) {
				LOG.debug("***coping data from adminList to dto list***");
				adminList.forEach(admin -> {
					AdminDTO dto = new AdminDTO();
					BeanUtils.copyProperties(admin, dto);
				});
			}
		} catch (Exception e) {
			LOG.error("***loadAllAdmin() method throws exception***");
			e.printStackTrace();
		}
		return adminDtoList;
	}

	@Override
	public String checkEmailAvailablity(String emailId) {
		AdminAccountMaster result=null;
		String msg=null;
		LOG.info("****checkEmailAvailablity() method execution started****");
		try {
			result=repositery.findByEmail(emailId);
			if(result==null) {
				LOG.debug("***Email field contains null value***");
				msg="not-available";
			}
			else {
				   LOG.debug("***Email already registred***");
					msg="available";
			}
		}
		catch(Exception e) {
			LOG.error("***checkEmailAvailablity() method throws exception***");
			e.printStackTrace();
		}
		return msg;
	}

}
