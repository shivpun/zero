package org.zerodha.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class CredentialResponse implements Serializable {

	private static final long serialVersionUID = 2671758467502357686L;

	private String userId;

	private String message;

	private String loginStatus;

	private boolean requireUpdate;

	private List<Integer> questionIds;

	private List<String> questions;

	@JsonGetter(value = "user_id")
	public String getUserId() {
		return userId;
	}

	@JsonSetter(value = "user_id")
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@JsonGetter(value = "message")
	public String getMessage() {
		return message;
	}

	@JsonSetter(value = "message")
	public void setMessage(String message) {
		this.message = message;
	}

	@JsonGetter(value = "login_status")
	public String getLoginStatus() {
		return loginStatus;
	}

	@JsonSetter(value = "login_status")
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public boolean isRequireUpdate() {
		return requireUpdate;
	}

	@JsonSetter(value = "require_update")
	public void setRequireUpdate(boolean requireUpdate) {
		this.requireUpdate = requireUpdate;
	}

	public List<Integer> getQuestionIds() {
		return questionIds;
	}

	@JsonSetter(value = "question_ids")
	public void setQuestionIds(List<Integer> questionIds) {
		this.questionIds = questionIds;
	}

	public List<String> getQuestions() {
		return questions;
	}

	@JsonSetter(value = "questions")
	public void setQuestions(List<String> questions) {
		this.questions = questions;
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
		if (!(obj instanceof CredentialResponse)) {
			return false;
		}
		CredentialResponse other = (CredentialResponse) obj;
		return equalToUserId(other);
	}

	private boolean equalToUserId(CredentialResponse other) {
		if (this.userId == null || other.userId == null) {
			return false;
		}
		return this.userId.equals(other.userId);
	}

	@Override
	public String toString() {
		return "CredentialResponse [userId=" + userId + ", message=" + message + ", loginStatus=" + loginStatus
				+ ", requireUpdate=" + requireUpdate + ", questionIds=" + questionIds + ", questions=" + questions
				+ "]";
	}
}
