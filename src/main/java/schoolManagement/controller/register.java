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
@WebServlet("/register")
public class register extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		student st = new student();
		st.setId(id);
		st.setName(name);
		st.setAge(age);
		studentService ss = new studentService();
		int res = ss.save(st);
		if(res!=0)
		{
			RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
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
