package net.start.amg;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;

import net.start.amg.model.Student;

public interface IStudentManager {
	
	public void addStudent(String name, String surname, String nrAlbumu, String adress, String faculty);
	
	public void removeStudent(String nrAlbumu);
	
	public void editStudent(String nrAlbumu, Student newStudent);
	
	public Student getByNrAlbumu(String nrAlbumu);
	
	public List<Student> getAll();
	
}
