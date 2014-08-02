package net.start.amg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.print.attribute.ResolutionSyntax;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddStudent
 */
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("operation", "Add is susuccessful");
		request.getRequestDispatcher("addstudent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentManager sm = StudentManager.getInstance();
		
		if((request.getParameter("name") == "") || (request.getParameter("nrAlbumu") == "")) {
			doGet(request, response, "Data is not inputed");
			
		} else {
			sm.addStudent(request.getParameter("name"),
					request.getParameter("surname"),
					request.getParameter("nrAlbumu"),
					request.getParameter("adress"), 
					request.getParameter("faculty"));
			doGet(request, response, "Record is successfully added");
		}
		
		
	}

	private void doGet(HttpServletRequest request,
			HttpServletResponse response, String message) throws ServletException, IOException {
		
		request.setAttribute("operation", message);
		request.getRequestDispatcher("addstudent.jsp").forward(request, response);
		
	}
	
	

}