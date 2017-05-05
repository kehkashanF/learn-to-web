package com.psl.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import com.psl.exception.InfiniteValueException;

public class test_MySciCalculator {

	MySciCalculator client=null;
	@Rule
	public Timeout timeout=new Timeout(1000);
	
	@Rule
	public ExpectedException exc=ExpectedException.none();
	@Before
	public void setUp() throws Exception {
		client=new MySciCalculator();
	}

	@Test
	public void testPower(){
		assertEquals(8, client.getPower(2,3));
		assertEquals(27, client.getPower(3,3));
	}
	
	@Test
	public void testSquareRoot(){
		assertEquals(8.0, client.squareRoot(64), 0);
	}
	
	@Test
	public void testAbsValue(){
		assertEquals(5, client.absValue(5.66));
	}
	
	@Test
	public void testGetLogValue() throws InfiniteValueException{
		assertEquals(0.602, client.getLogValue(4),3);
	}
	
	@Test(expected=InfiniteValueException.class)
	public void testInfiniteValueFromLog() throws Exception{
		client.getLogValue(0);
	}
	@After
	public void tearDown() throws Exception {
			client=null;
	}



}
