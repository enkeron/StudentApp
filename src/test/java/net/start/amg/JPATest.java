package net.start.amg;


import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.start.amg.dao.JDAStudentDAO;
import net.start.amg.hibernate.Article;
import net.start.amg.model.Student;

import org.junit.Test;

public class JPATest {

	@Test
	public void test() {
		
		
		EntityManagerFactory factory1 = Persistence.createEntityManagerFactory("testone");
		EntityManagerFactory factory2 = Persistence.createEntityManagerFactory("testone");
		EntityManager manager1 = factory1.createEntityManager();
		EntityManager manager2 = factory2.createEntityManager();
		manager1.getTransaction().begin();
		manager2.getTransaction().begin();
		try {
			Article s = new Article();
			
			s.setAuthor("One");
			s.setContent("one ");
			s.setId(4L);
			s.setTitle("Second Book");
			//manager1.persist(s);
			manager1.flush();
			//manager1.getTransaction().commit();
			Long primaryKey = 4L;
			
			Article art = manager2.find(Article.class, primaryKey);
			System.out.println(art.getAuthor());
			if (art.getAuthor() == null) {
				System.out.println("Art is null");
			}
			
			
//			s.setAuthor("modifire");
//			
//			manager.persist(s);
//			manager.getTransaction().commit();
//			Article s = manager.find(Article.class, 1L);
			
			
			System.out.println("OK");
			System.out.println(s);
			
//			assertNull(s);
			
		} catch(Exception e){
			manager1.getTransaction().rollback();
			manager1.getTransaction().rollback();
		} finally {
			manager1.close();
			manager2.close();
		}
//		manager.createQuery("select * from students");
	}
	
//	@Test
//	public void getAllTest() {
//		JDAStudentDAO jda = new JDAStudentDAO();
//		
//		List<Student> student = jda.getAll();
//		
//		System.out.println(student.size());
//	}
	
	
//	@Test
//	public void getByPeselTest() {
//		Student st = new Student();
//		
//		JDAStudentDAO stDAO = new JDAStudentDAO();
//		
//		String nrAlbumu = "197564";
//		st = stDAO.getByNrAlbumu(nrAlbumu );
//		System.out.println(st.toStringStudent());
//	}

}
