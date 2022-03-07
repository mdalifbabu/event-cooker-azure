package com.example.eventcooker.masterdata.models.geography;

import lombok.*;

import java.util.List;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "division")
public class Division {

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "name", length = 255)
	private String name;

	@OneToMany(
			mappedBy = "division",
			fetch = FetchType.LAZY,
			cascade = CascadeType.MERGE
	)
	@ToString.Exclude
	private List<District> districts;
}
