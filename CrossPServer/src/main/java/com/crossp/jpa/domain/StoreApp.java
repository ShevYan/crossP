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
@Table(name="store_app")
public class StoreApp{

	@Id
	@GeneratedValue
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAppstoreId() {
		return appstoreId;
	}
	public void setAppstoreId(String appstoreId) {
		this.appstoreId = appstoreId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon175Link() {
		return icon175Link;
	}
	public void setIcon175Link(String icon175Link) {
		this.icon175Link = icon175Link;
	}
	public String getIcon350Link() {
		return icon350Link;
	}
	public void setIcon350Link(String icon350Link) {
		this.icon350Link = icon350Link;
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
	public String getScreenPicture1Link() {
		return screenPicture1Link;
	}
	public void setScreenPicture1Link(String screenPicture1Link) {
		this.screenPicture1Link = screenPicture1Link;
	}
	public String getScreenPicture2Link() {
		return screenPicture2Link;
	}
	public void setScreenPicture2Link(String screenPicture2Link) {
		this.screenPicture2Link = screenPicture2Link;
	}
	public String getScreenPicture3Link() {
		return screenPicture3Link;
	}
	public void setScreenPicture3Link(String screenPicture3Link) {
		this.screenPicture3Link = screenPicture3Link;
	}
	public String getScreenPicture4Link() {
		return screenPicture4Link;
	}
	public void setScreenPicture4Link(String screenPicture4Link) {
		this.screenPicture4Link = screenPicture4Link;
	}
	private String appstoreId;
	private String name;
	private String icon175Link;
	private String icon350Link;
	private String type;
	private String description;
	private String screenPicture1Link;
	private String screenPicture2Link;
	private String screenPicture3Link;
	private String screenPicture4Link;
	
	
}
