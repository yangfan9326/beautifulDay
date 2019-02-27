package com.example.model;

/**
 *  从数据库表中查的结果
 * @author admin
 */
public class ObjDTO {

	private Integer id;
	private String name;
	private String city_code;
	private double coordinatex;
	private double coordinatey;
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
	public String getCity_code() {
		return city_code;
	}
	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}
	public double getCoordinatex() {
		return coordinatex;
	}
	public void setCoordinatex(double coordinatex) {
		this.coordinatex = coordinatex;
	}
	public double getCoordinatey() {
		return coordinatey;
	}
	public void setCoordinatey(double coordinatey) {
		this.coordinatey = coordinatey;
	}
	public ObjDTO() {
		super();
	}
	
	
	
}
