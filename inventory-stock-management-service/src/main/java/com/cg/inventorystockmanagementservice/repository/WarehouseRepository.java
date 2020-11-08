package com.cg.inventorystockmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.inventorystockmanagementservice.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer>{
	

}
