package edu.spring.ex10.domain;

public class PayProductVO {
	
	private int payDetailNum;	
	private int productId;
	private int amount;
	private String userId;
	private String userName;
	private String productName;
	private String productUrl;
	private int productPrice;
	private int money;
	
	public PayProductVO() {
		// TODO Auto-generated constructor stub
	}

	public PayProductVO(int payDetailNum, int productId, int amount, String userId, String userName, String productName,
			String productUrl, int productPrice, int money) {
		super();
		this.payDetailNum = payDetailNum;
		this.productId = productId;
		this.amount = amount;
		this.userId = userId;
		this.userName = userName;
		this.productName = productName;
		this.productUrl = productUrl;
		this.productPrice = productPrice;
		this.money = money;
	}

	public int getPayDetailNum() {
		return payDetailNum;
	}

	public void setPayDetailNum(int payDetailNum) {
		this.payDetailNum = payDetailNum;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "PayProductVO [payDetailNum=" + payDetailNum + ", productId=" + productId + ", amount=" + amount
				+ ", userId=" + userId + ", userName=" + userName + ", productName=" + productName + ", productUrl="
				+ productUrl + ", productPrice=" + productPrice + ", money=" + money + "]";
	}
	
	
	

}
