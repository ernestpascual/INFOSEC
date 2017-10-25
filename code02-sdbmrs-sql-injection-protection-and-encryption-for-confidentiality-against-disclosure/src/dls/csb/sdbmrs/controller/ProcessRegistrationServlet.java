package dls.csb.sdbmrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dls.csb.sdbmrs.model.StudentBean;
/**
 * Servlet implementation class ProcessRegistrationServlet
 */
@WebServlet("/processregistration.action")
public class ProcessRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// retrieve all parameter values from the form
		String studentId = request.getParameter("studentId");
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		int yearLevel = Integer.parseInt(request.getParameter("yearLevel"));
		String course = request.getParameter("course");

		// now we need to create JavaBean that will represent the user data
		StudentBean student = new StudentBean();
		student.setStudentId(studentId);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setYearLevel(yearLevel);
		student.setCourse(course);
		
		// save the student object to database
		student.insertRecord();
		
		// perform object binding on request
		request.setAttribute("student", student);
		
		request.getRequestDispatcher("viewstudentregistered.jsp")
			.forward(request, response);
		
		
	}

}
