/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-09-21 00:24:12
 * @modify date 2020-09-21 00:24:12
 * @desc Exception thrown on entering invalid credential
 */
package com.cg.inventoryauthservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InvalidCredentialException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  private String errorName;
  private String errorDescription;

}
