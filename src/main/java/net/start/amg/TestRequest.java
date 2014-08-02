package net.start.amg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.start.amg.model.Student;

/**
 * Servlet implementation class TestRequest
 */
public class TestRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		StudentManager sm = new StudentManager();
//    	sm.addStudent("John", "Kowalski", "183254", "Lodz", "123");
//		sm.addStudent("Mariusz", "Lewand", "125423", "Warszawa", "34");
//		
//		ArrayList<Student> studetns = (ArrayList<Student>) sm.getAll();
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println(studetns.get(0).getName());
//		out.println("hhelloo");
//		
		StudentManager sm = StudentManager.getInstance();
    	sm.addStudent("John", "Kowalski", "183254", "Lodz", "123");
		sm.addStudent("Mariusz", "Lewand", "125423", "Warszawa", "34");
		
		
		ArrayList<Student> students = (ArrayList<Student>) sm.getAll();
//		students.get(0).addFaculty("35");
//		students.get(0).addFaculty("36");
		request.setAttribute("students", students);
		RequestDispatcher disp = request.getRequestDispatcher("testForRequest.jsp");
		disp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}