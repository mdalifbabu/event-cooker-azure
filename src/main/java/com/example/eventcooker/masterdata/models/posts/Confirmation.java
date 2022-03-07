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
@Table(name = "confirmation")
public class Confirmation {
    @Id
    @Column(name = "id")
    @SequenceGenerator(
            initialValue = 1,
            name = "confirmation_seq",
            sequenceName = "confirmation_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "confirmation_seq"
    )
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "profId")
    private Long profId;

    @Column(name = "postId")
    private Long postId;

    @Column(name = "proposal")
    private String proposal;

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
