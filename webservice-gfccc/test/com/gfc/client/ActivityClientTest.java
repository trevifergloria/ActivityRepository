package com.gfc.client;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import com.gfc.model.Activity;

public class ActivityClientTest {

	@Test
	public void testGetActivity() {
		ActivityClient activityClient=new ActivityClient();
		Activity activity=activityClient.getActivity("1234");
		
		assertNotNull(activity);// basically if is no null it pass the test, otherwise it would fail
		System.out.println(activity);
	}

	@Test
	public void testGetAllActivities() {
		ActivityClient activityClient=new ActivityClient();
		List<Activity> activities=activityClient.getAllActivities();

		assertNotNull(activities);
	}
	
	//testing the testGetActivity () with Hamcrest
	@Test
	public void testGetActivityForDuration() {
		ActivityClient activityClient=new ActivityClient();
		Activity activity=activityClient.getActivity("1234");
		
		assertThat(activity.getDuration(), is(30));	
	}
	@Test (expected=RuntimeException.class)
	public void testActivityForException(){
		ActivityClient activityClient=new ActivityClient();
		Activity activity=activityClient.getActivity("6666");
		
	}
	
	@Test
	public void testCreateActivity(){
		ActivityClient activityClient=new ActivityClient();
		Activity activity=new Activity();
		activity.setDescription("Jogging");
		activity.setDuration(85);
		activity= activityClient.createActivity(activity);
		
		assertNotNull(activity);
	}
	
}
