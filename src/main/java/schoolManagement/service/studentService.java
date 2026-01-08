package schoolManagement.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import schoolManagement.entity.student;

public class studentService {
	private static Connection con;
	private static String url = "jdbc:postgresql://localhost:5433/school";
	private static String user = "postgres";
	private static String password = "123";
	static {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url,user,password);
			System.out.println("Connected");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int save(student st)
	{
		int res = 0;
		String sql = "Insert into student values(?,?,?)";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, st.getId());
			pstm.setString(2, st.getName());
			pstm.setInt(3,st.getAge());
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public List<student> getall()
	{
		List<student> st = new ArrayList<student>();
		String sql = "select * from student order by id asc";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next())
			{
				st.add(new student(rs.getInt(1),rs.getString(2),rs.getInt(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}
	public List<student> sortbyname()
	{
		List<student> st = new ArrayList<student>();
		String sql = "select * from student order by name asc";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next())
			{
				st.add(new student(rs.getInt(1),rs.getString(2),rs.getInt(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}
	public List<student> sortbyage()
	{
		List<student> st = new ArrayList<student>();
		String sql = "select * from student order by age asc";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next())
			{
				st.add(new student(rs.getInt(1),rs.getString(2),rs.getInt(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}
	public student getbyid(int id) {
		student st = null;
		String sql = "select * from student where id=?";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if(rs.next())
			{
				st = new student(rs.getInt(1),rs.getString(2),rs.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}
	public int update(student st)
	{
		String sql = "update student set name=?, age=? where id=?";
		int res = 0;
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(3, st.getId());
			pstm.setString(1, st.getName());
			pstm.setInt(2, st.getAge());
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public int delete(int id)
	{
		String sql = "delete from student where id = ?";
		int res = 0;
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
}
