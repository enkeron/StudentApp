package net.start.amg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import net.start.amg.model.Student;

public class JdbcStudentDAO 	 {
	private static Logger log = Logger.getLogger(JDAStudentDAO.class);
	
	private DataSource dataSource;
	
	

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void addStudent(Student student) {
		String sql = "INSERT INTO students "
				+ "(STUD_ID,STUD_NAME,STUD_SURNAME,STUD_NRALBUM,STUD_PESEL,STUD_ADDRESS,STUD_FACULTY)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setNull(1, java.sql.Types.BIGINT);
			ps.setString(2, student.getName());
			ps.setString(3, student.getSurname());
			ps.setString(4, student.getNrAlbumu());
			ps.setString(5, "");
			ps.setString(6, student.getAdress().getAdress());
			ps.setString(7, student.getFaculty().getFaculty());

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public void removeStudent(String nrAlbumu) {
		String sql = "delete from students where STUD_NRALBUM = ?";
		log.info(log.getClass() + " - Remove from JDBCstudentDAO");
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, nrAlbumu);

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public List<Student> getAll() {
		String sql = "select * from students";
		List<Student> students = new ArrayList<>();
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = conn.createStatement().executeQuery(sql);
			
			while(rs.next()) {
				
//				Student student = new Student(rs.getString("STUD_NAME"), 
//											rs.getString("STUD_SURNAME"), 
//											rs.getString("STUD_NRALBUM"), 
//											rs.getString("STUD_ADDRESS"),
//											rs.getString("STUD_FACULTY"));
//				students.add(student);
			}
			
//			ps.executeUpdate();
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
		return students;
	}
	
	public Student getByNrAlbumu(String nrAlbumu) {
		String sql = "select * from students where STUD_NRALBUM = ?";
		
		Connection conn = null;
		
		Student student = new Student();
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nrAlbumu);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
//				student = new Student(rs.getString("STUD_NAME"),
//						rs.getString("STUD_SURNAME"),
//						rs.getString("STUD_NRALBUM"),
//						rs.getString("STUD_ADDRESS"),
//						rs.getString("STUD_FACULTY"));
//
			}
			rs.close();
			ps.close();
		return student;	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		

	}

	public void editStudent(String nrAlbumu, Student student) {
		String sql = "update students.students set "
				+ "STUD_NAME = ?, STUD_SURNAME = ?, STUD_ADDRESS = ?, STUD_FACULTY = ? "
				+ "where STUD_NRALBUM = ?";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setString(2, student.getSurname());
		
			ps.setString(3, student.getAdress().getAdress());
			ps.setString(4, student.getFaculty().getFaculty());
			
			ps.setString(5, nrAlbumu);
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}

}
