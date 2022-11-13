package edu.web.board.controller_prac;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import edu.web.board.domain.ReplyVO;
import edu.web.board.persistence.ReplyDAO;
import edu.web.board.persistence.ReplyDAOImple;


@WebServlet("/replies/*")
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReplyDAO dao;
    
    public ReplyController() {
    	dao=ReplyDAOImple.getinstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		controlUri(request, response);
		
	}//end doGet


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		controlUri(request, response);
	}//end doPost

	private void controlUri(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requsetURI= request.getRequestURI();
		System.out.println(requsetURI);
		
		if(requsetURI.contains("add")) {
			System.out.println("-------------add 호출 확인-------------");
			replyadd(request,response);
		}else if(requsetURI.contains("all")) {
			System.out.println("-------------all 호출 확인-------------");
			replyall(request, response);
		}else if(requsetURI.contains("update")) {
			System.out.println("-------------update 호출 확인-------------");
			update(request, response);
		}else if(requsetURI.contains("delete")) {
			System.out.println("-------------delete 호출 확인-------------");
			delete(request, response);
		}
		
	}//end controlUri


	private void replyadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String obj= request.getParameter("obj");
		System.out.println(obj);
		JSONParser parser = new JSONParser(); //simple jsonparser로 import 한다!
		
		JSONObject jsonObject;
		
		
		try {
			jsonObject = (JSONObject)parser.parse(obj);
			System.out.println(jsonObject);
			
			int boardId= Integer.parseInt((String)jsonObject.get("boardId"));
			String memberId = (String)jsonObject.get("memberId");
			String replyContent = (String)jsonObject.get("replyContent");
			
			ReplyVO vo = new ReplyVO(0, boardId, memberId, replyContent, null);
			System.out.println(vo + "controller");
			
			int result = dao.insert(vo);
			if(result ==1) {
				response.getWriter().append("success");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}//end replyadd
	
	private void replyall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		List<ReplyVO>list = dao.select(boardId);
		
		JSONArray jsonArray = new JSONArray();
		
		for(int i=0; i<list.size(); i++) {
			JSONObject jsonObject= new JSONObject();
			ReplyVO vo= list.get(i);
			
			jsonObject.put("replyId", vo.getReplyId());
			jsonObject.put("boardId", vo.getBoardId());
			jsonObject.put("memberId", vo.getMemberId());
			jsonObject.put("replyContent", vo.getReplyContent());
			jsonObject.put("replyDateCreated", vo.getReplyDateCreated().toString());
			
			jsonArray.add(jsonObject);
						
		}
		
		System.out.println(jsonArray.toString());
		response.getWriter().append(jsonArray.toString());
		
	}//end replayall
	
	

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		int replyId = Integer.parseInt(request.getParameter("replyId")) ;
		String replyContent = request.getParameter("replyContent");
		
		ReplyVO vo= new ReplyVO(replyId, 0, null, replyContent, null);
		int result= dao.update(vo);
		
		if(result== 1) {
			response.getWriter().append("success");
		}
		
	}//end update

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int replyId = Integer.parseInt(request.getParameter("replyId")) ;
		
		int result = dao.delete(replyId);
		if(result== 1) {
			response.getWriter().append("success");
		}
		
	}//end delete
	
}









