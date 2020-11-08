package com.cg.inventorystockmanagementservice.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvalidDataException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errorName;
	private String errorDescription;
	public InvalidDataException() {
		super();
	}

	
}
