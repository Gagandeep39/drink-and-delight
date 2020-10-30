/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-30 00:05:42
 * @modify date 2020-10-30 00:05:42
 * @desc Exception thrown when Raw Material is not available in Database
 */
package com.cg.inventoryrawmaterialorderservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RawMaterialNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  private String errorName;
  private String errorDescription;
  
}
