package com.ojas.pmo.controller;


import com.ojas.pmo.model.Client;
import com.ojas.pmo.model.Technology;
import com.ojas.pmo.model.TimeSheet;
import com.ojas.pmo.model.User;
import com.ojas.pmo.service.PMOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pmo")
public class PMOController {

    @Autowired
    private PMOService pmoService;

    @PostMapping("/addTimesheet")
    public TimeSheet submiTimeSheet(@RequestParam("empId") String empId,
                                    @RequestParam("empName") String empName,
                                    @RequestParam("clientName") String clientName,
                                    @RequestParam("startDate") String startDate,
                                    @RequestParam("endDate") String endDate,
                                    @RequestParam("phoneNo") String phoneNo,
                                    @RequestParam("domain") String domain,
                                    @RequestParam("email") String email,
                                    @RequestParam("shift") String shift,
                                    @RequestParam("location") String location,
                                    @RequestParam("file") MultipartFile file

    ) throws IOException {


        return pmoService.submiTimeSheet(empId, empName, clientName, startDate, endDate, phoneNo, domain, email, shift, location,file);
    }

    @PostMapping("/getAllTimeSheetsBasedOnEmpId")
    public List<Map<String, String>> getAllTimeSheetsBasedOnEmpId(
            @RequestParam("empId") String empId
    ) {
        return pmoService.getAllTimeSheetsBasedOnEmpId(empId);
    }

    @GetMapping("/getAllTimeSheets")
    public List<TimeSheet> getAllTimeSheets() {
        return pmoService.getAllTimeSheets();
    }

    @PostMapping("/addTechnology")
    public Technology addTechnology(@RequestParam("technologyName") String technologyName) {
        return pmoService.addTechnology(technologyName);
    }

    @GetMapping("/getAllTechnologies")
    public List<Technology> getAllTechnologies() {
        return pmoService.getAllTechnologies();
    }

    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client client) {
        return pmoService.addClient(client);
    }

    @GetMapping("/getAllClients")
    public List<Client> getAllClients() {
        return pmoService.getAllClients();
    }


    @PostMapping("/getAllPendingTimeSheets")
    public List<Map<String, String>> getAllPendingTimeSheets(@RequestParam("empId") String empId) {
        return pmoService.getAllPendingTimeSheets(empId);
    }

    @PostMapping("/getAllApprovedTimeSheets")
    public List<Map<String, String>> getAllApprovedTimeSheets(@RequestParam("empId") String empId

    ) {
        return pmoService.getAllApprovedTimeSheets(empId);
    }

    @PostMapping("/addClients")
    public Client addClients(@RequestParam("clientName") String clientName) {
        return pmoService.addClients(clientName);
    }


    @PostMapping("/register")
    public String register(@RequestParam("empId") String empId,
                           @RequestParam("empName") String empName,
                           @RequestParam("email") String email,
                           @RequestParam("password") String password,
                           @RequestParam("technology") String technology,
                           @RequestParam("phoneNumber") String phoneNumber,
                           @RequestParam("gender") String gender
    ) {
        return pmoService.register(empId, empName, email, password, technology, phoneNumber, gender);
    }


    @PostMapping("/login")
    public Map<String, Object>  login(@RequestParam("empId") String empId,
                      @RequestParam("password") String password
    ) {
        return pmoService.login(empId, password);
    }


    @PostMapping("/approveTimesheet")
    public void approveTimesheet(@RequestParam("status") String status) {
        pmoService.approveTimesheet(status);
    }

}
