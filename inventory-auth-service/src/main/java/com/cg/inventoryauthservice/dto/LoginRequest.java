/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-09-20 01:26:22
 * @modify date 2020-09-20 01:26:22
 * @desc Object to recive login request
 */
package com.cg.inventoryauthservice.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
  @NotBlank
  @Size(min = 5, max = 20)
  private String username;
  @NotBlank
  @Size(min = 5, max = 20)
  private String password;
}
