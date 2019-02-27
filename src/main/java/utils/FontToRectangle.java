package utils;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**根据字体获得矩形宽度和高度
 * @author admin
 * 
 */
public class FontToRectangle {
	public static void main(String[] args) {
		Font font = new Font("宋体", Font.PLAIN, 20);
		Rectangle2D rec = getRectangleWidthHeight("a中bc",font);
		System.out.println(rec.getWidth()+","+rec.getHeight());
	}
	public static Rectangle2D getRectangleWidthHeight(String name,Font font){
		BufferedImage image = new BufferedImage(1,1,1);
		Graphics graphics = image.getGraphics();
		int width=image.getWidth();
		int height=image.getHeight();
		graphics.fillRect(0, 0, width, height);
		graphics.setFont(font);
		FontMetrics fm = graphics.getFontMetrics(font);
		return fm.getStringBounds(name, graphics);
	}
}
