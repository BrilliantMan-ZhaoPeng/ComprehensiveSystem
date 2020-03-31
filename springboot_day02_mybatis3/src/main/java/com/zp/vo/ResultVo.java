package com.zp.vo;

public class ResultVo {
	private boolean flag;
	private String message;
	private Object object;
	
	public ResultVo() {
		super();
	}
	
	public ResultVo(boolean flag, String message) {
		this.flag = flag;
		this.message = message;
	}
	
	public ResultVo(boolean flag, String message, Object object) {
		super();
		this.flag = flag;
		this.message = message;
		this.object = object;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
}
