/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-30 18:11:17
 * @modify date 2020-10-30 18:11:17
 * @desc RM Orer Endpoint Tests
 */
package com.cg.inventoryrawmaterialorderservice.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cg.inventoryrawmaterialorderservice.dto.UpdateStatusDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RawMaterialOrderControllerTest {

  static {
    System.setProperty("spring.profiles.active", "test");
  }

  @Autowired
  private MockMvc mockMvc;

  /**
   * 
   * @title Fetch All raw Material
   * @desc Checks if data is fetch peroperly
   */
  @Test
  void fetchAllOrder() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/rawMaterialOrder").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is2xxSuccessful());
  }

  /**
   * 
   * @title Fetch By Invalid ID
   * @desc Throws exception
   */
  @Test
  void fetchOrderByInvalidId() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/rawMaterialOrder/32456").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is4xxClientError()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.message", Matchers.is("FieldException")));

  }

  /**
   * 
   * @title Fetch By ID
   * @desc Checks response code, Response ID
   */
  @Test
  void fetchOrderById() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/rawMaterialOrder/1000000").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is2xxSuccessful()).andExpect(jsonPath("rawMaterialOrderId", Matchers.is(1000000)));
    // .andExpect(matcher);

  }

  /**
   * 
   * @title Update delivery status
   * @desc Error -Already delivered
   */
  @Test
  void updateStatusAlreadyDelivered() throws Exception {

    ObjectMapper mapper = new ObjectMapper();
    UpdateStatusDto dto = new UpdateStatusDto();
    dto.setOrderId(Long.parseLong("1000000"));
    dto.setStatus("Delivered");
    mockMvc
        .perform(MockMvcRequestBuilders.put("/rawMaterialOrder").contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(dto)))
        .andExpect(status().is4xxClientError()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.message", Matchers.is("FieldException")));
  }

  /**
   * 
   * @title Update delivery status
   * @desc Error -Already delivered
   */
  @Test
  void updateStatusInvalid() throws Exception {

    ObjectMapper mapper = new ObjectMapper();
    UpdateStatusDto dto = new UpdateStatusDto();
    dto.setOrderId(Long.parseLong("1000000"));
    dto.setStatus("Deliver");
    mockMvc
        .perform(MockMvcRequestBuilders.put("/rawMaterialOrder").contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(dto)))
        .andExpect(status().is4xxClientError()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.message", Matchers.is("FieldException")));
  }

  /**
   * 
   * @title Update delivery status
   * @desc Valid Data
   */
  @Test
  void updateStatusValid() throws Exception {

    ObjectMapper mapper = new ObjectMapper();
    UpdateStatusDto dto = new UpdateStatusDto();
    dto.setOrderId(Long.parseLong("1000003"));
    dto.setStatus("Delivered");
    mockMvc
        .perform(MockMvcRequestBuilders.put("/rawMaterialOrder").contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(dto)))
        .andExpect(status().is2xxSuccessful()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.rawMaterialOrderId", Matchers.is(1000003)));
  }

}
