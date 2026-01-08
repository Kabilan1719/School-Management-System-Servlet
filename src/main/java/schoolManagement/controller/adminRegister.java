package schoolManagement.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import schoolManagement.entity.admin;
import schoolManagement.service.adminService;

@WebServlet("/adminregister")
public class adminRegister extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String user = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String confrmpsw = req.getParameter("confirmpassword");
		admin ad = new admin();
		ad.setId(id);
		ad.setUsername(user);
		ad.setEmail(email);
		ad.setPassword(password);
		ad.setConfirmpsw(confrmpsw);
		adminService as = new adminService();
		int res = as.save(ad);
		if(res!=0)
		{
			RequestDispatcher dispatcher = req.getRequestDispatcher("adminLogin.jsp");
			dispatcher.forward(req, resp);
		}
		else
		{
			resp.getWriter().print("Data not Saved!!");
			RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
