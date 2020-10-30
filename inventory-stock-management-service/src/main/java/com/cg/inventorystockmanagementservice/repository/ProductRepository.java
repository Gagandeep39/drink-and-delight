/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-31 01:14:56
 * @modify date 2020-10-31 01:14:56
 * @desc Product Repository
 */
package com.cg.inventorystockmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.inventorystockmanagementservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
