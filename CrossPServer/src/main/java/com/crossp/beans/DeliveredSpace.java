package com.crossp.beans;

import java.util.List;

// response of mobile's fetching request
public class DeliveredSpace {
	private String appId;
	private String positon;
	private String showType;
	private String transparency;
	private String downloadLink;
	private List<DeliveredItem> items;
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
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
	public List<DeliveredItem> getItems() {
		return items;
	}
	public void setItems(List<DeliveredItem> items) {
		this.items = items;
	}
	

}
