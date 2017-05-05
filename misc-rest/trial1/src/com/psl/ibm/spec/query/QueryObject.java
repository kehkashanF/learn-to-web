package com.psl.ibm.spec.query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.psl.ibm.spec.bean.Designation;
import com.psl.ibm.spec.bean.Employee;
import com.psl.ibm.spec.dao.Constant;
import com.psl.ibm.spec.dao.EmployeeDAOImpl;
import com.psl.ibm.spec.exceptions.EmployeeException;

public class QueryObject {
	/**
	 * Method to create a select Query
	 * 
	 * @param operation
	 * @param orderbyAsc
	 * @param orderbyDesc
	 * @param filter
	 * @param empid
	 * @return String
	 */
	private String createQuery(String orderbyAsc, String orderbyDesc,
			String designation, String name, String id, String age, String empid) {
		StringBuffer query = new StringBuffer();
		query.append("select * from employees ");
		if (empid != null)
			query.append("WHERE emp_id = ? ");
		else {

			if (designation != null || name != null || id != null
					|| age != null) {
				// filter by designation
				if (designation != null) {
					query.append("WHERE designation LIKE ? ESCAPE '!'");
				}
				// filter by name
				if (name != null) {
					query.append("WHERE emp_name LIKE ? ESCAPE '!'");
				}
				// filter by id
				if (id != null) {
					String filter = id.substring(id.indexOf("~") + 1,
							id.lastIndexOf("~"));
					if (Constant.FILTER_GREATER_THAN.equalsIgnoreCase(filter)) {
						query.append("WHERE emp_id  > ?");
					} else if (Constant.FILTER_LESS_THAN
							.equalsIgnoreCase(filter)) {
						query.append("WHERE emp_id  < ?");
					}

					else if (Constant.FILTER_EQUAL_TO.equalsIgnoreCase(filter)) {
						query.append("WHERE emp_id  = ?");
					}

				}

				// filter by age
				if (age != null) {
					String filter = age.substring(age.indexOf("~") + 1,
							age.lastIndexOf("~"));
					if (Constant.FILTER_GREATER_THAN.equalsIgnoreCase(filter)) {
						query.append("WHERE emp_age  > ?");
					} else if (Constant.FILTER_LESS_THAN
							.equalsIgnoreCase(filter)) {
						query.append("WHERE emp_age  < ?");
					}

					else if (Constant.FILTER_EQUAL_TO.equalsIgnoreCase(filter)) {
						query.append("WHERE emp_age  = ?");
					}

				}
			}

			if (orderbyAsc != null || orderbyDesc != null) {
				query.append(" ORDER BY ");

				if (orderbyAsc != null) {
					query.append("emp_" + orderbyAsc.toLowerCase() + " ASC");
					if (orderbyDesc != null)
						query.append(" , emp_" + orderbyDesc.toLowerCase()
								+ " DESC");
				}
				if (orderbyAsc == null && orderbyDesc != null) {
					query.append("emp_" + orderbyDesc.toLowerCase() + " DESC");
				}

			}

		}
		System.out.println(query.toString());

		return query.toString();
	}

	/**
	 * Method to create PreparedStatement for select query based on
	 * specifications passed
	 * 
	 * @param con
	 * @param operation
	 * @param orderbyAsc
	 * @param orderbyDesc
	 * @param filter
	 * @param empid
	 * @param type
	 * @param employee
	 * @return
	 * @throws EmployeeException
	 */
	public PreparedStatement createPST(String orderbyAsc, String orderbyDesc,
			String designation, String name, String id, String age, String empid)
			throws EmployeeException {

		PreparedStatement pst = null;
		try {
			// fetch by empId
			if (empid != null) {
				pst = EmployeeDAOImpl.con.prepareStatement(createQuery(null,
						null, null, null, null, null, empid));
				pst.setInt(1, Integer.parseInt(empid));
			}
			// sort and filter
			else {
				pst = EmployeeDAOImpl.con.prepareStatement(createQuery(
						orderbyAsc, orderbyDesc, designation, name, id, age,
						null));
				// designation filter
				if (designation != null)
					pst.setString(1, designation.toUpperCase());

				// id filter
				else if (id != null) {
					pst.setInt(1, Integer.parseInt(id.substring(id
							.lastIndexOf("~") + 1)));
				}

				// name filter
				else if (name != null) {
					String filter = name.substring(name.indexOf("~") + 1,
							name.lastIndexOf("~"));
					name = name.substring(name.lastIndexOf("~") + 1);
					name = name.replace("!", "!!").replace("%", "!%")
							.replace("_", "!_").replace("[", "![");

					if (Constant.FILTER_STARTS_WITH.equalsIgnoreCase(filter)) {
						pst.setString(1, name.toUpperCase() + "%");
					} else if (Constant.FILTER_ENDS_WITH
							.equalsIgnoreCase(filter)) {
						pst.setString(1, "%" + name.toUpperCase());
					} else if (Constant.FILTER_CONTAINS
							.equalsIgnoreCase(filter)) {
						pst.setString(1, "%" + name.toUpperCase() + "%");
					} else if (Constant.FILTER_EQUALS.equalsIgnoreCase(filter)) {
						pst.setString(1, name.toUpperCase());
					} else {

					}
				}
				// age filter
				else if (age != null) {
					pst.setInt(1, Integer.parseInt(age.substring(age
							.lastIndexOf("~") + 1)));
					System.out.println(age);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pst;
	}

	/**
	 * Method to create Prepared Statement for creating employee
	 * 
	 * @param employee
	 * @return
	 * @throws EmployeeException
	 */
	public PreparedStatement createInsertPST(Employee employee)
			throws EmployeeException {

		PreparedStatement pst = null;
		String sql = "INSERT into employees (emp_name, emp_age,designation) values (?,?,?)";
		try {
			pst = EmployeeDAOImpl.con.prepareStatement(sql);

			try {
				pst.setString(1, employee.getEmpName().toUpperCase());
				pst.setInt(2, employee.getEmpAge());
			} catch (NullPointerException e) {
				List<String> error = new ArrayList<String>();
				error.add("employee.null.name");
				error.add("employee.null.age");
				throw new EmployeeException(error);
			}
			try {
				pst.setString(3, employee.getDesignation().toString()
						.toUpperCase());
			} catch (NullPointerException e) {
				List<String> error = new ArrayList<String>();
				error.add("employee.wrong.designation");
				throw new EmployeeException(error);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return pst;
	}

	/**
	 * Method to create Prepared Statement for updating employee
	 * 
	 * @param employee
	 * @return
	 * @throws EmployeeException
	 */
	public PreparedStatement createUpdatePST(Employee employee)
			throws EmployeeException {

		PreparedStatement pst = null;
		String sql = "UPDATE employees SET emp_name = ?, emp_age = ?, designation = ? WHERE emp_id = ?";
		try {
			pst = EmployeeDAOImpl.con.prepareStatement(sql);

			pst.setString(1, employee.getEmpName().toUpperCase());
			pst.setInt(2, employee.getEmpAge());
			try {
				pst.setString(3, employee.getDesignation().toString()
						.toUpperCase());
			} catch (NullPointerException e) {
				List<String> error = new ArrayList<String>();
				error.add("employee.wrong.designation");
				throw new EmployeeException(error);
			}
			pst.setInt(4, employee.getEmpId());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return pst;
	}

	/**
	 * Method to create Prepared Statement for deleting employee
	 * 
	 * @param empid
	 * @return
	 */
	public PreparedStatement createDeletePST(String empid) {

		PreparedStatement pst = null;
		String sql = "delete from employees where emp_id= ?";
		try {
			pst = EmployeeDAOImpl.con.prepareStatement(sql);

			pst.setInt(1, Integer.parseInt(empid));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pst;
	}

	/**
	 * Method to convert ResultSet to List of Employees
	 * 
	 * @param rs
	 * @return List<Employee>
	 */
	public List<Employee> convertResultSet(ResultSet rs) {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			while (rs.next()) {
				employees.add(new Employee(rs.getInt(1), rs.getString(2), rs
						.getInt(3), Designation.valueOf(rs.getString(4))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;
	}
}
