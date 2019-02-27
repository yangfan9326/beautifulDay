package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.example.model.ObjDTO;

/**
 * 从配置文件获得对象的列表List
 * 
 * @author admin
 */
public class GetObjFromXml {
	public static List<ObjDTO> getList(String fileLocation) throws Exception {
		SAXReader sr = new SAXReader();
		Document document = sr.read(new File(fileLocation));
		Element root = document.getRootElement();
		List<Element> elementList = root.elements();
		List<ObjDTO> ObjList = new ArrayList<ObjDTO>();
		for (Element e : elementList) {
			ObjDTO obj = new ObjDTO();
			obj.setCity_code(e.attributeValue("city_code").trim());
			obj.setCoordinatex(Double.parseDouble(e.attributeValue("st_x").trim()));
			obj.setCoordinatey(Double.parseDouble(e.attributeValue("st_y").trim()));
			obj.setId(Integer.parseInt(e.attributeValue("id").trim()));
			obj.setName(e.attributeValue("name").trim());
			ObjList.add(obj);
		}
		return ObjList;
	}
}
