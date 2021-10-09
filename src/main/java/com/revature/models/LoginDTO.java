package com.revature.models;

//Data Transfer Object.
//An HTTP handler will parse a JSON object sent by the user, containing their username and password
//this then gets sent to the controller to get turned into a Java object
//username and password put into the DTO as fields, which will then get checked/validated by the service layer
//You NEVER store a DTO in the database
public class LoginDTO {
	//our LoginDTO models only the username/password of our users
	private String username;
	private String password;
	private String title;
	
	
	//then I just want two constructors so we can instantiate this class when needed
	
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public LoginDTO(String username, String password, String title) {
		super();
		this.username = username;
		this.password = password;
		this.title = title;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginDTO other = (LoginDTO) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoginDTO [username=" + username + ", password=" + password + ", title=" + title + "]";
	}
}
	//and then getters/setters to access our fields
	
	