package com.revature.services;

import com.revature.daos.LoginDao;

public class LoginService {

	LoginDao cDao = new LoginDao();

	public boolean login(String username, String password) {
		return cDao.getCredentials(username, password);
	}
	
	public String getTitle(String username, String password) {
		return cDao.getTitle(username, password);
	}
	
}
/*
	public boolean login(String username, String password) {
		if(username.equals("ben") && password.equals("password")) {
			return true;
		}
		return false;
	}*/