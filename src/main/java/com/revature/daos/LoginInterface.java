package com.revature.daos;

import java.util.List;

import com.revature.models.LoginDTO;

public interface LoginInterface {

	public boolean getCredentials(String username, String password);//Return list of Login credentials where user=user and pass=pass 
																		//if true... if false... 
	public String getTitle(String username, String password); //return title of user
}
