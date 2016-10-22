package com.bbytes.mailgun.api;

public interface ResponseCallback<T> {

	void onSuccess(T result);
	
	void onFailure(Throwable ex);
	
}
