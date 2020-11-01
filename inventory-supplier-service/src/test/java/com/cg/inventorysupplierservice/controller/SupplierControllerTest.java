/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-02 02:43:01
 * @modify date 2020-11-02 02:43:01
 * @desc Supplier COntroller Test cases
 */
package com.cg.inventorysupplierservice.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cg.inventorysupplierservice.entity.Supplier;
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
public class SupplierControllerTest {

  static {
    System.setProperty("spring.profiles.active", "test");
  }

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void fethAllSupplier() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/supplier").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

  }

  @Test
  public void fetchByIdInvalidValue() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/supplier/10000").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is4xxClientError()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.message", Matchers.is("FieldException")));

  }

  @Test
  public void fetchById() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/supplier/1000001").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is2xxSuccessful()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.supplierId").exists());
  }

  @Test
  public void insertInvalidData() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    Supplier ds = Supplier.builder().name("gagan").location("Location").build();

    mockMvc
        .perform(MockMvcRequestBuilders.post("/supplier").contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(ds)))
        .andExpect(status().is4xxClientError()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }

  @Test
  public void insertInvalidDataTwo() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    Supplier ds = Supplier.builder().name("gagan").location("Location").phoneNo("1111111111111111").build();

    mockMvc
        .perform(MockMvcRequestBuilders.post("/supplier").contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(ds)))
        .andExpect(status().is4xxClientError()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }

  @Test
  public void insertvalidData() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    Supplier ds = Supplier.builder().name("gagan").location("Location").phoneNo("9876543210").build();

    mockMvc
        .perform(MockMvcRequestBuilders.post("/supplier").contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(ds)))
        .andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.supplierId").exists());
  }

  @Test
  public void updatevalidData() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    Supplier ds = Supplier.builder().supplierId(Long.valueOf("1000001")).name("gagan").location("Location")
        .phoneNo("9876543210").build();

    mockMvc
        .perform(MockMvcRequestBuilders.post("/supplier").contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(ds)))
        .andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.supplierId").exists());
  }

}
