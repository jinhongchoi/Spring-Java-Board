package edu.spring.ex10.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.ex10.domain.EventVO;
import edu.spring.ex10.domain.ProductVO;
import edu.spring.ex10.pageutil.PageCriteria;
import edu.spring.ex10.pageutil.PageMaker;
import edu.spring.ex10.service.EventService;
import edu.spring.ex10.util.MediaUtil;

@Controller
@RequestMapping(value="/event")
public class EventController {
	
	private static final Logger logger =
			LoggerFactory.getLogger(EventController.class);
	
	@Autowired
	private EventService EventService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@GetMapping("/eventregister")
	public void registerGET() {
		logger.info("-----------eventregisterGET()호출-----------");
	}//end registerGET()
	
	@PostMapping("/eventregister")
	public String registerPOST(EventVO vo, @RequestParam("files") MultipartFile[] files, RedirectAttributes reAttr) throws IOException{
		// RedirectAttributes
		// - 새로운 경로 위치에 속성값을 전송하는 객체
		logger.info("-----------eventregisterPOST()호출--"+vo.toString()+"---------");
				
		String img="";
		for(MultipartFile f: files) {
			img += saveUploadFile(f)+ "";
		}
		logger.info("파일 저장 경로" + uploadPath);
		logger.info("img = " + img);
		vo.setEventUrl(img);
		
		int result =EventService.create(vo);
		
		logger.info(result+ "행 삽입");
		 
		
		return "redirect:/event/eventlist";
		
	}//end registerPOST()
	
	@GetMapping("/eventlist")// jsp 명이랑 똑같이 맞출 것!
	public void list(Model model, Integer page, Integer numsPerPage, String productCate) {
		logger.info("-----------list()호출-----------");
		logger.info("page = "+page + ", numsPerPage = "+ numsPerPage);
		

		
		PageCriteria criteria = new PageCriteria();
		if(page != null) {
			criteria.setPage(page);
		}
		
		if(numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}
		
		List<EventVO>listEvent = EventService.read(criteria);		
		model.addAttribute("listEvent", listEvent);	
				
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(EventService.getTotalCount());
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);
						
	}//end list
	
	@GetMapping("/eventDetail") //detail을 가져오는게  get 방식이기 때문에 GetMapping을 사용한다
	public void detail(Model model, Integer eventId) {
		logger.info("-----------detail()호출: eventId= " + eventId +"-----------");
		EventVO vo = EventService.detailEvent(eventId);
		model.addAttribute("vo", vo);
		
		// model을 이용해 jsp로 보낸다!
		// 기존의 servlet 에서 request.setAttribute() 이거와 같음 -> request나 session과 같은 개념!
		
	}//end detail
	
	@GetMapping("/eventupdate") // 일단 페이지가 필요해서 get으로 가져옴
	public void productpdateGET(Model model, Integer eventId, Integer page) {
		logger.info("-----------updateGET()호출: eventId = "+eventId+"-----------");
		EventVO vo = EventService.detailEvent(eventId); //페이지에 보낼 정보들을 boardService를 통해서 필요한 정보들 가져온다.
		model.addAttribute("vo", vo);
		
	}//end updateGET
	
	@PostMapping("/eventupdate")
	public String productpdatePOST(EventVO vo, @RequestParam("files") MultipartFile[] files, RedirectAttributes reAttr) {
		logger.info("-----------updatePOST()호출: vo = "+vo.toString()+"-----------");
		
		String img="";
		for(MultipartFile f: files) {
			img += saveUploadFile(f)+ "";
		}
		logger.info("파일 저장 경로" + uploadPath);
		logger.info("img = " + img);
		vo.setEventUrl(img);
		
		
		int result = EventService.update(vo);
		if(result ==1) {
			
			return "redirect:/event/eventlist";
			// /board/list 경로로 이동. get 방식
			// get 방식이므로 page로 보내는 방식 가능
		}else {
			return "redirect:/event/eventupdate?event="+ vo.getEventId();
		}
		
	}//end updatePOST
	
	@PostMapping("/eventdelete")
	public String delete(Integer eventId, RedirectAttributes reAttr) {
		logger.info("-----------delete()호출: productId = "+eventId+"-----------");
		int result = EventService.delete(eventId);
		if(result==1) {
			reAttr.addFlashAttribute("delete_result", "success"); 
			
			return "redirect:/event/eventlist";
			// reAttr.addFlashAttribute("insert_result", "success");  alert띄우고 싶으면 insert 부분 참고!
			// 설정된 값들의 경로가 list로 가기때문에 list.jsp에 관련 jquery를 작성한다  
		}else {
			return "redirect:/event/eventdetail";
		}
	}//end delete
	
	
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
