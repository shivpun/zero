package org.zerodha.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonSetter;

public class ZerodhaCredentialResponse implements Serializable {

	private static final long serialVersionUID = 2671758467502357686L;
	
	private String status;
	
	private CredentialResponse credentialResponse;

	public String getStatus() {
		return status;
	}

	@JsonSetter(value = "status")
	public void setStatus(String status) {
		this.status = status;
	}

	public CredentialResponse getCredentialResponse() {
		return credentialResponse;
	}

	@JsonSetter(value = "data")
	public void setCredentialResponse(CredentialResponse credentialResponse) {
		this.credentialResponse = credentialResponse;
	}

	@Override
	public String toString() {
		return "ZerodhaCredentialResponse [status=" + status + ", credentialResponse=" + credentialResponse + "]";
	}
}
