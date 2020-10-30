package com.cg.inventoryproductorderservice.dto;

import java.time.LocalDate;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class ProductOrderRequest {

	  @NotNull
	  @Min(1000000)
	  @Max(9999999)
	  private Long productId;
	  @NotNull
	  @DecimalMax(value = "999.999")
	  private Double quantity;
	  @NotNull
	  @DecimalMax(value = "9999.999")
	  private Double pricePerUnit;
	  @Pattern(regexp = "^(Passed|Failed)$", message = "Must be either passed or failed")
	  private String qualityCheck;
	  @NotNull
	  @Future
	  private LocalDate deliveryDate;
	  @NotNull
	  @Future
	  private LocalDate expiryDate;
	  @NotNull
	  private Long supplierId;

}
