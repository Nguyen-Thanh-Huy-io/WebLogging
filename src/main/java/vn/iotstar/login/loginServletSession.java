package vn.iotstar.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class loginServletSession
 */
@WebServlet(urlPatterns= {"/doLogin"})
public class loginServletSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServletSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String action = request.getParameter("action");

		    if ("logout".equals(action)) {
		        HttpSession session = request.getSession(false);
		        if (session != null) {
		            session.invalidate();
		        }

		        response.setContentType("text/html;charset=UTF-8");
		        PrintWriter out = response.getWriter();
		        out.println("<!DOCTYPE html>");
		        out.println("<html><head><title>Logout</title></head><body>");
		        out.println("<h3>Bạn đã logout thành công!</h3>");
		        out.println("<a href='Login.html'>Đăng nhập lại</a>");
		        out.println("</body></html>");
		    } else {
		        
		        response.sendRedirect("Login.html");
		    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();

	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        if ("huy".equals(username) && "123".equals(password)) {
	            HttpSession session = request.getSession();
	            session.setAttribute("username", username);

	            out.println("<!DOCTYPE html>");
	            out.println("<html><head><title>Welcome</title></head><body>");
	            out.println("<h2>Xin chào, " + username + "!</h2>");
	            out.println("<form action='doLogin' method='get'>");
	            out.println("<input type='hidden' name='action' value='logout'/>");
	            out.println("<input type='submit' value='Logout'/>");
	            out.println("</form>");
	            out.println("</body></html>");
	        } else {
	            out.println("<!DOCTYPE html>");
	            out.println("<html><head><title>Login Failed</title></head><body>");
	            out.println("<p style='color:red;'>Tài khoản hoặc mật khẩu không chính xác!</p>");
	            out.println("<a href='Login.html'>Quay lại Login</a>");
	            out.println("</body></html>");
	        }
	}
}
