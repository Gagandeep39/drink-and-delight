package com.cg.inventorystockmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.inventorystockmanagementservice.entity.RawMaterial;

@Repository
public interface RawMaterialRepository extends JpaRepository<RawMaterial, Long> {

}
