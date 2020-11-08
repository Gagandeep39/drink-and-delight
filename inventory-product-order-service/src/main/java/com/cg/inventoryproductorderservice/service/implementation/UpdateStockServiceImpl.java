/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-31 02:31:27
 * @modify date 2020-10-31 02:31:27
 * @desc Update stock Implementation
 */
package com.cg.inventoryproductorderservice.service.implementation;

import com.cg.inventoryproductorderservice.dto.UpdateStockRequest;
import com.cg.inventoryproductorderservice.entity.Product;
import com.cg.inventoryproductorderservice.service.UpdateStockService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class UpdateStockServiceImpl implements UpdateStockService {

  private final RestTemplate restTemplate;

  @Override
  public boolean updateProductStock(Long productId, Double quantity) {

    // Prepare header
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");
    headers.add("Accept", "*/*");
    ObjectMapper mapper = new ObjectMapper();
    String requestBody;
    try {
      requestBody = mapper.writeValueAsString(new UpdateStockRequest(productId, quantity));
      HttpEntity<String> entity = new HttpEntity<String>(requestBody, headers);
      return restTemplate
          .exchange("http://inventory-stock-management-service/productStock", HttpMethod.PUT, entity, Product.class)
          .getStatusCode().is2xxSuccessful();
    } catch (JsonProcessingException e) {
      log.info(e.getMessage());
    }

    return false;
  }

}
