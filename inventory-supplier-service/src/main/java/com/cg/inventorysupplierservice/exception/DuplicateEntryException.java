package com.cg.inventorysupplierservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DuplicateEntryException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errorName;
	private String errorDescription;

}
