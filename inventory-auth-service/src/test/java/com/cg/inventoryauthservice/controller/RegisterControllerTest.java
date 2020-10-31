/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-28 16:14:07
 * @modify date 2020-10-28 16:14:07
 * @desc Register COntroller Test
 */
package com.cg.inventoryauthservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import com.cg.inventoryauthservice.dto.RegisterRequest;
import com.cg.inventoryauthservice.dto.UpdateRequest;
import com.cg.inventoryauthservice.entity.Address;
import com.cg.inventoryauthservice.security.JwtProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RegisterControllerTest {

  static {
    System.setProperty("spring.profiles.active", "test");
  }

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private JwtProvider jwtProvider;

  /**
   * @title Extras
   * @desc Fetch All User
   */
  @Test
  void fetchAllUsers() throws Exception {
    RequestBuilder builder = MockMvcRequestBuilders.get("/register").header("Authorization", "Bearer " + fetchToken());
    MvcResult result = mockMvc.perform(builder).andReturn();
    assertEquals(200, result.getResponse().getStatus());
  }

  /**
   * @title Extras
   * @desc Fetch yser By ID
   */
  @Test
  void fetchUserById() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/register/" + 100001)
        .header("Authorization", "Bearer " + fetchToken())
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.userId", Matchers.is(100001)));
  }

  /**
   * @title Extras
   * @desc Fetch yser By ID - Invalid
   */
  @Test
  void invalidFetchUserById() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/register/" + 100999)
        .header("Authorization", "Bearer " + fetchToken())
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is4xxClientError());
  }

  /**
   * @title Register
   * @desc Creates a new User successfully
   */
  @Test
  void register() throws Exception {

    ObjectMapper mapper = new ObjectMapper();
    // Fix date issue
    mapper.registerModule(new JavaTimeModule());
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    mockMvc
        .perform(MockMvcRequestBuilders.post("/register").header("Authorization", "Bearer " + fetchToken())
            .contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(createRegisterRequest())))
        .andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.userId").exists());
  }

  /**
   * @title Register
   * @desc Creates a new User successfully
   */
  @Test
  void invalidRegister() throws Exception {

    ObjectMapper mapper = new ObjectMapper();
    RegisterRequest request = createRegisterRequest();
    request.setUsername(null);
    // Fix date issue
    mapper.registerModule(new JavaTimeModule());
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    mockMvc
        .perform(MockMvcRequestBuilders.post("/register").header("Authorization", "Bearer " + fetchToken())
        .contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(request)))
        .andExpect(status().is4xxClientError());
  }

  /**
   * @title Update
   * @desc Success
   */
  @Test
  void updateUser() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    // Fix date issue
    mapper.registerModule(new JavaTimeModule());
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    Address address = new Address();
    address.setArea("Earths");
    address.setCity("Mumbai");
    address.setState("Maharashtra");
    address.setPincode("400072");
    UpdateRequest updateRequest = UpdateRequest.builder().userId(100001L).address(address).designation("Salesman")
        .dob(LocalDate.of(1999, 5, 14)).emailId("test@mail.com").phoneNo("9988776655").gender("Male")
        .firstName("Gagandeep").lastName("Singh").securityQuestion("New question").securityAnswer("answer").build();
    mockMvc
        .perform(MockMvcRequestBuilders.put("/register").header("Authorization", "Bearer " + fetchToken())
            .contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(updateRequest)))
        .andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.userId").exists());
  }

  /**
   * @title Update
   * @desc Invalid
   */
  @Test
  void invalidUpdateUser() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    // Fix date issue
    mapper.registerModule(new JavaTimeModule());
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    Address address = new Address();
    address.setArea(null);
    address.setPincode("400072");
    UpdateRequest updateRequest = UpdateRequest.builder().userId(100001L).address(address).designation("Salesman")
        .dob(LocalDate.of(1999, 5, 14)).emailId("test@mail.com").phoneNo("9988776655").gender("Male")
        .firstName("Gagandeep").lastName("Singh").securityQuestion("New question").securityAnswer("answer").build();
    mockMvc
        .perform(MockMvcRequestBuilders.put("/register").header("Authorization", "Bearer " + fetchToken())
            .contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(updateRequest)))
        .andExpect(status().is4xxClientError());
  }

  /**
   * Address Bean
   */
  public Address createAddress() {
    Address address = new Address();
    address.setArea("Earths");
    address.setCity("Mumbai");
    address.setState("Maharashtra");
    address.setPincode("400072");
    return address;
  }

  /**
   * Registration Request Bean
   */
  public RegisterRequest createRegisterRequest() {
    return RegisterRequest.builder().address(createAddress()).designation("Developer").dob(LocalDate.of(1999, 5, 14))
        .emailId("test@mail.com").firstName("gagandeep").lastName("Singh").phoneNo("9988776655").username("gaganqweerr")
        .password("123456").gender("Male").build();
  }

  public String fetchToken() {
    return jwtProvider.generateTokenWithUsername("gagan");
  }

}
