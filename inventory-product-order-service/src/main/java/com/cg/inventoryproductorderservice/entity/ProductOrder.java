/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-09-19 22:24:47
 * @modify date 2020-09-19 22:24:47
 * @desc Order entity for purchasing a Product
 */
package com.cg.inventoryproductorderservice.entity;

import java.time.LocalDate;

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

import com.cg.inventoryproductorderservice.enums.OrderStatus;
import com.cg.inventoryproductorderservice.enums.QualityCheck;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductOrder {
  @Id
  @SequenceGenerator(name = "product_order_id_sequence", initialValue = 100000, allocationSize = 1)
  @GeneratedValue(generator = "product_order_id_sequence", strategy = GenerationType.SEQUENCE)
  private Long productOrderId;

  private Double quantity;
  private Double pricePerUnit;
  // @Enumerated(EnumType.STRING)
  // private MeasurementUnit measurementUnit;
  @Enumerated(EnumType.STRING)
  private QualityCheck qualityCheck;
  @Enumerated(EnumType.STRING)
  private OrderStatus orderStatus;

  private LocalDate deliveryDate;
  private LocalDate manufactureDate;
  private LocalDate expiryDate;
  private LocalDate orderedOn;

  @ManyToOne
  @JoinColumn(name = "distributorId", referencedColumnName = "distributorId", foreignKey = @ForeignKey(name = "FK_product_distributor_ID"))
  private Distributor distributor;
  @ManyToOne
  @JoinColumn(name = "productId", referencedColumnName = "productId", foreignKey = @ForeignKey(name = "FK_product_order_ID"))
  private Product product;
}
