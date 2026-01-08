package schoolManagement.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adminlogin")
public class adminLogin extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		String psw = req.getParameter("password");
		String url = "jdbc:postgresql://localhost:5433/school";
		String user = "postgres";
		String password = "123";
		boolean flag = false;
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded");
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection established");
			String sql = "select * from admin where username=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, name);
			ResultSet rs = pstm.executeQuery();
			String getName = null;
			String getPass = null;
			while(rs.next())
			{
				getName = rs.getString(2);
				getPass = rs.getString(4);
			}
			if((name.equals(getName)) && (psw.equals(getPass)))
			{
				flag = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag)
		{
			HttpSession session = req.getSession();
			session.setAttribute("user", name);
			RequestDispatcher dispatch = req.getRequestDispatcher("index.jsp");
			dispatch.forward(req, resp);
		}
		else
		{
			System.out.println("Login Failed");
			resp.getWriter().print("<h1>Invalid Username and Password</h1>");
		}
	}
}
