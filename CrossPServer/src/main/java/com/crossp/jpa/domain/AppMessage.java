package com.crossp.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
@Inheritance
@Table(name="app_message")
public class AppMessage{

	@Id  
	@GeneratedValue
	private Long id;
	private Long cid;
	private Long pid;
	private Long appId;
	private Long appSpaceId;
	private Long appItemId;	
	private Long appTemplateId;
	private Long appAreaId;
	private String data;
	private int type;
	private int status;
	private long date = System.currentTimeMillis();
	
	public AppMessage() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}	
}
