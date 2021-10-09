package com.revature;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.controllers.LoginController;
import com.revature.controllers.RequestController;
import com.revature.controllers.RequestController;
import com.revature.daos.RequestDao;
import com.revature.models.Request;
//import com.revature.controllers.LoginController;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {
	
	public static void main(String[] args) {
		
		RequestController ac = new RequestController();		
		LoginController lc = new LoginController(); 
		
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins(); //allows the server to process JS requests from anywhere
				}
				).start(8090);
		
		//**********************************************************Login Stuff
		app.post("/login", lc.loginHandler);
		app.post("/title", lc.getTitleHandler);
		//***********************************************************Returning Data

		app.get("/requests", ac.getAllRequestsHandler);
		//get request
		app.post("/status_requests", ac.getRequestStatusHandler);
		
		//************************************************************Manipulating
		//post
		app.post("/add_request", ac.addRequestHandler);
		//patch?
		app.patch("/status", ac.updateRequestStatusHandler);
		//get request by username
	}

	
}
