package com.psl.ibm.spec.dao;

import java.util.List;

import com.psl.ibm.spec.bean.Employee;
import com.psl.ibm.spec.bean.Employees;

public interface EmployeeDAO {
	public Employees getAllEmployees();
	public List<Employee> sortedEmployees(List<Employee> employees,
			String orderByAsc, String orderByDesc);
	public List<Employee> filteredEmployees(List<Employee> empList,
			String designation);
	public Employee getEmployeeById(int empId);
	public String createEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(int empId);
}
