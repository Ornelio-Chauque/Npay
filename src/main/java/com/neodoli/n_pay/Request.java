package com.neodoli.n_pay;

public class Request {
	
	//A String that represent the transction
	private String transactionId;
	// The amount to be send to business account
	private String amount;
	// internal representation of object 
	private String businessProductId;
	// A string that represent the custumer account or number 
	private String senderAccount;
	//value that represent the business number
	private String receiverAccount;
	/**
	 * used to specify the transaction type ex: Enviorment.PRODUCTION */ 
	private TransactionType transactionType;
	

	private Request(String transactionId,
					String amount, 
					String businessProductId, 
					String senderAccount, 
					String receiverAccount,
					TransactionType transactionType ){
		
		this.transactionId=transactionId;
		this.amount=amount;
		this.businessProductId=businessProductId;
		this.senderAccount=senderAccount;
		this.receiverAccount=receiverAccount;
		this.transactionType=transactionType;
	}
	
	protected TransactionType getTransactionType() {
		return this.transactionType;
	}
	
	public String getTransactionId() {
		return transactionId;
	}

	public String getAmount() {
		return amount;
	}

	public String getBusinessProductId() {
		return businessProductId;
	}

	public String getSenderAccount() {
		return senderAccount;
	}

	public String getReceiverAccount() {
		return receiverAccount;
	}

	public static class Builder{
	
		String transactionId;
		String amount;
		String businessProductId;
		String senderAccount;
		String receiverAccount;
		TransactionType transactionType;
		
		
		public Builder transactionType(TransactionType transactionType) {
			this.transactionType=transactionType;
			return this;
		}
		
		public Builder amount(String amount) {
			this.amount=amount;
			return this;
		}
		
		public Builder transactionId(String transactionId) {
			this.transactionId=transactionId;
			return this;
		}
		public Builder businessProductId(String businessProductId) {
			this.businessProductId=businessProductId;
			return this;
		}
		
		public Builder senderAccount(String senderAccount) {
			this.senderAccount=senderAccount;
			return this;
			
		}
		
		public Builder receiverAccount(String receiverAccount) {
			this.receiverAccount=receiverAccount;
			return this;
		}
		
		
		public Request build(){
		
			return new Request(this.transactionId, 
							   this.amount, 
							   this.businessProductId, 
							   this.senderAccount, 
							   this.receiverAccount, 
							   this.transactionType);
		}
		
	}
	

}
