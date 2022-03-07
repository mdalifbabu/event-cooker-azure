package com.example.eventcooker.masterdata.models.equipments;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "item")
public class Item {
    @Id
    @Column(name = "id")
    @SequenceGenerator(
            initialValue = 1,
            name = "item_seq",
            sequenceName = "item_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_seq"
    )
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "photo")
    private String photo;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private int rating;

    @Column(name = "user")
    private Long user;

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
