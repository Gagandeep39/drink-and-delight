/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-09-19 19:07:14
 * @modify date 2020-09-19 19:07:14
 * @desc Warehouse Entity
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
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Warehouse {

	@Id
	// @NotNull(message = "Id cannot be null value")
	// @NotBlank(message = "Id cannot be blank value")
	@SequenceGenerator(name = "warehouse_id_sequence", initialValue = 100000, allocationSize = 1)
	@GeneratedValue(generator = "warehouse_id_sequence", strategy = GenerationType.SEQUENCE)
	private Long warehouseId;

	// @Size(min=5,max=40,message="Length should be between 5 to 40 characters")
	// @NotNull(message = "This field cannot be null")
	// @NotBlank(message = "This field cannot be blank")
	@Column(length = 20)
	private String name;

	// @Size(min=5,max=100,message="Length should be between 5 to 100 characters")
	// @NotNull(message = "This field cannot be null")
	// @NotBlank(message = "This field cannot be blank")
	@Column(length = 50)
	private String description;

}
