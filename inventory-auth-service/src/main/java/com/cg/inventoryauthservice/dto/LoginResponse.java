/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-29 00:25:53
 * @modify date 2020-10-29 00:25:53
 * @desc Login Success Response
 */
package com.cg.inventoryauthservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class LoginResponse {

  private Long userId;
  private String token;
  private String role;
  private String username;

}
