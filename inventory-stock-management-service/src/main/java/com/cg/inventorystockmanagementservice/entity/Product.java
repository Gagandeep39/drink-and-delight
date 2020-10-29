package com.cg.inventorystockmanagementservice.entity;

/**
 * @author Shubham Sangale
 * @email sssvsangale@gmail.com
 * @create date 2020-09-19 19:20:33
 * @modify date 2020-09-19 19:20:33
 * @desc Product properties
 */

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
public class Product {

	@Id
	@SequenceGenerator(name = "product_id_sequence", initialValue = 100000, allocationSize = 1)
	@GeneratedValue(generator = "product_id_sequence", strategy = GenerationType.SEQUENCE)
	private Long productId;
	@Column(length = 20)
	private String materialName;
	@Column(length = 100)
	private String description;
	private Double quantityAvailable;
	@Enumerated(EnumType.STRING)
	private MeasurementUnit quantityUnit;
	@ManyToOne
	@JoinColumn(name = "warehouseId", referencedColumnName = "warehouseId", foreignKey = @ForeignKey(name = "FK_prod_warehouse_ID"))
	private Warehouse warehouse;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public void setQuantityAvailable(Double quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public Product(String materialName, String description, Double quantityAvailable, MeasurementUnit quantityUnit,
			Warehouse warehouse) {
		super();
		this.materialName = materialName;
		this.description = description;
		this.quantityAvailable = quantityAvailable;
		this.quantityUnit = quantityUnit;
		this.warehouse = warehouse;
	}

	public Product(Long productId, String materialName, String description, Double quantityAvailable,
			MeasurementUnit quantityUnit, Warehouse warehouse) {
		super();
		this.productId = productId;
		this.materialName = materialName;
		this.description = description;
		this.quantityAvailable = quantityAvailable;
		this.quantityUnit = quantityUnit;
		this.warehouse = warehouse;
	}

	public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", materialName=" + materialName + ", description=" + description
				+ ", quantityAvailable=" + quantityAvailable + ", quantityUnit=" + quantityUnit + ", warehouse="
				+ warehouse + "]";
	}

	public MeasurementUnit getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(MeasurementUnit quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
}
