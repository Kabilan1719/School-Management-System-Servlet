package schoolManagement.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import schoolManagement.entity.admin;

public class adminService {
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
	public int save(admin st)
	{
		int res = 0;
		String sql = "Insert into admin values(?,?,?,?,?)";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, st.getId());
			pstm.setString(2, st.getUsername());
			pstm.setString(3,st.getEmail());
			pstm.setString(4, st.getPassword());
			pstm.setString(5, st.getConfirmpsw());
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
}
