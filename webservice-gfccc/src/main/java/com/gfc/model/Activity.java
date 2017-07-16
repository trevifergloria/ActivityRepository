package com.gfc.model;

import javax.xml.bind.annotation.XmlRootElement;
//it idenfifies all the resources the client interact with the server
@XmlRootElement
public class Activity {
	private String description;
	private int duration;
	private String id;
	private User user=new User();
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}	
}
