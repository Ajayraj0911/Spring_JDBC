package com.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.Bean.EmployeeBean;

@Repository("empDao")
public class EmployeeDao {

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int addEmployee() {
		
		String name = "ravi";
		
		return jdbcTemplate.update("insert into employee(ename,eage)values(?,?)",name,19);
		
	}
	public int deleteEmployee(int id) {
		
		return jdbcTemplate.update("delete from employee where eid="+id+"");
	}
	public int updateEmployee() {
		
		String name = "Ajay";
		return jdbcTemplate.update("update employee set ename=? where eid=?",name,5);
	}
	
	
	private final static class Employeemapper implements RowMapper<EmployeeBean>{

		@Override
		public EmployeeBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.seteId(rs.getInt("eid"));
			employeeBean.seteName(rs.getString("ename"));
			employeeBean.seteAge(rs.getString("eage"));
			employeeBean.setrId(rs.getInt("rid"));
			employeeBean.setrName(rs.getString("rname"));
			return employeeBean;
			
			
		}				
	}

	public List<EmployeeBean> getAllEmployees(){
		
		return jdbcTemplate.query("select * from employee", new ResultSetExtractor<List<EmployeeBean>>() {

			public List<EmployeeBean> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				
				List<EmployeeBean> list = new ArrayList<EmployeeBean>();
				while(rs.next()) {
					
					EmployeeBean employeeBean = new EmployeeBean();
					employeeBean.seteId(rs.getInt("eid"));
					employeeBean.seteName(rs.getString("ename"));
					employeeBean.seteAge(rs.getString("eage"));
					list.add(employeeBean);
				}
				return list;
			}
			
			
		});
		
	}
	
	public EmployeeBean getEmployeeBeanByName(String name) {
		
		return jdbcTemplate.queryForObject("select * from employee where ename ='" + name + "'", new Employeemapper());
	}

	public List<EmployeeBean> employeeList() {
		
		return jdbcTemplate.query("select * from employee natural join role",new Employeemapper());
	}

}
