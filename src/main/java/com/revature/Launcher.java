package com.revature;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.controllers.RequestController;
import com.revature.daos.RequestDao;
import com.revature.models.Request;
//import com.revature.controllers.LoginController;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {
	
	public static void main(String[] args) {
		
		/*try(Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("Hello, connection was successful!!");
		} catch (SQLException e) {
			System.out.println("HEY connection failed :(");
			e.printStackTrace();
		}*/
		RequestDao eDao = new RequestDao();
		List<Request> request = eDao.getAllRequests();
	
		//enhanced for loop to print out the ___ one by one
		for(Request req : request) {
		System.out.println(req);
		}
	}

	
}
