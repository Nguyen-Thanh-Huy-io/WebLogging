package vn.iostar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iostar.model.User;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HomeController
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns="/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();

	    HttpSession session = request.getSession(false);
	    if (session != null && session.getAttribute("account") != null) {
	        User user = (User) session.getAttribute("account");
	        out.println("<h1>Chào mừng " + user.getUserName() + "!</h1>");
	    } else {
	        out.println("<h1>Bạn chưa đăng nhập!</h1>");
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
