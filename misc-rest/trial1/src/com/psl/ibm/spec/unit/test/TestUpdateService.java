package com.psl.ibm.spec.unit.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

public class TestUpdateService extends JerseyTestSetup {
	/**
	 * Test UPDATE SUCCESS
	 */
	@Test
	public void updateEmployeeTest() throws Exception {

		 Employee employee = new Employee();
		 employee.setEmpName("Shaista Fazal");
		 employee.setEmpAge(37);
		 employee.setDesignation(Designation.TEAM_LEAD);
		
		
		 Entity<Employee> userEntity = Entity.entity(employee,
		 MediaType.APPLICATION_XML_TYPE);
		final Response response = target(Constant.EMPLOYEE_PATH).path("3").request()
				.put(userEntity);

		assertEquals(HttpStatus.SC_OK, response.getStatus());
		assertTrue(response.readEntity(String.class).contains(
				Constant.UPDATE_SUCCESS));
	}

	/**
	 * Test UPDATE FAILURE
	 */
	@Test
	public void updateEmployeeErrorTest() throws Exception {

		final Employee entity = new Employee();
		entity.setEmpAge(100);
		Entity<Employee> userEntity = Entity.entity(entity,
				MediaType.APPLICATION_JSON_TYPE);
		final Response response = target(Constant.EMPLOYEE_PATH).path("3").request(MediaType.APPLICATION_JSON_TYPE)
				.put(userEntity);
		assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus());
		final List<ValidationError> validationErrorList = getValidationErrorList(response);
		for (final ValidationError validationError : validationErrorList) {
			assertTrue(validationError.getPath().contains(
					"Employee.updateEmp.arg1."));
		}

		final Set<String> messageTemplates = getValidationMessageTemplates(validationErrorList);
		assertEquals(3, messageTemplates.size());
		assertTrue(messageTemplates.contains("{employee.null.name}"));
		assertTrue(messageTemplates
				.contains("{javax.validation.constraints.DecimalMax.message}"));
		assertTrue(messageTemplates.contains("{employee.wrong.designation}"));
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
