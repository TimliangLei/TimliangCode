package user;

public class User {
	private String username;
	private String password;
	private String rem="0";
	public String getRem() {
		return rem;
	}
	public void setRem(String rem) {
		this.rem = rem;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return username + "#" + password + "#" + rem ;
	}
	
}
