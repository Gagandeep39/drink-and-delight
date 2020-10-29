package com.cg.inventorysupplierservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.inventorysupplierservice.entity.Supplier;

@Repository
public interface SupplierDao extends JpaRepository<Supplier, Integer>{

}
