package com.crossp.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
@Inheritance
@Table(name="app_report_data")
public class AppReportData{

	@Id  
	@GeneratedValue
	private Long id;
	private Long appId;
	private Long appSpaceId;
	private Long appItemId;	
	private Long appTemplateId;
	private Long appAreaId;
	private Long count;
	private int type;
	private long date = System.currentTimeMillis();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAppId() {
		return appId;
	}
	public void setAppId(Long appId) {
		this.appId = appId;
	}
	public Long getAppSpaceId() {
		return appSpaceId;
	}
	public void setAppSpaceId(Long appSpaceId) {
		this.appSpaceId = appSpaceId;
	}
	public Long getAppItemId() {
		return appItemId;
	}
	public void setAppItemId(Long appItemId) {
		this.appItemId = appItemId;
	}
	public Long getAppTemplateId() {
		return appTemplateId;
	}
	public void setAppTemplateId(Long appTemplateId) {
		this.appTemplateId = appTemplateId;
	}
	public Long getAppAreaId() {
		return appAreaId;
	}
	public void setAppAreaId(Long appAreaId) {
		this.appAreaId = appAreaId;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
		
	
}
