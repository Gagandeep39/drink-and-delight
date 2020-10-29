/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-28 14:42:27
 * @modify date 2020-10-28 14:42:27
 * @desc Filed Error List
 */
package com.cg.inventorygatewayserver.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FieldErrorResponse {
  private String field;
  private String message;
}
