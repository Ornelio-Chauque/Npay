package com.neodoli.n_pay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestBody {

		@SerializedName("input_TransactionReference")
		@Expose
		private String inputTransactionReference;
		@SerializedName("input_Amount")
		@Expose
		private String inputAmount;
		@SerializedName("input_ThirdPartyReference")
		@Expose
		private String inputThirdPartyReference;
		@SerializedName("input_CustomerMSISDN")
		@Expose
		private String inputCustomerMSISDN;
		@SerializedName("input_ServiceProviderCode")
		@Expose
		private String inputServiceProviderCode;
		@SerializedName("input_PrimaryPartyCode")
		@Expose
		private String inputPrimaryPartyCode;
		@SerializedName("input_ReceiverPartyCode")
		@Expose
		private String inputReceiverPartyCode;

		public String getInputTransactionReference() {
		return inputTransactionReference;
		}

		public void setInputTransactionReference(String inputTransactionReference) {
		this.inputTransactionReference = inputTransactionReference;
		}

		public String getInputAmount() {
		return inputAmount;
		}

		public void setInputAmount(String inputAmount) {
		this.inputAmount = inputAmount;
		}

		public String getInputThirdPartyReference() {
		return inputThirdPartyReference;
		}

		public void setInputThirdPartyReference(String inputThirdPartyReference) {
		this.inputThirdPartyReference = inputThirdPartyReference;
		}

		public String getInputCustomerMSISDN() {
		return inputCustomerMSISDN;
		}

		public void setInputCustomerMSISDN(String inputCustomerMSISDN) {
		this.inputCustomerMSISDN = inputCustomerMSISDN;
		}

		public String getInputServiceProviderCode() {
		return inputServiceProviderCode;
		}

		public void setInputServiceProviderCode(String inputServiceProviderCode) {
		this.inputServiceProviderCode = inputServiceProviderCode;
		}

		public String getInputPrimaryPartyCode() {
		return inputPrimaryPartyCode;
		}

		public void setInputPrimaryPartyCode(String inputPrimaryPartyCode) {
		this.inputPrimaryPartyCode = inputPrimaryPartyCode;
		}

		public String getInputReceiverPartyCode() {
		return inputReceiverPartyCode;
		}

		public void setInputReceiverPartyCode(String inputReceiverPartyCode) {
		this.inputReceiverPartyCode = inputReceiverPartyCode;
		}

	

}
