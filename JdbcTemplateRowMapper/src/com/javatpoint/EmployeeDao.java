package com.javatpoint;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDao {
private JdbcTemplate template;

public void setTemplate(JdbcTemplate template) {
	this.template = template;
}

public List<Employee> getAllEmployeesRowMapper(){
	return template.query("select * from employee",new RowMapper<Employee>(){
		@Override
		public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {
			Employee e=new Employee();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setSalary(rs.getInt(3));
			return e;
		}
	});
}

}
