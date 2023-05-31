package com.ojas.pmo.repo;

import com.ojas.pmo.model.Client;
import com.ojas.pmo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmpId(String empId);
}
