package org.sf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.sf.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void createEmployee() {
		jdbcTemplate.execute("create table employee(id int, name varchar(250));");

	}

	@Override
	public Employee getEmployeeByid(int id) {
		String query = "select * from employee where id = ?";
		Employee employee = jdbcTemplate.queryForObject(query, new Object[]{id},
				new RowMapper<Employee>(){
			
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException{
				Employee employee = new Employee(rs.getInt("id"), rs.getString("name"));
				return employee;
			}
			});
		return employee;
	}

	@Override
	public int insertEmployee(Employee employee) {
		String insertQuery = "insert into employee(id, name) values(?,?)";
		//values to insert
		Object[] params = new Object[]{
				employee.getId(),
				employee.getName()
		};
		//kind of values to insert
		int[] types = new int[]{
				Types.INTEGER, Types.VARCHAR
		};
		
		return jdbcTemplate.update(insertQuery,params,types);

	}
	
	@Override
	public int deleteEmployeeById(int id){
		String deleteQuery = "delete from employee where id = ?";
		return jdbcTemplate.update(deleteQuery, new Object[]{id});
	}
	

	@Override
	public int getEmployeeCount(){
		String sql = "select count(*) from employee";
		//return jdbcTemplate.queryForInt(sql); //original
		return jdbcTemplate.queryForObject(sql,Integer.class);
	};

}
