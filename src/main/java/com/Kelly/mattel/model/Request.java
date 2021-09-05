package com.Kelly.mattel.model;

import com.Kelly.mattel.service.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity //something for JPA to save to the Database
@Data //generated all of the getters and setters
@NoArgsConstructor
@AllArgsConstructor //creates an All Arg constructir
public class Request {

    @Id //Primary Key
    @GeneratedValue //AutoIncrement ID
    private Long id;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String email;
    private String address;
    private String businessJustification;
    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;
    //@Temporal(TemporalType.TIMESTAMP) for specfying date types.
    private Instant createdAt;


    //private Date createdAt;
    //make an enum for status Approved or Not
}
