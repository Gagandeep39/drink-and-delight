/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-09-20 01:22:48
 * @modify date 2020-09-20 01:22:48
 * @desc DAO interface for user table
 */
package com.cg.inventoryauthservice.repository;

import java.util.Optional;

import com.cg.inventoryauthservice.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByUsername(String username);
  boolean existsByUsername(String username);
}
