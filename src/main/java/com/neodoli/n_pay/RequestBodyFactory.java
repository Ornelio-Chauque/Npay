package com.neodoli.n_pay;

public class RequestBodyFactory {
	
	private Request request;

	public RequestBodyFactory(Request req) {
		// TODO Auto-generated constructor stub
		request=req;
	}
	
	public  RequestBody factory(BodyType bodyType) {
		
		RequestBody reqBody=null;
		
		if(bodyType==BodyType.C2B) {
			
				
				if(!request.getSenderAccount().matches("258(\\d){9}")) {
					throw new IllegalArgumentException("Invalid Sender number");
				}
				
				if(request.getReceiverAccount().equals("")) {
					throw new IllegalArgumentException("Ivalid receiver account");
				}
				
				if(request.getAmount().equals("")) {
					throw new IllegalArgumentException("Invalid amount value");
				}
				
				if(request.getBusinessProductId().equals("")) {
					throw new IllegalArgumentException("Invalid third party reference values");
				}
				
				if(request.getTransactionId().equals("")) {
					throw new IllegalArgumentException("Invalid transaction Id");
				}
				
				reqBody= new RequestBody();
				System.out.println(request.getTransactionId()+" From generating");
				reqBody.setInputCustomerMSISDN(request.getSenderAccount());
				reqBody.setInputAmount(request.getAmount());
				reqBody.setInputServiceProviderCode(request.getReceiverAccount());
				reqBody.setInputThirdPartyReference(request.getBusinessProductId());
				reqBody.setInputTransactionReference(request.getTransactionId());
			
		}else if(bodyType==BodyType.B2C) {
			
			if(!request.getReceiverAccount().matches("258(\\d){9}")) {
				throw new IllegalArgumentException("Invalid Sender number");
			}
			
			if(request.getSenderAccount().equals("")) {
				throw new IllegalArgumentException("Ivalid receiver account");
			}
			
			if(request.getAmount().equals("")) {
				throw new IllegalArgumentException("Invalid amount value");
			}
			
			if(request.getBusinessProductId().equals("")) {
				throw new IllegalArgumentException("Invalid third party reference values");
			}
			
			if(request.getTransactionId().equals("")) {
				throw new IllegalArgumentException("Invalid transaction Id");
			}
		
			reqBody= new RequestBody();
			System.out.println(request.getTransactionId()+" From generating");
			reqBody.setInputCustomerMSISDN(request.getReceiverAccount());
			reqBody.setInputAmount(request.getAmount());
			reqBody.setInputServiceProviderCode(request.getSenderAccount());
			reqBody.setInputThirdPartyReference(request.getBusinessProductId());
			reqBody.setInputTransactionReference(request.getTransactionId());
			
		}else if (bodyType==BodyType.B2B) {
			
			if(!request.getSenderAccount().equals("")) {
				throw new IllegalArgumentException("Invalid Sender account");
			}
			
			if(request.getReceiverAccount().equals("")) {
				throw new IllegalArgumentException("Ivalid receiver account");
			}
			
			if(request.getAmount().equals("")) {
				throw new IllegalArgumentException("Invalid amount value");
			}
			
			if(request.getBusinessProductId().equals("")) {
				throw new IllegalArgumentException("Invalid third party reference values");
			}
			
			if(request.getTransactionId().equals("")) {
				throw new IllegalArgumentException("Invalid transaction Id");
			}
			
			reqBody= new RequestBody();
			System.out.println(request.getTransactionId()+" From generating");
			reqBody.setInputPrimaryPartyCode(request.getSenderAccount());
			reqBody.setInputAmount(request.getAmount());
			reqBody.setInputReceiverPartyCode(request.getReceiverAccount());
			reqBody.setInputThirdPartyReference(request.getBusinessProductId());
			reqBody.setInputTransactionReference(request.getTransactionId());
			
			
		}else if(bodyType==BodyType.RETREAVAL) {
			
		}else {
			
			
		}
		
		
		return reqBody;
		
	}

}
