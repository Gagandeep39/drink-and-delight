
/**
 * @author Shubham Sangale
 * @email sssvsangale@gmail.com
 * @create date 2020-09-19 19:07:14
 * @modify date 2020-09-19 19:07:14
 * @desc Warehouse Entity
 */
package com.cg.inventorystockmanagementservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Warehouse {

<<<<<<< Updated upstream
	@Id
	@SequenceGenerator(name = "warehouse_id_sequence", initialValue = 100000, allocationSize = 1)
	@GeneratedValue(generator = "warehouse_id_sequence", strategy = GenerationType.SEQUENCE)
	private Long warehouseId;
	@Column(length = 20)
	private String name;
	@Column(length = 50)
	private String description;

	public Warehouse() {
		super();
	}

	public Warehouse(Long warehouseId, String name, String description) {
		super();
		this.warehouseId = warehouseId;
		this.name = name;
		this.description = description;
	}

	public Warehouse(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Warehouse [warehouseId=" + warehouseId + ", name=" + name + ", description=" + description + "]";
	}
=======
  @Id
  @SequenceGenerator(name = "warehouse_id_sequence", initialValue = 100000, allocationSize = 1)
  @GeneratedValue(generator = "warehouse_id_sequence", strategy = GenerationType.SEQUENCE)
  private Long warehouseId;
  @Column(length = 20)
  private String name;
  @Column(length = 50)
  private String description;
public Long getWarehouseId() {
	return warehouseId;
}
public void setWarehouseId(Long warehouseId) {
	this.warehouseId = warehouseId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Warehouse(Long warehouseId, String name, String description) {
	super();
	this.warehouseId = warehouseId;
	this.name = name;
	this.description = description;
}
public Warehouse() {
	super();
}
  
  
  
>>>>>>> Stashed changes

}