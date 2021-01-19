package com.neodoli.n_pay;

public interface Callback {

	public void onSuccess(ResponseBody response);
	public void onFailure(Exception e);

}
