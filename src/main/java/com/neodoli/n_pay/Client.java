package com.neodoli.n_pay;

import retrofit2.Retrofit;

public class Client {

	private String apiKey;
	private String publicKey;
	private Environment envMode;
	
	/**
	 * setting the platform to use the framework, by default will be java.
	 * This will dictate the way the bearer token will be create because at some point,
	 * android don't support all java cryptography library
	 * */
	private Platform platform=Platform.JAVA;

	public Client(/** set the development or production mode*/Environment environment) {
		// TODO Auto-generated constructor stub
		this.envMode= environment;
	}

	
	public /*return Response*/ResponseBody execute(Request request) {
		RequestHandler reqquestHandler= new RequestHandler(this, request);
		return reqquestHandler.doSync();
	}
	
	public void enqueue(Request request, Callback callback){
		RequestHandler reqquestHandler= new RequestHandler(this, request);
		reqquestHandler.doAsync(callback);
	}


	public String getPublicKey() {
		return publicKey;
	}


	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}


	public String getApiKey() {
		return apiKey;
	}


	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public Environment getEnvMode() {
		return this.envMode;
	}


	public Platform getPlatform() {
		return platform;
	}


	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	
	
}
