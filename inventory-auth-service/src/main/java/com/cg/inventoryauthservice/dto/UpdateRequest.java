/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-09-21 09:55:29
 * @modify date 2020-09-21 09:55:29
 * @desc Update Dto
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
public class UpdateRequest {
  @NotNull
  private Long userId;
  @Size(min = 5, max = 20)
  @NotBlank
  @Pattern(regexp = "[a-zA-Z]{5,30}", message = "Enter a valid String between length 5-20")
  @Size(min = 5, max = 20)
  private String designation;
  @NotBlank
  @Pattern(regexp = "^(Male|Female)$", message = "Gender must be Male or Female")
  private String gender;
  @Email
  @NotBlank
  private String emailId;
  @NotBlank
  @Size(min = 10, max = 10, message = "Length of phone number must be 10")
  private String phoneNo;
  @Past
  private LocalDate dob;
  @Valid
  private Address address;

  
  @Size(min = 10, max = 30)
  @NotBlank
  private String securityQuestion;
  @Size(min = 5, max = 10)
  @NotBlank
  private String securityAnswer;
  
  @Size(min = 5, max = 30)
  @Pattern(regexp = "[a-zA-Z]{5,30}", message = "Enter a valid First Name between length 5-30")
  private String firstName;
  @Size(min = 5, max = 30)
  @Pattern(regexp = "[a-zA-Z]{5,30}", message = "Enter a valid Last Name between length 5-30")
  private String lastName;
}
