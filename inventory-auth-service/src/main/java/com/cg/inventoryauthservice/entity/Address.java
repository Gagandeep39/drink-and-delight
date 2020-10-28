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
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "userDetails")
public class Address {
  @Id
  @JsonIgnore
  private Long addressId;
  @Column(length = 25)
  @Size(min = 6, max = 20)
  @NotBlank
  private String city;
  @Column(length = 25)
  @Size(min = 6, max = 20)
  @NotBlank
  private String state;
  @Column(length = 25)
  @Size(min = 6, max = 20)
  @NotBlank
  private String area;
  @Size(min = 6, max = 6, message = "Must be 6 digits only")
  @Column(length = 6)
  @NotBlank
  private String pincode;
  @MapsId
  @OneToOne
  @JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "FK_Address_USER_ID"))
  @JsonBackReference
  private UserDetails userDetails;

}
