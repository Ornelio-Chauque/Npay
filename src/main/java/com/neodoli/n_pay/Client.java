package com.neodoli.n_pay;

public class Client {

	String enviornment;
	String transactionType;

	public Client(Environment enviorment) {
		// TODO Auto-generated constructor stub
	}

	
	public /*return Response*/Response execute(Request request) {
		
		return null;
	}
	
	public void enqueue(Request request, Callback callback){
		
		Request request1= request;
		callback.success(new Response());
		
	}
	
	
	static public enum TransactionType{
		C2B,
		B2C,
		B2B
	}
	
	
}
