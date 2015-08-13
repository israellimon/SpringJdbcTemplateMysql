package org.sf.dao;

import org.sf.model.Employee;

public interface EmployeeDao {
	
	public void createEmployee();
	public Employee getEmployeeByid(int id);
	public int insertEmployee(Employee employee);
	public int deleteEmployeeById(int id);
	public int getEmployeeCount();

}
