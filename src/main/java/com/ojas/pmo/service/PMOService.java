package com.ojas.pmo.service;

import com.ojas.pmo.model.Client;
import com.ojas.pmo.model.Technology;
import com.ojas.pmo.model.TimeSheet;
import com.ojas.pmo.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface PMOService {
    TimeSheet submiTimeSheet(TimeSheet timeSheet);

    List<TimeSheet> getAllTimeSheets();

    Technology addTechnology(String technologyName);

    List<Technology> getAllTechnologies();

    Client addClient(Client client);

    List<Client> getAllClients();

    List<Map<String, String>> getAllTimeSheetsWithStatus();

    TimeSheet submiTimeSheet(String empId, String empName, String clientName, String startDate, String endDate, String phoneNo, String domain, String email, String shift, String location, MultipartFile file) throws IOException;

    List<Map<String, String>> getAllTimeSheetsBasedOnEmpId(String empId);

    List<Map<String, String>> getAllPendingTimeSheets(String empId);

    List<Map<String, String>> getAllApprovedTimeSheets(String empId);

    Client addClients(String clientName);

    String register(String empId, String empName, String email, String password, String technology, String phoneNumber, String gender);

    Map<String, Object>  login(String empId, String password);

    void approveTimesheet(String status);
}
