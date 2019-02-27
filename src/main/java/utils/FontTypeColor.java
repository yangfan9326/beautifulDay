package utils;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import com.example.model.FontAndColor;


/**
 * 根据citycode获取字体类型
 * @author admin
 */
public class FontTypeColor {
	
	/**根据citycode(Type)获得字体
	 * @param citycode
	 * @param fontAndColorList
	 * @return
	 */
	public static Font getFontByType(String citycode, List<FontAndColor> fontAndColorList) {
		Font font = null;
		for (int i = 0; i < fontAndColorList.size(); i++) {
			if (citycode.equals(fontAndColorList.get(i).getBaseid())) {
				font = fontAndColorList.get(i).getFont();
			}
		}
		return font;
	}

	/**根据citycode(Type)获得颜色
	 * @param citycode
	 * @param fontAndColorList
	 * @return
	 */
	public static Color getColorByType(String citycode, List<FontAndColor> fontAndColorList) {
		Color color = null;
		for (int i = 0; i < fontAndColorList.size(); i++) {
			if (citycode.equals(fontAndColorList.get(i).getBaseid())) {
				color = fontAndColorList.get(i).getColor();
			}
		}
		return color;
	}
}
