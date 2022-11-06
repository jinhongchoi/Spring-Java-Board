package edu.spring.ex05.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import edu.spring.ex05.util.FileUploadUtil;
import edu.spring.ex05.util.MediaUtil;

;

@Controller
public class FileUploadController {
	private static final Logger logger = 
			LoggerFactory.getLogger(FileUploadController.class);
	
	// servlet-context.xml 파일에 설정된 문자열 리소스 주입
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@GetMapping("/upload") // 파일 업로드 하는 부분
	public void uploadGET() {
		logger.info("uploadGET() 호출: "+uploadPath);
	}
	
	@PostMapping("/upload")
	public void uploadPOST(MultipartFile file, Model model) {
		logger.info("=====uploadPOST()호출=====");
		logger.info("=====파일 이름 : "+file.getOriginalFilename()+"=====");
		logger.info("=====파일 크기: "+ file.getSize()+"=====");
		
		String savedFile= saveUploadFile(file);
	}
	
	@PostMapping("/upload2")
	public String uploadPost2(MultipartFile[] files, Model model) {
		String result ="";
		for(MultipartFile f : files) {
			result += saveUploadFile(f)+ " ";
		}
		logger.info("=====result = "+ result);
		return "upload";
	}
	
	@GetMapping("/upload-ajax")
	public void uploadAjaxGET() {
		logger.info("=====uploadAjaxGET() 호출=====");
	}
	
	@PostMapping("/upload-ajax")
	public ResponseEntity<String> uploadAjaxPOST(MultipartFile[] files) throws IOException{
		logger.info("=====uploadAjaxPOST() 호출=====");
		
		// 파일 하나만 저장
		String result = null; // result : 파일 경로 및 썸네일 이미지 이름
		result = FileUploadUtil.saveUploadedFile(uploadPath, 
				files[0].getOriginalFilename(), 
				files[0].getBytes());
		
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	// display 함수를 호출하면 서버에서 이미지를 확인할 수 있음 - 파일 경로를 전송해야 함
	@GetMapping("/display")
	public ResponseEntity<byte[]>display(String fileName)throws Exception{
		logger.info("=====display() 호출");
		ResponseEntity<byte[]>entity = null;
		InputStream in = null;
		
		String filePath = uploadPath + fileName; // uploadPath -> 저장했던 경로
		in= new FileInputStream(filePath);
		
		//파일 확장자
		String extension =
				filePath.substring(filePath.lastIndexOf(".")+1);
		logger.info(extension);
		
		// 응답 헤더(response header) 에 Content-Type 설정
		HttpHeaders httpHeaders = new HttpHeaders(); //org.springframework.http.HttpHeaders; 이거 임포트
		httpHeaders.setContentType(MediaUtil.geMediaType(extension));
		
		// 데이터 전송
		entity = new ResponseEntity<byte[]>(
					IOUtils.toByteArray(in),// org.apache.commons.io.IOUtils; 이거 임포트
					httpHeaders,
					HttpStatus.OK
				);
		return entity;
		//http://localhost:8080/ex05/display?fileName=/unnamed.jpg 이거 검색해서 불러와서 있는지 확인
	}

	private String saveUploadFile(MultipartFile file) {
		// UUID: 업로드하는 파일이 중복되지 않도록
		UUID uuid = UUID.randomUUID();		//uuid 이용해서 팡리 명만들어줌
		String savedName = uuid + "_"+ file.getOriginalFilename(); 
		File target= new File(uploadPath, savedName); 
		
		try {
			FileCopyUtils.copy(file.getBytes(), target); // 여기서 파일 명 저장
			logger.info("=====파일 저장 성공=====");
			return savedName;
		} catch (IOException e) {
			logger.info("=====파일 저장 실패=====");
			e.printStackTrace();
			return null;
		}
		
		
	}//end saveUploadFile
	
	
	
}









