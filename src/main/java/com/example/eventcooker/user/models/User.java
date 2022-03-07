package com.example.eventcooker.user.models;

import com.example.eventcooker.masterdata.models.geography.Address;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.time.Instant;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @SequenceGenerator(
            initialValue = 1,
            name = "user_seq",
            sequenceName = "user_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_seq"
    )
    private Long id;

    @Column(name = "profession")
    private String profession;

    @Column(name = "fullName", length = 255)
    private String fullName;

    @Column(name = "currentStatus", length = 255)
    private String currentStatus;

    @Column(name = "cellphone", length = 11)
    private String cellphone;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "nid", length = 30)
    private String nid;

    @Column(name = "birthRegNo", length = 30)
    private String birthRegNo;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    //Will be auto assigned, calculating from date of birth
    @Column(name = "age")
    private int age;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "nationality", length = 20)
    private String nationality;

    @Column(name = "bloodGroup", length = 10)
    private String bloodGroup;

    @Column(name = "martialStatus", length = 30)
    private String maritialStatus;

    @JoinColumn(name = "address")
    private Long address;

    @Column(name = "workPhone", length = 11)
    private String workPhone;

    @Column(name = "photo")
    private String photo;

    @Column(name = "about")
    private String about;

    @Column(name = "rating")
    private int rating;

    @Column(name = "description")
    private String description;

    @Column(name = "website")
    private String website;

    @Column(name = "approval")
    private boolean approval;

    //Will be auto generated
    @Column(name = "createdOn")
    private Instant createdOn;

    @Column(name = "createdBy", length = 255)
    private String createdBy;

    //Will be auto generated
    @Column(name = "modifiedOn")
    private Instant modifiedOn;

    @Column(name = "modifiedBy", length = 255)
    private String modifiedBy;
}
