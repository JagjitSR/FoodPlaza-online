package POJO;

public class AdminLogin 
{
	private String password;
	private String userName;



	public AdminLogin()
	{

	}
	public AdminLogin(String password, String userName) {
		super();
		this.password = password;
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "AdminLogin [password=" + password + ", userName=" + userName + "]";
	}

	
	

}
