package com.psl.ibm.spec.resources;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.ws.rs.core.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.ValidationException;

import org.apache.activemq.broker.BrokerService;

import com.psl.ibm.spec.bean.AtomLink;
import com.psl.ibm.spec.bean.Employee;
import com.psl.ibm.spec.bean.Employees;
import com.psl.ibm.spec.dao.Constant;
import com.psl.ibm.spec.dao.EmployeeDAOImpl;
import com.psl.ibm.spec.exceptions.EmployeeException;
import com.psl.ibm.spec.exceptions.EmployeeValidator;

/**
 * A Serviceable class EmployeeResource defines methods for Create, Update,
 * Delete and Fetching of Employee records from Database
 * 
 * @author kehkashan_fazal
 */

@Path("/employees")
public class EmployeeResource {

	@Context
	private UriInfo uriInfo;

	/**
	 * Resource Method to retrieve all Employees stored in database, supports
	 * sorting on age, name and id supports filtering on designation
	 * 
	 * @param orderByAsc
	 * @param orderByDesc
	 * @param designation
	 * @return
	 * @throws ValidationException
	 * @throws EmployeeException
	 */
	@GET
	@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getEmployees(
			@QueryParam(Constant.QUERY_PARAM_ORDERBYASC) String orderByAsc,
			@QueryParam(Constant.QUERY_PARAM_ORDERBYDESC) String orderByDesc,
			@QueryParam(Constant.QUERY_PARAM_DESIGNATION) String designation,
			@QueryParam(Constant.QUERY_PARAM_NAME) String name,
			@QueryParam(Constant.QUERY_PARAM_ID) String id,
			@QueryParam(Constant.QUERY_PARAM_AGE) String age)
			throws ValidationException, EmployeeException {

		new EmployeeValidator().employeeFetchParametersValidation(orderByAsc,
				orderByDesc);

		Employees employees = new EmployeeDAOImpl().getEmployees(orderByAsc,
				orderByDesc, designation, name, id, age, null);

		for (Employee employee : employees.getEmployees()) {
			UriBuilder selfie = uriInfo.getBaseUriBuilder();
			selfie.path(EmployeeResource.class, "getEmployeeById");
			employee.setSelf(new AtomLink(selfie.buildFromEncoded(
					"employees/" + employee.getEmpId()).toString(),
					MediaType.APPLICATION_XML, "self"));
		}

//		BrokerService broker = new BrokerService();  
//		// configure the broker  
//		try {
//			broker.addConnector("tcp://localhost:61616");
//			broker.start();  
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}  
//		
//	
//		try {
//			broker.stop();
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		} 
		return Response.ok(employees).build();
	}

	/**
	 * Resource Method to Retrieve employee by ID, takes integer Employee ID as
	 * path parameter
	 * 
	 * @param empId
	 * @return
	 * @throws EmployeeException
	 * @throws ValidationException
	 */
	@GET
	@Path("{empid}")
	@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getEmployeeById(
			@PathParam(Constant.EMPLOYEE_ID) String empid)
			throws EmployeeException {

		int empId = new EmployeeValidator().validateEmployeeId(empid);

		List<String> errorMessages = new ArrayList<String>();
		// Employee employee = new EmployeeDAOImpl().getEmployeeById(empId);

		Employees employees = new EmployeeDAOImpl().getEmployees(null, null,
				null, null, null, null, new Integer(empId).toString());
		if (employees.getEmployees().isEmpty())
			errorMessages.add("employee.find.error");
		if (!errorMessages.isEmpty()) {
			throw new EmployeeException(errorMessages);
		}
		return Response.ok(employees).build();
	}

	/**
	 * Resource Method to Create an Employee, Accepts JSON and XML formats and
	 * performs automatic marshalling
	 * 
	 * @param employee
	 * @return
	 * @throws ValidationException
	 * @throws EmployeeException
	 */
	@POST
	@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response createEmp(
			@NotNull(message = "{employee.empty.means}") @Valid Employee employee)
			throws EmployeeException {
		List<String> errorMessages = new ArrayList<String>();

		if (!new EmployeeDAOImpl().createEmployee(employee))
			errorMessages.add("employee.create.error");
		if (!errorMessages.isEmpty()) {
			throw new EmployeeException(errorMessages);
		}
		return Response.status(Status.CREATED).entity(Constant.CREATE_SUCCESS)
				.build();
	}

	/**
	 * Resource Method to UPDATE an employee, accepts form parameters for name,
	 * age and designation, accepts path parameter for ID (Integer)
	 * 
	 * @param empId
	 * @param empName
	 * @param empAge
	 * @param designation
	 * @return
	 * @throws ValidationException
	 * @throws EmployeeException
	 */
	@PUT
	@Path("{empid}")
	@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response updateEmp(
			@NotNull(message = "{employee.empty.means}") @PathParam(Constant.EMPLOYEE_ID) String empid,
			@Valid Employee employee) throws ValidationException,
			EmployeeException {

		int empId = new EmployeeValidator().validateEmployeeId(empid);

		List<String> errorMessages = new ArrayList<String>();
		employee.setEmpId(empId);
		if (!new EmployeeDAOImpl().updateEmployee(employee)) {
			errorMessages.add("employee.update.error");
			throw new EmployeeException(errorMessages);
		}

		return Response.status(Status.OK)
				.entity(Constant.UPDATE_SUCCESS + employee).build();
	}

	/**
	 * Resource Method to DELETE employee accepts ID as path parameter
	 * 
	 * @param empId
	 * @return
	 * @throws EmployeeException
	 */
	@DELETE
	@Path("{empid}")
	@Produces(value = { MediaType.TEXT_HTML, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_JSON })
	public Response deleteEmp(@PathParam(Constant.EMPLOYEE_ID) String empid)
			throws EmployeeException {

		int empId = new EmployeeValidator().validateEmployeeId(empid);

		if (!new EmployeeDAOImpl().deleteEmployee(empId)) {
			List<String> errorMessages = new ArrayList<String>();
			errorMessages.add("employee.delete.error");
			throw new EmployeeException(errorMessages);
		}

		return Response.status(Status.OK).entity(Constant.DELETE_SUCCESS)
				.build();
	}
}