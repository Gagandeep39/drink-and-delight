/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-09-19 19:07:34
 * @modify date 2020-09-19 19:07:34
 * @desc Supplier - Allows us to buy goods
 */
package com.cg.inventorysupplierservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Supplier {
	@Id
	// @NotNull(message = "Id cannot be null value")
	// @NotBlank(message = "Id cannot be blank value")
	@SequenceGenerator(name = "supplier_id_sequence", initialValue = 100000, allocationSize = 1)
	@GeneratedValue(generator = "supplier_id_sequence", strategy = GenerationType.SEQUENCE)
	private Long supplierId;

	// @Size(min=3,max=40,message="Length should be between 3 to 40 characters")
	// @NotNull(message="This field cannot be null")
	// @NotBlank(message="This field cannot be blank")
	@Column(length = 20)
	private String name;

	// @Size(min=3,max=15,message="Length should be between 3 to 15 characters")
	// @NotNull(message="This field cannot be null")
	// @NotBlank(message="This field cannot be blank")
	@Column(length = 30)
	private String location;

	// @NotNull(message="This field cannot be null")
	// @NotBlank(message="This field cannot be blank")
	// @Pattern(regexp="(0/91)?[7-9][0-9]{9}",message="Invalid Mobile Number!")
	@Column(length = 10)
	private String phoneNo;
}
