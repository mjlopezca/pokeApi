package com.bankaya.pokeApiTest.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankaya.pokeApiTest.model.Audit;




@Repository
public interface AuditRepository extends JpaRepository<Audit, String>{
     
 }