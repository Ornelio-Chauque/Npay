package com.neodoli.n_pay;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        
        // Creating the request client and set the mode to production
        Client client= new Client(Environment.PRODUCTION);
        
        //Construct the request with builder
        Request request= new Request.Builder()
        		.transactionId("")
        		.amount("")
        		.businessProductId("")
        		.senderAccount("")
        		.receiverAccount("")
        		.build();
        
        
        /**
         * Synchronous request call with execute method
         * */
        		
        Response response= client.execute(request);
        	
        /**
         * Asynchronous request call with enqueue
         * */
        client.enqueue(request, new Callback(){
        	
        	// Call when request success
        	public void onSuccess(Response response) {
        		
        	}
        
        	// Call when request fail
			public void onFailure() {
				// TODO Auto-generated method stub
				
			}
		});
    }
}
