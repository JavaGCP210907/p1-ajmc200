package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Request;
import com.revature.services.RequestService;

import io.javalin.http.Handler;

//The Controller layer sits between the Launcher (our Javalin Front Controller) and the Service layer
//This layer is where we'll parse our JSON into Java objects or vice versa
//We'll either be getting data from the service layer (which gets it from the DAO)...
//OR sending data to the service layer (which will validate it and send it to the DAO).
public class RequestController {
	
	RequestService as = new RequestService(); 
	

	public Handler getAllRequestsHandler = (ctx) -> {
		
		//if(ctx.req.getSession(false) != null) { //if a session exists...
		
		//we create an Array with Avenger data (using the service to talk to the dao)
		List<Request> allRequests = as.getAllRequests();
		
		//instantiate a Gson object to make JSON <-> POJO conversions (POJO - plain old java object)
		Gson gson = new Gson();
		
		String JSONRequests = gson.toJson(allRequests); //convert our Java object into a JSON String
		
		ctx.result(JSONRequests); //return our Avengers
		
		ctx.status(200); //200 = OK (success)
		
		//} else {
		//	ctx.status(403); //forbidden status code 
		//}
		
	};

	public Handler getRequestStatusHandler = (ctx) -> {
		Gson another = new Gson();
		Request JSONRequests = another.fromJson(ctx.body(), Request.class);
		
		//create list to return
		List<Request> statusRequests = as.getRequestStatus(JSONRequests.getRequest_status());
		//convert to json
		Gson gson = new Gson();
		String JSONResponse = gson.toJson(statusRequests); //convert our Java object into a JSON String
		//send results
		ctx.result(JSONResponse); //return our Avengers
		ctx.status(200); //200 = OK (success)
		
	};
	
	public Handler addRequestHandler = (ctx) -> {
		
		Gson gson = new Gson();//instantate to convert		
		Request JSONRequests = gson.fromJson(ctx.body(), Request.class); //http body --> java obj
	
		as.addRequest(JSONRequests);//run the new request object through our service and dao	
		ctx.status(200); //return 200 = OK (success)
		
	};

	public Handler updateRequestStatusHandler = (ctx) -> {
		
		Gson gson = new Gson();
		Request JSONRequests = gson.fromJson(ctx.body(), Request.class);
		
		as.updateRequestStatus(JSONRequests.getRequest_id(), JSONRequests.getRequest_status());
		//ctx.result(gson.toJson(JSONRequests.getRequest_status()));
		ctx.status(204); //200 = OK (success)
		
	};
}
