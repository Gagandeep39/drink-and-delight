package com.cg.inventoryproductorderservice.exception;

import java.util.Date;
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
	private long timeStamp;
	private List<FieldErrorResponse> errors;
}


	

