package net.start.amg;

import static org.junit.Assert.*;
import net.start.amg.hibernate.Article;

import org.hibernate.Transaction;
import org.junit.Test;
import org.hibernate.*;

public class SessionTest {
	Session session1 = null;
	Transaction tx1 = null;
	Session session2 = null;
	Transaction tx2 = null;
	@Test
	public void test() {
		session1.getSessionFactory().openSession();
		tx1 = session1.beginTransaction();
		

		Article s = new Article();
		
		s.setAuthor("One");
		s.setContent("one ");
		s.setId(4L);
		s.setTitle("Second Book");
		
		Long primaryKey = 4L;

		
		//Article art = tx1.find(Article.class, primaryKey);
//		System.out.println(art.getAuthor());
//		if (art.getAuthor() == null) {
//			System.out.println("Art is null");
//		}
	}

}
