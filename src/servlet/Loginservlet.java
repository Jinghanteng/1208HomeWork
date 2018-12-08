package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		System.out.println(name+password);
		UserDao userDao=new UserDao();
		User user=userDao.getInfoByName(name);
		if (user!=null) {
			if (user.getPassword().equals(password)) {
				session.setAttribute("name", name);
				response.sendRedirect("ViewServlet");
			}else {
				response.sendRedirect("login.jsp");
				String msg="√‹¬Î¥ÌŒÛ";
			}
		}else {
			String msg="”√ªß√˚¥ÌŒÛ";
			response.sendRedirect("login.jsp");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
