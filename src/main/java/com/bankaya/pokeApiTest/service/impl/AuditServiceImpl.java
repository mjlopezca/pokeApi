package com.bankaya.pokeApiTest.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankaya.pokeApiTest.model.Audit;
import com.bankaya.pokeApiTest.service.AuditService;
import com.bankaya.pokeApiTest.repository.AuditRepository;
/**
 * register audit interaction
 * 
 *
 */
@Service
public class AuditServiceImpl implements AuditService{
     @Autowired
     private AuditRepository AuditRepository;
     @Override
     public Boolean saveAudit(Audit Audit) {
          try {
               AuditRepository.save(Audit);
               return true;
          } catch (Exception e) {
               return false;
          }
     }
}