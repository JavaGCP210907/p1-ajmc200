package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
			ResultSet rs = s.executeQuery(sql);  //put the results of the query into a ResultSet (execute the query into it)			
			List<Request> requestList = new ArrayList<>(); //empty ArrayList of Avengers
			//populate the ArrayList
			while(rs.next()) { //while there are still objects in the resultset
				//make a new Avenger object for each row
				Request a = new Request (
					rs.getInt("request_id"),
					rs.getString("request_type"),
					rs.getInt("request_amount"),
					rs.getString("request_description"),
					rs.getString("request_status"),
					rs.getString("username")
					//null //there is no JDBC method for getHome() right? We'll add it below... JDBC can be clunky	
				);
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
	public List<Request> getRequestPending(String status) {
			
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			ResultSet rs = null;
			String sql = "select * from requests where request_status = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, status); // 1 is referring to first parameter (?) 
			rs = ps.executeQuery();
			
			//create an empty List to be filled with the data from the database
			List<Request> requestList = new ArrayList<>();
			
			while(rs.next()) { //while there are results in the result set...
				
			Request e = new Request(
					//we want to use rs.getXYZ for each column in the record
					rs.getInt("request_id"),
					rs.getString("request_type"),
					rs.getInt("request_amount"),
					rs.getString("request_description"),
					rs.getString("request_status"),
					rs.getString("username")
					);
			requestList.add(e); //e is the new request object we created above
			}
			
			return requestList;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong with your database!"); 
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addRequest(Request request) {
		try(Connection conn = ConnectionUtil.getConnection()){

			//you can line break a sql statement in Java by concatenation (not the +)
			String sql = "insert into requests (request_type, request_amount, request_description, request_status, username)" +
						 "values (?, ?, ?, ?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, request.getRequest_type());
			ps.setInt(2, request.getRequest_amount());
			ps.setString(3, request.getRequest_description());
			ps.setString(4, request.getRequest_status());
			ps.setString(5, request.getUsername());
			
			ps.executeUpdate(); //for anything that is NOT a SELECT statement, we use executeUpdate();
			
			//send confirmation to the console if successful
			//System.out.println("Employee " + request.getRequest_id() + " created. Welcome aboard!");
			
		} catch (SQLException e) {
			System.out.println("add request failed :(");
			e.printStackTrace();
		}
		//return true;
	}
/*
	@Override
	public boolean deleteRequest(int id) {
		// TODO Auto-generated method stub
		return false;
	}
*/	
	@Override
	public void updateRequestStatus(int id, String status) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "update requests set request_status = ? where request_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, status);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			
			//System.out.println(roleTitle + " salary has been updated to: " + salary);
			
		} catch (SQLException e) {
			System.out.println("You can't update salaries in this economy!!!");
			e.printStackTrace();
		}
	}

}
