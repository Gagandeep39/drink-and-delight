/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-09-20 01:22:08
 * @modify date 2020-09-20 01:22:08
 * @desc DAO interface for address table
 */
package com.cg.inventoryauthservice.repository;

import com.cg.inventoryauthservice.entity.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
