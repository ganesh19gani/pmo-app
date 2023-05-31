package com.ojas.pmo.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "timesheet")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class TimeSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;

    @Column(name = "EMP_NAME")
    private String empName;

    @Column(name = "EMP_ID")
    private String empId;

    @Column(name = "CLIENT_NAME")
    private String clientName;

    @Column(name = "START_DATE")
    private String startDate;

    @Column(name = "END_DATE")
    private String endDate;

//    @Column(name = "CREATE_DATE")
//    private Date createDate;
//
//    @Column(name = "MODIFY_DATE")
//    private Date modifyDate;

    @Column(name = "PHONE_NO")
    private String phoneNo;

    @Column(name = "DOMAIN")
    private String domain;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "SHIFT")
    private String shift;

//    @Column(name = "TIMING")
//    private String timing;
//
//    @Column(name = "FEEDBACK")
//    private String feedback;


    @Column(name = "LOCATION")
    private String location;

    @Lob
    @Column(name = "File_Info")
    private byte[] fileInfo;


}
