package com.crossp.jpa.domain;


import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Inheritance
@Table(name="app")
public class App{

	@Id  
	@GeneratedValue
	private Long id;
	private String appId;
	private String name;
	private String platform;
	private String type;
	private String description;
	private boolean isPublic = true;
	private UUID token =  java.util.UUID.randomUUID();
	private long date = System.currentTimeMillis();
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<App> apps;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<AppSpace> appSpaces;
	@ManyToOne(cascade = CascadeType.MERGE)
	private User user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isPublic() {
		return isPublic;
	}
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<AppSpace> getAppSpaces() {
		return appSpaces;
	}
	public void setAppSpaces(List<AppSpace> appSpaces) {
		this.appSpaces = appSpaces;
	}	
	public UUID getToken() {
		return token;
	}
	public void setToken(UUID token) {
		this.token = token;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}	
}
