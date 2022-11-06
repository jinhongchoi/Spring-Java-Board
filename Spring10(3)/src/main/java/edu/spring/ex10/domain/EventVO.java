package edu.spring.ex10.domain;

public class EventVO {
	
	private int eventId;
	private String eventName;
	private int eventPrice;
	private String eventDesc;
	private String eventUrl;
	private String eventPhoto ;
	
	public EventVO() {
		// TODO Auto-generated constructor stub
	}

	public EventVO(int eventId, String eventName, int eventPrice, String eventDesc, String eventUrl,
			String eventPhoto) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventPrice = eventPrice;
		this.eventDesc = eventDesc;
		this.eventUrl = eventUrl;
		this.eventPhoto = eventPhoto;
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

	public String getEventDesc() {
		return eventDesc;
	}

	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}

	public String getEventUrl() {
		return eventUrl;
	}

	public void setEventUrl(String eventUrl) {
		this.eventUrl = eventUrl;
	}

	public String getEventPhoto() {
		return eventPhoto;
	}

	public void setEventPhoto(String eventPhoto) {
		this.eventPhoto = eventPhoto;
	}

	@Override
	public String toString() {
		return "EventVO [eventId=" + eventId + ", eventName=" + eventName + ", eventPrice=" + eventPrice
				+ ", eventDesc=" + eventDesc + ", eventUrl=" + eventUrl + ", eventPhoto=" + eventPhoto + "]";
	}
	
		
}
