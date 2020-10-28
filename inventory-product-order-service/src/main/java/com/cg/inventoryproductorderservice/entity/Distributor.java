/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-28 09:01:04
 * @modify date 2020-10-28 09:01:04
 * @desc Created distribtor
 */
package com.cg.inventoryproductorderservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.cg.inventoryproductorderservice.enums.MeasurementUnit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Distributor {

  @Id
  @SequenceGenerator(name = "distributor_id_sequence", initialValue = 100000, allocationSize = 1)
  @GeneratedValue(generator = "distributor_id_sequence", strategy = GenerationType.SEQUENCE)
  private Long distributorId;
  @Column(length = 20)
  private String materialName;
  @Column(length = 100)
  private String description;
  private Double quantityAvailable;
  @Enumerated(EnumType.STRING)
  private MeasurementUnit quantityUnit;
  @ManyToOne
  @JoinColumn(name = "warehouseId", referencedColumnName = "warehouseId", foreignKey = @ForeignKey(name = "FK_dist_warehouse_ID"))
  private Warehouse warehouse;
}
