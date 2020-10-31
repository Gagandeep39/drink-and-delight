/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-30 17:53:13
 * @modify date 2020-10-30 17:53:13
 * @desc RM order repository
 */
package com.cg.inventoryrawmaterialorderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.inventoryrawmaterialorderservice.entity.RawMaterialOrder;

@Repository
public interface RawMaterialOrderRepository extends JpaRepository<RawMaterialOrder, Long> {

}
