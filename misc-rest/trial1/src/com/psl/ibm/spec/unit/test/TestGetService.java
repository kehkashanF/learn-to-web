package com.psl.ibm.spec.unit.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.HttpStatus;
import org.junit.Test;

import com.psl.ibm.spec.bean.Employee;
import com.psl.ibm.spec.bean.Employees;
import com.psl.ibm.spec.dao.Constant;

public class TestGetService extends JerseyTestSetup {

	/**
	 * Test to fetch ALL EMPLOYEES
	 */
	@Test
	public void testGetAllEmployees() throws Exception {
		final WebTarget target = target().path(Constant.EMPLOYEE_PATH);

		// JSON
		Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
				.get();

		assertEquals(HttpStatus.SC_OK, response.getStatus());
		assertEquals(MediaType.APPLICATION_JSON_TYPE, response.getMediaType());

		// XML
		response = target.request(MediaType.APPLICATION_XML_TYPE).get();

		assertEquals(HttpStatus.SC_OK, response.getStatus());
		assertEquals(MediaType.APPLICATION_XML_TYPE, response.getMediaType());

	}


	/**
	 * Test to sort employee by name and age
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSort() throws Exception {

		// name in ascending order
		Employee previous = new Employee();
		previous.setEmpName("");
		for (final Employee employee : testSort(
				Constant.QUERY_PARAM_ORDERBYASC, "name").getEmployees()) {
			assertTrue(employee.getEmpName().compareTo(previous.getEmpName()) >= 0);
			previous = employee;
		}

		// age in descending order
		previous.setEmpAge(Integer.MAX_VALUE);
		for (final Employee employee : testSort(
				Constant.QUERY_PARAM_ORDERBYDESC, "age").getEmployees()) {
			assertTrue(previous.getEmpAge() >= employee.getEmpAge());
			previous = employee;
		}

	}


	/**
	 * Test to SEARCH employee by NAME using filters
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSearchByName() throws Exception {
		// starts with
		for (final Employee employee : testFilterByNameParameter("~sw~K")
				.getEmployees()) {
			assertTrue(employee.getEmpName().startsWith("K"));
		}

		// ends with
		for (final Employee employee : testFilterByNameParameter("~ew~na")
				.getEmployees()) {
			assertTrue(employee.getEmpName().endsWith("NA"));
		}

		// contains
		for (final Employee employee : testFilterByNameParameter("~ct~sh")
				.getEmployees()) {
			assertTrue(employee.getEmpName().contains("SH"));
		}

		// equals
		for (final Employee employee : testFilterByNameParameter("~eq~rozina")
				.getEmployees()) {
			assertTrue("Rozina".equalsIgnoreCase(employee.getEmpName()));
		}
	}

	/**
	 * Test to SEARCH employee by AGE using filters
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSearchByAge() throws Exception {
		// less than
		for (final Employee employee : testFilterByAgeOrIdParameter(
				Constant.QUERY_PARAM_AGE, "~lt~30").getEmployees()) {
			assertTrue(employee.getEmpAge() < 30);
		}

		// greater than
		for (final Employee employee : testFilterByAgeOrIdParameter(
				Constant.QUERY_PARAM_AGE, "~gt~24").getEmployees()) {
			assertTrue(employee.getEmpAge() > 24);
		}

		// equal to
		for (final Employee employee : testFilterByAgeOrIdParameter(
				Constant.QUERY_PARAM_AGE, "~eq~22").getEmployees()) {
			assertTrue(employee.getEmpAge() == 22);
		}
	}

	/**
	 * Test to SEARCH employee by ID using filters
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSearchById() throws Exception {
		// less than
		for (final Employee employee : testFilterByAgeOrIdParameter(
				Constant.QUERY_PARAM_ID, "~lt~5").getEmployees()) {
			assertTrue(employee.getEmpId() < 5);
		}

		// greater than
		for (final Employee employee : testFilterByAgeOrIdParameter(
				Constant.QUERY_PARAM_ID, "~gt~2").getEmployees()) {
			assertTrue(employee.getEmpId() > 2);
		}

		// equal to
		for (final Employee employee : testFilterByAgeOrIdParameter(
				Constant.QUERY_PARAM_ID, "~eq~5").getEmployees()) {
			assertTrue(employee.getEmpId() == 5);
		}
	}
	
	/**
	 * Test Sorting and Filtering 
	 * @throws Exception
	 */
	@Test
	public void testSortAndFilter() throws Exception {

		final WebTarget target = target().path(Constant.EMPLOYEE_PATH);
		Employees employees;
		Response response = target
				.queryParam(Constant.QUERY_PARAM_ORDERBYASC, "age")
				.queryParam(Constant.QUERY_PARAM_ORDERBYDESC, "name")
				.queryParam(Constant.QUERY_PARAM_ID, "~lt~9")
				.request(MediaType.APPLICATION_JSON_TYPE).get();

		employees = response.readEntity(Employees.class);

		Employee previous = new Employee();
		previous.setEmpName("");
		previous.setEmpAge(Integer.MIN_VALUE);
		assertEquals(HttpStatus.SC_OK, response.getStatus());
		for (final Employee employee : employees.getEmployees()) {
			assertTrue(previous.getEmpAge() <= employee.getEmpAge());
			if(previous.getEmpAge() == employee.getEmpAge())
				assertTrue(previous.getEmpName().compareTo(employee.getEmpName()) >= 0);
			assertTrue(employee.getEmpId() < 9);
			previous = employee;
		}

	}

	/**
	 * Test for get Employee by ID PATH PARAMETER
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetEmployeeById() throws Exception {
		final WebTarget target = target().path(Constant.EMPLOYEE_PATH);
		// GET
		Response response = target.path("2")
				.request(MediaType.APPLICATION_JSON_TYPE).get();
		assertEquals(HttpStatus.SC_OK, response.getStatus());
	}

	/**
	 * Test for Error in Get Employee by ID PATH PARAMETER
	 * 
	 * @throws Exception
	 */
	@Test
	public void testEmployeeDoesNotExist() throws Exception {
		final WebTarget target = target().path(Constant.EMPLOYEE_PATH);

		// GET
		Response response = target.path("123")
				.request(MediaType.APPLICATION_JSON_TYPE).get();

		assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus());
		assertTrue(response.readEntity(String.class).contains(
				"No employee found"));
	}

	/**
	 * @param searchParameter
	 * @return
	 */
	private Employees testFilterByNameParameter(final String searchParameter) {
		final WebTarget target = target().path(Constant.EMPLOYEE_PATH);
		Employees employees;
		Response response = target.queryParam("name", searchParameter)
				.request(MediaType.APPLICATION_JSON_TYPE).get();

		employees = response.readEntity(Employees.class);
		assertEquals(HttpStatus.SC_OK, response.getStatus());
		return employees;
	}

	/**
	 * @param filter
	 * @param searchParameter
	 * @return
	 */
	private Employees testFilterByAgeOrIdParameter(final String filter,
			final String searchParameter) {
		final WebTarget target = target().path(Constant.EMPLOYEE_PATH);
		Employees employees;
		Response response = target.queryParam(filter, searchParameter)
				.request(MediaType.APPLICATION_JSON_TYPE).get();

		employees = response.readEntity(Employees.class);
		assertEquals(HttpStatus.SC_OK, response.getStatus());
		return employees;
	}

	/**
	 * @param filter
	 * @param searchParameter
	 * @return
	 */
	private Employees testSort(final String sortby, final String sortParameter) {
		final WebTarget target = target().path(Constant.EMPLOYEE_PATH);
		Employees employees;
		Response response = target.queryParam(sortby, sortParameter)
				.request(MediaType.APPLICATION_JSON_TYPE).get();

		employees = response.readEntity(Employees.class);
		assertEquals(HttpStatus.SC_OK, response.getStatus());
		return employees;
	}
}
