package com.app.BankManagement.Response;

public class AccountResponse {
	
	private boolean status;
	private Object data;
	private int statusCode;
	private String message;
	private String errorMessage;
	
	public static class  AccountResponseResponseBuilder
	{
		private String message;
		private boolean status;
		private Object data;
		private int statusCode;
		private String errorMessage;
		
		public AccountResponseResponseBuilder setMessage(String message) {
			this.message = message;
			return this;
		}
		
		public AccountResponseResponseBuilder setStatus(boolean status) {
			this.status = status;
			return this;
		}
		
		public AccountResponseResponseBuilder setData(Object data) {
			this.data = data;
			return this;
		}
		
		public AccountResponseResponseBuilder setStatusCode(int statusCode) {
			this.statusCode = statusCode;
			return this;
		}
		
		public AccountResponse build() {
			return new AccountResponse(message,status,data,statusCode,errorMessage);
		}

		public AccountResponseResponseBuilder setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
			return this;
		}

	}
	
	public AccountResponse(String message, boolean status, Object data, int statusCode, String errorMessage) {
		super();
		this.message = message;
		this.status = status;
		this.data = data;
		this.statusCode = statusCode;
		this.errorMessage=errorMessage;
	}
	public boolean isStatus() {
		return status;
	}

	public Object getData() {
		return data;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}
	public String getErrorMessage() {
		return errorMessage;
	}

}
