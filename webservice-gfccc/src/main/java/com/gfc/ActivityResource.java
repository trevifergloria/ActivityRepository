package com.gfc;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.gfc.model.Activity;
import com.gfc.model.User;
import com.gfc.repository.ActivityRepository;
import com.gfc.repository.ActivityRepositoryStub;

//it maps the uri (uniform resource identifier) to the resource
@Path("activities")
public class ActivityResource {
	ActivityRepository activityRepository = new ActivityRepositoryStub ();

	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) //means we are going to receive an URL by http - basically
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Activity createActivityParams(MultivaluedMap<String,String> formParams){
		Activity activity= new Activity();
		activity.setDescription(formParams.getFirst("description"));
		activity.setDescription(formParams.getFirst("description"));
		activity.setDuration(Integer.parseInt(formParams.getFirst("duration")));
		/*System.out.println(formParams.getFirst("description"));
		System.out.println(formParams.getFirst("duration"));*/
		
		activityRepository.createActivity(activity);	
		return null;
	}
	
	
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_JSON) //means we are going to receive JSON format - basically
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Activity createActivity(Activity activity){
		activityRepository.createActivity(activity);
		return activity;
	}
	
//	@GET  //is the same as the below method 
//	@Path ("{activity}")  //http://localhost:8080/webservice-gfccc/activities/{activityId}
//	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//	public Activity getActivity(@PathParam ("activity") String activityId){
//		return activityRepository.findActivity(activityId);
//	}
	
	@GET
	@Path ("{activity}")  //http://localhost:8080/webservice-gfccc/activities/{activityId}
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getActivity(@PathParam ("activity") String activityId){
		if (activityId==null || activityId.length()<4){
			return Response.status(Status.BAD_REQUEST).build();
		}
		Activity activity=activityRepository.findActivity(activityId);
		if(activity==null){
			return Response.status(Status.NOT_FOUND).build();
		}
		if(activityId.equals("6666")){
			return Response.status(Status.PAYMENT_REQUIRED).build();
		}
		return Response.ok().entity(activity).build();
	}
	
	
	@GET
	@Path ("{activity}/user")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public User getActivityUser(@PathParam ("activity") String activityId){
		Activity a=activityRepository.findActivity(activityId);
		User u= a.getUser();
		return u;
		//next line is the same: but in one line:
		//return activityRepository.findActivity(activityId).getUser();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Activity> getAllActivities(){
		return activityRepository.findAllActivities();
	}
}
