package dls.csb.sdbmrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import dls.csb.sdbmrs.model.StudentBean;


/**
 * Servlet implementation class ListAllRecordsServlet
 */
@WebServlet("/listrecords.action")
public class ListAllRecordsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		// get the ResultsSet from the bean - records
		
		ResultSet records = new StudentBean().getRecords();
		
		//assignment do your reaction paper
		
	}

}
