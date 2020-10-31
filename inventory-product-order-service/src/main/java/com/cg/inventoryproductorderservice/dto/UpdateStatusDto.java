
package com.cg.inventoryproductorderservice.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStatusDto {

  @NotNull
  private Long orderId;

  @NotBlank
  @Pattern(regexp = "^(Delivered|Cancelled)$", message = "Delivery staus must be 'Delivered' or 'Cancelled'")
  private String status;

}
