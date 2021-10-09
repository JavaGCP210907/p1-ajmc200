package com.revature.services;

import java.util.List;

import com.revature.daos.RequestDao;
import com.revature.models.Request;

//The Service layer sits between the controllers and the daos
//We never want the repository/dao layer to touch the web/presentation layer
//There are also times where we want to add more logic like input validation, and the service layer is a good place for it
public class RequestService {

	//instantiate an AvengerDAO to use its method
	RequestDao aDao = new RequestDao();
	
	
	public List<Request> getAllRequests() {
		return aDao.getAllRequests();
	}
	
	public List<Request> getRequestStatus(String status) {
		return aDao.getRequestPending(status);
	}
	//all we're doing is calling the dao method in order to get a List of all the Avengers to send to the controller
	
	public void addRequest(Request request) {
		aDao.addRequest(request);
	}
	
	public void updateRequestStatus(int id, String status) {
		aDao.updateRequestStatus(id, status);
	}
}
