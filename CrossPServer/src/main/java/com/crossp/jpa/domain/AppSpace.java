package com.crossp.jpa.domain;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="app_space")
public class AppSpace{

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String position;
	private int price;
	private String displayMode;
	private String displayAction;	
	private int displayCount;
	private int dispayTime;
	
	@ManyToMany
	private List<App> apps;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDispayTime() {
		return dispayTime;
	}
	public void setDispayTime(int dispayTime) {
		this.dispayTime = dispayTime;
	}
	public String getDisplayMode() {
		return displayMode;
	}
	public void setDisplayMode(String displayMode) {
		this.displayMode = displayMode;
	}
	public String getDisplayAction() {
		return displayAction;
	}
	public void setDisplayAction(String displayAction) {
		this.displayAction = displayAction;
	}
	public int getDisplayCount() {
		return displayCount;
	}
	public void setDisplayCount(int displayCount) {
		this.displayCount = displayCount;
	} 
	
	
}
