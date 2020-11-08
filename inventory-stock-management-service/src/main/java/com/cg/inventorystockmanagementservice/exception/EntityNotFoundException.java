package com.cg.inventorystockmanagementservice.exception;


public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errorName;
	private String errorDescription;
	public String getErrorName() {
		return errorName;
	}
	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public EntityNotFoundException(String errorName, String errorDescription) {
		super();
		this.errorName = errorName;
		this.errorDescription = errorDescription;
	}
	public EntityNotFoundException() {
		super();
	}

}
