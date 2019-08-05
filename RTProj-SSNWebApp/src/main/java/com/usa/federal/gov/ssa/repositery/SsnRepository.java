package com.usa.federal.gov.ssa.repositery;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usa.federal.gov.ssa.entity.SsnMasterEntity;

public interface SsnRepository extends JpaRepository<SsnMasterEntity, Serializable> {

}
