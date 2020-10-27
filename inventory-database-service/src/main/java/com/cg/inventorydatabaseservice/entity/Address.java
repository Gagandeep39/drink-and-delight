/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-09-19 18:40:28
 * @modify date 2020-09-19 18:40:28
 * @desc Address Entity
 */
package com.cg.inventorydatabaseservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

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
  private Long addressId;
  @Column(length = 25)
  private String city;
  @Column(length = 25)
  private String state;
  @Column(length = 25)
  private String area;
  @Column(length = 6)
  private String pincode;
  @MapsId
  @OneToOne
  @JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "FK_Address_USER_ID"))
  private UserDetails userDetails;

}
