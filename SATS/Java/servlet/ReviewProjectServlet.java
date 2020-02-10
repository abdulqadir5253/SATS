package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ReviewProjectBean;
import dao.ProjectReviewDao;

/**
 * Servlet implementation class ReviewProjectServlet
 */
@WebServlet("/ReviewProjectServlet")
public class ReviewProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String projectCode = request.getParameter("projectCode");
		ProjectReviewDao review = new ProjectReviewDao();
		List<ReviewProjectBean> info = new ArrayList<ReviewProjectBean>();
		info = review.getInfo(projectCode);
		for(ReviewProjectBean aa: info){
			System.out.println(aa.getEmpid());
		}
		request.setAttribute("info", info);
		request.setAttribute("projectCode", request.getParameter("projectCode"));		
		request.getRequestDispatcher("reviewProject.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
