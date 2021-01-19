package com.neodoli.n_pay;

import java.io.IOException;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Response;

public class RequestHandler {
	
	private final String PRODUCTION_HOST="https://api.vm.co.mz";
	private final String DEVELOPMENT_HOST="https://api.sandbox.vm.co.mz";
	private final int C2B_PORT=18352;
	private final int B2C_PORT=18345;
	private final int B2B_PORT=18349;
	private final String C2B_PATH="c2bPayment/singleStage/";
	private final String B2C_PATH="b2bPayment/";
	private final String B2B_PATH="b2bPayment/";
	
	private Client client;
	private Request request;
	private Callback cb;
	
	public RequestHandler(Client client, Request req) {
		this.client =client;
		this.request=req;
	}
	
	public RequestHandler() {
		// TODO Auto-generated constructor stub
	}
	
	
	protected void doAsync(Callback cb) {
		this.cb=cb;  
		RequestBody requestBody=null;
	
		switch(client.getEnvMode()){
			
			case  DEVELOPMENT:
				
				if(request.getTransactionType()==TransactionType.C2B) {
					 requestBody=new RequestBodyFactory(request).factory(BodyType.C2B);
					 asyncRequestHandler(DEVELOPMENT_HOST, C2B_PORT, C2B_PATH, requestBody);
					
				}else 
					if(request.getTransactionType()==TransactionType.B2C) {
						
						 requestBody=new RequestBodyFactory(request).factory(BodyType.C2B);
						 asyncRequestHandler(DEVELOPMENT_HOST, B2C_PORT, B2C_PATH, requestBody);
					
				}else 
					if(request.getTransactionType()==TransactionType.B2B) {
						
						 requestBody=new RequestBodyFactory(request).factory(BodyType.C2B);
						 asyncRequestHandler(DEVELOPMENT_HOST, B2B_PORT, B2B_PATH, requestBody);
					
				}else {
					
				}
			
				break;
				
			case PRODUCTION:
				

				if(request.getTransactionType()==TransactionType.C2B){
					
					return; 
				}else 
					if(request.getTransactionType()==TransactionType.B2C) {
					
				}else 
					if(request.getTransactionType()==TransactionType.B2B) {
					
				}else {
					
				}
				break;
			
		}
		
	}
	
	protected  ResponseBody doSync(){
		
		switch(client.getEnvMode()){
		
		case  DEVELOPMENT:
			
			if(request.getTransactionType()==TransactionType.C2B){
				
				
				
			}else 
				if(request.getTransactionType()==TransactionType.B2C) {
					
				
				
			}else 
				if(request.getTransactionType()==TransactionType.B2B) {
					
				
				
			}else {
				
			}
		
			break;
			
		case PRODUCTION:
			

			if(request.getTransactionType()==TransactionType.C2B){
				
				
			}else 
				if(request.getTransactionType()==TransactionType.B2C) {
				
			}else 
				if(request.getTransactionType()==TransactionType.B2B) {
				
			}else {
				
			}
			break;
		
	}
	
		return null;
	}
	


	private void asyncRequestHandler(String host, int port, String path, RequestBody reqBody){
	
		Call<ResponseBody>call=new RetrofitCall(client).call( host,  port,  path,  reqBody);
		
		call.enqueue(new retrofit2.Callback<ResponseBody>() {

			public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
				// TODO Auto-generated method stub
				
				if(response.isSuccessful()) {
					System.out.println("OK");
					cb.onSuccess(response.body());
				}else {
					try {
						
						ResponseBody resBody= parseResponseBody(response.errorBody().string());
						cb.onSuccess(resBody);
						
					} catch (IOException e) {
						//TODO Auto-generated catch block
						e.printStackTrace();
						cb.onFailure(e);
					}
					
				}
			
			}

			public void onFailure(Call<ResponseBody> call, Throwable t) {
				// TODO Auto-generated method stub
				System.out.println("error");
				call.timeout();
				cb.onFailure((Exception) t);
				
				//System.out.println(t.getMessage().toString());
			}
			
		});
	
	}
	
	private ResponseBody syncRequestHandler(String host, int port, String path, RequestBody reqBody){
		
		Call<ResponseBody>call=new RetrofitCall(client).call( host,  port,  path,  reqBody);;
		
		ResponseBody responseBody=null;
		try {
			Response<ResponseBody> response=call.execute();
			if(response.isSuccessful()) {
				responseBody =response.body();
				System.out.println("Success from aync");
			}else {
				System.out.println(response.errorBody().string());
				responseBody= parseResponseBody(response.errorBody().string());
				System.out.println("Error from sync ");
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return responseBody;
	}
	
	
	
	private ResponseBody parseResponseBody(String stringResponse) {
		Gson gson= new Gson();
		ResponseBody resBody=gson.fromJson(stringResponse, ResponseBody.class);
		System.out.println(resBody.getOutputConversationID()); 
		return resBody;
	}
	

}
