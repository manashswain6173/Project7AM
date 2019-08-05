package com.usa.his.admin.repositery;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usa.his.admin.entity.RoleMaster;

/**
 * This is the Role Repository interface.Used to perform curd operation on the database table.
 * @author manash
 *
 */
@Repository
public interface RolesRepository extends JpaRepository<RoleMaster, Serializable> {

}
