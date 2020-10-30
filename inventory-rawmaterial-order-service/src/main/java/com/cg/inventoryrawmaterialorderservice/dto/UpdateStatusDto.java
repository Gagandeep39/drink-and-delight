/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-30 00:15:24
 * @modify date 2020-10-30 00:15:24
 * @desc Request Object containg Updated Status ID
 */
package com.cg.inventoryrawmaterialorderservice.dto;

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
