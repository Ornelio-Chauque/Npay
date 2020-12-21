```java   Client client= new Client(Environment.PRODUCTION);
        
        Request request= new Request.Builder()
        		.build();
        
        	client.enqueue(request, new Callback(){
        	 public void onSuccess(Response response) {
        		
        	}
        
			public void onFailure() {
				// TODO Auto-generated method stub
				
			}
			});
    }

```