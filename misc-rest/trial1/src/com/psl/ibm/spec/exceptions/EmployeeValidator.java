package com.psl.ibm.spec.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.psl.ibm.spec.dao.Constant;

public class EmployeeValidator {

	/**
	 * Error checking for query parameters of getAllEmployees()
	 * 
	 * @param orderByAsc
	 * @param orderByDesc
	 * @throws EmployeeException
	 */
	public void employeeFetchParametersValidation(String orderByAsc,
			String orderByDesc) throws EmployeeException {
		List<String> errorMessages = new ArrayList<String>();
		if (!(orderByAsc == null
				|| Constant.SORT_BY_NAME.equalsIgnoreCase(orderByAsc)
				|| Constant.SORT_BY_AGE.equalsIgnoreCase(orderByAsc) || Constant.SORT_BY_ID
					.equalsIgnoreCase(orderByAsc))) {
			errorMessages.add("ascending.sort.order");
		}
		if (!(orderByDesc == null
				|| Constant.SORT_BY_NAME.equalsIgnoreCase(orderByDesc)
				|| Constant.SORT_BY_AGE.equalsIgnoreCase(orderByDesc) || Constant.SORT_BY_ID
					.equalsIgnoreCase(orderByDesc))) {
			errorMessages.add("descending.sort.order");
		}
		if (!errorMessages.isEmpty()) {
			throw new EmployeeException(errorMessages);
		}
	}

	/**
	 * Method to validate employee Id
	 * 
	 * @param empid
	 * @return
	 * @throws EmployeeException
	 */
	public int validateEmployeeId(String empid) throws EmployeeException {
		int empId;
		try {
			empId = Integer.parseInt(empid);
		} catch (NumberFormatException e) {
			List<String> error = new ArrayList<String>();
			error.add("employee.wrong.id");
			throw new EmployeeException(error);
		}
		return empId;
	}
}
