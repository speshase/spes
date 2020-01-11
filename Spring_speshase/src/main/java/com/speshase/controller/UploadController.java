package com.speshase.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.speshase.util.MimeMediaUtil;
import com.speshase.util.UploadFileUtils;

@Controller
public class UploadController {

	@Resource(name="uploadPath")
	private String uploadPath;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	//<form>태그를 이용하여 파일업로드
	@RequestMapping(value="/uploadForm", method=RequestMethod.GET) //화면이동이기때문에 get방식(화면 처리를 위한)
	public void uploadFormGet() {
	}

	@RequestMapping(value="uploadForm", method=RequestMethod.POST)
	public String uploadFormPost(MultipartFile file, Model model) throws Exception{
		logger.info("originalName="+file.getOriginalFilename());
		logger.info("Size="+file.getSize());
		logger.info("Bytes="+file.getBytes());
		logger.info("ContentType="+file.getContentType());

		String savedName=uploadFile(file.getOriginalFilename(), file.getBytes());
		model.addAttribute("savedName", savedName);
		
		return "uploadResult";
	}

	private String uploadFile(String originalName, byte[] fileData) throws Exception{
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString()+"_"+originalName;
		File targer = new File(uploadPath,savedName);
		FileCopyUtils.copy(fileData, targer);
		
		System.out.println("savedName="+savedName);

		return savedName;
	}
	
	//Ajax를 이용하여 파일업로드
	@RequestMapping(value="/uploadAjax", method=RequestMethod.GET)
	public void uploadAjax() {
		logger.info("uploadFormget=");
	}
	
	@ResponseBody
	@RequestMapping(value="/uploadAjax", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {
		logger.info("originalName="+file.getOriginalFilename());
		logger.info("Size="+file.getSize());
		logger.info("ContentType="+file.getContentType());
		
	return new ResponseEntity<>(
			UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()),
					HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(value="/displayFile", method=RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception{
		logger.info("File Name="+fileName);
		File file = new File("E:\\JAVA_GREEN\\upload\\"+fileName);
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;

		try {
			String formatName=fileName.substring(fileName.lastIndexOf(".")+1);
			MediaType mType=MimeMediaUtil.getMediaType(formatName);
			HttpHeaders header = new HttpHeaders();
			in = new FileInputStream(uploadPath+fileName);
			//header.add("Content-Type", Files.probeContentType(file.toPath()));
			if(mType != null) {
				header.add("Content-Type", Files.probeContentType(file.toPath()));
			}else {
				fileName=fileName.substring(fileName.indexOf("_")+1);
				header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				header.add("Content-DisPosition", "attachment;fileName=\""
				+new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
			}
			entity = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),
					header, HttpStatus.OK);		
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally {
			in.close();
		}
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteFile", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> deleteFile(String fileName) throws Exception {
		logger.info("Delete fileName="+fileName);
		
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		
		MediaType mType = MimeMediaUtil.getMediaType(formatName);
		
		if(mType != null) {
			String front = fileName.substring(0, 12);
			String end = fileName.substring(14);
			new File(uploadPath + (front+end).replace('/', File.separatorChar)).delete();
		}
		new File(uploadPath + (fileName).replace('/', File.separatorChar)).delete();
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
}


