package utils;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.example.model.FontAndColor;
import com.example.model.ObjDTO;
import com.example.model.PicLocation;

/**
 * 生成大图的工具类
 * @author admin
 */
public class WordToPic {
	/**
	 * @param objList
	 * @param fontAndColorList
	 * @param image
	 * @return
	 * @throws Exception
	 */
	public static List<PicLocation> createImage(List<ObjDTO> objList, List<FontAndColor> fontAndColorList,
			BufferedImage image, String outPicLocation) throws Exception {
		Graphics2D g = (Graphics2D) image.getGraphics();
		// 设置画图规则
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);// 抗锯齿
		g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);// alpha插值
		g.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_DISABLE);// 禁止抖动
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);//
		g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

		// g.fillRect(0, 0, image.getWidth(), image.getHeight());
		int width = image.getWidth();// 大图的宽度
		int height = image.getHeight();// 大图高度

		Rectangle2D nameSize = FontToRectangle.getRectangleWidthHeight("1",
				FontTypeColor.getFontByType(objList.get(0).getCity_code(), fontAndColorList));// 每个小图占得矩(是变量)

		int start = 0;// 开始画图的x坐标
		int y = (int) Math.floor(nameSize.getHeight());// 获得第一和字符的高度 同时是画图的y坐标

		Font font = null;// 字体
		List<String> coordinate = new ArrayList<String>();// 保存坐标位置
		String fourNumbers =null;
		List<PicLocation> picLocationList = new ArrayList<PicLocation>();
		for (int i = 0; i < objList.size(); i++) {
			g.setColor(FontTypeColor.getColorByType(objList.get(i).getCity_code(), fontAndColorList));// 设置字体颜色
			font = FontTypeColor.getFontByType(objList.get(i).getCity_code(), fontAndColorList);
			g.setFont(font);// 设置当前名字的字体
			nameSize = FontToRectangle.getRectangleWidthHeight(objList.get(i).getName(), font);// 获取当前字符串占得矩形框
			if (nameSize.getWidth() < width - start) {
				/*PicLocation picLocation = new PicLocation(objList.get(i).getId(), objList.get(i).getName(),
						drawingSmall(objList.get(i).getName(), font, g, start, y));*/
				PicLocation picLocation = new PicLocation();
				picLocation.setId(objList.get(i).getId());
				picLocation.setName(objList.get(i).getName());
				fourNumbers = drawingSmall(objList.get(i).getName(), font, g, start, y);
				picLocation.setLocation(fourNumbers);
				picLocationList.add(picLocation);
				coordinate.add(fourNumbers);
				
				start = start + (int) (nameSize.getWidth()) + 2;// 记录下一个开始的位置
				continue;
			} else {
				start = 0;// 换行画图,开始位置置零
				y = y + (int) nameSize.getHeight() + 8;// 换行y值增加 有误差
				if (y > height) {// 超出图片最大高度
					throw new Exception("超出界限");
				}
				/*PicLocation picLocation = new PicLocation(objList.get(i).getId(), objList.get(i).getName(),
						drawingSmall(objList.get(i).getName(), font, g, start, y));*/
				PicLocation picLocation = new PicLocation();
				picLocation.setId(objList.get(i).getId());
				picLocation.setName(objList.get(i).getName());
				fourNumbers = drawingSmall(objList.get(i).getName(), font, g, start, y);
				picLocation.setLocation(fourNumbers);
				picLocationList.add(picLocation);
				coordinate.add(fourNumbers);
				
				start = start + (int) (nameSize.getWidth()) + 2;// 记录下一个开始的位置
				continue;
			}
		}
		g.dispose();
		File file = new File(outPicLocation);
		if(!file.exists()){
			file.createNewFile();
		}
		ImageIO.write(image, "png", file);// 画大图
		coordinate.forEach(System.out::println);// 打印坐标四个数

		// 截取小图
		for (int i = 0; i < coordinate.size(); i++) {
			String[] abcd = coordinate.get(i).split(",");
			int a = Integer.parseInt(abcd[0].trim());
			int b = Integer.parseInt(abcd[1].trim());
			int c = Integer.parseInt(abcd[2].trim());
			int d = Integer.parseInt(abcd[3].trim());
			ImageIO.write(image.getSubimage(a, b, c - a, d - b), "png",
					new File("D:/test/pictures/small" + i + ".png"));
		}
		return picLocationList;
	}

	/**
	 * 画图并记录坐标位置的方法
	 * @param name
	 * @param font
	 * @param g
	 * @param x
	 * @param y
	 * @return
	 */
	public static String drawingSmall(String name, Font font, Graphics2D g, int x, int y) {
		Rectangle2D nameSize = FontToRectangle.getRectangleWidthHeight(name, font);
		g.drawString(name, x, y);
		String locationString = x + "," + (y + 4 - (int) Math.floor((nameSize.getHeight()))) + ","
				+ (x + (int) nameSize.getWidth()) + "," + (y + 4);
		return locationString;
	}
}