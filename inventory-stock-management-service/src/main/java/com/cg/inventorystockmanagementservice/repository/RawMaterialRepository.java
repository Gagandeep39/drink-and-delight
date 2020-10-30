/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-31 01:15:19
 * @modify date 2020-10-31 01:15:19
 * @desc Raw Materials Repo
 */
package com.cg.inventorystockmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.inventorystockmanagementservice.entity.RawMaterial;

public interface RawMaterialRepository extends JpaRepository<RawMaterial, Long> {

}
