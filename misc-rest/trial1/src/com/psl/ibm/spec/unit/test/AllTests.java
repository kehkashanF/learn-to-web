package com.psl.ibm.spec.unit.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestGetService.class, TestCreateService.class,
		TestUpdateService.class, TestDeleteService.class })
public class AllTests {

}
 