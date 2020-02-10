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

import bean.ManagerInfoBean;
import dao.AddModuleToEmpDao;
import dao.ManagerDetailsDao;

/**
 * Servlet implementation class AddModuleToEmpFwd
 */
@WebServlet("/AddModuleToEmpFwd")
public class AddModuleToEmpFwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddModuleToEmpFwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String endDate = request.getParameter("endDate");
		String projectCode = request.getParameter("projCode");
		String moduleName = request.getParameter("module");
		//System.out.println(" AddModuleToEmpFwd request.getParameter(emp_id) "+request.getParameter("emp_id"));
		String emp_id = request.getParameter("emp_id");
		
		AddModuleToEmpDao a = new AddModuleToEmpDao();
		
		System.out.println(a.insert(moduleName, projectCode, endDate, emp_id));
		
		HttpSession session = request.getSession();
		
		String u = (String)session.getAttribute("loggedInId");
		
		ManagerDetailsDao managerDetail = new ManagerDetailsDao();
		List<ManagerInfoBean> emp = new ArrayList<ManagerInfoBean>();
		emp = managerDetail.managerInfo(u);
		request.setAttribute("emp", emp);
		
		request.getRequestDispatcher("managerPage.jsp").forward(request, response);			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
