package com.cg.inventorystockmanagementservice.exception;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {

	private int status;
	private String message;
	public ErrorResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
		
	}
	public ErrorResponse() {
		super();
	}
	
	
	
}
