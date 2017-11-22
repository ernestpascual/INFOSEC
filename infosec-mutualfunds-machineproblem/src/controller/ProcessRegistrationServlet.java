package controller;
import model.InvestorsBean;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessRegistrationServlet
 */
@WebServlet("/ProcessRegistrationServlet")
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
				String lastName = request.getParameter("lastName");
				String firstName = request.getParameter("firstName");
				float investAmount = Float.parseFloat(request.getParameter("investAmount"));
				String fundType = request.getParameter("fundType");

				// represent the user data
				InvestorsBean investor = new InvestorsBean();
				investor.setInvestorFirstName(firstName);
				investor.setInvestorLastName(lastName);
				investor.setInvestAmount(investAmount);
				investor.setFundType(fundType);
				
				
				
				// computations
				ComputationsController compute = new ComputationsController();
			
				float navps = compute.navpsValue(fundType);
				float salesLoadAmount = compute.salesLoadAmount(investAmount);
				float netAmount = compute.netAmountInvested(investAmount, salesLoadAmount);
				int fundTypeModifier = compute.fundType(fundType);
				int numberOfShares = compute.computeNumberOfShares(netAmount, fundTypeModifier);
				
				investor.setNavps(navps);
				investor.setSalesLoadAmount(salesLoadAmount);
				investor.setNetAmount(netAmount);
				investor.setTotalShares(numberOfShares);
				
				// insert record
				investor.insertRecord();
				
				request.setAttribute("investor", investor);
				request.getRequestDispatcher("viewinvestorregistration.jsp")
					.forward(request, response);
	}

}
