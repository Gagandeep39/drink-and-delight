/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-02 00:54:54
 * @modify date 2020-11-02 00:54:54
 * @desc Distributors JPA repo
 */
package com.cg.inventorysupplierservice.repository;

import com.cg.inventorysupplierservice.entity.Distributor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DistributorRepository extends JpaRepository<Distributor, Long> {

}
