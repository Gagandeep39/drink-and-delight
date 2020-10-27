/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-09-19 19:07:34
 * @modify date 2020-09-19 19:07:34
 * @desc Supplier - Allows us to buy goods
 */
package com.cg.inventorydatabaseservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Supplier {
  @Id
  @SequenceGenerator(name = "supplier_id_sequence", initialValue = 100000, allocationSize = 1)
  @GeneratedValue(generator = "supplier_id_sequence", strategy = GenerationType.SEQUENCE)
  private Long supplierId;
  @Column(length = 20)
  private String name;
  @Column(length = 30)
  private String location;
  @Column(length = 10)
  private String phoneNo;
}
