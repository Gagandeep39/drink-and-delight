/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-09-19 18:09:13
 * @modify date 2020-09-19 18:09:13
 * @desc Dummy Endpoint
 */
package com.cg.inventorydatabaseservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greetings {

  @Value("${server.port}")
  private String serverPort;
  @Value("${spring.application.name}")
  private String applicationName;

  @GetMapping
  public String helloWorld() {
    return "Hello from " + applicationName + " running at " + serverPort;
  }

}
