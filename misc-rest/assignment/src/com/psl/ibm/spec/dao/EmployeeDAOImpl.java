package com.psl.ibm.spec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.ValidationException;

import com.psl.ibm.spec.bean.Employee;
import com.psl.ibm.spec.bean.Employees;
import com.psl.ibm.spec.dto.DataManager;
import com.psl.ibm.spec.dto.DataManagerImpl;
import com.psl.ibm.spec.exceptions.EmployeeException;
import com.psl.ibm.spec.query.QueryObject;

public class EmployeeDAOImpl {
	public static Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	/**
	 * Method to fetch employee according to specification
	 * 
	 * @param operation
	 * @param orderbyAsc
	 * @param orderbyDesc
	 * @param designation
	 * @param empid
	 * @return
	 * @throws ValidationException
	 * @throws EmployeeException
	 */
	public Employees getEmployees(String orderbyAsc, String orderbyDesc,
			String designation, String name, String id, String empid)
			throws ValidationException, EmployeeException {
		DataManager dm = new DataManagerImpl();

		Employees _employees = new Employees();
		List<Employee> employees = new ArrayList<Employee>();
		try {
			con = dm.getConnection();
			pst = new QueryObject().createPST(orderbyAsc, orderbyDesc,
					designation, name, id, empid);
			rs = pst.executeQuery();
			employees = new QueryObject().convertResultSet(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				dm.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		_employees.setEmployees(employees);

		return _employees;
	}

	/**
	 * Method to create employee
	 * 
	 * @param employee
	 * @return
	 * @throws EmployeeException
	 */

	public String createEmployee(Employee employee) throws EmployeeException {
		DataManager dm = new DataManagerImpl();
		try {
			con = dm.getConnection();
			pst = new QueryObject().createInsertPST(employee);
			int checkstat = pst.executeUpdate();
			if (checkstat > 0)
				return "Employee Created";
			else
				return "Employee could not be Created";

		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			return "This Emp ID already exists";
		} catch (SQLException e) {
			e.printStackTrace();
			return "SQL Error";
		} catch (ClassNotFoundException e) {
			return "Employee could not be created";
		} finally {
			try {
				dm.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Method to update Employee
	 * 
	 * @param employee
	 * @return
	 * @throws EmployeeException
	 */
	public boolean updateEmployee(Employee employee) throws EmployeeException {
		DataManager dm = new DataManagerImpl();
		try {
			con = dm.getConnection();
			pst = new QueryObject().createUpdatePST(employee);
			int checkstat = pst.executeUpdate();
			if (checkstat > 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				dm.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * Method to delete Employee
	 * 
	 * @param empId
	 * @return
	 */
	public boolean deleteEmployee(int empId) {
		DataManager dm = new DataManagerImpl();
		try {
			con = dm.getConnection();
			pst = new QueryObject().createDeletePST(new Integer(empId)
					.toString());

			int checkDel = pst.executeUpdate();

			if (checkDel == 1)
				return true;
			else
				return false;

		} catch (Exception e) {
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
