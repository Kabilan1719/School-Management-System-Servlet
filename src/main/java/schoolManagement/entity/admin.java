package schoolManagement.entity;

public class admin {
	private int id;
	private String username;
	private String email;
	private String password;
	private String confirmpsw;
	
	public admin(int id, String username, String email, String password, String confirmpsw) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirmpsw = confirmpsw;
	}
	public admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpsw() {
		return confirmpsw;
	}
	public void setConfirmpsw(String confirmpsw) {
		this.confirmpsw = confirmpsw;
	}

	
}
