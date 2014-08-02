package net.start.amg.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import net.start.amg.dao.StudentDAO;
import net.start.amg.model.Student;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import amg.net.HomeController;


@RestController
public class RestOneController {
	
	private static Logger log = Logger.getLogger(HomeController.class);
	@Autowired
	StudentDAO studentDAO;
		
	@Autowired
	ApplicationContext context;
	
	public RestOneController() {
	}
	
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET, produces={"application/json"})
	public Student getPersonDetail(@PathVariable("id") String id) {
		Student st = studentDAO.getByNrAlbumu(id);
		log.info(st.toStringStudent());
		return st;
	}
	
	@RequestMapping(value = "/addstudent", method = RequestMethod.POST, consumes = "application/json")
	public ModelAndView addStudent(@RequestBody Student student) {
		studentDAO.addStudent(student);
		return new ModelAndView("personXmlView", BindingResult.MODEL_KEY_PREFIX
                + "person", student);
		//return student;
	}
	
	@RequestMapping(value = "/home")
    public String home(Model m) {
		m.addAttribute("student", new Student());
		return "addstudent";
    }
	
	@RequestMapping(value = "/print", method = RequestMethod.GET)
    public String printStudentList(HttpServletRequest request, HttpServletResponse response) {
		List<Student> students = studentDAO.getAll();
		request.setAttribute("students", students);
		return "printStudentList";
    }
	
	@RequestMapping(value = "/addOne", method = RequestMethod.GET)
    public String showForm(ModelMap model) {
		model.addAttribute("student", new Student());
		
		return "addstudent";
    }
	
	@RequestMapping(value = "/addOne", method = RequestMethod.POST)
	protected String addNewStudent(@ModelAttribute("student") @Valid Student student, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("student", student);
		} else {
			studentDAO.addStudent(student);
			
			
			
			
//			log.error(student.toStringStudent());
//			sm.addStudent(student.getName(), student.getSurname(),
//					student.getNrAlbumu(), student.getAdress().getAdress(),
//					student.getFaculty().getFaculty());
			model.addAttribute("message", "Student has been added");
			model.addAttribute("student", new Student());
			
		}
		return "addstudent";
	}
	
	@RequestMapping(value = "/remove", method=RequestMethod.GET)
	protected String remove() {
		return "deletestudent";
	}
	
	@RequestMapping(value = "/remove", method=RequestMethod.POST)
	protected String search(HttpServletRequest request, HttpServletResponse response) {
		
		studentDAO.removeStudent(request.getParameter("nrAlbumu"));
		request.setAttribute("message", "Record has been removed!");
		
		
//		Student student = sm.getByNrAlbumu(request.getParameter("nrAlbumu"));
//		if(student != null) {
//			sm.removeStudent(request.getParameter("nrAlbumu"));
//			request.setAttribute("student", student);
//		} else {
//			request.setAttribute("message", "Havn't current NumberAlbum");
//		}
		
		return "deletestudent";
		
	}
	@RequestMapping(value = "/edit", method=RequestMethod.GET)
	protected String loadEditForm(Model m, @ModelAttribute Student student) {
		
		return "editstudent";
	}
	
	@RequestMapping(value = "/edit", method=RequestMethod.POST)
	protected String editStudent(Model m, @ModelAttribute Student student) {
		
		studentDAO.editStudent(student.getNrAlbumu(), student);
		m.addAttribute("student", new Student());
		m.addAttribute("editmessage", "Record has been changed");
		
		
		return "editstudent";
	}
	
	@RequestMapping(value = "/search", method=RequestMethod.POST)
	protected String search(HttpServletRequest request, Model model) {
		String nrAlbumu = request.getParameter("nrAlbumu");

		Student student = studentDAO.getByNrAlbumu(nrAlbumu);
		
		model.addAttribute("student", student);
		
		return "editstudent";
	}
}
