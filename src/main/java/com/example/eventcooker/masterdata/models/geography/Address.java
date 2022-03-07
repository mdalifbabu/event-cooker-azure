package com.example.eventcooker.masterdata.models.geography;

import javax.persistence.*;

import lombok.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "address")
public class Address {
	
	@Id
	@Column(name = "id")
	@SequenceGenerator(
			initialValue = 1,
			name = "address_seq",
			sequenceName = "address_sequence"
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "address_seq"
	)
	private Long id;
	
	@Column(name = "street", length = 255)
	private String street;
	
	@Column(name = "postOffice", length = 255)
	private String postOffice;
	
	@Column(name = "postalCode", length = 50)
	private String postalCode;

    @Column(name = "division")
	private Long division;

    @Column(name = "district")
	private Long district;

    @Column(name = "upazila")
	private Long upazila;
}
