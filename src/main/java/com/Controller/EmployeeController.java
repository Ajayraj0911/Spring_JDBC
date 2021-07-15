package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Bean.EmployeeBean;
import com.Config.DBConfig;
import com.Dao.EmployeeDao;

public class EmployeeController {

	@Autowired
	static EmployeeDao employeeDao;
	
	public static void main(String[] args) {
		
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DBConfig.class);	
		employeeDao = (EmployeeDao) ctx.getBean("empDao");
		int res = employeeDao.addEmployee();
		
		if(res>0) {
			
			System.out.println("Record inserted...");
		}
		else {
			System.out.println("Record not inserted...");
		}
		
		System.out.println(employeeDao.deleteEmployee(7)+"employee deleted");
		System.out.println(employeeDao.updateEmployee()+"Employee updated");
		
		
		List<EmployeeBean> emplist = employeeDao.employeeList();
		
		for(EmployeeBean emp : emplist) {
			
			System.out.println(emp.geteId()+"-"+emp.geteName()+"-"+emp.geteAge()+"-"+emp.getrName());
		}
		
		//EmployeeBean empBean = employeeDao.getEmployeeBeanByName("ravi");
		//System.out.println(empBean.geteAge());
	}

}
