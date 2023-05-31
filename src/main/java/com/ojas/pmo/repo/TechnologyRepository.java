package com.ojas.pmo.repo;

import com.ojas.pmo.model.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface TechnologyRepository extends JpaRepository<Technology,Integer> {

    @Query(value = "Select emp_Id as empId, emp_Name as empName, client_Name as clientName, status from timesheet", nativeQuery = true)
    List<Map<String, String>> getAllTimeSheetsWithStatus();

    @Query(value = "Select emp_Id as empId, emp_Name as empName, client_Name as clientName, status from timesheet where emp_Id=?1", nativeQuery = true)
    List<Map<String, String>> getAllTimeSheetsBasedOnEmpId(String empId);
}
