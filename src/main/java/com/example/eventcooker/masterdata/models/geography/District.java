package com.example.eventcooker.masterdata.models.geography;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import java.util.List;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "district")
public class District {

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
			foreignKey = @ForeignKey(name = "divisionId"),
			name = "divisionId"
	)
	@JsonIgnore
	@ToString.Exclude
	private Division division;
	
	@OneToMany(
			mappedBy = "district",
			cascade = CascadeType.MERGE,
			fetch = FetchType.LAZY
	)
	@ToString.Exclude
	private List<Upazila> upazilas;
}
