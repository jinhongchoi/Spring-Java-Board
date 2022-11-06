package edu.spring.ex10.domain;

public class ECartVO {
	
	private int ecartId; // 장바구니 번호 
	private String userId; // 사용자 아이디
	private String userName; // 사용자 이름
	private int eventId; // 상품 번호
	private String eventName; // 상품 이름
	private int eventPrice; // 상품 단가	
	private String eventUrl; // 상품이미지
	
	public ECartVO() {
		// TODO Auto-generated constructor stub
	}

	public ECartVO(int ecartId, String userId, String userName, int eventId, String eventName, int eventPrice,
			String eventUrl) {
		super();
		this.ecartId = ecartId;
		this.userId = userId;
		this.userName = userName;
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventPrice = eventPrice;
		this.eventUrl = eventUrl;
	}

	public int getEcartId() {
		return ecartId;
	}

	public void setEcartId(int ecartId) {
		this.ecartId = ecartId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getEventPrice() {
		return eventPrice;
	}

	public void setEventPrice(int eventPrice) {
		this.eventPrice = eventPrice;
	}

	public String getEventUrl() {
		return eventUrl;
	}

	public void setEventUrl(String eventUrl) {
		this.eventUrl = eventUrl;
	}

	@Override
	public String toString() {
		return "ECartVO [ecartId=" + ecartId + ", userId=" + userId + ", userName=" + userName + ", eventId=" + eventId
				+ ", eventName=" + eventName + ", eventPrice=" + eventPrice + ", eventUrl=" + eventUrl + "]";
	}
	
	
	
}
