package com.cg.inventorystockmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.inventorystockmanagementservice.entity.RawMaterial;

public interface RawMaterialRepository extends JpaRepository<RawMaterial, Integer> {

}
