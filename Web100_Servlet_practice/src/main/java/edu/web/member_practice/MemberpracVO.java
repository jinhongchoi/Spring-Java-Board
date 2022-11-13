package edu.web.member_practice;

import java.util.Arrays;

public class MemberpracVO {
	
	// 주의) useBean을 위한 VO를 생성할 경우, parameter name과 변수명이 같아야 함
	// VO 에 변수명은 항상 소문자로 지을것! / _(언더 스코어) 사용하지 말것! 
	private String userid;
	private String password;
	private String email;
	private String emailAgree;
	private String[] interest;	//배열을 vo에 넣을때 이런식으로 넣기!
	private String phone;
	private String introduce;
	
	public MemberpracVO() {
	
	}

	public MemberpracVO(String userid, String password, String email, String emailAgree, String[] interest,
			String phone, String introduce) {
		super();
		this.userid = userid;
		this.password = password;
		this.email = email;
		this.emailAgree = emailAgree;
		this.interest = interest;
		this.phone = phone;
		this.introduce = introduce;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailAgree() {
		return emailAgree;
	}

	public void setEmailAgree(String emailAgree) {
		this.emailAgree = emailAgree;
	}

	public String[] getInterest() {
		return interest;
	}

	public void setInterest(String[] interest) {
		this.interest = interest;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	@Override
	public String toString() {
		return "MemberpracVO [userid=" + userid + ", password=" + password + ", email=" + email + ", emailAgree="
				+ emailAgree + ", interest=" + Arrays.toString(interest) + ", phone=" + phone + ", introduce="
				+ introduce + "]";
	}

	public String getInterestJoin() {
		String result = (interest ==null) ? "없음" : String.join(",", interest);//사망 연산자 찾아보기
		
		return result;
	}
	

}//end MemberpracVO
