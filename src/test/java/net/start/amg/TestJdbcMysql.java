package net.start.amg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.start.amg.dao.*;
import net.start.amg.model.Student;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJdbcMysql {
	
	@Test
	public void testRun() {
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/students", "root", "root")) {
			System.out.println("HELLO IN CONNECTION");
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOwn() {
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("applicationContext.xml");
	        
			net.start.amg.dao.StudentDAO studentDao = (net.start.amg.dao.StudentDAO) context.getBean("studentDAO");
//			studentDao.addStudent(new Student("John", "One", "183254", "Lodz", "123"));
			
			
//	        Customer customer1 = customerDAO.findByCustomerId(1);
//	        System.out.println(customer1);
	 
	}
	
	

}
