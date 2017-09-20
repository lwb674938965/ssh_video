package com.zhiyou100.ssh.video.model;

public class Result {
	
	private Boolean orSuccess;
	
	private String message;

	public Boolean getOrSuccess() {
		return orSuccess;
	}

	public void setOrSuccess(Boolean orSuccess) {
		this.orSuccess = orSuccess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Result [orSuccess=" + orSuccess + ", message=" + message + "]";
	}
	
	

}
