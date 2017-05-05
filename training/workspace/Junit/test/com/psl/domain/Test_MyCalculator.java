package com.psl.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.psl.exception.InvalidInputException;

public class Test_MyCalculator {

	MyCalculator cal = null;

	// Fixtures

	// class level fixture - before class is getting instantiated
	@BeforeClass
	public static void setUp_class() {
		System.out.println("Before class level fixture");
	}

	// test level fixture - before any test
	@Before
	public void setup() {
		cal = new MyCalculator();
		System.out.println("Test level fixtures");
	}

	@Test(timeout = 500)
	public void testAdd() {

		MyCalculator cal = new MyCalculator();
		assertEquals(4, cal.add(3, 4)); // we will use Junit to test this
							// method.
		assertEquals(5, cal.add(3, 2));
	
	}

	@Ignore
	// to ignore this method i.e. don't run
	@Test
	public void testmult() {
		fail("Not Implemented");
	}

	@Test
	public void testdivide() {
		try {
			assertEquals(2, cal.divide(10, 5));
			assertEquals(5, cal.divide(10, 2));
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}

	}
	@Test(expected = InvalidInputException.class)
	public void testDivideThrowsInvalidException() throws Exception{
		cal.divide(23, 0);
	}


	@Test
	public void testincr() {
		List<Integer> lst = new ArrayList<Integer>();
		cal.incr(lst, 20);
		assertTrue(lst.size() == 1);
		cal.incr(lst, 30);
		assertTrue(lst.size() == 2);
		cal.incr(lst, 40);
		assertTrue(lst.size() == 3);

	}

	@After
	public void tearDown() {
		cal = null;
		System.out.println("after test level fixture");
	}

	@AfterClass
	public static void tearDown_Class() {
		System.out.println("after class level fixture");
	}
}
