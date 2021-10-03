package com.revature.daos;

import java.util.List;

import com.revature.models.Request;

//these are the things I can do with my "requests" table, in postgres
public interface RequestInterface {
	
	public List<Request> getAllRequests()     ;//retrieve everything in "requests" table
	
	public Request getRequestById(int id)     ;//retrieve data by request_id
	
	public boolean addRequest(Request request);//add a request to the table
	
	public boolean deleteRequest(int id)      ;//delete a request from the table

}
