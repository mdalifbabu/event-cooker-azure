package com.example.eventcooker.masterdata.models.posts;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "post")
public class Post {
    @Id
    @Column(name = "id")
    @SequenceGenerator(
            initialValue = 1,
            name = "post_seq",
            sequenceName = "post_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_seq"
    )
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "photo")
    private String photo;

    @Column(name = "description")
    private String description;

    @Column(name = "user")
    private Long user;

    @Column(name = "employee")
    private Long employee;

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
