/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-09-21 19:07:51
 * @modify date 2020-09-21 19:07:51
 * @desc Auth COntroller test cases
 */
package com.cg.inventoryauthservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cg.inventoryauthservice.dto.ForgotPasswordRequest;
import com.cg.inventoryauthservice.dto.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

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
class AuthControllerTest {

        static {
                System.setProperty("spring.profiles.active", "test");
        }

        @Autowired
        private MockMvc mockMvc;

        /**
         * 
         * @title Peform Login
         * @desc Successfully Login - Returns UserId
         */
        @Test
        void login() throws Exception {

                ObjectMapper mapper = new ObjectMapper();
                LoginRequest loginRequest = new LoginRequest();
                RequestBuilder builder = MockMvcRequestBuilders.post("/auth/login")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(loginRequest));
                MvcResult result = mockMvc.perform(builder).andReturn();
                assertEquals(400, result.getResponse().getStatus());

                loginRequest.setPassword("123456");
                loginRequest.setUsername("gagan");
                mockMvc.perform(MockMvcRequestBuilders.post("/auth/login").contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(loginRequest))).andExpect(status().isOk())
                                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                                .andExpect(jsonPath("$.userId", Matchers.is(100001)));
        }

        /**
         * 
         * @title Peform Login
         * @desc Login Failure
         */
        @Test
        void loginInvalid() throws Exception {

                ObjectMapper mapper = new ObjectMapper();
                LoginRequest loginRequest = new LoginRequest();
                RequestBuilder builder = MockMvcRequestBuilders.post("/auth/login")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(loginRequest));
                MvcResult result = mockMvc.perform(builder).andReturn();
                assertEquals(400, result.getResponse().getStatus());

                loginRequest.setPassword("123456");
                loginRequest.setUsername("gaga");
                mockMvc.perform(MockMvcRequestBuilders.post("/auth/login").contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(loginRequest)))
                                .andExpect(status().is4xxClientError());
        }

        /**
         * 
         * @title Request PasswordChange
         * @desc Invalid Username
         */
        @Test
        void forgotPasswordInvalidUsername() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders.get("/auth/forgotpassword/gaga")
                                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().is4xxClientError());
        }

        /**
         * 
         * @title Request PasswordChange
         * @desc Successfully fetch Secret Question
         */
        @Test
        void forgotPassword() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders.get("/auth/forgotpassword/gagan")
                                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                                .andExpect(jsonPath("$.securityQuestion").exists());

        }

        /**
         * 
         * @title Request PasswordChange
         * @desc Validate answer and Update - Invalid Username
         */
        @Test
        void validateAnswerAndUpdatePasswordInvalidUsername() throws Exception {
                ObjectMapper mapper = new ObjectMapper();
                ForgotPasswordRequest forgotPasswordRequest = ForgotPasswordRequest.builder().securityAnswer("answer")
                                .username("gn").newPassword("123456").build();
                mockMvc.perform(MockMvcRequestBuilders.put("/auth/forgotpassword")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(forgotPasswordRequest)))
                                .andExpect(status().is4xxClientError());
        }

        /**
         * 
         * @title Request PasswordChange
         * @desc Validate answer and Update - Invalid answer
         */
        @Test
        void validateAnswerAndUpdatePasswordInvalidAnswer() throws Exception {
                ObjectMapper mapper = new ObjectMapper();
                ForgotPasswordRequest forgotPasswordRequest = ForgotPasswordRequest.builder().securityAnswer("answ")
                                .username("gagan").newPassword("123456").build();
                mockMvc.perform(MockMvcRequestBuilders.put("/auth/forgotpassword")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(forgotPasswordRequest)))
                                .andExpect(status().is4xxClientError());
        }

        /**
         * 
         * @title Request PasswordChange
         * @desc Validate answer and Update - Success
         */
        @Test
        void validateAnswerAndUpdatePassword() throws Exception {
                ObjectMapper mapper = new ObjectMapper();
                ForgotPasswordRequest forgotPasswordRequest = ForgotPasswordRequest.builder().securityAnswer("answer")
                                .username("gagan").newPassword("123456").build();
                mockMvc.perform(MockMvcRequestBuilders.put("/auth/forgotpassword")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(forgotPasswordRequest))).andExpect(status().isOk())
                                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                                .andExpect(jsonPath("$.userId").exists());
        }

}
