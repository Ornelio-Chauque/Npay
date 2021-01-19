package com.neodoli.n_pay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseBody {

	public ResponseBody() {
		// TODO Auto-generated constructor stub
	}
	
	@SerializedName("output_ConversationID")
	@Expose
	private String outputConversationID;
	@SerializedName("output_TransactionID")
	@Expose
	private String outputTransactionID;
	@SerializedName("output_ResponseDesc")
	@Expose
	private String outputResponseDesc;
	@SerializedName("output_ResponseCode")
	@Expose
	private String outputResponseCode;
	@SerializedName("output_ThirdPartyReference")
	@Expose
	private String outputThirdPartyReference;

	public String getOutputConversationID() {
	return outputConversationID;
	}

	public void setOutputConversationID(String outputConversationID) {
	this.outputConversationID = outputConversationID;
	}

	public String getOutputTransactionID() {
	return outputTransactionID;
	}

	public void setOutputTransactionID(String outputTransactionID) {
	this.outputTransactionID = outputTransactionID;
	}

	public String getOutputResponseDesc() {
	return outputResponseDesc;
	}

	public void setOutputResponseDesc(String outputResponseDesc) {
	this.outputResponseDesc = outputResponseDesc;
	}

	public String getOutputResponseCode() {
	return outputResponseCode;
	}

	public void setOutputResponseCode(String outputResponseCode) {
	this.outputResponseCode = outputResponseCode;
	}

	public String getOutputThirdPartyReference() {
	return outputThirdPartyReference;
	}

	public void setOutputThirdPartyReference(String outputThirdPartyReference) {
	this.outputThirdPartyReference = outputThirdPartyReference;
	}

}
