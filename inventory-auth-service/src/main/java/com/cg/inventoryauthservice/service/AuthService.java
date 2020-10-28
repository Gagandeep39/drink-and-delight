/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-09-20 18:59:06
 * @modify date 2020-09-20 18:59:06
 * @desc Auth Service Structure
 */
package com.cg.inventoryauthservice.service;

import java.util.List;
import java.util.Map;

import com.cg.inventoryauthservice.dto.ChangePasswordRequest;
import com.cg.inventoryauthservice.dto.ForgotPasswordRequest;
import com.cg.inventoryauthservice.dto.LoginRequest;
import com.cg.inventoryauthservice.dto.RegisterRequest;
import com.cg.inventoryauthservice.dto.UpdateRequest;
import com.cg.inventoryauthservice.dto.UserDetailsDto;

public interface AuthService {
  Map<String, String> login(LoginRequest loginRequest);

  Map<String, String> register(RegisterRequest registerRequest);

  Map<String, String> changePassword(ChangePasswordRequest changePasswordRequest);

  Map<String, String> updateUser(UpdateRequest updateRequest);

  List<UserDetailsDto> fetchAllUsers();

  UserDetailsDto fetchUserById(Long id);

  boolean checkIfUsernameExists(String username);

  Map<String, String> fetchSecurityQuestionForUser(String username);

  Map<String, String> validateAnswerAndUpdate(ForgotPasswordRequest forgotPasswordRequest);
}
