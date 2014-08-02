package net.start.amg;

import static org.junit.Assert.*;

import java.util.ArrayList;

import net.start.amg.model.Adress;
import net.start.amg.model.Student;

import org.junit.Test;

public class NewAdressTest {

	@Test
	public void test() {
		StudentManager sm = StudentManager.getInstance();
		Adress adr = new Adress("lodz", "piotr", "12", "45");
		
		Student st = new Student("Name", "Surnmae", "2342342", adr, "weeia");
		
		sm.addStudent(st);
		
		ArrayList<Student> list = (ArrayList<Student>) sm.getAll();
		
		for (Student element : list) {
			System.out.println(element.getName() + element.getNrAlbumu() + element.getFaculty().getFaculty());
		}
	}

}
