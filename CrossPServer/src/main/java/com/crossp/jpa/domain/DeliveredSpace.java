package com.crossp.jpa.domain;

// response of mobile's fetching request
public class DeliveredSpace {
	private String id;
	private String name;
	private String positon;
	private String showType;
	private String transparency;
	private String downloadLink;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPositon() {
		return positon;
	}
	public void setPositon(String positon) {
		this.positon = positon;
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
	public String getDownloadLink() {
		return downloadLink;
	}
	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}
	
	
}
