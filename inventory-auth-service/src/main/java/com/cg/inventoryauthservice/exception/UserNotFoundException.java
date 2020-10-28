/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-09-20 01:45:41
 * @modify date 2020-09-20 01:45:41
 * @desc Exception thrown when user is not found in database
 */
package com.cg.inventoryauthservice.exception;

public class UserNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 5512565657286379434L;

  public UserNotFoundException() {
    super();
  }

  public UserNotFoundException(String message) {
    super(message);
  }

}