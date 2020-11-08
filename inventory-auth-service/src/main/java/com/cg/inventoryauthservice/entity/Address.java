/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-09-19 18:40:28
 * @modify date 2020-09-19 18:40:28
 * @desc Address Entity
 */
package com.cg.inventoryauthservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
  @Id
  @JsonIgnore
  @SequenceGenerator(name = "address_id_sequence", initialValue = 100000, allocationSize = 1)
  @GeneratedValue(generator = "address_id_sequence", strategy = GenerationType.SEQUENCE)
  private Long addressId;
  @Column(length = 25)
  @Size(min = 3, max = 20)
  @NotBlank
  private String city;
  @Column(length = 25)
  @Size(min = 3, max = 20)
  @NotBlank
  private String state;
  @Column(length = 25)
  @Size(min = 3, max = 20)
  @NotBlank
  private String area;
  @Size(min = 6, max = 6, message = "Must be 6 digits only")
  @Column(length = 6)
  @NotBlank
  private String pincode;

}
