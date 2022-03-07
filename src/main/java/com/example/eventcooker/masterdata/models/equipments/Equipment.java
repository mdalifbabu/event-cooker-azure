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
@Table(name = "equipment")
public class Equipment {
    @Id
    @Column(name = "id")
    @SequenceGenerator(
            initialValue = 1,
            name = "equipment_seq",
            sequenceName = "equipment_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "equipment_seq"
    )
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private String model;

    @Column(name = "sensor")
    private String sensor;

    @Column(name = "wireless")
    private String wireless;

    @Column(name = "weight")
    private double weight;

    @Column(name = "photo")
    private String photo;

    @Column(name = "description")
    private String description;

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
