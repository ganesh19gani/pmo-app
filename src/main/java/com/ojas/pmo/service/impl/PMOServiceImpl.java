package com.ojas.pmo.service.impl;

import com.ojas.pmo.model.Client;
import com.ojas.pmo.model.Technology;
import com.ojas.pmo.model.TimeSheet;
import com.ojas.pmo.model.User;
import com.ojas.pmo.repo.ClientRepository;
import com.ojas.pmo.repo.PMORepository;
import com.ojas.pmo.repo.TechnologyRepository;
import com.ojas.pmo.repo.UserRepository;
import com.ojas.pmo.service.PMOService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PMOServiceImpl implements PMOService {

    @Autowired
    private PMORepository repository;

    @Autowired
    private TechnologyRepository technologyRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public TimeSheet submiTimeSheet(TimeSheet timeSheet) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date sDate = null, eDate = null;
//        try {
//            sDate = sdf.parse(timeSheet.getStartDate());
//            eDate = sdf.parse(endDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        TimeSheet timesheet = new TimeSheet();
        timesheet.setEmpName(timeSheet.getEmpName());
        timesheet.setEmpId(timeSheet.getEmpId());
        timesheet.setClientName(timeSheet.getClientName());
        timesheet.setEmail(timeSheet.getEmail());
        timesheet.setPhoneNo(timeSheet.getPhoneNo());
        timesheet.setDomain(timeSheet.getDomain());
        timesheet.setStartDate(timeSheet.getStartDate());
        timesheet.setEndDate(timeSheet.getEndDate());
//        timesheet.setCreateDate(timeSheet.getCreateDate());
//        timesheet.setModifyDate(timeSheet.getModifyDate());
        timesheet.setStatus("P");
        timesheet.setShift(timeSheet.getShift());
      //  timesheet.setTiming(timeSheet.getTiming());
        timesheet.setLocation(timeSheet.getLocation());
//        timesheet.setLatitude(timeSheet.getLatitude());
//        timesheet.setLongitude(timeSheet.getLongitude());
//        timesheet.setIpAddress(timeSheet.getIpAddress());
//        timesheet.setLocDetails(timeSheet.getLocDetails());
//        TimeSheet save = timeSheetService.addTimeSheetDetails(timesheet);
//        Gson gson = new GsonBuilder().create();
//        String jsonString = gson.toJson(timesheet);
        repository.save(timeSheet);
        return timeSheet;
    }

    @Override
    public List<TimeSheet> getAllTimeSheets() {
        return repository.findAll();
    }

    @Override
    public Technology addTechnology(String technologyName) {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        List<Technology> findAll = technologyRepository.findAll();
        boolean found = false;
        for (Technology tech : findAll) {
            if (tech.getName().equals(technologyName)) {
                found = true;
            }
        }
        if (found != true) {
            try {
                Technology tech = new Technology();
                tech.setName(technologyName);
                tech.setCreateDate(date);
                tech.setSoftdelete(1);
                Technology save = technologyRepository.save(tech);

                save.setName(save.getName() + " Successfully Created...");
                return save;

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Technology tech = new Technology();
            tech.setName("Technology already exists...");
            return tech;
        }
        return null;
    }

    @Override
    public List<Technology> getAllTechnologies() {
return technologyRepository.findAll();
//        List<String> technologies = new ArrayList<>();
//       List<Technology> tech = technologyRepository.findAll();
//       tech.stream().map( ele -> technologies.add(ele.getName())).collect(Collectors.toList());
//   return technologies;
    }

    @Override
    public Client addClient(Client client) {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        List<Client> findAll = clientRepository.findAll();
        boolean found = false;
        for (Client tech : findAll) {
            if (tech.getName().equals(client.getName())) {
                found = true;
            }
        }
        if (found != true) {
            try {
                Client tech = new Client();
                tech.setName(client.getName());
                tech.setCreateDate(date);
                tech.setSoftdelete(1);
                Client save = clientRepository.save(tech);

                save.setName(save.getName() + " Successfully Created...");
                return save;

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Client tech = new Client();
            tech.setName("Client already exists...");
            return tech;
        }
        return client;
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public List<Map<String, String>> getAllTimeSheetsWithStatus() {
        return technologyRepository.getAllTimeSheetsWithStatus();
    }

    @Override
    public TimeSheet submiTimeSheet(String empId, String empName, String clientName, String startDate, String endDate, String phoneNo, String domain,String email, String shift, String location, MultipartFile file) throws IOException {
        TimeSheet timeSheet = new TimeSheet();
        timeSheet.setEmpName(empName);
        timeSheet.setEmpId(empId);
        timeSheet.setClientName(clientName);
        timeSheet.setStartDate(startDate);
        timeSheet.setEndDate(endDate);
        timeSheet.setPhoneNo(phoneNo);
        timeSheet.setDomain(domain);
        timeSheet.setEmail(email);
        timeSheet.setStatus("P");
        timeSheet.setShift(shift);
        timeSheet.setLocation(location);
        timeSheet.setFileInfo(file.getBytes());

        TimeSheet timeSheetFromDb =repository.save(timeSheet);
        return timeSheetFromDb;
    }

    @Override
    public List<Map<String, String>> getAllTimeSheetsBasedOnEmpId(String empId) {


        return technologyRepository.getAllTimeSheetsBasedOnEmpId(empId);
    }

    @Override
    public  List<Map<String, String>> getAllPendingTimeSheets(String empId) {
        return repository.getAllPendingTimeSheets(empId);
    }

    @Override
    public List<Map<String, String>> getAllApprovedTimeSheets(String empId) {
        return repository.getAllApprovedTimeSheets(empId);
    }

    @Override
    public Client addClients(String clientName) {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        List<Client> findAll = clientRepository.findAll();
        boolean found = false;
        for (Client tech : findAll) {
            if (tech.getName().equals(clientName)) {
                found = true;
            }
        }
        if (found != true) {
            try {
                Client tech = new Client();
                tech.setName(clientName);
                tech.setCreateDate(date);
                tech.setSoftdelete(1);
                Client save = clientRepository.save(tech);

                save.setName(save.getName() + " Successfully Created...");
                return save;

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Client tech = new Client();
            tech.setName("Client already exists...");
            return tech;
        }
        return null;
    }

    @Override
    public String register(String empId, String empName, String email, String password, String technology, String phoneNumber, String gender) {

        String salt = BCrypt.gensalt();

        String hashedPassword = BCrypt.hashpw(password, salt);
        User user = new User();
      user.setEmpId(empId);
      user.setEmpName(empName);
      user.setEmail(email);
      user.setPassword(hashedPassword);
      user.setTechnology(technology);
      user.setPhoneNo(phoneNumber);
      user.setGender(gender);

       User userFromDb = userRepository.save(user);

        return String.format(" %s Registration Completed Successfully", userFromDb.getEmpName());
    }

    @Override
    public Map<String, Object> login(String empId, String password) {

        HashMap<String, Object> response = null;

        User existingDetails = userRepository.findByEmpId(empId);

        if (existingDetails != null) {

        if (BCrypt.checkpw(password, existingDetails.getPassword())) {
            response = new HashMap<>();
            response.put("status", true);
            response.put("message", "User Availabe");
            existingDetails.setPassword("");
            response.put("result", existingDetails);
            return response;
        }
            response = new HashMap<>();
            response.put("status", false);
            response.put("message", "Incorrect Password");
            response.put("result", null);
            response.put("userRole", null);
            return response;
        }
        response = new HashMap<>();
        response.put("status", false);
        response.put("message", "User Not Found");
        response.put("result", null);
        response.put("userRole", null);
        return response;
    }

    @Override
    public void approveTimesheet(String status) {

    }
}