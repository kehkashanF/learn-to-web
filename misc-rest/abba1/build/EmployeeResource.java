package com.psl.ibm.spec.resources;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.ValidationException;

import com.psl.ibm.spec.bean.AtomLink;
import com.psl.ibm.spec.bean.Designation;
import com.psl.ibm.spec.bean.Employee;
import com.psl.ibm.spec.bean.Employees;
import com.psl.ibm.spec.dao.Constant;
import com.psl.ibm.spec.dao.EmployeeDAOImpl;
import com.psl.ibm.spec.exceptions.EmployeeException;

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
			@QueryParam(Constant.QUERY_PARAM_ID) String id)
			throws ValidationException, EmployeeException {

		employeeFetchParametersValidation(orderByAsc, orderByDesc);

		Employees employees = new EmployeeDAOImpl().getEmployees(orderByAsc,
				orderByDesc, designation, name, id, null);

		for (Employee employee : employees.getEmployees()) {
			UriBuilder selfie = uriInfo.getBaseUriBuilder();
			selfie.path(EmployeeResource.class, "getEmployeeById");
			employee.setSelf(new AtomLink(selfie.build(
					"employees/" + employee.getEmpId()).toString(),
					MediaType.APPLICATION_XML, "self"));
		}

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
			throws EmployeeException, ValidationException {

		int empId = validateEmployeeId(empid);

		List<String> errorMessages = new ArrayList<String>();
		// Employee employee = new EmployeeDAOImpl().getEmployeeById(empId);

		Employees employees = new EmployeeDAOImpl().getEmployees(null, null,
				null, null, null, new Integer(empId).toString());
		if (employees.getEmployees().isEmpty())
			errorMessages.add("No Employee Found");
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
	public Response createEmp(@Valid Employee employee) throws ValidationException,
			EmployeeException {
		List<String> errorMessages = new ArrayList<String>();
		String reply = new EmployeeDAOImpl().createEmployee(employee);
		if (!"Employee Created".equalsIgnoreCase(reply))
			errorMessages.add(reply);
		if (!errorMessages.isEmpty()) {
			throw new EmployeeException(errorMessages);
		}
		return Response.status(201).entity(reply + ": " + employee).build();
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
	@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response updateEmp(@PathParam(Constant.EMPLOYEE_ID) String empid,
			@FormParam(Constant.FORM_PARAM_NAME) String empName,
			@FormParam(Constant.FORM_PARAM_AGE) int empAge,
			@FormParam(Constant.FORM_PARAM_DESIGNATION) String desig)
			throws ValidationException, EmployeeException {

		Designation designation;
		int empId = validateEmployeeId(empid);

		try {
			designation = Designation.valueOf(desig.toUpperCase());
		} catch (IllegalArgumentException e) {
			List<String> error = new ArrayList<String>();
			error.add("Invalid Designation");
			throw new EmployeeException(error);
		}

		employeeCreateValidation(empName, empAge, designation);

		List<String> errorMessages = new ArrayList<String>();
		Employee employee = new Employee(empId, empName, empAge, designation);
		if (!new EmployeeDAOImpl().updateEmployee(employee)) {
			errorMessages.add("Employee could not be updated!");
			throw new EmployeeException(errorMessages);
		}

		return Response.status(Status.OK)
				.entity("Employee Updated: " + employee).build();
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

		int empId = validateEmployeeId(empid);

		if (!new EmployeeDAOImpl().deleteEmployee(empId)) {
			List<String> errorMessages = new ArrayList<String>();
			errorMessages.add("No Employee to Delete");
			throw new EmployeeException(errorMessages);
		}

		return Response.status(Status.OK)
				.entity("Employee Deleted Successfully").build();
	}

	/**
	 * Error checking for query parameters of getAllEmployees()
	 * 
	 * @param orderByAsc
	 * @param orderByDesc
	 * @throws EmployeeException
	 */

	private void employeeFetchParametersValidation(String orderByAsc,
			String orderByDesc) throws EmployeeException {
		List<String> errorMessages = new ArrayList<String>();
		if (!(orderByAsc == null
				|| Constant.SORT_BY_NAME.equalsIgnoreCase(orderByAsc)
				|| Constant.SORT_BY_AGE.equalsIgnoreCase(orderByAsc) || Constant.SORT_BY_ID
					.equalsIgnoreCase(orderByAsc))) {
			errorMessages
					.add("Sorting in ascending order can only be done on age, name or id! \n Check your keywords \n");
		}
		if (!(orderByDesc == null
				|| Constant.SORT_BY_NAME.equalsIgnoreCase(orderByDesc)
				|| Constant.SORT_BY_AGE.equalsIgnoreCase(orderByDesc) || Constant.SORT_BY_ID
					.equalsIgnoreCase(orderByDesc))) {
			errorMessages
					.add("Sorting in descending order can only be done on age, name or id! \n Check your keywords\n");
		}
		if (!errorMessages.isEmpty()) {
			throw new EmployeeException(errorMessages);
		}
	}

	/**
	 * Error checking for form parameters of getAllEmployees()
	 * 
	 * @param empName
	 * @param empAge
	 * @param designation
	 * @throws EmployeeException
	 */
	private void employeeCreateValidation(String empName, int empAge,
			Designation designation) throws EmployeeException {

		List<String> errorMessages = new ArrayList<String>();
		if (empName.isEmpty() || empName == null)
			errorMessages.add("Enter name to update");

		if (empAge == 0)
			errorMessages.add("Enter appropriate age");

		if (empAge < 1 || empAge > 99)
			errorMessages.add("Age not in acceptable range");

		if (designation == null)
			errorMessages.add("Enter designation of Employee");

		if (!errorMessages.isEmpty())
			throw new EmployeeException(errorMessages);
	}

	/**
	 * Method to validate employee Id
	 * 
	 * @param empid
	 * @return
	 * @throws EmployeeException
	 */
	private int validateEmployeeId(String empid) throws EmployeeException {
		int empId;
		try {
			empId = Integer.parseInt(empid);
		} catch (NumberFormatException e) {
			List<String> error = new ArrayList<String>();
			error.add("Employee ID can contain only numbers");
			throw new EmployeeException(error);
		}
		return empId;
	}
}