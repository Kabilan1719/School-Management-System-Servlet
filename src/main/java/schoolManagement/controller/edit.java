package schoolManagement.controller;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import schoolManagement.entity.student;
import schoolManagement.service.studentService;

@WebServlet("/editstudent")
public class edit extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		studentService ss = new studentService();
		student st = ss.getbyid(id);
		req.setAttribute("student", st);
		RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
		dispatcher.forward(req, resp);
	}
}
