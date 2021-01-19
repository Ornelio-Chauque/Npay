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
        Client client= new Client(Environment.DEVELOPMENT);
        client.setPlatform(Platform.JAVA);
        client.setApiKey("m2c6vg1zizge5lnvwyw9hjdt7k1tk78e");
        client.setPublicKey("MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAmptSWqV7cGUUJJhUBxsMLonux24u+FoTlrb+4Kgc6092JIszmI1QUoMohaDDXSVueXx6IXwYGsjjWY32HGXj1iQhkALXfObJ4DqXn5h6E8y5/xQYNAyd5bpN5Z8r892B6toGzZQVB7qtebH4apDjmvTi5FGZVjVYxalyyQkj4uQbbRQjgCkubSi45Xl4CGtLqZztsKssWz3mcKncgTnq3DHGYYEYiKq0xIj100LGbnvNz20Sgqmw/cH+Bua4GJsWYLEqf/h/yiMgiBbxFxsnwZl0im5vXDlwKPw+QnO2fscDhxZFAwV06bgG0oEoWm9FnjMsfvwm0rUNYFlZ+TOtCEhmhtFp+Tsx9jPCuOd5h2emGdSKD8A6jtwhNa7oQ8RtLEEqwAn44orENa1ibOkxMiiiFpmmJkwgZPOG/zMCjXIrrhDWTDUOZaPx/lEQoInJoE2i43VN/HTGCCw8dKQAwg0jsEXau5ixD0GUothqvuX3B9taoeoFAIvUPEq35YulprMM7ThdKodSHvhnwKG82dCsodRwY428kg2xM/UjiTENog4B6zzZfPhMxFlOSFX4MnrqkAS+8Jamhy1GgoHkEMrsT5+/ofjCx0HjKbT5NuA2V/lmzgJLl3jIERadLzuTYnKGWxVJcGLkWXlEPYLbiaKzbJb2sYxt+Kt5OxQqC1MCAwEAAQ==");
        
        //Construct the request with builder
        Request request= new Request.Builder()
        		.transactionType(TransactionType.C2B)
        		.transactionId("aaddnb4251")
        		.amount("100")
        		.businessProductId("Hkehsnj")
        		.senderAccount("258842519199")
        		.receiverAccount("171717")
        		.build();
      
        /**
         * Synchronous request call with execute method
         * */
        		
        //ResponseBody response= client.execute(request);
        //System.out.println(response.getOutputResponseDesc());
        	
        /**
         * Asynchronous request call with enqueue
         * */
       client.enqueue(request, new Callback(){
       
        	// Call when request success
        	public void onSuccess(ResponseBody response) {
        		System.out.println("Success from npay");
        		System.out.println(response.getOutputConversationID());
        		System.out.println(response.getOutputResponseDesc());
        		System.out.println(response.getOutputTransactionID());
        		System.out.println(response.getOutputResponseCode());
        	}
        
        	// Call when request fail
			public void onFailure(Exception e) {
				// TODO Auto-generated method stub
				System.out.println(e.getMessage());
				System.out.println("Error from n_pay");
				
			}
		});
		
    }
}
