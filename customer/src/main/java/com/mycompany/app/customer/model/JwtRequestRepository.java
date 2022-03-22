package com.mycompany.app.customer.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JwtRequestRepository extends JpaRepository<JwtRequest,String> {

    @Query("SELECT s FROM JwtRequest s WHERE s.username = ?1")
    Optional<JwtRequest> findByUsername(String username);

}
