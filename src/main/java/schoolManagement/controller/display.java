package schoolManagement.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import schoolManagement.entity.student;
import schoolManagement.service.studentService;
@WebServlet("/getall")
public class display extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		studentService ss = new studentService();
		List<student> students = ss.getall();
		req.setAttribute("student", students);
		RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
		dispatcher.forward(req, resp);
	}
}
