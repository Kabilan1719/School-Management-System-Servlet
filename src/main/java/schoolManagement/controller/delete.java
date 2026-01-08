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

@WebServlet("/deletestudent")
public class delete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		studentService ss = new studentService();
		int res = ss.delete(id);
		if(res!=0)
		{
			List<student> students = ss.getall();
			req.setAttribute("student", students);
			RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
			dispatcher.forward(req, resp);
		}
		else
		{
			resp.getWriter().print("Data not deleted!!");
		}
	}
}
