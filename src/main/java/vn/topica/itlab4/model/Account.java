package vn.topica.itlab4.model;

//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;

//@Component
//@Scope("session")
public class Account {
	private String username;
	private String password;
	private String email;
	private String fullname;
	private String address;
	private String phone;
	private boolean role;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isRole() {
		return role;
	}
	public void setRole(boolean role) {
		this.role = role;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
//	public Account(String username, String password, String email, String fullname, String address, String phone) {
//		super();
//		this.username = username;
//		this.password = password;
//		this.email = email;
//		this.fullname = fullname;
//		this.address = address;
//		this.phone = phone;
//		this.role=false;
//	}
	public Account(String username, String password, String email, String fullname, String address, String phone,
			boolean role) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.fullname = fullname;
		this.address = address;
		this.phone = phone;
		this.role = role;
	}
	
	
}
