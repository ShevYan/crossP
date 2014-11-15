package com.crossp.jpa.domain;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="app_template")
public class AppTemplate{

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private int size;
	@OneToMany
	private List<AppItemArea> itemAreas;
	
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
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<AppItemArea> getItemAreas() {
		return itemAreas;
	}
	public void setItemAreas(List<AppItemArea> itemAreas) {
		this.itemAreas = itemAreas;
	}
	
}
