package com.fulgorithm.first.orderManagement.shared.dto;

public class RegistrationDto {
	
	private long id;
	private String userId;
	private String userName;
	private String email;
	private String password;
	private String encryptedPassword;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	@Override
	public String toString() {
		return "RegistrationDto [id=" + id + ", userId=" + userId + ", userName=" + userName + ", email=" + email
				+ ", password=" + password + ", encryptedPassword=" + encryptedPassword + "]";
	}
    
	
}
