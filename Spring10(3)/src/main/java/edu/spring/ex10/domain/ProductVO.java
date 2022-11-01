package edu.spring.ex10.domain;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class ProductVO {
	
	private int productId;
	private String productName;
	private int productPrice;
	private String productDesc;
	private String productUrl;
	private String productPhoto ;
	private String productCate;
	
	public ProductVO() {
		
	}// 기본 생성자

	public ProductVO(int productId, String productName, int productPrice, String productDesc, String productUrl,
			String productPhoto, String productCate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDesc = productDesc;
		this.productUrl = productUrl;
		this.productPhoto = productPhoto;
		this.productCate = productCate;
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

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getProductPhoto() {
		return productPhoto;
	}

	public void setProductPhoto(String productPhoto) {
		this.productPhoto = productPhoto;
	}

	public String getProductCate() {
		return productCate;
	}

	public void setProductCate(String productCate) {
		this.productCate = productCate;
	}

	@Override
	public String toString() {
		return "ProductVO [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productDesc=" + productDesc + ", productUrl=" + productUrl + ", productPhoto=" + productPhoto
				+ ", productCate=" + productCate + "]";
	}

	
	
		
}
