package com.ojas.pmo.repo;

import com.ojas.pmo.model.TimeSheet;
import org.hibernate.context.TenantIdentifierMismatchException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface PMORepository extends JpaRepository<TimeSheet,Integer> {

    @Query(value = "Select emp_Id as empId, emp_Name as empName, client_Name as clientName, status from timesheet where status='P' and emp_Id =?1", nativeQuery = true)
    List<Map<String, String>> getAllPendingTimeSheets(String empId);

    @Query(value = "Select emp_Id as empId, emp_Name as empName, client_Name as clientName, status from timesheet where status !='P' and emp_Id=?1", nativeQuery = true)
    List<Map<String, String>> getAllApprovedTimeSheets(String empId);
}
