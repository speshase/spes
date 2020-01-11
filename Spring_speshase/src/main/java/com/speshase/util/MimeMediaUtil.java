package com.speshase.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

public class MimeMediaUtil {
	
	private static Map<String, MediaType> mediaMap;
	
	static {
		mediaMap = new HashMap<String, MediaType> ();
		mediaMap.put("JPG", MediaType.IMAGE_JPEG);
		mediaMap.put("GIF", MediaType.IMAGE_GIF);
		mediaMap.put("PNG", MediaType.IMAGE_PNG);
	}
	public static MediaType getMediaType(String type) {
		return mediaMap.get(type.toUpperCase());
		//소문자를 대문자로 바꾸어주는 함수. 있으면 true, 없으면 false(null)l
	}
}
