package com.cg.inventorystockmanagementservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.inventorystockmanagementservice.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	

}
