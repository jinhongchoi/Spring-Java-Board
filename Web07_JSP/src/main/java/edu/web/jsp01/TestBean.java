package edu.web.jsp01;

public class TestBean {
	private String msg= "test useBean";
	
	public TestBean() {
		// TODO Auto-generated constructor stub
	}

	public TestBean(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "TestBean [msg=" + msg + "]";
	}
	
	
}
