package com.manash.test;

import static org.junit.Assert.assertSame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.manash.service.Calculator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitTestApp1ApplicationTests {
	
	@Autowired
	private Calculator cal;
	static int i=1;
	
	@Before
	public  void before() {
		System.out.println("******Before Method executed::"+i+"*****");
		i++;
	}
	@BeforeClass
	public  static void beforeCls() {
		System.out.println("*****BeforeClass Method executed::"+i+"*****");
		i++;
	}

	@Test
	public void test1_add() {
		assertSame(30.0,cal.add(10, 20));
	}
	@Test
	public void test2_add() {
		assertSame(0.0, cal.add(0, 0));
	}
	
	@After
	public  void after() {
		System.out.println("******After Method executed::"+i+"*****");
		i++;
	}
	@AfterClass
	public static void afterCls() {
		System.out.println("*****AfterClass Method executed::"+i+"*****");
		i++;
	}

}
