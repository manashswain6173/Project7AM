package com.usa.his.admin.repositery;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usa.his.admin.entity.AdminAccountMaster;
/**
 * This is the AdminAccountRepository class is used  to perform curd operation in the database table.  
 * @author manas
 *
 */

@Repository
public interface AdminAccountRepositery extends JpaRepository<AdminAccountMaster,Serializable> {
	/**
	 * This method is used gives the email id based on the given email id if already exists.
	 * @param emailId
	 * @return String
	 */
	@Query(name="from AdminAccountMaster where email=:emailId")
	public AdminAccountMaster findByEmail(String emailId);

}
