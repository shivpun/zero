package org.zerodha.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(value = { "userId", "password" })
public class ZerodhaCredential  {

	private String userId;

	private String password;

	@JsonGetter(value = "user_id")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@JsonGetter(value = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ZerodhaCredential)) {
			return false;
		}
		ZerodhaCredential other = (ZerodhaCredential) obj;
		return equalToUserId(other);
	}

	private boolean equalToUserId(ZerodhaCredential other) {
		if (this.userId == null || other.userId == null) {
			return false;
		}
		return this.userId.equals(other.userId);
	}

	@Override
	public String toString() {
		return "ZerodhaCredential [userId=" + userId + ", password=" + password + "]";
	}
}
