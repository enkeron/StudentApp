package net.start.amg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.start.amg.model.Student;

import org.apache.log4j.Logger;


public class StudentManager implements IStudentManager, IFacultyManager {
	private static StudentManager INSTANCE = null;
	//private static Logger log = Logger.getLogger(StudentManager.class);
	private static List<Student> studentList = new ArrayList<Student>();
	
	private StudentManager() {
	}
	
	public static StudentManager getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new StudentManager();
		}
		
		return INSTANCE;
	}
	
	public void addStudent(Student newStudent) {
		studentList.add(new Student(newStudent));
	}
	
	public void addStudent(String name, String surname, String nrAlbumu, String adress,
			String faculty) {
		//studentList.add(new Student(name, surname, nrAlbumu, adress, faculty));
	}

	public void removeStudent(String nrAlbumu) {
		Student forRemove = getByNrAlbumu(nrAlbumu);
		if(forRemove != null) {
		//	log.info("Record has been removed");
			studentList.remove(forRemove);
		}
		
	}

	public void editStudent(String nrAlbumu, Student newStudent) {
		Student oldStudent;
		if (newStudent != null) {
			if (newStudent.getNrAlbumu().equalsIgnoreCase(nrAlbumu)) {
				oldStudent = getByNrAlbumu(nrAlbumu);
				studentList.remove(oldStudent);
				studentList.add(newStudent);
			}
		}
	}
	
	public void removeFaculty(String nrAlbumu, String faculty) {
		// TODO Auto-generated method stub
		
	}
	
	public void printStudentList() {
		StringBuilder str;
		if (!studentList.isEmpty()) {
			for (Student element : studentList) {
				str = new StringBuilder();
				str.append("name:").append(element.getName()).append(", surname:")
				.append(element.getSurname()).append(", nrAlbumu:")
				.append(element.getNrAlbumu()).append(", adress:")
				.append(element.getAdress()).append(", id faculty:");
			}
		} else {
		}
	}
	
	public String toStringStudent(Student student) {
		
		StringBuilder str = new StringBuilder();
		str.append("name:").append(student.getName()).append(", surname:")
		.append(student.getSurname()).append(", nrAlbumu:")
		.append(student.getNrAlbumu()).append(", adress:")
		.append(student.getAdress()).append(", id faculty:");
		
		return str.toString();
		
		
	}
	public Student getByNrAlbumu(String nrAlbumu) {
		if (nrAlbumu != null) {
			for (Student element : studentList) {
				if(element.getNrAlbumu().equalsIgnoreCase(nrAlbumu)) {
					return element;
				}
			}
		}
		return null;
	}

	public List<Student> getAll() {
		if(!studentList.isEmpty()) {
			return studentList;
		}
		return null;
	}
}
