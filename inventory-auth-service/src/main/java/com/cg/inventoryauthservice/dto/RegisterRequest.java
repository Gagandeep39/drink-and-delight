/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-09-20 19:10:45
 * @modify date 2020-09-20 19:10:45
 * @desc Reqister Request Object
 */
package com.cg.inventoryauthservice.dto;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.cg.inventoryauthservice.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {

  @NotBlank
  @Size(min = 5, max = 20)
  private String username;
  @NotBlank
  @Size(min = 5, max = 20)
  private String password;
  @NotBlank
  @Size(min = 5, max = 20)
  private String designation;
  @NotBlank
  @Pattern(regexp = "^(Male|Female)$", message = "Gender must be Male or Female")
  private String gender;
  @NotBlank
  @Email
  private String emailId;
  @NotBlank
  @Size(min = 10, max = 10, message = "Length of phone number must be 10")
  private String phoneNo;
  @NotNull
  @Past
  private LocalDate dob;
  @Valid
  private Address address;
  @NotBlank
  @Size(min = 5, max = 30)
  private String firstName;
  @NotBlank
  @Size(min = 5, max = 30)
  private String lastName;

}
