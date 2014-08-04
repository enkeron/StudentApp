package net.start.amg.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="STUD_NAME")
	@NotEmpty
	@Length(min=4, max=10, message = "Must be 10 characters.")
	private String name;
	
	@Column(name="STUD_SURNAME")
	@NotEmpty(message = "Surname should not be null")
	private String surname;
	
	@Column(name="STUD_NRALBUM")
	@NotEmpty(message = "nrAlbumu should not be null")
	private String nrAlbumu;
	
	
	@NotNull(message = " should not be null")
	@OneToOne(cascade = CascadeType.ALL)
	private Adress adress;
	
	@Column(name="STUD_PESEL")
	private String pesel = "";
	
	@NotNull(message = "Username should not be null")
	private Faculty faculty;
	
	//@Version
	//private Data ts;
	
//	List<Faculty> facultyList = new ArrayList<Faculty>();
	
	public Student(String nrAlbumu, String name) {
		this.name = name;
		this.nrAlbumu = nrAlbumu;
	}
	
//	public Student(String name, String surname, String nrAlbumu, String adress, String faculty) {
//		this.name = name;
//		this.surname = surname;
//		this.nrAlbumu = nrAlbumu;
//		this.adress = new Adress(adress);
//		this.faculty = new Faculty(faculty);
//		
//		
//	}
	
	
	public Student(Student newStudent) {
		this.name = newStudent.getName();
		this.surname = newStudent.getSurname();
		this.nrAlbumu = newStudent.getNrAlbumu();
		this.adress = new Adress(newStudent.getAdress());
		this.faculty = new Faculty(newStudent.getFaculty().getFaculty());
	}
	
	public void setStudent(Student newStudent) {
		this.name = newStudent.getName();
		this.surname = newStudent.getSurname();
		this.nrAlbumu = newStudent.getNrAlbumu();
		this.adress.setAdress(newStudent.getAdress());
		this.faculty = newStudent.getFaculty();
	}
	
	public Student(String name, String surname, String nrAlbumu, Adress address, String faculty) {
		this.name = name;
		this.surname = surname;
		this.nrAlbumu = nrAlbumu;
		this.adress = new Adress(address);
		this.faculty = new Faculty(faculty);
		System.out.println("In constructor" + faculty);
	}
	
	public Student() {
	}
	@NotNull(message = " should not be null")
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	@NotNull(message = " should not be null")
	public Adress getAdress() {
		return adress;
	}

	public Faculty getFaculty() {
		return faculty;
	}
	
//	public List<Faculty> getFaculty() {
//		return facultyList;
//	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getNrAlbumu() {
		return nrAlbumu;
	}
	
//	public void addFaculty(String fac) {
//		facultyList.add(new Faculty(fac));
//	}
	
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setNrAlbumu(String nrAlbumu) {
		this.nrAlbumu = nrAlbumu;
	}
	
//	public ArrayList<Faculty> getFaculties() {
//		return (ArrayList<Faculty>) facultyList;
//	}

	public String toStringStudent() {

		StringBuilder str = new StringBuilder();
		str.append("name:").append(name).append(", surname:")
				.append(surname).append(", nrAlbumu:")
				.append(nrAlbumu).append(", adress:")
				.append(adress.getAdress()).append(", faculty:")
				.append(faculty.getFaculty());
			
//		for (Faculty faculty : getFaculties()) {
//			str.append(faculty.getFaculty() + " ");
//		}
// 
		return str.toString();

	}
	@Override
	public String toString() {
		
		return super.toString();
	}
	
}
