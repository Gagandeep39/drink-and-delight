package com.cg.inventorysupplierservice.dao;

import org.springframework.stereotype.Repository;

import com.cg.inventorysupplierservice.entity.Distributor;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface DistributorDao extends JpaRepository <Distributor, Integer>{

}
