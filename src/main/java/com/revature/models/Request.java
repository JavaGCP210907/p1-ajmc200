package com.revature.models;

public class Request {

	private int request_id; 
	private String request_type;
	private int request_amount;
	private String request_description;
	private String request_status;
	private String username;
	
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Request(int request_id, String request_type, int request_amount, String request_description,
			String request_status) {
		super();
		this.request_id = request_id;
		this.request_type = request_type;
		this.request_amount = request_amount;
		this.request_description = request_description;
		this.request_status = request_status;
	}

	public Request(int request_id, String request_type, int request_amount, String request_description,
			String request_status, String username) {
		super();
		this.request_id = request_id;
		this.request_type = request_type;
		this.request_amount = request_amount;
		this.request_description = request_description;
		this.request_status = request_status;
		this.username = username;
	}
	

	public Request(String request_type, int request_amount, String request_description, String request_status,
			String username) {
		super();
		this.request_type = request_type;
		this.request_amount = request_amount;
		this.request_description = request_description;
		this.request_status = request_status;
		this.username = username;
	}

	public Request(String request_type, int request_amount, String request_description, String username) {
		super();
		this.request_type = request_type;
		this.request_amount = request_amount;
		this.request_description = request_description;
		this.username = username;
	}

	public Request(int request_id, String request_status) {
		super();
		this.request_id = request_id;
		this.request_status = request_status;
	}

	public Request(String request_status) {
		super();
		this.request_status = request_status;
	}

	@Override
	public String toString() {
		return "Request [request_id=" + request_id + ", request_type=" + request_type + ", request_amount="
				+ request_amount + ", request_description=" + request_description + ", request_status=" + request_status
				+ ", username=" + username + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + request_amount;
		result = prime * result + ((request_description == null) ? 0 : request_description.hashCode());
		result = prime * result + request_id;
		result = prime * result + ((request_status == null) ? 0 : request_status.hashCode());
		result = prime * result + ((request_type == null) ? 0 : request_type.hashCode());
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
		Request other = (Request) obj;
		if (request_amount != other.request_amount)
			return false;
		if (request_description == null) {
			if (other.request_description != null)
				return false;
		} else if (!request_description.equals(other.request_description))
			return false;
		if (request_id != other.request_id)
			return false;
		if (request_status == null) {
			if (other.request_status != null)
				return false;
		} else if (!request_status.equals(other.request_status))
			return false;
		if (request_type == null) {
			if (other.request_type != null)
				return false;
		} else if (!request_type.equals(other.request_type))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}

	public String getRequest_type() {
		return request_type;
	}

	public void setRequest_type(String request_type) {
		this.request_type = request_type;
	}

	public int getRequest_amount() {
		return request_amount;
	}

	public void setRequest_amount(int request_amount) {
		this.request_amount = request_amount;
	}

	public String getRequest_description() {
		return request_description;
	}

	public void setRequest_description(String request_description) {
		this.request_description = request_description;
	}

	public String getRequest_status() {
		return request_status;
	}

	public void setRequest_status(String request_status) {
		this.request_status = request_status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	
	
}
