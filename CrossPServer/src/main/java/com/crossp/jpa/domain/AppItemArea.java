package com.crossp.jpa.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="app_item_area")
public class AppItemArea{

	@Id
	@GeneratedValue
	private Long id;
	private int sequence;
	private int status;
	private boolean isPublic = true;
	private long date = System.currentTimeMillis();
	@OneToOne
	private AppItem appItem;
	
	public AppItemArea() {
	}
	
	public AppItemArea(int sequence) {
		this.sequence = sequence;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public boolean isPublic() {
		return isPublic;
	}
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	public AppItem getAppItem() {
		return appItem;
	}
	public void setAppItem(AppItem appItem) {
		this.appItem = appItem;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}	
}
