package com.example.model;

import java.util.List;

/**
 * 返回给前端的结果
 * @author admin
 */
public class ResultDTO {

	private List<PicLocation> resultList;
	private String imageCode;
	public List<PicLocation> getResultList() {
		return resultList;
	}
	public void setResultList(List<PicLocation> resultList) {
		this.resultList = resultList;
	}
	public String getImageCode() {
		return imageCode;
	}
	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}
	
	
}
