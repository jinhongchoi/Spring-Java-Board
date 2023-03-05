package my.practice.freeboard.domain;

import java.sql.Date;

public class BoardVO {
	
	private int boardId;
	private String boardTitle;
	private String boardContent;
	private String memberId;
	private Date boardDateCreated;
	private int replyCnt;
	private String keyword;
	private String searchType;
	
	public BoardVO() {
		
	}// 기본 생성자

	public BoardVO(int boardId, String boardTitle, String boardContent, String memberId, Date boardDateCreated,
			int replyCnt, String keyword, String searchType) {
		super();
		this.boardId = boardId;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.memberId = memberId;
		this.boardDateCreated = boardDateCreated;
		this.replyCnt = replyCnt;
		this.keyword = keyword;
		this.searchType = searchType;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getBoardDateCreated() {
		return boardDateCreated;
	}

	public void setBoardDateCreated(Date boardDateCreated) {
		this.boardDateCreated = boardDateCreated;
	}

	public int getReplyCnt() {
		return replyCnt;
	}

	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	@Override
	public String toString() {
		return "BoardVO [boardId=" + boardId + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", memberId=" + memberId + ", boardDateCreated=" + boardDateCreated + ", replyCnt=" + replyCnt
				+ ", keyword=" + keyword + ", searchType=" + searchType + "]";
	}

		
	
}
