package my.practice.freeboard.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

public class MediaUtil {

	private static Map<String, MediaType> mediaMap;
	
	static {
		mediaMap = new HashMap<>();
		mediaMap.put("JPG", MediaType.IMAGE_JPEG);
		mediaMap.put("GIF", MediaType.IMAGE_GIF);
		mediaMap.put("PNG", MediaType.IMAGE_PNG);
		mediaMap.put("JFIF", MediaType.IMAGE_PNG); // 구글에서 만든 새로운 확장자
	}
	
	public static MediaType geMediaType(String type) {
		return mediaMap.get(type.toUpperCase());
	}
	
}
