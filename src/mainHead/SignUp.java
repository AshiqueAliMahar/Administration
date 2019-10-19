package mainHead;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BALS.UsersBAL;
import Beans.UsersBean;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String contact=request.getParameter("contact");
		String address=request.getParameter("address");
		String status=request.getParameter("status");
		String role=request.getParameter("role");
		UsersBean usersBean=new UsersBean(id, name, email, password, contact, address, status, role);
		UsersBAL.insert(usersBean);
		HttpSession session=request.getSession();
		session.setAttribute("email",request.getParameter("email"));
		session.setAttribute("password",request.getParameter("password"));
		new Main().doGet(request, response);
	}

}
