package com.manash.repositery;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manash.entity.SSNDetailsEntity;


@Repository("ssnRepo")
public interface SSNEnrollRepositery extends JpaRepository<SSNDetailsEntity, Serializable> {
	
}
