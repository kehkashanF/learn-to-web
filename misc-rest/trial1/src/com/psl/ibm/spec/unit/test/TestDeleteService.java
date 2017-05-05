package com.psl.ibm.spec.unit.test;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.apache.http.HttpStatus;
import org.junit.Test;

import com.psl.ibm.spec.dao.Constant;

import static org.junit.Assert.*;

public class TestDeleteService extends JerseyTestSetup {

	/**
	 * Test for Delete Success
	 * 
	 * @throws Exception
	 */
	@Test
	public void employeeDeleteTest() throws Exception {
		final WebTarget target = target().path(Constant.EMPLOYEE_PATH);

		// DELETE
		Response response = target.path("21").request().delete();

		assertEquals(HttpStatus.SC_OK, response.getStatus());
		assertTrue(response.readEntity(String.class).contains(
				Constant.DELETE_SUCCESS));
	}

	/**
	 * Test for Delete Failure
	 * 
	 * @throws Exception
	 */
	@Test
	public void employeeDeleteFailureTest() throws Exception {
		final WebTarget target = target().path(Constant.EMPLOYEE_PATH);

		// GET
		Response response = target.path("179").request().delete();

		assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus());
		assertTrue(response.readEntity(String.class).contains(
				"No Employee to Delete"));
	}
}
