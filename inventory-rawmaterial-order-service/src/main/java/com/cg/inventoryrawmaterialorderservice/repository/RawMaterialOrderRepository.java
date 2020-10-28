package com.cg.inventoryrawmaterialorderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.inventoryrawmaterialorderservice.entity.RawMaterialOrder;

@Repository
public interface RawMaterialOrderRepository extends JpaRepository<RawMaterialOrder, Integer>{

	//fetch raw material by id
	List<RawMaterialOrder> fetchRawMaterialById(int rawMaterialId);
}
