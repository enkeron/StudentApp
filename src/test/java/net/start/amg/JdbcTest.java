package net.start.amg;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import net.start.amg.model.Student;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JdbcTest extends Exception {
	
	//@Autowired
	private DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	
	StudentDAO dao;
	
	@Test
	public void testName() throws Exception {
//		dao = new StudentDAO();
//		
//		dao.findByNumber();

		Student newOne = testJDBC("1");
		System.out.println(newOne.toStringStudent());
	}
		

	public Student testJDBC(String indexNo) {
		return new JdbcTemplate(dataSource).queryForObject(
				"select * from student where index_no=?",
				new RowMapper<Student>() {

					@Override
					public Student mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						return new Student(rs.getString("student_id"), rs.getString("student_name"));
						
					}
					
					
				});
		
		
	}
}
