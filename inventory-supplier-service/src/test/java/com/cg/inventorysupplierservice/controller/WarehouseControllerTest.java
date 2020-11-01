/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-02 02:45:33
 * @modify date 2020-11-02 02:45:33
 * @desc Warehouse Controller Tests
 */
package com.cg.inventorysupplierservice.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cg.inventorysupplierservice.entity.Warehouse;
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
public class WarehouseControllerTest {
  
  static {
    System.setProperty("spring.profiles.active", "test");
  }

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void fethAllWarehouse() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/warehouse").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

  }

  @Test
  public void fetchByIdInvalidValue() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/warehouse/10000").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is4xxClientError()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.message", Matchers.is("FieldException")));

  }

  @Test
  public void fetchById() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/warehouse/1000001").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is2xxSuccessful()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.warehouseId").exists());
  }

  @Test
  public void insertInvalidData() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    Warehouse ds = Warehouse.builder().name("gagan").build();

    mockMvc
        .perform(MockMvcRequestBuilders.post("/warehouse").contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(ds)))
        .andExpect(status().is4xxClientError()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }

  @Test
  public void insertInvalidDataTwo() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    Warehouse ds = Warehouse.builder().description("xcdfvgbfdcdvfbgvvb").build();

    mockMvc
        .perform(MockMvcRequestBuilders.post("/warehouse").contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(ds)))
        .andExpect(status().is4xxClientError()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }

  @Test
  public void insertvalidData() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    Warehouse ds = Warehouse.builder().name("gagan").description("This is description").build();

    mockMvc
        .perform(MockMvcRequestBuilders.post("/warehouse").contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(ds)))
        .andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.warehouseId").exists());
  }

  @Test
  public void updatevalidData() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    Warehouse ds = Warehouse.builder().warehouseId(Long.valueOf("1000001")).name("gagan").description("This is description").build();

    mockMvc
        .perform(MockMvcRequestBuilders.post("/warehouse").contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(ds)))
        .andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.warehouseId").exists());
  }

}
