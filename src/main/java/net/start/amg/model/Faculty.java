package net.start.amg.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class Faculty {
	@Column(name="STUD_FACULTY")
	@NotEmpty
	private String faculty;
	
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public void addFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getFaculty() {
		return faculty;
	}
	
	public Faculty() {
	}
	
	public Faculty(String faculty) {
		this.faculty = faculty;
	}
}
