package com.example.webtest.util;

import java.util.List;

public class ResponseUtil<T> {

	private int resCode;
	private String resMessage;
	private Object resObject;
	private List<T> resList;
	
	public ResponseUtil(int resCode, Object resObject, List<T> resList, String resMessage){
		this.resCode = resCode;
		this.resMessage = resMessage;
		this.resObject = resObject;
		this.resList = resList;
	}

	public int getResCode() {
		return resCode;
	}

	public void setResCode(int resCode) {
		this.resCode = resCode;
	}

	public Object getResObject() {
		return resObject;
	}

	public void setResObject(Object resObject) {
		this.resObject = resObject;
	}

	public List<T> getResList() {
		return resList;
	}

	public void setResList(List<T> resList) {
		this.resList = resList;
	}

	public String getResMessage() {
		return resMessage;
	}

	public void setResMessage(String resMessage) {
		this.resMessage = resMessage;
	}
}