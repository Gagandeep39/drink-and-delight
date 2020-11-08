/**
 * @author Shubham Sangale
 * @email sssvsangale@gmail.com
 * @create date 2020-09-19 19:31:49
 * @modify date 2020-09-19 19:31:49
 * @desc Raw Material
 */
package com.cg.inventorystockmanagementservice.entity;

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

import com.cg.inventorystockmanagementservice.enums.MeasurementUnit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class RawMaterial {
	@Id
	@SequenceGenerator(name = "rawmaterial_id_sequence", initialValue = 100000, allocationSize = 1)
	@GeneratedValue(generator = "rawmaterial_id_sequence", strategy = GenerationType.SEQUENCE)
	private Long rawMaterialId;
	@Column(length = 20)
	private String materialName;
	@Column(length = 100)
	private String description;
	private Double quantityAvailable;
<<<<<<< Updated upstream

	public RawMaterial(String materialName, String description, Double quantityAvailable, MeasurementUnit quantityUnit,
			Warehouse warehouse) {
		super();
		this.materialName = materialName;
		this.description = description;
		this.quantityAvailable = quantityAvailable;
		this.quantityUnit = quantityUnit;
		this.warehouse = warehouse;
	}

	public RawMaterial(Long rawMaterialId, String materialName, String description, Double quantityAvailable,
			MeasurementUnit quantityUnit, Warehouse warehouse) {
		super();
		this.rawMaterialId = rawMaterialId;
		this.materialName = materialName;
		this.description = description;
		this.quantityAvailable = quantityAvailable;
		this.quantityUnit = quantityUnit;
		this.warehouse = warehouse;
	}

=======
>>>>>>> Stashed changes
	@Enumerated(EnumType.STRING)
	private MeasurementUnit quantityUnit;
	@ManyToOne
	@JoinColumn(name = "warehouseId", referencedColumnName = "warehouseId", foreignKey = @ForeignKey(name = "FK_raw_matr_warehouse_ID"))
	private Warehouse warehouse;

	public Long getRawMaterialId() {
		return rawMaterialId;
	}

	public void setRawMaterialId(Long rawMaterialId) {
		this.rawMaterialId = rawMaterialId;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getQuantityAvailable() {
		return quantityAvailable;
	}

<<<<<<< Updated upstream
	@Override
	public String toString() {
		return "RawMaterial [rawMaterialId=" + rawMaterialId + ", materialName=" + materialName + ", description="
				+ description + ", quantityAvailable=" + quantityAvailable + ", quantityUnit=" + quantityUnit
				+ ", warehouse=" + warehouse + "]";
	}

=======
>>>>>>> Stashed changes
	public void setQuantityAvailable(Double quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public MeasurementUnit getQuantityUnit() {
		return quantityUnit;
	}

<<<<<<< Updated upstream
	public RawMaterial() {
		super();
	}

=======
>>>>>>> Stashed changes
	public void setQuantityUnit(MeasurementUnit quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
<<<<<<< Updated upstream
}
=======

}
>>>>>>> Stashed changes
