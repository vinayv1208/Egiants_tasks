package com.javatpoint;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeDao dao=(EmployeeDao)ctx.getBean("edao");
		List<Employee> list=dao.getAllEmployeesRowMapper();
		
		for(Employee e:list)
			System.out.println(e);
	}
}
