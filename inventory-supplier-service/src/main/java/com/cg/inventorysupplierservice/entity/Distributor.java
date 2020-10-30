/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-28 09:01:04
 * @modify date 2020-10-28 09:01:04
 * @desc Created distribtor
 */
package com.cg.inventorysupplierservice.entity;

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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cg.inventorysupplierservice.enums.MeasurementUnit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Distributor {

	@Id
	// @NotNull(message = "Id cannot be null value")
	// @NotBlank(message = "Id cannot be blank value")
	@SequenceGenerator(name = "distributor_id_sequence", initialValue = 100000, allocationSize = 1)
	@GeneratedValue(generator = "distributor_id_sequence", strategy = GenerationType.SEQUENCE)
	private Long distributorId;

	// @Size(min=5,max=40,message="Length should be between 5 to 40 characters")
	// @NotNull(message="Material name should not be null")
	// @NotBlank(message="Material name should not be blank")
	@Column(length = 20)
	private String materialName;

	// @Size(min=5,max=100,message="Length should be between 5 to 100 characters")
	// @NotNull
	// @NotBlank
	@Column(length = 100)
	private String description;

}
