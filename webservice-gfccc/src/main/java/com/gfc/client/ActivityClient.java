//for testing purposes we create a client package
package com.gfc.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.eclipse.persistence.oxm.MediaType;

import com.gfc.model.Activity;

public class ActivityClient {
	//this class is unique for Jersey WS
	Client client;
	
	public ActivityClient(){
		//we have to create a new client every time we do a test
		client=ClientBuilder.newClient(); //client send the request to the server
	}
	
	//we'll test the public Activity getActivity(@PathParam ("activity") String activityId){
	
//	public Activity getActivity(String id){	//is a method for testing the same as below
//		WebTarget webTarget= client.target("http://localhost:8080/webservice-gfccc/");
//		Activity target=webTarget.path("activities/"+id).request().get(Activity.class);
//		//String target=webTarget.path("activities/"+id).request().get(String.class);
//		//return null;
//		return target;
//	}

	public Activity getActivity(String id){	
		WebTarget webTarget= client.target("http://localhost:8080/webservice-gfccc/");
		Response target=webTarget.path("activities/"+id).request().get(Response.class);
		
		if (target.getStatus()!=200){
			System.out.println("The error on the Server is: "+target.getStatus());
			throw new RuntimeException("The error on the Server is: "+target.getStatus());	
		}
		if (target.getStatus()==402){
			System.out.println("The error on the Server is: "+target.getStatus());
			throw new RuntimeException("The error on the Server is: "+target.getStatus());	
		}
		return target.readEntity(Activity.class);
	}

	
	public List<Activity> getAllActivities(){
		WebTarget w= client.target("http://localhost:8080/webservice-gfccc/").path("activities");		
		//List<Activity> list= w.request().get(List.class);
		List<Activity> list= w.request().get(new GenericType<List<Activity>>(){});
		return list;
	}

	public Activity createActivity(Activity activity) {
		//WebTarget webTarget= client.target("http://localhost:8080/webservice-gfccc/");
		//Response target=webTarget.path("activities/activity").
		//		request(MediaType.APPLICATION_JSON).post(Entity.entity(activity, MediaType.APPLICATION_JSON));
		WebTarget w=client.target("http://localhost:8080/webservice-gfccc/").path("activities/activity");
		
		return null;
		//return target.readEntity(Activity.class);
	}
}
