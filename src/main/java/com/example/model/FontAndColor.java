package com.example.model;

import java.awt.Color;
import java.awt.Font;

/**
 * 类型 字体 颜色的封装
 * @author admin
 *
 */
public class FontAndColor {

	private String baseid;
	private Color color;
	private Font font;
	
	public String getBaseid() {
		return baseid;
	}
	public void setBaseid(String baseid) {
		this.baseid = baseid;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Font getFont() {
		return font;
	}
	public void setFont(Font font) {
		this.font = font;
	}
	@Override
	public String toString() {
		return "FontAndColor [baseid=" + baseid + ", color=" + color + ", font=" + font + "]";
	}
}
