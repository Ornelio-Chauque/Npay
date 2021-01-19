package com.neodoli.n_pay;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface HttpService {
	
	 @Headers({
         "Content-Type: application/json",
         "Origin: developer.mpesa.vm.co.mz"})
	@POST("/ipg/v1x/{path}")
	Call<ResponseBody> doMpesaRequest(@Header("Authorization") String bearToken,@Path("path") String path, @Body RequestBody reqBody);
	

	@GET("posts/{id}")
	Call<Post> test(@Path("id") int id);

}
