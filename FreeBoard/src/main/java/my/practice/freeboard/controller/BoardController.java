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
	
	//@RequestMapping(value="/list", method = {RequestMethod.GET, RequestMethod.POST})
	@GetMapping("/list")
	public void list(Model model, Integer page, Integer numsPerPage, 
			@RequestParam(value="searchType" ,required= false, defaultValue = "title")String searchType, 
			@RequestParam(value="keyword", required= false, defaultValue = "")String keyword 
			)throws Exception
	{
		logger.info("-----------list()ȣ��-----------");
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
	
	@GetMapping("/update")
	public void updateGET(Model model, Integer boardId, Integer page) {
		logger.info("-----------updateGET()ȣ��: boardId = "+boardId+"-----------");
		BoardVO vo = boardService.read(boardId); //�������� ���� �������� boardService�� ���ؼ� �ʿ��� ������ �����´�.
		model.addAttribute("vo", vo);
		model.addAttribute("page", page); // ������ �������� model�� ��� �������� ������!(�׻� �̷��� �ϴµ�?)
	}//end updateGET
	
	@PostMapping("/update")
	public String updatePOST(BoardVO vo, Integer page, RedirectAttributes reAttr) {
		logger.info("-----------updatePOST()ȣ��: vo = "+vo.toString()+"-----------");
		int result = boardService.update(vo);
		if(result ==1) {
			
			return "redirect:/board/detail?boardId="+ vo.getBoardId();
			// /board/list ��η� �̵�. get ���
			// get ����̹Ƿ� page�� ������ ��� ����
		}else {
			return "redirect:/board/update?boardId="+ vo.getBoardId();
		}
		
	}//end updatePOST
	
	@PostMapping("/delete")
	public String delete(Integer boardId, RedirectAttributes reAttr) {
		logger.info("-----------delete()ȣ��: boardId = "+boardId+"-----------");
		int result = boardService.delete(boardId);
		if(result==1) {
			reAttr.addFlashAttribute("delete_result", "success"); 
			
			return "redirect:/board/list";
			// reAttr.addFlashAttribute("insert_result", "success");  alert���� ������ insert �κ� ����!
			// ������ ������ ��ΰ� list�� ���⶧���� list.jsp�� ���� jquery�� �ۼ��Ѵ�  
		}else {
			return "redirect:/board/list";
		}
	}//end delete
	
	
}//end BoardController












