package org.sf.main;

import org.sf.dao.EmployeeDao;
import org.sf.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HrPayrollSystem {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		EmployeeDao employeeDao = context.getBean("employeeDaoImpl", EmployeeDao.class);
		employeeDao.createEmployee();
		employeeDao.insertEmployee(new Employee(1,"John"));
		employeeDao.insertEmployee(new Employee(2,"Mark"));
		int employees = employeeDao.getEmployeeCount();
		System.out.println("Number of employees: "+employees);
		Employee employee = employeeDao.getEmployeeByid(2);
		System.out.println("Employee 2:"+employee.getName());
		int deleteEmp = employeeDao.deleteEmployeeById(2);
		System.out.println("Delete Employees :"+deleteEmp);

	}

}
