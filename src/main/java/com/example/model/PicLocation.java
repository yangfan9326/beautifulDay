package com.example.model;

/**
 * 每个小图片的位置坐标信息
 * @author admin
 */
public class PicLocation {

	private Integer id;
	private String name;
	private String location;
	public PicLocation() {}
	
	public PicLocation(Integer id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
