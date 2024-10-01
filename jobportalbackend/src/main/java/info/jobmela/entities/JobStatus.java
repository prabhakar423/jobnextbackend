package info.jobmela.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "job_status")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JobStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String jobStatusId;
	private String jobStatusName;
	private String jobStatusDesc;
//	@OneToOne(mappedBy = "jobStatus")
//	private JobAdvertisements jobAdvertisements;
}
