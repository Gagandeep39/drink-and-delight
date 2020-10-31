package com.cg.inventorysupplierservice.dto;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class DistributorDto {

	@Min(100000)
	@Max(999999)
	private Long distributorId;

	@Size(min = 5, max = 40, message = "Length should be between 5 to 40 characters")
	@NotNull(message = "This field cannot be null")
	private String materialName;

	@Size(min = 5, max = 100, message = "Length should be between 5 to 100 characters")
	@NotNull(message = "This field cannot be null")
	private String description;
}
