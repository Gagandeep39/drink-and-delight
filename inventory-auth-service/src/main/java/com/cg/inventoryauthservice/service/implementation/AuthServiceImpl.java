/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-09-20 19:00:02
 * @modify date 2020-09-20 19:00:02
 * @desc Auth Service Impl
 */
package com.cg.inventoryauthservice.service.implementation;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.cg.inventoryauthservice.dto.ChangePasswordRequest;
import com.cg.inventoryauthservice.dto.ForgotPasswordRequest;
import com.cg.inventoryauthservice.dto.LoginRequest;
import com.cg.inventoryauthservice.dto.RegisterRequest;
import com.cg.inventoryauthservice.dto.UpdateRequest;
import com.cg.inventoryauthservice.dto.UserDetailsDto;
import com.cg.inventoryauthservice.entity.Address;
import com.cg.inventoryauthservice.entity.User;
import com.cg.inventoryauthservice.entity.UserDetails;
import com.cg.inventoryauthservice.exception.InvalidCredentialException;
import com.cg.inventoryauthservice.helper.UserDetailsMapper;
import com.cg.inventoryauthservice.repository.AddressRepository;
import com.cg.inventoryauthservice.repository.UserDetailsRepository;
import com.cg.inventoryauthservice.repository.UserRepository;
import com.cg.inventoryauthservice.service.AuthService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {

  private final UserDetailsRepository userDetailsRepository;
  private final AddressRepository addressRepository;
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public Map<String, String> login(LoginRequest loginRequest) {
    return Collections.singletonMap("userId",
        findUserByCredentials(loginRequest.getUsername(), loginRequest.getPassword()).getUserId().toString());
  }

  @Override
  public Map<String, String> register(RegisterRequest registerRequest) {
    checkIfUsernameExists(registerRequest.getUsername());
    registerRequest.setPassword(encodePassword(registerRequest.getPassword()));
    UserDetails userDetails = userDetailsRepository.save(UserDetailsMapper.registerToUserDetails(registerRequest));
    Address address = registerRequest.getAddress();
    address.setUserDetails(userDetails);
    addressRepository.save(address);
    return Collections.singletonMap("success", "User created with ID: " + userDetails.getUserDetailsId());
  }

  @Override
  public Map<String, String> changePassword(ChangePasswordRequest changePasswordRequest) {
    User user = findUserByCredentials(changePasswordRequest.getUsername(), changePasswordRequest.getOldPassword());
    user.setPassword(encodePassword(changePasswordRequest.getNewPassword()));
    userRepository.save(user);
    return Collections.singletonMap("success", "Successfully Updated Password");
  }

  @Override
  public Map<String, String> updateUser(UpdateRequest updateRequest) {
    userDetailsRepository.save(UserDetailsMapper.updateRequestToUserDetails(updateRequest));
    return Collections.singletonMap("success", "Successfully Updated user with ID: " + updateRequest.getUserId());
  }

  @Override
  @Transactional(readOnly = true)
  public List<UserDetailsDto> fetchAllUsers() {
    return userDetailsRepository
      .findAll()
      .stream()
      .map(UserDetailsMapper::userDetailsToDto)
      .collect(Collectors.toList());
      // return null;
  }

  @Override
  @Transactional(readOnly = true)
  public UserDetailsDto fetchUserById(Long id) {
    return UserDetailsMapper.userDetailsToDto(
      userDetailsRepository
        .findById(id)
        .orElseThrow(() -> new InvalidCredentialException("userId", "ID " + id + " doesn't exist"))
    );
  }

  @Transactional(readOnly = true)
  public User findUserByCredentials(String username, String password) {
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new InvalidCredentialException("username", "User " + username + " doesn't exist"));
    if (!passwordEncoder.matches(password, user.getPassword())) throw new InvalidCredentialException("password", "Invalid Password");
    return user;
  }

  @Override
  @Transactional(readOnly = true)
  public boolean checkIfUsernameExists(String username) {
    if (!userRepository.existsByUsername(username)) return false;
    else throw new InvalidCredentialException("username", "Username already exists");
  }

  @Override
  @Transactional(readOnly = true)
  public Map<String, String> fetchSecurityQuestionForUser(String username) {
    HashMap<String, String> responseMap = new HashMap<>();
    responseMap.put("username", username);
    responseMap.put("securityQuestion", userDetailsRepository.findByUserUsername(username)
      .orElseThrow(() -> new InvalidCredentialException("username", "User " + username + " doesn't exist"))
      .getSecurityQuestion());
    return responseMap;
  }

  @Override
  public Map<String, String> validateAnswerAndUpdate(ForgotPasswordRequest forgotPasswordRequest) {
    UserDetails userDetails = userDetailsRepository
      .findByUserUsername(forgotPasswordRequest.getUsername())
      .orElseThrow(() -> new InvalidCredentialException("username", "User " + forgotPasswordRequest.getUsername() + " doesn't exist"));
    if(!userDetails.getSecurityAnswer().toLowerCase().equals(forgotPasswordRequest.getSecurityAnswer().toLowerCase()))
      throw new InvalidCredentialException("securityAnswer", "Invalid Answer");
    User user = userDetails.getUser();
    user.setPassword(encodePassword(forgotPasswordRequest.getNewPassword()));
    userRepository.save(user);
    return Collections.singletonMap("success", "Successfully Updated Password");
  }

  private String encodePassword(String password) {
    return passwordEncoder.encode(password);
  }

}
