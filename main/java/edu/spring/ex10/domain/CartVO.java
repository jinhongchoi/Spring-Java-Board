package edu.spring.ex10.domain;

public class CartVO {
	
	private int cartId; // 장바구니 번호 
	private String userId; // 사용자 아이디
	private String userName; // 사용자 이름
	private int productId; // 상품 번호
	private String productName; // 상품 이름
	private int productPrice; // 상품 단가
	private int amount; // 구매 수량
	private int money; // 상품 가격
	private String productUrl; // 상품이미지
	
	public CartVO() {
		// TODO Auto-generated constructor stub
	}

	public CartVO(int cartId, String userId, String userName, int productId, String productName, int productPrice,
			int amount, int money, String productUrl) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.userName = userName;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.amount = amount;
		this.money = money;
		this.productUrl = productUrl;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	@Override
	public String toString() {
		return "CartVO [cartId=" + cartId + ", userId=" + userId + ", userName=" + userName + ", productId=" + productId
				+ ", productName=" + productName + ", productPrice=" + productPrice + ", amount=" + amount + ", money="
				+ money + ", productUrl=" + productUrl + "]";
	}
	
	
}
