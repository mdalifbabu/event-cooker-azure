package com.example.eventcooker.masterdata.models.auth;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "user_all_info")
public class UserAllInfo {
    @Id
    @Column(name = "id")
    @SequenceGenerator(
            initialValue = 1,
            name = "user_all_info_seq",
            sequenceName = "user_all_info_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_all_info_seq"
    )
    private Long id;

    @Column(name = "lastLogon")
    private Instant lastLogon;

    @Column(name = "lastLogoff")
    private Instant lastLogoff;

    @Column(name = "passwordLastSet")
    private String passwordLastSet;

    @Column(name = "accountExpires")
    private Instant accountExpires;

    @Column(name = "passwordCanChange")
    private boolean passwordCanChange;

    @Column(name = "passwordMustChange")
    private long passwordMustChange;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "homeDirectory")
    private String homeDirectory;

    @Column(name = "homeDirectoryDrive")
    private String homeDirectoryDrive;

    @Column(name = "scriptPath")
    private String scriptPath;

    @Column(name = "profilePath")
    private String profilePath;

    @Column(name = "adminComment")
    private String adminComment;

    @Column(name = "workStations")
    private String workStations;

    @Column(name = "userComment")
    private String userComment;

    @Column(name = "parameters")
    private String parameters;

    @Column(name = "lmPassword")
    private String lmPassword;

    @Column(name = "ntPassword")
    private String ntPassword;

    @Column(name = "privateData")
    private String privateData;

    @Column(name = "securityDescriptor")
    private String securityDescriptor;

    @Column(unique=true, name = "userId")
    private long userId;

    @Column(name = "primaryGroupId")
    private long primaryGroupId;

    @Column(name = "userAccountControl")
    private long userAccountControl;

    @Column(name = "whichFields")
    private long whichFields;

    @Column(name = "LogonHours")
    private long LogonHours;

    @Column(name = "badPasswordCount")
    private short badPasswordCount;

    @Column(name = "logonCount")
    private short logonCount;

    @Column(name = "countryCode")
    private short countryCode;

    @Column(name = "codePage")
    private short codePage;

    @Column(name = "lmPasswordPresent")
    private boolean lmPasswordPresent;

    @Column(name = "ntPasswordPresent")
    private boolean ntPasswordPresent;

    @Column(name = "passwordExpired")
    private boolean passwordExpired;

    @Column(name = "privateDataSensitive")
    private boolean privateDataSensitive;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userPassword")
    private String userPassword;

    @Column(name = "email")
    private String email;

    @Column(name = "profession")
    private String profession;
}
