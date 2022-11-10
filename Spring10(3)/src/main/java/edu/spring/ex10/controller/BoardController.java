package edu.spring.ex10.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import edu.spring.ex10.domain.BoardVO;
import edu.spring.ex10.pageutil.PageCriteria;
import edu.spring.ex10.pageutil.PageMaker;
import edu.spring.ex10.service.BoardService;


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
	
	@GetMapping("/list")
	public void list(Model model, Integer page, Integer numsPerPage) {
		logger.info("-----------list()호출-----------");
		logger.info("page = "+page + ", numsPerPage = "+ numsPerPage);
		
		//paging 처리
		PageCriteria criteria = new PageCriteria();
		if(page != null) {
			criteria.setPage(page);
		}
		
		if(numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}
		//위에 부분 순서 바꿔서 쓰거나 하지 말기! 정확히 쓰기!
		
		List<BoardVO>list =  boardService.read(criteria);
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
	
	
}//end BoardController












