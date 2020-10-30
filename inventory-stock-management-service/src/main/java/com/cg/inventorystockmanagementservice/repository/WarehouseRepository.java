/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-31 01:15:38
 * @modify date 2020-10-31 01:15:38
 * @desc Warehouse repo
 */
package com.cg.inventorystockmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.inventorystockmanagementservice.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long>{
	
}
