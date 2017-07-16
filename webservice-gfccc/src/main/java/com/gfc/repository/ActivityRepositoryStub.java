package com.gfc.repository;

import java.util.ArrayList;
import java.util.List;
import com.gfc.model.Activity;
import com.gfc.model.User;

public class ActivityRepositoryStub implements ActivityRepository {
	//variable reference      = assigning an object to the reference
		List<Activity> activities = new ArrayList<Activity>();
		Activity activity1=new Activity();
		Activity activity2=new Activity();
		
	/* (non-Javadoc)
	 * @see com.gfc.repository.ActivityRepository#findAllActivities()
	 */
	@Override
	public  List<Activity> findAllActivities(){
		activity1.setDescription("Swimming");
		activity1.setDuration(30);
		activities.add(activity1);
	
		activity2.setDescription("Cycling");
		activity2.setDuration(20);
		activities.add(activity2);

		return activities;
	}
	/* (non-Javadoc)
	 * @see com.gfc.repository.ActivityRepository#findActivity(java.lang.String)
	 */
	@Override
	public Activity findActivity(String id){
		activity1.setDescription("Swimming");
		activity1.setDuration(30);
		activity1.setId(id);
		
		User user= new User();
		user.setName("John");
		user.setId("123");
		
		activity1.setUser(user);
		
		return activity1;
	}
	@Override
	public void createActivity(Activity a) {
		a.getDescription();
		a.getDuration();
		
	}

//	@Override
//	public Activity findActivity(String id){
//		if(id.equals("123")){
//			activity1.setDescription("Swimming");
//			activity1.setDuration(30);
//			activity1.setId(id);
//		}
//		else if(id.equals("456")){
//			activity1.setDescription("Cycling");
//			activity1.setDuration(40);
//			activity1.setId(id);
//		}
//		return activity1;
//	}
	
	
}
