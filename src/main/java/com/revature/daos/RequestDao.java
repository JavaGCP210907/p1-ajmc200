package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Request;
import com.revature.utils.ConnectionUtil;

public class RequestDao implements RequestInterface {

	//HomeDao hDao = new HomeDao(); //so we can use the HomeDao methods
	
	@Override
	public List<Request> getAllRequests() {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM requests"; //write out out SQL query
			
			Statement s = conn.createStatement(); //create a Statement object to execute our query
			
			ResultSet rs = s.executeQuery(sql); //put the results of the query into a ResultSet (execute the query into it)
			
			List<Request> requestList = new ArrayList<>(); //empty ArrayList of Avengers
			
			//populate the ArrayList
			while(rs.next()) { //while there are still objects in the resultset
				
				//make a new Avenger object for each row
				Request a = new Request (
					rs.getInt("request_id"),
					rs.getString("request_type"),
					rs.getInt("request_amount"),
					rs.getString("request_description"),
					rs.getString("request_status")
					//null //there is no JDBC method for getHome() right? We'll add it below... JDBC can be clunky	
				);
				/*
				//if the Avenger DOES have a home...
				if(rs.getString("home_fk") != null) {
					
					//use the setHome_fk method of Avenger to set it equal to the appropriate Home object
					//We need to use a DAO method to get a Home by its name... 
					//the getHomeByName method gets its parameter from the home_fk column from the SQL query above
					a.setHome_fk(hDao.getHomeByName(rs.getString("home_fk")));
					
					//now our Avenger object is fully initialized!
				}
				*/
				//now we can add each new Avenger into the ArrayList
				requestList.add(a);
			}
			
			//outside our while loop, once all avengers have been added, return the avengerList
			return requestList;
			
		} catch (SQLException e) {
			System.out.println("Get all requests failed :(");
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	//leaving these unimplemented (to focus more on frontend-backend communication)
	//you can always look at P0demo for similar implementations of this 
	
	@Override
	public Request getRequestById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addRequest(Request avenger) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRequest(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
