/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-02 01:14:24
 * @modify date 2020-11-02 01:14:24
 * @desc Warehouse Dto
 */
package com.cg.inventorysupplierservice.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class WarehouseDto {

	
	private Long warehouseId;

	@Size(min = 5, max = 40)
	@NotBlank
	private String name;

	@Size(min = 5, max = 100)
	@NotBlank
	private String description;

}
