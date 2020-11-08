package com.cg.inventorystockmanagementservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.inventorystockmanagementservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	

}
