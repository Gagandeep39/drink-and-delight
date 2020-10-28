/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-09-20 01:44:05
 * @modify date 2020-09-20 01:44:05
 * @desc Error response entity
 */
package com.cg.inventoryrawmaterialorderservice.exception;

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
