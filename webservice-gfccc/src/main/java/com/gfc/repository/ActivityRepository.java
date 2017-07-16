package com.gfc.repository;

import java.util.List;

import com.gfc.model.Activity;

public interface ActivityRepository {

	/* (non-Javadoc)
	 * @see com.gfc.repository.ActivityRepository#findAllActivities()
	 */
	List<Activity> findAllActivities();

	Activity findActivity(String id);

	void createActivity(Activity a);


}