package com.ojas.pmo.repo;

import com.ojas.pmo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
