package utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Base64;
import java.util.Base64.Encoder;

/**
 * 此类将 图片转换Base64编码
 * @author admin
 */
public class PicToBase64 {
	public static void main(String[] args) throws Exception {
		String imgFile = "D:/test/small.png";
		String result = getImageCode(imgFile);
		System.out.print(result);
	}

	public static String getImageCode(String filePath) throws Exception {
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] b = new byte[1024];
		int len = -1;
		while ((len = fis.read(b)) != -1) {
			bos.write(b, 0, len);
		}
		byte[] data = bos.toByteArray();
		Encoder encoder = Base64.getEncoder();
		String encode = encoder.encodeToString(data);
		return "data:image/png;base64,"+encode;
	}

}