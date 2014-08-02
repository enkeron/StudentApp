package net.start.amg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import net.start.amg.model.Student;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;


@Component
@Transactional
public class JDAStudentDAO implements StudentDAO {
	private boolean loggingFlage = true;
	private static Logger log = Logger.getLogger(JDAStudentDAO.class);
	
	@PersistenceContext
	EntityManager manager;
	
	public JDAStudentDAO() {
	}

	@Override
	public void addStudent(Student student) {
		try {
			
			manager.persist(student);
			if(loggingFlage ) {
				log.info("add student" + student.toStringStudent());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void removeStudent(String nrAlbumu) {
		log.info(log.getClass() + " Remove from JDAstudentDAO");
		try {
			Query query = manager.createQuery("delete Student s where s.nrAlbumu = :nrAlbumu");
			query.setParameter("nrAlbumu", nrAlbumu);
			query.executeUpdate();
			
			if(loggingFlage ) {
				log.info("Remove student");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}

	}

	@Override
	public List<Student> getAll() {
		List<Student> students = null;
		try {
			Query query = manager.createQuery("from Student");
			students = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return students;
	}

	@Override	
	public Student getByNrAlbumu(String nrAlbumu) {
		Student findStudent = new Student();
		try {
			Query query = manager.createQuery("from Student s where s.nrAlbumu = :nrAlbumu");
			query.setParameter("nrAlbumu", nrAlbumu);
			
			List<Student> findStudents = query.getResultList();
			if(!findStudents.isEmpty()) {
				findStudent = findStudents.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return findStudent;
	}

	@Override
	public void editStudent(String nrAlbumu, Student student) {
		try {
			Student studentForEdit = getByNrAlbumu(nrAlbumu);
			studentForEdit.setStudent(student);
//			manager.merge(studentForEdit);
			
			if (loggingFlage) {
				log.info("Old student" + studentForEdit.toStringStudent());
				log.info("New student" + student.toStringStudent());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
