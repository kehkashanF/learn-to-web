package com.psl.ibm.spec.dao;

public interface Constant {
	public static final String QUERY_PARAM_ORDERBYASC = "orderbyasc";
	public static final String QUERY_PARAM_ORDERBYDESC = "orderbydesc";
	public static final String QUERY_PARAM_NAME = "name";
	public static final String QUERY_PARAM_DESIGNATION = "designation";
	public static final String QUERY_PARAM_ID = "id";
	public static final String QUERY_PARAM_AGE = "age";

	public static final String SORT_BY_NAME = "name";
	public static final String SORT_BY_AGE = "age";
	public static final String SORT_BY_ID = "id";

	public static final String FILTER_STARTS_WITH = "sw";
	public static final String FILTER_ENDS_WITH = "ew";
	public static final String FILTER_EQUALS = "eq";
	public static final String FILTER_CONTAINS = "ct";

	public static final String FILTER_GREATER_THAN = "gt";
	public static final String FILTER_LESS_THAN = "lt";
	public static final String FILTER_EQUAL_TO = "eq";

	public static final String EMPLOYEE_ID = "empid";

	public static final String FORM_PARAM_NAME = "name";
	public static final String FORM_PARAM_AGE = "age";
	public static final String FORM_PARAM_DESIGNATION = "designation";

	// success messages
	public static final String CREATE_SUCCESS = "Employee Created Successfully";
	public static final String UPDATE_SUCCESS = "Employee Updated: ";
	public static final String DELETE_SUCCESS = "Employee Deleted Successfully";

	public static final String EMPLOYEE_PATH = "employees";
}
