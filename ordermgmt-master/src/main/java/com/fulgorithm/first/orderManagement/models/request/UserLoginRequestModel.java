package com.fulgorithm.first.orderManagement.models.request;

import javax.validation.constraints.NotEmpty;

public class UserLoginRequestModel {
	@NotEmpty(message = "{username.not.empty}")
	private String username;

	@NotEmpty(message = "{password.not.empty}")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
