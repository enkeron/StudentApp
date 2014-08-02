package net.start.amg.dao;

import java.util.List;

import net.start.amg.model.Student;

public interface StudentDAO {
	public void addStudent(Student student);
	public void removeStudent(String nrAlbumu);
	public List<Student> getAll();
	public Student getByNrAlbumu(String nrAlbumu);
	public void editStudent(String nrAlbumu, Student student);
	
	
}
