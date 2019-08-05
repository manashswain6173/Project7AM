package com.manash.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manash.entity.StudentDetailsEntity;

@Repository
public interface StudentCurdRepositery extends JpaRepository<StudentDetailsEntity, Integer> {

}
