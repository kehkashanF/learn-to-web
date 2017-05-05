package com.psl.ibm.spec.unit.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.HttpStatus;
import org.glassfish.jersey.server.validation.ValidationError;
import org.junit.Test;

import com.psl.ibm.spec.bean.Designation;
import com.psl.ibm.spec.bean.Employee;
import com.psl.ibm.spec.dao.Constant;

import static org.junit.Assert.*;

public class TestCreateService extends JerseyTestSetup {


	 /**
	 * Test for creating user
	 */
	 @Test
	 public void addUserTest() {
	
	
	 Employee employee = new Employee();
	 employee.setEmpName("John Doe");
	 employee.setEmpAge(22);
	 employee.setDesignation(Designation.TEAM_LEAD);
	
	
	 Entity<Employee> userEntity = Entity.entity(employee,
	 MediaType.APPLICATION_XML_TYPE);
	 //Here we send POST request
	 final Response response= target(Constant.EMPLOYEE_PATH).request().post(userEntity);
	
	 assertEquals(HttpStatus.SC_CREATED, response.getStatus());
	 }

	/**
	 * Test for bean validation with Invalid Inputs 
	 * 
	 * @throws Exception
	 */
	@Test
	public void addInvalidContactTest() throws Exception {
		final Employee entity = new Employee();
		entity.setEmpName("John123");
		entity.setEmpAge(100);
		entity.setDesignation(Designation.TEAM_LEAD);

		Entity<Employee> userEntity = Entity.entity(entity,
				MediaType.APPLICATION_JSON_TYPE);
		// Here we send POST request
		final Response response = target(Constant.EMPLOYEE_PATH).request(
				MediaType.APPLICATION_JSON_TYPE).post(userEntity);

		assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus());

		final List<ValidationError> validationErrorList = getValidationErrorList(response);
		for (final ValidationError validationError : validationErrorList) {
			assertTrue(validationError.getPath().contains(
					"Employee.createEmp.arg0."));
		}

		final Set<String> messageTemplates = getValidationMessageTemplates(validationErrorList);
		assertEquals(2, messageTemplates.size());
		assertTrue(messageTemplates.contains("{employee.wrong.name}"));
		assertTrue(messageTemplates
				.contains("{javax.validation.constraints.DecimalMax.message}"));
	}

	/**
	 * Test for bean validation with Null Inputs 
	 * 
	 * @throws Exception
	 */
	@Test
	public void addNullContactTest() throws Exception {
		final Employee entity = new Employee();
		entity.setDesignation(Designation.TEAM_LEAD);

		Entity<Employee> userEntity = Entity.entity(entity,
				MediaType.APPLICATION_XML_TYPE);
		// Here we send POST request
		final Response response = target(Constant.EMPLOYEE_PATH).request(
				MediaType.APPLICATION_XML_TYPE).post(userEntity);

		assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus());

		final List<ValidationError> validationErrorList = getValidationErrorList(response);
		for (final ValidationError validationError : validationErrorList) {
			assertTrue(validationError.getPath().contains(
					"Employee.createEmp.arg0."));
		}

		final Set<String> messageTemplates = getValidationMessageTemplates(validationErrorList);
		assertEquals(2, messageTemplates.size());
		assertTrue(messageTemplates.contains("{employee.null.name}"));
		assertTrue(messageTemplates
				.contains("{javax.validation.constraints.DecimalMin.message}"));
	}

	/**
	 * To get bean validation message templates
	 * @param response
	 * @return
	 */
	private List<ValidationError> getValidationErrorList(final Response response) {
		return response.readEntity(new GenericType<List<ValidationError>>() {
		});
	}

	private Set<String> getValidationMessageTemplates(
			final List<ValidationError> errors) {
		final Set<String> templates = new HashSet<>();
		for (final ValidationError error : errors) {
			templates.add(error.getMessageTemplate());
		}
		return templates;
	}

}
