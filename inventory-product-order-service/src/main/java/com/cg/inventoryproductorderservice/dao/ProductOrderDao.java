package com.cg.inventoryproductorderservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.inventoryproductorderservice.entity.ProductOrder;

@Repository
public interface ProductOrderDao extends JpaRepository<ProductOrder, Long> {

}
