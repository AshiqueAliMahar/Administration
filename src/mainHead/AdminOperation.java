package mainHead;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BALS.UsersBAL;

@WebServlet("/AdminOperation")
public class AdminOperation extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn=request.getParameter("btnAP");
		int id=Integer.parseInt(request.getParameter("id"));
		if(btn.equalsIgnoreCase("active")) {
			UsersBAL.update(id,"active");
		}else if (btn.equalsIgnoreCase("block")) {
			UsersBAL.update(id,"block");
		}
	new Main().doGet(request, response);
	}
}