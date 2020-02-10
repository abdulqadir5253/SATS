package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.EmployeeInfoBean;
import dao.EmpSubmitModuleDao;
import dao.EmployeeDetailDao;

/**
 * Servlet implementation class SubmitModuleServlet
 */
@WebServlet("/SubmitModuleServlet")
public class SubmitModuleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitModuleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		HttpSession session = request.getSession(false);
		String ui = (String) session.getAttribute("loggedInId");
		String moduleName = (String) request.getParameter("moduleName");
		
		// Set values of the sumitted modules
		EmpSubmitModuleDao submit = new EmpSubmitModuleDao();		
		submit.insertValue(ui, moduleName);		
		// Jsp display code
		List<EmployeeInfoBean> emps = new ArrayList<EmployeeInfoBean>();		
		EmployeeDetailDao a = new EmployeeDetailDao();		
		emps = a.employeeDetail(ui);				
		request.setAttribute("emps", emps);
		request.getRequestDispatcher("EmployeePage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
