/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-09-20 01:22:36
 * @modify date 2020-09-20 01:22:36
 * @desc DAO interface for user details table
 */
package com.cg.inventoryauthservice.repository;

import java.util.Optional;

import com.cg.inventoryauthservice.entity.UserDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

  Optional<UserDetails> findByUserUsername(String username);
}
