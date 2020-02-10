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
import bean.ManagerInfoBean;
import dao.EmployeeDetailDao;
import dao.LoginDao;
import dao.ManagerDetailsDao;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    

    
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginDao login = new LoginDao();

		String checkUser = login.hi(request.getParameter("un"), request.getParameter("pw"));
		
		if(checkUser.equals("manager")){
			
			HttpSession session = request.getSession();
			
			session.setAttribute("loggedInId", request.getParameter("un"));
			
			ManagerDetailsDao managerDetail = new ManagerDetailsDao();
			List<ManagerInfoBean> emp = new ArrayList<ManagerInfoBean>();
			emp = managerDetail.managerInfo(request.getParameter("un"));
			request.setAttribute("emp", emp);							
//			for(ManagerInfoBean m:emp){
//				System.out.println(m.getProjName()+" "+m.getStatus());
//			}
			
			request.getRequestDispatcher("managerPage.jsp").forward(request, response);
		}
		else if(checkUser.equals("employee")){
			//Get all the modules of the Employee
			HttpSession session = request.getSession();			
			session.setAttribute("loggedInId", request.getParameter("un"));
			
			List<EmployeeInfoBean> emps = new ArrayList<EmployeeInfoBean>();
			
			EmployeeDetailDao a = new EmployeeDetailDao();
			
			emps = a.employeeDetail(request.getParameter("un"));
			System.out.println(request.getParameter("un"));
			request.setAttribute("loggedId", request.getParameter("un"));
			request.setAttribute("emps", emps);
			// 
			
			
			request.getRequestDispatcher("EmployeePage.jsp").forward(request, response);
		}
			
		else if(checkUser.equals("userId"))
			response.sendRedirect("ErrorPage.jsp");
		else
			response.sendRedirect("ErrorPage.jsp");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
