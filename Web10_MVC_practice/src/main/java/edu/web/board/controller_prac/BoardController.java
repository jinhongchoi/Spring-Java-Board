package edu.web.board.controller_prac;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.board.domain.BoardVO;
import edu.web.board.persistence.BoardDAO;
import edu.web.board.persistence.BoardDAOImple;
import edu.web.util.PageMaker;
import edu.web.util.PageCriteria;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static BoardDAO dao;

	private static final String BOARD_URL = "WEB-INF/board/";
	private static final String MAIN = "index";
	private static final String LIST = "list";
	private static final String REGISTER = "register";
	private static final String DETAIL = "detail";
	private static final String UPDATE = "update";
	private static final String DELETE = "delete";
	private static final String EXTENSION = ".jsp";
	private static final String SERVER_EXTENSION = ".do";

	public BoardController() {
		dao = BoardDAOImple.getinstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		controlURI(request, response);
	}// end doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		controlURI(request, response);
	}// end doPost

	private void controlURI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestURI = request.getRequestURI();
		String requestMethod = request.getMethod();

		System.out.println("호출 경로: " + requestURI);
		System.out.println("호출 방식: " + requestMethod);

		if (requestURI.contains(LIST + SERVER_EXTENSION)) {
			System.out.println("-----------list 호출 확인 -----------");
			list(request, response);
		} else if (requestURI.contains(REGISTER + SERVER_EXTENSION)) {
			System.out.println("-----------register 호출 확인 -----------");
			if (requestMethod.contains("GET")) {
				registerGET(request, response);
			} else if (requestMethod.contains("POST")) {
				registerPOST(request, response);
			}
		} else if (requestURI.contains(DETAIL + SERVER_EXTENSION)) {
			System.out.println("-----------detail 호출 확인 -----------");
			detail(request, response);
		} else if (requestURI.contains(UPDATE + SERVER_EXTENSION)) {
			System.out.println("-----------update 호출 확인 -----------");
			if (requestMethod.contains("GET")) {
				updateGET(request, response);
			} else if (requestMethod.contains("POST")) {
				updatePOST(request, response);
			}
		} else if(requestURI.contains(DELETE+SERVER_EXTENSION)) {
			System.out.println("-----------detail 호출 확인 -----------");
			delete(request, response);
		}

	}// end controlURI


	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		List<BoardVO> list = dao.select();
		String page= request.getParameter("page");
		PageCriteria criteria= new PageCriteria();
		if(page!=null) {
			criteria.setPage(Integer.parseInt(page));
		}
		List<BoardVO>list= dao.select(criteria);
		
		String path = BOARD_URL + LIST + EXTENSION;
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		request.setAttribute("list", list);
		
		PageMaker pageMaker = new PageMaker(); //전송이 되었으므로 PageMaker 이걸 사용하려면 pageMaker 로 사용한다!
		pageMaker.setCriteria(criteria); // 현재 페이지 번호 및 한 페이지 당 게시글 정보 저장
		int totalCount = dao.getTotalCounts(); // 전체 게시글 수
		pageMaker.setTotalCount(totalCount); // 전체 게시글 수 저장
		pageMaker.setPageData(); // 저장된 데이터를 바탕으로 page 링크 데이터 저장
		System.out.println("전체 게시글 수: " + pageMaker.getTotalCount());
		System.out.println("현재 선택된 페이지: " + criteria.getPage());
		System.out.println("한 페이지당 게시글 수: " + criteria.getNumsPerPage());
		System.out.println("페이지 링크 번호 개수: " + pageMaker.getNumsOfPageLinks());
		System.out.println("시작 페이지 링크 번호: " + pageMaker.getStartPageNo());
		System.out.println("끝 페이지 링크 번호: " + pageMaker.getEndPageNo());
		System.out.println("이전 버튼 존재 유무: "+ pageMaker.isHasPrev());
		System.out.println("다음 버튼 존재 유무: "+ pageMaker.isHasNext());
		//위의 문단 공부!
		
		
		request.setAttribute("pageMaker", pageMaker); //request로 pageMaker를 보낸다!
		dispatcher.forward(request, response);

	}// end list

	private void registerGET(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = BOARD_URL + REGISTER + EXTENSION;
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);

	}// end registerGET

	private void registerPOST(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String boardTitle = request.getParameter("boardTitle");
		String memberId = request.getParameter("memberId");
		String boardContent = request.getParameter("boardContent");

		BoardVO vo = new BoardVO(0, boardTitle, boardContent, memberId, null);
		System.out.println(vo);

		int result = dao.insert(vo);
		System.out.println(result + "행이 삽입되었습니다.");
		if (result == 1) {
			PrintWriter out = response.getWriter();
			out.print("<head>" + "<meta charset='UTF-8'>" + "</head>");
			out.print("<script>alert('게시글 동록 성공')</script>");
			out.print("<script>location.href='" + MAIN + EXTENSION + "';</script>");
		}

	}// end registerPOST

	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int boardId = Integer.parseInt(request.getParameter("boardId"));
		BoardVO vo = dao.select(boardId);
		System.out.println(vo);

		String path = BOARD_URL + DETAIL + EXTENSION;
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		request.setAttribute("vo", vo);
		dispatcher.forward(request, response);

	}// end detail

	private void updateGET(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		BoardVO vo= dao.select(boardId);
		//updateGET은 jsp화면을 띄우는 메소드이므로 update.jsp에 띄울 화면에 값이 나타나게 하기 위해서는
		// select()로 값을 가져와야한다!
		
		String path = BOARD_URL + UPDATE + EXTENSION;
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		request.setAttribute("vo", vo);
		dispatcher.forward(request, response);

	}// end updateGET

	private void updatePOST(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		String boardTitle = request.getParameter("boardTitle");
		
		String boardContent = request.getParameter("boardContent");

		BoardVO vo = new BoardVO(boardId, boardTitle, boardContent, null, null);
		System.out.println(vo);

		int result = dao.update(vo);
		System.out.println(result + "행이 수정되었습니다.");
		if (result == 1) {
			PrintWriter out = response.getWriter();
			out.print("<head>" + "<meta charset='UTF-8'>" + "</head>");
			out.print("<script>alert('게시글 수정 성공')</script>");
			out.print("<script>location.href='" + DETAIL + SERVER_EXTENSION + "?boardId="+boardId +"';</script>");
			//업데이트 하고 보낼때 경로 주의하기!!

		} 

	}// end updatePOST
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int boardId= Integer.parseInt(request.getParameter("boardId"));
		
		int result = dao.delete(boardId);
		System.out.println(result + "행이 삭제되었습니다.");
		if (result == 1) {
			PrintWriter out = response.getWriter();
			out.print("<head>" + "<meta charset='UTF-8'>" + "</head>");
			out.print("<script>alert('게시글 삭제 성공')</script>");
			out.print("<script>location.href='" + MAIN + EXTENSION + "';</script>");

		} 
		
	}//end delete
	
}// end controller
