package com.usa.federal.gov.ssa;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.usa.federal.gov.ssa.entity.StateMasterEntity;
import com.usa.federal.gov.ssa.repositery.StateRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RtProjSsnWebAppApplicationTests {

	@Autowired
	private StateRepository stateRepo;
	
	@Test
	public void test1_getAllState() {
		List<StateMasterEntity> states=stateRepo.findAll();
		assertNotNull(states);
	}
	
	@Test
	public void test2_getAllState() {
		List<StateMasterEntity> states=stateRepo.findAll();
		assertEquals(20, states.size());
	}
}
