package vn.iotstar.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet(urlPatterns= {"/login"})
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter printwriter = resp.getWriter();
		printwriter.println("Lỗi đăng nhập");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		if(user.equals("huy") && pass.equals("123"))
		{
		Cookie cookie = new Cookie("username", user); 
		cookie.setMaxAge(30);
		resp.addCookie(cookie);
		resp.sendRedirect("/Helloworld/hello");
		}else {
		resp.sendRedirect("/Helloworld/login");
		}
	}

}
