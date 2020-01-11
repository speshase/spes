package com.speshase.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

import com.speshase.controller.BoardController;

public class UploadFileUtils {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	// 클래스메서드 리턴타입 메서드명()
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception {
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + originalName;
		//uploadPath : E:\\JAVA_GREEN\\upload
		String savedPath = calcPath(uploadPath);
		File targer = new File(uploadPath+savedPath, savedName);
		FileCopyUtils.copy(fileData, targer);
		
		System.out.println("uploadPath="+uploadPath);
		System.out.println("originalName="+originalName);
		System.out.println("targer="+targer);
		//끝에서부터 .을 찾아서 첫번쨰부터 출력.
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
		System.out.println("formatName="+formatName);
		String uploadedFileName=null;
		if(MimeMediaUtil.getMediaType(formatName)!=null) {
			uploadedFileName = makeThumbnail(uploadPath, savedPath, savedName);
		}else {
			uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		}
		return uploadedFileName;
	}

	// uploadFile
	private static String calcPath(String uploadPath) {
		//uploadPath : E:\\JAVA_GREEN\\upload

		// Calendar메서드 : 기본시간대 및 로컬을 사용하여 달력을 가져온다.
		Calendar cal = Calendar.getInstance();
		// 결과 출력해보기.
		System.out.println("cal=" + cal);

		// 달력 중에서 년도만 가져오기(separator : 폴더를 구분하기 위해 '/'를 붙이는 것)
		// '/2020'이 만들어짐.
		String yearPath = File.separator + cal.get(Calendar.YEAR);

		// '2020/01'이 만들어짐.
		// January는 0을 반환하므로 +1을 해준다.
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);

		// '2020/01/07'이 만들어짐.
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));

		//폴더 만들 때 필요한 정보들(uploadPath, yearPath, monthPath, datePath)
		makeDir(uploadPath, yearPath, monthPath, datePath);
		logger.info(datePath);

		// '2020/01/07'를 리턴.
		return datePath;
	}

	// 가변배열(배열의 길이를 모를 때 사용)
	private static void makeDir(String uploadPath, String... paths) {
		
		//똑같은 폴더가 존재하면 return하고,
		if (new File(paths[paths.length-1]).exists()) {
			return;
		}
		for (String path : paths) {
			File dirPath = new File(uploadPath + path);
			//그렇지 않으면 폴더를 만든다.
			if (!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
	}
	
	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception{
		//Buffer : 임시기억장치
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath+path,fileName));
		System.out.println(sourceImg);
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,100); //썸네일 파일높이를 100으로 변경
		String thumbnailName = uploadPath + path + File.separator + "s_" + fileName; //썸네일 파일 앞에 s_붙임
		File newFile = new File(thumbnailName);
		
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		return thumbnailName.substring(uploadPath.length()).replace(File.separator, "/"); //'\'를 '/'로 변경, url에 경로를 인식시키기 위해.
	}
	
	private static String makeIcon(String uploadPath, String path, String fileName) throws Exception{
		String iconName = uploadPath + path + File.separator+fileName;
		return iconName.substring(uploadPath.length()).replace(File.separatorChar,'/');
	}
}

