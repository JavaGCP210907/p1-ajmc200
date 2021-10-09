package com.revature.daos;

import java.util.List;

import com.revature.models.Request;

//these are the things I can do with my "requests" table, in postgres
public interface RequestInterface {
	
	public List<Request> getAllRequests()                ;//retrieve everything in "requests" table
	
	public List<Request> getRequestPending(String status);//retrieve data by "pending"
	
	public void addRequest(Request request)				  ;//add a request to the table
	
	public void updateRequestStatus(int id, String status);//update request_status by calling the id#

}
