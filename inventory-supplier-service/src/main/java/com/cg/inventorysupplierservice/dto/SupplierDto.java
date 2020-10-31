package com.cg.inventorysupplierservice.dto;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class SupplierDto {

	@Min(100000)
	@Max(999999)
	private Long supplierId;

	@Size(min = 3, max = 40, message = "Length should be between 3 to 40 characters")
	@NotNull(message = "This field cannot be null")
	private String name;

	@Size(min = 3, max = 15, message = "Length should be between 3 to 15 characters")
	@NotNull(message = "This field cannot be null")
	private String location;

	@NotNull(message = "This field cannot be null")
	@Pattern(regexp = "(0/91)?[7-9][0-9]{9}", message = "Invalid Mobile Number!")
	private String phoneNo;
}
