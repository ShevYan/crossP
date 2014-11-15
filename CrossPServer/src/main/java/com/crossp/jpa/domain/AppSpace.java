package com.crossp.jpa.domain;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="app_space")
public class AppSpace{

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String position;
	private String showType;
	private String transparency;	
	private boolean isPublic = true;
		
	@ManyToOne(cascade = CascadeType.MERGE)
	private User user;
	@ManyToOne
	private AppTemplate appTemplate; 
	@OneToMany(cascade = CascadeType.ALL)
	private List<AppItemArea> appItemAreas;
	@ManyToMany(fetch = FetchType.LAZY)
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
	public String getShowType() {
		return showType;
	}
	public void setShowType(String showType) {
		this.showType = showType;
	}
	public String getTransparency() {
		return transparency;
	}
	public void setTransparency(String transparency) {
		this.transparency = transparency;
	}
	public boolean isPublic() {
		return isPublic;
	}
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}	
	public void setUser(User user) {
		this.user = user;
	}
	public AppTemplate getAppTemplate() {
		return appTemplate;
	}
	public void setAppTemplate(AppTemplate appTemplate) {
		this.appTemplate = appTemplate;
	}
	public List<AppItemArea> getAppItemAreas() {
		return appItemAreas;
	}
	public void setAppItemAreas(List<AppItemArea> appItemAreas) {
		this.appItemAreas = appItemAreas;
	}
}
