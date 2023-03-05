package my.practice.freeboard.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



import my.practice.freeboard.domain.BoardVO;
import my.practice.freeboard.pageutill.PageCriteria;
import my.practice.freeboard.pageutill.PageMaker;
import my.practice.freeboard.service.BoardService;


@Controller
// * 표현계층(Presentation Layer)
// - view(페이지)와 service를 연결하는 역할
// - request에 대한 response를 전달하는 역할

@RequestMapping(value="/board") // url: /ex02/board 
// -> servlet에서 @webservlet 개념
// 시작하는 경로의 대표 경로
public class BoardController {
	private static final Logger logger =
			LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	//@RequestMapping(value="/list", method = {RequestMethod.GET, RequestMethod.POST})
	@GetMapping("/list")
	public void list(Model model, Integer page, Integer numsPerPage, 
			@RequestParam(value="searchType" ,required= false, defaultValue = "title")String searchType, 
			@RequestParam(value="keyword", required= false, defaultValue = "")String keyword 
			)throws Exception
	{
		logger.info("-----------list()호출-----------");
		//logger.info("page = "+page + ", numsPerPage = "+ numsPerPage);
		
		
		PageCriteria criteria = new PageCriteria();
		if(page != null) {criteria.setPage(page); }
		  
		if(numsPerPage != null) { criteria.setNumsPerPage(numsPerPage); } 
		 		
		List<BoardVO> list = boardService.selectBykeyword(searchType, keyword);		 
	    model.addAttribute("list", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(boardService.getTotalCount());
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);				
	}//end list
	

	@GetMapping("/register")
	public void registerGET() {
		logger.info("-----------registerGET()호출-----------");
	}//end registerGET()
	
	@PostMapping("/register")
	public String registerPOST(BoardVO vo, RedirectAttributes reAttr) {
		// RedirectAttributes
		// - 새로운 경로 위치에 속성값을 전송하는 객체
		logger.info("-----------registerPOST()호출-----------");
		logger.info(vo.toString());
		int result= boardService.create(vo);
		logger.info(result+ "행 삽입");
		if(result==1) {
			reAttr.addFlashAttribute("insert_result", "success"); 
			// insert_result가 list.jsp로 가고 success라는 문구가 jsp에 전달되면 jsp에서 처리함
			return "redirect:/board/list"; // /board/list 경로로 이동. get 방식
		}else {
			return "redirect:/board/register";
		}
		
	}//end registerPOST()
	
	@GetMapping("/detail") //detail을 가져오는게  get 방식이기 때문에 GetMapping을 사용한다
	public void detail(Model model, Integer boardId, Integer page) {
		logger.info("-----------detail()호출: boardId= " + boardId +"-----------");
		BoardVO vo = boardService.read(boardId);
		model.addAttribute("vo", vo);
		model.addAttribute("page",page); 
		// model을 이용해 jsp로 보낸다!
		// 기존의 servlet 에서 request.setAttribute() 이거와 같음 -> request나 session과 같은 개념!
		
	}//end detail
	
	@GetMapping("/update")
	public void updateGET(Model model, Integer boardId, Integer page) {
		logger.info("-----------updateGET()호출: boardId = "+boardId+"-----------");
		BoardVO vo = boardService.read(boardId); //페이지에 보낼 정보들을 boardService를 통해서 필요한 정보들 가져온다.
		model.addAttribute("vo", vo);
		model.addAttribute("page", page); // 가져온 정보들을 model에 담아 페이지로 전송함!(항상 이렇게 하는듯?)
	}//end updateGET
	
	@PostMapping("/update")
	public String updatePOST(BoardVO vo, Integer page, RedirectAttributes reAttr) {
		logger.info("-----------updatePOST()호출: vo = "+vo.toString()+"-----------");
		int result = boardService.update(vo);
		if(result ==1) {
			
			return "redirect:/board/detail?boardId="+ vo.getBoardId();
			// /board/list 경로로 이동. get 방식
			// get 방식이므로 page로 보내는 방식 가능
		}else {
			return "redirect:/board/update?boardId="+ vo.getBoardId();
		}
		
	}//end updatePOST
	
	@PostMapping("/delete")
	public String delete(Integer boardId, RedirectAttributes reAttr) {
		logger.info("-----------delete()호출: boardId = "+boardId+"-----------");
		int result = boardService.delete(boardId);
		if(result==1) {
			reAttr.addFlashAttribute("delete_result", "success"); 
			
			return "redirect:/board/list";
			// reAttr.addFlashAttribute("insert_result", "success");  alert띄우고 싶으면 insert 부분 참고!
			// 설정된 값들의 경로가 list로 가기때문에 list.jsp에 관련 jquery를 작성한다  
		}else {
			return "redirect:/board/list";
		}
	}//end delete
	
	
}//end BoardController












