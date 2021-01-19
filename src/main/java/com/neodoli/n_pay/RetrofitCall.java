package com.neodoli.n_pay;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCall {
	Client client;
	
	protected RetrofitCall(Client client) {
	 this.client=client;	
	}
	
	
	protected Call<ResponseBody> call(String host, int port, String path, RequestBody reqBody) {
		
			String baseUrl= generateBaseUrl(host, port);
			System.out.println(baseUrl);
			String bearerToken= generateBearerTokenFromPlatform(client.getApiKey(), client.getPublicKey());
			System.out.println(bearerToken);
			
			Call<ResponseBody>  call = new Retrofit.Builder()
			.baseUrl(baseUrl)
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create(HttpService.class)
			.doMpesaRequest(bearerToken,path, reqBody);
			
			return call;
	}
	
	
	private String generateBaseUrl(String host, int port) {
		
		return host+":"+port;
	}
	

	public String generateBearerTokenFromPlatform(String apiKey, String publicKey  ) {
		
		if(client.getPlatform()==Platform.ANDROID) {
			return generateBearerTokenAndroid(apiKey, publicKey);
		}
		
		return generateBearerToken(apiKey, publicKey);
	
	}
	

	private static String generateBearerToken(String apiKey, String publicKey) {
        //String publicKey = "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAmptSWqV7cGUUJJhUBxsMLonux24u+FoTlrb+4Kgc6092JIszmI1QUoMohaDDXSVueXx6IXwYGsjjWY32HGXj1iQhkALXfObJ4DqXn5h6E8y5/xQYNAyd5bpN5Z8r892B6toGzZQVB7qtebH4apDjmvTi5FGZVjVYxalyyQkj4uQbbRQjgCkubSi45Xl4CGtLqZztsKssWz3mcKncgTnq3DHGYYEYiKq0xIj100LGbnvNz20Sgqmw/cH+Bua4GJsWYLEqf/h/yiMgiBbxFxsnwZl0im5vXDlwKPw+QnO2fscDhxZFAwV06bgG0oEoWm9FnjMsfvwm0rUNYFlZ+TOtCEhmhtFp+Tsx9jPCuOd5h2emGdSKD8A6jtwhNa7oQ8RtLEEqwAn44orENa1ibOkxMiiiFpmmJkwgZPOG/zMCjXIrrhDWTDUOZaPx/lEQoInJoE2i43VN/HTGCCw8dKQAwg0jsEXau5ixD0GUothqvuX3B9taoeoFAIvUPEq35YulprMM7ThdKodSHvhnwKG82dCsodRwY428kg2xM/UjiTENog4B6zzZfPhMxFlOSFX4MnrqkAS+8Jamhy1GgoHkEMrsT5+/ofjCx0HjKbT5NuA2V/lmzgJLl3jIERadLzuTYnKGWxVJcGLkWXlEPYLbiaKzbJb2sYxt+Kt5OxQqC1MCAwEAAQ==";
        //String apiKey = "m2c6vg1zizge5lnvwyw9hjdt7k1tk78e";

        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
            /**
             * Decode public key in JDK environment
             * */
            byte[] encodedPublicKey = Base64.getDecoder().decode(publicKey);
            
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(encodedPublicKey);
            PublicKey pk = keyFactory.generatePublic(publicKeySpec);

            cipher.init(Cipher.ENCRYPT_MODE, pk);
          
            /**
             * Encode public key in JKD environment
             * */
            
            byte[] encryptedApiKey =  Base64.getEncoder().encode(cipher.doFinal(
                    apiKey.getBytes("UTF-8")));
            
            return "Bearer "+ new String(encryptedApiKey, "UTF-8" );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
	
	
	private static String generateBearerTokenAndroid(String apiKey, String publicKey) {
        //String publicKey = "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAmptSWqV7cGUUJJhUBxsMLonux24u+FoTlrb+4Kgc6092JIszmI1QUoMohaDDXSVueXx6IXwYGsjjWY32HGXj1iQhkALXfObJ4DqXn5h6E8y5/xQYNAyd5bpN5Z8r892B6toGzZQVB7qtebH4apDjmvTi5FGZVjVYxalyyQkj4uQbbRQjgCkubSi45Xl4CGtLqZztsKssWz3mcKncgTnq3DHGYYEYiKq0xIj100LGbnvNz20Sgqmw/cH+Bua4GJsWYLEqf/h/yiMgiBbxFxsnwZl0im5vXDlwKPw+QnO2fscDhxZFAwV06bgG0oEoWm9FnjMsfvwm0rUNYFlZ+TOtCEhmhtFp+Tsx9jPCuOd5h2emGdSKD8A6jtwhNa7oQ8RtLEEqwAn44orENa1ibOkxMiiiFpmmJkwgZPOG/zMCjXIrrhDWTDUOZaPx/lEQoInJoE2i43VN/HTGCCw8dKQAwg0jsEXau5ixD0GUothqvuX3B9taoeoFAIvUPEq35YulprMM7ThdKodSHvhnwKG82dCsodRwY428kg2xM/UjiTENog4B6zzZfPhMxFlOSFX4MnrqkAS+8Jamhy1GgoHkEMrsT5+/ofjCx0HjKbT5NuA2V/lmzgJLl3jIERadLzuTYnKGWxVJcGLkWXlEPYLbiaKzbJb2sYxt+Kt5OxQqC1MCAwEAAQ==";
        //String apiKey = "m2c6vg1zizge5lnvwyw9hjdt7k1tk78e";

        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
            
            /**
             * Decode public key in android environment
             * */
            byte[] encodedPublicKey = Base64.decode(publicKey, Base64.NO_WRAP);
            
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(encodedPublicKey);
            PublicKey pk = keyFactory.generatePublic(publicKeySpec);

            cipher.init(Cipher.ENCRYPT_MODE, pk);
          
            /**
             * Encode public key in android environment
             * */
            
            byte[] encryptedApiKey =  Base64.encode(cipher.doFinal(apiKey.getBytes("UTF-8")), Base64.NO_WRAP);
            
            
            return "Bearer "+ new String(encryptedApiKey, "UTF-8" );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
	
	
	

}
