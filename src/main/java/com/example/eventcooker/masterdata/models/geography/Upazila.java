package com.example.eventcooker.masterdata.models.geography;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "upazila")
public class Upazila {
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", length = 255)
	private String name;
	
	@ManyToOne(
			cascade = CascadeType.MERGE,
			fetch = FetchType.LAZY
	)
	@JoinColumn(
			foreignKey = @ForeignKey(name = "districtId"),
			name = "districtId"
	)
	@JsonIgnore
	@ToString.Exclude
	private District district;
}
