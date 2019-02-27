package utils;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.example.model.FontAndColor;

/**
 * 从给定的配置文件中获得不同类型对应的 字体 颜色集合List @author admin @category
 */
public class FontColorFromXml {

	public static void main(String[] args) throws DocumentException {
		List<FontAndColor> list = getFontColorFromXml("src/fontSizeColor.xml");
		list.forEach(str -> System.out.println(str));
	}

	// 从配置文件获得字符串类型的字体和颜色
	public static List<FontAndColor> getFontColorFromXml(String fontFileLocation) throws DocumentException {
		SAXReader sr = new SAXReader();
		Document document = sr.read(new File(fontFileLocation));
		Element root = document.getRootElement();
		List<Element> elementList = root.elements();
		List<FontAndColor> fontAndColorList = new ArrayList<FontAndColor>();
		for (Element e : elementList) {
			FontAndColor fontAndColor = new FontAndColor();

			// 设置id
			fontAndColor.setBaseid(e.attributeValue("baseid").trim());

			// 设置字体风格默认是0 表示plain
			int fontStyle = 0;
			// 常规字体
			if ("BOLD".equalsIgnoreCase((e.attributeValue("font-style").trim()))) {
				fontStyle = 1;
			} else if ("ITALIC".equalsIgnoreCase((e.attributeValue("font-style").trim()))) {
				fontStyle = 2;
			}

			/*int size = Integer.parseInt(e.attributeValue("font-size").trim()) > 20 ? 20
					: Integer.parseInt(e.attributeValue("font-size").trim());*/
			int size = getNum(Integer.parseInt(e.attributeValue("font-size").trim()));
			
			Font font = new Font(e.attributeValue("font-family").trim(), fontStyle, size);
			fontAndColor.setFont(font);

			// 获取颜色属性三个参数 并split成数组
			String colorArray[] = e.attributeValue("color").split(",");
			Color color = new Color(Integer.parseInt(colorArray[0].trim()), Integer.parseInt(colorArray[1].trim()),
					Integer.parseInt(colorArray[2].trim()));
			fontAndColor.setColor(color);
			fontAndColorList.add(fontAndColor);
		}
		return fontAndColorList;
	}
	
	//字体范围限定
	public static int getNum(int num){
		if(num<18){
			return 18;
		}else if (num>22){
			return 22;
		}
		return num;
	}
}
