package info.jobmela.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "job_advertisements")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JobAdvertisements {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String jobAdvtId;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "jobAdvertisements")
	@JsonIgnore
	private List<JobPost> jobPosts;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "job_org_id")
	private JobOrganizations jobOrganizations;
	private String jobAdvtNo;
	private String jobAdvtHeading;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private String jobAdvtLastDate;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private String jobAdvtStartDate;
	private Long jobAdvtApplicationFee;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private String jobAdvtImpDates;
	private String jobAdvtAgeLimit;
	private String jobAdvtQualification;
	private String jobAdvtVacancyDetails;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private JobImportantLinks jobImportantLinks;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private JobFeeDetails jobFeeDetails;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "job_status_id")
	private JobStatus jobStatus;
}
