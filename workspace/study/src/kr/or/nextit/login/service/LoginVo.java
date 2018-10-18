package kr.or.nextit.login.service;

import java.io.Serializable;

public class LoginVo implements Serializable {

	private String userName;
	private String userId;
	private String userPw;
	private String userEmail;
	private String userRemember;

	private boolean result;
	private String message;

	public LoginVo() {

	}

	public LoginVo(String userName, String userId, String userPw, String userEmail) {
		this.userName = userName;
		this.userId = userId;
		this.userPw = userPw;
		this.userEmail = userEmail;
		
	}

	public String getMessage() {
		return message;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPw() {
		return userPw;
	}

	public String getUserRemember() {
		return userRemember;
	}

	public boolean isResult() {
		return result;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public void setUserRemember(String userRemember) {
		this.userRemember = userRemember;
	}

}
