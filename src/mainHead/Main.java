package mainHead;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import BALS.UsersBAL;
import Beans.UsersBean;

@WebServlet("/LogIn")
public class Main extends HttpServlet {
	HttpSession session = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException {
		
		String btn = request.getParameter("update");
		session = request.getSession();
		btnActions(btn, request, response);

		Object email = session.getAttribute("email");
		Object password = session.getAttribute("password");

		empAdmin(email, password, request, response);
	}

	private void btnActions(String btn, HttpServletRequest request, HttpServletResponse response) {

		if (btn != null) {

			if (btn.equalsIgnoreCase("update")) {

				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				String contact = request.getParameter("contact");
				String address = request.getParameter("address");
				String status = request.getParameter("status");
				String role = request.getParameter("role");
				System.out.println(address);
				UsersBean usersBean = new UsersBean(id, name, email, password, contact, address, status, role);
				UsersBAL.update(usersBean);
			} else if (btn.equalsIgnoreCase("logout")) {
				session.invalidate();
				session = request.getSession();
			} else if (btn.equalsIgnoreCase("login")) {
				session.setAttribute("email", request.getParameter("email"));
				session.setAttribute("password", request.getParameter("password"));
			}
		}
	}

	private void empAdmin(Object email, Object password, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (email != null && password != null) {

			UsersBean usersBean = new UsersBean(-1, "", email.toString(), password.toString(), null, null, null, null);
			usersBean = UsersBAL.isAvail(usersBean);

			if (usersBean != null) {

				if (usersBean.getRole().equalsIgnoreCase("employee")) {

					if (usersBean.getStatus().equalsIgnoreCase("Fresh")) {
						request.setAttribute("status", " New");
						
						request.getRequestDispatcher("logInNew.jsp").forward(request, response);
					} else if (usersBean.getStatus().equalsIgnoreCase("Block")) {
						request.setAttribute("status", " Blocked");
						request.getRequestDispatcher("logInNew.jsp").forward(request, response);
					} else if (usersBean.getStatus().equalsIgnoreCase("active")) {
						request.setAttribute("empData", usersBean);
						request.getRequestDispatcher("EmpData.jsp").forward(request, response);
					}
				} else if (usersBean.getRole().equalsIgnoreCase("admin")) {
					if (request.getParameter("profile") != null) {
						if (request.getParameter("profile").equalsIgnoreCase("profile")) {
							request.setAttribute("empData", usersBean);
							request.getRequestDispatcher("EmpData.jsp").forward(request, response);
						}
					} else {
						request.setAttribute("email", usersBean.getEmail());
						request.setAttribute("password", usersBean.getPassword());
						request.setAttribute("active", UsersBAL.getAllEmp("active", "employee"));
						request.setAttribute("block", UsersBAL.getAllEmp("block", "employee"));
						request.setAttribute("fresh", UsersBAL.getAllEmp("fresh", "employee"));
						request.getRequestDispatcher("AdminPortal.jsp").forward(request, response);
					}
				}

			} else {
				request.setAttribute("warning", "Incorrect Email or password");
				request.getRequestDispatcher("LogIn.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect("LogIn.jsp");
		}

	}
}
