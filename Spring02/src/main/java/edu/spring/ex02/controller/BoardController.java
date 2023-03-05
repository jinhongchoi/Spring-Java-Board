package edu.spring.ex02.controller;

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

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PageCriteria;
import edu.spring.ex02.pageutil.PageMaker;
import edu.spring.ex02.service.BoardService;

@Controller
// * ǥ������(Presentation Layer)
// - view(������)�� service�� �����ϴ� ����
// - request�� ���� response�� �����ϴ� ����

@RequestMapping(value="/board") // url: /ex02/board 
// -> servlet���� @webservlet ����
// �����ϴ� ����� ��ǥ ���
public class BoardController {
	private static final Logger logger =
			LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public void list(Model model, Integer page, Integer numsPerPage) {
		logger.info("-----------list()ȣ��-----------");
		logger.info("page = "+page + ", numsPerPage = "+ numsPerPage);
		
		//paging ó��
		PageCriteria criteria = new PageCriteria();
		if(page != null) {
			criteria.setPage(page);
		}
		
		if(numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}
		//���� �κ� ���� �ٲ㼭 ���ų� ���� ����! ��Ȯ�� ����!
		
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
		logger.info("-----------registerGET()ȣ��-----------");
	}//end registerGET()
	
	@PostMapping("/register")
	public String registerPOST(BoardVO vo, RedirectAttributes reAttr) {
		// RedirectAttributes
		// - ���ο� ��� ��ġ�� �Ӽ����� �����ϴ� ��ü
		logger.info("-----------registerPOST()ȣ��-----------");
		logger.info(vo.toString());
		int result= boardService.create(vo);
		logger.info(result+ "�� ����");
		if(result==1) {
			reAttr.addFlashAttribute("insert_result", "success"); 
			// insert_result�� list.jsp�� ���� success��� ������ jsp�� ���޵Ǹ� jsp���� ó����
			return "redirect:/board/list"; // /board/list ��η� �̵�. get ���
		}else {
			return "redirect:/board/register";
		}
		
	}//end registerPOST()
	
	@GetMapping("/detail") //detail�� �������°�  get ����̱� ������ GetMapping�� ����Ѵ�
	public void detail(Model model, Integer boardId, Integer page) {
		logger.info("-----------detail()ȣ��: boardId= " + boardId +"-----------");
		BoardVO vo = boardService.read(boardId);
		model.addAttribute("vo", vo);
		model.addAttribute("page",page); 
		// model�� �̿��� jsp�� ������!
		// ������ servlet ���� request.setAttribute() �̰ſ� ���� -> request�� session�� ���� ����!
		
	}//end detail
	
	
}//end BoardController












