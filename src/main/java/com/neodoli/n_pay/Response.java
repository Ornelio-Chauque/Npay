package com.neodoli.n_pay;

public class Response {
	
	private String transactionId;
	
	private String businessProductId;
	
	private String description;
	
	private String descriptionCode;
	
	private String conversactionId;

	public Response() {
		// TODO Auto-generated constructor stub
		
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBusinessProductId() {
		return businessProductId;
	}

	public void setBusinessProductId(String businessProductId) {
		this.businessProductId = businessProductId;
	}

	public String getDescriptionCode() {
		return descriptionCode;
	}

	public void setDescriptionCode(String descriptionCode) {
		this.descriptionCode = descriptionCode;
	}

	public String getConversactionId() {
		return conversactionId;
	}

	public void setConversactionId(String conversactionId) {
		this.conversactionId = conversactionId;
	}

}
