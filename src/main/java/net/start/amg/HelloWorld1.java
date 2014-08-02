package net.start.amg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.start.amg.model.Student;

/**
 * Servlet implementation class HelloWorld1
 */
public class HelloWorld1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<title>OneTwo</title>");
//		out.println("<body>");
//		out.println("<h1>Hi there</h1>");
//		out.println("</body>");
//		out.println("</html>");
//	}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	StudentManager sm = StudentManager.getInstance();
    	sm.addStudent("John", "Kowalski", "183254", "Lodz", "123");
		sm.addStudent("Mariusz", "Lewand", "125423", "Warszawa", "34");
		
		ArrayList<Student> studetns = (ArrayList<Student>) sm.getAll();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		for (Student elements : studetns) {
			out.println(sm.toStringStudent(elements));
			out.println("<br />");
			
		}
		
		
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
