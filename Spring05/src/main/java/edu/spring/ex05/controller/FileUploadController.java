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
	
	// servlet-context.xml ���Ͽ� ������ ���ڿ� ���ҽ� ����
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@GetMapping("/upload") // ���� ���ε� �ϴ� �κ�
	public void uploadGET() {
		logger.info("uploadGET() ȣ��: "+uploadPath);
	}
	
	@PostMapping("/upload")
	public void uploadPOST(MultipartFile file, Model model) {
		logger.info("=====uploadPOST()ȣ��=====");
		logger.info("=====���� �̸� : "+file.getOriginalFilename()+"=====");
		logger.info("=====���� ũ��: "+ file.getSize()+"=====");
		
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
		logger.info("=====uploadAjaxGET() ȣ��=====");
	}
	
	@PostMapping("/upload-ajax")
	public ResponseEntity<String> uploadAjaxPOST(MultipartFile[] files) throws IOException{
		logger.info("=====uploadAjaxPOST() ȣ��=====");
		
		// ���� �ϳ��� ����
		String result = null; // result : ���� ��� �� ����� �̹��� �̸�
		result = FileUploadUtil.saveUploadedFile(uploadPath, 
				files[0].getOriginalFilename(), 
				files[0].getBytes());
		
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	// display �Լ��� ȣ���ϸ� �������� �̹����� Ȯ���� �� ���� - ���� ��θ� �����ؾ� ��
	@GetMapping("/display")
	public ResponseEntity<byte[]>display(String fileName)throws Exception{
		logger.info("=====display() ȣ��");
		ResponseEntity<byte[]>entity = null;
		InputStream in = null;
		
		String filePath = uploadPath + fileName; // uploadPath -> �����ߴ� ���
		in= new FileInputStream(filePath);
		
		//���� Ȯ����
		String extension =
				filePath.substring(filePath.lastIndexOf(".")+1);
		logger.info(extension);
		
		// ���� ���(response header) �� Content-Type ����
		HttpHeaders httpHeaders = new HttpHeaders(); //org.springframework.http.HttpHeaders; �̰� ����Ʈ
		httpHeaders.setContentType(MediaUtil.geMediaType(extension));
		
		// ������ ����
		entity = new ResponseEntity<byte[]>(
					IOUtils.toByteArray(in),// org.apache.commons.io.IOUtils; �̰� ����Ʈ
					httpHeaders,
					HttpStatus.OK
				);
		return entity;
		//http://localhost:8080/ex05/display?fileName=/unnamed.jpg �̰� �˻��ؼ� �ҷ��ͼ� �ִ��� Ȯ��
	}

	private String saveUploadFile(MultipartFile file) {
		// UUID: ���ε��ϴ� ������ �ߺ����� �ʵ���
		UUID uuid = UUID.randomUUID();		//uuid �̿��ؼ� �θ� �������
		String savedName = uuid + "_"+ file.getOriginalFilename(); 
		File target= new File(uploadPath, savedName); 
		
		try {
			FileCopyUtils.copy(file.getBytes(), target); // ���⼭ ���� �� ����
			logger.info("=====���� ���� ����=====");
			return savedName;
		} catch (IOException e) {
			logger.info("=====���� ���� ����=====");
			e.printStackTrace();
			return null;
		}
		
		
	}//end saveUploadFile
	
	
	
}









