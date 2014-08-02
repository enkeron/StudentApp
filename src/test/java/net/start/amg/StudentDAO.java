package net.start.amg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataSource;

import org.junit.Test;

import net.start.amg.model.Student;

public class StudentDAO {

	DataSource datasource;
	
	public void initDataSource() {
		
	}
	
	@Test
	public void findByNumber() {
		// TODO Auto-generated method stub
		try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9001", "sa", "") ) {
			System.out.println("HELLO IN CONNECTION");
			
			
			ResultSet rs = connection.createStatement().executeQuery("select * from students");
//			PreparedStatement stm = connection.prepareStatement("select * from students ");

			//			PreparedStatement stm = connection.prepareStatement("select * from students");
//			connection.createStatement().executeQuery("SELECT * from students");
//			stm.setString(456576, "STUDENT_NUMBER");
			
			
			
			
			
//			ResultSet rs = stm.executeQuery();
//			List<String> student = new ArrayList<>();
			
			List<Student> student = new ArrayList<>();
			while(rs.next()) {
				String name = rs.getString("student_name");
				String surname = rs.getString("student_surname");
				String nrAlbumu = rs.getString("student_number");
//				student.add(new Student(name, surname, nrAlbumu, "Lodz", "weeia"));
			}
			System.out.println(student.size());
			for (Student element : student) {
				System.out.println(element.toStringStudent()
							);
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
	}
}
