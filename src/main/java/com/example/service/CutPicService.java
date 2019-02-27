package com.example.service;

import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.FontAndColor;
import com.example.model.ObjDTO;
import com.example.model.ResultDTO;

import utils.FontColorFromXml;
import utils.GetObjFromXml;
import utils.PicToBase64;
import utils.WordToPic;


public class CutPicService {
	public static ResultDTO getResultDTO() throws Exception {
		ResultDTO resultDTO = new ResultDTO();
		BufferedImage image = new BufferedImage(1000, 800, Transparency.TRANSLUCENT);
		List<ObjDTO> objDTOList=GetObjFromXml.getList("src/main/resources/static/ObjDTO.xml");
		List<FontAndColor> fontAndColorList = FontColorFromXml.getFontColorFromXml("src/main/resources/static/fontSizeColor.xml");
		String outPicLocation="D:/test/bigcode2.png";
		resultDTO.setResultList(WordToPic.createImage(objDTOList, fontAndColorList, image,outPicLocation));
		String imageCode = PicToBase64.getImageCode(outPicLocation);
		resultDTO.setImageCode(imageCode);
		return resultDTO;
	}
}
