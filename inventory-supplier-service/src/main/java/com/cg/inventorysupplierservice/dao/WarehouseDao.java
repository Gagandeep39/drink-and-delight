package com.cg.inventorysupplierservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.inventorysupplierservice.entity.Warehouse;

@Repository
public interface WarehouseDao extends JpaRepository<Warehouse, Integer> {

}
